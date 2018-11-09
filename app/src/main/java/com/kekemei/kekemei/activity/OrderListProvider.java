package com.kekemei.kekemei.activity;

import com.google.gson.Gson;
import com.kekemei.kekemei.utils.LogUtil;
import com.kekemei.kekemei.utils.URLs;
import com.kekemei.kekemei.bean.OrderListBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

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
        OkGo.<String>get(URLs.MY_ORDER)
                .tag(this)
                .params("state", OrderListBean.ORDER_STATUS_ALL == orderStatus ? "" : orderStatus + "")
                .params("user_id", "1")
                .params("page", pageNum)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            Object msg = jsonObject.opt("msg");
                            if (msg.equals("暂无数据")){
                                jProviderCallback.onSuccess(null, orderStatus);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Gson gson = new Gson();
                        OrderListBean orderListBean = gson.fromJson(response.body(), OrderListBean.class);
                        jProviderCallback.onSuccess(orderListBean, orderStatus);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        LogUtil.e("TAGE",response.message());
                        jProviderCallback.onError(response, orderStatus);
                    }
                });



    }

}
