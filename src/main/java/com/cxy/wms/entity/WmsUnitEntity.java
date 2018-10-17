package com.cxy.wms.entity;

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
 * @Description: 单位信息表
 * @author onlineGenerator
 * @date 2018-10-17 20:38:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_unit", schema = "")
@SuppressWarnings("serial")
public class WmsUnitEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**单位编码*/
	@Excel(name="单位编码",width=15)
	private java.lang.String unitCode;
	/**单位名称*/
	@Excel(name="单位名称",width=15)
	private java.lang.String unitName;
	/**单位类型*/
	@Excel(name="单位类型",width=15,dicCode="unitType")
	private java.lang.Integer unitType;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="wh_simple")
	private java.lang.Integer unitStatus;
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
	 *@return: java.lang.String  单位编码
	 */

	@Column(name ="UNIT_CODE",nullable=true,length=32)
	public java.lang.String getUnitCode(){
		return this.unitCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位编码
	 */
	public void setUnitCode(java.lang.String unitCode){
		this.unitCode = unitCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位名称
	 */

	@Column(name ="UNIT_NAME",nullable=true,length=32)
	public java.lang.String getUnitName(){
		return this.unitName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位名称
	 */
	public void setUnitName(java.lang.String unitName){
		this.unitName = unitName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  单位类型
	 */

	@Column(name ="UNIT_TYPE",nullable=true,length=2)
	public java.lang.Integer getUnitType(){
		return this.unitType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  单位类型
	 */
	public void setUnitType(java.lang.Integer unitType){
		this.unitType = unitType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */

	@Column(name ="UNIT_STATUS",nullable=true,length=2)
	public java.lang.Integer getUnitStatus(){
		return this.unitStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setUnitStatus(java.lang.Integer unitStatus){
		this.unitStatus = unitStatus;
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

	@Column(name ="ISDEL",nullable=true,length=32)
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