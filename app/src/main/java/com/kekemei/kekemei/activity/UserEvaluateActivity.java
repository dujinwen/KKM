package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.adapter.EvaluateListAdapter;
import com.kekemei.kekemei.bean.EvaluateBean;
import com.kekemei.kekemei.bean.EvaluateListBean;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.IndictorWithNumber;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 用户评价
 */
public class UserEvaluateActivity extends BaseActivity implements IndictorWithNumber.TabChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.indictor_tabs)
    IndictorWithNumber jIndictorWithNumber;
    @BindView(R.id.rv_list)
    RecyclerView jRecyclerView;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout jSwipeRefreshLayout;
    @BindView(R.id.view_pager)
    ViewPager jViewPager;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    private EvaluateListAdapter jAdapter;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;

    private int jPageNum = 1;
    private int tabPosition = -1;


    public static final int EVALUATE_STATUS_ALL = -10;     //全部
    public static final int EVALUATE_STATUS_QUITE_SATISFACTION = 0; //超出期待
    public static final int EVALUATE_STATUS_SATISFACTION = 1;     //满意
    public static final int EVALUATE_STATUS_BASICALLY_SATISFACTION = 2; //基本满意
    public static final int EVALUATE_STATUS_DISSATISFIED = 3;      //不满意

    private boolean isMyComment;//是否是我的评价

    public static void start(Context context, boolean isMyComment) {
        Intent intent = new Intent(context, UserEvaluateActivity.class);
        intent.putExtra("isMyComment", isMyComment);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_user_evaluate;
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        isMyComment = getIntent().getBooleanExtra("isMyComment", false);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title.setText(isMyComment ? "我的评价" : "客户评价");

        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData(false);
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

        jAdapter = new EvaluateListAdapter(this, isMyComment);

        jRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        jAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });

        jRecyclerView.setAdapter(jAdapter);

        jIndictorWithNumber.setTabChangeListener(this);
        loadData(true);
    }

    public void getData(int pageNum) {
        onRequestStart();
        OkGo.<String>get(URLs.COMMENT_LIST)
                .tag(this)/*.params("shop_id", "1").params("user_id", UserHelp.getUserId(this))
                .params("beautician_id", "1").params("project_id", "1")*/
                .params("page", pageNum).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.body());
                    Object msg = jsonObject.opt("msg");
                    if (msg.equals("暂无数据")) {
                        onResultSuccess(null);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                EvaluateListBean evaluateListBean = gson.fromJson(response.body(), EvaluateListBean.class);
                onResultSuccess(evaluateListBean);
            }

            @Override
            public void onError(Response<String> response) {
                LogUtil.e("TAG", response.message());
                onResultError(response);
            }
        });
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

    private void reloadData(int position) {
        isLoadMore = false;
        isRefresh = false;
        if (position == tabPosition)
            return;
        else {
            jPageNum = 1;
            getData(jPageNum);
            showLoading();
        }
    }

    private void onRequestStart() {
        if (!isRefresh && !isLoadMore)
            showLoading();
    }

    private void onResultSuccess(Object response) {
        if (!isLoadMore) {
            jPageNum++;
            EvaluateListBean evaluateListBean = (EvaluateListBean) response;
            refreshTabMod(evaluateListBean);

            if (null == response || null == evaluateListBean.getData() || evaluateListBean.getData().size() == 0) {
                showEmpty();
            } else {
                if (isRefresh)
                    showRefreshLoading(false);
                showData(evaluateListBean.getData());
            }

            if (null != response && jPageNum > evaluateListBean.getData().size())
                showLoadMoreEnd();
            else
                showLoadMoreComplete();
        } else {
            jPageNum++;
            EvaluateListBean evaluateListBean = (EvaluateListBean) response;
            loadMoreSuccess(evaluateListBean.getData());
            if (jPageNum > evaluateListBean.getData().size()) {
                showLoadMoreEnd();
            } else {
                showLoadMoreComplete();
            }
        }
    }

    private void onResultError(Object response) {
        if (!isRefresh && !isLoadMore)
            showError();
        if (isLoadMore)
            showLoadMoreFailed();
        if (isRefresh)
            showRefreshLoading(false);
    }

    private void showLoading() {
        multipleStatusView.showLoading();
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
    }

    private void showLoadMoreFailed() {
        jAdapter.loadMoreFail();
    }

    private void showLoadMoreEnd() {
        jAdapter.loadMoreEnd(false);
    }

    private void showLoadMoreComplete() {
        jAdapter.loadMoreComplete();
    }

    @Override
    public void onTabSelected(int position) {
        jSwipeRefreshLayout.finishRefresh();
        reloadData(position);
    }

    private IndictorWithNumber.TabModele tabModele;

    private void refreshTabMod(EvaluateListBean evaluateListBean) {
        if (null == tabModele) {
            IndictorWithNumber.TabModele titleModle = new IndictorWithNumber.TabModele();
            ArrayList<IndictorWithNumber.TabModele.TitleNumber> list = new ArrayList<>();
            IndictorWithNumber.TabModele.TitleNumber item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "全部";
            item.status = EVALUATE_STATUS_ALL;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "超出期待";
            item.status = EVALUATE_STATUS_QUITE_SATISFACTION;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "满意";
            item.status = EVALUATE_STATUS_SATISFACTION;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "基本满意";
            item.status = EVALUATE_STATUS_BASICALLY_SATISFACTION;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "不满意";
            item.status = EVALUATE_STATUS_DISSATISFIED;
            list.add(item);

            titleModle.setTitleNumList(list);
            tabModele = titleModle;
            titleModle.setCurrentItem(getTabIndex());
        } else {
            for (IndictorWithNumber.TabModele.TitleNumber item : tabModele.getTitleNumList()) {
                item.count = getTabNumber(item.status, evaluateListBean);
            }
        }
        showIndictor(tabModele);
    }

    private int getTabNumber(int status, EvaluateListBean orderListBean) {
        //        if (status == OrderListBean.EVALUATE_STATUS_TO_BE_DELIVERED)
        //            return orderListBean.getStayDeliverNum();
        //        if (status == OrderListBean.EVALUATE_STATUS_TO_BE_PAID)
        //            return orderListBean.getStayPayNum();
        return 0;
    }

    private int getTabIndex() {
        int index = 0;
        int i = 0;
        for (IndictorWithNumber.TabModele.TitleNumber item : tabModele.getTitleNumList()) {
            /*if (jOrderStatus == item.status) {
                index = i;
            }
            i++;*/
        }
        return index;
    }

    private void showIndictor(IndictorWithNumber.TabModele titleModle) {
        if (null == jViewPager.getAdapter() && !isOnDestroy && getFragmentManager() != null) {
            jViewPager.setAdapter(new IndictorWithNumber.MyPagerAdapter(getFragmentManager(), titleModle));
        }
        jIndictorWithNumber.setViewPager(jViewPager, titleModle);
        jIndictorWithNumber.setVisibility(View.VISIBLE);
    }

    private boolean isOnDestroy = false;

    @Override
    public void onDestroy() {
        isOnDestroy = true;
        super.onDestroy();
    }
}
