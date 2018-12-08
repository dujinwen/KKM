package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CommentListBean {
    private List<EvaluateBean> reply;
    @SerializedName("new")
    private List<EvaluateBean> newX;

    public List<EvaluateBean> getReply() {
        return reply;
    }

    public void setReply(List<EvaluateBean> reply) {
        this.reply = reply;
    }

    public List<EvaluateBean> getNewX() {
        return newX;
    }

    public void setNewX(List<EvaluateBean> newX) {
        this.newX = newX;
    }
}
