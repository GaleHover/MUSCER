package com.hys.musclehungry.Handler;

import android.graphics.Bitmap;

/**
 * Created by Hover on 2016/5/11.
 */
public class ShopInfo2 {
    private Double ShopPrice;
    private String ShopName;
    private Bitmap Shoppic;

    public String getHiddenID() {
        return hiddenID;
    }

    public void setHiddenID(String hiddenID) {
        this.hiddenID = hiddenID;
    }

    private String hiddenID;
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

    public Bitmap getShoppic() {
        return Shoppic;
    }

    public void setShoppic(Bitmap shoppic) {
        Shoppic = shoppic;
    }

    public Integer getDianZan() {
        return DianZan;
    }

    public void setDianZan(Integer dianZan) {
        DianZan = dianZan;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    private Integer DianZan;
    private String descript;

}
