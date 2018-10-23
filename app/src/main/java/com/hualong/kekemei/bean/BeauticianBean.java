package com.hualong.kekemei.bean;

import java.util.List;

/**
 * 美容师
 */
public class BeauticianBean {
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
     * image : /uploads/20181022/63b5dc1f595937b86f1a7ad7e21185fa.jpg
     * images : /uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg
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
    private String image;
    private String images;

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
}
