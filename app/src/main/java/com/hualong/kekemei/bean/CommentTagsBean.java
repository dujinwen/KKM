package com.hualong.kekemei.bean;

import java.util.List;

public class CommentTagsBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1540123385
     * data : ["服务热情","技师专业"]
     */

    private int code;
    private String msg;
    private String time;
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
