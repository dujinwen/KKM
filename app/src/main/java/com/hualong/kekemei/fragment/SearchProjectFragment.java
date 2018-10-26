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
import com.hualong.kekemei.utils.LogUtil;
import com.hualong.kekemei.view.MultipleStatusView;
import com.hualong.kekemei.utils.URLs;
import com.hualong.kekemei.adapter.MyGridAdapter;
import com.hualong.kekemei.bean.HotdataBean;
import com.hualong.kekemei.bean.SearchResultBean;
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

import static com.hualong.kekemei.activity.SearchActivity.EXTRA_KEY_KEYWORD;


/**
 * 搜索-项目
 */
public class SearchProjectFragment extends Fragment implements SearchIPage {

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

    private String keyWord = "";

    private boolean isOnEnter = false, isViewCreate = false;

    public static SearchProjectFragment newInstance(String keyWord) {
        SearchProjectFragment fragment = new SearchProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY_KEYWORD, keyWord);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        keyWord = getArguments().getString(EXTRA_KEY_KEYWORD);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
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

        isViewCreate = true;

        return view;
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            showRefreshLoading(isRefresh);
        }
        getData(keyWord, jPageNum);
    }

    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        getData(keyWord, jPageNum);
    }

    public void getData(final String keyword, int pageNum) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>post(URLs.INDEX_SEARCH)
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
                        SearchResultBean searchResultBean = gson.fromJson(response.body(), SearchResultBean.class);
                        onResult(searchResultBean);
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

            SearchResultBean searchResultBean = (SearchResultBean) response;

            if (null == response || null == searchResultBean.getData() || searchResultBean.getData().getProject().size() == 0) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                showData(searchResultBean.getData().getProject());
            }

            if (null != response && jPageNum > searchResultBean.getData().getProject().size())
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            SearchResultBean searchResultBean = (SearchResultBean) response;
            loadMoreSuccess(searchResultBean.getData().getProject());
            if (jPageNum > searchResultBean.getData().getProject().size()) {
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

    public void loadMoreSuccess(List<HotdataBean> dataList) {
        listAdapter.addData(dataList);
    }

    public void showLoadMoreEnd() {
        listAdapter.loadMoreEnd(false);
    }

    public void showLoadMoreComplete() {
        listAdapter.loadMoreComplete();
    }

    public void showData(List<HotdataBean> dataList) {
        if (isOnDestory)
            return;
        multipleStatusView.showOutContentView(refresh_layout);
        listAdapter.replaceData(dataList);
        rv_list.scrollToPosition(0);
    }


    private boolean isOnDestory = false;

    @Override
    public void onDestroyView() {
        isOnDestory = true;
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onEnter(String keyWord) {
        this.keyWord = keyWord;
        if (!isOnEnter) {
            isOnEnter = true;
            if (isViewCreate) {
                loadData(true);
            }
        }
    }

    @Override
    public void onLeave() {
        if (isOnEnter) {
            isOnEnter = false;
        }
    }
}
