<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>托盘信息表</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <t:base type="jquery,aceform,DatePicker,validform,ueditor"></t:base>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmsPalletController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">托盘信息表</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>托盘编码：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletCode" name="palletCode" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">托盘编码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>托盘材质：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="palletMaterial" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" typeGroupCode="palletMade"  hasLabel="false"  title="托盘材质"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">托盘材质</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>托盘类型：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="palletType" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" typeGroupCode="palletType"  hasLabel="false"  title="托盘类型"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">托盘类型</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>托盘型号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletModel" name="palletModel" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">托盘型号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>生产厂商：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletProducer" name="palletProducer" maxlength="100" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">生产厂商</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>长（毫米）：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletLength" name="palletLength" maxlength="11" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">长（毫米）</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>宽（毫米）：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletWidth" name="palletWidth" maxlength="11" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">宽（毫米）</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>高（毫米）：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletHeight" name="palletHeight" maxlength="11" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">高（毫米）</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>价格：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletPrice" name="palletPrice" maxlength="11" type="text" class="form-control"  datatype="d" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">价格</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>静载（T）：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletStaticLoad" name="palletStaticLoad" maxlength="11" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">静载（T）</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>动载（T）：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="palletLiveLoad" name="palletLiveLoad" maxlength="11" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">动载（T）</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>状态：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="palletStatus" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" typeGroupCode="palletStat"  hasLabel="false"  title="状态"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">状态</label>
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
<script src = "webpage/com/cxy/pallet/wmsPallet.js"></script>		
</html>