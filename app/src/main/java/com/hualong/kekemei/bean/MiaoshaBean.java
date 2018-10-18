package com.hualong.kekemei.bean;

import java.util.List;

public class MiaoshaBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1539769512
     * data : {"second":[{"id":1,"name":"12:00专场","starttimes":"12:00:00","endtimes":"13:00:00","project_project_ids":"3,4","state":"1","project_data":[{"id":3,"name":"会员区","project_category_id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":null,"state":"1","weigh":100,"views":0,"createtime":1538452488,"quality_text":"","flag_text":"","state_text":"正常"},{"id":4,"name":"新人","project_category_id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":null,"state":"1","weigh":4,"views":0,"createtime":1538487574,"quality_text":"","flag_text":"","state_text":"正常"}],"state_text":"正常"}],"banner":[{"id":3,"title":"杀Banner广告","adv_pos_id":10344,"content":"杀Banner广告","views":0,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","starttime":"2018-10-16 21:01:31","endtime":"2018-10-16 21:01:31","createtime":1539694959,"switch":1},{"id":4,"title":"秒杀广告","adv_pos_id":10346,"content":"秒杀广告","views":0,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","starttime":"2018-10-16 21:45:46","endtime":"2018-10-16 21:45:46","createtime":1539697575,"switch":1}]}
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
        private List<SecondBean> second;
        private List<BannerBean> banner;

        public List<SecondBean> getSecond() {
            return second;
        }

        public void setSecond(List<SecondBean> second) {
            this.second = second;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class SecondBean {
            /**
             * id : 1
             * name : 12:00专场
             * starttimes : 12:00:00
             * endtimes : 13:00:00
             * project_project_ids : 3,4
             * state : 1
             * project_data : [{"id":3,"name":"会员区","project_category_id":2,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":null,"state":"1","weigh":100,"views":0,"createtime":1538452488,"quality_text":"","flag_text":"","state_text":"正常"},{"id":4,"name":"新人","project_category_id":1,"image":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","images":"/uploads/20181001/8cf03f354750e3e38664485e647c4af4.jpeg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":null,"state":"1","weigh":4,"views":0,"createtime":1538487574,"quality_text":"","flag_text":"","state_text":"正常"}]
             * state_text : 正常
             */

            private int id;
            private String name;
            private String starttimes;
            private String endtimes;
            private String project_project_ids;
            private String state;
            private String state_text;
            private List<HotdataBean> project_data;

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

            public String getStarttimes() {
                return starttimes;
            }

            public void setStarttimes(String starttimes) {
                this.starttimes = starttimes;
            }

            public String getEndtimes() {
                return endtimes;
            }

            public void setEndtimes(String endtimes) {
                this.endtimes = endtimes;
            }

            public String getProject_project_ids() {
                return project_project_ids;
            }

            public void setProject_project_ids(String project_project_ids) {
                this.project_project_ids = project_project_ids;
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

            public List<HotdataBean> getProject_data() {
                return project_data;
            }

            public void setProject_data(List<HotdataBean> project_data) {
                this.project_data = project_data;
            }
        }
    }
}
