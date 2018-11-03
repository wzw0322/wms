<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsStockList" checkbox="false" pagination="true" fitColumns="true" title="库存表" actionUrl="wmsStockController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="csCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="csName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货品编码"  field="goodsCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货品名称"  field="goodsName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="获评类型"  field="goodsType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库"  field="wareId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓位"  field="positionId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="stockQuantity"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="重量"  field="stockWeight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体积"  field="stockVolume"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在途数量"  field="transQuantity"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在途重量"  field="transWeight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在途体积"  field="transVolume"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wmsStockController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsStockController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="wmsStockController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsStockController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsStockController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/stock/wmsStockList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsStockController.do?upload', "wmsStockList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsStockController.do?exportXls","wmsStockList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsStockController.do?exportXlsByT","wmsStockList");
}

 </script>