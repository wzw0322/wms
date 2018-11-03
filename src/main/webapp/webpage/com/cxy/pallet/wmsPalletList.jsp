<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsPalletList" checkbox="false" pagination="true" fitColumns="true" title="托盘信息表" actionUrl="wmsPalletController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="doSearchPallet(id)" title="查看" urlclass="ace_button" urlfont="fa-search" />
   <t:dgFunOpt funname="doUpdatePallet(id)" title="修改" urlclass="ace_button" urlfont="fa-edit" />
   <t:dgDelOpt title="删除" url="wmsPalletController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="托盘编码"  field="palletCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="托盘材质"  field="palletMaterial"  query="true"  queryMode="single"  dictionary="palletMade"  width="120"></t:dgCol>
   <t:dgCol title="托盘类型"  field="palletType"  query="true"  queryMode="single"  dictionary="palletType"  width="120"></t:dgCol>
   <t:dgCol title="托盘型号"  field="palletModel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生产厂商"  field="palletProducer"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长（毫米）"  field="palletLength"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宽（毫米）"  field="palletWidth"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="高（毫米）"  field="palletHeight"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="palletPrice"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="静载（T）"  field="palletStaticLoad"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="动载（T）"  field="palletLiveLoad"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="palletStatus"  query="true"  queryMode="single"  dictionary="palletStat"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否删除 0-否 1-是"  field="isdel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsPalletController.do?goAdd" funname="add"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="wmsPalletController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsPalletController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsPalletController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/pallet/wmsPalletList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
		//自定义按钮-修改ss
	 	function doUpdatePallet(id,index){
            var row = $('#wmsPalletList').datagrid('getData').rows[index];
            if(row.palletStatus != 0){
                tip("当前状态不支持修改");
            }else{
                var url = "wmsPalletController.do?goUpdate&id="+id;
                createwindow("托盘信息表修改",url,700,400);
            }
	 	}
		//自定义按钮-查看s
	 	function doSearchPallet(id,index){
            var url = "wmsPalletController.do?goUpdate&load=detail&id="+id;
            createdetailwindow("查看",url,700,400);
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsPalletController.do?upload', "wmsPalletList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsPalletController.do?exportXls","wmsPalletList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsPalletController.do?exportXlsByT","wmsPalletList");
}

 </script>