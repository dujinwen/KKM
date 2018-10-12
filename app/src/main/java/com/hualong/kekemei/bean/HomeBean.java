package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/9.
 */

public class HomeBean {
    /**
     * code : 1
     * msg : 请求成功
     * time : 1539313408
     * data : {"beautician":[{"id":1,"name":"美容师","user_id":1,"shop_ids":"1,2","content":"3333333","state":"1","state_text":"State 1"},{"id":2,"name":"5555","user_id":1,"shop_ids":"2,1","content":"fwfw","state":"2","state_text":"State 2"}],"shop":[{"id":1,"name":"西直门店","image":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","images":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","city":"北京/北京市/西城区","address":"2222","tel":"2222","longitude":"2222","latitude":"2222","content":"2222","state":"1","createtime":1537862188,"user_id":1,"state_text":"State 1"},{"id":2,"name":"德胜门店","image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","city":"北京/北京市/西城区","address":"1111","tel":"111111","longitude":"11111","latitude":"1111","content":"11111","state":"1","createtime":1538567762,"user_id":1,"state_text":"State 1"}],"banneradv":[{"id":1,"title":"测试","adv_pos_id":10339,"content":"测试","views":0,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","starttime":"2018-10-01 10:38:27","endtime":"2018-10-01 10:38:27","createtime":1538361648,"switch":1},{"id":2,"title":"测试","adv_pos_id":10343,"content":"测试","views":0,"image":"/assets/img/qrcode.png","starttime":"2018-10-01 11:02:50","endtime":"2018-10-01 11:02:50","createtime":1538363019,"switch":1}],"hotdata":[{"id":1,"name":"热门项目","project_category_id":3,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"2","weigh":100,"views":0,"createtime":1538449687,"quality_text":"","flag_text":"","state_text":"State 2"},{"id":2,"name":"5555","project_category_id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":555,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:19:22","activitytime_end":"2018-10-02 11:19:22","content":"55555","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"1","weigh":100,"views":0,"createtime":1538450467,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":3,"name":"会员区","project_category_id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"1","weigh":100,"views":0,"createtime":1538452488,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":4,"name":"新人","project_category_id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"1","weigh":4,"views":0,"createtime":1538487574,"quality_text":"","flag_text":"","state_text":"State 1"}],"specialdata":[{"id":1,"name":"热门项目","project_category_id":3,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"2","weigh":100,"views":0,"createtime":1538449687,"quality_text":"","flag_text":"","state_text":"State 2"}],"newmemberdata":[{"id":4,"name":"新人","project_category_id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"1","weigh":4,"views":0,"createtime":1538487574,"quality_text":"","flag_text":"","state_text":"State 1"}],"memberdata":[{"id":3,"name":"会员区","project_category_id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","redenvelopes_ids":"1","coupon_ids":null,"state":"1","weigh":100,"views":0,"createtime":1538452488,"quality_text":"","flag_text":"","state_text":"State 1"}],"commentdata":[{"id":1,"user_id":1,"project_id":3,"shop_id":1,"beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":2,"user_id":1,"project_id":4,"shop_id":2,"beautician_id":1,"comment_tag_ids":"5","order_id":0,"content":"y4y4y54","start":"3","state":"1","createtime":1538619998,"satisfaction":"0","switch":1,"start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 0"},{"id":3,"user_id":1,"project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"3","order_id":1,"content":"fewfewfw","start":"1","state":"1","createtime":1538645747,"satisfaction":"2","switch":1,"start_text":"Start 1","state_text":"State 1","satisfaction_text":"Satisfaction 2"}]}
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
        private List<BeauticianBean> beautician;
        private List<ShopBean> shop;
        private List<BanneradvBean> banneradv;
        private List<HotdataBean> hotdata;
        private List<SpecialdataBean> specialdata;
        private List<NewmemberdataBean> newmemberdata;
        private List<MemberdataBean> memberdata;
        private List<CommentdataBean> commentdata;

        public List<BeauticianBean> getBeautician() {
            return beautician;
        }

        public void setBeautician(List<BeauticianBean> beautician) {
            this.beautician = beautician;
        }

        public List<ShopBean> getShop() {
            return shop;
        }

        public void setShop(List<ShopBean> shop) {
            this.shop = shop;
        }

        public List<BanneradvBean> getBanneradv() {
            return banneradv;
        }

        public void setBanneradv(List<BanneradvBean> banneradv) {
            this.banneradv = banneradv;
        }

        public List<HotdataBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<HotdataBean> hotdata) {
            this.hotdata = hotdata;
        }

        public List<SpecialdataBean> getSpecialdata() {
            return specialdata;
        }

        public void setSpecialdata(List<SpecialdataBean> specialdata) {
            this.specialdata = specialdata;
        }

        public List<NewmemberdataBean> getNewmemberdata() {
            return newmemberdata;
        }

        public void setNewmemberdata(List<NewmemberdataBean> newmemberdata) {
            this.newmemberdata = newmemberdata;
        }

        public List<MemberdataBean> getMemberdata() {
            return memberdata;
        }

        public void setMemberdata(List<MemberdataBean> memberdata) {
            this.memberdata = memberdata;
        }

        public List<CommentdataBean> getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(List<CommentdataBean> commentdata) {
            this.commentdata = commentdata;
        }

        public static class BeauticianBean {
            /**
             * id : 1
             * name : 美容师
             * user_id : 1
             * shop_ids : 1,2
             * content : 3333333
             * state : 1
             * state_text : State 1
             */

