package com.cxy.instore.entity;

/**
 * 功能描述:入库单初始化剩余信息-后台根据订单信息补全 <br>
 *
 * @Author: wzw
 * @Date: 2018/10/27 14:00
 */
public class InstoreExtraInfo {
    /**
     * 含义:客户编码<br>
     */
    private String customerCode;
    /**
     * 含义:货物编码<br>
     */
    private String goodsCode;
    /**
     * 含义:货物类型<br>
     */
    private String goodsType;
    /**
     * 含义:体积<br>
     */
    private String volume;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InstoreExtraInfo{");
        sb.append("customerCode='").append(customerCode).append('\'');
        sb.append(", goodsCode='").append(goodsCode).append('\'');
        sb.append(", goodsType='").append(goodsType).append('\'');
        sb.append(", volume='").append(volume).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
