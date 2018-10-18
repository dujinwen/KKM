package com.hualong.kekemei.bean;

import java.util.List;

public class ShopListBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1539695801
     * data : [{"id":1,"name":"西直门店","image":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","images":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","city":"北京/北京市/西城区","address":"2222","tel":"2222","longitude":"2222","latitude":"2222","content":"2222","state":"1","createtime":1537862188,"user_id":1,"order_count":0,"$satisfaction":1,"distance":"","start":3,"state_text":"正常"},{"id":2,"name":"德胜门店","image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","city":"北京/北京市/西城区","address":"1111","tel":"111111","longitude":"11111","latitude":"1111","content":"11111","state":"1","createtime":1538567762,"user_id":1,"order_count":1,"$satisfaction":0.5,"distance":"","start":2,"state_text":"正常"}]
     */

    private int code;
    private String msg;
    private String time;
    private List<ShopBean> data;

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

    public List<ShopBean> getData() {
        return data;
    }

    public void setData(List<ShopBean> data) {
        this.data = data;
    }
}
