package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

public class EvaluateBean{
    /**
     * id : 1
     * user_id : 1
     * project_id : 3
     * project_project_id : 3
     * shop_id : 1
     * beautician_id : 1
     * comment_tag_ids : 5,3
     * order_id : 0
     * content : 很好
     * images :
     * type : 1
     * start : 3
     * state : 1
     * createtime : 1538469581
     * satisfaction : 2
     * switch : 1
     * type_text : Type 1
     * start_text : Start 3
     * state_text : State 1
     * satisfaction_text : Satisfaction 2
     */

    private int project_project_id;
    private String images;
    private String type;
    private String type_text;
    private int id;
    private int user_id;
    private int project_id;
    private int shop_id;
    private int beautician_id;
    private String comment_tag_ids;
    private int order_id;
    private String content;
    private float start;
    private String state;
    private int createtime;
    private String satisfaction;
    @SerializedName("switch")
    private int switchX;
    private String start_text;
    private String state_text;
    private String satisfaction_text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getBeautician_id() {
        return beautician_id;
    }

    public void setBeautician_id(int beautician_id) {
        this.beautician_id = beautician_id;
    }

    public String getComment_tag_ids() {
        return comment_tag_ids;
    }

    public void setComment_tag_ids(String comment_tag_ids) {
        this.comment_tag_ids = comment_tag_ids;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
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

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public int getSwitchX() {
        return switchX;
    }

    public void setSwitchX(int switchX) {
        this.switchX = switchX;
    }

    public String getStart_text() {
        return start_text;
    }

    public void setStart_text(String start_text) {
        this.start_text = start_text;
    }

    public String getState_text() {
        return state_text;
    }

    public void setState_text(String state_text) {
        this.state_text = state_text;
    }

    public String getSatisfaction_text() {
        return satisfaction_text;
    }

    public void setSatisfaction_text(String satisfaction_text) {
        this.satisfaction_text = satisfaction_text;
    }

    public int getProject_project_id() {
        return project_project_id;
    }

    public void setProject_project_id(int project_project_id) {
        this.project_project_id = project_project_id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_text() {
        return type_text;
    }

    public void setType_text(String type_text) {
        this.type_text = type_text;
    }
}
