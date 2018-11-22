package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;
import com.kekemei.kekemei.utils.StringUtils;

import java.io.Serializable;
import java.util.List;

public class ProjectDetailBean implements Serializable {

    /**
     * code : 1
     * data : {"comment":{"all":[],"count":0,"haveimg":[],"new":[],"tags":[{"id":1,"name":"服务热情","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":2,"name":"环境优雅","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0},{"id":3,"name":"美容师专业","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":4,"name":"效果赞","state":"1","state_text":"正常","tag_type":"3,","tag_type_text":"","weigh":0},{"id":5,"name":"干净卫生","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0}]},"content":"测试测试测试测试测试","coupon":[{"activitytime":"2018-10-07 12:53:59","activitytime_end":"2019-07-27 12:53:59","createtime":1538888184,"id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"满599减50","price_reduction":50,"price_satisfy":599,"state":"1","state_text":"正常","weigh":1}],"coupon_ids":"1","createtime":1538449687,"hotdata":[{"content":"测试测试测试测试测试","coupon":["111111"],"coupon_ids":"1","createtime":1538449687,"id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"蒙贝面部紧致提升","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"2","state_text":"推荐","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"content":"55555","coupon":["111111"],"coupon_ids":"1","createtime":1538450467,"id":2,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","like_count":0,"name":"东方芒果台芭抗衰修复","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"content":"1111","coupon":["111111"],"coupon_ids":"1","createtime":1538452488,"id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price_discount":66,"price_market":666,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100},{"content":"55","coupon":["111111"],"coupon_ids":"1","createtime":1538487574,"id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price_discount":100,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","memberdata":[{"content":"1111","coupon_ids":"1","createtime":1538452488,"id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price_discount":66,"price_market":666,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100}],"name":"蒙贝面部紧致提升","newmemberdata":[{"content":"55","coupon":["111111"],"coupon_ids":"1","createtime":1538487574,"id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price_discount":100,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}],"price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes":[{"count":9,"createtime":1537844659,"id":1,"image":"/assets/img/qrcode.png","name":"111111","price_reduction":100,"price_satisfy":0,"state":"1","state_text":"正常","type":"1","type_text":"Type 1"}],"redenvelopes_ids":"1","specialdata":[{"content":"测试测试测试测试测试","coupon":["111111"],"coupon_ids":"1","createtime":1538449687,"id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"蒙贝面部紧致提升","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"2","state_text":"推荐","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100}],"state":"2","state_text":"推荐","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100}
     * msg : 请求成功
     * time : 1541577331
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

    public static class DataBean implements Serializable {
        /**
         * comment : {"all":[],"count":0,"haveimg":[],"new":[],"tags":[{"id":1,"name":"服务热情","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":2,"name":"环境优雅","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0},{"id":3,"name":"美容师专业","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":4,"name":"效果赞","state":"1","state_text":"正常","tag_type":"3,","tag_type_text":"","weigh":0},{"id":5,"name":"干净卫生","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0}]}
         * content : 测试测试测试测试测试
         * coupon : [{"activitytime":"2018-10-07 12:53:59","activitytime_end":"2019-07-27 12:53:59","createtime":1538888184,"id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","name":"满599减50","price_reduction":50,"price_satisfy":599,"state":"1","state_text":"正常","weigh":1}]
         * coupon_ids : 1
         * createtime : 1538449687
         * hotdata : [{"content":"测试测试测试测试测试","coupon":["111111"],"coupon_ids":"1","createtime":1538449687,"id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"蒙贝面部紧致提升","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"2","state_text":"推荐","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"content":"55555","coupon":["111111"],"coupon_ids":"1","createtime":1538450467,"id":2,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","like_count":0,"name":"东方芒果台芭抗衰修复","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100},{"content":"1111","coupon":["111111"],"coupon_ids":"1","createtime":1538452488,"id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price_discount":66,"price_market":666,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100},{"content":"55","coupon":["111111"],"coupon_ids":"1","createtime":1538487574,"id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price_discount":100,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}]
         * id : 1
         * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
         * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
         * memberdata : [{"content":"1111","coupon_ids":"1","createtime":1538452488,"id":3,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":1,"name":"金因姜时光肌密面膜","price_discount":66,"price_market":666,"price_member":555,"price_newmember":0,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"0","treatment_price":"55.00","views":0,"weigh":100}]
         * name : 蒙贝面部紧致提升
         * newmemberdata : [{"content":"55","coupon":["111111"],"coupon_ids":"1","createtime":1538487574,"id":4,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"粉红丝带","price_discount":100,"price_market":0,"price_member":0,"price_newmember":33,"price_second":0,"project_category_id":1,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"1","state_text":"正常","treatment_count":"3","treatment_price":"44.00","views":0,"weigh":4}]
         * price_discount : 100
         * price_market : 0
         * price_member : 0
         * price_newmember : 0
         * price_second : 0
         * project_category_id : 3
         * quality :
         * quality_text :
         * redenvelopes : [{"count":9,"createtime":1537844659,"id":1,"image":"/assets/img/qrcode.png","name":"111111","price_reduction":100,"price_satisfy":0,"state":"1","state_text":"正常","type":"1","type_text":"Type 1"}]
         * redenvelopes_ids : 1
         * specialdata : [{"content":"测试测试测试测试测试","coupon":["111111"],"coupon_ids":"1","createtime":1538449687,"id":1,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","like_count":0,"name":"蒙贝面部紧致提升","price_discount":100,"price_market":0,"price_member":0,"price_newmember":0,"price_second":0,"project_category_id":3,"quality":"","quality_text":"","redenvelopes":["111111"],"redenvelopes_ids":"1","state":"2","state_text":"推荐","treatment_count":"0","treatment_price":"0.00","views":0,"weigh":100}]
         * state : 2
         * state_text : 推荐
         * treatment_count : 0
         * treatment_price : 0.00
         * views : 0
         * weigh : 100
         */

