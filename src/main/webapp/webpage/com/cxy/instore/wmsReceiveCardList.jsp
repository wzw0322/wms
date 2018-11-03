<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsReceiveCardList" checkbox="false" pagination="true" fitColumns="true" title="收货单" actionUrl="wmsReceiveCardController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="290"></t:dgCol>
   <t:dgFunOpt funname="doSearchReceive(id)" title="查看" urlclass="ace_button" urlfont="fa-search" />
   <t:dgFunOpt funname="doUpdateReceive(id)" title="修改" urlclass="ace_button" urlfont="fa-edit" />
   <t:dgFunOpt funname="doSureReceive(id)" title="确认" urlclass="ace_button" urlfont="fa-edit" />
   <t:dgFunOpt funname="doOnShelfReceive(id)" title="上架" exp="shStatus#eq#2" urlclass="ace_button" urlfont="fa-edit" />
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收货单号"  field="shCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="质检单号"  field="qcCode"  queryMode="single"  dictionary="book_init_receive,qcCode@csName@csCode@wareName@unit@goodsName,qc_code@cs_name@cs_code@ware_name@unit@goods_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="客户名称"  field="csName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编码"  field="csCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库ID"  field="wareId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称"  field="wareName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓位"  field="positionId"  hidden="true"  queryMode="single"  dictionary="wms_ware_position,id,position_name"  dictCondition="where isdel=0" width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  hidden="true"  queryMode="single"  dictionary="wms_unit,id,unit_name" dictCondition="where isdel=0" width="120"></t:dgCol>
   <t:dgCol title="货物名称"  field="goodsName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物编码"  field="goodsCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物类型"  field="goodsType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收货单状态"  field="shStatus"  query="true"  queryMode="single"  dictionary="sh_status"  width="120"></t:dgCol>
   <t:dgCol title="收货数量"  field="shNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现收数量"  field="currentShNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体积"  field="volume"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毛重"  field="grossWeight"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="净重"  field="netWeight"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否良品"  field="isGood"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="shDes"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="上架人"  field="onShelfMan"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="上架时间"  field="onShelfTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsReceiveCardController.do?goAdd" funname="add"></t:dgToolBar>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="wmsReceiveCardController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsReceiveCardController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsReceiveCardController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/cxy/instore/wmsReceiveCardList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
		//自定义按钮-查看
	 	function doSearchReceive(id,index){
            var url = "wmsReceiveCardController.do?goUpdate&load=detail&id="+id;
            createdetailwindow("查看",url,700,400);
	 	}
		//自定义按钮-修改
	 	function doUpdateReceive(id,index){
            var row = $('#wmsReceiveCardList').datagrid('getData').rows[index];
            if(row.shStatus != 1){
                tip("请选择一条数据进行编辑");
            }else{
                var url = "wmsReceiveCardController.do?goUpdate&id="+id;
                createwindow("货物信息表修改",url,700,400);
            }
	 	}

	 	//自定义按钮-上架
        function doOnShelfReceive(id,index){
            var row = $('#wmsReceiveCardList').datagrid('getData').rows[index];
           if(row.shStatus != 2){
               tip("请选择一条数据进行编辑");
           }else{
               var url = "wmsReceiveCardController.do?goOnShelf&id="+id;
               createwindow("货物信息表修改",url,700,400);
           }
        }



//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsReceiveCardController.do?upload', "wmsReceiveCardList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsReceiveCardController.do?exportXls","wmsReceiveCardList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsReceiveCardController.do?exportXlsByT","wmsReceiveCardList");
}

 </script>