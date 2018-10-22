package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class HomeBean {

    /**
     * code : 1
     * data : {"banneradv":[{"adv_pos_id":10339,"content":"测试","createtime":1538361648,"endtime":"2018-10-01 10:38:27","id":1,"image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","starttime":"2018-10-01 10:38:27","switch":1,"title":"测试","views":0},{"adv_pos_id":10343,"content":"测试","createtime":1538363019,"endtime":"2018-10-01 11:02:50","id":2,"image":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg","starttime":"2018-10-01 11:02:50","switch":1,"title":"测试","views":0}],"beautician":[{"content":"3333333","id":1,"image":"/uploads/20181022/63b5dc1f595937b86f1a7ad7e21185fa.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg","name":"美容师","shop_ids":"2,1","state":"1","state_text":"State 1","user_id":4},{"content":"fwfw","id":2,"image":"/uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","name":"专业美容师","shop_ids":"2,1","state":"2","state_text":"State 2","user_id":2}],"commentdata":[{"beautician_id":1,"comment_tag_ids":"5,3","content":"很好","createtime":1538469581,"id":1,"images":"","order_id":0,"project_project_id":3,"satisfaction":"2","satisfaction_text":"Satisfaction 2","shop_id":1,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"type":"1","type_text":"Type 1","user_id":1},{"beautician_id":1,"comment_tag_ids":"5","content":"y4y4y54","createtime":1538619998,"id":2,"images":"","order_id":0,"project_project_id":4,"satisfaction":"0","satisfaction_text":"Satisfaction 0","shop_id":2,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"type":"1","type_text":"Type 1","user_id":1},{"beautician_id":2,"comment_tag_ids":"3","content":"fewfewfw","createtime":1538645747,"id":3,"images":"","order_id":1,"project_project_id":3,"satisfaction":"2","satisfaction_text":"Satisfaction 2","shop_id":2,"start":"1","start_text":"Start 1","state":"1","state_text":"State 1","switch":1,"type":"1","type_text":"Type 1","user_id":1},{"beautician_id":2,"comment_tag_ids":"1,2","content":"eeeeee","createtime":1540048446,"id":4,"images":"11,222","order_id":1,"project_project_id":3,"satisfaction":"1","satisfaction_text":"Satisfaction 1","shop_id":2,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"type":"2","type_text":"Type 2","user_id":1},{"beautician_id":2,"comment_tag_ids":"1,2","content":"66666","createtime":1540048866,"id":5,"images":"44,33","order_id":1,"project_project_id":3,"satisfaction":"1","satisfaction_text":"Satisfaction 1","shop_id":2,"start":"3","start_text":"Start 3","state":"1","state_text":"State 1","switch":1,"type":"1","type_text":"Type 1","user_id":1}],"hotdata":[{"activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","coupon_ids":"1","createtime":1538449687,"flag":"","flag_text":"","id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"蒙贝面部紧致提升","price":150,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","state":"2","state_text":"State 2","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"activitytime":"2018-10-02 11:19:22","activitytime_end":"2018-10-02 11:19:22","content":"55555","coupon_ids":"1","createtime":1538450467,"flag":"","flag_text":"","id":2,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","like_count":0,"name":"东方芒果台芭抗衰修复","price":555,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","coupon_ids":"1","createtime":1538452488,"flag":"","flag_text":"","id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price":665.83,"price_discount":0,"price_market":0,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100},{"activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","coupon_ids":"1","createtime":1538487574,"flag":"","flag_text":"","id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price":55,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","state":"1","state_text":"State 1","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"memberdata":[{"activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","coupon_ids":"1","createtime":1538452488,"flag":"","flag_text":"","id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price":665.83,"price_discount":0,"price_market":0,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","state":"1","state_text":"State 1","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100}],"newmemberdata":[{"activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","coupon_ids":"1","createtime":1538487574,"flag":"","flag_text":"","id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price":55,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","state":"1","state_text":"State 1","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"shop":[{"address":"2222","city":"北京/北京市/西城区","comment_count":1,"content":"2222","createtime":1537862188,"distance":"","id":1,"image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","images":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","latitude":"2222","longitude":"2222","minimum":88,"name":"西直门店","starts":3,"state":"1","state_text":"State 1","tag":"真棒","tel":"2222","user_id":1},{"address":"德胜门店","city":"北京/北京市/西城区","comment_count":24,"content":"11111","createtime":1538567762,"distance":"","id":2,"image":"/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","images":"/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","latitude":"1111","longitude":"11111","minimum":88,"name":"德胜门店","starts":2.9166666666667,"state":"1","state_text":"State 1","tag":"真棒","tel":"111111","user_id":1}],"specialdata":[{"activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","coupon_ids":"1","createtime":1538449687,"flag":"","flag_text":"","id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","name":"蒙贝面部紧致提升","price":150,"price_discount":0,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","state":"2","state_text":"State 2","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100}]}
     * msg : 请求成功
     * time : 1540182982
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
        private List<BanneradvBean> banneradv;
        private List<BeauticianBean> beautician;
        private List<EvaluateBean> commentdata;
        private List<HotdataBean> hotdata;
        private List<MemberdataBean> memberdata;
        private List<NewmemberdataBean> newmemberdata;
        private List<ShopBean> shop;
        private List<SpecialdataBean> specialdata;

        public List<BanneradvBean> getBanneradv() {
            return banneradv;
        }

        public void setBanneradv(List<BanneradvBean> banneradv) {
            this.banneradv = banneradv;
        }

        public List<BeauticianBean> getBeautician() {
            return beautician;
        }

        public void setBeautician(List<BeauticianBean> beautician) {
            this.beautician = beautician;
        }

        public List<EvaluateBean> getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(List<EvaluateBean> commentdata) {
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

        public static class BanneradvBean {
            /**
             * adv_pos_id : 10339
             * content : 测试
             * createtime : 1538361648
             * endtime : 2018-10-01 10:38:27
             * id : 1
             * image : /uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg
             * starttime : 2018-10-01 10:38:27
             * switch : 1
             * title : 测试
             * views : 0
             */

            private int adv_pos_id;
            private String content;
            private int createtime;
            private String endtime;
            private int id;
            private String image;
            private String starttime;
            @SerializedName("switch")
            private int switchX;
            private String title;
            private int views;

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

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
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

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }
        }

        public static class BeauticianBean {
            /**
             * content : 3333333
             * id : 1
             * image : /uploads/20181022/63b5dc1f595937b86f1a7ad7e21185fa.jpg
             * images : /uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg
             * name : 美容师
             * shop_ids : 2,1
             * state : 1
             * state_text : State 1
             * user_id : 4
             */

            private String content;
            private int id;
            private String image;
            private String images;
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

        public static class MemberdataBean extends BaseBean{
            /**
             * activitytime : 2018-10-02 11:53:50
             * activitytime_end : 2018-10-02 11:53:50
             * content : 1111
             * coupon_ids : 1
             * createtime : 1538452488
             * flag :
             * flag_text :
             * id : 3
             * image : /uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * like_count : 1
             * name : 金因姜时光肌密面膜
             * price : 665.83
             * price_discount : 0
             * price_market : 0
             * price_member : 555
             * price_newmember : 0
             * price_second : 0
             * project_category_id : 1
             * quality :
             * quality_text :
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
            private String coupon_ids;
            private int createtime;
            private String flag;
            private String flag_text;
            private int id;
            private String image;
            private String images;
            private int like_count;
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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
             * coupon_ids : 1
             * createtime : 1538487574
             * flag :
             * flag_text :
             * id : 4
             * image : /uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg
             * images : /uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * like_count : 0
             * name : 粉红丝带
             * price : 55
             * price_discount : 0
             * price_market : 0
             * price_member : 0
             * price_newmember : 33
             * price_second : 0
             * project_category_id : 1
             * quality :
             * quality_text :
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
            private String coupon_ids;
            private int createtime;
            private String flag;
            private String flag_text;
            private int id;
            private String image;
            private String images;
            private int like_count;
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
                this.coupon_ids = coupon_ids;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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
             * comment_count : 1
             * content : 2222
             * createtime : 1537862188
             * distance :
             * id : 1
             * image : /uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg
             * images : /uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg
             * latitude : 2222
             * longitude : 2222
             * minimum : 88
             * name : 西直门店
             * starts : 3
             * state : 1
             * state_text : State 1
             * tag : 真棒
             * tel : 2222
             * user_id : 1
             */

            private String address;
            private String city;
            private int comment_count;
            private String content;
            private int createtime;
            private String distance;
            private int id;
            private String image;
            private String images;
            private String latitude;
            private String longitude;
            private int minimum;
            private String name;
            private double starts;
            private String state;
            private String state_text;
            private String tag;
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

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
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

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
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

            public int getMinimum() {
                return minimum;
            }

            public void setMinimum(int minimum) {
                this.minimum = minimum;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getStarts() {
                return starts;
            }

            public void setStarts(double starts) {
                this.starts = starts;
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

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
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
             * coupon_ids : 1
             * createtime : 1538449687
             * flag :
             * flag_text :
             * id : 1
             * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * name : 蒙贝面部紧致提升
             * price : 150
             * price_discount : 0
             * price_market : 0
             * price_member : 0
             * price_newmember : 0
             * price_second : 0
             * project_category_id : 3
             * quality :
             * quality_text :
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
            private String coupon_ids;
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
                this.coupon_ids = coupon_ids;
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
