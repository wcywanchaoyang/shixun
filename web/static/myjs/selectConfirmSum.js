//文档加载事件
$(function(){
	$.ajax({
		url:"info",
		type:"get",//提交方式
		dataType:"json",//返回的数据类型
		data:{
			"method":"Confirm"
		},
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			//显示查询数据到id="allcount"的标签的文本
			$("#allcount").text(data);
		}
	})
})