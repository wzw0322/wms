<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>收货单</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <t:base type="jquery,aceform,DatePicker,validform,ueditor"></t:base>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmsReceiveCardController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">收货单</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收货单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="shCode" placeholder="自动生成" readonly="readonly" name="shCode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收货单号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>质检单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="qcCode" placeholder="点击选择质检单号" name="qcCode" type="text" class="form-control"  ignore="ignore"  onclick="popupClick(this,'qc_code,cs_name,cs_code,ware_name,unit,goods_name','qcCode,csName,csCode,wareName,unit,goodsName','book_init_receive')"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">质检单号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>客户名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csName" readonly="readonly" name="csName" maxlength="50" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>客户编码：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csCode" name="csCode" readonly="readonly" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户编码</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>仓库名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="wareName" name="wareName" readonly="readonly"  maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓库名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>单位：</b>
			          </div>
			          		<div class="col-xs-3">
								<%--<input id="unit" name="unit" maxlength="36" type="text" class="form-control"  datatype="*" ignore="checked" />--%>
									<t:dictSelect field="unit" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" dictTable="wms_unit" dictField="id" dictText="unit_name"  hasLabel="false"  title="单位"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">单位</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>货物名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsName" name="goodsName" readonly="readonly" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">货物名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收货数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="shNum" name="shNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收货数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>现收数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="currentShNum" name="currentShNum" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">现收数量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>体积：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="volume" name="volume" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">体积</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>毛重：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="grossWeight" name="grossWeight" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">毛重</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>净重：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="netWeight" name="netWeight" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">净重</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>是否良品：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="isGood" name="isGood" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">是否良品</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>备注：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="shDes" name="shDes" maxlength="300" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
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
<script src = "webpage/com/cxy/instore/wmsReceiveCard.js"></script>		
</html>