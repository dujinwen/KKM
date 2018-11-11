package com.kekemei.kekemei.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.EvaluateListAdapter;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.ProjectDetailBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.adapter.DayCheckAdapter2;
import com.kekemei.kekemei.adapter.YuYueDataListAdapter;
import com.kekemei.kekemei.bean.CanlBean;
import com.kekemei.kekemei.bean.YuYueDataBean;
import com.kekemei.kekemei.utils.CustomDatePicker;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.UserHelp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目详情页面
 */
public class ProjectDetailActivity extends BaseActivity implements View.OnClickListener {
    private static final String EXTRA_KEY_BEAUTICIAN_ID = "beauticianId";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_share)
    ImageView iv_share;

    @BindView(R.id.scrollLayout)
    ScrollView scrollLayout;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    @BindView(R.id.shop_detail_icon)
    ImageView shop_detail_icon;

    @BindView(R.id.shopName)
    TextView shopName;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.marketPrice)
    TextView marketPrice;
    @BindView(R.id.tvCollection)
    TextView tvCollection;
    @BindView(R.id.tvFollowNum)
    TextView tvFollowNum;

    @BindView(R.id.projectDetail)
    RelativeLayout projectDetail;
    @BindView(R.id.indicatorProjectDetail)
    ImageView indicatorProjectDetail;

    @BindView(R.id.userEvaluate)
    RelativeLayout userEvaluate;
    @BindView(R.id.indicatorEvaluate)
    ImageView indicatorEvaluate;

    @BindView(R.id.contentView)
    LinearLayout contentView;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_buy_now)
    TextView tvBuyNow;

    @BindView(R.id.ll_dianpu_tab)
    LinearLayout llDianpuTab;
    @BindView(R.id.id_recyclerview_horizontal)
    RecyclerView id_recyclerview_horizontal;
    @BindView(R.id.show_select_time)
    LinearLayout showSelectTime;
    @BindView(R.id.ll_select_time)
    LinearLayout llSelectTime;
    @BindView(R.id.rv_list_yuyue)
    RecyclerView rvListYuyue;
    @BindView(R.id.layoutBottomBar)
    LinearLayout layoutBottomBar;

    private WebView webContainer;

    private ProjectDetailBean.DataBean.CommentBean commentData;
    private View commentSectionView;
    private TextView userCommentNum;
    private TextView commentTabAll;
    private TextView commentTabNew;
    private TextView commentTabPhoto;
    private TextView tvCommentPeer;
    private LinearLayout markLayout;
    private FlexboxLayout commentTagFlowLayout;
    private RecyclerView rvCommentList;

    private RecyclerView hotProjectRv;
    private String beauticianId;
    private MyGridAdapter contentSectionAdapter;
    private EvaluateListAdapter commentAdapter;

    private String encoding = "UTF-8";
    private String mimeType = "text/html";
    private ProjectDetailBean detailBean;

    @Nullable
    private LinearLayout ll_yuyue;
    private Calendar cal;
    private DayCheckAdapter2 dayAdapter;
    private YuYueDataListAdapter yuYueDataListAdapter;
    private TextView tv_date_and_week;
    private TextView tv_can_yuyue;

    public static void start(Context context, int beauticianId) {
        Intent intent = new Intent(context, ProjectDetailActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, String.valueOf(beauticianId));
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_project_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        beauticianId = super.getStringExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title.setText("项目详情");
        iv_share.setVisibility(View.VISIBLE);

        indicatorProjectDetail.setVisibility(View.VISIBLE);

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

        multipleStatusView.showOutContentView(scrollLayout);

        View contentHead = View.inflate(this, R.layout.layout_detail_content_head, null);
        initContentHead(contentHead);

        View webLayout = View.inflate(this, R.layout.layout_detail_content_web, null);
        webContainer = webLayout.findViewById(R.id.webContainer);

        commentSectionView = View.inflate(this, R.layout.layout_comment_top_head, null);
        initCommentView(commentSectionView);

        View contentSectionView = View.inflate(this, R.layout.layout_shop_content_section_view, null);
        initContentSectionView(contentSectionView);

        contentView.addView(contentHead);
        contentView.addView(webLayout);
        contentView.addView(commentSectionView);
        contentView.addView(contentSectionView);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void displayForWebView(String html, String baseUrl) {
        webContainer.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webContainer.getSettings().setDefaultFontSize(13);
        webContainer.getSettings().setJavaScriptEnabled(true);
        webContainer.getSettings().setBuiltInZoomControls(true);
        webContainer.getSettings().setDisplayZoomControls(false);
        webContainer.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        if (StringUtils.isEmpty(baseUrl)) {
            baseUrl = "about:blank";
        }
        webContainer.loadDataWithBaseURL(baseUrl, html, mimeType, encoding, "about:blank");
        webContainer.scrollTo(0, 0);
    }

    private void initCommentView(View view) {
        userCommentNum = view.findViewById(R.id.userCommentNum);
        commentTabAll = view.findViewById(R.id.commentTabAll);
        commentTabNew = view.findViewById(R.id.commentTabNew);
        commentTabPhoto = view.findViewById(R.id.commentTabPhoto);
        tvCommentPeer = view.findViewById(R.id.tvCommentPeer);
        markLayout = view.findViewById(R.id.markLayout);
        markLayout.setVisibility(View.VISIBLE);
        commentTagFlowLayout = view.findViewById(R.id.commentTagFlowLayout);
        rvCommentList = view.findViewById(R.id.rvCommentList);
        commentTabAll.setSelected(true);
        commentTabAll.setOnClickListener(this);
        commentTabNew.setOnClickListener(this);
        commentTabPhoto.setOnClickListener(this);
        commentAdapter = new EvaluateListAdapter(this, false);
        rvCommentList.setLayoutManager(new LinearLayoutManager(this));
        rvCommentList.setHasFixedSize(true);
        rvCommentList.setNestedScrollingEnabled(false);
        commentAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        rvCommentList.setAdapter(commentAdapter);
        TextView lookMore = view.findViewById(R.id.lookMore);
        lookMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEvaluateActivity.start(ProjectDetailActivity.this, false);
            }
        });
    }

    private void initContentSectionView(View view) {
        hotProjectRv = view.findViewById(R.id.sectionRv);
        hotProjectRv.setLayoutManager(new GridLayoutManager(this, 2));
        hotProjectRv.setHasFixedSize(true);
        hotProjectRv.setNestedScrollingEnabled(false);
        contentSectionAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        hotProjectRv.setAdapter(contentSectionAdapter);
        TextView lookMore = view.findViewById(R.id.lookMore);
        lookMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProjectDetailActivity.this, ClassifyActivity.class));
            }
        });
    }

    private TextView tradingArea;
    private TextView serviceOne;
    private TextView serviceTwo;
    private TextView serviceThree;
    private TextView tvAddress;
    private TextView tvDistance;

    private void initContentHead(View contentHead) {
        tradingArea = contentHead.findViewById(R.id.tradingArea);
        serviceOne = contentHead.findViewById(R.id.serviceOne);
        serviceTwo = contentHead.findViewById(R.id.serviceTwo);
        serviceThree = contentHead.findViewById(R.id.serviceThree);
        tvAddress = contentHead.findViewById(R.id.tvAddress);
        tvDistance = contentHead.findViewById(R.id.tvDistance);
        ll_yuyue = contentHead.findViewById(R.id.ll_yuyue);
        ll_yuyue.setOnClickListener(this);

        rvListYuyue.setLayoutManager(new GridLayoutManager(getBaseContext(), 4));
        yuYueDataListAdapter = new YuYueDataListAdapter(this);
        rvListYuyue.setAdapter(yuYueDataListAdapter);
        yuYueDataListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.ll_select_data_time) {
                    tv_date_and_week = (TextView) adapter.getViewByPosition(rvListYuyue, position, R.id.tv_date_and_week);
                    tv_can_yuyue = (TextView) adapter.getViewByPosition(rvListYuyue, position, R.id.tv_can_yuyue);
                    if (!view.isSelected()) {
                        view.setSelected(true);
                        view.setBackground(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.btn_7ad2d2_background));
                        tv_date_and_week.setTextColor(0XFFFFFFFF);
                        tv_can_yuyue.setTextColor(0XFFFFFFFF);
                    } else {
                        view.setSelected(false);
                        view.setBackground(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.btn_white_background));
                        tv_date_and_week.setTextColor(0XFF999999);
                        tv_can_yuyue.setTextColor(0XFF999999);
                    }
                }
            }
        });
    }

    @OnClick({R.id.projectDetail, R.id.userEvaluate, R.id.tv_buy_now})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.projectDetail:
                indicatorProjectDetail.setVisibility(View.VISIBLE);
                indicatorEvaluate.setVisibility(View.GONE);
                scrollTo(contentView.getChildAt(0));
                break;
            case R.id.userEvaluate:
                indicatorProjectDetail.setVisibility(View.GONE);
                indicatorEvaluate.setVisibility(View.VISIBLE);
                scrollTo(contentView.getChildAt(2));
                break;
            case R.id.commentTabAll:
                commentTabAll.setSelected(true);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(false);
                if (commentData != null) {
                    commentAdapter.replaceData(commentData.getAll());
                }
                break;
            case R.id.commentTabNew:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(true);
                commentTabPhoto.setSelected(false);
                if (commentData != null) {
                    commentAdapter.replaceData(commentData.getNewX());
                }
                break;
            case R.id.commentTabPhoto:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(true);
                if (commentData != null) {
                    commentAdapter.replaceData(commentData.getHaveimg());
                }
                break;

            case R.id.tv_buy_now:
                OkGo.<String>get(URLs.ORDER_GENERATING)
                        .params("user_id", UserHelp.getUserId(this))
                        .params("name", detailBean.getData().getName())
                        .params("project_id", detailBean.getData().getProject_category_id())
                        .params("count", 1)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {

                            }
                        });
                break;
            case R.id.ll_yuyue:
                //                llSelectTime.setVisibility(llSelectTime.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                llSelectTime.setVisibility(View.VISIBLE);
                llDianpuTab.setVisibility(View.GONE);
                layoutBottomBar.setVisibility(View.GONE);
                break;
        }
    }

    private void scrollTo(final View view) {
        if (view == null) {
            return;
        }
        scrollLayout.post(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
                //mRootScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                int top = view.getTop();
                if (top < 0) {
                    top = 0;
                }
                scrollLayout.smoothScrollTo(0, top);
            }
        });
    }

    /**
     * 预约时间
     */
    public void timeData(long timedstartdate) {
        OkGo.<String>post(URLs.APPOINTMENT_TIME_DATA).params("beautician", beauticianId).params("timedstartdate", timedstartdate).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                YuYueDataBean yuYueDataBean = gson.fromJson(response.body(), YuYueDataBean.class);
                yuYueDataListAdapter.setNewData(yuYueDataBean.getData());
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        multipleStatusView.showLoading();
        OkGo.<String>post(URLs.PROJECT_DETAILS).params("id", beauticianId).execute(new StringCallback() {
            @SuppressLint("StringFormatMatches")
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ProjectDetailActivity", response.body());
                multipleStatusView.showOutContentView(scrollLayout);
                Gson gson = new Gson();
                detailBean = gson.fromJson(response.body(), ProjectDetailBean.class);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + detailBean.getData().getImage(), shop_detail_icon);
                shopName.setText(detailBean.getData().getName());
                price.setText("￥" + detailBean.getData().getPrice_discount());
                marketPrice.setText("￥" + detailBean.getData().getPrice_market());
                /*tvFollowNum.setText("已有"+detailBean.getData().getTreatment_count()+"人关注");*/
                displayForWebView("http://www.baidu.com", "http://www.baidu.com");
                if (CollectionUtils.isNotEmpty(detailBean.getData().getHotdata())) {
                    contentSectionAdapter.replaceData(detailBean.getData().getHotdata());
                    contentSectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            LogUtil.e("section", "click:" + position);
                            BaseBean item = contentSectionAdapter.getItem(position);
                            ProjectDetailActivity.start(ProjectDetailActivity.this, item.getId());
                        }
                    });
                }
                if (detailBean.getData().getComment() != null && CollectionUtils.isNotEmpty(detailBean.getData().getComment().getAll())) {
                    commentSectionView.setVisibility(View.VISIBLE);
//                    userCommentNum.setText(getString(R.string.home_comment_num_format, detailBean.getData().getComment_count()));
                    tvCommentPeer.setText(getString(R.string.home_comment_peer_format, detailBean.getData().getPeer() + "%", detailBean.getData().getSatisfaction() + "%"));
                    commentData = detailBean.getData().getComment();
                    commentAdapter.replaceData(detailBean.getData().getComment().getAll());
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getComment().getTags())) {
                        fillTags(detailBean.getData().getComment().getTags());
                    }
                } else {
                    commentSectionView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                multipleStatusView.showError();
            }
        });

        initDayTime("");

        initDatePicker(this);
    }

    /**
     * 填充评价标识
     *
     * @param result
     */
    private void fillTags(final List<ProjectDetailBean.DataBean.CommentBean.TagsBean> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        commentTagFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(this).inflate(R.layout.item_comment_tag_layout, commentTagFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i).getName())) {
                txt.setText(result.get(i).getName());
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                    }
                });
                commentTagFlowLayout.addView(txt);
            }
        }
    }

    private ArrayList<Calendar> calList = new ArrayList<>();

    private void initDayTime(String time) {
        final CanlBean canlBean = new CanlBean();

        calList.clear();
        for (int i = 0; i < 30; i++) {
            cal = Calendar.getInstance();
            if (time != null && !time.isEmpty() && "" != null) {
                if ("" != time && time != null) {
                    String[] year = time.split(" ")[0].split("-");
                    int integer = Integer.parseInt(year[0]);
                    int integer1 = Integer.parseInt(year[1]);
                    int integer2 = Integer.parseInt(year[2]);

                    int month = integer1 == 1 ? 12 : integer1 - 1;
                    integer = integer1 == 1 ? integer - 1 : integer;
                    cal.set(integer, month, integer2);
                    cal.add(Calendar.DATE, i);
                    calList.add(cal);
                }
            } else {
                cal.add(Calendar.DATE, i);
                calList.add(cal);
            }
        }
        canlBean.setDataBean(calList);

        timeData(canlBean.getDataBean().get(0).getTimeInMillis());
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        id_recyclerview_horizontal.setLayoutManager(linearLayoutManager);
        dayAdapter = new DayCheckAdapter2(this, canlBean.getDataBean(), beauticianId);
        id_recyclerview_horizontal.setAdapter(dayAdapter);

        dayAdapter.setOnItemClickLitener(new DayCheckAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, TextView textView, int position) {
                timeData(canlBean.getDataBean().get(position).getTimeInMillis());
            }
        });
    }

    private CustomDatePicker startTimePicker;
    /*
     *初始化时间选择器
     */
    protected void initDatePicker(final Context mContext) {
        startTimePicker = new CustomDatePicker(mContext, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                ToastUtil.showToastMsg(mContext, time);

                long currentTimeMillis = System.currentTimeMillis();
                String formatTime = AppUtil.getFormatTime(currentTimeMillis);

                String timers = formatTime.split(" ")[0];
                String timers1 = time.split(" ")[0];
                if (AppUtil.timeToStamp(timers1) < AppUtil.timeToStamp(timers)) {
                    ToastUtil.showToastMsg(mContext, "时间不可选");
                } else {
                    initDayTime(time);
                }
            }
        }, "2018-01-01 00:00", "2050-01-01 00:00", "请设置开始时间"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        startTimePicker.showSpecificTime(false); // 显示时和分
        startTimePicker.setIsLoop(true); // 允许循环滚动
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
