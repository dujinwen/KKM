package com.kekemei.kekemei.bean;

import java.io.Serializable;
import java.util.List;

public class InComeBean implements Serializable {

    /**
     * code : 1
     * msg : 请求成功
     * time : 1544319199
     * data : {"sum":6,"info":[{"count":6,"info":[{"date":"28","week":"星期三","money":6,"orderprice":100},{"date":"28","week":"星期三","money":0,"orderprice":0.01},{"date":"28","week":"星期三","money":0,"orderprice":0.01}]},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null}]}
     */

    /**
     * sum : 6
     * info : [{"count":6,"info":[{"date":"28","week":"星期三","money":6,"orderprice":100},{"date":"28","week":"星期三","money":0,"orderprice":0.01},{"date":"28","week":"星期三","money":0,"orderprice":0.01}]},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null},{"count":0,"info":null}]
     */

    private float sum;
    private List<InfoBeanX> info;

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public List<InfoBeanX> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBeanX> info) {
        this.info = info;
    }

    public static class InfoBeanX implements Serializable {
        /**
         * count : 6
         * info : [{"date":"28","week":"星期三","money":6,"orderprice":100},{"date":"28","week":"星期三","money":0,"orderprice":0.01},{"date":"28","week":"星期三","money":0,"orderprice":0.01}]
         */

        private float count;
        private String month;
        private List<InfoBean> info;
        private String ordersum;

        public float getCount() {
            return count;
        }

        public void setCount(float count) {
            this.count = count;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public String getMonth(int index) {
            switch (index) {
                case 0:
                    month = "12";
                    break;
                case 1:
                    month = "11";
                    break;
                case 2:
                    month = "10";
                    break;
                case 3:
                    month = "9";
                    break;
                case 4:
                    month = "8";
                    break;
                case 5:
                    month = "7";
                    break;
                case 6:
                    month = "6";
                    break;
                case 7:
                    month = "5";
                    break;
                case 8:
                    month = "4";
                    break;
                case 9:
                    month = "3";
                    break;
                case 10:
                    month = "2";
                    break;
                case 11:
                    month = "1";
                    break;
            }
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getOrdersum() {
            return ordersum;
        }

        public void setOrdersum(String ordersum) {
            this.ordersum = ordersum;
        }

        public static class InfoBean implements Serializable {
            /**
             * date : 28
             * week : 星期三
             * money : 6
             * orderprice : 100
             */

            private String date;
            private String week;
            private float money;
            private float orderprice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public float getMoney() {
                return money;
            }

            public void setMoney(float money) {
                this.money = money;
            }

            public float getOrderprice() {
                return orderprice;
            }

            public void setOrderprice(float orderprice) {
                this.orderprice = orderprice;
            }
        }
    }
}
