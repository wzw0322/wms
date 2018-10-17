<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wmsWarePositionList" checkbox="false" pagination="true" fitColumns="true" title="仓位信息表" actionUrl="wmsWarePositionController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgFunOpt funname="doSearchPosition(id)" title="查看" urlclass="ace_button" urlfont="fa-search"/>
   <t:dgFunOpt funname="doUpdatePosition(id)" title="修改" urlclass="ace_button" urlfont="fa-edit"/>
   <t:dgDelOpt title="删除" url="wmsWarePositionController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓库名称"  field="whId"  query="true"  queryMode="single"  dictionary="wms_ware_house,id,house_name" dictCondition="where isdel=0" width="120"></t:dgCol>
   <t:dgCol title="仓位编码"  field="positionCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓位名称"  field="positionName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长（厘米）"  field="positionLength"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="宽（厘米）"  field="positionWidth"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="高（厘米）"  field="positionHeight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体积限制"  field="sizeLimit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量限制"  field="numLimit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="重量限制"  field="weightLimit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱数限制"  field="boxLimit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓位状态"  field="positionStatus"  query="true"  queryMode="single"  dictionary="ps_status"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否删除 0-否 1-是"  field="isdel"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="wmsWarePositionController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
  <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="wmsWarePositionController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wmsWarePositionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wmsWarePositionController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
		//自定义按钮-修改
	 	function doUpdatePosition(id,index){
	 		var row = $('#wmsWarePositionList').datagrid('getData').rows[index];
            if(row.positionStatus != 0){
                alert("当前状态不支持修改");
            }else{
                var url = "wmsWarePositionController.do?goUpdate&id="+id;
                createwindow("仓位信息表修改",url,700,400);
            }
	 	}
		//自定义按钮-查看
	 	function doSearchPosition(id,index){
            var url = "wmsWarePositionController.do?goUpdate&load=detail&id="+id;
            createdetailwindow("查看",url,700,400);
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wmsWarePositionController.do?upload', "wmsWarePositionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wmsWarePositionController.do?exportXls","wmsWarePositionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wmsWarePositionController.do?exportXlsByT","wmsWarePositionList");
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
