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
 * @Description: 仓库信息表
 * @author onlineGenerator
 * @date 2018-10-10 21:29:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_ware_house", schema = "")
@SuppressWarnings("serial")
public class WmsWareHouseEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**区域名称*/
	@Excel(name="区域名称",width=15,dictTable ="wms_area",dicCode ="id",dicText ="area_name")
	private java.lang.String areaId;
	/**仓库编码*/
	@Excel(name="仓库编码",width=15)
	private java.lang.String houseCode;
	/**仓库名称*/
	@Excel(name="仓库名称",width=15)
	private java.lang.String houseName;
	/**仓库面积*/
	@Excel(name="仓库面积",width=15)
	private java.lang.String houseSquare;
	/**仓库状态*/
	@Excel(name="仓库状态",width=15,dicCode="wh_status")
	private java.lang.Integer houseStatus;
	/**仓库负责人*/
	@Excel(name="仓库负责人",width=15)
	private java.lang.String houseLeader;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String houseTel;
	/**仓库描述*/
	@Excel(name="仓库描述",width=15)
	private java.lang.String houseDes;
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
	 *@return: java.lang.String  区域名称
	 */

	@Column(name ="AREA_ID",nullable=true,length=36)
	public java.lang.String getAreaId(){
		return this.areaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域名称
	 */
	public void setAreaId(java.lang.String areaId){
		this.areaId = areaId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库编码
	 */

	@Column(name ="HOUSE_CODE",nullable=true,length=32)
	public java.lang.String getHouseCode(){
		return this.houseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库编码
	 */
	public void setHouseCode(java.lang.String houseCode){
		this.houseCode = houseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */

	@Column(name ="HOUSE_NAME",nullable=true,length=32)
	public java.lang.String getHouseName(){
		return this.houseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setHouseName(java.lang.String houseName){
		this.houseName = houseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库面积
	 */

	@Column(name ="HOUSE_SQUARE",nullable=true,length=32)
	public java.lang.String getHouseSquare(){
		return this.houseSquare;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库面积
	 */
	public void setHouseSquare(java.lang.String houseSquare){
		this.houseSquare = houseSquare;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  仓库状态
	 */

	@Column(name ="HOUSE_STATUS",nullable=true,length=2)
	public java.lang.Integer getHouseStatus(){
		return this.houseStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  仓库状态
	 */
	public void setHouseStatus(java.lang.Integer houseStatus){
		this.houseStatus = houseStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库负责人
	 */

	@Column(name ="HOUSE_LEADER",nullable=true,length=32)
	public java.lang.String getHouseLeader(){
		return this.houseLeader;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库负责人
	 */
	public void setHouseLeader(java.lang.String houseLeader){
		this.houseLeader = houseLeader;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="HOUSE_TEL",nullable=true,length=11)
	public java.lang.String getHouseTel(){
		return this.houseTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setHouseTel(java.lang.String houseTel){
		this.houseTel = houseTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库描述
	 */

	@Column(name ="HOUSE_DES",nullable=true,length=300)
	public java.lang.String getHouseDes(){
		return this.houseDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库描述
	 */
	public void setHouseDes(java.lang.String houseDes){
		this.houseDes = houseDes;
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