package com.hys.musclehungry.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Hover on 2016/5/12.
 */
public class WantBuy extends BmobObject {
    private String shopid;
    private String shopname;
    private String userid;
    private Double shopprice;

    public Double getShopprice() {
        return shopprice;
    }

    public void setShopprice(Double shopprice) {
        this.shopprice = shopprice;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
