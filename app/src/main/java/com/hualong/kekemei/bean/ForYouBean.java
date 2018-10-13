package com.hualong.kekemei.bean;

import java.util.List;

public class ForYouBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1539400736
     * data : [{"id":1,"name":"热门项目","project_category_id":3,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"2","weigh":100,"views":0,"createtime":1538449687,"quality_text":"","flag_text":"","state_text":"推荐"}]
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

    public static class DataBean extends BaseBean{
        /**
         * id : 1
         * name : 热门项目
         * project_category_id : 3
         * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
         * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
         * price : 150
         * price_market : 0
         * price_discount : 0
         * treatment_price : 0.00
         * price_newmember : 0
         * price_member : 0
         * price_second : 0
         * treatment_count : 0
         * quality :
         * activitytime : 2018-10-02 11:01:59
         * activitytime_end : 2018-10-02 11:01:59
         * content : 测试测试测试测试测试
         * flag :
         * redenvelopes_ids : 1
         * coupon_ids : null
         * state : 2
         * weigh : 100
         * views : 0
         * createtime : 1538449687
         * quality_text :
         * flag_text :
         * state_text : 推荐
         */

        private int id;
        private String name;
        private int project_category_id;
        private String image;
        private String images;
        private int price;
        private int price_market;
        private int price_discount;
        private String treatment_price;
        private int price_newmember;
        private int price_member;
        private int price_second;
        private String treatment_count;
        private String quality;
        private String activitytime;
        private String activitytime_end;
        private String content;
        private String flag;
        private String redenvelopes_ids;
        private Object coupon_ids;
        private String state;
        private int weigh;
        private int views;
        private int createtime;
        private String quality_text;
        private String flag_text;
        private String state_text;

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

        public int getProject_category_id() {
            return project_category_id;
        }

        public void setProject_category_id(int project_category_id) {
            this.project_category_id = project_category_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice_market() {
            return price_market;
        }

        public void setPrice_market(int price_market) {
            this.price_market = price_market;
        }

        public int getPrice_discount() {
            return price_discount;
        }

        public void setPrice_discount(int price_discount) {
            this.price_discount = price_discount;
        }

        public String getTreatment_price() {
            return treatment_price;
        }

        public void setTreatment_price(String treatment_price) {
            this.treatment_price = treatment_price;
        }

        public int getPrice_newmember() {
            return price_newmember;
        }

        public void setPrice_newmember(int price_newmember) {
            this.price_newmember = price_newmember;
        }

        public int getPrice_member() {
            return price_member;
        }

        public void setPrice_member(int price_member) {
            this.price_member = price_member;
        }

        public int getPrice_second() {
            return price_second;
        }

        public void setPrice_second(int price_second) {
            this.price_second = price_second;
        }

        public String getTreatment_count() {
            return treatment_count;
        }

        public void setTreatment_count(String treatment_count) {
            this.treatment_count = treatment_count;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getActivitytime() {
            return activitytime;
        }

        public void setActivitytime(String activitytime) {
            this.activitytime = activitytime;
        }

        public String getActivitytime_end() {
            return activitytime_end;
        }

        public void setActivitytime_end(String activitytime_end) {
            this.activitytime_end = activitytime_end;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getRedenvelopes_ids() {
            return redenvelopes_ids;
        }

        public void setRedenvelopes_ids(String redenvelopes_ids) {
            this.redenvelopes_ids = redenvelopes_ids;
        }

        public Object getCoupon_ids() {
            return coupon_ids;
        }

        public void setCoupon_ids(Object coupon_ids) {
            this.coupon_ids = coupon_ids;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getWeigh() {
            return weigh;
        }

        public void setWeigh(int weigh) {
            this.weigh = weigh;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public String getQuality_text() {
            return quality_text;
        }

        public void setQuality_text(String quality_text) {
            this.quality_text = quality_text;
        }

        public String getFlag_text() {
            return flag_text;
        }

        public void setFlag_text(String flag_text) {
            this.flag_text = flag_text;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }
    }
}