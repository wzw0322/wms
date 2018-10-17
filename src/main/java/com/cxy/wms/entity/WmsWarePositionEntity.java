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
 * @Description: 仓位信息表
 * @author onlineGenerator
 * @date 2018-10-15 16:27:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_ware_position", schema = "")
@SuppressWarnings("serial")
public class WmsWarePositionEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**仓库名称*/
	@Excel(name="仓库名称",width=15,dictTable ="wms_ware_house",dicCode ="id",dicText ="house_name")
	private java.lang.String whId;
	/**仓位编码*/
	@Excel(name="仓位编码",width=15)
	private java.lang.String positionCode;
	/**仓位名称*/
	@Excel(name="仓位名称",width=15)
	private java.lang.String positionName;
	/**长（厘米）*/
	@Excel(name="长（厘米）",width=15)
	private java.lang.Double positionLength;
	/**宽（厘米）*/
	@Excel(name="宽（厘米）",width=15)
	private java.lang.Double positionWidth;
	/**高（厘米）*/
	@Excel(name="高（厘米）",width=15)
	private java.lang.Double positionHeight;
	/**体积限制*/
	@Excel(name="体积限制",width=15)
	private java.lang.String sizeLimit;
	/**数量限制*/
	@Excel(name="数量限制",width=15)
	private java.lang.Integer numLimit;
	/**重量限制*/
	@Excel(name="重量限制",width=15)
	private java.lang.Double weightLimit;
	/**箱数限制*/
	@Excel(name="箱数限制",width=15)
	private java.lang.Integer boxLimit;
	/**创建人名称*/
	private java.lang.String createName;
	/**仓位状态*/
	@Excel(name="仓位状态",width=15,dicCode="ps_status")
	private java.lang.Integer positionStatus;
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
	 *@return: java.lang.String  仓库名称
	 */

	@Column(name ="WH_ID",nullable=true,length=36)
	public java.lang.String getWhId(){
		return this.whId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setWhId(java.lang.String whId){
		this.whId = whId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓位编码
	 */

	@Column(name ="POSITION_CODE",nullable=true,length=32)
	public java.lang.String getPositionCode(){
		return this.positionCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓位编码
	 */
	public void setPositionCode(java.lang.String positionCode){
		this.positionCode = positionCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓位名称
	 */

	@Column(name ="POSITION_NAME",nullable=true,length=32)
	public java.lang.String getPositionName(){
		return this.positionName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓位名称
	 */
	public void setPositionName(java.lang.String positionName){
		this.positionName = positionName;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  长（厘米）
	 */

	@Column(name ="POSITION_LENGTH",nullable=true,scale=2,length=11)
	public java.lang.Double getPositionLength(){
		return this.positionLength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  长（厘米）
	 */
	public void setPositionLength(java.lang.Double positionLength){
		this.positionLength = positionLength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  宽（厘米）
	 */

	@Column(name ="POSITION_WIDTH",nullable=true,scale=2,length=11)
	public java.lang.Double getPositionWidth(){
		return this.positionWidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  宽（厘米）
	 */
	public void setPositionWidth(java.lang.Double positionWidth){
		this.positionWidth = positionWidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  高（厘米）
	 */

	@Column(name ="POSITION_HEIGHT",nullable=true,scale=2,length=11)
	public java.lang.Double getPositionHeight(){
		return this.positionHeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  高（厘米）
	 */
	public void setPositionHeight(java.lang.Double positionHeight){
		this.positionHeight = positionHeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积限制
	 */

	@Column(name ="SIZE_LIMIT",nullable=true,length=32)
	public java.lang.String getSizeLimit(){
		return this.sizeLimit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积限制
	 */
	public void setSizeLimit(java.lang.String sizeLimit){
		this.sizeLimit = sizeLimit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量限制
	 */

	@Column(name ="NUM_LIMIT",nullable=true,length=11)
	public java.lang.Integer getNumLimit(){
		return this.numLimit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量限制
	 */
	public void setNumLimit(java.lang.Integer numLimit){
		this.numLimit = numLimit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  重量限制
	 */

	@Column(name ="WEIGHT_LIMIT",nullable=true,scale=2,length=11)
	public java.lang.Double getWeightLimit(){
		return this.weightLimit;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  重量限制
	 */
	public void setWeightLimit(java.lang.Double weightLimit){
		this.weightLimit = weightLimit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  箱数限制
	 */

	@Column(name ="BOX_LIMIT",nullable=true,length=11)
	public java.lang.Integer getBoxLimit(){
		return this.boxLimit;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  箱数限制
	 */
	public void setBoxLimit(java.lang.Integer boxLimit){
		this.boxLimit = boxLimit;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  仓位状态
	 */

	@Column(name ="POSITION_STATUS",nullable=true,length=2)
	public java.lang.Integer getPositionStatus(){
		return this.positionStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  仓位状态
	 */
	public void setPositionStatus(java.lang.Integer positionStatus){
		this.positionStatus = positionStatus;
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