//构建一个全局变量
var china_map;
//定义加载事件
$(function(){
	//创建地图容器
 	china_map =echarts.init(document.getElementById("china_map"),'infographic');
 	//运行加载中国地图
 	loadChinaMap();
	//地图鼠标点击事件
	china_map.on('click', function (params) {
		console.log(params)
	
		//获取省份名称
		var city = params.name
		//加载省级地图
		loadProvidName(city)
	 });
})

//加载中国地图
//加载中国地图
function loadChinaMap(){	
	$.ajax({
		url:"info.do",
		type:"get",//提交方式
		dataType:"json",//返回的数据类型
		data:{
			"method": "loadChinaMap"
		},
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			var option = {
					
					title: {
						text: '新冠型肺炎人口来源分析',
						textStyle:{color:'#fff'},
						//subtext: '纯属虚构',
						x:'center'
					},
					tooltip : {
						trigger: 'item'
					},
					visualMap: {
						show : false,
						x: 'left',
						y: 'bottom',
						//layoutCenter:['30%','30%'],
						splitList: [ 
							{start: 0, end:100},
							{start: 100, end: 300},
							{start: 300, end: 500},
							{start: 500, end: 800},
							{start: 800, end: 1500},
							{start: 1500, end: 100000}
						],
						color: ['red', 'yellow', 'Purple','DarkCyan', 'green', 'Lime']
					},
					series: [{
						name: '新冠型肺炎人口来源分析',
						type: 'map',
						mapType: 'china', 
						roam: true,
						label: {
							normal: {
								show: true
							},
							emphasis: {
								show: false
							}
						},
						data:data
					}]
				};

			china_map.setOption(option);
		}
	})
		
}

//加载省级地图
function loadProvidName(city){
	
	//
	china_map.showLoading();
 	//请求省级地图数据
	$.get("json/"+city+".json", function (geoJson) {
	console.log("==="+geoJson)
	//如果要请求服务端的数据
		$.ajax({
			url:"info.do",
			type:"get",//提交方式
			data:{
				"cityName":city,
				"method":"loadProvidName"
			},
			dataType:"json",//返回的数据类型
			success:function(data){
				//在浏览器控制台打印数据
				console.log("11111111111")
				console.log(data);
				china_map.hideLoading();
			    echarts.registerMap(city, geoJson);

				var option = {
						
						title: {
							text: city+'新冠型肺炎人口来源分析',
							textStyle:{color:'#fff'},
							//subtext: '纯属虚构',
							x:'center'
						},
						tooltip : {
							trigger: 'item'
						},
						visualMap: {
							show : false,
							x: 'left',
							y: 'bottom',
							//layoutCenter:['30%','30%'],
							splitList: [ 
								{start: 0, end:100},{start: 100, end: 300},
								{start: 300, end: 500},{start: 500, end: 800},
								{start: 800, end: 1500},{start: 1500, end: 100000},
							],
							color: ['red', 'yellow', 'Purple','DarkCyan', 'green', 'Lime']
						},
						series: [{
							name: city+'新冠型肺炎人口来源分析',
							type: 'map',
							mapType: city, 
							roam: true,
							label: {
								normal: {
									show: true
								},
								emphasis: {
									show: false
								}
							},
							data:data
						}]
					};

				china_map.setOption(option);
			}
		})
	
		
	});
}


