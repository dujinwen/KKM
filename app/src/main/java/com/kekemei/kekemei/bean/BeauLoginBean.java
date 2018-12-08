package com.kekemei.kekemei.bean;

public class BeauLoginBean {

    /**
     * code : 1
     * data : {"content":"专业美容师","coupon_ids":1,"id":2,"identity":"身份证","image":"/uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","name":"专业美容师","place":"籍贯","redenvelopes_ids":1,"shop_shop_ids":"2,1","speciality":"特长","state":"2","state_text":"State 2","user_id":2}
     * msg : 登陆成功
     * time : 1543823298
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
         * content : 专业美容师
         * coupon_ids : 1
         * id : 2
         * identity : 身份证
         * image : /uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg
         * images : /uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
         * name : 专业美容师
         * place : 籍贯
         * redenvelopes_ids : 1
         * shop_shop_ids : 2,1
         * speciality : 特长
         * state : 2
         * state_text : State 2
         * user_id : 2
         */

        private String content;
        private int coupon_ids;
        private int id;
        private String identity;
        private String image;
        private String images;
        private String name;
        private String place;
        private int redenvelopes_ids;
        private String shop_shop_ids;
        private String speciality;
        private String state;
        private String state_text;
        private int user_id;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCoupon_ids() {
            return coupon_ids;
        }

        public void setCoupon_ids(int coupon_ids) {
            this.coupon_ids = coupon_ids;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getRedenvelopes_ids() {
            return redenvelopes_ids;
        }

        public void setRedenvelopes_ids(int redenvelopes_ids) {
            this.redenvelopes_ids = redenvelopes_ids;
        }

        public String getShop_shop_ids() {
            return shop_shop_ids;
        }

        public void setShop_shop_ids(String shop_shop_ids) {
            this.shop_shop_ids = shop_shop_ids;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
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
    }
}
