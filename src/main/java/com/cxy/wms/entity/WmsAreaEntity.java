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
 * @Description: 仓库区域信息表
 * @author onlineGenerator
 * @date 2018-10-15 12:06:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_area", schema = "")
@SuppressWarnings("serial")
public class WmsAreaEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**区域编码*/
	@Excel(name="区域编码",width=15)
	private java.lang.String areaCode;
	/**区域名称*/
	@Excel(name="区域名称",width=15)
	private java.lang.String areaName;
	/**区域描述*/
	@Excel(name="区域描述",width=15)
	private java.lang.String areaDes;
	/**长（米）*/
	@Excel(name="长（米）",width=15)
	private java.lang.Double areaLength;
	/**宽（米）*/
	@Excel(name="宽（米）",width=15)
	private java.lang.Double areaWidth;
	/**面积*/
	@Excel(name="面积",width=15)
	private java.lang.Double areaSquare;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	
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
	 *@return: java.lang.String  区域编码
	 */

	@Column(name ="AREA_CODE",nullable=false,length=32)
	public java.lang.String getAreaCode(){
		return this.areaCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域编码
	 */
	public void setAreaCode(java.lang.String areaCode){
		this.areaCode = areaCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域名称
	 */

	@Column(name ="AREA_NAME",nullable=false,length=32)
	public java.lang.String getAreaName(){
		return this.areaName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域名称
	 */
	public void setAreaName(java.lang.String areaName){
		this.areaName = areaName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域描述
	 */

	@Column(name ="AREA_DES",nullable=false,length=300)
	public java.lang.String getAreaDes(){
		return this.areaDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域描述
	 */
	public void setAreaDes(java.lang.String areaDes){
		this.areaDes = areaDes;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  长（米）
	 */

	@Column(name ="AREA_LENGTH",nullable=true,length=32)
	public java.lang.Double getAreaLength(){
		return this.areaLength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  长（米）
	 */
	public void setAreaLength(java.lang.Double areaLength){
		this.areaLength = areaLength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  宽（米）
	 */

	@Column(name ="AREA_WIDTH",nullable=true,scale=2,length=11)
	public java.lang.Double getAreaWidth(){
		return this.areaWidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  宽（米）
	 */
	public void setAreaWidth(java.lang.Double areaWidth){
		this.areaWidth = areaWidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  面积
	 */

	@Column(name ="AREA_SQUARE",nullable=true,scale=2,length=11)
	public java.lang.Double getAreaSquare(){
		return this.areaSquare;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  面积
	 */
	public void setAreaSquare(java.lang.Double areaSquare){
		this.areaSquare = areaSquare;
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
}