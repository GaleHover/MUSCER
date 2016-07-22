package com.hys.musclehungry.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Hover on 2016/5/11.
 */
public class Like extends BmobObject {
    private String username;
    private String shopId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
