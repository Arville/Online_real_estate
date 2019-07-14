function guanzhu(p,obj){
					var ufid2=$('#ufid1').val();
					if(ufid2!=""){
					$.ajax({
						 url:'fyattention.do',
					     type:'post',
					     data:{
					    	 ufid:''+ufid2+'',
					    	 bianhao:''+p+''
					    	 },
					     success:function(data,textStatus){
					    	 if(data=="success"){
					    		 $(obj).text("取消关注");
					    		 $(obj).attr("onclick","quxiaoguanzhu("+p+",this)");
					    		 layer.msg('关注成功');
					    	 }
					     },
					     error:function(){
							   alert("关注失败");
						   }
					   });
					}
				}

				function quxiaoguanzhu(l,obj){
					var ufid2=$('#ufid1').val();
					if(ufid2!=""){
					$.ajax({
						 url:'fycancel.do',
					     type:'post',
					     data:{
					    	 ufid:''+ufid2+'',
					    	 bianhao:''+l+''
					    	 },
					     success:function(data,textStatus){
					    	 if(data=="success"){
					    		 $(obj).text("关注");
					    		 $(obj).attr("onclick","guanzhu("+l+",this)");
					    		 layer.msg('取消关注成功');
					    	 }
					     },
					     error:function(){
							   alert("取消关注失败");
						   }
					  });
					}
				}	
$(function(){
	$("#menu2 li a").wrapInner( '<span class="out"></span>' );
	
	$("#menu2 li a").each(function() {
		$( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
	});

	$("#menu2 li a").hover(function() {
		$(".out",	this).stop().animate({'top':	'40px'},	300); // move down - hide
		$(".over",	this).stop().animate({'top':	'0px'},		300); // move down - show

	}, function() {
		$(".out",	this).stop().animate({'top':	'0px'},		300); // move up - show
		$(".over",	this).stop().animate({'top':	'-40px'},	300); // move up - hide
	});
	
		
	
	$(".f2_f3").hover(function(){
		var ufid2=$('#ufid1').val();
		var a=$(this).children("div").eq(1).next().val();
		var div1=$(this).children("div").eq(1);
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
		    		 div1.append("<a href='javascript:void(0);' onclick='guanzhu(&quot;"+a+"&quot;,this)'>关注</a>");
		    	 }else{
		    		 div1.append("<a href='javascript:void(0);' onclick='quxiaoguanzhu(&quot;"+a+"&quot;,this)'>取消关注</a>");
		    	 }
		     },
		     error:function(){
				   alert("失败");
			   }
			});
		}
	    },function(){
	    	$(this).children("div").eq(1).empty();
	  });
	
	var currentPage=$('#currentPage1').val();
	var totalPage=$('#totalPage1').val();
	var navi=$('#navi1').val();
	var keyword=$('#keyword1').val();
	var shaixuan=$('#shaixuan1').val();
	
	if (totalPage<=5) {
		for (var i=1; i <= totalPage; i++) {
			$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="fyxxList.do?currentPage='+i+'&navigation='+navi+'&keyword='+keyword+'&shaixuan='+shaixuan+'" data-hover='+i+'>'+i+'</a></li>');
		}
		$('#li'+currentPage+'').addClass("active");
	}
	if (totalPage>5&&currentPage<3) {
		for (var i=1; i <= 5; i++) {
			$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="fyxxList.do?currentPage='+i+'&navigation='+navi+'&keyword='+keyword+'&shaixuan='+shaixuan+'" data-hover='+i+'>'+i+'</a></li>');
		}
		$('#li'+currentPage+'').addClass("active");
	}
	if (totalPage>5&&currentPage-1>1&&currentPage+1<totalPage) {
		for (var i=currentPage-2; i <= currentPage+2; i++) {
			$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="fyxxList.do?currentPage='+i+'&navigation='+navi+'&keyword='+keyword+'&shaixuan='+shaixuan+'" data-hover='+i+'>'+i+'</a></li>');
		}
		$('#li'+currentPage+'').addClass("active");
	}
	if (totalPage>5&&currentPage+1==totalPage) {
		for (var i=currentPage-3; i <= currentPage+1; i++) {
			$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="fyxxList.do?currentPage='+i+'&navigation='+navi+'&keyword='+keyword+'&shaixuan='+shaixuan+'" data-hover='+i+'>'+i+'</a></li>');
		}
		$('#li'+currentPage+'').addClass("active");
	}
	if (totalPage>5&&currentPage==totalPage) {
		for (var i=currentPage-4; i <= currentPage; i++) {
			$("#ul1").append('<li id="li'+i+'" class="page-item"><a class="page-link" href="fyxxList.do?currentPage='+i+'&navigation='+navi+'&keyword='+keyword+'&shaixuan='+shaixuan+'" data-hover='+i+'>'+i+'</a></li>');
		}
		$('#li'+currentPage+'').addClass("active");
	}


})
