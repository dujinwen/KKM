package com.hualong.kekemei.bean;

import com.google.gson.annotations.SerializedName;

public class HongBao {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1538895183
     * data : {"0":{"id":1,"redenvelopes_id":1,"user_id":1,"project_project_id":3,"state":"1","createtime":1538894951,"redenvelopes":{"id":1,"name":"111111","price_satisfy":0,"price_reduction":0,"image":"/assets/img/qrcode.png","state":"1","activitytime":"2018-09-25 11:04:11","activitytime_end":"2018-09-25 11:04:11","createtime":1537844659,"state_text":"State 1"},"state_text":"State 1"},"redenvelopes_name":"111111"}
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
         * 0 : {"id":1,"redenvelopes_id":1,"user_id":1,"project_project_id":3,"state":"1","createtime":1538894951,"redenvelopes":{"id":1,"name":"111111","price_satisfy":0,"price_reduction":0,"image":"/assets/img/qrcode.png","state":"1","activitytime":"2018-09-25 11:04:11","activitytime_end":"2018-09-25 11:04:11","createtime":1537844659,"state_text":"State 1"},"state_text":"State 1"}
         * redenvelopes_name : 111111
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String redenvelopes_name;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getRedenvelopes_name() {
            return redenvelopes_name;
        }

        public void setRedenvelopes_name(String redenvelopes_name) {
            this.redenvelopes_name = redenvelopes_name;
        }

        public static class _$0Bean {
            /**
             * id : 1
             * redenvelopes_id : 1
             * user_id : 1
             * project_project_id : 3
             * state : 1
             * createtime : 1538894951
             * redenvelopes : {"id":1,"name":"111111","price_satisfy":0,"price_reduction":0,"image":"/assets/img/qrcode.png","state":"1","activitytime":"2018-09-25 11:04:11","activitytime_end":"2018-09-25 11:04:11","createtime":1537844659,"state_text":"State 1"}
             * state_text : State 1
             */

            private int id;
            private int redenvelopes_id;
            private int user_id;
            private int project_project_id;
            private String state;
            private int createtime;
            private RedenvelopesBean redenvelopes;
            private String state_text;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRedenvelopes_id() {
                return redenvelopes_id;
            }

            public void setRedenvelopes_id(int redenvelopes_id) {
                this.redenvelopes_id = redenvelopes_id;
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

            public RedenvelopesBean getRedenvelopes() {
                return redenvelopes;
            }

            public void setRedenvelopes(RedenvelopesBean redenvelopes) {
                this.redenvelopes = redenvelopes;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public static class RedenvelopesBean {
                /**
                 * id : 1
                 * name : 111111
                 * price_satisfy : 0
                 * price_reduction : 0
                 * image : /assets/img/qrcode.png
                 * state : 1
                 * activitytime : 2018-09-25 11:04:11
                 * activitytime_end : 2018-09-25 11:04:11
                 * createtime : 1537844659
                 * state_text : State 1
                 */

                private int id;
                private String name;
                private int price_satisfy;
                private int price_reduction;
                private String image;
                private String state;
                private String activitytime;
                private String activitytime_end;
                private int createtime;
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

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
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
