package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.InComeListAdapter;
import com.kekemei.kekemei.bean.InComeBean;
import com.kekemei.kekemei.utils.CollectionUtils;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收入页面
 */
public class InComeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_submit)
    TextView tv_submit;
    @BindView(R.id.inComeCount)
    TextView inComeCount;
    @BindView(R.id.dateLeft)
    ImageView dateLeft;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.dateRight)
    ImageView dateRight;
    @BindView(R.id.inComeList)
    RecyclerView jRecyclerView;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout jSwipeRefreshLayout;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private InComeListAdapter jAdapter;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;

    private int year = 2018;

    public static void start(Context context) {
        Intent intent = new Intent(context, InComeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_in_come;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setBackgroundColor(Color.parseColor("#00000000"));
        tv_title.setText("收入");
        tv_submit.setText("收入规则");
        tv_submit.setVisibility(View.VISIBLE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebActivity.start(InComeActivity.this, URLs.ABOUS + 3);
            }
        });
        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        multipleStatusView.showOutContentView(jSwipeRefreshLayout);

        jSwipeRefreshLayout.setRefreshHeader(new ClassicsHeader(this));
        jSwipeRefreshLayout.setEnableLoadMore(false);
        jSwipeRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMoreData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData(true);
            }
        });

        jRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        jRecyclerView.setHasFixedSize(true);
        jRecyclerView.setNestedScrollingEnabled(false);
        jAdapter = new InComeListAdapter(this);
        jRecyclerView.setAdapter(jAdapter);

        date.setText(year + "");
    }

    @OnClick({R.id.dateLeft, R.id.dateRight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dateLeft:
                changeDate(false);
                break;
            case R.id.dateRight:
                changeDate(true);
                break;
        }
    }

    private void changeDate(boolean flag) {
        if (flag) {
            year++;
        } else {
            year--;
        }
        date.setText(year + "");
        initData();
    }

    @Override
    protected void initData() {
        multipleStatusView.showLoading();
        loadData(true);
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            showRefreshLoading(isRefresh);
        }
        getData(date.getText().toString());
    }

    private void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData(date.getText().toString());
    }

    public void getData(String year) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        long userId = UserHelp.getUserId(this);
        if (userId == -1L) {
            LoginActivity.start(this);
            return;
        }
        OkGo.<String>get(URLs.BEAUTICIAN_PAY).params("beautician_id", userId)
                .params("year", year).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    String data = jsonObject.optString("data");
                    if (msg.equals("暂无数据") || StringUtils.isEmpty(data)) {
                        jSwipeRefreshLayout.finishLoadMore();
                        return;
                    }
                    Gson gson = new Gson();
                    InComeBean inComeBean = gson.fromJson(data, InComeBean.class);
                    if (inComeBean != null) {
                        inComeCount.setText("￥" + inComeBean.getSum());
                        onResultSuccess(inComeBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                onResultError(response);
            }
        });
    }

    private void onResultSuccess(Object response) {
        if (!isLoadMore) {
            InComeBean inComeBean = (InComeBean) response;

            if (null == response) {
                showEmpty();
            }
            fillData(inComeBean.getInfo());
        } else {
            InComeBean inComeBean = (InComeBean) response;
            loadMoreSuccess(inComeBean.getInfo());
        }
    }

    private void fillData(List<InComeBean.InfoBeanX> listData) {
        if (CollectionUtils.isEmpty(listData)) {
            showEmpty();
        } else {
            if (isRefresh)
                showRefreshLoading(false);
            showData(listData);
        }
        if (listData.size() < 10)
            showLoadMoreEnd();
        else
            showLoadMoreComplete();
    }

    private void onResultError(Object response) {
        if (!isRefresh && !isLoadMore)
            showError();
        if (isLoadMore)
            showLoadMoreFailed();
        if (isRefresh)
            showRefreshLoading(false);
    }

    private void showRefreshLoading(boolean show) {
        if (show) {
            jSwipeRefreshLayout.refreshDrawableState();
        } else {
            jSwipeRefreshLayout.finishRefresh();
        }
    }

    private void showData(List<InComeBean.InfoBeanX> dataList) {
        if (isOnDestroy)
            return;
        multipleStatusView.showOutContentView(jSwipeRefreshLayout);
        jAdapter.replaceData(dataList);
        jRecyclerView.scrollToPosition(0);
    }

    private void showEmpty() {
        multipleStatusView.showEmpty();
    }

    private void showError() {
        multipleStatusView.showError();
    }

    private void showNoNetwork() {
        multipleStatusView.showNoNetwork();
    }

    private void loadMoreSuccess(List<InComeBean.InfoBeanX> dataList) {
        jSwipeRefreshLayout.finishLoadMore();
        jAdapter.addData(dataList);
        if (dataList.size() < 10) {
            showLoadMoreEnd();
        } else {
            showLoadMoreComplete();
        }
    }

    private void showLoadMoreFailed() {
        jAdapter.loadMoreFail();
    }

    private void showLoadMoreEnd() {
        jSwipeRefreshLayout.setEnableLoadMore(false);
        addCantLoadMoreFooter(jAdapter);
        jAdapter.loadMoreEnd(false);
    }

    private void showLoadMoreComplete() {
        jAdapter.loadMoreComplete();
    }

    private boolean isOnDestroy = false;

    @Override
    public void onDestroy() {
        isOnDestroy = true;
        super.onDestroy();
    }

    private View footer;

    private void addCantLoadMoreFooter(BaseQuickAdapter adapter) {
        if (footer == null) {
            footer = LayoutInflater.from(this).inflate(R.layout.layout_list_no_more_footer, null);
            adapter.addFooterView(footer);
        }
    }
}
