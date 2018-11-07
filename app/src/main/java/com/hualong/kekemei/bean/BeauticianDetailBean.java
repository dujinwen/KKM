package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeauticianDetailBean {

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

        private int id;
        private String name;
        private int user_id;
        private int redenvelopes_ids;
        private int coupon_ids;
        private String image;
        private String images;
        private String shop_shop_ids;
        private String content;
        private String place;
        private String speciality;
        private String identity;
        private String state;
        private String nickname;
        private int isfriend;
        private int friend_count;
        private int order_count;
        private int comment_count;
        private int average_price;
        private List<String> auth;
        private List<CouponBean> coupon;
        private List<RedEnvelopes> redenvelopes;
        private int start;
        private String satisfaction;
        private List<CommentTagBean> comment_tag;
        private String address;
        private int like_people;
        private String state_text;
        private List<String> shop_text;
        private List<String> strading;
        private List<BaseBean> hotdata;
        private List<BaseBean> specialdata;
        private List<BaseBean> newmemberdata;
        private List<BaseBean> memberdata;
        private List<RecBeauticianBean> rec_beautician;
        private CommentdataBean commentdata;

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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getRedenvelopes_ids() {
            return redenvelopes_ids;
        }

        public void setRedenvelopes_ids(int redenvelopes_ids) {
            this.redenvelopes_ids = redenvelopes_ids;
        }

        public int getCoupon_ids() {
            return coupon_ids;
        }

        public void setCoupon_ids(int coupon_ids) {
            this.coupon_ids = coupon_ids;
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

        public String getShop_shop_ids() {
            return shop_shop_ids;
        }

        public void setShop_shop_ids(String shop_shop_ids) {
            this.shop_shop_ids = shop_shop_ids;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getIsfriend() {
            return isfriend;
        }

        public void setIsfriend(int isfriend) {
            this.isfriend = isfriend;
        }

        public int getFriend_count() {
            return friend_count;
        }

        public void setFriend_count(int friend_count) {
            this.friend_count = friend_count;
        }

        public int getOrder_count() {
            return order_count;
        }

        public void setOrder_count(int order_count) {
            this.order_count = order_count;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getAverage_price() {
            return average_price;
        }

        public void setAverage_price(int average_price) {
            this.average_price = average_price;
        }

        public List<String> getAuth() {
            return auth;
        }

        public void setAuth(List<String> auth) {
            this.auth = auth;
        }

        public List<CouponBean> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<CouponBean> coupon) {
            this.coupon = coupon;
        }

        public List<RedEnvelopes> getRedenvelopes() {
            return redenvelopes;
        }

        public void setRedenvelopes(List<RedEnvelopes> redenvelopes) {
            this.redenvelopes = redenvelopes;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public String getSatisfaction() {
            return satisfaction;
        }

        public void setSatisfaction(String satisfaction) {
            this.satisfaction = satisfaction;
        }

        public List<CommentTagBean> getComment_tag() {
            return comment_tag;
        }

        public void setComment_tag(List<CommentTagBean> comment_tag) {
            this.comment_tag = comment_tag;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getLike_people() {
            return like_people;
        }

        public void setLike_people(int like_people) {
            this.like_people = like_people;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public List<String> getShop_text() {
            return shop_text;
        }

        public void setShop_text(List<String> shop_text) {
            this.shop_text = shop_text;
        }

        public List<String> getStrading() {
            return strading;
        }

        public void setStrading(List<String> strading) {
            this.strading = strading;
        }

        public List<BaseBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<BaseBean> hotdata) {
            this.hotdata = hotdata;
        }

        public List<BaseBean> getSpecialdata() {
            return specialdata;
        }

        public void setSpecialdata(List<BaseBean> specialdata) {
            this.specialdata = specialdata;
        }

        public List<BaseBean> getNewmemberdata() {
            return newmemberdata;
        }

        public void setNewmemberdata(List<BaseBean> newmemberdata) {
            this.newmemberdata = newmemberdata;
        }

        public List<BaseBean> getMemberdata() {
            return memberdata;
        }

        public void setMemberdata(List<BaseBean> memberdata) {
            this.memberdata = memberdata;
        }

        public List<RecBeauticianBean> getRec_beautician() {
            return rec_beautician;
        }

        public void setRec_beautician(List<RecBeauticianBean> rec_beautician) {
            this.rec_beautician = rec_beautician;
        }

        public CommentdataBean getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(CommentdataBean commentdata) {
            this.commentdata = commentdata;
        }

        public static class CommentdataBean {
            private List<EvaluateBean> all;
            @SerializedName("new")
            private List<EvaluateBean> newX;
            private List<EvaluateBean> haveimg;

            public List<EvaluateBean> getAll() {
                return all;
            }

            public void setAll(List<EvaluateBean> all) {
                this.all = all;
            }

            public List<EvaluateBean> getNewX() {
                return newX;
            }

            public void setNewX(List<EvaluateBean> newX) {
                this.newX = newX;
            }

            public List<EvaluateBean> getHaveimg() {
                return haveimg;
            }

            public void setHaveimg(List<EvaluateBean> haveimg) {
                this.haveimg = haveimg;
            }
        }

        public static class CommentTagBean {

            /**
             * id : 3
             * name : 美容师专业
             * state : 1
             * weigh : 0
             * tag_type : 1
             * state_text : 正常
             * tag_type_text : 美容师
             */

            private int id;
            private String name;
            private String state;
            private int weigh;
            private String tag_type;
            private String state_text;
            private String tag_type_text;

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

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }

            public String getTag_type() {
                return tag_type;
            }

            public void setTag_type(String tag_type) {
                this.tag_type = tag_type;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public String getTag_type_text() {
                return tag_type_text;
            }

            public void setTag_type_text(String tag_type_text) {
                this.tag_type_text = tag_type_text;
            }
        }

        public static class RedEnvelopes {

            /**
             * count : 9
             * createtime : 1537844659
             * id : 1
             * image : /assets/img/qrcode.png
             * name : 111111
             * price_reduction : 100
             * price_satisfy : 0
             * state : 1
             * state_text : 正常
             * type : 1
             * type_text : Type 1
             */

            private int count;
            private int createtime;
            private int id;
            private String image;
            private String name;
            private int price_reduction;
            private int price_satisfy;
            private String state;
            private String state_text;
            private String type;
            private String type_text;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice_reduction() {
                return price_reduction;
            }

            public void setPrice_reduction(int price_reduction) {
                this.price_reduction = price_reduction;
            }

            public int getPrice_satisfy() {
                return price_satisfy;
            }

            public void setPrice_satisfy(int price_satisfy) {
                this.price_satisfy = price_satisfy;
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

        public static class CouponBean {
            /**
             * id : 1
             * name : 111111
             * type : 1
             * price_satisfy : 0
             * price_reduction : 100
             * image : /assets/img/qrcode.png
             * count : 9
             * state : 1
             * createtime : 1537844659
             * type_text : Type 1
             * state_text : 正常
             */

            private int id;
            private String name;
            private String type;
            private int price_satisfy;
            private int price_reduction;
            private String image;
            private int count;
            private String state;
            private int createtime;
            private String type_text;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getPrice_satisfy() {
                return price_satisfy;
            }

            public void setPrice_satisfy(int price_satisfy) {
                this.price_satisfy = price_satisfy;
            }

            public int getPrice_reduction() {
                return price_reduction;
            }

            public void setPrice_reduction(int price_reduction) {
                this.price_reduction = price_reduction;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
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

            public String getType_text() {
                return type_text;
            }

            public void setType_text(String type_text) {
                this.type_text = type_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }
    }

    public static class RecBeauticianBean {
        /**
         * id : 2
         * name : 专业美容师
         * user_id : 2
         * redenvelopes_ids : 1
         * coupon_ids : 1
         * image : /uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg
         * images : /uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
         * shop_shop_ids : 2,1
         * content : fwfw
         * place : 籍贯
         * speciality : 特长
         * identity : 身份证
         * state : 2
         * state_text : 推荐
         */

        private int id;
        private String name;
        private int user_id;
        private int redenvelopes_ids;
        private int coupon_ids;
        private String image;
        private String images;
        private String shop_shop_ids;
        private String content;
        private String place;
        private String speciality;
        private String identity;
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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getRedenvelopes_ids() {
            return redenvelopes_ids;
        }

        public void setRedenvelopes_ids(int redenvelopes_ids) {
            this.redenvelopes_ids = redenvelopes_ids;
        }

        public int getCoupon_ids() {
            return coupon_ids;
        }

        public void setCoupon_ids(int coupon_ids) {
            this.coupon_ids = coupon_ids;
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

        public String getShop_shop_ids() {
            return shop_shop_ids;
        }

        public void setShop_shop_ids(String shop_shop_ids) {
            this.shop_shop_ids = shop_shop_ids;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
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
