<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>货物信息表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="wmsGoodsController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="goodsCode" class="col-sm-3 control-label">货物编码：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="goodsCode" name="goodsCode" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入货物编码"  datatype="*" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="goodsName" class="col-sm-3 control-label">货物名称：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="goodsName" name="goodsName" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入货物名称"  datatype="*" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="goodsType" class="col-sm-3 control-label">货物类型：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="goodsType" type="list" extendJson="{class:'form-control input-sm'}"  datatype="*"  dictTable="wms_goods_type" dictField="id" dictCondition="where isdel=0 and goods_status=1" dictText="goods_name"  hasLabel="false"  title="货物类型"></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="goodsStatus" class="col-sm-3 control-label">货物状态：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="goodsStatus" type="list" extendJson="{class:'form-control input-sm'}"  datatype="*"  typeGroupCode="wh_simple"  hasLabel="false"  title="货物状态"></t:dictSelect>     
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="goodsKeep" class="col-sm-3 control-label">保质期：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="goodsKeep" name="goodsKeep" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入保质期"  datatype="*" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="goodsUnit" class="col-sm-3 control-label">单位：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="goodsUnit" type="list" extendJson="{class:'form-control input-sm'}"  datatype="*"  dictTable="wms_unit" dictField="id" dictText="unit_name"  dictCondition="where isdel=0 and unit_status=1" hasLabel="false"  title="单位"></t:dictSelect>
				</div>
			</div>
		</div>
					<div class="form-group">
						<label for="goodsDes" class="col-sm-3 control-label">备注：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="goodsDes" value = "${wmsGoods.goodsDes}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
			          </div>
						</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
		
});
</script>
</body>
</html>