        private String id;
        private String name;
        private String image;
        private String images;
        private String redenvelopes_ids;
        private String coupon_ids;
        private String content;
        private String state;
        private int createtime;
        private int price_discount;
        private int price_market;
        private int price_member;
        private int price_newmember;
        private int price_second;
        private int project_category_id;
        private String quality;
        private String quality_text;
        private String state_text;
        private String treatment_count;
        private String treatment_price;
        private String satisfaction;
        private String peer;
        private int views;
        private int weigh;
        private CommentBean comment;
        private List<CouponBean> coupon;
        private List<BaseBean> hotdata;
        private List<BaseBean> memberdata;
        private List<BaseBean> newmemberdata;
        private List<BaseBean> specialdata;
        private List<RedenvelopesBean> redenvelopes;
        private List<FullBean> full;
        private List<String> strading;
        private List<String> service;

        public List<String> getService() {
            return service;
        }

        public void setService(List<String> service) {
            this.service = service;
        }

        public List<String> getStrading() {
            return strading;
        }

        public void setStrading(List<String> strading) {
            this.strading = strading;
        }

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
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

        public List<FullBean> getFull() {
            return full;
        }

        public void setFull(List<FullBean> full) {
            this.full = full;
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

        public String getSatisfaction() {
            if (StringUtils.isNotEmpty(satisfaction) && satisfaction.contains(".")) {
                String[] split = satisfaction.split("\\.");
                return split[1];
            }
            return satisfaction;
        }

        public void setSatisfaction(String satisfaction) {
            this.satisfaction = satisfaction;
        }

        public String getPeer() {
            if (StringUtils.isNotEmpty(peer) && peer.contains(".")) {
                String[] split = peer.split("\\.");
                return split[1];
            }
            return peer;
        }

        public void setPeer(String peer) {
            this.peer = peer;
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

        public List<CouponBean> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<CouponBean> coupon) {
            this.coupon = coupon;
        }

        public List<BaseBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<BaseBean> hotdata) {
            this.hotdata = hotdata;
        }

        public List<BaseBean> getMemberdata() {
            return memberdata;
        }

        public void setMemberdata(List<BaseBean> memberdata) {
            this.memberdata = memberdata;
        }

        public List<BaseBean> getNewmemberdata() {
            return newmemberdata;
        }

        public void setNewmemberdata(List<BaseBean> newmemberdata) {
            this.newmemberdata = newmemberdata;
        }

