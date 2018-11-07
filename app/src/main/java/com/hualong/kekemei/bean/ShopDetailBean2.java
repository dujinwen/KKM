package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopDetailBean2 {
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
        private float $satisfaction;
        private String distance;
        private int start;
        private CommentdataBean commentdata;
        private String state_text;
        private List<ServiceBean> service;
        private List<BeauticianBean> beautician;
        private List<String> strading;
        private List<HotdataBean> hotdata;
        private List<SpecialdataBean> specialdata;
        private List<NewmemberdataBean> newmemberdata;
        private List<MemberdataBean> memberdata;
        private List<BeauticianDetailBean.DataBean.CommentTagBean> comment_tag;

        public List<BeauticianDetailBean.DataBean.CommentTagBean> getComment_tag() {
            return comment_tag;
        }

        public void setComment_tag(List<BeauticianDetailBean.DataBean.CommentTagBean> comment_tag) {
            this.comment_tag = comment_tag;
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

        public float get$satisfaction() {
            return $satisfaction;
        }

        public void set$satisfaction(float $satisfaction) {
            this.$satisfaction = $satisfaction;
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

        public static class HotdataBean {
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
             * like_count : 0
             * redenvelopes : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
             * coupon : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
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
            private int like_count;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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


            public static class RedenvelopesBeanX {
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

            public static class CouponBeanX {
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

        public static class SpecialdataBean {
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
             * like_count : 0
             * redenvelopes : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
             * coupon : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
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
            private int like_count;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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



            public static class RedenvelopesBeanXX {
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

            public static class CouponBeanXX {
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

        public static class NewmemberdataBean {
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
             * like_count : 0
             * redenvelopes : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
             * coupon : [{"id":1,"name":"111111","type":"1","price_satisfy":0,"price_reduction":100,"image":"/assets/img/qrcode.png","count":9,"state":"1","createtime":1537844659,"type_text":"Type 1","state_text":"正常"}]
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
            private int like_count;
            private String quality_text;
            private String state_text;
            private List<String> redenvelopes;
            private List<String> coupon;

            public void setRedenvelopes(List<String> redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public void setCoupon(List<String> coupon) {
                this.coupon = coupon;
            }

            public List<String> getRedenvelopes() {
                return redenvelopes;
            }

            public List<String> getCoupon() {
                return coupon;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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



            public static class RedenvelopesBeanXXX {
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

            public static class CouponBeanXXX {
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

        public static class MemberdataBean {
            /**
             * id : 3
             * name : 金因姜时光肌密面膜
             * project_category_id : 1
             * image : /uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
             * price_market : 666
             * price_discount : 66
             * treatment_price : 55.00
             * price_newmember : 0
             * price_member : 555
             * price_second : 0
             * treatment_count : 0
             * quality :
             * content : 1111
             * coupon_ids : 1
             * redenvelopes_ids : 1
             * state : 1
             * weigh : 100
             * views : 0
             * createtime : 1538452488
             * like_count : 1
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
            private int like_count;
            private String quality_text;
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

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
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
        }
    }
}
