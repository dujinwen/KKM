package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.ProjectListBean;
import com.hualong.kekemei.bean.ShopDetailBean;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.StarBar;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置页面
 */
public class ShopActivity extends BaseActivity {
    private static final String EXTRA_KEY_BEAUTICIAN_ID = "beauticianId";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;

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

    private RecyclerView hotProjectRv;
    private String beauticianId;
    private MyGridAdapter contentSectionAdapter;

    public static void start(Context context, int beauticianId) {
        Intent intent = new Intent(context, ShopActivity.class);
        intent.putExtra(EXTRA_KEY_BEAUTICIAN_ID, String.valueOf(beauticianId));
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_shop;
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

        indicatorShopHome.setVisibility(View.VISIBLE);

        View contentHead = View.inflate(this, R.layout.layout_detail_content_head, null);

        View contentSectionView = View.inflate(this, R.layout.layout_shop_content_section_view, null);

        hotProjectRv = contentSectionView.findViewById(R.id.sectionRv);
        hotProjectRv.setLayoutManager(new GridLayoutManager(this, 2));
        hotProjectRv.setHasFixedSize(true);
        hotProjectRv.setNestedScrollingEnabled(false);
        contentSectionAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        hotProjectRv.setAdapter(contentSectionAdapter);

        contentView.addView(contentHead);
        contentView.addView(contentSectionView);
    }

    @OnClick({R.id.shopHome, R.id.hotProject, R.id.userEvaluate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopHome:
                indicatorShopHome.setVisibility(View.VISIBLE);
                indicatorHotProject.setVisibility(View.GONE);
                indicatorEvaluate.setVisibility(View.GONE);
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
                break;
        }
    }

    private void scrollTo(final View view) {
        LogUtil.e("ShopActivity", "scrollTo");
        scrollLayout.post(new Runnable() {
            @Override
            public void run() {
                //To change body of implemented methods use File | Settings | File Templates.
//                    mRootScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                int offset = location[1] - view.getMeasuredHeight();
                LogUtil.e("ShopActivity", "scrollTo:" + offset);
                if (offset < 0) {
                    offset = -offset;
                }
                scrollLayout.smoothScrollTo(0, offset);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        OkGo.<String>post(URLs.SHOP_DETAIL).params("id", beauticianId).execute(new StringCallback() {
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
    }
}
