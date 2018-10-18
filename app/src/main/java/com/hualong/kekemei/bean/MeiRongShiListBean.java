package com.hualong.kekemei.bean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/16.
 */

public class MeiRongShiListBean {
    /**
     * code : 1
     * data : [{"content":"3333333","distance":"","id":1,"name":"美容师","order":1,"satisfaction":0.5,"shop_ids":"1,2","shops":["西直门店","德胜门店"],"start":3,"state":"1","state_text":"正常","tag":["5","3"],"tag_text":["干净卫生","技师专业"],"user_id":1,"user_nickname":"admin"},{"content":"fwfw","distance":"","id":2,"name":"5555","order":1,"satisfaction":0.5,"shop_ids":"2,1","shops":["德胜门店","西直门店"],"start":3,"state":"2","state_text":"推荐","tag":["5","3"],"tag_text":["干净卫生","技师专业"],"user_id":1,"user_nickname":"admin"}]
     * msg : 请求成功
     * time : 1539680434
     */

    private int code;
    private String msg;
    private String time;
    private List<BeauticianBean> data;

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

    public List<BeauticianBean> getData() {
        return data;
    }

    public void setData(List<BeauticianBean> data) {
        this.data = data;
    }

}
