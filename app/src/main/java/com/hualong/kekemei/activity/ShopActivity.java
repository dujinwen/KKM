package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.EvaluateListAdapter;
import com.hualong.kekemei.adapter.MeiRongShiAdapter;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.adapter.YuYueDataListAdapter;
import com.hualong.kekemei.bean.BaseBean;
import com.hualong.kekemei.bean.BeauticianDetailBean;
import com.hualong.kekemei.bean.DetailEnum;
import com.hualong.kekemei.bean.ShopDetailBean;
import com.hualong.kekemei.bean.YuYueDataBean;
import com.hualong.kekemei.utils.AppUtil;
import com.hualong.kekemei.utils.CollectionUtils;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.StringUtils;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.MultipleStatusView;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * 店铺和美容师主页页面
 */
public class ShopActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = ShopActivity.class.getSimpleName();
    private static final String EXTRA_KEY_BEAUTICIAN_ID = "beauticianId";
    private static final String EXTRA_KEY_USER_ID = "userId";
    private static final String EXTRA_KEY_ENUM_ID = "type";
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

    @BindView(R.id.tvOrderCount)
    TextView tvOrderCount;

    @BindView(R.id.tvCollectionCount)
    TextView tvCollectionCount;

    @BindView(R.id.tvFollow)
    TextView tvFollow;

    @BindView(R.id.tvSatisfaction)
    TextView tvSatisfaction;

    @BindView(R.id.shopStar)
    StarBar shopStar;

    @BindView(R.id.detailHome)
    TextView detailHome;
    @BindView(R.id.indicatorShopHome)
    ImageView indicatorShopHome;

    @BindView(R.id.indicatorHotProject)
    ImageView indicatorHotProject;

    @BindView(R.id.indicatorEvaluate)
    ImageView indicatorEvaluate;

    @BindView(R.id.contentView)
    LinearLayout contentView;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.ll_dianpu_tab)
    LinearLayout llDianpuTab;
    @BindView(R.id.grid)
    GridView grid;
    @BindView(R.id.show_select_time)
    LinearLayout showSelectTime;
    @BindView(R.id.ll_select_time)
    LinearLayout llSelectTime;
    @BindView(R.id.rv_list_yuyue)
    RecyclerView rvListYuyue;

    private ImageView callPhone;

    private View commentSectionView;
    private TextView userCommentNum;
    private TextView commentTabAll;
    private TextView commentTabNew;
    private TextView commentTabPhoto;
    private LinearLayout markLayout;
    private FlexboxLayout commentTagFlowLayout;
    private RecyclerView rvCommentList;
    private ShopDetailBean.DataBean.CommentdataBean commentdata;

    private RecyclerView hotProjectRv;
    private String beauticianId, userId;
    private MyGridAdapter contentSectionAdapter;
    private EvaluateListAdapter commentAdapter;
    private DetailEnum detailEnum;

    private MeiRongShiAdapter meiRongShiAdapter;
    @Nullable
    private LinearLayout ll_yuyue;
    private Calendar cal;
    private DayAdapter dayAdapter;
    private YuYueDataListAdapter yuYueDataListAdapter;

    public static void start(Context context, int beauticianId, long userId, DetailEnum detailEnum) {
        Intent intent = new Intent(context, ShopActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, String.valueOf(beauticianId));
        intent.putExtra(EXTRA_KEY_USER_ID, String.valueOf(userId));
        intent.putExtra(EXTRA_KEY_ENUM_ID, detailEnum);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        if (detailEnum == DetailEnum.SHOP) {
            return R.layout.activity_shop;
        } else if (detailEnum == DetailEnum.BEAUTICIAN) {
            return R.layout.activity_beautician;
        }
        return R.layout.activity_shop;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        detailEnum = (DetailEnum) getIntent().getSerializableExtra(EXTRA_KEY_ENUM_ID);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        beauticianId = super.getStringExtraSecure(EXTRA_KEY_BEAUTICIAN_ID);
        userId = super.getStringExtraSecure(EXTRA_KEY_USER_ID);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (detailEnum == DetailEnum.BEAUTICIAN) {
            tv_title.setText("美容师详情");
            detailHome.setText("美容师首页");
        }
        iv_share.setVisibility(View.VISIBLE);
        llSelectTime = findViewById(R.id.ll_select_time);
        indicatorShopHome.setVisibility(View.VISIBLE);

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

        multipleStatusView.showOutContentView(scrollLayout);

        if (detailEnum == DetailEnum.SHOP) {
            callPhone = findViewById(R.id.callphone);
        }

        View contentHead = View.inflate(this, R.layout.layout_detail_content_head, null);
        initContentHead(contentHead);

        View contentSectionView = View.inflate(this, R.layout.layout_shop_content_section_view, null);
        initContentSectionView(contentSectionView);

        View nearbySectionView = View.inflate(this, R.layout.section_layout_nearby_beautician, null);
        initNearbyView(nearbySectionView);

        commentSectionView = View.inflate(this, R.layout.layout_comment_top_head, null);
        initCommentView(commentSectionView);

        contentView.addView(contentHead);
        contentView.addView(contentSectionView);
        if (detailEnum == DetailEnum.SHOP) {
            contentView.addView(nearbySectionView);
        }
        contentView.addView(commentSectionView);
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
                startActivity(new Intent(ShopActivity.this, ClassifyActivity.class));
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
        ll_yuyue = contentHead.findViewById(R.id.ll_yuyue);
        ll_yuyue.setOnClickListener(this);
        serviceOne = contentHead.findViewById(R.id.serviceOne);
        serviceTwo = contentHead.findViewById(R.id.serviceTwo);
        serviceThree = contentHead.findViewById(R.id.serviceThree);
        tvAddress = contentHead.findViewById(R.id.tvAddress);
        tvDistance = contentHead.findViewById(R.id.tvDistance);
    }

    private void initNearbyView(View view) {
        TextView fujinMeirongshi = view.findViewById(R.id.fujin_meirongshi);
        RecyclerView rvMeirongshi = view.findViewById(R.id.rv_meirongshi);
        fujinMeirongshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeiRongShiActivity.start(ShopActivity.this);
            }
        });
        LinearLayoutManager layout_meirongshi = new LinearLayoutManager(this);
        layout_meirongshi.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvMeirongshi.setHasFixedSize(true);
        rvMeirongshi.setNestedScrollingEnabled(false);
        rvMeirongshi.setLayoutManager(layout_meirongshi);
        meiRongShiAdapter = new MeiRongShiAdapter(this);
        rvMeirongshi.setAdapter(meiRongShiAdapter);
    }

    private void initCommentView(View view) {
        userCommentNum = view.findViewById(R.id.userCommentNum);
        commentTabAll = view.findViewById(R.id.commentTabAll);
        commentTabNew = view.findViewById(R.id.commentTabNew);
        commentTabPhoto = view.findViewById(R.id.commentTabPhoto);
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
        rvListYuyue.setLayoutManager(new GridLayoutManager(getBaseContext(), 4));
        yuYueDataListAdapter = new YuYueDataListAdapter(this);
        rvListYuyue.setAdapter(yuYueDataListAdapter);
        yuYueDataListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.ll_select_data_time) {
                    if (view.isSelected()) {
                        view.setSelected(true);
                        view.setBackground(ShopActivity.this.getResources().getDrawable(R.drawable.btn_7ad2d2_background));
                    } else {
                        view.setSelected(false);
                        view.setBackground(ShopActivity.this.getResources().getDrawable(R.drawable.btn_white_background));
                    }
                }
            }
        });


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
                UserEvaluateActivity.start(ShopActivity.this, false);
            }
        });
    }

    @Optional
    @OnClick({R.id.shopHome, R.id.hotProject, R.id.userEvaluate,
            R.id.commentTabAll, R.id.commentTabNew, R.id.tvFollow,
            R.id.commentTabPhoto, R.id.ll_yuyue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvFollow:
                follow();
                break;
            case R.id.shopHome:
                indicatorShopHome.setVisibility(View.VISIBLE);
                indicatorHotProject.setVisibility(View.GONE);
                indicatorEvaluate.setVisibility(View.GONE);
                scrollTo(contentView.getChildAt(0));
                break;
            case R.id.hotProject:
                indicatorShopHome.setVisibility(View.GONE);
                indicatorHotProject.setVisibility(View.VISIBLE);
                indicatorEvaluate.setVisibility(View.GONE);
                scrollTo(contentView.getChildAt(1));
                break;
            case R.id.userEvaluate:
                indicatorShopHome.setVisibility(View.GONE);
                indicatorHotProject.setVisibility(View.GONE);
                indicatorEvaluate.setVisibility(View.VISIBLE);
                if (detailEnum == DetailEnum.SHOP) {
                    scrollTo(contentView.getChildAt(3));
                } else if (detailEnum == DetailEnum.BEAUTICIAN) {
                    scrollTo(contentView.getChildAt(2));
                }
                break;
            case R.id.commentTabAll:
                commentTabAll.setSelected(true);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(false);
                if (commentdata != null) {
                    commentAdapter.replaceData(commentdata.getAll());
                }
                break;
            case R.id.commentTabNew:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(true);
                commentTabPhoto.setSelected(false);
                if (commentdata != null) {
                    commentAdapter.replaceData(commentdata.getNewX());
                }
                break;
            case R.id.commentTabPhoto:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(true);
                if (commentdata != null) {
                    commentAdapter.replaceData(commentdata.getHaveimg());
                }
                break;
            case R.id.ll_yuyue:
                //                llSelectTime.setVisibility(llSelectTime.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                llSelectTime.setVisibility(View.VISIBLE);
                llDianpuTab.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 关注
     */
    private void follow() {
        OkGo.<String>post(URLs.FOLLOW_BEAUTICIAN).params("beautician_id", beauticianId).params("user_id", userId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "follow beautician:" + response.body());
                Gson gson = new Gson();
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
                LogUtil.e(TAG, "follow beautician:" + response.body());
                Gson gson = new Gson();
                YuYueDataBean yuYueDataBean = gson.fromJson(response.body(), YuYueDataBean.class);
                yuYueDataListAdapter.setNewData(yuYueDataBean.getData());
                //
            }
        });
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

    @Override
    protected void initData() {
        super.initData();
        multipleStatusView.showLoading();
        if (detailEnum == DetailEnum.SHOP) {
            OkGo.<String>post(URLs.SHOP_DETAILS).params("id", beauticianId).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    LogUtil.e(TAG, "shop detail:" + response.body());
                    multipleStatusView.showOutContentView(scrollLayout);
                    Gson gson = new Gson();
                    final ShopDetailBean detailBean = gson.fromJson(response.body(), ShopDetailBean.class);
                    ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + detailBean.getData().getImage(), shop_detail_icon);
                    tv_title.setText(getString(R.string.shop_detail_name_text, detailBean.getData().getName()));
                    shopName.setText(detailBean.getData().getName());
                    shopStar.setStarMark(detailBean.getData().getStart());
                    tvOrderCount.setText(getString(R.string.shop_detail_server_number, detailBean.getData().getOrder_count()));
                    tvCollectionCount.setText(getString(R.string.shop_detail_fensi_number, detailBean.getData().getCollection_count()));
                    tvSatisfaction.setText(getString(R.string.shop_detail_satisfaction, detailBean.getData().getSatisfaction() + "%"));
                    tvAddress.setText(detailBean.getData().getAddress());
                    tvDistance.setText(detailBean.getData().getDistance());
                    if (StringUtils.isNotBlank(detailBean.getData().getTel())) {
                        LogUtil.e(TAG, "tel:" + detailBean.getData().getTel());
                        callPhone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                LogUtil.e(TAG, "click tel:" + detailBean.getData().getTel());
                                AppUtil.callPhone(ShopActivity.this, detailBean.getData().getTel());
                            }
                        });
                    }
                    if (detailBean.getData().getIscollection() == 1) {
                        tvFollow.setText("已关注");
                        tvFollow.setClickable(false);
                        tvFollow.setTextColor(ContextCompat.getColor(ShopActivity.this, R.color.common_text_dark));
                        tvFollow.setBackground(ContextCompat.getDrawable(ShopActivity.this, R.mipmap.orderform_determine_btn_1));
                    } else {
                        tvFollow.setText("关注");
                        tvFollow.setClickable(true);
                        tvFollow.setTextColor(ContextCompat.getColor(ShopActivity.this, R.color.white));
                        tvFollow.setBackground(ContextCompat.getDrawable(ShopActivity.this, R.mipmap.orderform_determine_btn));
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getStrading())) {
                        List<String> tradingList = detailBean.getData().getStrading();
                        StringBuilder tradingText = new StringBuilder();
                        for (String trading : tradingList) {
                            tradingText.append(trading).append("    ");
                        }
                        tradingArea.setText(tradingText.toString());
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getService())) {
                        List<ShopDetailBean.DataBean.ServiceBean> serviceList = detailBean.getData().getService();
                        if (serviceList.get(0) != null) {
                            serviceOne.setVisibility(View.VISIBLE);
                            serviceOne.setText(serviceList.get(0).getName());
                        } else {
                            serviceOne.setVisibility(View.GONE);
                        }
                        if (serviceList.get(1) != null) {
                            serviceTwo.setVisibility(View.VISIBLE);
                            serviceTwo.setText(serviceList.get(1).getName());
                        } else {
                            serviceTwo.setVisibility(View.GONE);
                        }
                        if (serviceList.get(2) != null) {
                            serviceThree.setVisibility(View.VISIBLE);
                            serviceThree.setText(serviceList.get(2).getName());
                        } else {
                            serviceThree.setVisibility(View.GONE);
                        }
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getHotdata())) {
                        contentSectionAdapter.replaceData(detailBean.getData().getHotdata());
                        contentSectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                                BaseBean item = contentSectionAdapter.getItem(position);
                                ProjectDetailActivity.start(ShopActivity.this, item.getId());
                            }
                        });
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getBeautician())) {
                        meiRongShiAdapter.replaceData(detailBean.getData().getBeautician());
                    }
                    if (detailBean.getData().getCommentdata() != null && CollectionUtils.isNotEmpty(detailBean.getData().getCommentdata().getAll())) {
                        commentSectionView.setVisibility(View.VISIBLE);
                        userCommentNum.setText(getString(R.string.home_comment_num_format, detailBean.getData().getComment_count()));
                        commentdata = detailBean.getData().getCommentdata();
                        commentAdapter.replaceData(detailBean.getData().getCommentdata().getAll());
                    } else {
                        commentSectionView.setVisibility(View.GONE);
                    }
                    fillTags(detailBean.getData().getComment_tag());
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    multipleStatusView.showError();
                }
            });
        } else {
            OkGo.<String>post(URLs.BEAUTICIAN_DETAILS).params("id", beauticianId).params("user_id", userId).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    LogUtil.e(TAG, "beautician detail:" + response.body());
                    multipleStatusView.showOutContentView(scrollLayout);
                    Gson gson = new Gson();
                    BeauticianDetailBean detailBean = gson.fromJson(response.body(), BeauticianDetailBean.class);
                    ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + detailBean.getData().getImage(), shop_detail_icon);
                    shopName.setText(detailBean.getData().getName());
                    shopStar.setStarMark(detailBean.getData().getStart());
                    tvOrderCount.setText(getString(R.string.shop_detail_server_number, detailBean.getData().getOrder_count()));
                    tvCollectionCount.setText(getString(R.string.shop_detail_fensi_number, detailBean.getData().getFriend_count()));
                    tvSatisfaction.setText(getString(R.string.shop_detail_satisfaction, detailBean.getData().getSatisfaction() + "%"));
                    tvAddress.setText(detailBean.getData().getAddress());
