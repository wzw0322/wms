package com.cxy.instore.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 入库单
 * @author onlineGenerator
 * @date 2018-10-27 10:49:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_instore_card", schema = "")
@SuppressWarnings("serial")
public class WmsInstoreCardEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**入库单号*/
	@Excel(name="入库单号",width=15)
	private java.lang.String instoreCode;
	/**入库订单号*/
	@Excel(name="入库订单号",width=15)
	private java.lang.String orderCode;
	/**仓库名称*/
	@Excel(name="仓库名称",width=15,dictTable ="wms_ware_house",dicCode ="id",dicText ="house_name")
	private java.lang.String wareId;
	/**仓位*/
	private java.lang.String positionId;
	/**入库类型*/
	@Excel(name="入库类型",width=15,dicCode="inSType")
	private java.lang.Integer instoreType;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String customerName;
	/**客户编码*/
	private java.lang.String customerCode;
	/**货品编码*/
	private java.lang.String goodsCode;
	/**货品名称*/
	@Excel(name="货品名称",width=15)
	private java.lang.String goodsName;
	/**货物类型*/
	private java.lang.String goodsType;
	/**运输方式*/
	@Excel(name="运输方式",width=15)
	private java.lang.String transMode;
	/**入库单状态*/
	private java.lang.Integer instoreStatus;
	/**发运地*/
	@Excel(name="发运地",width=15)
	private java.lang.String srcAddress;
	/**到达地*/
	@Excel(name="到达地",width=15)
	private java.lang.String destAddress;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Integer quantity;
	/**重量*/
	@Excel(name="重量",width=15)
	private java.lang.Double weight;
	/**单位*/
	@Excel(name="单位",width=15,dictTable ="wms_unit",dicCode ="id",dicText ="unit_name")
	private java.lang.String uint;
	/**体积*/
	private java.lang.String volume;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**是否删除 0-否 1-是*/
	private java.lang.Integer isdel;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库单号
	 */
	@Column(name ="INSTORE_CODE",nullable=true,length=32)
	public java.lang.String getInstoreCode(){
		return this.instoreCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库单号
	 */
	public void setInstoreCode(java.lang.String instoreCode){
		this.instoreCode = instoreCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入库订单号
	 */
	@Column(name ="ORDER_CODE",nullable=true,length=32)
	public java.lang.String getOrderCode(){
		return this.orderCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入库订单号
	 */
	public void setOrderCode(java.lang.String orderCode){
		this.orderCode = orderCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="WARE_ID",nullable=true,length=36)
	public java.lang.String getWareId(){
		return this.wareId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setWareId(java.lang.String wareId){
		this.wareId = wareId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓位
	 */
	@Column(name ="POSITION_ID",nullable=true,length=36)
	public java.lang.String getPositionId(){
		return this.positionId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓位
	 */
	public void setPositionId(java.lang.String positionId){
		this.positionId = positionId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  入库类型
	 */
	@Column(name ="INSTORE_TYPE",nullable=true,length=10)
	public java.lang.Integer getInstoreType(){
		return this.instoreType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  入库类型
	 */
	public void setInstoreType(java.lang.Integer instoreType){
		this.instoreType = instoreType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CUSTOMER_NAME",nullable=true,length=50)
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */
	@Column(name ="CUSTOMER_CODE",nullable=true,length=32)
	public java.lang.String getCustomerCode(){
		return this.customerCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setCustomerCode(java.lang.String customerCode){
		this.customerCode = customerCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货品编码
	 */
	@Column(name ="GOODS_CODE",nullable=true,length=32)
	public java.lang.String getGoodsCode(){
		return this.goodsCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货品编码
	 */
	public void setGoodsCode(java.lang.String goodsCode){
		this.goodsCode = goodsCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货品名称
	 */
	@Column(name ="GOODS_NAME",nullable=true,length=32)
	public java.lang.String getGoodsName(){
		return this.goodsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货品名称
	 */
	public void setGoodsName(java.lang.String goodsName){
		this.goodsName = goodsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物类型
	 */
	@Column(name ="GOODS_TYPE",nullable=true,length=32)
	public java.lang.String getGoodsType(){
		return this.goodsType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物类型
	 */
	public void setGoodsType(java.lang.String goodsType){
		this.goodsType = goodsType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式
	 */
	@Column(name ="TRANS_MODE",nullable=true,length=32)
	public java.lang.String getTransMode(){
		return this.transMode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式
	 */
	public void setTransMode(java.lang.String transMode){
		this.transMode = transMode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  入库单状态
	 */
	@Column(name ="INSTORE_STATUS",nullable=true,length=10)
	public java.lang.Integer getInstoreStatus(){
		return this.instoreStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  入库单状态
	 */
	public void setInstoreStatus(java.lang.Integer instoreStatus){
		this.instoreStatus = instoreStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发运地
	 */
	@Column(name ="SRC_ADDRESS",nullable=true,length=160)
	public java.lang.String getSrcAddress(){
		return this.srcAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发运地
	 */
	public void setSrcAddress(java.lang.String srcAddress){
		this.srcAddress = srcAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  到达地
	 */
	@Column(name ="DEST_ADDRESS",nullable=true,length=160)
	public java.lang.String getDestAddress(){
		return this.destAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  到达地
	 */
	public void setDestAddress(java.lang.String destAddress){
		this.destAddress = destAddress;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="QUANTITY",nullable=true,length=11)
	public java.lang.Integer getQuantity(){
		return this.quantity;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setQuantity(java.lang.Integer quantity){
		this.quantity = quantity;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  重量
	 */
	@Column(name ="WEIGHT",nullable=true,scale=2,length=11)
	public java.lang.Double getWeight(){
		return this.weight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  重量
	 */
	public void setWeight(java.lang.Double weight){
		this.weight = weight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="UINT",nullable=true,length=36)
	public java.lang.String getUint(){
		return this.uint;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUint(java.lang.String uint){
		this.uint = uint;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */
	@Column(name ="VOLUME",nullable=true,length=32)
	public java.lang.String getVolume(){
		return this.volume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setVolume(java.lang.String volume){
		this.volume = volume;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否删除 0-否 1-是
	 */
	@Column(name ="ISDEL",nullable=true,length=2)
	public java.lang.Integer getIsdel(){
		return this.isdel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否删除 0-否 1-是
	 */
	public void setIsdel(java.lang.Integer isdel){
		this.isdel = isdel;
	}
}
