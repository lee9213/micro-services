package com.lee9213.gmall.user.dto;

import com.lee9213.gmall.user.abs.AbstractResponse;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-08-21 8:40
 */
public class UserLoginResponse extends AbstractResponse {


    private Integer uid;
    private String avatar;
    private String mobile;

    private String token;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
