package com.kekemei.kekemei.bean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class BaseBean {

    /**
     * id : 1
     * name : 蒙贝面部紧致提升
     * project_category_id : 3
     * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
     * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
     * price_market : 0
     * price_discount : 100
     * treatment_price : 0.00
     * price_newmember : 0
     * price_member : 0
     * price_second : 0
     * treatment_count : 0
     * quality :
     * content : 测试测试测试测试测试
     * coupon_ids : 1
     * redenvelopes_ids : 1
     * state : 2
     * weigh : 100
     * views : 0
     * createtime : 1538449687
     * redenvelopes : ["111111"]
     * coupon : ["满599减50"]
     * distance : 0.95
     * quality_text :
     * state_text : 推荐
     */

    private int id;
    private String name;
    private int project_category_id;
    private String image;
    private String images;
    private int price_market;
    private int price_discount;
    private String treatment_price;
    private int price_newmember;
    private int price_member;
    private int price_second;
    private String treatment_count;
    private String quality;
    private String content;
    private String coupon_ids;
    private String redenvelopes_ids;
    private String state;
    private int weigh;
    private int views;
    private int createtime;
    private double distance;
    private String quality_text;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoupon_ids() {
        return coupon_ids;
    }

    public void setCoupon_ids(String coupon_ids) {
        this.coupon_ids = coupon_ids;
    }

    public String getRedenvelopes_ids() {
        return redenvelopes_ids;
    }

    public void setRedenvelopes_ids(String redenvelopes_ids) {
        this.redenvelopes_ids = redenvelopes_ids;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getQuality_text() {
        return quality_text;
    }

    public void setQuality_text(String quality_text) {
        this.quality_text = quality_text;
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
