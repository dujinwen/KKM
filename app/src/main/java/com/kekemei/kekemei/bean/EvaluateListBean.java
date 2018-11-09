package com.kekemei.kekemei.bean;

import java.util.List;

public class EvaluateListBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1538795891
     * data : [{"id":1,"user_id":1,"project_id":3,"shop_id":1,"beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":2,"user_id":1,"project_id":4,"shop_id":2,"beautician_id":1,"comment_tag_ids":"5","order_id":0,"content":"y4y4y54","start":"3","state":"1","createtime":1538619998,"satisfaction":"0","switch":1,"start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 0"},{"id":3,"user_id":1,"project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"3","order_id":1,"content":"fewfewfw","start":"1","state":"1","createtime":1538645747,"satisfaction":"2","switch":1,"start_text":"Start 1","state_text":"State 1","satisfaction_text":"Satisfaction 2"}]
     */

    private int code;
    private String msg;
    private String time;
    private List<EvaluateBean> data;

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

    public List<EvaluateBean> getData() {
        return data;
    }

    public void setData(List<EvaluateBean> data) {
        this.data = data;
    }
}
