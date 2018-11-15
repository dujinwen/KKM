package com.kekemei.kekemei.activity;

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
import com.jcloud.image_loader_module.ImageLoaderUtil;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.FindOrderListAdapter;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.NewComerBean;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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
    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private int jPageNum = 1;

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
                loadData(true);
            }
        });
        refresh_layout.setRefreshHeader(new ClassicsHeader(this));
        refresh_layout.setEnableLoadMore(true);
        refresh_layout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMoreData();
            }
        });
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
        loadData(true);
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

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData(jPageNum);
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData(jPageNum);
    }

    private void getData(int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.PROJECT_NEW_PEOPLE).params("user_id", userId).params("page", pageNum).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                LogUtil.e(TAG, "response:" + response.body());
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        onResult(null);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                NewComerBean newComerBean = gson.fromJson(response.body(), NewComerBean.class);
                onResult(newComerBean);
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                onResultError(response);
            }
        });
    }

    public void onResult(Object response) {
        if (!isLoadMore) {
            jPageNum++;

            NewComerBean newComerBean = (NewComerBean) response;

            if (null == response || null == newComerBean.getData()) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
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
                                BaseBean item = allAdapter.getItem(position);
                                ProjectDetailActivity.start(NewComerActivity.this, item.getId());
                            }
                        });
                    }
                    if (CollectionUtils.isNotEmpty(newComerBean.getData().getForyou())) {
                        forYouAdapter.replaceData(newComerBean.getData().getForyou());
                        forYouAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                                BaseBean item = forYouAdapter.getItem(position);
                                ProjectDetailActivity.start(NewComerActivity.this, item.getId());
                            }
                        });
                    }
                } else {
                    toolbar.setBackgroundColor(Color.parseColor("#7AD2D2"));
                    scrollContent.setVisibility(View.GONE);
                    multipleStatusView.showOutContentView(refresh_layout);
                    if (CollectionUtils.isNotEmpty(newComerBean.getData().getNewpopledata())) {
                        listAdapter.replaceData(newComerBean.getData().getNewpopledata());
                        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                LogUtil.e("section", "click:" + position);
                                BaseBean item = listAdapter.getItem(position);
                                ProjectDetailActivity.start(NewComerActivity.this, item.getId());
                            }
                        });
                    }
                }
            }

            if (null != response && newComerBean.getData().getNewpopledata().size() < 10)
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            NewComerBean newComerBean = (NewComerBean) response;
            loadMoreSuccess(newComerBean.getData().getNewpopledata());
            if (newComerBean.getData().getNewpopledata().size() < 10) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    public void onResultError(Object response) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showError();
        if (isLoadMore)
            listAdapter.loadMoreFail();
        if (isRefresh)
            showRefreshLoading(false);
    }

    public void showEmpty() {
        multipleStatusView.showEmpty();
    }

    public void loadMoreSuccess(List<BaseBean> dataList) {
        refresh_layout.finishLoadMore();
        listAdapter.addData(dataList);
    }

    public void showLoadMoreEnd() {
        listAdapter.loadMoreEnd(false);
    }

    public void showLoadMoreComplete() {
        listAdapter.loadMoreComplete();
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }
}
