package com.hualong.kekemei.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hualong.kekemei.R;

import java.io.Serializable;
import java.util.List;

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
     * time : 1539224052
     * data : [{"id":1,"name":"订单！！！！","price":0,"user_id":1,"project_project_id":3,"shop_id":2,"state":"1","pay_type":null,"beautician_id":2,"createtime":1538613801,"state_text":"State 1","pay_type_text":""}]
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



    public static class DataBean implements Serializable, MultiItemEntity {

        @Override
        public int getItemType() {
            switch (state) {
                case "0":
                    ORDER_STATUS = ORDER_STATUS_TO_BE_PAID;
                    break;
                case "1":
                    ORDER_STATUS = ORDER_STATUS_TO_BE_DELIVERED;
                    break;
                case "2":
                    ORDER_STATUS = ORDER_STATUS_TO_RECEIVE_GOODS;
                    break;
                case "3":
                    ORDER_STATUS = ORDER_STATUS_FINISHED;
                    break;
                case "4":
                    ORDER_STATUS = ORDER_STATUS_CANCLE;
                    break;
                default:
                    ORDER_STATUS = ORDER_STATUS_ALL;
                    break;
            }
            return ORDER_STATUS;
        }

        /**
         * id : 1
         * name : 订单！！！！
         * price : 0
         * user_id : 1
         * project_project_id : 3
         * shop_id : 2
         * state : 1
         * pay_type : null
         * beautician_id : 2
         * createtime : 1538613801
         * state_text : State 1
         * pay_type_text :
         */

        private int id;
        private String name;
        private int price;
        private int user_id;
        private int project_project_id;
        private int shop_id;
        private String state;
        private Object pay_type;
        private int beautician_id;
        private int createtime;
        private String state_text;
        private String pay_type_text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getProject_project_id() {
            return project_project_id;
        }

        public void setProject_project_id(int project_project_id) {
            this.project_project_id = project_project_id;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getPay_type() {
            return pay_type;
        }

        public void setPay_type(Object pay_type) {
            this.pay_type = pay_type;
        }

        public int getBeautician_id() {
            return beautician_id;
        }

        public void setBeautician_id(int beautician_id) {
            this.beautician_id = beautician_id;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public String getPay_type_text() {
            return pay_type_text;
        }

        public void setPay_type_text(String pay_type_text) {
            this.pay_type_text = pay_type_text;
        }

    }
}
