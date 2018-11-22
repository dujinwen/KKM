package com.kekemei.kekemei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.adapter.ServiceOrderListAdapter;
import com.kekemei.kekemei.bean.BaseBean;
import com.kekemei.kekemei.bean.ForYouBean;
import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.bean.ServiceOrderListBean;
import com.kekemei.kekemei.bean.YuYueActivityBean;
import com.kekemei.kekemei.utils.EndLessOnScrollListener;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.StringUtils;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 服务订单
 */
public class ServiceOrderListActivity extends BaseActivity {
    @BindView(R.id.tabAll)
    LinearLayout tabAll;
    @BindView(R.id.tvAll)
    TextView tvAll;
    @BindView(R.id.vAll)
    View vAll;

    @BindView(R.id.tvAppointment)
    TextView tvAppointment;
    @BindView(R.id.vAppointment)
    View vAppointment;

    @BindView(R.id.tvNotStart)
    TextView tvNotStart;
    @BindView(R.id.vNotStart)
    View vNotStart;

    @BindView(R.id.tvGoing)
    TextView tvGoing;
    @BindView(R.id.vGoing)
    View vGoing;

    @BindView(R.id.tvFinished)
    TextView tvFinished;
    @BindView(R.id.vFinished)
    View vFinished;

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    private ServiceOrderListAdapter jAdapter;
    private RecyclerView rvForYou;

    private MyGridAdapter forYouAdapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, ServiceOrderListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_service_order_list;
    }

    @Override
    protected void initData() {
        super.initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ServiceOrderListActivity.this);
        rvList.setLayoutManager(linearLayoutManager);
        jAdapter = new ServiceOrderListAdapter(ServiceOrderListActivity.this);
        rvList.setAdapter(jAdapter);
        jAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
                final List<ServiceOrderListBean> data = jAdapter.getData();
                switch (view.getId()) {
                    case R.id.iv_del_order:
                        long userId = UserHelp.getUserId(ServiceOrderListActivity.this);
                        if (userId == -1L) {
                            LoginActivity.start(ServiceOrderListActivity.this);
                            return;
                        }
                        OkGo.<String>get(URLs.DEL_ORDER)
                                .params("user_id", userId)
                                .params("order_id", data.get(position).getId())
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        data.remove(position);
                                        jAdapter.notifyDataSetChanged();
                                    }
                                });
                        break;
                    case R.id.lijifukuan:
                        YuYueActivityBean yuYueActivityBean = new YuYueActivityBean();
                        yuYueActivityBean.setDateSelect(-1L);
                        yuYueActivityBean.setTimeSelect(-1);
                        yuYueActivityBean.setOrderPrice(data.get(position).getPrice());
                        yuYueActivityBean.setOrderCount(data.get(position).getCount());
                        yuYueActivityBean.setOrderIconUrl(data.get(position).getImage());
                        yuYueActivityBean.setOrderName(data.get(position).getName());
                        PayActivity.start(ServiceOrderListActivity.this, yuYueActivityBean);
                        break;
                    case R.id.chakan:
                        OrderDetailActivity.start(ServiceOrderListActivity.this, data.get(position).getId());
                        break;
                    case R.id.zaicigoumai:
                        ProjectDetailActivity.start(ServiceOrderListActivity.this, data.get(position).getProject_project_id());
                        break;
                    case R.id.qupingjia:
//                        UserEvaluateActivity.start(ServiceOrderListActivity.this, false, item.getShop_shop_id() + "",
                        //                                item.getBeautician_beautician_id() + "",
                        //                                item.getProject_project_id() + "");
