package com.cxy.pallet.entity;

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
 * @Description: 托盘信息表
 * @author onlineGenerator
 * @date 2018-11-03 15:52:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_pallet", schema = "")
@SuppressWarnings("serial")
public class WmsPalletEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**托盘编码*/
	@Excel(name="托盘编码",width=15)
	private java.lang.String palletCode;
	/**托盘材质*/
	@Excel(name="托盘材质",width=15,dicCode="palletMade")
	private java.lang.Integer palletMaterial;
	/**托盘类型*/
	@Excel(name="托盘类型",width=15,dicCode="palletType")
	private java.lang.Integer palletType;
	/**托盘型号*/
	@Excel(name="托盘型号",width=15)
	private java.lang.String palletModel;
	/**生产厂商*/
	@Excel(name="生产厂商",width=15)
	private java.lang.String palletProducer;
	/**长（毫米）*/
	@Excel(name="长（毫米）",width=15)
	private java.lang.Integer palletLength;
	/**宽（毫米）*/
	@Excel(name="宽（毫米）",width=15)
	private java.lang.Integer palletWidth;
	/**高（毫米）*/
	@Excel(name="高（毫米）",width=15)
	private java.lang.Integer palletHeight;
	/**价格*/
	@Excel(name="价格",width=15)
	private java.lang.Double palletPrice;
	/**静载（T）*/
	@Excel(name="静载（T）",width=15)
	private java.lang.Double palletStaticLoad;
	/**动载（T）*/
	@Excel(name="动载（T）",width=15)
	private java.lang.Double palletLiveLoad;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="palletStat")
	private java.lang.Integer palletStatus;
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
	 *@return: java.lang.String  托盘编码
	 */
	@Column(name ="PALLET_CODE",nullable=true,length=32)
	public java.lang.String getPalletCode(){
		return this.palletCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  托盘编码
	 */
	public void setPalletCode(java.lang.String palletCode){
		this.palletCode = palletCode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  托盘材质
	 */
	@Column(name ="PALLET_MATERIAL",nullable=true,length=2)
	public java.lang.Integer getPalletMaterial(){
		return this.palletMaterial;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  托盘材质
	 */
	public void setPalletMaterial(java.lang.Integer palletMaterial){
		this.palletMaterial = palletMaterial;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  托盘类型
	 */
	@Column(name ="PALLET_TYPE",nullable=true,length=2)
	public java.lang.Integer getPalletType(){
		return this.palletType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  托盘类型
	 */
	public void setPalletType(java.lang.Integer palletType){
		this.palletType = palletType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  托盘型号
	 */
	@Column(name ="PALLET_MODEL",nullable=true,length=32)
	public java.lang.String getPalletModel(){
		return this.palletModel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  托盘型号
	 */
	public void setPalletModel(java.lang.String palletModel){
		this.palletModel = palletModel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产厂商
	 */
	@Column(name ="PALLET_PRODUCER",nullable=true,length=100)
	public java.lang.String getPalletProducer(){
		return this.palletProducer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产厂商
	 */
	public void setPalletProducer(java.lang.String palletProducer){
		this.palletProducer = palletProducer;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  长（毫米）
	 */
	@Column(name ="PALLET_LENGTH",nullable=true,length=11)
	public java.lang.Integer getPalletLength(){
		return this.palletLength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  长（毫米）
	 */
	public void setPalletLength(java.lang.Integer palletLength){
		this.palletLength = palletLength;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  宽（毫米）
	 */
	@Column(name ="PALLET_WIDTH",nullable=true,length=11)
	public java.lang.Integer getPalletWidth(){
		return this.palletWidth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  宽（毫米）
	 */
	public void setPalletWidth(java.lang.Integer palletWidth){
		this.palletWidth = palletWidth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  高（毫米）
	 */
	@Column(name ="PALLET_HEIGHT",nullable=true,length=11)
	public java.lang.Integer getPalletHeight(){
		return this.palletHeight;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  高（毫米）
	 */
	public void setPalletHeight(java.lang.Integer palletHeight){
		this.palletHeight = palletHeight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  价格
	 */
	@Column(name ="PALLET_PRICE",nullable=true,scale=2,length=11)
	public java.lang.Double getPalletPrice(){
		return this.palletPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  价格
	 */
	public void setPalletPrice(java.lang.Double palletPrice){
		this.palletPrice = palletPrice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  静载（T）
	 */
	@Column(name ="PALLET_STATIC_LOAD",nullable=true,scale=2,length=11)
	public java.lang.Double getPalletStaticLoad(){
		return this.palletStaticLoad;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  静载（T）
	 */
	public void setPalletStaticLoad(java.lang.Double palletStaticLoad){
		this.palletStaticLoad = palletStaticLoad;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  动载（T）
	 */
	@Column(name ="PALLET_LIVE_LOAD",nullable=true,scale=2,length=11)
	public java.lang.Double getPalletLiveLoad(){
		return this.palletLiveLoad;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  动载（T）
	 */
	public void setPalletLiveLoad(java.lang.Double palletLiveLoad){
		this.palletLiveLoad = palletLiveLoad;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */
	@Column(name ="PALLET_STATUS",nullable=true,length=2)
	public java.lang.Integer getPalletStatus(){
		return this.palletStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setPalletStatus(java.lang.Integer palletStatus){
		this.palletStatus = palletStatus;
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
