$(function() {
    reder()
})

function reder() {
    var option = {
        url: "js/data.json",
        searfunc: searfunc

    }

    function searfunc(arr) {
        //arr为查询按钮之后输出的搜索条件
        //console.log(arr);
        var str="";
        for(var i in arr){
　　			for(var j in arr[i]){
				str+=arr[i][j]+"|";
			}
		}
        if(str!=""){
        $.ajax({
   		 url:'fyxxList.do',
   	     type:'post',
   	     data:{
   	    	 shaixuan:''+str+'',
   	    	navigation: "default2"
   	    	 },
   	     success:function(data,textStatus){
   	    	 window.location.href="fangyuanxinxilist.jsp";   
   	     },
   	     error:function(){
   			   alert("查询失败");
   		   }
        	});
        }else{
        	alert("请您设置高级选项再点击查询");
        }
    }

    $("#searchcon").SEarch(option);
}