package com.wjx.mvprxjavaretrofitrxlifecycle.entity;

/**
 * Author: WangJX
 * Time:2018/10/10 11:08
 * Descriprtion:
 */
public class UserInfo {
    private String userName;
    private String userPwd;


    public UserInfo(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
