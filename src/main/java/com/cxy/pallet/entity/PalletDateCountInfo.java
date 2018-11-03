package com.cxy.pallet.entity;

/**
 * 功能描述:托盘日用统计报表对象 <br>
 *
 * @Author: wzw
 * @Date: 2018/11/3 17:02
 */
public class PalletDateCountInfo {
    /**
     * 含义:托盘材质<br>
     */
    private int palletMaterial;
    /**
     * 含义:托盘类型<br>
     */
    private int palletType;
    /**
     * 含义:托盘型号<br>
     */
    private String palletModel;
    /**
     * 含义:使用中的数量<br>
     */
    private int useNum;
    /**
     * 含义:空闲中的数量<br>
     */
    private int freeNum;
    /**
     * 含义:维修中的数量<br>
     */
    private int maintainNum;
    /**
     * 含义:丢失的数量<br>
     */
    private int lostNum;

    public int getPalletMaterial() {
        return palletMaterial;
    }

    public void setPalletMaterial(int palletMaterial) {
        this.palletMaterial = palletMaterial;
    }

    public int getPalletType() {
        return palletType;
    }

    public void setPalletType(int palletType) {
        this.palletType = palletType;
    }

    public String getPalletModel() {
        return palletModel;
    }

    public void setPalletModel(String palletModel) {
        this.palletModel = palletModel;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public int getFreeNum() {
        return freeNum;
    }

    public void setFreeNum(int freeNum) {
        this.freeNum = freeNum;
    }

    public int getMaintainNum() {
        return maintainNum;
    }

    public void setMaintainNum(int maintainNum) {
        this.maintainNum = maintainNum;
    }

    public int getLostNum() {
        return lostNum;
    }

    public void setLostNum(int lostNum) {
        this.lostNum = lostNum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PalletDateCountInfo{");
        sb.append("palletMaterial=").append(palletMaterial);
        sb.append(", palletType=").append(palletType);
        sb.append(", palletModel='").append(palletModel).append('\'');
        sb.append(", useNum=").append(useNum);
        sb.append(", freeNum=").append(freeNum);
        sb.append(", maintainNum=").append(maintainNum);
        sb.append(", lostNum=").append(lostNum);
        sb.append('}');
        return sb.toString();
    }
}
