package com.hualong.kekemei.bean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiListBean {
    /**
     * code : 1
     * data : [{"content":"3333333","distance":"","id":1,"name":"美容师","order":1,"satisfaction":0.5,"shop_ids":"1,2","shops":["西直门店","德胜门店"],"start":3,"state":"1","state_text":"正常","tag":["5","3"],"tag_text":["干净卫生","技师专业"],"user_id":1,"user_nickname":"admin"},{"content":"fwfw","distance":"","id":2,"name":"5555","order":1,"satisfaction":0.5,"shop_ids":"2,1","shops":["德胜门店","西直门店"],"start":3,"state":"2","state_text":"推荐","tag":["5","3"],"tag_text":["干净卫生","技师专业"],"user_id":1,"user_nickname":"admin"}]
     * msg : 请求成功
     * time : 1539680434
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

    public static class DataBean {
        /**
         * content : 3333333
         * distance :
         * id : 1
         * name : 美容师
         * order : 1
         * satisfaction : 0.5
         * shop_ids : 1,2
         * shops : ["西直门店","德胜门店"]
         * start : 3
         * state : 1
         * state_text : 正常
         * tag : ["5","3"]
         * tag_text : ["干净卫生","技师专业"]
         * user_id : 1
         * user_nickname : admin
         */

        private String content;
        private String distance;
        private int id;
        private String name;
        private int order;
        private double satisfaction;
        private String shop_ids;
        private int start;
        private String state;
        private String state_text;
        private int user_id;
        private String user_nickname;
        private List<String> shops;
        private List<String> tag;
        private List<String> tag_text;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public double getSatisfaction() {
            return satisfaction;
        }

        public void setSatisfaction(double satisfaction) {
            this.satisfaction = satisfaction;
        }

        public String getShop_ids() {
            return shop_ids;
        }

        public void setShop_ids(String shop_ids) {
            this.shop_ids = shop_ids;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public List<String> getShops() {
            return shops;
        }

        public void setShops(List<String> shops) {
            this.shops = shops;
        }

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }

        public List<String> getTag_text() {
            return tag_text;
        }

        public void setTag_text(List<String> tag_text) {
            this.tag_text = tag_text;
        }
    }
}
