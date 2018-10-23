package com.hualong.kekemei.bean;

import java.util.List;

/**
 * Created by peiyangfan on 2018/10/12.
 */

public class HomeBean {


    /**
     * code : 1
     * msg : 请求成功
     * time : 1540282099
     * data : {"beautician":[{"id":1,"name":"美容师","user_id":4,"image":"/uploads/20181022/63b5dc1f595937b86f1a7ad7e21185fa.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg","shop_ids":"2,1","content":"3333333","state":"1","state_text":"State 1"},{"id":2,"name":"专业美容师","user_id":2,"image":"/uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","shop_ids":"2,1","content":"fwfw","state":"2","state_text":"State 2"}],"shop":[{"id":1,"name":"西直门店","image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","images":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","city":"北京/北京市/西城区","address":"2222","tel":"2222","longitude":"2222","latitude":"2222","content":"2222","state":"1","createtime":1537862188,"user_id":1,"comment_count":1,"distance":"","starts":3,"minimum":88,"tag":"真棒","state_text":"State 1"},{"id":2,"name":"德胜门店","image":"/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","images":"/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","city":"北京/北京市/西城区","address":"德胜门店","tel":"111111","longitude":"11111","latitude":"1111","content":"11111","state":"1","createtime":1538567762,"user_id":1,"comment_count":24,"distance":"","starts":2.9166666666667,"minimum":88,"tag":"真棒","state_text":"State 1"}],"banneradv":[{"id":1,"title":"测试","adv_pos_id":10339,"content":"测试","views":0,"image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","starttime":"2018-10-01 10:38:27","endtime":"2018-10-01 10:38:27","createtime":1538361648,"switch":1},{"id":2,"title":"测试","adv_pos_id":10343,"content":"测试","views":0,"image":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg","starttime":"2018-10-01 11:02:50","endtime":"2018-10-01 11:02:50","createtime":1538363019,"switch":1}],"hotdata":[{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","coupon_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 2"},{"id":2,"name":"东方芒果台芭抗衰修复","project_category_id":1,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","price":555,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:19:22","activitytime_end":"2018-10-02 11:19:22","content":"55555","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538450467,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"like_count":1,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"}],"specialdata":[{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","coupon_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"quality_text":"","flag_text":"","state_text":"State 2"}],"newmemberdata":[{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"}],"memberdata":[{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"like_count":1,"quality_text":"","flag_text":"","state_text":"State 1"}],"commentdata":{"all":[{"id":1,"user_id":1,"project_project_id":3,"shop_id":1,"beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","images":"","type":"1","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":2,"user_id":1,"project_project_id":4,"shop_id":2,"beautician_id":1,"comment_tag_ids":"5","order_id":0,"content":"y4y4y54","images":"","type":"1","start":"3","state":"1","createtime":1538619998,"satisfaction":"0","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 0"},{"id":3,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"3","order_id":1,"content":"fewfewfw","images":"","type":"1","start":"1","state":"1","createtime":1538645747,"satisfaction":"2","switch":1,"type_text":"Type 1","start_text":"Start 1","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":4,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"eeeeee","images":"11,222","type":"2","start":"3","state":"1","createtime":1540048446,"satisfaction":"1","switch":1,"type_text":"Type 2","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":5,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540048866,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"}],"hot":[{"id":25,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540051063,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":24,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540051006,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":23,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050903,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":22,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050871,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":21,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050822,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"}]}}
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
         * beautician : [{"id":1,"name":"美容师","user_id":4,"image":"/uploads/20181022/63b5dc1f595937b86f1a7ad7e21185fa.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg","shop_ids":"2,1","content":"3333333","state":"1","state_text":"State 1"},{"id":2,"name":"专业美容师","user_id":2,"image":"/uploads/20181022/10d83ebbe169c77cbbbdbf1d9111e01d.jpg","images":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg,/uploads/20181022/d92905316745b7ce3c0e3d6ddc382c98.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","shop_ids":"2,1","content":"fwfw","state":"2","state_text":"State 2"}]
         * shop : [{"id":1,"name":"西直门店","image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","images":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg,/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","city":"北京/北京市/西城区","address":"2222","tel":"2222","longitude":"2222","latitude":"2222","content":"2222","state":"1","createtime":1537862188,"user_id":1,"comment_count":1,"distance":"","starts":3,"minimum":88,"tag":"真棒","state_text":"State 1"},{"id":2,"name":"德胜门店","image":"/uploads/20181022/223862141ebbdec2dbcbbd0d976383e0.jpeg","images":"/uploads/20181022/67f217375e12f531168371f316cd91ce.jpeg,/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","city":"北京/北京市/西城区","address":"德胜门店","tel":"111111","longitude":"11111","latitude":"1111","content":"11111","state":"1","createtime":1538567762,"user_id":1,"comment_count":24,"distance":"","starts":2.9166666666667,"minimum":88,"tag":"真棒","state_text":"State 1"}]
         * banneradv : [{"id":1,"title":"测试","adv_pos_id":10339,"content":"测试","views":0,"image":"/uploads/20181022/5a7cd90e4e2ba8bffc9d9c714aa70c99.jpeg","starttime":"2018-10-01 10:38:27","endtime":"2018-10-01 10:38:27","createtime":1538361648,"switch":1},{"id":2,"title":"测试","adv_pos_id":10343,"content":"测试","views":0,"image":"/uploads/20181022/2c5d84349965e653baa9870a5311d15d.jpg","starttime":"2018-10-01 11:02:50","endtime":"2018-10-01 11:02:50","createtime":1538363019,"switch":1}]
         * hotdata : [{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","coupon_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 2"},{"id":2,"name":"东方芒果台芭抗衰修复","project_category_id":1,"image":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","images":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","price":555,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:19:22","activitytime_end":"2018-10-02 11:19:22","content":"55555","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538450467,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"like_count":1,"quality_text":"","flag_text":"","state_text":"State 1"},{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"}]
         * specialdata : [{"id":1,"name":"蒙贝面部紧致提升","project_category_id":3,"image":"/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":150,"price_market":0,"price_discount":0,"treatment_price":"0.00","price_newmember":0,"price_member":0,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:01:59","activitytime_end":"2018-10-02 11:01:59","content":"测试测试测试测试测试","flag":"","coupon_ids":"1","state":"2","weigh":100,"views":0,"createtime":1538449687,"quality_text":"","flag_text":"","state_text":"State 2"}]
         * newmemberdata : [{"id":4,"name":"粉红丝带","project_category_id":1,"image":"/uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg","images":"/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":55,"price_market":0,"price_discount":0,"treatment_price":"44.00","price_newmember":33,"price_member":0,"price_second":0,"treatment_count":"3","quality":"","activitytime":"2018-10-02 21:38:44","activitytime_end":"2018-10-02 21:38:44","content":"55","flag":"","coupon_ids":"1","state":"1","weigh":4,"views":0,"createtime":1538487574,"like_count":0,"quality_text":"","flag_text":"","state_text":"State 1"}]
         * memberdata : [{"id":3,"name":"金因姜时光肌密面膜","project_category_id":1,"image":"/uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg","images":"/uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg","price":665.83,"price_market":0,"price_discount":0,"treatment_price":"55.00","price_newmember":0,"price_member":555,"price_second":0,"treatment_count":"0","quality":"","activitytime":"2018-10-02 11:53:50","activitytime_end":"2018-10-02 11:53:50","content":"1111","flag":"","coupon_ids":"1","state":"1","weigh":100,"views":0,"createtime":1538452488,"like_count":1,"quality_text":"","flag_text":"","state_text":"State 1"}]
         * commentdata : {"all":[{"id":1,"user_id":1,"project_project_id":3,"shop_id":1,"beautician_id":1,"comment_tag_ids":"5,3","order_id":0,"content":"很好","images":"","type":"1","start":"3","state":"1","createtime":1538469581,"satisfaction":"2","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":2,"user_id":1,"project_project_id":4,"shop_id":2,"beautician_id":1,"comment_tag_ids":"5","order_id":0,"content":"y4y4y54","images":"","type":"1","start":"3","state":"1","createtime":1538619998,"satisfaction":"0","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 0"},{"id":3,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"3","order_id":1,"content":"fewfewfw","images":"","type":"1","start":"1","state":"1","createtime":1538645747,"satisfaction":"2","switch":1,"type_text":"Type 1","start_text":"Start 1","state_text":"State 1","satisfaction_text":"Satisfaction 2"},{"id":4,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"eeeeee","images":"11,222","type":"2","start":"3","state":"1","createtime":1540048446,"satisfaction":"1","switch":1,"type_text":"Type 2","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":5,"user_id":1,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540048866,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"}],"hot":[{"id":25,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540051063,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":24,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540051006,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":23,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050903,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":22,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050871,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"},{"id":21,"user_id":2,"project_project_id":3,"shop_id":2,"beautician_id":2,"comment_tag_ids":"1,2","order_id":1,"content":"66666","images":"44,33","type":"1","start":"3","state":"1","createtime":1540050822,"satisfaction":"1","switch":1,"type_text":"Type 1","start_text":"Start 3","state_text":"State 1","satisfaction_text":"Satisfaction 1"}]}
         */

