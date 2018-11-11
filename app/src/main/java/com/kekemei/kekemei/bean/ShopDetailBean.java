package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopDetailBean {
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
        private String image;
        private String images;
        private String city;
        private int redenvelopes_ids;
        private int coupon_ids;
        private String address;
        private String tel;
        private String longitude;
        private String latitude;
        private String content;
        private String state;
        private int createtime;
        private String shop_service_ids;
        private int user_id;
        private int order_count;
        private int collection_count;
        private int iscollection;
        private String satisfaction;
        private String peer;
        private String distance;
        private int start;
        private String state_text;
        private CommentdataBean commentdata;
        private List<ServiceBean> service;
        private List<CouponBean> coupon;
        private List<RedenvelopesBean> redenvelopes;
        private List<BeauticianBean> beautician;
        private List<String> strading;
        private List<BaseBean> hotdata;
        private List<BaseBean> specialdata;
        private List<BaseBean> newmemberdata;
        private List<BaseBean> memberdata;

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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getShop_service_ids() {
            return shop_service_ids;
        }

        public void setShop_service_ids(String shop_service_ids) {
            this.shop_service_ids = shop_service_ids;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getOrder_count() {
            return order_count;
        }

        public void setOrder_count(int order_count) {
            this.order_count = order_count;
        }

        public int getCollection_count() {
            return collection_count;
        }

        public void setCollection_count(int collection_count) {
            this.collection_count = collection_count;
        }

        public int getIscollection() {
            return iscollection;
        }

        public void setIscollection(int iscollection) {
            this.iscollection = iscollection;
        }

        public String getSatisfaction() {
            return satisfaction;
        }

        public void setSatisfaction(String satisfaction) {
            this.satisfaction = satisfaction;
        }

        public String getPeer() {
            return peer;
        }

        public void setPeer(String peer) {
            this.peer = peer;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public CommentdataBean getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(CommentdataBean commentdata) {
            this.commentdata = commentdata;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public List<ServiceBean> getService() {
            return service;
        }

        public void setService(List<ServiceBean> service) {
            this.service = service;
        }

        public List<CouponBean> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<CouponBean> coupon) {
            this.coupon = coupon;
        }

        public List<RedenvelopesBean> getRedenvelopes() {
            return redenvelopes;
        }

        public void setRedenvelopes(List<RedenvelopesBean> redenvelopes) {
            this.redenvelopes = redenvelopes;
        }

        public List<BeauticianBean> getBeautician() {
            return beautician;
        }

        public void setBeautician(List<BeauticianBean> beautician) {
            this.beautician = beautician;
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

        public static class CommentdataBean {

            /**
             * tags : [{"id":3,"name":"美容师专业","state":"1","weigh":0,"tag_type":"1","state_text":"正常","tag_type_text":"Tag_type 1"},{"id":5,"name":"干净卫生","state":"1","weigh":0,"tag_type":"2","state_text":"正常","tag_type_text":"Tag_type 2"}]
             * count : 1
             * all : [{"id":1,"user_id":1,"project_project_id":3,"shop_shop_id":1,"beautician_beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","images":"","coment_type":"1","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"nickname":"admin","user_avatar":"/assets/img/avatar.png","reply":null,"coment_type_text":"Coment_type 1","start_text":"Start 3","state_text":"正常","satisfaction_text":"Satisfaction 2"}]
             * new : [{"id":1,"user_id":1,"project_project_id":3,"shop_shop_id":1,"beautician_beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","images":"","coment_type":"1","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"nickname":"admin","user_avatar":"/assets/img/avatar.png","reply":null,"coment_type_text":"Coment_type 1","start_text":"Start 3","state_text":"正常","satisfaction_text":"Satisfaction 2"}]
             * haveimg : []
             */

            private int count;
            private List<CommentTagsBean> tags;
            private List<EvaluateBean> all;
            @SerializedName("new")
            private List<EvaluateBean> newX;
            private List<EvaluateBean> haveimg;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<CommentTagsBean> getTags() {
                return tags;
            }

            public void setTags(List<CommentTagsBean> tags) {
                this.tags = tags;
            }

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

        public static class ServiceBean {
            /**
             * id : 1
             * name : 品质保障
             */

            private int id;
            private String name;

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
        }

        public static class CouponBean {
            /**
             * id : 1
             * name : 满599减50
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * price_satisfy : 599
             * price_reduction : 50
             * activitytime : 2018-10-07 12:53:59
             * activitytime_end : 2019-07-27 12:53:59
             * createtime : 1538888184
             * weigh : 1
             * state : 1
             * statu : 1
             * state_text : 正常
             */

            private int id;
            private String name;
            private String image;
            private int price_satisfy;
            private int price_reduction;
            private String activitytime;
            private String activitytime_end;
            private int createtime;
            private int weigh;
            private String state;
            private int statu;
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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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

            public String getActivitytime() {
                return activitytime;
            }

            public void setActivitytime(String activitytime) {
                this.activitytime = activitytime;
            }

            public String getActivitytime_end() {
                return activitytime_end;
            }

            public void setActivitytime_end(String activitytime_end) {
                this.activitytime_end = activitytime_end;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getStatu() {
                return statu;
            }

            public void setStatu(int statu) {
                this.statu = statu;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class RedenvelopesBean {
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
}