//                        AddCommentActivity.start(ServiceOrderListActivity.this,item.getSource(),item.getId()+"");
                        break;
                    case R.id.yuyue:
                        break;
                }
            }
        });
        jAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                OrderListBean.DataBean item = (OrderListBean.DataBean) adapter.getItem(position);
                ProjectDetailActivity.start(ServiceOrderListActivity.this, item.getProject_project_id());
            }
        });

        rvList.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        onViewClicked(tabAll);

        addHotProject();

        getForYouInfo();
    }

    private void getForYouInfo() {
        OkGo.<String>get(URLs.FOR_YOU).params("page", 1).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                ForYouBean forYouBean = gson.fromJson(response.body(), ForYouBean.class);
                forYouAdapter.replaceData(forYouBean.getData());
                if (forYouAdapter.getData().size() > 0) {
                    footView.setVisibility(View.VISIBLE);
                } else {
                    footView.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.iv_search, R.id.tabAll, R.id.tabAppointment, R.id.tabNotStart, R.id.tabGoing, R.id.tabFinished})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.iv_search) {
            Intent intent = new Intent(ServiceOrderListActivity.this, OrderListSearchActivity.class);
            startActivity(intent);
            return;
        }
        if (view.getId() == R.id.tabAll || view.getId() == R.id.tabAppointment
                || view.getId() == R.id.tabNotStart || view.getId() == R.id.tabGoing
                || view.getId() == R.id.tabFinished) {
            setSelect(view.getId());
            return;
        }
    }

    private void loadMoreData() {
        page = page++;
        getData(jOrderStatus, page);
    }

    private int jOrderStatus;
    private int page = 1;

    private void setSelect(int id) {
        tvAll.setSelected(id == R.id.tabAll);
        vAll.setVisibility(id == R.id.tabAll ? View.VISIBLE : View.INVISIBLE);

        tvAppointment.setSelected(id == R.id.tabAppointment);
        vAppointment.setVisibility(id == R.id.tabAppointment ? View.VISIBLE : View.INVISIBLE);

        tvNotStart.setSelected(id == R.id.tabNotStart);
        vNotStart.setVisibility(id == R.id.tabNotStart ? View.VISIBLE : View.INVISIBLE);

        tvGoing.setSelected(id == R.id.tabGoing);
        vGoing.setVisibility(id == R.id.tabGoing ? View.VISIBLE : View.INVISIBLE);

        tvFinished.setSelected(id == R.id.tabFinished);
        vFinished.setVisibility(id == R.id.tabFinished ? View.VISIBLE : View.INVISIBLE);

        switch (id) {
            case R.id.tabAll:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_ALL;
                getData(jOrderStatus, page);
                break;
            case R.id.tabAppointment:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_BE_PAID;
                getData(jOrderStatus, page);
                break;
            case R.id.tabNotStart:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_BE_DELIVERED;
                getData(jOrderStatus, page);
                break;
            case R.id.tabGoing:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS;
                getData(jOrderStatus, page);
                break;
            case R.id.tabFinished:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_CANCLE;
                getData(jOrderStatus, page);
                break;
        }
    }


    public void getData(final int orderStatus, int pageNum) {
        long userId = UserHelp.getUserId(ServiceOrderListActivity.this);
        if (userId == -1L) {
            LoginActivity.start(ServiceOrderListActivity.this);
            return;
        }
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
                            multipleStatusView.showOutContentView(rvList);
                            Gson gson = new Gson();
                            List<ServiceOrderListBean> orderListBean = gson.fromJson(data, new TypeToken<List<ServiceOrderListBean>>() {
                            }.getType());
                            if (page == 1) {
                                jAdapter.getData().clear();
                            }
                            jAdapter.replaceData(orderListBean);
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

    private View footView;

    private void addHotProject() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            footView = getLayoutInflater().inflate(R.layout.foot_view, (ViewGroup) rvList.getParent(), false);
        } else {
            footView = LayoutInflater.from(ServiceOrderListActivity.this).inflate(R.layout.foot_view, (ViewGroup) rvList.getParent(), false);
        }
        footView.setVisibility(View.GONE);
        jAdapter.addFooterView(footView);
        rvForYou = footView.findViewById(R.id.rv_hot_huodong);
        rvForYou.setLayoutManager(new GridLayoutManager(ServiceOrderListActivity.this, 2));
        rvForYou.setHasFixedSize(true);
        rvForYou.setNestedScrollingEnabled(false);
        forYouAdapter = new MyGridAdapter(ServiceOrderListActivity.this, MyGridAdapter.ORDER_HOT_BEAN);
        rvForYou.setAdapter(forYouAdapter);

        forYouAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BaseBean item = (BaseBean) adapter.getItem(position);
                ProjectDetailActivity.start(ServiceOrderListActivity.this, item.getProject_category_id());
            }
        });
    }
}
