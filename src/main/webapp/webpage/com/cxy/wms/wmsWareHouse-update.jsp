<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>仓库信息表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="wmsWareHouseController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${wmsWareHouse.id}"/>
	<div class="form-group">
		<label for="areaId" class="col-sm-3 control-label">区域名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
               <t:dictSelect field="areaId" type="list" readonly="readonly" extendJson="{class:'form-control input-sm'}"  datatype="*"  dictTable="wms_area" dictField="id" dictText="area_name"  hasLabel="false"  title="区域名称" defaultVal="${wmsWareHouse.areaId}"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseCode" class="col-sm-3 control-label">仓库编码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseCode" readonly="readonly" name="houseCode" value='${wmsWareHouse.houseCode}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入仓库编码"  validType="wms_ware_house,house_code,id" datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseName" class="col-sm-3 control-label">仓库名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseName" name="houseName" value='${wmsWareHouse.houseName}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入仓库名称"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseLength" class="col-sm-3 control-label">长（米）：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseLength" name="houseLength" readonly="readonly" value='${wmsWareHouse.houseLength}' type="text" maxlength="11" class="form-control input-sm" placeholder="请输入长（米）"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseWidth" class="col-sm-3 control-label">宽（米）：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseWidth" name="houseWidth" readonly="readonly" value='${wmsWareHouse.houseWidth}' type="text" maxlength="11" class="form-control input-sm" placeholder="请输入宽（米）"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseSquare" class="col-sm-3 control-label">仓库面积：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseSquare" name="houseSquare" readonly="readonly" value='${wmsWareHouse.houseSquare}' type="text" maxlength="11" class="form-control input-sm" placeholder="请输入仓库面积"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseStatus" class="col-sm-3 control-label">仓库状态：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
               <t:dictSelect field="houseStatus" type="list" extendJson="{class:'form-control input-sm'}"  datatype="*"  typeGroupCode="wh_status"  hasLabel="false"  title="仓库状态" defaultVal="${wmsWareHouse.houseStatus}"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseLeader" class="col-sm-3 control-label">仓库负责人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseLeader" name="houseLeader" readonly="readonly" value='${wmsWareHouse.houseLeader}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入仓库负责人"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="houseTel" class="col-sm-3 control-label">联系电话：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="houseTel" name="houseTel" readonly="readonly" value='${wmsWareHouse.houseTel}' type="text" maxlength="11" class="form-control input-sm" placeholder="请输入联系电话"  datatype="m" ignore="checked" />
			</div>
		</div>
	</div>
					<div class="form-group">
					<label for="houseDes" class="col-sm-3 control-label">仓库描述：</label>
					<div class="col-sm-7">
					<div class="input-group" style="width:100%">
						  	 	<textarea name="houseDes" class="form-control input-sm" rows="6"  datatype="*" ignore="checked" >${wmsWareHouse.houseDes}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">仓库描述</label>
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