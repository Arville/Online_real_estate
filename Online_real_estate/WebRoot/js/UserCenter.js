function guanzhu(x,obj){
	var ufid2=$('#ufid1').val();
	if(ufid2!=""){
	$.ajax({
		 url:'fyattention.do',
	     type:'post',
	     data:{
	    	 ufid:''+ufid2+'',
	    	 bianhao:''+x+''
	    	 },
	     success:function(data,textStatus){
	    	 if(data=="success"){
	    		 $(obj).text("取消关注");
	    		 $(obj).attr("onclick","quxiaoguanzhu("+x+",this)");
	    	 }
	     },
	     error:function(){
			   alert("关注失败");
		   }
	   });
	}
}

function quxiaoguanzhu(x,obj){
	var ufid2=$('#ufid1').val();
	if(ufid2!=""){
	$.ajax({
		 url:'fycancel.do',
	     type:'post',
	     data:{
	    	 ufid:''+ufid2+'',
	    	 bianhao:''+x+''
	    	 },
	     success:function(data,textStatus){
	    	 if(data=="success"){
	    		 $(obj).text("关注");
	    		 $(obj).attr("onclick","guanzhu("+x+",this)");
	    	 }
	     },
	     error:function(){
			   alert("取消关注失败");
		   }
	  });
	}
}

$(".contain1").hover(function(){
					var ufid2=$('#ufid1').val();
					var a=$(this).children("div").eq(2).next().val();
					var gz=$(this).children("div").eq(2);
					if(ufid2!=""){
					$.ajax({
						 url:'findguanzhu.do',
					     type:'post',
					     data:{
					    	 ufid:''+ufid2+'',
					    	 bianhao:''+a+''
					    	 },
					     success:function(data,textStatus){
					    	 if(data=="nohaved"){
					    		 gz.append("<a href='javascript:void(0);' onclick='guanzhu(&quot;"+a+"&quot;,this)'>关注</a>");
					    	 }else{
					    		 gz.append("<a href='javascript:void(0);' onclick='quxiaoguanzhu(&quot;"+a+"&quot;,this)'>取消关注</a>");
					    	 }
					     },
					     error:function(){
							   alert("失败");
						   }
						});
					}
				    },function(){
				    	$(this).children("div").eq(2).empty();
				  });


var currentPage=$('#currentPage1').val();
var totalPage=$('#totalPage1').val();
if (totalPage<=5) {
	for (var i=1; i <= totalPage; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="UserCenter.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage<3) {
	for (var i=1; i <= 5; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="UserCenter.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage-1>1&&currentPage+1<totalPage) {
	for (var i=currentPage-2; i <= currentPage+2; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="UserCenter.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage+1==totalPage) {
	for (var i=currentPage-3; i <= currentPage+1; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="UserCenter.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}
if (totalPage>5&&currentPage==totalPage) {
	for (var i=currentPage-4; i <= currentPage; i++) {
		$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="UserCenter.do?currentPage='+i+'" data-hover='+i+'>'+i+'</a></li>');
	}
	$('#li'+currentPage+'').addClass("active");
}