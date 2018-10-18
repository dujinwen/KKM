package com.hualong.kekemei.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.AppUtil;
import com.hualong.kekemei.Utills.CollectionUtils;
import com.hualong.kekemei.Utills.LogUtil;
import com.hualong.kekemei.Utills.MultipleStatusView;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.DataBean;
import com.hualong.kekemei.bean.OrderListBean;
import com.hualong.kekemei.bean.SearchHistoryBean;
import com.hualong.kekemei.adapter.OrderListAdapter;
import com.hualong.kekemei.manager.SearchHistoryManager;
import com.hualong.kekemei.view.XEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListSearchActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.editTextSearch)
    XEditText editTextSearch;
    @BindView(R.id.txtSearch)
    TextView txtSearch;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_order_list_search)
    RecyclerView rvOrderListSearch;
    @BindView(R.id.layoutHistoryFlowLayout)
    FlexboxLayout layoutHistoryFlowLayout;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;
    private SearchHistoryManager searchHistoryManager;
    private static final int historyMax = 10;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private int jPageNum = 1;
    private OrderListAdapter listAdapter;

    @Override
    protected int setLayoutId() {
        return R.layout.order_list_search_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }


    @Override
    protected void initData() {

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData(false);
            }
        });
        multipleStatusView.showOutContentView(refresh_layout);
        initSearchHistoryArea();
        listAdapter = new OrderListAdapter(this);
        rvOrderListSearch.setLayoutManager(new LinearLayoutManager(this));
        rvOrderListSearch.setAdapter(listAdapter);
        txtSearch.setOnClickListener(this);
    }

    private void loadData(boolean isRefresh) {
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData("", jPageNum);
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData("", jPageNum);
    }


    /**
     * 初始化历史搜索区域
     */
    @SuppressWarnings("ConstantConditions")
    private void initSearchHistoryArea() {
        searchHistoryManager = SearchHistoryManager.getInstance(this, historyMax);
        searchHistoryManager.setOnSearchListener(new SearchHistoryManager.OnSearchListener() {
            @Override
            public void onSortSuccess(ArrayList<SearchHistoryBean> results) {
                fillHistoryWordArea(results);
            }
        });
        searchHistoryManager.sortHistory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchHistoryManager.setOnSearchListener(null);
    }

    /**
     * 填充历史搜索区域
     *
     * @param result 本地保存的历史搜索内容
     */
    private void fillHistoryWordArea(final ArrayList<SearchHistoryBean> result) {
        if (CollectionUtils.isEmpty(result)) {
            return;
        }
        layoutHistoryFlowLayout.removeAllViews();
        for (int i = 0; i < result.size(); i++) {
            final TextView txt = (TextView) LayoutInflater.from(this).inflate(R.layout.item_search_history_item, layoutHistoryFlowLayout, false);
            if (!AppUtil.isEmptyString(result.get(i).getContent())) {
                txt.setText(result.get(i).getContent());
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = txt.getText().toString();
                        searchHistoryManager.save(content);
                    }
                });
                layoutHistoryFlowLayout.addView(txt);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtSearch:
                llHistory.setVisibility(View.GONE);
                refresh_layout.setVisibility(View.VISIBLE);
                getData("", jPageNum);
                break;

            default:

                break;
        }
    }

    private void getData(final String keyword, int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.SEARCH)
                .tag(this)
                .params("keyword", keyword)
                .params("page", pageNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.e("Search", "body:" + response.body());
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
                        OrderListBean orderListBean = gson.fromJson(response.body(), OrderListBean.class);
                        onResult(orderListBean);
                        //                        listAdapter.addData(homeBean.getData().getHotdata());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAGE", response.message());
                        onResultError(response);
                    }
                });
    }

    public void onResult(Object response) {
        if (!isLoadMore) {
            jPageNum++;
            OrderListBean orderListBean = (OrderListBean) response;

            if (null == response || null == orderListBean.getData() || orderListBean.getData().size() == 0) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                showData(orderListBean.getData());
            }

            if (null != response && jPageNum > orderListBean.getData().size())
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            OrderListBean orderListBean = (OrderListBean) response;
            loadMoreSuccess(orderListBean.getData());
            if (jPageNum > orderListBean.getData().size()) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    public void onResultError(Object response) {
        if (!isRefresh && !isLoadMore)
            showError();
        if (isLoadMore)
            showLoadMoreFailed();
        if (isRefresh)
            showRefreshLoading(false);
    }

    public void showError() {
        multipleStatusView.showError();
    }

    public void showEmpty() {
        multipleStatusView.showEmpty();
    }

    public void showLoadMoreFailed() {
        listAdapter.loadMoreFail();
    }

    public void loadMoreSuccess(List<DataBean> dataList) {
        //        listAdapter.addData(dataList);
    }

    public void showLoadMoreEnd() {
        listAdapter.loadMoreEnd(false);
    }

    public void showLoadMoreComplete() {
        listAdapter.loadMoreComplete();
    }

    public void showData(List<DataBean> dataList) {
        if (isOnDestory)
            return;
        multipleStatusView.showOutContentView(refresh_layout);
        //        listAdapter.setNewData(dataList);
        rvOrderListSearch.scrollToPosition(0);
    }

    private boolean isOnDestory = false;
}
