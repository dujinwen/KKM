package com.hualong.kekemei.activity;
import com.hualong.kekemei.App;
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
        String orderlistUrl;
//        if (Urls.BASE_URL.contains("gw-api.tfsandbox-dev.jcloudec.com"))
//            orderlistUrl = Urls.URL_ORDER_LIST;
//        else
//            orderlistUrl = Urls.URL_ORDER_LIST_SEARCH_PRE;
//        OkGo.<TResponse<OrderListBean>>get(orderlistUrl)
//                .tag(this)
//                .headers(Urls.COOKIE_NAME, UserHelp.getCookie(App.getAppContext()))
//                .params("orderStatus", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
//                .params("shopId", UserHelp.getShopId(App.getAppContext()))
//                .params("companyId", UserHelp.getCompanyId(App.getAppContext()))
//                .params("pageSize", Constant.testPageSize)
//                .params("pageNum", pageNum)
//                .params("orderSpecies", 1)
//                .execute(new JsonCallback<TResponse<OrderListBean>>() {
//                    @Override
//                    public void onStart(Request<TResponse<OrderListBean>, ? extends Request> request) {
//                        super.onStart(request);
//                    }
//
//                    @Override
//                    public void onSuccess(Response<TResponse<OrderListBean>> response) {
//                        jProviderCallback.onSuccess(response.body().data, orderStatus);
//                    }
//
//                    @Override
//                    public void onError(Response<TResponse<OrderListBean>> response) {
//                        LogUtil.e(response.message());
//                        jProviderCallback.onError(response, orderStatus);
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        super.onFinish();
//
//                    }
//                });

//        OkGo.<String>post(Urls.URL_ORDER_LIST)
//                .tag(this)
//                .headers(Urls.COOKIE_NAME, UserHelp.getCookie(App.getAppContext()))
//                .headers(Urls.COOKIE_NAME_ORDER, UserHelp.getCookie(App.getAppContext()))
//                .params("orderStatus", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
//                .params("shopId", UserHelp.getShopId(App.getAppContext()))
//                .params("companyId", UserHelp.getCompanyId(App.getAppContext()))
//                .params("pageSize", Constant.testPageSize)
//                .params("pageNum", pageNum)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        LogUtil.e(response.body());
//                    }
//                });
    }

}
