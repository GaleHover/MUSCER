package com.hys.musclehungry.entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Hover on 2016/5/11.
 */
public class ShopInfo extends BmobObject {
    private Double ShopPrice;
    private String ShopName;

    private Integer DianZan;
    private String descript;
    private BmobFile ShopPic;
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }


    public Double getShopPrice() {
        return ShopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        ShopPrice = shopPrice;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public BmobFile getShopPic() {
        return ShopPic;
    }

    public void setShopPic(BmobFile shopPic) {
        ShopPic = shopPic;
    }

    public Integer getDianZan() {
        return DianZan;
    }

    public void setDianZan(Integer dianZan) {
        DianZan = dianZan;
    }
}
