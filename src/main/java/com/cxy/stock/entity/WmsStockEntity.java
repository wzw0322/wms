package com.cxy.stock.entity;

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
 * @Description: 库存表
 * @author onlineGenerator
 * @date 2018-10-30 22:21:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_stock", schema = "")
@SuppressWarnings("serial")
public class WmsStockEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**客户编码*/
	@Excel(name="客户编码",width=15)
	private java.lang.String csCode;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String csName;
	/**货品编码*/
	@Excel(name="货品编码",width=15)
	private java.lang.String goodsCode;
	/**货品名称*/
	@Excel(name="货品名称",width=15)
	private java.lang.String goodsName;
	/**获评类型*/
	@Excel(name="获评类型",width=15)
	private java.lang.String goodsType;
	@Excel(name = "区域", width = 15)
	private java.lang.String areaId;
	/**仓库*/
	@Excel(name="仓库",width=15)
	private java.lang.String wareId;
	/**仓位*/
	@Excel(name="仓位",width=15)
	private java.lang.String positionId;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String unit;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Double stockQuantity;
	/**重量*/
	@Excel(name="重量",width=15)
	private java.lang.Double stockWeight;
	/**体积*/
	@Excel(name="体积",width=15)
	private java.lang.Double stockVolume;
	/**在途数量*/
	@Excel(name="在途数量",width=15)
	private java.lang.Double transQuantity;
	/**在途重量*/
	@Excel(name="在途重量",width=15)
	private java.lang.Double transWeight;
	/**在途体积*/
	@Excel(name="在途体积",width=15)
	private java.lang.Double transVolume;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
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
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */
	@Column(name ="CS_CODE",nullable=true,length=32)
	public java.lang.String getCsCode(){
		return this.csCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setCsCode(java.lang.String csCode){
		this.csCode = csCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CS_NAME",nullable=true,length=32)
	public java.lang.String getCsName(){
		return this.csName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCsName(java.lang.String csName){
		this.csName = csName;
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
	 *@return: java.lang.String  获评类型
	 */
	@Column(name ="GOODS_TYPE",nullable=true,length=32)
	public java.lang.String getGoodsType(){
		return this.goodsType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  获评类型
	 */
	public void setGoodsType(java.lang.String goodsType){
		this.goodsType = goodsType;
	}

	@Column(name = "AREA_ID", nullable = true, length = 36)
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库
	 */
	@Column(name ="WARE_ID",nullable=true,length=36)
	public java.lang.String getWareId(){
		return this.wareId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="UNIT",nullable=true,length=36)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */
	@Column(name ="STOCK_QUANTITY",nullable=true,scale=2,length=32)
	public java.lang.Double getStockQuantity(){
		return this.stockQuantity;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setStockQuantity(java.lang.Double stockQuantity){
		this.stockQuantity = stockQuantity;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  重量
	 */
	@Column(name ="STOCK_WEIGHT",nullable=true,scale=2,length=32)
	public java.lang.Double getStockWeight(){
		return this.stockWeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  重量
	 */
	public void setStockWeight(java.lang.Double stockWeight){
		this.stockWeight = stockWeight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  体积
	 */
	@Column(name ="STOCK_VOLUME",nullable=true,scale=2,length=32)
	public java.lang.Double getStockVolume(){
		return this.stockVolume;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  体积
	 */
	public void setStockVolume(java.lang.Double stockVolume){
		this.stockVolume = stockVolume;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  在途数量
	 */
	@Column(name ="TRANS_QUANTITY",nullable=true,scale=2,length=32)
	public java.lang.Double getTransQuantity(){
		return this.transQuantity;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  在途数量
	 */
	public void setTransQuantity(java.lang.Double transQuantity){
		this.transQuantity = transQuantity;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  在途重量
	 */
	@Column(name ="TRANS_WEIGHT",nullable=true,scale=2,length=32)
	public java.lang.Double getTransWeight(){
		return this.transWeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  在途重量
	 */
	public void setTransWeight(java.lang.Double transWeight){
		this.transWeight = transWeight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  在途体积
	 */
	@Column(name ="TRANS_VOLUME",nullable=true,scale=2,length=32)
	public java.lang.Double getTransVolume(){
		return this.transVolume;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  在途体积
	 */
	public void setTransVolume(java.lang.Double transVolume){
		this.transVolume = transVolume;
	}
}
