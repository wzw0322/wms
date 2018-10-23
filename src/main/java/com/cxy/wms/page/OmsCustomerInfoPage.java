package com.cxy.wms.page;

import com.cxy.wms.entity.OmsCustomerInfoEntity;
import com.cxy.wms.entity.OmsCustomerReceiverAddressEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;

/**   
 * @Title: Entity
 * @Description: oms_customer_info
 * @author onlineGenerator
 * @date 2018-10-21 18:02:23
 * @version V1.0   
 *
 */
public class OmsCustomerInfoPage implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**客户编码*/
    @Excel(name="客户编码")
	private java.lang.String customerCode;
	/**客户名称*/
    @Excel(name="客户名称")
	private java.lang.String customerName;
	/**客户地址*/
    @Excel(name="客户地址")
	private java.lang.String customerAddress;
	/**状态*/
    @Excel(name="状态")
	private java.lang.String usingStatus;
	/**联系人姓名*/
    @Excel(name="联系人姓名")
	private java.lang.String contactName;
	/**联系人电话*/
    @Excel(name="联系人电话")
	private java.lang.String contactTel;
	/**Email*/
    @Excel(name="Email")
	private java.lang.String email;
	/**职务*/
    @Excel(name="职务")
	private java.lang.String position;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	/**是否逻辑删除 1是 0否*/
    @Excel(name="是否逻辑删除 1是 0否")
	private java.lang.String isLoggicDel;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
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
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */
	public java.lang.String getCustomerCode(){
		return this.customerCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setCustomerCode(java.lang.String customerCode){
		this.customerCode = customerCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	public java.lang.String getCustomerName(){
		return this.customerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCustomerName(java.lang.String customerName){
		this.customerName = customerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户地址
	 */
	public java.lang.String getCustomerAddress(){
		return this.customerAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户地址
	 */
	public void setCustomerAddress(java.lang.String customerAddress){
		this.customerAddress = customerAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	public java.lang.String getUsingStatus(){
		return this.usingStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setUsingStatus(java.lang.String usingStatus){
		this.usingStatus = usingStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人姓名
	 */
	public java.lang.String getContactName(){
		return this.contactName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人姓名
	 */
	public void setContactName(java.lang.String contactName){
		this.contactName = contactName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人电话
	 */
	public java.lang.String getContactTel(){
		return this.contactTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人电话
	 */
	public void setContactTel(java.lang.String contactTel){
		this.contactTel = contactTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Email
	 */
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  Email
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务
	 */
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否逻辑删除 1是 0否
	 */
	public java.lang.String getIsLoggicDel(){
		return this.isLoggicDel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否逻辑删除 1是 0否
	 */
	public void setIsLoggicDel(java.lang.String isLoggicDel){
		this.isLoggicDel = isLoggicDel;
	}
	
	/**保存-客户信息附表-地址信息*/
    @ExcelCollection(name="客户信息附表-地址信息")
	private List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressList = new ArrayList<OmsCustomerReceiverAddressEntity>();
	public List<OmsCustomerReceiverAddressEntity> getOmsCustomerReceiverAddressList() {
		return omsCustomerReceiverAddressList;
	}
	public void setOmsCustomerReceiverAddressList(List<OmsCustomerReceiverAddressEntity> omsCustomerReceiverAddressList) {
		this.omsCustomerReceiverAddressList = omsCustomerReceiverAddressList;
	}
	
}
