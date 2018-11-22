package com.kekemei.kekemei.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kekemei.kekemei.R;
import com.kekemei.kekemei.bean.ServiceOrderListBean;
import com.kekemei.kekemei.utils.AppUtil;


public class ServiceOrderListAdapter extends BaseQuickAdapter<ServiceOrderListBean, BaseViewHolder> {

    public ServiceOrderListAdapter() {
        super(R.layout.item_service_order_list, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, ServiceOrderListBean item) {
        helper.addOnClickListener(R.id.cancelOrder);
        helper.addOnClickListener(R.id.acceptOrder);
        helper.addOnClickListener(R.id.startService);
        helper.addOnClickListener(R.id.finishService);
        helper.addOnClickListener(R.id.orderDetail);
        helper.setText(R.id.orderDate, "下单时间：" + AppUtil.getFormatTime(item.getCreatetime()));
        helper.setText(R.id.orderStatus, item.getState_text());
        helper.setText(R.id.name, item.getUser_name());
        helper.setText(R.id.phone, item.getUser_mobile());
        helper.setText(R.id.address, item.getService_address());
        helper.setText(R.id.orderId, item.getId());
        helper.setText(R.id.projectContent, item.getProject_name());
        helper.setText(R.id.appointmentTime, item.getServicetime_text());
        helper.setText(R.id.countNum, "X " + item.getCount());
        helper.setText(R.id.orderPrice, "￥ " + item.getProject_price());
        helper.getView(R.id.callPhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        helper.getView(R.id.lookMoreTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        setShowOrHide(item.getState(), helper);
    }


    public void setShowOrHide(String showOrHide, BaseViewHolder helper) {
        //状态值:0=待支付,1=待预约,2=待服务,3=待评价,4=完成
        switch (showOrHide) {
            case "0":  //待支付
                helper.setGone(R.id.cancelOrder, true);
                helper.setGone(R.id.acceptOrder, false);
                helper.setGone(R.id.startService, false);
                helper.setGone(R.id.finishService, true);
                helper.setGone(R.id.orderDetail, false);
                break;
            case "1": //待预约
                helper.setGone(R.id.cancelOrder, true);
                helper.setGone(R.id.acceptOrder, false);
                helper.setGone(R.id.startService, false);
                helper.setGone(R.id.finishService, false);
                helper.setGone(R.id.orderDetail, false);
                break;
            case "2": //待服务
                helper.setGone(R.id.cancelOrder, true);
                helper.setGone(R.id.acceptOrder, true);
                helper.setGone(R.id.startService, false);
                helper.setGone(R.id.finishService, false);
                helper.setGone(R.id.orderDetail, false);
                break;
            case "3": //待评价
                helper.setGone(R.id.cancelOrder, false);
                helper.setGone(R.id.acceptOrder, false);
                helper.setGone(R.id.startService, false);
                helper.setGone(R.id.finishService, false);
                helper.setGone(R.id.orderDetail, true);
                break;
            case "4": //完成
                helper.setGone(R.id.cancelOrder, false);
                helper.setGone(R.id.acceptOrder, false);
                helper.setGone(R.id.startService, false);
                helper.setGone(R.id.finishService, false);
                helper.setGone(R.id.orderDetail, true);
                break;
        }
    }
}


