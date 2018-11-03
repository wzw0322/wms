<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsPalletDayList" checkbox="false" pagination="false" fitColumns="true" title="托盘日表" actionUrl="wmsPalletDayController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="托盘材质"  field="palletMaterial"  query="true"  queryMode="single"  dictionary="palletMade"  width="120"></t:dgCol>
   <t:dgCol title="托盘类型"  field="palletType"  query="true"  queryMode="single"  dictionary="palletType"  width="120"></t:dgCol>
   <t:dgCol title="托盘型号"  field="palletModel"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用数量"  field="useNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="空闲数量"  field="freeNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="维修数量"  field="maintainNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="丢失数量"  field="lostNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合计"  field="countNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="时间"  field="countDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wmsPalletDayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsPalletDayController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="wmsPalletDayController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsPalletDayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsPalletDayController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/pallet/wmsPalletDayList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsPalletDayController.do?upload', "wmsPalletDayList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsPalletDayController.do?exportXls","wmsPalletDayList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsPalletDayController.do?exportXlsByT","wmsPalletDayList");
}

 </script>