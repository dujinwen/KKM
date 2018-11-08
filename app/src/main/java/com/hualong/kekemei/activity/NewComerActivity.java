package com.hualong.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.adapter.FindOrderListAdapter;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.NewComerBean;
import com.hualong.kekemei.utils.CollectionUtils;
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.view.MultipleStatusView;
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 新人体验
 */
public class NewComerActivity extends BaseActivity {
    public static final String TAG = NewComerActivity.class.getSimpleName();
    private static final String EXTRA_KEY_USER_ID = "userId";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_share)
    ImageView iv_share;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.scrollContent)
    ScrollView scrollContent;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;
    @BindView(R.id.newPeopleList)
    RecyclerView newPeopleList;
    private FindOrderListAdapter listAdapter;

    @BindView(R.id.topBanner)
    ImageView topBanner;

    @BindView(R.id.allProjectLayout)
    LinearLayout allProjectLayout;
    @BindView(R.id.sectionAllRv)
    RecyclerView sectionAllRv;
    @BindView(R.id.lookMoreAll)
    TextView lookMoreAll;

    @BindView(R.id.forYouLayout)
    LinearLayout forYouLayout;
    @BindView(R.id.sectionForYouRv)
    RecyclerView sectionForYouRv;
    @BindView(R.id.lookMoreForYou)
    TextView lookMoreForYou;

    private MyGridAdapter allAdapter, forYouAdapter;

    private String userId;

    public static void start(Context context, String userId) {
        Intent intent = new Intent(context, NewComerActivity.class);
        intent.putExtra(EXTRA_KEY_USER_ID, userId);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_new_comer;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        userId = super.getStringExtraSecure(EXTRA_KEY_USER_ID);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setBackgroundColor(Color.parseColor("#00000000"));
        tv_title.setText("超值体验");
        iv_share.setVisibility(View.VISIBLE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

        multipleStatusView.showOutContentView(scrollContent);

        refresh_layout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
//                loadData(true);
            }
        });
        refresh_layout.setRefreshHeader(new ClassicsHeader(this));
        refresh_layout.setEnableLoadMore(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        newPeopleList.setLayoutManager(linearLayoutManager);
        listAdapter = new FindOrderListAdapter(getBaseContext());
        newPeopleList.setAdapter(listAdapter);

        sectionAllRv.setLayoutManager(new GridLayoutManager(this, 2));
        sectionAllRv.setHasFixedSize(true);
        sectionAllRv.setNestedScrollingEnabled(false);

        sectionForYouRv.setLayoutManager(new GridLayoutManager(this, 2));
        sectionForYouRv.setHasFixedSize(true);
        sectionForYouRv.setNestedScrollingEnabled(false);

        allAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        sectionAllRv.setAdapter(allAdapter);

        forYouAdapter = new MyGridAdapter(this, MyGridAdapter.HotdataBean);
        sectionForYouRv.setAdapter(forYouAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        multipleStatusView.showLoading();
        OkGo.<String>post(URLs.NEW_COMMER).params("user_id", userId).params("page", "1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "response:" + response.body());
                Gson gson = new Gson();
                NewComerBean newComerBean = gson.fromJson(response.body(), NewComerBean.class);
                if (newComerBean.getData().getIsnew() == 0) {
                    scrollContent.setVisibility(View.VISIBLE);
                    multipleStatusView.showOutContentView(scrollContent);
                    ImageLoaderUtil.getInstance().loadImage(URLs.BASE_URL + newComerBean.getData().getBanner().getImage(), topBanner);
                    if (CollectionUtils.isNotEmpty(newComerBean.getData().getProjectall())) {
                        allAdapter.replaceData(newComerBean.getData().getProjectall());
                        allAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                            /*BaseBean item = hotProjectAdapter.getItem(position);
                            ProjectDetailActivity.start(ShopActivity.this, item.getId());*/
                            }
                        });
                    }
                    if (CollectionUtils.isNotEmpty(newComerBean.getData().getForyou())) {
                        forYouAdapter.replaceData(newComerBean.getData().getForyou());
                        forYouAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                            /*BaseBean item = hotProjectAdapter.getItem(position);
                            ProjectDetailActivity.start(ShopActivity.this, item.getId());*/
                            }
                        });
                    }
                } else {
                    scrollContent.setVisibility(View.GONE);
                    multipleStatusView.showOutContentView(refresh_layout);
                    if (CollectionUtils.isNotEmpty(newComerBean.getData().getNewpopledata())) {
                        listAdapter.replaceData(newComerBean.getData().getNewpopledata());
                        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                            /*BaseBean item = hotProjectAdapter.getItem(position);
                            ProjectDetailActivity.start(ShopActivity.this, item.getId());*/
                            }
                        });
                    }
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                multipleStatusView.showError();
            }
        });
    }

    @OnClick({R.id.lookMoreAll, R.id.lookMoreForYou})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lookMoreAll:
                break;
            case R.id.lookMoreForYou:
                break;
        }
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }
}
