//自定义按钮-确认
function doSureReceive(id,index){
    var row = $('#wmsReceiveCardList').datagrid('getData').rows[index];
    if(row.shStatus != 1){
        tip("当前状态不支持确认")
    }else{
        $.dialog({
            title: "收货单确认",
            max: false,
            min: false,
            drag: false,
            resize: false,
            content: '确定进行确认操作吗？',
            lock:true,
            button : [ {
                name : "确定",
                focus : true,
                callback : function() {
                    this.close();
                    var param = {"id":id};
                    $.get("wmsReceiveCardController.do?doSure",param,function(data){
                        var jsonData=JSON.parse(data);
                        console.log("返回的data是："+jsonData);
                        if(jsonData.result == 1){
                            tip("确认成功");
                        }else if (jsonData.result == 2){
                            tip("已经确认");
                        }else{
                            tip("确认失败");
                        }
                    });
                    return true;
                }
            }],
        });
    }
}
