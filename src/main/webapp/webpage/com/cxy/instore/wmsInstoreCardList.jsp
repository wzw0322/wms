<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsInstoreCardList" checkbox="false" pagination="true" fitColumns="true" title="入库单" actionUrl="wmsInstoreCardController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wmsInstoreCardController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt funname="doSearchInstore(id)" title="查看" urlclass="ace_button" urlfont="fa-search"/>
   <t:dgFunOpt funname="doUpdateInstore(id)" title="修改" urlclass="ace_button" urlfont="fa-edit"/>
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入库单号"  field="instoreCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库订单号"  field="orderCode"  hidden="true"  queryMode="single"  dictionary="book_init_instore,orderCode@customerName@goodsName@quantity@weight@srcAddress@destAddress@transMode,order_code@customer_name@goods_name@quantity@weight@src_address@dest_address@trans_mode"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称"  field="wareId"  queryMode="single"  dictionary="wms_ware_house,id,house_name" dictCondition="where isdel=0" width="120"></t:dgCol>
   <t:dgCol title="仓位"  field="positionId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库类型"  field="instoreType"  hidden="true"  query="true"  queryMode="single"  dictionary="inSType"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="customerName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="customerCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货品编码"  field="goodsCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货品名称"  field="goodsName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物类型"  field="goodsType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运输方式"  field="transMode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库单状态"  field="instoreStatus"  query="true"  queryMode="single"  dictionary="inSStatus"  width="120"></t:dgCol>
   <t:dgCol title="发运地"  field="srcAddress"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="到达地"  field="destAddress"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="quantity"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="重量"  field="weight"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="uint"  hidden="true"  queryMode="single"  dictionary="wms_unit,id,unit_name"  dictCondition="where isdel=0" width="120"></t:dgCol>
   <t:dgCol title="体积"  field="volume"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否删除 0-否 1-是"  field="isdel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsInstoreCardController.do?goAdd" funname="add"></t:dgToolBar>
	<%--<t:dgToolBar title="编辑" icon="icon-edit" url="wmsInstoreCardController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsInstoreCardController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsInstoreCardController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/instore/wmsInstoreCardList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

 //自定义按钮-修改
 function doUpdateInstore(id,index){
     var row = $('#wmsInstoreCardList').datagrid('getData').rows[index];
     if(row.instoreStatus != 1){
         tip("当前状态不支持修改");
     }else{
         var url = "wmsInstoreCardController.do?goUpdate&id="+id;
         createwindow("货物信息表修改",url,700,400);
     }
 }
 //自定义按钮-查看
 function doSearchInstore(id,index){
     var url = "wmsInstoreCardController.do?goUpdate&load=detail&id="+id;
     createdetailwindow("查看",url,700,400);
 }
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsInstoreCardController.do?upload', "wmsInstoreCardList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsInstoreCardController.do?exportXls","wmsInstoreCardList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsInstoreCardController.do?exportXlsByT","wmsInstoreCardList");
}

 </script>