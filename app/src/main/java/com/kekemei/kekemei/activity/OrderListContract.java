package com.kekemei.kekemei.activity;

import android.content.Context;


import com.kekemei.kekemei.bean.OrderListBean;
import com.kekemei.kekemei.view.IndictorWithNumber;
import com.kekemei.kekemei.bean.DataBean;

import java.util.List;

/**
 * Created by zhangshaoming on 2017/12/12.
 */

public interface OrderListContract {

    interface View extends BaseView<OrderListPresenter> {

        void showLoading();

        void showRefreshLoading(boolean show);

        void showData(List<OrderListBean.DataBean> dataList);

        void showEmpty();

        void showError();

        void showNoNetwork();

        void loadMoreSuccess(List<OrderListBean.DataBean> moreList);

        void showLoadMoreFailed();

        void showLoadMoreEnd();

        void showLoadMoreComplete();

        void shwoOrdersDeliverBtn(boolean show);

        void showIndictor(IndictorWithNumber.TabModele titleModle);

        void showDeliver(boolean show);

        void showDialogLoading(boolean show);

        Context getContext();
    }

    interface Presenter extends BasePresenter {

        void loadData(boolean isRefresh);

        void loadMoreData();

        void reloadData(int position);

    }

    interface ProviderCallback {

        /**
         * 请求网络开始前，UI线程
         */
        void onStart();

        /**
         * 对返回数据进行操作的回调， UI线程
         */
        void onSuccess(Object response, int orderStatus);

        /**
         * 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程
         */
        void onError(Object response, int orderStatus);

        /**
         * 请求网络结束后，UI线程
         */
        void onFinish();

    }
}
