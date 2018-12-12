package com.kekemei.kekemei.bean;

import java.io.Serializable;

public class NearShop implements Serializable {

    /**
     * id : 1000
     * shopname : saf
     * distance : 1
     * address : 1
     */

    private int id;
    private String shopname;
    private int distance;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
