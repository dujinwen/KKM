package com.hualong.kekemei.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_ALL;
import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_CANCLE;
import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_FINISHED;
import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_TO_BE_DELIVERED;
import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_TO_BE_PAID;
import static com.hualong.kekemei.bean.OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS;

/**
 * Created by zhangshaoming on 2018/1/31.
 */

public class OrderListBean implements Serializable {

    /**
     * 状态值:0=待支付,1=待预约,2=待服务,3=待评价,4=完成
     */
    public static int ORDER_STATUS = 0;
    public static final int ORDER_STATUS_ALL = -10;     //全部订单
    public static final int ORDER_STATUS_TO_BE_PAID = 0;     //待支付
    public static final int ORDER_STATUS_TO_BE_DELIVERED = 1; //待预约
    public static final int ORDER_STATUS_TO_RECEIVE_GOODS = 2; //待服务
    public static final int ORDER_STATUS_FINISHED = 3;      //待评价
    public static final int ORDER_STATUS_CANCLE = 4;  //完成
    /**
     * code : 1
     * msg : 请求成功
     * time : 1539238425
     * data : [{"id":1,"name":"订单！！！！","price":0,"user_id":1,"project_project_id":3,"shop_id":2,"state":"1","pay_type":null,"beautician_id":2,"createtime":1538613801,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","state_text":"待预约","pay_type_text":""}]
     */

    private int code;
    private String msg;
    private String time;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}

