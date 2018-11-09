package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;

public class BannerBean {
    /**
     * id : 3
     * title : 杀Banner广告
     * adv_pos_id : 10344
     * content : 杀Banner广告
     * views : 0
     * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
     * starttime : 2018-10-16 21:01:31
     * endtime : 2018-10-16 21:01:31
     * createtime : 1539694959
     * switch : 1
     */

    private int id;
    private String title;
    private int adv_pos_id;
    private String content;
    private int views;
    private String image;
    private String starttime;
    private String endtime;
    private int createtime;
    @SerializedName("switch")
    private int switchX;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAdv_pos_id() {
        return adv_pos_id;
    }

    public void setAdv_pos_id(int adv_pos_id) {
        this.adv_pos_id = adv_pos_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public int getSwitchX() {
        return switchX;
    }

    public void setSwitchX(int switchX) {
        this.switchX = switchX;
    }
}