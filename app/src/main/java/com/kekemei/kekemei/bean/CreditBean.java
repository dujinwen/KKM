package com.kekemei.kekemei.bean;

import java.util.List;

public class CreditBean {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1545055304
     * data : {"count":200.1,"integral":[{"id":1000000019,"price":100,"createtime":1542890785,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000027,"price":0.01,"createtime":1542892708,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000032,"price":0.01,"createtime":1542893063,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000033,"price":0.01,"createtime":1542893190,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000034,"price":0.01,"createtime":1542893246,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000129,"price":0.01,"createtime":1543894347,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000159,"price":100,"createtime":1544576425,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000168,"price":0.01,"createtime":1544587394,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000170,"price":0.01,"createtime":1544591255,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000172,"price":0.01,"createtime":1544595877,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000176,"price":0.01,"createtime":1544628052,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000177,"price":0.01,"createtime":1544629089,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""}]}
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
         * count : 200.1
         * integral : [{"id":1000000019,"price":100,"createtime":1542890785,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000027,"price":0.01,"createtime":1542892708,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000032,"price":0.01,"createtime":1542893063,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000033,"price":0.01,"createtime":1542893190,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000034,"price":0.01,"createtime":1542893246,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000129,"price":0.01,"createtime":1543894347,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000159,"price":100,"createtime":1544576425,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000168,"price":0.01,"createtime":1544587394,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000170,"price":0.01,"createtime":1544591255,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000172,"price":0.01,"createtime":1544595877,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000176,"price":0.01,"createtime":1544628052,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""},{"id":1000000177,"price":0.01,"createtime":1544629089,"name":"消费积分","pay_type_text":"","servicetime_text":"","finishtime_text":"","source_text":"","state_text":""}]
         */

        private double count;
        private List<IntegralBean> integral;

        public double getCount() {
            return count;
        }

        public void setCount(double count) {
            this.count = count;
        }

        public List<IntegralBean> getIntegral() {
            return integral;
        }

        public void setIntegral(List<IntegralBean> integral) {
            this.integral = integral;
        }

        public static class IntegralBean {
            /**
             * id : 1000000019
             * price : 100
             * createtime : 1542890785
             * name : 消费积分
             * pay_type_text :
             * servicetime_text :
             * finishtime_text :
             * source_text :
             * state_text :
             */

            private int id;
            private double price;
            private int createtime;
            private String name;
            private String pay_type_text;
            private String servicetime_text;
            private String finishtime_text;
            private String source_text;
            private String state_text;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
                this.createtime = createtime;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPay_type_text() {
                return pay_type_text;
            }

            public void setPay_type_text(String pay_type_text) {
                this.pay_type_text = pay_type_text;
            }

            public String getServicetime_text() {
                return servicetime_text;
            }

            public void setServicetime_text(String servicetime_text) {
                this.servicetime_text = servicetime_text;
            }

            public String getFinishtime_text() {
                return finishtime_text;
            }

            public void setFinishtime_text(String finishtime_text) {
                this.finishtime_text = finishtime_text;
            }

            public String getSource_text() {
                return source_text;
            }

            public void setSource_text(String source_text) {
                this.source_text = source_text;
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
