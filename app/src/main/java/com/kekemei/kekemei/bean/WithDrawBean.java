package com.kekemei.kekemei.bean;

import java.io.Serializable;
import java.util.List;

public class WithDrawBean implements Serializable {

    /**
     * account : 7
     * bank : [{"id":1,"beautician_beautician_id":1,"openingbank":"1","accountname":"11111","mobel":111111,"cardnumber":"22222","openingbank_text":"Openingbank 1"}]
     */

    private float account;
    private List<BankBean> bank;

    public float getAccount() {
        return account;
    }

    public void setAccount(float account) {
        this.account = account;
    }

    public List<BankBean> getBank() {
        return bank;
    }

    public void setBank(List<BankBean> bank) {
        this.bank = bank;
    }

    public static class BankBean implements Serializable {
        /**
         * id : 1
         * beautician_beautician_id : 1
         * openingbank : 1
         * accountname : 11111
         * mobel : 111111
         * cardnumber : 22222
         * openingbank_text : Openingbank 1
         */

        private String id;
        private int beautician_beautician_id;
        private String openingbank;
        private String accountname;
        private String mobel;
        private String cardnumber;
        private String openingbank_text;
        private boolean needAddCard;

        public boolean isNeedAddCard() {
            return needAddCard;
        }

        public void setNeedAddCard(boolean needAddCard) {
            this.needAddCard = needAddCard;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getBeautician_beautician_id() {
            return beautician_beautician_id;
        }

        public void setBeautician_beautician_id(int beautician_beautician_id) {
            this.beautician_beautician_id = beautician_beautician_id;
        }

        public String getOpeningbank() {
            return openingbank;
        }

        public void setOpeningbank(String openingbank) {
            this.openingbank = openingbank;
        }

        public String getAccountname() {
            return accountname;
        }

        public void setAccountname(String accountname) {
            this.accountname = accountname;
        }

        public String getMobel() {
            return mobel;
        }

        public void setMobel(String mobel) {
            this.mobel = mobel;
        }

        public String getCardnumber() {
            return cardnumber;
        }

        public void setCardnumber(String cardnumber) {
            this.cardnumber = cardnumber;
        }

        public String getOpeningbank_text() {
            return openingbank_text;
        }

        public void setOpeningbank_text(String openingbank_text) {
            this.openingbank_text = openingbank_text;
        }
    }
}
