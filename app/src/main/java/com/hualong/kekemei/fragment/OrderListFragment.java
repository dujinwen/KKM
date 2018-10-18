package com.hualong.kekemei.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hualong.kekemei.R;
import com.hualong.kekemei.Utills.BaseFragment;
import com.hualong.kekemei.Utills.IndictorWithNumber;
import com.hualong.kekemei.Utills.MultipleStatusView;
import com.hualong.kekemei.activity.OrderListContract;
import com.hualong.kekemei.activity.OrderListPresenter;
import com.hualong.kekemei.bean.DataBean;
import com.hualong.kekemei.adapter.OrderListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by zhangshaoming on 2018/3/18.
 */

public class OrderListFragment extends BaseFragment implements OrderListContract.View, IndictorWithNumber.TabChangeListener {

    public static final String ARG_ORDER_STATUS = "orderStatus";

    private IndictorWithNumber jIndictorWithNumber;
    private RecyclerView jRecyclerView;
    private OrderListAdapter jAdapter;
    private OrderListPresenter jPresenter;
    private SmartRefreshLayout jSwipeRefreshLayout;
    private ViewPager jViewPager;

    private MultipleStatusView multipleStatusView;

    public static OrderListFragment newInstance(int orderStatus) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ORDER_STATUS, orderStatus);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.work_order_list_frag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    protected void initViewsAndEvents(View view) {
        multipleStatusView = view.findViewById(R.id.multiple_status_view);
        jViewPager = view.findViewById(R.id.view_pager);
        jIndictorWithNumber = view.findViewById(R.id.indictor_tabs);
        jSwipeRefreshLayout = view.findViewById(R.id.swipe_rfresh_layout);
        jRecyclerView = view.findViewById(R.id.rv_list);
//        deliver_orders_ll = view.findViewById(R.id.deliver_orders_ll);

//        mDeliverOrdersBtn = view.findViewById(R.id.deliver_orders_btn_tv);
//        mDeliverOrdersBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDeliver(true);
//            }
//        });
        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jPresenter.loadData(false);
            }
        });
        multipleStatusView.showOutContentView(jSwipeRefreshLayout);

        jSwipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                jPresenter.loadData(true);
            }
        });
        jSwipeRefreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        jSwipeRefreshLayout.setEnableLoadMore(false);

        jAdapter = new OrderListAdapter(getContext());
        jAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                jPresenter.loadMoreData();
            }
        }, jRecyclerView);

        jRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        jAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                if (view.getId() == R.id.order_id_copy_tv) {
//                    Toast.makeText(getContext(), "复制成功", Toast.LENGTH_SHORT).show();
//                    AppUtil.copyToClipboard(getContext(),
//                            ((OrderListBean.PageResultVoBean.ResultBean) adapter.getItem(position)).
//                                    getOrderNo() + "");
//                } else if (view.getId() == R.id.order_adress_copy_tv) {
//                    Toast.makeText(getContext(), "复制成功", Toast.LENGTH_SHORT).show();
//                    OrderListBean.PageResultVoBean.ResultBean item = (OrderListBean.PageResultVoBean.ResultBean) adapter.getItem(position);
//                    String copStr = String.format(getContext().getResources().getString(R.string.format_buyer_name_tv), item.getShopName())
//                            + "  " + item.getMobile() + "  /n" + String.format(getContext().getResources().getString(R.string.format_adress),
//                            item.getFullAddress());
//                    AppUtil.copyToClipboard(getContext(), copStr);
//                } else if (view.getId() == R.id.deliver_btn_tv) {
//                    OrderListBean.PageResultVoBean.ResultBean item = (OrderListBean.PageResultVoBean.ResultBean) adapter.getItem(position);
//                    Router.build("work_order_deliver").with(DeliverActivity.ARG_PARAM1, item.getOrderNo())
//                            .requestCode(ActivityRequestCode.ACTIVITY_REQUEST_TO_DELIVER).go(getContext());
//                } else if (view.getId() == R.id.phone_call_btn) {
//                    OrderListBean.PageResultVoBean.ResultBean item = (OrderListBean.PageResultVoBean.ResultBean) adapter.getItem(position);
//                    Intent intent = new Intent(Intent.ACTION_DIAL);
//                    Uri data = Uri.parse("tel:" + item.getMobile());
//                    intent.setData(data);
//                    startActivity(intent);
//                }
            }
        });
