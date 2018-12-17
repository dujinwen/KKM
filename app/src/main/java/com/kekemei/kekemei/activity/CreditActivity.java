package com.kekemei.kekemei.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.CreditAdapter;
import com.kekemei.kekemei.bean.CreditBean;
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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 积分页面
 */

public class CreditActivity extends BaseActivity {
    @BindView(R.id.rv_jifen_list)
    RecyclerView rvJifenList;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    private CreditAdapter adapter;
    private TextView tv_jifennum;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_credit;
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
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

        multipleStatusView.showOutContentView(refresh_layout);
        refresh_layout.setRefreshHeader(new ClassicsHeader(this));
        refresh_layout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMoreData();
            }

            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                loadData(true);
            }
        });
        tvTitle.setText("我的积分");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter = new CreditAdapter();
        rvJifenList.setLayoutManager(new LinearLayoutManager(this));
        rvJifenList.setAdapter(adapter);
        rvJifenList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        View header_view = getLayoutInflater().inflate(R.layout.hear_jifen, (ViewGroup) rvJifenList.getParent(), false);
        adapter.addHeaderView(header_view);
        tv_jifennum = header_view.findViewById(R.id.tv_jifennum);

    }

    private boolean isRefresh = false;
    private boolean isLoadMore = false;

    private void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        page++;
        getData(page);
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            page = 1;
            showRefreshLoading(isRefresh);
        }
        getData(page);
    }

    private void getData(int page) {
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();


        OkGo.<String>post(URLs.MY_INTEGRAL).params("page", page)
                .params("user_id", UserHelp.getUserId(getApplicationContext()))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        LogUtil.d("CreditActivity", response.body());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            String data = jsonObject.optString("data");
                            if (msg.equals("暂无数据") || StringUtils.isEmpty(data)) {
                                multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                                return;
                            }
                            Gson gson = new Gson();
                            CreditBean creditBean = gson.fromJson(response.body(), CreditBean.class);

                            adapter.setNewData(creditBean.getData().getIntegral());
                            tv_jifennum.setText(creditBean.getData().getCount() + "");


                            multipleStatusView.showOutContentView(refresh_layout);
                            if (isRefresh) {
                                showRefreshLoading(false);
                                adapter.replaceData(creditBean.getData().getIntegral());
                            } else {
                                refresh_layout.finishLoadMore();
                                adapter.addData(creditBean.getData().getIntegral());
                            }
                            if (creditBean.getData().getIntegral().size() < 10) {
                                refresh_layout.setEnableLoadMore(false);
                                addCantLoadMoreFooter(adapter);
                                adapter.loadMoreEnd();
                            } else {
                                adapter.loadMoreComplete();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private View footer;
    private void addCantLoadMoreFooter(BaseQuickAdapter adapter) {
        if (footer == null) {
            footer = LayoutInflater.from(this).inflate(R.layout.layout_list_no_more_footer, null);
            adapter.addFooterView(footer);
        }
    }
    public void showRefreshLoading(boolean show) {
        if (show) {
            refresh_layout.refreshDrawableState();
        } else {
            refresh_layout.finishRefresh();
        }
    }

    private int page = 1;

    @Override
    protected void initData() {
        super.initData();
//        OkGo.<String>post(URLs.MY_INTEGRAL).params("page", 1)
//                .params("user_id", UserHelp.getUserId(getApplicationContext()))
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        LogUtil.d("CreditActivity", response.body());
//                        Gson gson = new Gson();
//                        CreditBean creditBean = gson.fromJson(response.body(), CreditBean.class);
//
//                        adapter.setNewData(creditBean.getData().getIntegral());
//                        tv_jifennum.setText(creditBean.getData().getCount() + "");
//                    }
//                });

//        jiFenBean.setZongfen("192929");
//        ArrayList<CreditBean.JIFEN> jifens = new ArrayList<>();
//        CreditBean.JIFEN e = new CreditBean.JIFEN();
//        for (int i = 0; i < 10; i++) {
//
//            e.setData("2019-12-12   12:30");
//            e.setPrice("+  10.00");
//            jifens.add(e);
//        }
//        jiFenBean.setJifens(jifens);
        loadData(true);
    }
}
