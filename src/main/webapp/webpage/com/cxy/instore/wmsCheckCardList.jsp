<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsCheckCardList" checkbox="false" pagination="true" fitColumns="true" title="质检单" actionUrl="wmsCheckCardController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="wmsCheckCardController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <t:dgFunOpt funname="doSearchCheck(id)" title="查看" urlclass="ace_button" urlfont="fa-search"/>
   <t:dgFunOpt funname="doUpdateCheck(id)" title="修改" urlclass="ace_button" urlfont="fa-edit"/>
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="质检单号"  field="qcCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入库单号"  field="instoreCode"  hidden="true"  queryMode="single"  dictionary="book_init_check,instoreCode@wareId@csName@csCode@goodsName@goodsType@goodsCode,in_code@w_id@cs_name@cs_code@g_name@g_type@g_code"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="csName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="csCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称"  field="wareName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="质检类型"  field="qcType"  query="true"  queryMode="single"  dictionary="qc_type"  width="120"></t:dgCol>
   <t:dgCol title="货物名称"  field="goodsName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物编码"  field="goodsCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物类型"  field="goodsType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应检数量"  field="needCheckNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="已检数量"  field="checkedNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="抽检数量"  field="randomNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  hidden="true"  queryMode="single"  dictionary="wms_unit,id,unit_name" dictCondition="where isdel=0"  width="120"></t:dgCol>
   <t:dgCol title="合格数量"  field="qualifiedNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="不合格数量"  field="unqualifiedNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="质检状态"  field="qcStatus"  query="true"  queryMode="single"  dictionary="qc_status"  width="120"></t:dgCol>
   <t:dgCol title="质检人"  field="qcMan"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="质检时间"  field="qcTime"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsCheckCardController.do?goAdd" funname="add"></t:dgToolBar>
	<%--<t:dgToolBar title="编辑" icon="icon-edit" url="wmsCheckCardController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsCheckCardController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsCheckCardController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/instore/wmsCheckCardList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

 //自定义按钮-修改
 function doUpdateCheck(id,index){
     var row = $('#wmsCheckCardList').datagrid('getData').rows[index];
     if(row.qcStatus != 0){
         tip("当前状态不支持修改");
     }else{
         var url = "wmsCheckCardController.do?goUpdate&id="+id;
         createwindow("质检单修改",url,700,400);
     }
 }
 //自定义按钮-查看
 function doSearchCheck(id,index){
     var url = "wmsCheckCardController.do?goUpdate&load=detail&id="+id;
     createdetailwindow("查看",url,700,400);
 }
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsCheckCardController.do?upload', "wmsCheckCardList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsCheckCardController.do?exportXls","wmsCheckCardList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsCheckCardController.do?exportXlsByT","wmsCheckCardList");
}

 </script>