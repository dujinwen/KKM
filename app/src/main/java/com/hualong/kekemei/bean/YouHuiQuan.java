package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

public class YouHuiQuan {
    /**
     * code : 1
     * msg : 请求成功
     * time : 1538893557
     * data : {"0":{"id":1,"coupon_id":1,"user_id":1,"project_project_id":3,"state":"1","createtime":1538893112,"coupon":{"id":1,"name":"测试优惠券","image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price_satisfy":0,"price_reduction":0,"discount":9.8,"activitytime":"2018-10-07 12:53:59","activitytime_end":"2018-10-07 12:53:59","createtime":1538888184,"weigh":1,"state":"1","state_text":"State 1"},"state_text":"State 1"},"coupon_name":"测试优惠券"}
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
         * 0 : {"id":1,"coupon_id":1,"user_id":1,"project_project_id":3,"state":"1","createtime":1538893112,"coupon":{"id":1,"name":"测试优惠券","image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price_satisfy":0,"price_reduction":0,"discount":9.8,"activitytime":"2018-10-07 12:53:59","activitytime_end":"2018-10-07 12:53:59","createtime":1538888184,"weigh":1,"state":"1","state_text":"State 1"},"state_text":"State 1"}
         * coupon_name : 测试优惠券
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String coupon_name;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCoupon_name() {
            return coupon_name;
        }

        public void setCoupon_name(String coupon_name) {
            this.coupon_name = coupon_name;
        }

        public static class _$0Bean {
            /**
             * id : 1
             * coupon_id : 1
             * user_id : 1
             * project_project_id : 3
             * state : 1
             * createtime : 1538893112
             * coupon : {"id":1,"name":"测试优惠券","image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price_satisfy":0,"price_reduction":0,"discount":9.8,"activitytime":"2018-10-07 12:53:59","activitytime_end":"2018-10-07 12:53:59","createtime":1538888184,"weigh":1,"state":"1","state_text":"State 1"}
             * state_text : State 1
             */

            private int id;
            private int coupon_id;
            private int user_id;
            private int project_project_id;
            private String state;
            private int createtime;
            private CouponBean coupon;
            private String state_text;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(int coupon_id) {
                this.coupon_id = coupon_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getProject_project_id() {
                return project_project_id;
            }

            public void setProject_project_id(int project_project_id) {
                this.project_project_id = project_project_id;
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

            public CouponBean getCoupon() {
                return coupon;
            }

            public void setCoupon(CouponBean coupon) {
                this.coupon = coupon;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public static class CouponBean {
                /**
                 * id : 1
                 * name : 测试优惠券
                 * image : /uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg
                 * price_satisfy : 0
                 * price_reduction : 0
                 * discount : 9.8
                 * activitytime : 2018-10-07 12:53:59
                 * activitytime_end : 2018-10-07 12:53:59
                 * createtime : 1538888184
                 * weigh : 1
                 * state : 1
                 * state_text : State 1
                 */

                private int id;
                private String name;
                private String image;
                private int price_satisfy;
                private int price_reduction;
                private double discount;
                private String activitytime;
                private String activitytime_end;
                private int createtime;
                private int weigh;
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

                public double getDiscount() {
                    return discount;
                }

                public void setDiscount(double discount) {
                    this.discount = discount;
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

                public String getState_text() {
                    return state_text;
                }

                public void setState_text(String state_text) {
                    this.state_text = state_text;
                }
            }
        }
    }
}
