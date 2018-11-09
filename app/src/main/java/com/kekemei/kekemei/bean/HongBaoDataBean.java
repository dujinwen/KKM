package com.kekemei.kekemei.bean;

import java.util.List;

public class HongBaoDataBean {


    /**
     * code : 1
     * data : [{"beautician_beautician_id":0,"createtime":1540866872,"id":7,"project_project_id":1,"red_type":"1","red_type_text":"Red_type 1","redenvelopes":{"count":9,"createtime":1537844659,"id":1,"image":"/assets/img/qrcode.png","name":"111111","price_reduction":100,"price_satisfy":0,"state":"1","state_text":"State 1","type":"1","type_text":"Type 1"},"redenvelopes_id":1,"state":"1","state_text":"State 1","user_id":2}]
     * msg : 请求成功
     * time : 1541066982
     */

    private int code;
    private String msg;
    private String time;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * beautician_beautician_id : 0
         * createtime : 1540866872
         * id : 7
         * project_project_id : 1
         * red_type : 1
         * red_type_text : Red_type 1
         * redenvelopes : {"count":9,"createtime":1537844659,"id":1,"image":"/assets/img/qrcode.png","name":"111111","price_reduction":100,"price_satisfy":0,"state":"1","state_text":"State 1","type":"1","type_text":"Type 1"}
         * redenvelopes_id : 1
         * state : 1
         * state_text : State 1
         * user_id : 2
         */

        private int beautician_beautician_id;
        private int createtime;
        private int id;
        private int project_project_id;
        private String red_type;
        private String red_type_text;
        private RedenvelopesBean redenvelopes;
        private int redenvelopes_id;
        private String state;
        private String state_text;
        private int user_id;

        public int getBeautician_beautician_id() {
            return beautician_beautician_id;
        }

        public void setBeautician_beautician_id(int beautician_beautician_id) {
            this.beautician_beautician_id = beautician_beautician_id;
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

        public int getProject_project_id() {
            return project_project_id;
        }

        public void setProject_project_id(int project_project_id) {
            this.project_project_id = project_project_id;
        }

        public String getRed_type() {
            return red_type;
        }

        public void setRed_type(String red_type) {
            this.red_type = red_type;
        }

        public String getRed_type_text() {
            return red_type_text;
        }

        public void setRed_type_text(String red_type_text) {
            this.red_type_text = red_type_text;
        }

        public RedenvelopesBean getRedenvelopes() {
            return redenvelopes;
        }

        public void setRedenvelopes(RedenvelopesBean redenvelopes) {
            this.redenvelopes = redenvelopes;
        }

        public int getRedenvelopes_id() {
            return redenvelopes_id;
        }

        public void setRedenvelopes_id(int redenvelopes_id) {
            this.redenvelopes_id = redenvelopes_id;
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

        public static class RedenvelopesBean {
            /**
             * count : 9
             * createtime : 1537844659
             * id : 1
             * image : /assets/img/qrcode.png
             * name : 111111
             * price_reduction : 100
             * price_satisfy : 0
             * state : 1
             * state_text : State 1
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
            private String activitytime;
            private String activitytime_end;

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
        }
    }
}
