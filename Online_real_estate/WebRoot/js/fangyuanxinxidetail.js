var swiper = new Swiper('.swiper-container', {
				loop: true, //是否循环，false不循环
				effect : 'cube',//切换效果，不要可删除
				pagination: {
					el: '.swiper-pagination',
					type: 'fraction',
				},
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				},
			});


$('#guanzhu1').click(function(){
	if($(this).text()=='关注'){
		guanzhu();
	}else{
		quxiaoguanzhu();
	}
})
function guanzhu(){
	var ufid2=$('#ufid1').val();
	var bianhao2=$('#bianhao1').val();
	if(ufid2!=""){
	$.ajax({
		 url:'fyattention.do',
	     type:'post',
	     data:{
	    	 ufid:''+ufid2+'',
	    	 bianhao:''+bianhao2+''
	    	 },
	     success:function(data,textStatus){
	    	 if(data=="success"){
	    		 $('#guanzhu1').text('取消关注');
	    		 layer.msg('关注成功'); 
	    	 }
	     },
	     error:function(){
			   alert("关注失败");
		   }
	   });
	}
}

function quxiaoguanzhu(){
	var ufid2=$('#ufid1').val();
	var bianhao2=$('#bianhao1').val();
	if(ufid2!=""){
	$.ajax({
		 url:'fycancel.do',
	     type:'post',
	     data:{
	    	 ufid:''+ufid2+'',
	    	 bianhao:''+bianhao2+''
	    	 },
	     success:function(data,textStatus){
	    	 if(data=="success"){
	    		 $('#guanzhu1').text('关注');
	    		 layer.msg('取消关注成功');
	    	 }
	     },
	     error:function(){
			   alert("取消关注失败");
		   }
	  });
	}
}

var index;

function liuyan(){
	var ufid2=$('#ufid1').val();
	var bianhao2=$('#bianhao1').val();
	var jjrgonghao2=$('#jjrgonghao').val();
	$.ajax({
		 url:'yonghuliuyan.do',
	     type:'post',
	     data:{
	    	 ufid:''+ufid2+'',
	    	 bianhao:''+bianhao2+'',
	    	 jjrgonghao:''+jjrgonghao2+'',
	    	 liuyan:''+$('#oehg').val()+''
	    	 },
	     success:function(data,textStatus){
	    	 if(data=="success"){
	    		 layer.msg("留言成功");
	    	 }
	     },
	     error:function(){
			   alert("留言失败");
		   }
	  });
	layer.close(index);
}


$('#leavemessage1').click(function(){
	index =	layer.open({
		  type: 1,
		  title: '写下您想咨询的内容',
		  skin: 'layui-layer-rim', //加上边框
		  area: ['600px', '300px'],
		  content: '<br/><div style="text-align: center;"><textarea id="oehg" style="width: 450px;height: 150px;resize:none;" ></textarea></div><br/>'+
		  '<div style="text-align: center;"><a onclick="liuyan()" href="javascript:void(0);" class="btn btn-primary">提交</a></div>'
		});
})






var map = new AMap.Map("container", {
    resizeEnable: true,
});

function MyMap1(){
	var geocoder;
	if(!geocoder){
	        geocoder = new AMap.Geocoder({
	            city: "0755", //城市设为北京，默认：“全国”
	        });
	    }
	    var address  = document.getElementById('address').value;
	    geocoder.getLocation(address, function(status, result) {
	        if (status === 'complete'&&result.geocodes.length) {
	            var lnglat = result.geocodes[0].location;
	            AMap.service(["AMap.PlaceSearch"], function() {
	    //构造地点查询类
	    var placeSearch = new AMap.PlaceSearch({ 
	        type: '050000', // 兴趣点类别
	        pageSize: 5, // 单页显示结果条数
	        pageIndex: 1, // 页码
	        city: "0755", // 兴趣点城市
	        citylimit: true,  //是否强制限制在设置的城市内搜索
	        map: map, // 展现结果的地图实例
	        panel: "panel", // 结果列表将在此容器中进行展示。
	        autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
	    });
	    
	    var cpoint = [lnglat]; //中心点坐标
	    placeSearch.searchNearBy('', cpoint, 200, function(status, result) {

	    });
	});
	        }else{alert(JSON.stringify(result))}
	    });
}

