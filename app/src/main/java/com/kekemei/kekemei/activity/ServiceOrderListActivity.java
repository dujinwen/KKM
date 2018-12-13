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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.ServiceOrderListAdapter;
import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.bean.ServiceOrderListBean;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.ToastUtil;
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
 * 服务订单
 */
public class ServiceOrderListActivity extends BaseActivity {
    public static final int TAB_All = 0;
    private static final String KEY_TAB = "tab";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_share)
    ImageView iv_share;

    @BindView(R.id.tal_all)
    LinearLayout talAll;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.v_all)
    View vAll;

    @BindView(R.id.tal_wait_server)
    LinearLayout tabWaitServer;
    @BindView(R.id.tv_wait_server)
    TextView tvWaitServer;
    @BindView(R.id.v_wait_server)
    View vWaitServer;

    @BindView(R.id.tv_pingjia)
    TextView tvPingjia;
    @BindView(R.id.v_pingjia)
    View vPingjia;

    @BindView(R.id.tv_finish)
    TextView tvFinish;
    @BindView(R.id.v_finish)
    View vFinish;

    @BindView(R.id.tv_reply)
    TextView tvReply;
    @BindView(R.id.v_reply)
    View vReply;

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout refresh_layout;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    private ServiceOrderListAdapter jAdapter;
    private int targetId;

    public static void start(Context context) {
        Intent intent = new Intent(context, ServiceOrderListActivity.class);
        context.startActivity(intent);
    }

    public static void start(Context context, int tabIndex) {
        Intent intent = new Intent(context, ServiceOrderListActivity.class);
        intent.putExtra(KEY_TAB, tabIndex);
        context.startActivity(intent);
    }

    @Override
    protected View setTitleBar() {
        return toolbar;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_service_order_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        targetId = getIntent().getIntExtra(KEY_TAB, TAB_All);
        tv_title.setText("服务订单");
        iv_share.setImageResource(R.mipmap.search_btn);
        iv_share.setVisibility(View.VISIBLE);

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ServiceOrderListActivity.this);
        rvList.setLayoutManager(linearLayoutManager);
        jAdapter = new ServiceOrderListAdapter();
        rvList.setAdapter(jAdapter);
        jAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
                final List<ServiceOrderListBean> data = jAdapter.getData();
                long userId = UserHelp.getUserId(ServiceOrderListActivity.this);
                if (userId == -1L) {
                    LoginActivity.start(ServiceOrderListActivity.this);
                    return;
                }
                switch (view.getId()) {
                    case R.id.cancelOrder:
                        OkGo.<String>get(URLs.CANCEL_ORDER)
                                .params("user_id", userId)
                                .params("order_id", data.get(position).getId())
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response.body());
                                            Object msg = jsonObject.opt("msg");
                                            if (msg.equals("暂无数据")) {
                                                return;
                                            }
                                            loadData(true);
                                            ToastUtil.showToastMsg(ServiceOrderListActivity.this, "取消成功");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onError(Response<String> response) {
                                        super.onError(response);
                                        ToastUtil.showToastMsg(ServiceOrderListActivity.this, "取消失败");
                                    }
                                });
                        break;
                    case R.id.startService:
                    case R.id.acceptOrder:
                        OkGo.<String>get(URLs.ACCEPC_ORDER)
                                .params("user_id", userId)
                                .params("order_id", data.get(position).getId())
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response.body());
                                            Object msg = jsonObject.opt("msg");
                                            if (msg.equals("暂无数据")) {
                                                return;
                                            }
                                            ToastUtil.showToastMsg(ServiceOrderListActivity.this, "接单成功");
                                            loadData(true);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onError(Response<String> response) {
                                        super.onError(response);
                                        ToastUtil.showToastMsg(ServiceOrderListActivity.this, "接单失败");
                                    }
                                });
                        break;
                    case R.id.finishService:
                        OkGo.<String>get(URLs.OVER_ORDER)
                                .params("user_id", userId)
                                .params("order_id", data.get(position).getId())
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response.body());
                                            Object msg = jsonObject.opt("msg");
                                            if (msg.equals("暂无数据")) {
                                                return;
                                            }
                                            ToastUtil.showToastMsg(ServiceOrderListActivity.this, "订单完成");
                                            loadData(true);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onError(Response<String> response) {
                                        super.onError(response);
                                        ToastUtil.showToastMsg(ServiceOrderListActivity.this, "完成失败");
                                    }
                                });
                        break;
                    case R.id.replayComment:
                        ServiceOrderDetailActivity.start(ServiceOrderListActivity.this, jAdapter.getItem(position));
                        break;
                }
            }
        });
        jAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ServiceOrderListBean item = jAdapter.getItem(position);
                ServiceOrderDetailActivity.start(ServiceOrderListActivity.this, item);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        if (targetId == OrderListBean.ORDER_STATUS_TO_WAIT_SERVER) {
            onViewClicked(tabWaitServer);
        } else {
            onViewClicked(talAll);
        }
    }

    @OnClick({R.id.iv_share, R.id.tal_all, R.id.tal_wait_server,
            R.id.tal_finish, R.id.tal_pingjia, R.id.tal_reply})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.iv_share) {
            Intent intent = new Intent(this, OrderListSearchActivity.class);
            startActivity(intent);
            return;
        }
        if (view.getId() == R.id.tal_all || view.getId() == R.id.tal_wait_server || view.getId() == R.id.tal_reply
                || view.getId() == R.id.tal_finish || view.getId() == R.id.tal_pingjia) {
            setSelect(view.getId());
            return;
        }
    }

    private int jOrderStatus;
    private int page = 1;

    private void setSelect(int id) {
        tvAll.setSelected(id == R.id.tal_all);
        vAll.setVisibility(id == R.id.tal_all ? View.VISIBLE : View.INVISIBLE);

        tvWaitServer.setSelected(id == R.id.tal_wait_server);
        vWaitServer.setVisibility(id == R.id.tal_wait_server ? View.VISIBLE : View.INVISIBLE);

        tvFinish.setSelected(id == R.id.tal_finish);
        vFinish.setVisibility(id == R.id.tal_finish ? View.VISIBLE : View.INVISIBLE);

        tvPingjia.setSelected(id == R.id.tal_pingjia);
        vPingjia.setVisibility(id == R.id.tal_pingjia ? View.VISIBLE : View.INVISIBLE);

        tvReply.setSelected(id == R.id.tal_reply);
        vReply.setVisibility(id == R.id.tal_reply ? View.VISIBLE : View.INVISIBLE);

        switch (id) {
            case R.id.tal_all:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_ALL;
                break;
            case R.id.tal_reply:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_QUIT;
                break;
            case R.id.tal_wait_server:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_WAIT_SERVER;
                break;
            case R.id.tal_finish:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_FINISHED;
                break;
            case R.id.tal_pingjia:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_COMMENT;
                break;
        }
        loadData(true);
    }

    private boolean isRefresh = false;
    private boolean isLoadMore = false;

    private void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        page++;
        getData(jOrderStatus, page);
    }

    private void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            page = 1;
            showRefreshLoading(isRefresh);
        }
        getData(jOrderStatus, page);
    }

    public void getData(final int orderStatus, int pageNum) {
        long userId = UserHelp.getUserId(ServiceOrderListActivity.this);
        if (userId == -1L) {
            LoginActivity.start(ServiceOrderListActivity.this);
            return;
        }
        if (!isRefresh && !isLoadMore)
            multipleStatusView.showLoading();
        OkGo.<String>get(URLs.SERVICE_ORDER)
                .tag(this)
                .params("state", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
                .params("user_id", userId)
                .params("page", pageNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            String data = jsonObject.optString("data");
                            if (msg.equals("暂无数据") || StringUtils.isEmpty(data)) {
                                multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                                return;
                            }
                            multipleStatusView.showOutContentView(refresh_layout);
                            Gson gson = new Gson();
                            List<ServiceOrderListBean> orderListBean = gson.fromJson(data, new TypeToken<List<ServiceOrderListBean>>() {
                            }.getType());
                            if (isRefresh) {
                                showRefreshLoading(false);
                                jAdapter.replaceData(orderListBean);
                            } else {
                                refresh_layout.finishLoadMore();
                                jAdapter.addData(orderListBean);
                            }
                            if (orderListBean.size() < 10) {
                                refresh_layout.setEnableLoadMore(false);
                                addCantLoadMoreFooter(jAdapter);
                                jAdapter.loadMoreEnd();
                            } else {
                                jAdapter.loadMoreComplete();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAGE", response.message());
                        multipleStatusView.showError();
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

    private View footer;

    private void addCantLoadMoreFooter(BaseQuickAdapter adapter) {
        if (footer == null) {
            footer = LayoutInflater.from(this).inflate(R.layout.layout_list_no_more_footer, null);
            adapter.addFooterView(footer);
        }
    }
}
