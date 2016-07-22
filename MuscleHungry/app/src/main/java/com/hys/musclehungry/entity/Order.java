package com.hys.musclehungry.entity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;

/**
 * Created by Hover on 2016/5/12.
 */
public class Order extends BmobObject {
    private String userid;
    private String xinxi ;
    private String zhuangtai;
    private String address;
    private String phone;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getXinxi() {
        return xinxi;
    }

    public void setXinxi(String xinxi) {
        this.xinxi = xinxi;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
