package com.kekemei.kekemei.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_ALL;
import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_CANCLE;
import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_FINISHED;
import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_TO_BE_DELIVERED;
import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_TO_BE_PAID;
import static com.kekemei.kekemei.bean.OrderListBean.ORDER_STATUS_TO_RECEIVE_GOODS;

public class DataBean extends BaseBean implements Serializable, MultiItemEntity {

    @Override
    public int getItemType() {
        int ORDER_STATUS;
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
     * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
     * state_text : 待预约
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
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
