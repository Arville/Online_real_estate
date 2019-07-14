<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class=" nav">
	<div class="box navcontent">
          <div class="navbox">
          <ul>
              <li class="mainlevel"><a href="index.do">网站首页</a></li>
              <li class="mainlevel"><a href="fyxxList.do?navigation=default">二手房源</a></li>
			  <li class="mainlevel"><a href="fangyuanxinxi_fangyuanfabu.jsp">房源发布</a></li>
			  
          </ul>
          </div>
          <span style="color: #FFF;line-height: 39px;">搜索</span>
           <div class="searchbox">
          	<form id="Search1" method="post" action="fyxxList.do">
            	<input type="text" id="biaoti" name="biaoti" />
                <input type="button" id="sbnt"/>
                <input type="hidden" id="keyword" name="keyword"  />
                <input type="hidden" id="navigation" name="navigation" value="default"  />
            </form>
          </div> 
       </div>
</div>
<script>
$(document).ready(function(){
  
  $('li.mainlevel').mousemove(function(){
  $(this).find('ul').slideDown();
  });
  $('li.mainlevel').mouseleave(function(){
  $(this).find('ul').slideUp("fast");
  });
  $('#sbnt').click(function(){
		$("#keyword").val($("#biaoti").val());
		$("#Search1").submit();
	});
$("#biaoti").keydown(function(event){
	  if(event.keyCode==13||event.keyCode==108){
		  $("#keyword").val($("#biaoti").val());
		  $("#Search1").submit();
	  }
});
  
});

</script>