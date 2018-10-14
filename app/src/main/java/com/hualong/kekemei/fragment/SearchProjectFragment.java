package com.hualong.kekemei.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.LogUtil;
import com.hualong.kekemei.Utills.MultipleStatusView;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.bean.DataBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 搜索-项目
 */
public class SearchProjectFragment extends Fragment {

    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private MyGridAdapter listAdapter;
    private int jPageNum = 1;

    private Unbinder unbinder;

    public static SearchProjectFragment newInstance() {
        SearchProjectFragment fragment = new SearchProjectFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_project, container, false);
        unbinder = ButterKnife.bind(this, view);

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData(false);
            }
        });
        multipleStatusView.showOutContentView(refresh_layout);

        refresh_layout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                loadData(true);
            }
        });
        refresh_layout.setRefreshHeader(new ClassicsHeader(getActivity()));
        refresh_layout.setEnableLoadMore(false);

        rv_list.setLayoutManager(new GridLayoutManager(getActivity().getBaseContext(), 2));
        listAdapter = new MyGridAdapter(getActivity().getBaseContext(), MyGridAdapter.HotdataBean);
        rv_list.setAdapter(listAdapter);

        listAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMoreData();
            }
        }, rv_list);

        return view;
    }

    private void loadData(boolean isRefresh) {
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData("", jPageNum);
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData("", jPageNum);
    }

    public void getData(final String keyword, int pageNum) {
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
//                        OrderListBean orderListBean = gson.fromJson(response.body(), OrderListBean.class);
//                        onResult(orderListBean);
//                        listAdapter.addData(homeBean.getData().getHotdata());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAGE", response.message());
                        onResultError(response);
                    }
                });
    }

    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }

    public void onResult(Object response) {
        if (!isLoadMore) {
            jPageNum++;

            /*if (null == response || null == orderListBean.getData() || orderListBean.getData().size() == 0) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                showData(orderListBean.getData());
            }

            if (null != response && jPageNum > orderListBean.getData().size())
                showLoadMoreEnd();
            else
                showLoadMoreComplete();*/
        } else {
            jPageNum++;
            /*OrderListBean orderListBean = (OrderListBean) response;
            loadMoreSuccess(orderListBean.getData());
            if (jPageNum > orderListBean.getData().size()) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }*/
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
        rv_list.scrollToPosition(0);
    }


    private boolean isOnDestory = false;

    @Override
    public void onDestroyView() {
        isOnDestory = true;
        super.onDestroyView();
        unbinder.unbind();
    }
}
