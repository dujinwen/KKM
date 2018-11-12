package com.kekemei.kekemei.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.adapter.OrderListAdapter;
import com.kekemei.kekemei.bean.ForYouBean;
import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.utils.EndLessOnScrollListener;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class MessageFragment2 extends Fragment {

    @BindView(R.id.tv_dingdan)
    TextView tvDingdan;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.v_all)
    View vAll;
    @BindView(R.id.tal_all)
    LinearLayout talAll;
    @BindView(R.id.tv_wait_pay)
    TextView tvWaitPay;
    @BindView(R.id.v_wait_pay)
    View vWaitPay;
    @BindView(R.id.tal_wait_pay)
    LinearLayout talWaitPay;
    @BindView(R.id.tv_wait_yuyue)
    TextView tvWaitYuyue;
    @BindView(R.id.v_wait_yuyue)
    View vWaitYuyue;
    @BindView(R.id.tal_wait_yuyue)
    LinearLayout talWaitYuyue;
    @BindView(R.id.tv_wait_server)
    TextView tvWaitServer;
    @BindView(R.id.v_wait_server)
    View vWaitServer;
    @BindView(R.id.tal_wait_server)
    LinearLayout talWaitServer;
    @BindView(R.id.tv_pingjia)
    TextView tvPingjia;
    @BindView(R.id.v_pingjia)
    View vPingjia;
    @BindView(R.id.tal_pingjia)
    LinearLayout talPingjia;
    @BindView(R.id.tv_finish)
    TextView tvFinish;
    @BindView(R.id.v_finish)
    View vFinish;
    @BindView(R.id.tal_finish)
    LinearLayout talFinish;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.rl_list)
    RelativeLayout rlList;
    Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private OrderListAdapter jAdapter;
    private RecyclerView rv_hot_huodong;

    private ArrayList<OrderListBean.DataBean> arrayList = new ArrayList<OrderListBean.DataBean>();
    private LinearLayout llForyou;
    private MyGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_order_list_frag2, container, false);


        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvList.setLayoutManager(linearLayoutManager);
        jAdapter = new OrderListAdapter(getActivity());
        rvList.setAdapter(jAdapter);
        rvList.addOnScrollListener(new EndLessOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
        onViewClicked(talAll);


        addHotProject();


        getForYouInfo();
    }

    private void getForYouInfo() {
        OkGo.<String>get(URLs.FOR_YOU).params("page", 1).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                ForYouBean forYouBean = gson.fromJson(response.body(), ForYouBean.class);
                if (forYouBean.getCode() == 1 && forYouBean.getData().size() != 0) {
                    llForyou.setVisibility(View.VISIBLE);
                } else {
                    llForyou.setVisibility(View.GONE);
                    return;
                }

                adapter.addData(forYouBean.getData());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tal_all, R.id.tal_wait_pay, R.id.tal_wait_yuyue, R.id.tal_wait_server, R.id.tal_finish, R.id.tal_pingjia})
    public void onViewClicked(View view) {
        setSelect(view.getId());
    }

    private void loadMoreData() {
        page = page++;
        getData(jOrderStatus, page);
    }

    private int jOrderStatus;
    private int page = 1;

    private void setSelect(int id) {
        tvAll.setSelected(id == R.id.tal_all);
        vAll.setVisibility(id == R.id.tal_all ? View.VISIBLE : View.INVISIBLE);

        tvWaitPay.setSelected(id == R.id.tal_wait_pay);
        vWaitPay.setVisibility(id == R.id.tal_wait_pay ? View.VISIBLE : View.INVISIBLE);

        tvWaitYuyue.setSelected(id == R.id.tal_wait_yuyue);
        vWaitYuyue.setVisibility(id == R.id.tal_wait_yuyue ? View.VISIBLE : View.INVISIBLE);

        tvWaitServer.setSelected(id == R.id.tal_wait_server);
        vWaitServer.setVisibility(id == R.id.tal_wait_server ? View.VISIBLE : View.INVISIBLE);

        tvFinish.setSelected(id == R.id.tal_finish);
        vFinish.setVisibility(id == R.id.tal_finish ? View.VISIBLE : View.INVISIBLE);

        tvPingjia.setSelected(id == R.id.tal_pingjia);
        vPingjia.setVisibility(id == R.id.tal_pingjia ? View.VISIBLE : View.INVISIBLE);

        switch (id) {
            case R.id.tal_all:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_ALL;
                getData(jOrderStatus, page);
                break;
            case R.id.tal_wait_pay:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_BE_PAID;
                getData(jOrderStatus, page);
                break;
            case R.id.tal_wait_yuyue:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_BE_DELIVERED;
                getData(jOrderStatus, page);
                break;
            case R.id.tal_wait_server:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS;
                getData(jOrderStatus, page);
                break;
            case R.id.tal_finish:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_CANCLE;
                getData(jOrderStatus, page);
                break;
            case R.id.tal_pingjia:
                page = 1;
                jOrderStatus = OrderListBean.ORDER_STATUS_FINISHED;
                getData(jOrderStatus, page);
                break;
            default:

                break;


        }
    }


    public void getData(final int orderStatus, int pageNum) {
        OkGo.<String>get(URLs.MY_ORDER)
                .tag(this)
                .params("state", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
                .params("user_id", UserHelp.getUserId(getActivity()))
                .params("page", pageNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject obj = new JSONObject(response.body());
                            if (obj.getString("data") == null || obj.getString("data").isEmpty()) {
                                multipleStatusView.showEmpty(R.mipmap.default_dingdan);
                                return;
                            }
                            multipleStatusView.showOutContentView(rvList);
                            Gson gson = new Gson();
                            OrderListBean orderListBean = gson.fromJson(response.body(), OrderListBean.class);
                            if (page == 1) {
                                arrayList.clear();
                            }
                            arrayList.addAll(orderListBean.getData());
                            jAdapter.setNewData(arrayList);
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


    private void addHotProject() {
        View foot_view = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            foot_view = getLayoutInflater().inflate(R.layout.foot_view, (ViewGroup) rvList.getParent(), false);
        } else {
            foot_view = LayoutInflater.from(getActivity()).inflate(R.layout.foot_view, (ViewGroup) rvList.getParent(), false);
        }
        jAdapter.addFooterView(foot_view);
        rv_hot_huodong = (RecyclerView) foot_view.findViewById(R.id.rv_hot_huodong);
        llForyou = foot_view.findViewById(R.id.ll_foryou);
        rv_hot_huodong.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        adapter = new MyGridAdapter(getActivity(), MyGridAdapter.ORDER_HOT_BEAN);
        rv_hot_huodong.setAdapter(adapter);
    }
}