//        jAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
////                Router.build("work_order_detail").with(OrderDetailActivity.ARG_PARAM1,
////                        ((OrderListBean.PageResultVoBean.ResultBean) adapter.getData().get(position)).getOrderNo())
////                        .requestCode(ActivityRequestCode.ACTIVITY_REQUEST_TO_DELIVER).go(getContext());
//            }
//        });

        jRecyclerView.setAdapter(jAdapter);

        int status = getArguments().getInt(ARG_ORDER_STATUS);
        new OrderListPresenter(this, status);

        jIndictorWithNumber.setTabChangeListener(this);

    }


    @Override
    public void setPresenter(OrderListPresenter presenter) {
        jPresenter = presenter;
        jPresenter.loadData(false);
    }

    @Override
    public void showLoading() {
        multipleStatusView.showLoading();
    }

    @Override
    public void showRefreshLoading(boolean show) {
        if (show) {
            jSwipeRefreshLayout.refreshDrawableState();
        } else {
            jSwipeRefreshLayout.finishRefresh();
        }
    }

    @Override
    public void showData(List<DataBean> dataList) {
        if (isOnDestory)
            return;
        multipleStatusView.showOutContentView(jSwipeRefreshLayout);
        jAdapter.setNewData(dataList);
        jRecyclerView.scrollToPosition(0);
    }

    @Override
    public void showEmpty() {
        multipleStatusView.showEmpty();
    }

    @Override
    public void showError() {
        multipleStatusView.showError();
    }

    @Override
    public void showNoNetwork() {
        multipleStatusView.showNoNetwork();
    }

    @Override
    public void loadMoreSuccess(List<DataBean> dataList) {
        jAdapter.addData(dataList);
    }

    @Override
    public void showLoadMoreFailed() {
        jAdapter.loadMoreFail();
    }

    @Override
    public void showLoadMoreEnd() {
        jAdapter.loadMoreEnd(false);
    }

    @Override
    public void showLoadMoreComplete() {
        jAdapter.loadMoreComplete();
    }

    @Override
    public void shwoOrdersDeliverBtn(boolean show) {
//        mDeliverOrdersBtn.setVisibility(show ? View.VISIBLE : View.GONE);
//        deliver_orders_ll.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showIndictor(IndictorWithNumber.TabModele titleModle) {
        if (null == jViewPager.getAdapter() && !isOnDestory && getActivity() != null && getActivity().getFragmentManager() != null)
            jViewPager.setAdapter(new IndictorWithNumber.MyPagerAdapter(getActivity().getFragmentManager(), titleModle));
        jIndictorWithNumber.setViewPager(jViewPager, titleModle);
        jIndictorWithNumber.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDeliver(boolean show) {
//        Router.build("work_order_deliver_list")
//                .requestCode(ActivityRequestCode.ACTIVITY_REQUEST_TO_DELIVER_LIST).go(getContext());
    }

    @Override
    public void showDialogLoading(boolean show) {

    }

    @Override
    public void onTabSelected(int position) {
        jSwipeRefreshLayout.finishRefresh();
        jPresenter.reloadData(position);
    }

    private boolean isOnDestory = false;

    @Override
    public void onDestroy() {
        isOnDestory = true;
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == ActivityRequestCode.ACTIVITY_REQUEST_TO_DELIVER) {
//            if (resultCode == Activity.RESULT_OK) {
//                jSwipeRefreshLayout.autoRefresh();
//            }
//        }
//
//        if (requestCode == ActivityRequestCode.ACTIVITY_REQUEST_TO_DELIVER_LIST) {
//            jSwipeRefreshLayout.autoRefresh();
//        }
    }
}
