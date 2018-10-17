package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class HomeBean {

    /**
     * code : 1
     * data : {"banneradv":[{"adv_pos_id":10339,"content":"测试","createtime":1538361648,"endtime":"2018-10-01 10:38:27","id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","starttime":"2018-10-01 10:38:27","switch":1,"title":"测试","views":0},{"adv_pos_id":10343,"content":"测试","createtime":1538363019,"endtime":"2018-10-01 11:02:50","id":2,"image":"/assets/img/qrcode.png","starttime":"2018-10-01 11:02:50","switch":1,"title":"测试","views":0}],"beautician":[{"content":"3333333","id":1,"name":"美容师","shop_ids":"1,2","state":"1","state_text":"State 1","user_id":1},{"content":"fwfw","id":2,"name":"5555","shop_ids":"2,1","state":"2","state_text":"State 2","user_id":1}],"commentdata":[{"beautician_id":1,"comment_tag_ids":"5,3","content":"很好","createtime":1538469581,"id":1,"order_id":0,"project_id":3,"satisfaction":"2","satisfaction_text":"Satisfaction 2","shop_id":1,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"user_id":1},{"beautician_id":1,"comment_tag_ids":"5","content":"y4y4y54","createtime":1538619998,"id":2,"order_id":0,"project_id":4,"satisfaction":"0","satisfaction_text":"Satisfaction 0","shop_id":2,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"user_id":1},{"beautician_id":2,"comment_tag_ids":"3","content":"fewfewfw","createtime":1538645747,"id":3,"order_id":1,"project_id":3,"satisfaction":"2","satisfaction_text":"Satisfaction 2","shop_id":2,"start":"1","start_text":"Start 1","state":"1","state_text":"State 1","switch":1,"user_id":1}],"hotdata":[{"activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","createtime":1538449687,"flag":"","flag_text":"","id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","name":"热门项目","price":150,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"2","state_text":"State 2","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"activitytime":"2018-10-02 11:19:22","activitytime_end":"2018-10-02 11:19:22","content":"55555","createtime":1538450467,"flag":"","flag_text":"","id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"5555","price":555,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":2,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","createtime":1538452488,"flag":"","flag_text":"","id":3,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"会员区","price":665.83,"price_discount":0,"price_market":0,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":2,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100},{"activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","createtime":1538487574,"flag":"","flag_text":"","id":4,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"新人","price":55,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"State 1","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"memberdata":[{"activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","createtime":1538452488,"flag":"","flag_text":"","id":3,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"会员区","price":665.83,"price_discount":0,"price_market":0,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":2,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100}],"newmemberdata":[{"activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","createtime":1538487574,"flag":"","flag_text":"","id":4,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"新人","price":55,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"State 1","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"shop":[{"address":"2222","city":"北京/北京市/西城区","content":"2222","createtime":1537862188,"id":1,"image":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","images":"/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","latitude":"2222","longitude":"2222","name":"西直门店","state":"1","state_text":"State 1","tel":"2222","user_id":1},{"address":"1111","city":"北京/北京市/西城区","content":"11111","createtime":1538567762,"id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","latitude":"1111","longitude":"11111","name":"德胜门店","state":"1","state_text":"State 1","tel":"111111","user_id":1}],"specialdata":[{"activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","createtime":1538449687,"flag":"","flag_text":"","id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg","name":"热门项目","price":150,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"2","state_text":"State 2","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100}]}
     * msg : 请求成功
     * time : 1539329956
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
        private List<BannerBean> banneradv;
        private List<BeauticianBean> beautician;
        private List<CommentdataBean> commentdata;
        private List<HotdataBean> hotdata;
        private List<MemberdataBean> memberdata;
        private List<NewmemberdataBean> newmemberdata;
        private List<ShopBean> shop;
        private List<SpecialdataBean> specialdata;

        public List<BannerBean> getBanneradv() {
            return banneradv;
        }

        public void setBanneradv(List<BannerBean> banneradv) {
            this.banneradv = banneradv;
        }

        public List<BeauticianBean> getBeautician() {
            return beautician;
        }

        public void setBeautician(List<BeauticianBean> beautician) {
            this.beautician = beautician;
        }

        public List<CommentdataBean> getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(List<CommentdataBean> commentdata) {
            this.commentdata = commentdata;
        }

        public List<HotdataBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<HotdataBean> hotdata) {
            this.hotdata = hotdata;
        }

        public List<MemberdataBean> getMemberdata() {
            return memberdata;
        }

        public void setMemberdata(List<MemberdataBean> memberdata) {
            this.memberdata = memberdata;
        }

        public List<NewmemberdataBean> getNewmemberdata() {
            return newmemberdata;
        }

        public void setNewmemberdata(List<NewmemberdataBean> newmemberdata) {
            this.newmemberdata = newmemberdata;
        }

        public List<ShopBean> getShop() {
            return shop;
        }

        public void setShop(List<ShopBean> shop) {
            this.shop = shop;
        }

        public List<SpecialdataBean> getSpecialdata() {
            return specialdata;
        }

        public void setSpecialdata(List<SpecialdataBean> specialdata) {
            this.specialdata = specialdata;
        }

        public static class BeauticianBean {
            /**
             * content : 3333333
             * id : 1
             * name : 美容师
             * shop_ids : 1,2
             * state : 1
             * state_text : State 1
             * user_id : 1
             */

            private String content;
            private int id;
            private String name;
            private String shop_ids;
            private String state;
            private String state_text;
            private int user_id;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

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

            public String getShop_ids() {
                return shop_ids;
            }

            public void setShop_ids(String shop_ids) {
                this.shop_ids = shop_ids;
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

        public static class CommentdataBean {
            /**
             * beautician_id : 1
             * comment_tag_ids : 5,3
             * content : 很好
             * createtime : 1538469581
             * id : 1
             * order_id : 0
             * project_id : 3
             * satisfaction : 2
             * satisfaction_text : Satisfaction 2
             * shop_id : 1
             * start : 3
             * start_text : Start 3
             * state : 1
             * state_text : State 1
             * switch : 1
             * user_id : 1
             */

            private int beautician_id;
            private String comment_tag_ids;
            private String content;
            private int createtime;
            private int id;
            private int order_id;
            private int project_id;
            private String satisfaction;
            private String satisfaction_text;
            private int shop_id;
            private String start;
            private String start_text;
            private String state;
            private String state_text;
            @SerializedName("switch")
            private int switchX;
            private int user_id;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public int getProject_id() {
                return project_id;
            }

            public void setProject_id(int project_id) {
                this.project_id = project_id;
            }

            public String getSatisfaction() {
                return satisfaction;
            }

            public void setSatisfaction(String satisfaction) {
                this.satisfaction = satisfaction;
            }

            public String getSatisfaction_text() {
                return satisfaction_text;
            }

            public void setSatisfaction_text(String satisfaction_text) {
                this.satisfaction_text = satisfaction_text;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getStart_text() {
                return start_text;
            }

            public void setStart_text(String start_text) {
                this.start_text = start_text;
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

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }
        }

        public static class MemberdataBean extends BaseBean{
            /**
             * activitytime : 2018-10-02 11:53:50
             * activitytime_end : 2018-10-02 11:53:50
             * content : 1111
             * createtime : 1538452488
             * flag : 
             * flag_text : 
             * id : 3
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * name : 会员区
             * price : 665.83
             * price_discount : 0
             * price_market : 0
             * price_member : 555
             * price_newmember : 0
             * price_second : 0
             * project_category_id : 2
             * quality : 
             * quality_text : 
             * redenvelopes_ids : 1
             * state : 1
             * state_text : State 1
             * treatment_count : 0
             * treatment_price : 55.00
             * views : 0
             * weigh : 100
             */

            private String activitytime;
            private String activitytime_end;
            private String content;
            private int createtime;
            private String flag;
            private String flag_text;
            private int id;
            private String image;
            private String images;
            private String name;
            private double price;
            private int price_discount;
            private int price_market;
            private int price_member;
            private int price_newmember;
            private int price_second;
            private int project_category_id;
            private String quality;
            private String quality_text;
            private String redenvelopes_ids;
            private String state;
            private String state_text;
            private String treatment_count;
            private String treatment_price;
            private int views;
            private int weigh;

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

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
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

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }
        }

        public static class NewmemberdataBean extends BaseBean{
            /**
             * activitytime : 2018-10-02 21:38:44
             * activitytime_end : 2018-10-02 21:38:44
             * content : 55
             * createtime : 1538487574
             * flag : 
             * flag_text : 
             * id : 4
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * name : 新人
             * price : 55
             * price_discount : 0
             * price_market : 0
             * price_member : 0
             * price_newmember : 33
             * price_second : 0
             * project_category_id : 1
             * quality : 
             * quality_text : 
             * redenvelopes_ids : 1
             * state : 1
             * state_text : State 1
             * treatment_count : 3
             * treatment_price : 44.00
             * views : 0
             * weigh : 4
             */

            private String activitytime;
            private String activitytime_end;
            private String content;
            private int createtime;
            private String flag;
            private String flag_text;
            private int id;
            private String image;
            private String images;
            private String name;
            private double price;
            private int price_discount;
            private int price_market;
            private int price_member;
            private int price_newmember;
            private int price_second;
            private int project_category_id;
            private String quality;
            private String quality_text;
            private String redenvelopes_ids;
            private String state;
            private String state_text;
            private String treatment_count;
            private String treatment_price;
            private int views;
            private int weigh;

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

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
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

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }
        }

        public static class ShopBean {
            /**
             * address : 2222
             * city : 北京/北京市/西城区
             * content : 2222
             * createtime : 1537862188
             * id : 1
             * image : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * images : /uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * latitude : 2222
             * longitude : 2222
             * name : 西直门店
             * state : 1
             * state_text : State 1
             * tel : 2222
             * user_id : 1
             */

            private String address;
            private String city;
            private String content;
            private int createtime;
            private int id;
            private String image;
            private String images;
            private String latitude;
            private String longitude;
            private String name;
            private String state;
            private String state_text;
            private String tel;
            private int user_id;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
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

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }
        }

        public static class SpecialdataBean extends BaseBean{
            /**
             * activitytime : 2018-10-02 11:01:59
             * activitytime_end : 2018-10-02 11:01:59
             * content : 测试测试测试测试测试
             * createtime : 1538449687
             * flag : 
             * flag_text : 
             * id : 1
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * images : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg,/uploads/20180925/29393d1005dc4ffabaee1736aaa2b6a0.jpg
             * name : 热门项目
             * price : 150
             * price_discount : 0
             * price_market : 0
             * price_member : 0
             * price_newmember : 0
             * price_second : 0
             * project_category_id : 3
             * quality : 
             * quality_text : 
             * redenvelopes_ids : 1
             * state : 2
             * state_text : State 2
             * treatment_count : 0
             * treatment_price : 0.00
             * views : 0
             * weigh : 100
             */

            private String activitytime;
            private String activitytime_end;
            private String content;
            private int createtime;
            private String flag;
            private String flag_text;
            private int id;
            private String image;
            private String images;
            private String name;
            private double price;
            private int price_discount;
            private int price_market;
            private int price_member;
            private int price_newmember;
            private int price_second;
            private int project_category_id;
            private String quality;
            private String quality_text;
            private String redenvelopes_ids;
            private String state;
            private String state_text;
            private String treatment_count;
            private String treatment_price;
            private int views;
            private int weigh;

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

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getFlag_text() {
                return flag_text;
            }

            public void setFlag_text(String flag_text) {
                this.flag_text = flag_text;
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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPrice_discount() {
                return price_discount;
            }

            public void setPrice_discount(int price_discount) {
                this.price_discount = price_discount;
            }

            public int getPrice_market() {
                return price_market;
            }

            public void setPrice_market(int price_market) {
                this.price_market = price_market;
            }

            public int getPrice_member() {
                return price_member;
            }

            public void setPrice_member(int price_member) {
                this.price_member = price_member;
            }

            public int getPrice_newmember() {
                return price_newmember;
            }

            public void setPrice_newmember(int price_newmember) {
                this.price_newmember = price_newmember;
            }

            public int getPrice_second() {
                return price_second;
            }

            public void setPrice_second(int price_second) {
                this.price_second = price_second;
            }

            public int getProject_category_id() {
                return project_category_id;
            }

            public void setProject_category_id(int project_category_id) {
                this.project_category_id = project_category_id;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getQuality_text() {
                return quality_text;
            }

            public void setQuality_text(String quality_text) {
                this.quality_text = quality_text;
            }

            public String getRedenvelopes_ids() {
                return redenvelopes_ids;
            }

            public void setRedenvelopes_ids(String redenvelopes_ids) {
                this.redenvelopes_ids = redenvelopes_ids;
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

            public String getTreatment_count() {
                return treatment_count;
            }

            public void setTreatment_count(String treatment_count) {
                this.treatment_count = treatment_count;
            }

            public String getTreatment_price() {
                return treatment_price;
            }

            public void setTreatment_price(String treatment_price) {
                this.treatment_price = treatment_price;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }
        }
    }
}