        public List<BaseBean> getSpecialdata() {
            return specialdata;
        }

        public void setSpecialdata(List<BaseBean> specialdata) {
            this.specialdata = specialdata;
        }

        public List<RedenvelopesBean> getRedenvelopes() {
            return redenvelopes;
        }

        public void setRedenvelopes(List<RedenvelopesBean> redenvelopes) {
            this.redenvelopes = redenvelopes;
        }

        public static class CommentBean implements Serializable {
            /**
             * all : []
             * count : 0
             * haveimg : []
             * new : []
             * tags : [{"id":1,"name":"服务热情","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":2,"name":"环境优雅","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0},{"id":3,"name":"美容师专业","state":"1","state_text":"正常","tag_type":"1","tag_type_text":"Tag_type 1","weigh":0},{"id":4,"name":"效果赞","state":"1","state_text":"正常","tag_type":"3,","tag_type_text":"","weigh":0},{"id":5,"name":"干净卫生","state":"1","state_text":"正常","tag_type":"2","tag_type_text":"Tag_type 2","weigh":0}]
             */

            private int count;
            private List<EvaluateBean> all;
            private List<EvaluateBean> haveimg;
            @SerializedName("new")
            private List<EvaluateBean> newX;
            private List<TagsBean> tags;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<EvaluateBean> getAll() {
                return all;
            }

            public void setAll(List<EvaluateBean> all) {
                this.all = all;
            }

            public List<EvaluateBean> getHaveimg() {
                return haveimg;
            }

            public void setHaveimg(List<EvaluateBean> haveimg) {
                this.haveimg = haveimg;
            }

            public List<EvaluateBean> getNewX() {
                return newX;
            }

            public void setNewX(List<EvaluateBean> newX) {
                this.newX = newX;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean implements Serializable {
                /**
                 * id : 1
                 * name : 服务热情
                 * state : 1
                 * state_text : 正常
                 * tag_type : 1
                 * tag_type_text : Tag_type 1
                 * weigh : 0
                 */

                private int id;
                private String name;
                private String state;
                private String state_text;
                private String tag_type;
                private String tag_type_text;
                private int weigh;

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

                public String getState_text() {
                    return state_text;
                }

                public void setState_text(String state_text) {
                    this.state_text = state_text;
                }

                public String getTag_type() {
                    return tag_type;
                }

                public void setTag_type(String tag_type) {
                    this.tag_type = tag_type;
                }

                public String getTag_type_text() {
                    return tag_type_text;
                }

                public void setTag_type_text(String tag_type_text) {
                    this.tag_type_text = tag_type_text;
                }

                public int getWeigh() {
                    return weigh;
                }

                public void setWeigh(int weigh) {
                    this.weigh = weigh;
                }
            }
        }

        public static class CouponBean implements Serializable {
            /**
             * activitytime : 2018-10-07 12:53:59
             * activitytime_end : 2019-07-27 12:53:59
             * createtime : 1538888184
             * id : 1
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * name : 满599减50
             * price_reduction : 50
             * price_satisfy : 599
             * state : 1
             * state_text : 正常
             * weigh : 1
             */

            private String activitytime;
            private String activitytime_end;
            private int createtime;
            private int id;
            private String image;
            private String name;
            private int price_reduction;
            private int price_satisfy;
            private String state;
            private String state_text;
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

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }
        }

        public static class RedenvelopesBean implements Serializable {
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

        public static class FullBean implements Serializable {

            /**
             * activitytime : 2018-10-07 12:53:59
             * activitytime_end : 2019-07-27 12:53:59
             * createtime : 1538888184
             * id : 1
             * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
             * name : 满599减50
             * price_reduction : 1
             * price_satisfy : 599
             * state : 1
             * state_text : 正常
             * weigh : 1
             */

            private String activitytime;
            private String activitytime_end;
            private int createtime;
            private int id;
            private String image;
            private String name;
            private int price_reduction;
            private int price_satisfy;
            private String state;
            private String state_text;
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

            public int getWeigh() {
                return weigh;
            }

            public void setWeigh(int weigh) {
                this.weigh = weigh;
            }
        }
    }
}
