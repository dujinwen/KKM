package com.hualong.kekemei.bean;

/**
 * Created by caozhimin on 2018/8/1.
 */

public class UserBean {
    private String userName;

    private int userIcon;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }


    public UserBean(String userName, int userIcon) {
        this.userName = userName;
        this.userIcon = userIcon;
    }


}
