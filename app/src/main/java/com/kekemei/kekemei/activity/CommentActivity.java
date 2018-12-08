package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.CommentListAdapter;
import com.kekemei.kekemei.bean.CommentListBean;
import com.kekemei.kekemei.bean.EvaluateBean;
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

public class CommentActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.commentTabNew)
    TextView commentTabNew;
    @BindView(R.id.commentTabOld)
    TextView commentTabOld;
    @BindView(R.id.rv_list)
    RecyclerView jRecyclerView;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout jSwipeRefreshLayout;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private CommentListAdapter jAdapter;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private int jPageNum = 1;

    public static void start(Context context) {
        Intent intent = new Intent(context, CommentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        commentTabNew.setSelected(true);

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
        multipleStatusView.showOutContentView(jSwipeRefreshLayout);

        jSwipeRefreshLayout.setRefreshHeader(new ClassicsHeader(this));
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
        jAdapter = new CommentListAdapter(this);
        jRecyclerView.setAdapter(jAdapter);

    }

    @OnClick({R.id.commentTabNew, R.id.commentTabOld})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commentTabNew:
                commentTabNew.setSelected(true);
                commentTabOld.setSelected(false);
                loadData(true);
                break;
            case R.id.commentTabOld:
                commentTabNew.setSelected(false);
                commentTabOld.setSelected(true);
                loadData(true);
                break;
        }
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
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData(jPageNum);
    }

    private void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData(jPageNum);
    }

    public void getData(int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        long userId = UserHelp.getUserId(this);
        if (userId == -1L) {
            LoginActivity.start(this);
            return;
        }
        OkGo.<String>get(URLs.BEAUTICIAN_COMMENT).params("beautician_id", userId)
                .params("page", pageNum).execute(new StringCallback() {
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
                    CommentListBean commentListBean = gson.fromJson(data, CommentListBean.class);
                    onResultSuccess(commentListBean);
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
            jPageNum++;
            CommentListBean commentListBean = (CommentListBean) response;

            if (null == response) {
                showEmpty();
            }
            fillData(commentTabNew.isSelected() ? commentListBean.getNewX() : commentListBean.getReply());
        } else {
            jPageNum++;
            CommentListBean commentListBean = (CommentListBean) response;
            loadMoreSuccess(commentTabNew.isSelected() ? commentListBean.getNewX() : commentListBean.getReply());
        }
    }

    private void fillData(List<EvaluateBean> listData) {
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

    private void showData(List<EvaluateBean> dataList) {
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

    private void loadMoreSuccess(List<EvaluateBean> dataList) {
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
