<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>仓位信息表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="wmsWarePositionController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${wmsWarePosition.id}"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					仓库名称：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="whId" readonly="readonly" defaultVal = "${wmsWarePosition.whId}" type="select" hasLabel="false" title="仓库名称" extendJson="{class:'form-control'}"  datatype="*"  dictTable="wms_ware_house" dictField="id" dictText="house_name" dictCondition="where isdel=0 and (house_status=0 or house_status=1)"></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					仓位编码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="positionCode" readonly="readonly" type="text" class="form-control" maxlength="32" value = "${wmsWarePosition.positionCode}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					仓位名称：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="positionName" readonly="readonly" type="text" class="form-control" maxlength="32" value = "${wmsWarePosition.positionName}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					长（厘米）：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="positionLength" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.positionLength}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					宽（厘米）：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="positionWidth" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.positionWidth}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					高（厘米）：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="positionHeight" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.positionHeight}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					体积限制：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="sizeLimit" type="text" class="form-control" maxlength="32" value = "${wmsWarePosition.sizeLimit}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					数量限制：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="numLimit" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.numLimit}"  datatype="n" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					重量限制：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="weightLimit" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.weightLimit}"  datatype="*" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					箱数限制：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="boxLimit" type="text" class="form-control" maxlength="11" value = "${wmsWarePosition.boxLimit}"  datatype="n" ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					仓位状态：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="positionStatus" defaultVal = "${wmsWarePosition.positionStatus}" type="select" hasLabel="false" title="仓位状态" extendJson="{class:'form-control'}"  datatype="*"  typeGroupCode="ps_status" ></t:dictSelect>
				</div>
			</div>
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