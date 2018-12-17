package com.kekemei.kekemei.bean;

public class OrderCountBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1545059273
     * data : {"state0":45,"state1":1,"state5":3,"state10":0}
     */

    private int code;
    private String msg;
    private String time;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * state0 : 45
         * state1 : 1
         * state5 : 3
         * state10 : 0
         */

        private int state0;
        private int state1;
        private int state5;
        private int state10;

        public int getState0() {
            return state0;
        }

        public void setState0(int state0) {
            this.state0 = state0;
        }

        public int getState1() {
            return state1;
        }

        public void setState1(int state1) {
            this.state1 = state1;
        }

        public int getState5() {
            return state5;
        }

        public void setState5(int state5) {
            this.state5 = state5;
        }

        public int getState10() {
            return state10;
        }

        public void setState10(int state10) {
            this.state10 = state10;
        }
    }
}
