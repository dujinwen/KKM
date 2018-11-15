package com.kekemei.kekemei.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 店铺
 */
public class ShopBean implements Serializable{

    /**
     * $satisfaction : 1
     * address : 2222
     * appointment : 1
     * city : 北京/北京市/西城区
     * comment_count : 24
     * content : 2222
     * coupon : ["满599减50"]
     * coupon_ids : 1
     * createtime : 1537862188
     * distance : 10.18
     * id : 1
     * image : /uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg
     * images : /uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg
     * latitude : 2222
     * longitude : 2222
     * name : 西直门店
     * order_count : 0
     * redenvelopes : ["111111"]
     * redenvelopes_ids : 1
     * service : ["品质保障","随时调换","7天退"]
     * shop_service_ids : 3,1,2
     * start : 3
     * state : 1
     * state_text : 正常
     * tel : 2222
     * user_id : 1
     */

    private double $satisfaction;
    private String address;
    private int appointment;
    private String city;
    private int comment_count;
    private String content;
    private int coupon_ids;
    private int createtime;
    private double distance;
    private int id;
    private String image;
    private String images;
    private String latitude;
    private String longitude;
    private String name;
    private int order_count;
    private int redenvelopes_ids;
    private String shop_service_ids;
    private int start;
    private String state;
    private String state_text;
    private String tel;
    private int user_id;
    private List<String> coupon;
    private List<String> redenvelopes;
    private List<String> service;

    public double get$satisfaction() {
        return $satisfaction;
    }

    public void set$satisfaction(double $satisfaction) {
        this.$satisfaction = $satisfaction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAppointment() {
        return appointment;
    }

    public void setAppointment(int appointment) {
        this.appointment = appointment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCoupon_ids() {
        return coupon_ids;
    }

    public void setCoupon_ids(int coupon_ids) {
        this.coupon_ids = coupon_ids;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getRedenvelopes_ids() {
        return redenvelopes_ids;
    }

    public void setRedenvelopes_ids(int redenvelopes_ids) {
        this.redenvelopes_ids = redenvelopes_ids;
    }

    public String getShop_service_ids() {
        return shop_service_ids;
    }

    public void setShop_service_ids(String shop_service_ids) {
        this.shop_service_ids = shop_service_ids;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<String> getCoupon() {
        return coupon;
    }

    public void setCoupon(List<String> coupon) {
        this.coupon = coupon;
    }

    public List<String> getRedenvelopes() {
        return redenvelopes;
    }

    public void setRedenvelopes(List<String> redenvelopes) {
        this.redenvelopes = redenvelopes;
    }

    public List<String> getService() {
        return service;
    }

    public void setService(List<String> service) {
        this.service = service;
    }
}