        private CommentdataBean commentdata;
        private List<BeauticianBean> beautician;
        private List<ShopBean> shop;
        private List<BannerBean> banneradv;
        private List<HotdataBean> hotdata;
        private List<SpecialdataBean> specialdata;
        private List<NewmemberdataBean> newmemberdata;
        private List<MemberdataBean> memberdata;

        public CommentdataBean getCommentdata() {
            return commentdata;
        }

        public void setCommentdata(CommentdataBean commentdata) {
            this.commentdata = commentdata;
        }

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

        public List<BannerBean> getBanneradv() {
            return banneradv;
        }

        public void setBanneradv(List<BannerBean> banneradv) {
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

        public static class CommentdataBean {
            private List<EvaluateBean> all;
            private List<EvaluateBean> hot;

            public List<EvaluateBean> getAll() {
                return all;
            }

            public void setAll(List<EvaluateBean> all) {
                this.all = all;
            }

            public List<EvaluateBean> getHot() {
                return hot;
            }

            public void setHot(List<EvaluateBean> hot) {
                this.hot = hot;
            }
        }

        public static class SpecialdataBean extends BaseBean{
            /**
             * id : 1
             * name : 蒙贝面部紧致提升
             * project_category_id : 3
             * image : /uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
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
             * coupon_ids : 1
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
            private int price;
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
            private String coupon_ids;
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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
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
             * name : 粉红丝带
             * project_category_id : 1
             * image : /uploads/20181022/0847d20fcb22b348e29a61e333a363b4.jpg
             * images : /uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
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
             * coupon_ids : 1
             * state : 1
             * weigh : 4
             * views : 0
             * createtime : 1538487574
             * like_count : 0
             * quality_text :
             * flag_text :
             * state_text : State 1
             */

            private int id;
            private String name;
            private int project_category_id;
            private String image;
            private String images;
            private int price;
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
            private String coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private int like_count;
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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
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
             * name : 金因姜时光肌密面膜
             * project_category_id : 1
             * image : /uploads/20181022/eba3d6f9ffc2bd7f7791f407bccec354.jpg
             * images : /uploads/20181022/979c9ab660275292aefc5c6b7632b2a8.jpg,/uploads/20181022/5e50668033beb8d9d671da58b598fa79.jpg,/uploads/20181022/b532838d95d86275310107d512861b6c.jpg
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
             * coupon_ids : 1
             * state : 1
             * weigh : 100
             * views : 0
             * createtime : 1538452488
             * like_count : 1
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
            private String coupon_ids;
            private String state;
            private int weigh;
            private int views;
            private int createtime;
            private int like_count;
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

            public String getCoupon_ids() {
                return coupon_ids;
            }

            public void setCoupon_ids(String coupon_ids) {
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
    }
}
