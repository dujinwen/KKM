package com.kekemei.kekemei.bean;

/**
 * Created by caozhimin on 2018/11/8.
 */

public class UserInfoBean {

    /**
     * code : 1
     * data : {"avatar":"/assets/img/avatar.png","coupon_count":2,"createtime":1541997489,"expires_in":2592000,"expiretime":1544589489,"id":1,"isnew":0,"mobile":"13269501726","nickname":"admin","redenvelopes_count":0,"score":0,"token":"1a70f31e-6518-4b2d-9d39-10f98312d856","user_id":1,"username":"admin"}
     * msg : 请求成功
     * time : 1541997489
     */

    private int code;
    private DataBean data;
    private String msg;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * avatar : /assets/img/avatar.png
         * coupon_count : 2
         * createtime : 1541997489
         * expires_in : 2592000
         * expiretime : 1544589489
         * id : 1
         * isnew : 0
         * mobile : 13269501726
         * nickname : admin
         * redenvelopes_count : 0
         * score : 0
         * token : 1a70f31e-6518-4b2d-9d39-10f98312d856
         * user_id : 1
         * username : admin
         */

        private String avatar;
        private int coupon_count;
        private int createtime;
        private int expires_in;
        private int expiretime;
        private int id;
        private int isnew;
        private String mobile;
        private String nickname;
        private int redenvelopes_count;
        private int score;
        private String token;
        private int user_id;
        private String username;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCoupon_count() {
            return coupon_count;
        }

        public void setCoupon_count(int coupon_count) {
            this.coupon_count = coupon_count;
        }

        public int getCreatetime() {
            return createtime;
        }

        public void setCreatetime(int createtime) {
            this.createtime = createtime;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public int getExpiretime() {
            return expiretime;
        }

        public void setExpiretime(int expiretime) {
            this.expiretime = expiretime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsnew() {
            return isnew;
        }

        public void setIsnew(int isnew) {
            this.isnew = isnew;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getRedenvelopes_count() {
            return redenvelopes_count;
        }

        public void setRedenvelopes_count(int redenvelopes_count) {
            this.redenvelopes_count = redenvelopes_count;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
