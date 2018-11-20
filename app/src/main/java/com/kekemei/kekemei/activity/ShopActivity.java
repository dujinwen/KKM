package com.kekemei.kekemei.activity;

import android.annotation.SuppressLint;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.DayCheckAdapter2;
import com.kekemei.kekemei.adapter.EvaluateListAdapter;
import com.kekemei.kekemei.adapter.MeiRongShiAdapter;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.adapter.YuYueDataListAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.BeauticianDetailBean;
import com.kekemei.kekemei.bean.CanlBean;
import com.kekemei.kekemei.bean.CommentTagsBean;
import com.kekemei.kekemei.bean.DetailEnum;
import com.kekemei.kekemei.bean.ShopDetailBean;
import com.kekemei.kekemei.bean.YuYueDataBean;
import com.kekemei.kekemei.utils.AppUtil;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.CustomDatePicker;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.ToastUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.kekemei.kekemei.view.StarBar;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

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
    private static final String EXTRA_KEY_ENUM_ID = "type";
    private CustomDatePicker startTimePicker;
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

    private ImageView callPhone;

    private View commentSectionView;
    private TextView userCommentNum;
    private TextView commentTabAll;
    private TextView commentTabNew;
    private TextView commentTabPhoto;
    private TextView tvCommentPeer;
    private LinearLayout markLayout;
    private FlexboxLayout commentTagFlowLayout;
    private RecyclerView rvCommentList;
    private ShopDetailBean.DataBean.CommentdataBean commentdata;

    private LinearLayout newComerLayout, memberLayout, preferenceLayout;
    private RecyclerView hotProjectRv, newComerRv, memberRv, preferenceRv;
    private String beauticianId;
    private MyGridAdapter hotProjectAdapter, newComerAdapter, memberAdapter, preferenceAdapter;
    private EvaluateListAdapter commentAdapter;
    private DetailEnum detailEnum;

    private MeiRongShiAdapter meiRongShiAdapter;
    @Nullable
    private LinearLayout ll_yuyue;
    private Calendar cal;
    private DayCheckAdapter2 dayAdapter;
    private YuYueDataListAdapter yuYueDataListAdapter;
    private TextView tv_date_and_week;
    private TextView tv_can_yuyue;

    private String tel = "";
    private int timeSelectPosition = -1;
    private String timeSelectName = "";
    private long daySelectPosition = -1L;
    private ShopDetailBean shopDetailBean;
    private BeauticianDetailBean beauticianDetailBean;

    public static void start(Context context, String beauticianId, DetailEnum detailEnum) {
        Intent intent = new Intent(context, ShopActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, beauticianId);
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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (detailEnum == DetailEnum.BEAUTICIAN) {
            tv_title.setText("美容师详情");
            detailHome.setText("美容师首页");
            findViewById(R.id.tvBeauticianInfo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BeauticianInfoActivity.start(ShopActivity.this, beauticianId);
                }
            });
            findViewById(R.id.tvAddFriends).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
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
            findViewById(R.id.openPictures).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPhotoPicker();
                }
            });
            findViewById(R.id.onLineService).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (StringUtils.isNotBlank(tel)) {
                        AppUtil.callPhone(ShopActivity.this, tel);
                    }
                }
            });
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
        newComerLayout = view.findViewById(R.id.newComerLayout);
        newComerRv = view.findViewById(R.id.sectionNewRv);
        memberLayout = view.findViewById(R.id.memberLayout);
        memberRv = view.findViewById(R.id.sectionMemberRv);
        preferenceLayout = view.findViewById(R.id.preferenceLayout);
        preferenceRv = view.findViewById(R.id.sectionPreferenceRv);

        initRv(hotProjectRv);
        initRv(newComerRv);
        initRv(memberRv);
        initRv(preferenceRv);
        hotProjectAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        hotProjectRv.setAdapter(hotProjectAdapter);
        hotProjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.e("section", "click:" + position);
                BaseBean item = hotProjectAdapter.getItem(position);
                if (detailEnum == DetailEnum.SHOP) {
                    ProjectDetailActivity.start(ShopActivity.this, item.getId(), timeSelectPosition, timeSelectName, daySelectPosition, shopDetailBean, detailEnum);
                } else {
                    ProjectDetailActivity.start(ShopActivity.this, item.getId(), timeSelectPosition, timeSelectName, daySelectPosition, beauticianDetailBean, detailEnum);
                }
            }
        });
        view.findViewById(R.id.lookMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, ClassifyActivity.class));
            }
        });

        newComerAdapter = new MyGridAdapter(this, MyGridAdapter.NewmemberdataBean);
        newComerRv.setAdapter(newComerAdapter);
        newComerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.e("section", "click:" + position);
                BaseBean item = newComerAdapter.getItem(position);
                NewComerActivity.start(ShopActivity.this, item.getId() + "");
            }
        });
        view.findViewById(R.id.lookMoreNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, ClassifyActivity.class));
            }
        });

        memberAdapter = new MyGridAdapter(this, MyGridAdapter.MemberdataBean);
        memberRv.setAdapter(memberAdapter);
        memberAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.e("section", "click:" + position);
                BaseBean item = memberAdapter.getItem(position);
                ProjectDetailActivity.start(ShopActivity.this, item.getId(), timeSelectPosition, timeSelectName, daySelectPosition, beauticianDetailBean, detailEnum);
            }
        });
        view.findViewById(R.id.lookMoreMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, ClassifyActivity.class));
            }
        });

        preferenceAdapter = new MyGridAdapter(this, MyGridAdapter.SpecialdataBean);
        preferenceRv.setAdapter(preferenceAdapter);
        preferenceAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LogUtil.e("section", "click:" + position);
                BaseBean item = preferenceAdapter.getItem(position);
                ProjectDetailActivity.start(ShopActivity.this, item.getId(), timeSelectPosition, timeSelectName, daySelectPosition, beauticianDetailBean, detailEnum);
            }
        });
        view.findViewById(R.id.lookMorePreference).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, ClassifyActivity.class));
            }
        });
    }

    private void initRv(RecyclerView view) {
        view.setLayoutManager(new GridLayoutManager(this, 2));
        view.setHasFixedSize(true);
        view.setNestedScrollingEnabled(false);
    }

    private TextView tradingArea;
    private TextView serviceOne;
    private TextView serviceTwo;
    private TextView serviceThree;
    private TextView tvAddress;
    private TextView tvDistance;
    private TextView coupon;
    private TextView subtract;
    private TextView redBao;

    private void initContentHead(View contentHead) {
        tradingArea = contentHead.findViewById(R.id.tradingArea);
        ll_yuyue = contentHead.findViewById(R.id.ll_yuyue);
        ll_yuyue.setOnClickListener(this);
        serviceOne = contentHead.findViewById(R.id.serviceOne);
        serviceTwo = contentHead.findViewById(R.id.serviceTwo);
        serviceThree = contentHead.findViewById(R.id.serviceThree);
        tvAddress = contentHead.findViewById(R.id.tvAddress);
        tvDistance = contentHead.findViewById(R.id.tvDistance);
        coupon = contentHead.findViewById(R.id.coupon);
        coupon.setOnClickListener(this);
        subtract = contentHead.findViewById(R.id.subtract);
        subtract.setOnClickListener(this);
        redBao = contentHead.findViewById(R.id.redBao);
        redBao.setOnClickListener(this);
    }

    private void initNearbyView(View view) {
        TextView fujinMeirongshi = view.findViewById(R.id.fujin_meirongshi);
        RecyclerView rvMeirongshi = view.findViewById(R.id.rv_meirongshi);
        fujinMeirongshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopBeauticianListActivity.start(ShopActivity.this, false);
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
        rvListYuyue.setLayoutManager(new GridLayoutManager(getBaseContext(), 4));
        yuYueDataListAdapter = new YuYueDataListAdapter(this);
        rvListYuyue.setAdapter(yuYueDataListAdapter);
        yuYueDataListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<YuYueDataBean.DataBean> data = yuYueDataListAdapter.getData();
                if (view.getId() == R.id.ll_select_data_time) {

                    tv_date_and_week = (TextView) adapter.getViewByPosition(rvListYuyue, position, R.id.tv_date_and_week);
                    tv_can_yuyue = (TextView) adapter.getViewByPosition(rvListYuyue, position, R.id.tv_can_yuyue);
                    for (YuYueDataBean.DataBean item : data) {
                        item.setSelect(false);
                        view.setBackground(ContextCompat.getDrawable(ShopActivity.this, R.drawable.btn_white_background));
                        tv_date_and_week.setTextColor(0XFF999999);
                        tv_can_yuyue.setTextColor(0XFF999999);
                    }
                    data.get(position).setSelect(true);
                    timeSelectPosition = data.get(position).getId();
                    timeSelectName = data.get(position).getName();
                    adapter.notifyDataSetChanged();
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
                UserEvaluateActivity.start(ShopActivity.this, false, "1", "1", "1");
            }
        });
    }

    @Optional
    @OnClick({R.id.shopHome, R.id.hotProject, R.id.userEvaluate,
            R.id.commentTabAll, R.id.commentTabNew, R.id.tvFollow,
            R.id.commentTabPhoto, R.id.ll_yuyue, R.id.queding})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvFollow:
                if (tvFollow.getText().toString().equals("关注"))
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
                llSelectTime.setVisibility(View.VISIBLE);
                llDianpuTab.setVisibility(View.GONE);
                layoutBottomBar.setVisibility(View.GONE);
                initDayTime("");
                break;

            case R.id.queding:
                llSelectTime.setVisibility(View.GONE);
                llDianpuTab.setVisibility(View.VISIBLE);
                layoutBottomBar.setVisibility(View.VISIBLE);
                break;
            case R.id.coupon:
                int tagId = (int) coupon.getTag();
                receiveCoupon(tagId);
                break;
            case R.id.subtract:
                receiveFull();
                break;
            case R.id.redBao:
                int redBaoId = (int) redBao.getTag();
                receiveRedBao(redBaoId);
                break;
        }
    }

    public static final int REQUEST_ALBUM = 10;

    private void openPhotoPicker() {
        Intent intent = new Intent(this, ImageGridActivity.class);
        startActivityForResult(intent, REQUEST_ALBUM);
    }

    /**
     * 关注
     */
    private void follow() {
        OkGo.<String>post(URLs.FOLLOW_BEAUTICIAN).params("beautician_id", beauticianId)
                .params("user_id", UserHelp.getUserId(this)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "follow beautician:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        ToastUtil.showToastMsg(ShopActivity.this, "关注失败");
                        return;
                    }
                    tvFollow.setText("已关注");
                    ToastUtil.showToastMsg(ShopActivity.this, msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtil.showToastMsg(ShopActivity.this, "关注失败");
            }
        });
    }

    /**
     * 领取红包
     *
     * @param redBaoId
     */
    private void receiveRedBao(int redBaoId) {
        String shopId = detailEnum == DetailEnum.SHOP ? shopDetailBean.getData().getId() : "";
        String redType = detailEnum == DetailEnum.SHOP ? "3" : "2";
        OkGo.<String>post(URLs.RED_ENVELOPES_RECEIVE).params("red_type", redType)
                .params("project_id", "").params("id", redBaoId)
                .params("shop_id", shopId).params("beautician_id", beauticianId)
                .params("user_id", UserHelp.getUserId(this)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "follow beautician:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        ToastUtil.showToastMsg(ShopActivity.this, "领取失败");
                        return;
                    }
                    ToastUtil.showToastMsg(ShopActivity.this, msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtil.showToastMsg(ShopActivity.this, "领取失败");
            }
        });
    }

    /**
     * 领取满减券
     *
     * @TODO 满减领取URL？
     */
    private void receiveFull() {
       /* OkGo.<String>post(URLs.FOLLOW_BEAUTICIAN).params("beautician_id", beauticianId).params("user_id", userId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "follow beautician:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        ToastUtil.showToastMsg(ShopActivity.this, "关注失败");
                        return;
                    }
                    tvFollow.setText("已关注");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    /**
     * 领取优惠券
     *
     * @param couponId
     */
    private void receiveCoupon(int couponId) {
        String shopId = detailEnum == DetailEnum.SHOP ? shopDetailBean.getData().getId() : "";
        String couponType = detailEnum == DetailEnum.SHOP ? "3" : "2";
        OkGo.<String>post(URLs.COUPON_RECEIVE).params("coupon_type", couponType)
                .params("project_id", "").params("id", couponId)
                .params("shop_id", shopId).params("beautician_id", beauticianId)
                .params("user_id", UserHelp.getUserId(this)).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        ToastUtil.showToastMsg(ShopActivity.this, "领取失败");
                        return;
                    }
                    ToastUtil.showToastMsg(ShopActivity.this, msg.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                ToastUtil.showToastMsg(ShopActivity.this, "领取失败");
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
                @SuppressLint("StringFormatMatches")
                @Override
                public void onSuccess(Response<String> response) {
                    LogUtil.e(TAG, "shop detail:" + response.body());
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());
                        Object msg = jsonObject.opt("msg");
                        if (msg.equals("暂无数据")) {
                            multipleStatusView.showEmpty();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    multipleStatusView.showOutContentView(scrollLayout);
                    Gson gson = new Gson();
                    shopDetailBean = gson.fromJson(response.body(), ShopDetailBean.class);
                    ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + shopDetailBean.getData().getImage(), shop_detail_icon);
                    tv_title.setText(getString(R.string.shop_detail_name_text, shopDetailBean.getData().getName()));
                    shopName.setText(shopDetailBean.getData().getName());
                    shopStar.setStarMark(shopDetailBean.getData().getStart());
                    tvOrderCount.setText(getString(R.string.shop_detail_server_number, shopDetailBean.getData().getOrder_count()));
                    tvCollectionCount.setText(getString(R.string.shop_detail_fensi_number, shopDetailBean.getData().getCollection_count()));
                    tvSatisfaction.setText(getString(R.string.shop_detail_satisfaction, shopDetailBean.getData().getSatisfaction() + "%"));
                    tvAddress.setText(shopDetailBean.getData().getAddress());
                    tvDistance.setText(getString(R.string.shop_detail_distance, shopDetailBean.getData().getDistance()));
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getCoupon())) {
                        coupon.setVisibility(View.VISIBLE);
                        coupon.setTag(shopDetailBean.getData().getCoupon().get(0).getId());
                        coupon.setText(String.valueOf(shopDetailBean.getData().getCoupon().get(0).getPrice_satisfy()));
                    } else {
                        coupon.setVisibility(View.GONE);
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getFull())) {
                        subtract.setVisibility(View.VISIBLE);
                        String name = shopDetailBean.getData().getFull().get(0).getName();
                        String[] split = name.split("减");
                        String subtractText = "-" + split[1] + "\n" + shopDetailBean.getData().getFull().get(0).getPrice_satisfy() + "元";
                        subtract.setTag(shopDetailBean.getData().getFull().get(0).getId());
                        subtract.setText(String.valueOf(subtractText));
                    } else {
                        subtract.setVisibility(View.GONE);
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getRedenvelopes())) {
                        redBao.setVisibility(View.VISIBLE);
                        redBao.setTag(shopDetailBean.getData().getRedenvelopes().get(0).getId());
                        redBao.setText(String.valueOf(shopDetailBean.getData().getRedenvelopes().get(0).getPrice_reduction()));
                    } else {
                        redBao.setVisibility(View.GONE);
                    }
                    if (StringUtils.isNotBlank(shopDetailBean.getData().getTel())) {
                        LogUtil.e(TAG, "tel:" + shopDetailBean.getData().getTel());
                        tel = shopDetailBean.getData().getTel();
                        callPhone.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                LogUtil.e(TAG, "click tel:" + shopDetailBean.getData().getTel());
                                AppUtil.callPhone(ShopActivity.this, shopDetailBean.getData().getTel());
                            }
                        });
                    }
                    if (shopDetailBean.getData().getIscollection() == 1) {
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
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getStrading())) {
                        List<String> tradingList = shopDetailBean.getData().getStrading();
                        StringBuilder tradingText = new StringBuilder();
                        if (tradingList.size() >= 2) {
                            tradingText.append(tradingList.get(0)).append("    ").append(tradingList.get(1)).append("等");
                        } else {
                            tradingText.append(tradingList.get(0));
                        }
                        tradingArea.setText(tradingText.toString());
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getService())) {
                        List<ShopDetailBean.DataBean.ServiceBean> serviceList = shopDetailBean.getData().getService();
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
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getHotdata())) {
                        hotProjectAdapter.replaceData(shopDetailBean.getData().getHotdata());
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getNewmemberdata())) {
                        newComerLayout.setVisibility(View.VISIBLE);
                        newComerAdapter.replaceData(shopDetailBean.getData().getNewmemberdata());
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getMemberdata())) {
                        memberLayout.setVisibility(View.VISIBLE);
                        memberAdapter.replaceData(shopDetailBean.getData().getMemberdata());
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getSpecialdata())) {
                        preferenceLayout.setVisibility(View.VISIBLE);
                        preferenceAdapter.replaceData(shopDetailBean.getData().getSpecialdata());
                    }
                    if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getBeautician())) {
                        meiRongShiAdapter.replaceData(shopDetailBean.getData().getBeautician());
                    }
                    if (shopDetailBean.getData().getCommentdata() != null && CollectionUtils.isNotEmpty(shopDetailBean.getData().getCommentdata().getAll())) {
                        commentSectionView.setVisibility(View.VISIBLE);
                        userCommentNum.setText(getString(R.string.home_comment_num_format, shopDetailBean.getData().getCommentdata().getCount()));
                        tvCommentPeer.setText(getString(R.string.home_comment_peer_format, shopDetailBean.getData().getPeer() + "%", shopDetailBean.getData().getSatisfaction() + "%"));
                        commentdata = shopDetailBean.getData().getCommentdata();
                        commentAdapter.replaceData(shopDetailBean.getData().getCommentdata().getAll());
                        if (CollectionUtils.isNotEmpty(shopDetailBean.getData().getCommentdata().getTags())) {
                            fillTags(shopDetailBean.getData().getCommentdata().getTags());
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
        } else {
            OkGo.<String>post(URLs.BEAUTICIAN_DETAILS).params("id", beauticianId).params("user_id", UserHelp.getUserId(this)).execute(new StringCallback() {
                @SuppressLint("StringFormatMatches")
                @Override
                public void onSuccess(Response<String> response) {
                    LogUtil.e(TAG, "beautician detail:" + response.body());
                    try {
                        JSONObject jsonObject = new JSONObject(response.body());
                        Object msg = jsonObject.opt("msg");
                        if (msg.equals("暂无数据")) {
                            multipleStatusView.showEmpty();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    multipleStatusView.showOutContentView(scrollLayout);
                    Gson gson = new Gson();
                    beauticianDetailBean = gson.fromJson(response.body(), BeauticianDetailBean.class);
                    ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + beauticianDetailBean.getData().getImage(), shop_detail_icon);
                    shopName.setText(beauticianDetailBean.getData().getName());
                    shopStar.setStarMark(beauticianDetailBean.getData().getStart());
                    tvOrderCount.setText(getString(R.string.shop_detail_server_number, beauticianDetailBean.getData().getOrder_count()));
                    tvCollectionCount.setText(getString(R.string.shop_detail_fensi_number, beauticianDetailBean.getData().getFriend_count()));
                    tvSatisfaction.setText(getString(R.string.shop_detail_satisfaction, beauticianDetailBean.getData().getSatisfaction() + "%"));
                    tvAddress.setText(beauticianDetailBean.getData().getAddress());
                    tvDistance.setText(getString(R.string.shop_detail_distance, beauticianDetailBean.getData().getDistance()));
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getCoupon())) {
                        coupon.setVisibility(View.VISIBLE);
                        coupon.setTag(beauticianDetailBean.getData().getCoupon().get(0).getId());
                        coupon.setText(String.valueOf(beauticianDetailBean.getData().getCoupon().get(0).getPrice_satisfy()));
                    } else {
                        coupon.setVisibility(View.GONE);
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getFull())) {
                        subtract.setVisibility(View.VISIBLE);
                        String name = beauticianDetailBean.getData().getFull().get(0).getName();
                        String[] split = name.split("减");
                        String subtractText = "-" + split[1] + "\n" + beauticianDetailBean.getData().getFull().get(0).getPrice_satisfy() + "元";
                        subtract.setTag(beauticianDetailBean.getData().getFull().get(0).getId());
                        subtract.setText(String.valueOf(subtractText));
                    } else {
                        subtract.setVisibility(View.GONE);
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getRedenvelopes())) {
                        redBao.setVisibility(View.VISIBLE);
                        redBao.setTag(beauticianDetailBean.getData().getRedenvelopes().get(0).getId());
                        redBao.setText(String.valueOf(beauticianDetailBean.getData().getRedenvelopes().get(0).getPrice_reduction()));
                    } else {
                        redBao.setVisibility(View.GONE);
                    }
                    if (beauticianDetailBean.getData().getIsfriend() == 1) {
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
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getStrading())) {
                        List<String> tradingList = beauticianDetailBean.getData().getStrading();
                        StringBuilder tradingText = new StringBuilder();
                        if (tradingList.size() >= 2) {
                            tradingText.append(tradingList.get(0)).append("    ").append(tradingList.get(1)).append("等");
                        } else {
                            tradingText.append(tradingList.get(0));
                        }
                        tradingArea.setText(tradingText.toString());
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getAuth())) {
                        List<String> authList = beauticianDetailBean.getData().getAuth();
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
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getHotdata())) {
                        hotProjectAdapter.replaceData(beauticianDetailBean.getData().getHotdata());
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getNewmemberdata())) {
                        newComerLayout.setVisibility(View.VISIBLE);
                        newComerAdapter.replaceData(beauticianDetailBean.getData().getNewmemberdata());
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getMemberdata())) {
                        memberLayout.setVisibility(View.VISIBLE);
                        memberAdapter.replaceData(beauticianDetailBean.getData().getMemberdata());
                    }
                    if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getSpecialdata())) {
                        preferenceLayout.setVisibility(View.VISIBLE);
                        preferenceAdapter.replaceData(beauticianDetailBean.getData().getSpecialdata());
                    }
                    if (beauticianDetailBean.getData().getCommentdata() != null && CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getCommentdata().getAll())) {
                        commentSectionView.setVisibility(View.VISIBLE);
                        tvCommentPeer.setText(getString(R.string.home_comment_peer_format, beauticianDetailBean.getData().getPeer() + "%", beauticianDetailBean.getData().getSatisfaction() + "%"));
                        userCommentNum.setText(getString(R.string.home_comment_num_format, beauticianDetailBean.getData().getCommentdata().getCount()));
                        commentAdapter.addData(beauticianDetailBean.getData().getCommentdata().getAll());
                        if (CollectionUtils.isNotEmpty(beauticianDetailBean.getData().getCommentdata().getTags())) {
                            fillTags(beauticianDetailBean.getData().getCommentdata().getTags());
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
        }

        initDatePicker(this);
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

        long timeInMillis = canlBean.getDataBean().get(0).getTimeInMillis();
        String timestamp = String.format("%010d", timeInMillis);
        timeData(Long.valueOf(timestamp));
        daySelectPosition = Long.valueOf(timestamp);
        LogUtil.d("ShopActivity", daySelectPosition + "");
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        id_recyclerview_horizontal.setLayoutManager(linearLayoutManager);
        dayAdapter = new DayCheckAdapter2(this, canlBean.getDataBean(), beauticianId);
        id_recyclerview_horizontal.setAdapter(dayAdapter);

        dayAdapter.setOnItemClickLitener(new DayCheckAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, TextView textView, int position) {
                long timeInMillis1 = canlBean.getDataBean().get(position).getTimeInMillis();
                String format = String.format("%010d", timeInMillis1);
                timeData(Long.valueOf(format));
                daySelectPosition = Long.valueOf(format);
            }
        });
    }

    /**
     * 填充评价标识
     *
     * @param result
     */
    private void fillTags(final List<CommentTagsBean> result) {
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

    @OnClick(R.id.show_select_time)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.show_select_time:

                startTimePicker.show(AppUtil.getFormatTime(System.currentTimeMillis()));
                break;

            default:

                break;
        }
    }


    /*
  初始化时间选择器
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
        }, "1950-01-01 00:00", "2050-01-01 00:00", "请设置开始时间"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        startTimePicker.showSpecificTime(false); // 显示时和分
        startTimePicker.setIsLoop(true); // 允许循环滚动
    }
}