function MyMap2(){
	var geocoder;
	if(!geocoder){
	        geocoder = new AMap.Geocoder({
	            city: "0755", //城市设为北京，默认：“全国”
	        });
	    }
	    var address  = document.getElementById('address').value;
	    geocoder.getLocation(address, function(status, result) {
	        if (status === 'complete'&&result.geocodes.length) {
	            var lnglat = result.geocodes[0].location;
	            AMap.service(["AMap.PlaceSearch"], function() {
	    //构造地点查询类
	    var placeSearch = new AMap.PlaceSearch({ 
	        type: '150000', // 兴趣点类别
	        pageSize: 5, // 单页显示结果条数
	        pageIndex: 1, // 页码
	        city: "0755", // 兴趣点城市
	        citylimit: true,  //是否强制限制在设置的城市内搜索
	        map: map, // 展现结果的地图实例
	        panel: "panel", // 结果列表将在此容器中进行展示。
	        autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
	    });
	    
	    var cpoint = [lnglat]; //中心点坐标
	    placeSearch.searchNearBy('', cpoint, 200, function(status, result) {

	    });
	});
	        }else{alert(JSON.stringify(result))}
	    });
}

function MyMap3(){
	var geocoder;
	if(!geocoder){
	        geocoder = new AMap.Geocoder({
	            city: "0755", //城市设为北京，默认：“全国”
	        });
	    }
	    var address  = document.getElementById('address').value;
	    geocoder.getLocation(address, function(status, result) {
	        if (status === 'complete'&&result.geocodes.length) {
	            var lnglat = result.geocodes[0].location;
	            AMap.service(["AMap.PlaceSearch"], function() {
	    //构造地点查询类
	    var placeSearch = new AMap.PlaceSearch({ 
	        type: '150700', // 兴趣点类别
	        pageSize: 5, // 单页显示结果条数
	        pageIndex: 1, // 页码
	        city: "0755", // 兴趣点城市
	        citylimit: true,  //是否强制限制在设置的城市内搜索
	        map: map, // 展现结果的地图实例
	        panel: "panel", // 结果列表将在此容器中进行展示。
	        autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
	    });
	    
	    var cpoint = [lnglat]; //中心点坐标
	    placeSearch.searchNearBy('', cpoint, 200, function(status, result) {

	    });
	});
	        }else{alert(JSON.stringify(result))}
	    });
}

function MyMap4(){
	var geocoder;
	if(!geocoder){
	        geocoder = new AMap.Geocoder({
	            city: "0755", //城市设为北京，默认：“全国”
	        });
	    }
	    var address  = document.getElementById('address').value;
	    geocoder.getLocation(address, function(status, result) {
	        if (status === 'complete'&&result.geocodes.length) {
	            var lnglat = result.geocodes[0].location;
	            AMap.service(["AMap.PlaceSearch"], function() {
	    //构造地点查询类
	    var placeSearch = new AMap.PlaceSearch({ 
	        type: '150500', // 兴趣点类别
	        pageSize: 5, // 单页显示结果条数
	        pageIndex: 1, // 页码
	        city: "0755", // 兴趣点城市
	        citylimit: true,  //是否强制限制在设置的城市内搜索
	        map: map, // 展现结果的地图实例
	        panel: "panel", // 结果列表将在此容器中进行展示。
	        autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
	    });
	    
	    var cpoint = [lnglat]; //中心点坐标
	    placeSearch.searchNearBy('', cpoint, 200, function(status, result) {

	    });
	});
	        }else{alert(JSON.stringify(result))}
	    });
}

MyMap1();

$('#canyin').click(function(){
	$('#panel').empty();
	MyMap1();
});

$('#tingche').click(function(){
	$('#panel').empty();
	MyMap2();
});

$('#gongjiao').click(function(){
	$('#panel').empty();
	MyMap3();
});

$('#ditie').click(function(){
	$('#panel').empty();
	MyMap4();
});

