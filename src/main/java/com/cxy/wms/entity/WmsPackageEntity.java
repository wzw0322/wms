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
 * @Description: 仓储包装信息表
 * @author onlineGenerator
 * @date 2018-10-17 21:13:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_package", schema = "")
@SuppressWarnings("serial")
public class WmsPackageEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**包装箱编码*/
	@Excel(name="包装箱编码",width=15)
	private java.lang.String packCode;
	/**包装箱名称*/
	@Excel(name="包装箱名称",width=15)
	private java.lang.String packName;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="wh_simple")
	private java.lang.Integer packStatus;
	/**描述*/
	@Excel(name="描述",width=15)
	private java.lang.String packDes;
	/**长（厘米）*/
	@Excel(name="长（厘米）",width=15)
	private java.lang.Double packLength;
	/**宽（厘米）*/
	@Excel(name="宽（厘米）",width=15)
	private java.lang.Double packWidth;
	/**高（厘米）*/
	@Excel(name="高（厘米）",width=15)
	private java.lang.Double packHeight;
	/**重量（克）*/
	@Excel(name="重量（克）",width=15)
	private java.lang.Double packWeight;
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
	 *@return: java.lang.String  包装箱编码
	 */

	@Column(name ="PACK_CODE",nullable=true,length=32)
	public java.lang.String getPackCode(){
		return this.packCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装箱编码
	 */
	public void setPackCode(java.lang.String packCode){
		this.packCode = packCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装箱名称
	 */

	@Column(name ="PACK_NAME",nullable=true,length=32)
	public java.lang.String getPackName(){
		return this.packName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装箱名称
	 */
	public void setPackName(java.lang.String packName){
		this.packName = packName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  状态
	 */

	@Column(name ="PACK_STATUS",nullable=true,length=2)
	public java.lang.Integer getPackStatus(){
		return this.packStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  状态
	 */
	public void setPackStatus(java.lang.Integer packStatus){
		this.packStatus = packStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */

	@Column(name ="PACK_DES",nullable=true,length=300)
	public java.lang.String getPackDes(){
		return this.packDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setPackDes(java.lang.String packDes){
		this.packDes = packDes;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  长（厘米）
	 */

	@Column(name ="PACK_LENGTH",nullable=true,scale=2,length=11)
	public java.lang.Double getPackLength(){
		return this.packLength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  长（厘米）
	 */
	public void setPackLength(java.lang.Double packLength){
		this.packLength = packLength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  宽（厘米）
	 */

	@Column(name ="PACK_WIDTH",nullable=true,scale=2,length=11)
	public java.lang.Double getPackWidth(){
		return this.packWidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  宽（厘米）
	 */
	public void setPackWidth(java.lang.Double packWidth){
		this.packWidth = packWidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  高（厘米）
	 */

	@Column(name ="PACK_HEIGHT",nullable=true,scale=2,length=11)
	public java.lang.Double getPackHeight(){
		return this.packHeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  高（厘米）
	 */
	public void setPackHeight(java.lang.Double packHeight){
		this.packHeight = packHeight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  重量（克）
	 */

	@Column(name ="PACK_WEIGHT",nullable=true,scale=2,length=11)
	public java.lang.Double getPackWeight(){
		return this.packWeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  重量（克）
	 */
	public void setPackWeight(java.lang.Double packWeight){
		this.packWeight = packWeight;
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