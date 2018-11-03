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
 * @Description: 托盘日表
 * @author onlineGenerator
 * @date 2018-11-03 16:42:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_pallet_day", schema = "")
@SuppressWarnings("serial")
public class WmsPalletDayEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**托盘材质*/
	@Excel(name="托盘材质",width=15,dicCode="palletMade")
	private java.lang.Integer palletMaterial;
	/**托盘类型*/
	@Excel(name="托盘类型",width=15,dicCode="palletType")
	private java.lang.Integer palletType;
	/**托盘型号*/
	@Excel(name="托盘型号",width=15)
	private java.lang.String palletModel;
	/**使用数量*/
	@Excel(name="使用数量",width=15)
	private java.lang.Integer useNum;
	/**空闲数量*/
	@Excel(name="空闲数量",width=15)
	private java.lang.Integer freeNum;
	/**维修数量*/
	@Excel(name="维修数量",width=15)
	private java.lang.Integer maintainNum;
	/**丢失数量*/
	@Excel(name="丢失数量",width=15)
	private java.lang.Integer lostNum;
	/**合计*/
	@Excel(name="合计",width=15)
	private java.lang.Integer countNum;
	/**时间*/
	private java.util.Date countDate;
	
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  使用数量
	 */
	@Column(name ="USE_NUM",nullable=true,length=11)
	public java.lang.Integer getUseNum(){
		return this.useNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  使用数量
	 */
	public void setUseNum(java.lang.Integer useNum){
		this.useNum = useNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  空闲数量
	 */
	@Column(name ="FREE_NUM",nullable=true,length=11)
	public java.lang.Integer getFreeNum(){
		return this.freeNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  空闲数量
	 */
	public void setFreeNum(java.lang.Integer freeNum){
		this.freeNum = freeNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  维修数量
	 */
	@Column(name ="MAINTAIN_NUM",nullable=true,length=11)
	public java.lang.Integer getMaintainNum(){
		return this.maintainNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  维修数量
	 */
	public void setMaintainNum(java.lang.Integer maintainNum){
		this.maintainNum = maintainNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  丢失数量
	 */
	@Column(name ="LOST_NUM",nullable=true,length=11)
	public java.lang.Integer getLostNum(){
		return this.lostNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  丢失数量
	 */
	public void setLostNum(java.lang.Integer lostNum){
		this.lostNum = lostNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  合计
	 */
	@Column(name ="COUNT_NUM",nullable=true,length=11)
	public java.lang.Integer getCountNum(){
		return this.countNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  合计
	 */
	public void setCountNum(java.lang.Integer countNum){
		this.countNum = countNum;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="COUNT_DATE",nullable=true,length=32)
	public java.util.Date getCountDate(){
		return this.countDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setCountDate(java.util.Date countDate){
		this.countDate = countDate;
	}
}
