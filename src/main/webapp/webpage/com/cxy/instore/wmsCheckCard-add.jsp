<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>质检单</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <t:base type="jquery,aceform,DatePicker,validform,ueditor"></t:base>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmsCheckCardController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">质检单</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>质检单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="qcCode" name="qcCode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检单号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>入库单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="instoreCode" name="instoreCode" type="text" class="form-control"  ignore="ignore"  onclick="popupClick(this,'in_code,w_id,cs_name,cs_code,g_name,g_type,g_code','instoreCode,wareId,csName,csCode,goodsName,goodsType,goodsCode','book_init_check')"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">入库单号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>客户名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csName" name="csName" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>客户编码：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csCode" name="csCode" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户编码</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>仓库名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="wareId" name="wareId" maxlength="36" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓库名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>质检类型：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="qcType" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" typeGroupCode="qc_type"  hasLabel="false"  title="质检类型"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检类型</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>货物名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsName" name="goodsName" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">货物名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>应检数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="needCheckNum" name="needCheckNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">应检数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>已检数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="checkedNum" name="checkedNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">已检数量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>抽检数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="randomNum" name="randomNum" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">抽检数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>单位：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="unit" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" dictTable="wms_unit" dictField="id" dictText="unit_name"  hasLabel="false"  title="单位"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">单位</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>合格数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="qualifiedNum" name="qualifiedNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">合格数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>不合格数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="unqualifiedNum" name="unqualifiedNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">不合格数量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>质检状态：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="qcStatus" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" typeGroupCode="qc_status"  hasLabel="false"  title="质检状态"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检状态</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>质检人：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="qcMan" name="qcMan" maxlength="50" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检人</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>质检时间：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="qcTime" name="qcTime" type="text"  datatype="*" ignore="checked" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;" class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检时间</label>
			          </div>
							</div>
			          
			        
			        
			       
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				          <div class="col-xs-6"></div>
				          <div class="col-xs-6"><button type="button" onclick="neibuClick();" class="btn btn-default">提交</button></div>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
			 </div>
  </t:formvalid>

<script type="text/javascript">
   $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
	
	if(location.href.indexOf("mode=read")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
	}
	if(location.href.indexOf("mode=onbutton")!=-1){
		//其他模式显示提交按钮
		$("#sub_tr").show();
	}
   });

  var neibuClickFlag = false;
  function neibuClick() {
	  neibuClickFlag = true; 
	  $('#btn_sub').trigger('click');
  }

</script>
 </body>
<script src = "webpage/com/cxy/instore/wmsCheckCard.js"></script>		
</html>