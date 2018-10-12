package com.hualong.kekemei.bean;

import java.util.List;

public class MiaoshaBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1538726974
     * data : [{"id":1,"name":"12:00专场","starttimes":"12:00:00","endtimes":"13:00:00","project_project_ids":"3,4","state":"1","state_text":"正常"}]
     */

    private int code;
    private String msg;
    private String time;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 12:00专场
         * starttimes : 12:00:00
         * endtimes : 13:00:00
         * project_project_ids : 3,4
         * state : 1
         * state_text : 正常
         */

        private int id;
        private String name;
        private String starttimes;
        private String endtimes;
        private String project_project_ids;
        private String state;
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

        public String getStarttimes() {
            return starttimes;
        }

        public void setStarttimes(String starttimes) {
            this.starttimes = starttimes;
        }

        public String getEndtimes() {
            return endtimes;
        }

        public void setEndtimes(String endtimes) {
            this.endtimes = endtimes;
        }

        public String getProject_project_ids() {
            return project_project_ids;
        }

        public void setProject_project_ids(String project_project_ids) {
            this.project_project_ids = project_project_ids;
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
    }
}
