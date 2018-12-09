package com.kekemei.kekemei.bean;

import java.io.Serializable;

public class BeauticianHomeBean implements Serializable {
    /**
     * id : 2
     * name : 专业美容师
     * user_id : 2
     * redenvelopes_ids : 1
     * coupon_ids : 1
     * image : /uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg
     * images : /uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
     * shop_shop_ids : 2,1
     * content : 专业美容师
     * place : 籍贯
     * speciality : 特长
     * identity : 身份证
     * account : 40
     * state : 2
     * views : 6
     * order_count : 11
     * order_monthcount : 11
     * admin_tel : 888888888
     * version : 1.0.1
     * state_text : 推荐
     */

    private int id;
    private String name;
    private int user_id;
    private int redenvelopes_ids;
    private int coupon_ids;
    private String image;
    private String images;
    private String shop_shop_ids;
    private String content;
    private String place;
    private String speciality;
    private String identity;
    private int account;
    private String state;
    private int views;
    private int order_count;
    private int order_monthcount;
    private String admin_tel;
    private String version;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getShop_shop_ids() {
        return shop_shop_ids;
    }

    public void setShop_shop_ids(String shop_shop_ids) {
        this.shop_shop_ids = shop_shop_ids;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getOrder_monthcount() {
        return order_monthcount;
    }

    public void setOrder_monthcount(int order_monthcount) {
        this.order_monthcount = order_monthcount;
    }

    public String getAdmin_tel() {
        return admin_tel;
    }

    public void setAdmin_tel(String admin_tel) {
        this.admin_tel = admin_tel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getState_text() {
        return state_text;
    }

    public void setState_text(String state_text) {
        this.state_text = state_text;
    }
}
