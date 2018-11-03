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
 * @Description: 质检单
 * @author onlineGenerator
 * @date 2018-10-27 20:56:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_check_card", schema = "")
@SuppressWarnings("serial")
public class WmsCheckCardEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**质检单号*/
	@Excel(name="质检单号",width=15)
	private java.lang.String qcCode;
	/**入库单号*/
	@Excel(name="入库单号",width=15)
	private java.lang.String instoreCode;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String csName;
	/**客户编码*/
	@Excel(name="客户编码",width=15)
	private java.lang.String csCode;
	/**仓库名称*/
	@Excel(name="仓库ID",width=15)
	private java.lang.String wareId;
	@Excel(name = "仓库名称",width=15)
	private java.lang.String wareName;
	/**质检类型*/
	@Excel(name="质检类型",width=15,dicCode="qc_type")
	private java.lang.Integer qcType;
	/**货物名称*/
	@Excel(name="货物名称",width=15)
	private java.lang.String goodsName;
	/**货物编码*/
	private java.lang.String goodsCode;
	/**货物类型*/
	private java.lang.String goodsType;
	/**应检数量*/
	@Excel(name="应检数量",width=15)
	private java.lang.Double needCheckNum;
	/**已检数量*/
	@Excel(name="已检数量",width=15)
	private java.lang.Double checkedNum;
	/**抽检数量*/
	@Excel(name="抽检数量",width=15)
	private java.lang.Double randomNum;
	/**单位*/
	@Excel(name="单位",width=15,dictTable ="wms_unit",dicCode ="id",dicText ="unit_name")
	private java.lang.String unit;
	/**合格数量*/
	@Excel(name="合格数量",width=15)
	private java.lang.Double qualifiedNum;
	/**不合格数量*/
	@Excel(name="不合格数量",width=15)
	private java.lang.Double unqualifiedNum;
	/**质检状态*/
	@Excel(name="质检状态",width=15,dicCode="qc_status")
	private java.lang.Integer qcStatus;
	/**质检人*/
	@Excel(name="质检人",width=15)
	private java.lang.String qcMan;
	/**质检时间*/
	@Excel(name="质检时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date qcTime;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	
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
	 *@return: java.lang.String  质检单号
	 */
	@Column(name ="QC_CODE",nullable=true,length=32)
	public java.lang.String getQcCode(){
		return this.qcCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  质检单号
	 */
	public void setQcCode(java.lang.String qcCode){
		this.qcCode = qcCode;
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

	@Column(name ="WARE_NAME",nullable=true,length=32)
	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  质检类型
	 */
	@Column(name ="QC_TYPE",nullable=true,length=2)
	public java.lang.Integer getQcType(){
		return this.qcType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  质检类型
	 */
	public void setQcType(java.lang.Integer qcType){
		this.qcType = qcType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物名称
	 */
	@Column(name ="GOODS_NAME",nullable=true,length=32)
	public java.lang.String getGoodsName(){
		return this.goodsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物名称
	 */
	public void setGoodsName(java.lang.String goodsName){
		this.goodsName = goodsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物编码
	 */
	@Column(name ="GOODS_CODE",nullable=true,length=32)
	public java.lang.String getGoodsCode(){
		return this.goodsCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物编码
	 */
	public void setGoodsCode(java.lang.String goodsCode){
		this.goodsCode = goodsCode;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  应检数量
	 */
	@Column(name ="NEED_CHECK_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getNeedCheckNum(){
		return this.needCheckNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  应检数量
	 */
	public void setNeedCheckNum(java.lang.Double needCheckNum){
		this.needCheckNum = needCheckNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  已检数量
	 */
	@Column(name ="CHECKED_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getCheckedNum(){
		return this.checkedNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  已检数量
	 */
	public void setCheckedNum(java.lang.Double checkedNum){
		this.checkedNum = checkedNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  抽检数量
	 */
	@Column(name ="RANDOM_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getRandomNum(){
		return this.randomNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  抽检数量
	 */
	public void setRandomNum(java.lang.Double randomNum){
		this.randomNum = randomNum;
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
	 *@return: java.lang.Double  合格数量
	 */
	@Column(name ="QUALIFIED_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getQualifiedNum(){
		return this.qualifiedNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  合格数量
	 */
	public void setQualifiedNum(java.lang.Double qualifiedNum){
		this.qualifiedNum = qualifiedNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  不合格数量
	 */
	@Column(name ="UNQUALIFIED_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getUnqualifiedNum(){
		return this.unqualifiedNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  不合格数量
	 */
	public void setUnqualifiedNum(java.lang.Double unqualifiedNum){
		this.unqualifiedNum = unqualifiedNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  质检状态
	 */
	@Column(name ="QC_STATUS",nullable=true,length=2)
	public java.lang.Integer getQcStatus(){
		return this.qcStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  质检状态
	 */
	public void setQcStatus(java.lang.Integer qcStatus){
		this.qcStatus = qcStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  质检人
	 */
	@Column(name ="QC_MAN",nullable=true,length=50)
	public java.lang.String getQcMan(){
		return this.qcMan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  质检人
	 */
	public void setQcMan(java.lang.String qcMan){
		this.qcMan = qcMan;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  质检时间
	 */
	@Column(name ="QC_TIME",nullable=true,length=32)
	public java.util.Date getQcTime(){
		return this.qcTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  质检时间
	 */
	public void setQcTime(java.util.Date qcTime){
		this.qcTime = qcTime;
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
}
