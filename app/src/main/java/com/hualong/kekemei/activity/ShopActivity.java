package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.EvaluateListAdapter;
import com.hualong.kekemei.adapter.MeiRongShiAdapter;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.CommentTagsBean;
import com.hualong.kekemei.bean.DetailEnum;
import com.hualong.kekemei.bean.EvaluateListBean;
import com.hualong.kekemei.bean.MeiRongShiListBean;
import com.hualong.kekemei.bean.ProjectListBean;
import com.hualong.kekemei.bean.ShopDetailBean;
import com.hualong.kekemei.utils.AppUtil;
import com.hualong.kekemei.utils.CollectionUtils;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * 店铺和美容师主页页面
 */
public class ShopActivity extends BaseActivity implements View.OnClickListener {
    private static final String EXTRA_KEY_BEAUTICIAN_ID = "beauticianId";
    private static final String EXTRA_KEY_ENUM_ID = "type";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_share)
    ImageView iv_share;

    @BindView(R.id.scrollLayout)
    ScrollView scrollLayout;

    @BindView(R.id.shop_detail_icon)
    ImageView shop_detail_icon;

    @BindView(R.id.shopName)
    TextView shopName;

    @BindView(R.id.shopStar)
    StarBar shopStar;

    @BindView(R.id.shopHome)
    RelativeLayout shopHome;
    @BindView(R.id.indicatorShopHome)
    ImageView indicatorShopHome;

    @BindView(R.id.hotProject)
    RelativeLayout hotProject;
    @BindView(R.id.indicatorHotProject)
    ImageView indicatorHotProject;

    @BindView(R.id.userEvaluate)
    RelativeLayout userEvaluate;
    @BindView(R.id.indicatorEvaluate)
    ImageView indicatorEvaluate;

    @BindView(R.id.contentView)
    LinearLayout contentView;



    private TextView userCommentNum;
    private TextView commentTabAll;
    private TextView commentTabNew;
    private TextView commentTabPhoto;
    private LinearLayout markLayout;
    private FlexboxLayout commentTagFlowLayout;
    private RecyclerView rvCommentList;

    private RecyclerView hotProjectRv;
    private String beauticianId;
    private MyGridAdapter contentSectionAdapter;
    private EvaluateListAdapter commentAdapter;
    private DetailEnum detailEnum;

    private MeiRongShiAdapter meiRongShiAdapter;
    @Nullable
    private LinearLayout ll_yuyue;
    private LinearLayout llSelectTime;

    public static void start(Context context, int beauticianId, DetailEnum detailEnum) {
        Intent intent = new Intent(context, ShopActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, String.valueOf(beauticianId));
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
        iv_share.setVisibility(View.VISIBLE);
        llSelectTime = (LinearLayout) findViewById(R.id.ll_select_time);
        indicatorShopHome.setVisibility(View.VISIBLE);

        View contentHead = View.inflate(this, R.layout.layout_detail_content_head, null);

        View contentSectionView = View.inflate(this, R.layout.layout_shop_content_section_view, null);

        View nearbySectionView = View.inflate(this, R.layout.section_layout_nearby_beautician, null);

        initNearbyView(nearbySectionView);

        View commentSectionView = View.inflate(this, R.layout.layout_comment_top_head, null);

        initCommentView(commentSectionView);

        hotProjectRv = contentSectionView.findViewById(R.id.sectionRv);
        ll_yuyue = contentHead.findViewById(R.id.ll_yuyue);
        ll_yuyue.setOnClickListener(this);
        hotProjectRv.setLayoutManager(new GridLayoutManager(this, 2));
        hotProjectRv.setHasFixedSize(true);
        hotProjectRv.setNestedScrollingEnabled(false);
        contentSectionAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        hotProjectRv.setAdapter(contentSectionAdapter);

        contentView.addView(contentHead);
        contentView.addView(contentSectionView);
        if (detailEnum == DetailEnum.SHOP) {
            contentView.addView(nearbySectionView);
        }
        contentView.addView(commentSectionView);
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
            R.id.commentTabAll,R.id.commentTabNew,
            R.id.commentTabPhoto,R.id.ll_yuyue})
    public void onClick(View view) {
        switch (view.getId()) {
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
                break;
            case R.id.commentTabNew:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(true);
                commentTabPhoto.setSelected(false);
                break;
            case R.id.commentTabPhoto:
                commentTabAll.setSelected(false);
                commentTabNew.setSelected(false);
                commentTabPhoto.setSelected(true);
                break;
            case R.id.ll_yuyue:
                llSelectTime.setVisibility(llSelectTime.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
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

    @Override
    protected void initData() {
        super.initData();
        OkGo.<String>post(URLs.SHOP_DETAILS).params("id", beauticianId).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ShopActivity", response.body());
                Gson gson = new Gson();
                ShopDetailBean shopDetailBean = gson.fromJson(response.body(), ShopDetailBean.class);
                ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + shopDetailBean.getData().getImage(), shop_detail_icon);
                tv_title.setText("克克美-" + shopDetailBean.getData().getName());
                shopName.setText(shopDetailBean.getData().getName());
                shopStar.setStarMark(shopDetailBean.getData().getStart());
            }
        });


        OkGo.<String>post(URLs.PROJECT_LIST).params("page", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ShopActivity", "project list:" + response.body());
                Gson gson = new Gson();
                ProjectListBean projectListBean = gson.fromJson(response.body(), ProjectListBean.class);
                contentSectionAdapter.replaceData(projectListBean.getData());
            }
        });

        if (detailEnum == DetailEnum.SHOP) {
            OkGo.<String>get(URLs.BEAUTICIAN_NEAR).params("longitude", 116.4072154982)
                    .params("latitude", 39.9047253699).params("page", "1").execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    LogUtil.d("MeiRongShiActivity", response.body());
                    Gson gson = new Gson();
                    MeiRongShiListBean meiRongShiListBean = gson.fromJson(response.body(), MeiRongShiListBean.class);
                    meiRongShiAdapter.addData(meiRongShiListBean.getData());
                }
            });
        }

        initCommentTags();

        OkGo.<String>post(URLs.COMMENT_LIST).params("page", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("ShopActivity", "project list:" + response.body());
                Gson gson = new Gson();
                EvaluateListBean evaluateListBean = gson.fromJson(response.body(), EvaluateListBean.class);
                userCommentNum.setText(getString(R.string.home_comment_num_format, evaluateListBean.getData().size()));
                commentAdapter.replaceData(evaluateListBean.getData());
            }
        });
    }

    private void initCommentTags() {
        OkGo.<String>post(URLs.COMMENT_TAG).params("type", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e("comment", "body:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        fillTags(null);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                CommentTagsBean commentTagsBean = gson.fromJson(response.body(), CommentTagsBean.class);
                fillTags(commentTagsBean.getData());
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                fillTags(null);
            }
        });
    }

    /**
     * 填充评价标识
     *
     * @param result
     */
    private void fillTags(final List<String> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        commentTagFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(this).inflate(R.layout.item_comment_tag_layout, commentTagFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i))) {
                txt.setText(result.get(i));
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

}
