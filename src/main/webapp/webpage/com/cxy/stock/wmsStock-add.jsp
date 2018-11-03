<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>库存表</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <t:base type="jquery,aceform,DatePicker,validform,ueditor"></t:base>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmsStockController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">库存表</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>客户编码：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csCode" name="csCode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户编码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>客户名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="csName" name="csName" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>货品编码：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsCode" name="goodsCode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">货品编码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>货品名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsName" name="goodsName" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">货品名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>获评类型：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsType" name="goodsType" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">获评类型</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>仓库：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="wareId" name="wareId" maxlength="36" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓库</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>仓位：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="positionId" name="positionId" maxlength="36" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓位</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>单位：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="unit" name="unit" maxlength="36" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">单位</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="stockQuantity" name="stockQuantity" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">数量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>重量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="stockWeight" name="stockWeight" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">重量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>体积：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="stockVolume" name="stockVolume" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">体积</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>在途数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="transQuantity" name="transQuantity" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">在途数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>在途重量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="transWeight" name="transWeight" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">在途重量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>在途体积：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="transVolume" name="transVolume" maxlength="32" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">在途体积</label>
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
<script src = "webpage/com/cxy/stock/wmsStock.js"></script>		
</html>