//                    tvDistance.setText(detailBean.getData().getDistance());
                    if (detailBean.getData().getIsfriend() == 1) {
                        tvFollow.setText("已关注");
                        tvFollow.setClickable(false);
                        tvFollow.setTextColor(ContextCompat.getColor(ShopActivity.this, R.color.common_text_dark));
                        tvFollow.setBackground(ContextCompat.getDrawable(ShopActivity.this, R.mipmap.orderform_determine_btn_1));
                    } else {
                        tvFollow.setText("关注");
                        tvFollow.setClickable(true);
                        tvFollow.setTextColor(ContextCompat.getColor(ShopActivity.this, R.color.white));
                        tvFollow.setBackground(ContextCompat.getDrawable(ShopActivity.this, R.mipmap.orderform_determine_btn));
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getStrading())) {
                        List<String> tradingList = detailBean.getData().getStrading();
                        StringBuilder tradingText = new StringBuilder();
                        for (String trading : tradingList) {
                            tradingText.append(trading).append("    ");
                        }
                        tradingArea.setText(tradingText.toString());
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getAuth())) {
                        List<String> authList = detailBean.getData().getAuth();
                        for (int i = 0; i < authList.size(); i++) {
                            if (StringUtils.isNotEmpty(authList.get(i))) {
                                if (i == 0) {
                                    serviceOne.setVisibility(View.VISIBLE);
                                    serviceOne.setText(authList.get(i));
                                } else {
                                    serviceOne.setVisibility(View.GONE);
                                }
                                if (i == 1) {
                                    serviceTwo.setVisibility(View.VISIBLE);
                                    serviceTwo.setText(authList.get(i));
                                } else {
                                    serviceTwo.setVisibility(View.GONE);
                                }
                                if (i == 2) {
                                    serviceThree.setVisibility(View.VISIBLE);
                                    serviceThree.setText(authList.get(i));
                                } else {
                                    serviceThree.setVisibility(View.GONE);
                                }
                            }
                        }
                    }
                    if (CollectionUtils.isNotEmpty(detailBean.getData().getHotdata())) {
                        contentSectionAdapter.replaceData(detailBean.getData().getHotdata());
                        contentSectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                                BaseBean item = contentSectionAdapter.getItem(position);
                                ProjectDetailActivity.start(ShopActivity.this, item.getId());
                            }
                        });
                    }
                    if (detailBean.getData().getCommentdata() != null && CollectionUtils.isNotEmpty(detailBean.getData().getCommentdata().getAll())) {
                        commentSectionView.setVisibility(View.VISIBLE);
                        userCommentNum.setText(getString(R.string.home_comment_num_format, detailBean.getData().getComment_count()));
                        commentAdapter.addData(detailBean.getData().getCommentdata().getAll());
                    } else {
                        commentSectionView.setVisibility(View.GONE);
                    }
                    fillTags(detailBean.getData().getComment_tag());
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    multipleStatusView.showError();
                }
            });
        }
        initDayTime();
    }

    private ArrayList<Calendar> arrayList = new ArrayList();

    private void initDayTime() {
        for (int i = 0; i < 30; i++) {
            cal = Calendar.getInstance();
            cal.add(Calendar.DATE, i);
            arrayList.add(cal);
        }

        dayAdapter = new DayAdapter(this, arrayList);
        grid.setAdapter(dayAdapter);
    }

    /**
     * 填充评价标识
     *
     * @param result
     */
    private void fillTags(final List<BeauticianDetailBean.DataBean.CommentTagBean> result) {
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

    class DayAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<Calendar> calList;
        private String week = "周日";

        public DayAdapter(Context context, ArrayList<Calendar> arrayList) {

            this.mContext = context;
            this.calList = arrayList;
        }


        @Override
        public int getCount() {
            return calList.size();
        }

        @Override
        public Object getItem(int position) {
            return calList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_date_list, null);
                viewHolder = new ViewHolder();
                viewHolder.tv_date_and_week = convertView.findViewById(R.id.tv_date_and_week);
                viewHolder.tv_can_yuyue = convertView.findViewById(R.id.tv_can_yuyue);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final Calendar calendar = calList.get(position);
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY:
                    week = "周一";
                    break;
                case Calendar.TUESDAY:
                    week = "周二";
                    break;
                case Calendar.WEDNESDAY:
                    week = "周三";
                    break;
                case Calendar.THURSDAY:
                    week = "周四";
                    break;
                case Calendar.FRIDAY:
                    week = "周五";
                    break;
                case Calendar.SATURDAY:
                    week = "周六";
                    break;
                case Calendar.SUNDAY:
                    week = "周日";
                    break;
                default:

                    break;
            }
            viewHolder.tv_date_and_week.setText(week + " " + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH));
            viewHolder.tv_date_and_week.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeData(calendar.getTimeInMillis());
                }
            });
            return convertView;
        }

        private class ViewHolder {
            TextView tv_date_and_week;
            TextView tv_can_yuyue;
        }
    }
}
