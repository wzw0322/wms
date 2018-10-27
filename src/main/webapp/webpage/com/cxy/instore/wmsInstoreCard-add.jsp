<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>入库单</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <t:base type="jquery,aceform,DatePicker,validform,ueditor"></t:base>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wmsInstoreCardController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">入库单</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>入库单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="instoreCode" name="instoreCode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">入库单号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>入库订单号：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="orderCode" name="orderCode" type="text" class="form-control"  ignore="ignore"  onclick="popupClick(this,'order_code,customer_name,goods_name,quantity,weight,src_address,dest_address,trans_mode','orderCode,customerName,goodsName,quantity,weight,srcAddress,destAddress,transMode','book_init_instore')"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">入库订单号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>仓库名称：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="wareId" type="list" extendJson="{class:'form-control',style:'width:158px'}" dictTable="wms_ware_house" dictCondition="where isdel=0" dictField="id" dictText="house_name"  hasLabel="false"  title="仓库名称"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓库名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>入库类型：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="instoreType" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="n"  typeGroupCode="inSType"  hasLabel="false"  title="入库类型"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">入库类型</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>客户名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="customerName" name="customerName" maxlength="50" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>货品名称：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="goodsName" name="goodsName" maxlength="32" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">货品名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>运输方式：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="transMode" name="transMode" maxlength="32" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">运输方式</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>发运地：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="srcAddress" name="srcAddress" maxlength="160" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发运地</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>到达地：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="destAddress" name="destAddress" maxlength="160" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">到达地</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>数量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="quantity" name="quantity" maxlength="11" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>重量：</b>
			          </div>
			          		<div class="col-xs-3">
								<input id="weight" name="weight" maxlength="11" type="text" class="form-control"  datatype="*" ignore="checked" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">重量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>单位：</b>
			          </div>
			          		<div class="col-xs-3">
							  <t:dictSelect field="uint" type="list" extendJson="{class:'form-control',style:'width:158px'}" datatype="*" dictTable="wms_unit" dictCondition="where isdel=0" dictField="id" dictText="unit_name"  hasLabel="false"  title="单位"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">单位</label>
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
<script src = "webpage/com/cxy/instore/wmsInstoreCard.js"></script>		
</html>