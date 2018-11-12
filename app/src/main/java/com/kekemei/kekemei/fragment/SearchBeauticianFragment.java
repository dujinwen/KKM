package com.kekemei.kekemei.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.ProjectDetailActivity;
import com.kekemei.kekemei.activity.PushOrderActivity;
import com.kekemei.kekemei.activity.ShopActivity;
import com.kekemei.kekemei.adapter.MeiRongShiListAdapter;
import com.kekemei.kekemei.bean.BeauticianBean;
import com.kekemei.kekemei.bean.DetailEnum;
import com.kekemei.kekemei.bean.SearchResultBean;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
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

import static com.kekemei.kekemei.activity.SearchActivity.EXTRA_KEY_KEYWORD;


/**
 * 搜索-美容师
 */
public class SearchBeauticianFragment extends Fragment implements SearchIPage {

    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;
    private MeiRongShiListAdapter listAdapter;
    private int jPageNum = 1;

    private Unbinder unbinder;

    private String keyWord = "";

    private boolean isOnEnter = false, isViewCreate = false;

    public static SearchBeauticianFragment newInstance(String keyWord) {
        SearchBeauticianFragment fragment = new SearchBeauticianFragment();
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

        rv_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAdapter = new MeiRongShiListAdapter(getActivity(), R.layout.list_shop, null);
        rv_list.setAdapter(listAdapter);

        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                BeauticianBean beauticianBean = (BeauticianBean) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.ll_meirongshi:
                        ShopActivity.start(getActivity(), beauticianBean.getId(),
                                beauticianBean.getUser_id(), DetailEnum.BEAUTICIAN);
                        break;
                    case R.id.btn_buy_now:
//                        OkGo.<String>get(URLs.ORDER_GENERATING)
//                                .params("user_id", UserHelp.getUserId(getActivity()))
//                                .params("name", beauticianBean.getName())
//                                .params("project_id",beauticianBean.getId())
//                                .params("count",1)
//                                .execute(new StringCallback() {
//                                    @Override
//                                    public void onSuccess(Response<String> response) {
//
//                                    }
//                                });
                        Intent intent = new Intent(getActivity(), PushOrderActivity.class);
                        intent.putExtra(PushOrderActivity.IMAGE_URL,beauticianBean.getImage());
                        intent.putExtra(PushOrderActivity.ORDER_NAME,beauticianBean.getName());
//                        intent.putExtra(PushOrderActivity.ORDER_PRICE,beauticianBean.getPrice_newmember());
                        intent.putExtra(PushOrderActivity.PROJECT_ID,beauticianBean.getOrder());
                        startActivity(intent);
                        break;
                }
            }
        });
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
                .params("user_id", UserHelp.getUserId(getActivity()))
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

            if (null == response || null == searchResultBean.getData() || searchResultBean.getData().getBeautician().size() == 0) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                showData(searchResultBean.getData().getBeautician());
            }

            if (null != response && jPageNum > searchResultBean.getData().getBeautician().size())
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            SearchResultBean searchResultBean = (SearchResultBean) response;
            loadMoreSuccess(searchResultBean.getData().getBeautician());
            if (jPageNum > searchResultBean.getData().getBeautician().size()) {
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

    public void loadMoreSuccess(List<BeauticianBean> dataList) {
        listAdapter.addData(dataList);
    }

    public void showLoadMoreEnd() {
        listAdapter.loadMoreEnd(false);
    }

    public void showLoadMoreComplete() {
        listAdapter.loadMoreComplete();
    }

    public void showData(List<BeauticianBean> dataList) {
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