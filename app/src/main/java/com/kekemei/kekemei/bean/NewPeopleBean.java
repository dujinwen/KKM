package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by peiyangfan on 2018/11/8.
 */

public class NewPeopleBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1541642993
     * data : {"isnew":0,"banner":{"id":10,"title":"新人会员卡","adv_pos_id":10359,"image":"/uploads/20181107/8c83b8fd48c4dd6f2acf048da3fc9ee5.png","jumbdata":"web","project_project_id":0,"shop_shop_id":0,"becautician_becautician_id":0,"content":"","url":"","views":0,"starttime":"2018-11-07","endtime":"2018-11-07","createtime":1541558147,"weigh":10,"switch":1,"jumbdata_text":"Jumbdata web"},"newpopledata":[{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","content":"55","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"}],"projectall":[{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"测试测试测试测试测试","coupon_ids":"1","redenvelopes_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"推荐"},{"id":2,"name":"东方芒果台芭抗衰修复","project_category_id":1,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"55555","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538450467,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"},{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":666,"price_discount":66,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","content":"1111","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"},{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","content":"55","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"}],"foryou":[{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"测试测试测试测试测试","coupon_ids":"1","redenvelopes_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"推荐"}]}
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
         * isnew : 0
         * banner : {"id":10,"title":"新人会员卡","adv_pos_id":10359,"image":"/uploads/20181107/8c83b8fd48c4dd6f2acf048da3fc9ee5.png","jumbdata":"web","project_project_id":0,"shop_shop_id":0,"becautician_becautician_id":0,"content":"","url":"","views":0,"starttime":"2018-11-07","endtime":"2018-11-07","createtime":1541558147,"weigh":10,"switch":1,"jumbdata_text":"Jumbdata web"}
         * newpopledata : [{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","content":"55","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"}]
         * projectall : [{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"测试测试测试测试测试","coupon_ids":"1","redenvelopes_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"推荐"},{"id":2,"name":"东方芒果台芭抗衰修复","project_category_id":1,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"55555","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538450467,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"},{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":666,"price_discount":66,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","content":"1111","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"},{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","content":"55","coupon_ids":"1","redenvelopes_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"正常"}]
         * foryou : [{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price_market":0,"price_discount":100,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","content":"测试测试测试测试测试","coupon_ids":"1","redenvelopes_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"redenvelopes":["111111"],"coupon":["满599减50"],"quality_text":"","state_text":"推荐"}]
         */

        private int isnew;
        private BannerBean banner;
        private List<BaseBean> newpopledata;
        private List<BaseBean> projectall;
        private List<BaseBean> foryou;

        public int getIsnew() {
            return isnew;
        }

        public void setIsnew(int isnew) {
            this.isnew = isnew;
        }

        public BannerBean getBanner() {
            return banner;
        }

        public void setBanner(BannerBean banner) {
            this.banner = banner;
        }


        public static class BannerBean {
            /**
             * id : 10
             * title : 新人会员卡
             * adv_pos_id : 10359
             * image : /uploads/20181107/8c83b8fd48c4dd6f2acf048da3fc9ee5.png
             * jumbdata : web
             * project_project_id : 0
             * shop_shop_id : 0
             * becautician_becautician_id : 0
             * content :
             * url :
             * views : 0
             * starttime : 2018-11-07
             * endtime : 2018-11-07
             * createtime : 1541558147
             * weigh : 10
             * switch : 1
             * jumbdata_text : Jumbdata web
             */

            private int id;
            private String title;
            private int adv_pos_id;
            private String image;
            private String jumbdata;
            private int project_project_id;
            private int shop_shop_id;
            private int becautician_becautician_id;
            private String content;
            private String url;
            private int views;
            private String starttime;
            private String endtime;
            private int createtime;
            private int weigh;
            @SerializedName("switch")
            private int switchX;
            private String jumbdata_text;

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

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getJumbdata() {
                return jumbdata;
            }

            public void setJumbdata(String jumbdata) {
                this.jumbdata = jumbdata;
            }

            public int getProject_project_id() {
                return project_project_id;
            }

            public void setProject_project_id(int project_project_id) {
                this.project_project_id = project_project_id;
            }

            public int getShop_shop_id() {
                return shop_shop_id;
            }

            public void setShop_shop_id(int shop_shop_id) {
                this.shop_shop_id = shop_shop_id;
            }

            public int getBecautician_becautician_id() {
                return becautician_becautician_id;
            }

            public void setBecautician_becautician_id(int becautician_becautician_id) {
                this.becautician_becautician_id = becautician_becautician_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
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

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }

            public String getJumbdata_text() {
                return jumbdata_text;
            }

            public void setJumbdata_text(String jumbdata_text) {
                this.jumbdata_text = jumbdata_text;
            }
        }

        public static class NewpopledataBean {
            /**
             * id : 4
             * name : 粉红丝带
             * project_category_id : 1
             * image : /uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg
             * images : /uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * price_market : 0
             * price_discount : 100
             * treatment_price : 44.00
             * price_newmember : 33
             * price_member : 0
             * price_second : 0
             * treatment_count : 3
             * quality :
             * content : 55
             * coupon_ids : 1
             * redenvelopes_ids : 1
             * state : 1
             * weigh : 4
             * views : 0
             * createtime : 1538487574
             * redenvelopes : ["111111"]
             * coupon : ["满599减50"]
             * quality_text :
             * state_text : 正常
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String content;
            private String coupon_ids;
            private String redenvelopes_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

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

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }
        }

        public static class ProjectallBean {
            /**
             * id : 1
             * name : 蒙贝面部紧致提升
             * project_category_id : 3
             * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * price_market : 0
             * price_discount : 100
             * treatment_price : 0.00
             * price_newmember : 0
             * price_member : 0
             * price_second : 0
             * treatment_count : 0
             * quality :
             * content : 测试测试测试测试测试
             * coupon_ids : 1
             * redenvelopes_ids : 1
             * state : 2
             * weigh : 100
             * views : 0
             * createtime : 1538449687
             * redenvelopes : ["111111"]
             * coupon : ["满599减50"]
             * quality_text :
             * state_text : 推荐
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String content;
            private String coupon_ids;
            private String redenvelopes_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

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

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }
        }

        public static class ForyouBean {
            /**
             * id : 1
             * name : 蒙贝面部紧致提升
             * project_category_id : 3
             * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * price_market : 0
             * price_discount : 100
             * treatment_price : 0.00
             * price_newmember : 0
             * price_member : 0
             * price_second : 0
             * treatment_count : 0
             * quality :
             * content : 测试测试测试测试测试
             * coupon_ids : 1
             * redenvelopes_ids : 1
             * state : 2
             * weigh : 100
             * views : 0
             * createtime : 1538449687
             * redenvelopes : ["111111"]
             * coupon : ["满599减50"]
             * quality_text :
             * state_text : 推荐
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private int price_market;
            private int price_discount;
            private String treatment_price;
            private int price_newmember;
            private int price_member;
            private int price_second;
            private String treatment_count;
            private String quality;
            private String content;
            private String coupon_ids;
            private String redenvelopes_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

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

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }
        }
    }
}
