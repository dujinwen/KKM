package com.kekemei.kekemei.bean;

import com.google.gson.annotations.SerializedName;

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
        private List<BaseBean> hotdata;
        private List<BaseBean> specialdata;
        private List<BaseBean> newmemberdata;
        private List<BaseBean> memberdata;

        public List<BaseBean> getHotdata() {
            return hotdata;
        }

        public void setHotdata(List<BaseBean> hotdata) {
            this.hotdata = hotdata;
        }

        public List<BaseBean> getSpecialdata() {
            return specialdata;
        }

        public void setSpecialdata(List<BaseBean> specialdata) {
            this.specialdata = specialdata;
        }

        public List<BaseBean> getNewmemberdata() {
            return newmemberdata;
        }

        public void setNewmemberdata(List<BaseBean> newmemberdata) {
            this.newmemberdata = newmemberdata;
        }

        public List<BaseBean> getMemberdata() {
            return memberdata;
        }

        public void setMemberdata(List<BaseBean> memberdata) {
            this.memberdata = memberdata;
        }

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

    }
}
