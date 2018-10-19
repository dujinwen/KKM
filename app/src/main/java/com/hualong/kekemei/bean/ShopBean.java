package com.hualong.kekemei.bean;

/**
 * 店铺
 */
public class ShopBean {
    /**
     * id : 1
     * name : 西直门店
     * image : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
     * images : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
     * city : 北京/北京市/西城区
     * address : 2222
     * tel : 2222
     * longitude : 2222
     * latitude : 2222
     * content : 2222
     * state : 1
     * createtime : 1537862188
     * user_id : 1
     * order_count : 0
     * $satisfaction : 1
     * distance :
     * start : 3
     * state_text : 正常
     */

    private int id;
    private String name;
    private String image;
    private String images;
    private String city;
    private String address;
    private String tel;
    private String longitude;
    private String latitude;
    private String content;
    private String state;
    private int createtime;
    private int user_id;
    private int order_count;
    private String $satisfaction;
    private String distance;
    private int start;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public String getSatisfaction() {
        return $satisfaction;
    }

    public void setSatisfaction(String $satisfaction) {
        this.$satisfaction = $satisfaction;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getState_text() {
        return state_text;
    }

    public void setState_text(String state_text) {
        this.state_text = state_text;
    }
}