            private int id;
            private String name;
            private int user_id;
            private String shop_ids;
            private String content;
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

            public String getShop_ids() {
                return shop_ids;
            }

            public void setShop_ids(String shop_ids) {
                this.shop_ids = shop_ids;
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

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class ShopBean {
            /**
             * id : 1
             * name : 西直门店
             * image : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * images : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * city : 北京/北京市/西城区
             * address : 2222
             * tel : 2222
             * longitude : 2222
             * latitude : 2222
             * content : 2222
             * state : 1
             * createtime : 1537862188
             * user_id : 1
             * state_text : State 1
             */

            private int id;
            private String name;
            private String image;
            private String images;
            private String city;
            private String address;
            private String tel;
            private String longitude;
            private String latitude;
            private String content;
            private String state;
            private int createtime;
            private int user_id;
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

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class BanneradvBean {
            /**
             * id : 1
             * title : 测试
             * adv_pos_id : 10339
             * content : 测试
             * views : 0
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * starttime : 2018-10-01 10:38:27
             * endtime : 2018-10-01 10:38:27
             * createtime : 1538361648
             * switch : 1
             */

            private int id;
            private String title;
            private int adv_pos_id;
            private String content;
            private int views;
            private String image;
            private String starttime;
            private String endtime;
            private int createtime;
            @SerializedName("switch")
            private int switchX;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getAdv_pos_id() {
                return adv_pos_id;
            }

            public void setAdv_pos_id(int adv_pos_id) {
                this.adv_pos_id = adv_pos_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }
        }

        public static class HotdataBean extends BaseBean{
            /**
             * id : 1
             * name : 热门项目
             * project_category_id : 3
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * price : 150
             * price_market : 0
             * price_discount : 0
             * treatment_price : 0.00
             * price_newmember : 0
             * price_member : 0
             * price_second : 0
             * treatment_count : 0
             * quality :
             * activitytime : 2018-10-02 11:01:59
             * activitytime_end : 2018-10-02 11:01:59
             * content : 测试测试测试测试测试
             * flag :
             * redenvelopes_ids : 1
             * coupon_ids : null
             * state : 2
             * weigh : 100
             * views : 0
             * createtime : 1538449687
             * quality_text :
             * flag_text :
             * state_text : State 2
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private double price;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String activitytime;
            private String activitytime_end;
            private String content;
            private String flag;
            private String redenvelopes_ids;
            private Object coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String flag_text;
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

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
            }

            public Object getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(Object coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class SpecialdataBean extends BaseBean{
            /**
             * id : 1
             * name : 热门项目
             * project_category_id : 3
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * price : 150
             * price_market : 0
             * price_discount : 0
             * treatment_price : 0.00
             * price_newmember : 0
             * price_member : 0
             * price_second : 0
             * treatment_count : 0
             * quality :
             * activitytime : 2018-10-02 11:01:59
             * activitytime_end : 2018-10-02 11:01:59
             * content : 测试测试测试测试测试
             * flag :
             * redenvelopes_ids : 1
             * coupon_ids : null
             * state : 2
             * weigh : 100
             * views : 0
             * createtime : 1538449687
             * quality_text :
             * flag_text :
             * state_text : State 2
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private double price;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String activitytime;
            private String activitytime_end;
            private String content;
            private String flag;
            private String redenvelopes_ids;
            private Object coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String flag_text;
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

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
            }

            public Object getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(Object coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class NewmemberdataBean extends BaseBean{
            /**
             * id : 4
             * name : 新人
             * project_category_id : 1
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * price : 55
             * price_market : 0
             * price_discount : 0
             * treatment_price : 44.00
             * price_newmember : 33
             * price_member : 0
             * price_second : 0
             * treatment_count : 3
             * quality :
             * activitytime : 2018-10-02 21:38:44
             * activitytime_end : 2018-10-02 21:38:44
             * content : 55
             * flag :
             * redenvelopes_ids : 1
             * coupon_ids : null
             * state : 1
             * weigh : 4
             * views : 0
             * createtime : 1538487574
             * quality_text :
             * flag_text :
             * state_text : State 1
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private double price;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String activitytime;
            private String activitytime_end;
            private String content;
            private String flag;
            private String redenvelopes_ids;
            private Object coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String flag_text;
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

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
            }

            public Object getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(Object coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class MemberdataBean extends BaseBean{
            /**
             * id : 3
             * name : 会员区
             * project_category_id : 2
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * price : 665.83
             * price_market : 0
             * price_discount : 0
             * treatment_price : 55.00
             * price_newmember : 0
             * price_member : 555
             * price_second : 0
             * treatment_count : 0
             * quality :
             * activitytime : 2018-10-02 11:53:50
             * activitytime_end : 2018-10-02 11:53:50
             * content : 1111
             * flag :
             * redenvelopes_ids : 1
             * coupon_ids : null
             * state : 1
             * weigh : 100
             * views : 0
             * createtime : 1538452488
             * quality_text :
             * flag_text :
             * state_text : State 1
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private double price;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String activitytime;
            private String activitytime_end;
            private String content;
            private String flag;
            private String redenvelopes_ids;
            private Object coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String flag_text;
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

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
            }

            public Object getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(Object coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }

        public static class CommentdataBean {
            /**
             * id : 1
             * user_id : 1
             * project_id : 3
             * shop_id : 1
             * beautician_id : 1
             * comment_tag_ids : 5,3
             * order_id : 0
             * content : 很好
             * start : 3
             * state : 1
             * createtime : 1538469581
             * satisfaction : 2
             * switch : 1
             * start_text : Start 3
             * state_text : State 1
             * satisfaction_text : Satisfaction 2
             */

            private int id;
            private int user_id;
            private int project_id;
            private int shop_id;
            private int beautician_id;
            private String comment_tag_ids;
            private int order_id;
            private String content;
            private String start;
            private String state;
            private int createtime;
            private String satisfaction;
            @SerializedName("switch")
            private int switchX;
            private String start_text;
            private String state_text;
            private String satisfaction_text;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getProject_id() {
                return project_id;
            }

            public void setProject_id(int project_id) {
                this.project_id = project_id;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getBeautician_id() {
                return beautician_id;
            }

            public void setBeautician_id(int beautician_id) {
                this.beautician_id = beautician_id;
            }

            public String getComment_tag_ids() {
                return comment_tag_ids;
            }

            public void setComment_tag_ids(String comment_tag_ids) {
                this.comment_tag_ids = comment_tag_ids;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
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

            public String getSatisfaction() {
                return satisfaction;
            }

            public void setSatisfaction(String satisfaction) {
                this.satisfaction = satisfaction;
            }

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }

            public String getStart_text() {
                return start_text;
            }

            public void setStart_text(String start_text) {
                this.start_text = start_text;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public String getSatisfaction_text() {
                return satisfaction_text;
            }

            public void setSatisfaction_text(String satisfaction_text) {
                this.satisfaction_text = satisfaction_text;
            }
        }
    }
}
