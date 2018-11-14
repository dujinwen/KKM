package com.kekemei.kekemei.bean;

public class WXPayResultBean {

    /**
     * code : 1
     * msg : 下单成功
     * time : 1539945260
     * data : {"appid":"wx5c1c391ac956b658","mch_id":"1515211071","nonce_str":"tbFNfs5dFBuzP8Ns","prepay_id":"wx1918342127169094f0e9268b0510232534","result_code":"SUCCESS","return_code":"SUCCESS","return_msg":"OK","sign":"9AD5B562E5925C78863F565BACDEF6D4","trade_type":"APP","out_trade_no":"wx14883668731539945260","total_fee":100}
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
         * appid : wx5c1c391ac956b658
         * mch_id : 1515211071
         * nonce_str : tbFNfs5dFBuzP8Ns
         * prepay_id : wx1918342127169094f0e9268b0510232534
         * result_code : SUCCESS
         * return_code : SUCCESS
         * return_msg : OK
         * sign : 9AD5B562E5925C78863F565BACDEF6D4
         * trade_type : APP
         * out_trade_no : wx14883668731539945260
         * total_fee : 100
         */

        private String appid;
        private String mch_id;
        private String nonce_str;
        private String prepay_id;
        private String result_code;
        private String return_code;
        private String return_msg;
        private String sign;
        private String trade_type;
        private String out_trade_no;
        private int total_fee;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        public String getNonce_str() {
            return nonce_str;
        }

        public void setNonce_str(String nonce_str) {
            this.nonce_str = nonce_str;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getReturn_code() {
            return return_code;
        }

        public void setReturn_code(String return_code) {
            this.return_code = return_code;
        }

        public String getReturn_msg() {
            return return_msg;
        }

        public void setReturn_msg(String return_msg) {
            this.return_msg = return_msg;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public int getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(int total_fee) {
            this.total_fee = total_fee;
        }
    }
}