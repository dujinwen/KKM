package com.hualong.kekemei.activity;

import com.hualong.kekemei.App;
import com.hualong.kekemei.Utills.LogUtil;
import com.hualong.kekemei.Utills.TResponse;
import com.hualong.kekemei.Utills.URLs;
import com.hualong.kekemei.Utills.callback.JsonCallback;
import com.hualong.kekemei.bean.OrderListBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

/**
 * Created by zhangshaoming on 2018/3/18.
 */

public class OrderListProvider {

    public OrderListContract.ProviderCallback jProviderCallback;

    public OrderListProvider(OrderListContract.ProviderCallback providerCallback) {
        jProviderCallback = providerCallback;
    }

    public void getData(final int orderStatus, int pageNum) {
        jProviderCallback.onStart();
        OkGo.<TResponse<OrderListBean>>get(URLs.MY_ORDER)
                .tag(this)
                .params("state", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
                .params("user_id", "")
                .params("page", pageNum)
                .execute(new JsonCallback<TResponse<OrderListBean>>() {
                    @Override
                    public void onStart(Request<TResponse<OrderListBean>, ? extends Request> request) {
                        super.onStart(request);
                    }

                    @Override
                    public void onSuccess(Response<TResponse<OrderListBean>> response) {
                        jProviderCallback.onSuccess(response.body().data, orderStatus);
                    }

                    @Override
                    public void onError(Response<TResponse<OrderListBean>> response) {
                        LogUtil.e("TAGE",response.message());
                        jProviderCallback.onError(response, orderStatus);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();

                    }
                });

    }

}
