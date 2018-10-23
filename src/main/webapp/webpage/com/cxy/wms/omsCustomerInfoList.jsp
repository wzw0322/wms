<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="omsCustomerInfoList" checkbox="false" pagination="true" fitColumns="true" title="客户信息" sortName="createDate" actionUrl="omsCustomerInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="doSearchCustomer(id)" title="查看" urlclass="ace_button" urlfont="fa-wrench"/>
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="customerCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户地址"  field="customerAddress"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="usingStatus"  query="true"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="联系人姓名"  field="contactName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系人电话"  field="contactTel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="Email"  field="email"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="职务"  field="position"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否逻辑删除 1是 0否"  field="isLoggicDel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="omsCustomerInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="omsCustomerInfoController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="omsCustomerInfoController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="omsCustomerInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="omsCustomerInfoController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
		//自定义按钮-查看
	 	function doSearchCustomer(id,index){
            var url = "omsCustomerInfoController.do?goUpdate&load=detail&id="+id;
            createdetailwindow("查看",url,700,400);
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'omsCustomerInfoController.do?upload', "omsCustomerInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("omsCustomerInfoController.do?exportXls","omsCustomerInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("omsCustomerInfoController.do?exportXlsByT","omsCustomerInfoList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "img/server/"+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "img/server/"+value+"?down=true";
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}

</script>
