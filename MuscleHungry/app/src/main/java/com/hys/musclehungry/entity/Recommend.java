package com.hys.musclehungry.entity;

/**
 * Created by Hover on 2016/5/8.
 */
public class Recommend {
    private String descript;
    private int imageId;
    private String foodName;
    private String foodPrice;
    private String hiddenMsg;

    public Recommend(String descript, int imageId, String foodName, String foodPrice, String hiddenMsg) {
        this.descript = descript;
        this.imageId = imageId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.hiddenMsg = hiddenMsg;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getHiddenMsg() {
        return hiddenMsg;
    }

    public void setHiddenMsg(String hiddenMsg) {
        this.hiddenMsg = hiddenMsg;
    }
}
