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
 * @Description: 收货单
 * @author onlineGenerator
 * @date 2018-10-29 21:24:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "wms_receive_card", schema = "")
@SuppressWarnings("serial")
public class WmsReceiveCardEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**收货单号*/
	@Excel(name="收货单号",width=15)
	private java.lang.String shCode;
	/**质检单号*/
	@Excel(name="质检单号",width=15)
	private java.lang.String qcCode;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String csName;
	/**客户编码*/
	@Excel(name="客户编码",width=15)
	private java.lang.String csCode;
	/**仓库ID*/
	private java.lang.String wareId;
	/**仓库名称*/
	@Excel(name="仓库名称",width=15)
	private java.lang.String wareName;
	/**仓位*/
	private java.lang.String positionId;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String unit;
	/**货物名称*/
	@Excel(name="货物名称",width=15)
	private java.lang.String goodsName;
	/**货物编码*/
	private java.lang.String goodsCode;
	/**货物类型*/
	private java.lang.String goodsType;
	/**收货单状态*/
	private java.lang.Integer shStatus;
	/**收货数量*/
	@Excel(name="收货数量",width=15)
	private java.lang.Double shNum;
	/**现收数量*/
	@Excel(name="现收数量",width=15)
	private java.lang.Double currentShNum;
	/**体积*/
	@Excel(name="体积",width=15)
	private java.lang.Double volume;
	/**毛重*/
	@Excel(name="毛重",width=15)
	private java.lang.Double grossWeight;
	/**净重*/
	@Excel(name="净重",width=15)
	private java.lang.Double netWeight;
	/**是否良品*/
	@Excel(name="是否良品",width=15)
	private java.lang.String isGood;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String shDes;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新日期*/
	private java.util.Date updateDate;
	/**上架人*/
	private java.lang.String onShelfMan;
	/**上架时间*/
	private java.util.Date onShelfTime;
	
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
	 *@return: java.lang.String  收货单号
	 */
	@Column(name ="SH_CODE",nullable=true,length=32)
	public java.lang.String getShCode(){
		return this.shCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货单号
	 */
	public void setShCode(java.lang.String shCode){
		this.shCode = shCode;
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
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CS_NAME",nullable=true,length=50)
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
	 *@return: java.lang.String  仓库ID
	 */
	@Column(name ="WARE_ID",nullable=true,length=36)
	public java.lang.String getWareId(){
		return this.wareId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库ID
	 */
	public void setWareId(java.lang.String wareId){
		this.wareId = wareId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓库名称
	 */
	@Column(name ="WARE_NAME",nullable=true,length=32)
	public java.lang.String getWareName(){
		return this.wareName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓库名称
	 */
	public void setWareName(java.lang.String wareName){
		this.wareName = wareName;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  收货单状态
	 */
	@Column(name ="SH_STATUS",nullable=true,length=2)
	public java.lang.Integer getShStatus(){
		return this.shStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  收货单状态
	 */
	public void setShStatus(java.lang.Integer shStatus){
		this.shStatus = shStatus;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  收货数量
	 */
	@Column(name ="SH_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getShNum(){
		return this.shNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收货数量
	 */
	public void setShNum(java.lang.Double shNum){
		this.shNum = shNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  现收数量
	 */
	@Column(name ="CURRENT_SH_NUM",nullable=true,scale=2,length=32)
	public java.lang.Double getCurrentShNum(){
		return this.currentShNum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  现收数量
	 */
	public void setCurrentShNum(java.lang.Double currentShNum){
		this.currentShNum = currentShNum;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  体积
	 */
	@Column(name ="VOLUME",nullable=true,scale=2,length=32)
	public java.lang.Double getVolume(){
		return this.volume;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  体积
	 */
	public void setVolume(java.lang.Double volume){
		this.volume = volume;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  毛重
	 */
	@Column(name ="GROSS_WEIGHT",nullable=true,scale=2,length=32)
	public java.lang.Double getGrossWeight(){
		return this.grossWeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  毛重
	 */
	public void setGrossWeight(java.lang.Double grossWeight){
		this.grossWeight = grossWeight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  净重
	 */
	@Column(name ="NET_WEIGHT",nullable=true,scale=2,length=32)
	public java.lang.Double getNetWeight(){
		return this.netWeight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  净重
	 */
	public void setNetWeight(java.lang.Double netWeight){
		this.netWeight = netWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否良品
	 */
	@Column(name ="IS_GOOD",nullable=true,length=32)
	public java.lang.String getIsGood(){
		return this.isGood;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否良品
	 */
	public void setIsGood(java.lang.String isGood){
		this.isGood = isGood;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="SH_DES",nullable=true,length=300)
	public java.lang.String getShDes(){
		return this.shDes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setShDes(java.lang.String shDes){
		this.shDes = shDes;
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
	 *@return: java.lang.String  上架人
	 */
	@Column(name ="ON_SHELF_MAN",nullable=true,length=50)
	public java.lang.String getOnShelfMan(){
		return this.onShelfMan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上架人
	 */
	public void setOnShelfMan(java.lang.String onShelfMan){
		this.onShelfMan = onShelfMan;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上架时间
	 */
	@Column(name ="ON_SHELF_TIME",nullable=true,length=32)
	public java.util.Date getOnShelfTime(){
		return this.onShelfTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上架时间
	 */
	public void setOnShelfTime(java.util.Date onShelfTime){
		this.onShelfTime = onShelfTime;
	}
}
