package com.hualong.kekemei.activity;



import com.hualong.kekemei.Utills.IndictorWithNumber;
import com.hualong.kekemei.bean.OrderListBean;

import java.util.ArrayList;

/**
 * Created by zhangshaoming on 2018/3/18.
 */

public class OrderListPresenter implements OrderListContract.Presenter, OrderListContract.ProviderCallback {

    private final OrderListContract.View jView;

    private OrderListProvider jWorkProvider;

    private int jOrderStatus;
    private int tabPosition = -1;
    private IndictorWithNumber.TabModele tabModele;

    private boolean isRefresh = false;
    private boolean isLoadMore = false;

    private int jPageNum = 1;


    public OrderListPresenter(OrderListContract.View view, int orderStatus) {
        jWorkProvider = new OrderListProvider(this);
        jOrderStatus = orderStatus;
        jView = view;
        jView.setPresenter(this);
    }

    @Override
    public void start() {
    }


    @Override
    public void loadData(boolean isRefresh) {
        this.isRefresh = isRefresh;
        isLoadMore = false;
        if (isRefresh) {
            jPageNum = 1;
            jView.showRefreshLoading(isRefresh);
        }
        jWorkProvider.getData(jOrderStatus, jPageNum);
    }

    @Override
    public void loadMoreData() {
        isLoadMore = true;
        isRefresh = false;
        jWorkProvider.getData(jOrderStatus, jPageNum);
    }

    @Override
    public void reloadData(int position) {
        isLoadMore = false;
        isRefresh = false;
        if (position == tabPosition)
            return;
        else {
            jPageNum = 1;
            jOrderStatus = tabModele.getStatusNum(position);
            jWorkProvider.getData(jOrderStatus, jPageNum);
            jView.showLoading();
        }
    }

    @Override
    public void onStart() {
        if (!isRefresh && !isLoadMore)
            jView.showLoading();
    }

    @Override
    public void onSuccess(Object response, int jOrderStatus) {
        if (!isLoadMore) {
            jPageNum++;
            OrderListBean orderListBean = (OrderListBean) response;
            refreshTabMod(orderListBean);

            if (null == orderListBean.getPageResultVo().getResult() || orderListBean.getPageResultVo().getResult().size() == 0) {
                jView.showEmpty();
                jView.shwoOrdersDeliverBtn(false);
            } else {
                jView.shwoOrdersDeliverBtn(jOrderStatus == OrderListBean.ORDER_STATUS_TO_BE_DELIVERED ? true : false);
                if (isRefresh)
                    jView.showRefreshLoading(false);
                jView.showData(orderListBean.getPageResultVo().getResult());
            }

            if (jPageNum > orderListBean.getPageResultVo().getTotalPageCount())
                jView.showLoadMoreEnd();
            else
                jView.showLoadMoreComplete();
        } else {
            jPageNum++;
            OrderListBean orderListBean = (OrderListBean) response;
            jView.loadMoreSuccess(orderListBean.getPageResultVo().getResult());
            if (jPageNum > orderListBean.getPageResultVo().getTotalPageCount()) {
                jView.showLoadMoreEnd();
            } else {
                jView.showLoadMoreComplete();
            }
        }
    }

    private void refreshTabMod(OrderListBean orderListBean) {
        if (null == tabModele) {
            IndictorWithNumber.TabModele titleModle = new IndictorWithNumber.TabModele();
            ArrayList<IndictorWithNumber.TabModele.TitleNumber> list = new ArrayList<>();
            IndictorWithNumber.TabModele.TitleNumber item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "全部";
            item.status = OrderListBean.ORDER_STATUS_ALL;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "待付款";
            item.status = OrderListBean.ORDER_STATUS_TO_BE_PAID;
            item.count = orderListBean.getStayPayNum();
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "待发货";
            item.status = OrderListBean.ORDER_STATUS_TO_BE_DELIVERED;
            item.count = orderListBean.getStayDeliverNum();
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "待收货";
            item.status = OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS;
            item.count = 0;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "已完成";
            item.status = OrderListBean.ORDER_STATUS_FINISHED;
            list.add(item);

            item = new IndictorWithNumber.TabModele.TitleNumber();
            item.title = "已取消";
            item.status = OrderListBean.ORDER_STATUS_CANCLE;
            list.add(item);

            titleModle.setTitleNumList(list);
            tabModele = titleModle;
            titleModle.setCurrentItem(getTabIndex());
        } else {
            for (IndictorWithNumber.TabModele.TitleNumber item : tabModele.getTitleNumList()) {
                item.count = getTabNumber(item.status, orderListBean);
            }
        }
        jView.showIndictor(tabModele);
    }


    private int getTabNumber(int status, OrderListBean orderListBean) {
        if (status == OrderListBean.ORDER_STATUS_TO_BE_DELIVERED)
            return orderListBean.getStayDeliverNum();
        if (status == OrderListBean.ORDER_STATUS_TO_BE_PAID)
            return orderListBean.getStayPayNum();
        return 0;
    }

    private int getTabIndex() {
        int index = 0;
        int i = 0;
        for (IndictorWithNumber.TabModele.TitleNumber item : tabModele.getTitleNumList()) {
            if (jOrderStatus == item.status) {
                index = i;
            }
            i++;
        }
        return index;
    }

    @Override
    public void onError(Object response, int jOrderStatus) {
        if (this.jOrderStatus == jOrderStatus)
            if (!isRefresh && !isLoadMore)
                jView.showError();
        if (isLoadMore)
            jView.showLoadMoreFailed();
        if (isRefresh)
            jView.showRefreshLoading(false);
    }

    @Override
    public void onFinish() {

    }
}
