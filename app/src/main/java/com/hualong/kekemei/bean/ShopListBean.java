package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1541571059
     * data : {"banner":[{"id":8,"title":"店铺广告第一屏","adv_pos_id":10354,"image":"/uploads/20181022/4208428115e55145e7ca26f73fa5c6d3.jpg","jumbdata":"web","project_project_id":0,"shop_shop_id":0,"becautician_becautician_id":0,"content":"店铺广告第一屏","url":"","views":0,"starttime":"2018-11-05","endtime":"2019-01-27","createtime":1541467816,"weigh":8,"switch":1,"jumbdata_text":"Jumbdata web"},{"id":7,"title":"店铺banner广告第二屏","adv_pos_id":10355,"image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","jumbdata":"web","project_project_id":0,"shop_shop_id":0,"becautician_becautician_id":0,"content":"店铺banner广告第二屏","url":"","views":0,"starttime":"2018-11-03","endtime":"2020-11-26","createtime":1541467001,"weigh":7,"switch":1,"jumbdata_text":"Jumbdata web"}],"data":[{"id":1,"name":"西直门店","image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","images":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","city":"北京/北京市/西城区","redenvelopes_ids":1,"coupon_ids":1,"address":"2222","tel":"2222","longitude":"2222","latitude":"2222","content":"2222","state":"1","createtime":1537862188,"shop_service_ids":"3,1,2","user_id":1,"order_count":0,"$satisfaction":1,"distance":10.18,"start":3,"service":["品质保障","随时调换","7天退"],"redenvelopes":["111111"],"coupon":["满599减50"],"comment_count":24,"appointment":1,"state_text":"正常"},{"id":2,"name":"德胜门店","image":"/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","images":"/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","city":"北京/北京市/西城区","redenvelopes_ids":1,"coupon_ids":1,"address":"德胜门店","tel":"111111","longitude":"116.3975157338","latitude":"39.9088596409","content":"11111","state":"1","createtime":1538567762,"shop_service_ids":"3,1,2","user_id":1,"order_count":1,"$satisfaction":0.96,"distance":10.18,"start":3,"service":["品质保障","随时调换","7天退"],"redenvelopes":["111111"],"state_text":"正常"}]}
     */

    private int code;
    private String msg;
    private String time;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        private List<BannerBean> banner;

        public List<ShopBean> getData() {
            return data;
        }

        public void setData(List<ShopBean> data) {
            this.data = data;
        }

        private List<ShopBean> data;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }


    }
}
