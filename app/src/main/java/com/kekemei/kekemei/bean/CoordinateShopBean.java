package com.kekemei.kekemei.bean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/11/15.
 */

public class CoordinateShopBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1542261796
     * data : [{"id":2,"name":"德胜门店","image":"/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","images":"/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","city":"北京/北京市/西城区","redenvelopes_ids":1,"coupon_ids":1,"address":"德胜门店","tel":"111111","longitude":"116.3975157338","latitude":"39.9088596409","content":"11111","state":"1","createtime":1538567762,"shop_service_ids":"3,1,2","user_id":1,"redenvelopes":["111111"],"coupon":["满599减50"],"distance":10.15,"state_text":"正常"},{"id":1,"name":"西直门店","image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","images":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","city":"北京/北京市/西城区","redenvelopes_ids":1,"coupon_ids":1,"address":"2222","tel":"2222","longitude":"116.3875157338","latitude":"39.3088596409","content":"2222","state":"1","createtime":1537862188,"shop_service_ids":"3,1,2","user_id":1,"redenvelopes":["111111"],"coupon":["满599减50"],"distance":76.91,"state_text":"正常"}]
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
         * id : 2
         * name : 德胜门店
         * image : /uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg
         * images : /uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg
         * city : 北京/北京市/西城区
         * redenvelopes_ids : 1
         * coupon_ids : 1
         * address : 德胜门店
         * tel : 111111
         * longitude : 116.3975157338
         * latitude : 39.9088596409
         * content : 11111
         * state : 1
         * createtime : 1538567762
         * shop_service_ids : 3,1,2
         * user_id : 1
         * redenvelopes : ["111111"]
         * coupon : ["满599减50"]
         * distance : 10.15
         * state_text : 正常
         */

        private int id;
        private String name;
        private String image;
        private String images;
        private String city;
        private int redenvelopes_ids;
        private int coupon_ids;
        private String address;
        private String tel;
        private String longitude;
        private String latitude;
        private String content;
        private String state;
        private int createtime;
        private String shop_service_ids;
        private int user_id;
        private double distance;
        private String state_text;
        private List<String> redenvelopes;
        private List<String> coupon;

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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getRedenvelopes_ids() {
            return redenvelopes_ids;
        }

        public void setRedenvelopes_ids(int redenvelopes_ids) {
            this.redenvelopes_ids = redenvelopes_ids;
        }

        public int getCoupon_ids() {
            return coupon_ids;
        }

        public void setCoupon_ids(int coupon_ids) {
            this.coupon_ids = coupon_ids;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public String getShop_service_ids() {
            return shop_service_ids;
        }

        public void setShop_service_ids(String shop_service_ids) {
            this.shop_service_ids = shop_service_ids;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public List<String> getRedenvelopes() {
            return redenvelopes;
        }

        public void setRedenvelopes(List<String> redenvelopes) {
            this.redenvelopes = redenvelopes;
        }

        public List<String> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<String> coupon) {
            this.coupon = coupon;
        }
    }
}
