package com.kekemei.kekemei.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.activity.PushOrderActivity;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.utils.UserHelp;
import com.kekemei.kekemei.view.IndictorWithNumber;
import com.kekemei.kekemei.view.MultipleStatusView;
import com.kekemei.kekemei.activity.OrderListContract;
import com.kekemei.kekemei.activity.OrderListPresenter;
import com.kekemei.kekemei.activity.OrderListSearchActivity;
import com.kekemei.kekemei.adapter.MyGridAdapter;
import com.kekemei.kekemei.bean.DataBean;
import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.adapter.OrderListAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class MessageFragment

        extends Fragment implements OrderListContract.View, IndictorWithNumber.TabChangeListener, View.OnClickListener {

    public static final String ARG_ORDER_STATUS = "orderStatus";

    Unbinder unbinder;
    @BindView(R.id.tv_dingdan)
    TextView tvDingdan;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.indictor_tabs)
    IndictorWithNumber indictorTabs;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.swipe_rfresh_layout)
    SmartRefreshLayout swipeRfreshLayout;

    private IndictorWithNumber jIndictorWithNumber;
    private RecyclerView jRecyclerView;
    private OrderListAdapter jAdapter;
    private OrderListPresenter jPresenter;
    private SmartRefreshLayout jSwipeRefreshLayout;
    private ViewPager jViewPager;

    private MultipleStatusView multipleStatusView;
    int status = OrderListBean.ORDER_STATUS_TO_BE_PAID;
    private RecyclerView rv_hot_huodong;

    public static OrderListFragment newInstance(int orderStatus) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ORDER_STATUS, orderStatus);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_order_list_frag, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndEvents(view);
    }

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
        // TODO: 2018/10/15   判断是否有数据
        addHotProject();

        //添加Header对应的点击事件
        jAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.zaicigoumai:
                        DataBean item = jAdapter.getItem(position);
//                        OkGo.<String>get(URLs.ORDER_GENERATING)
//                                .params("user_id", UserHelp.getUserId(getActivity()))
//                                .params("name", item.getName())
//                                .params("project_id", item.getProject_project_id())
//                                .params("count", 1)
//                                .execute(new StringCallback() {
//                                    @Override
//                                    public void onSuccess(Response<String> response) {
//
//                                    }
//                                });
                        Intent intent = new Intent(getActivity(), PushOrderActivity.class);
                        intent.putExtra(PushOrderActivity.IMAGE_URL,item.getImage());
                        intent.putExtra(PushOrderActivity.ORDER_NAME,item.getName());
                        intent.putExtra(PushOrderActivity.ORDER_PRICE,item.getPrice());
                        intent.putExtra(PushOrderActivity.PROJECT_ID,item.getProject_project_id());
                        startActivity(intent);
                        break;

                    default:

                        break;
                }
            }
        });

        jRecyclerView.setAdapter(jAdapter);

        //        status = getArguments().getInt(ARG_ORDER_STATUS);
        new OrderListPresenter(this, status);

        jIndictorWithNumber.setTabChangeListener(this);


        ivSearch.setOnClickListener(this);
    }

    private void addHotProject() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View foot_view = getLayoutInflater().inflate(R.layout.foot_view, (ViewGroup) jRecyclerView.getParent(), false);
            jAdapter.addFooterView(foot_view);
            rv_hot_huodong = (RecyclerView) foot_view.findViewById(R.id.rv_hot_huodong);
            rv_hot_huodong.setLayoutManager(new GridLayoutManager(getContext(), 2));

            MyGridAdapter adapter = new MyGridAdapter(getContext(), MyGridAdapter.ORDER_HOT_BEAN);
            rv_hot_huodong.setAdapter(adapter);
            //设置热门数据
            //            adapter.addData();
        } else {
            View foot_view = LayoutInflater.from(getContext()).inflate(R.layout.foot_view, (ViewGroup) jRecyclerView.getParent(), false);
            jAdapter.addFooterView(foot_view);
            rv_hot_huodong = (RecyclerView) foot_view.findViewById(R.id.rv_hot_huodong);
            rv_hot_huodong.setLayoutManager(new GridLayoutManager(getContext(), 2));

            MyGridAdapter adapter = new MyGridAdapter(getContext(), MyGridAdapter.ORDER_HOT_BEAN);
            rv_hot_huodong.setAdapter(adapter);
            //设置热门数据
            //            adapter.addData();
        }
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
        multipleStatusView.showEmpty(R.mipmap.default_dingdan);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search: {
                Intent intent = new Intent(getActivity(), OrderListSearchActivity.class);
                startActivity(intent);
            }
        }
    }
}
