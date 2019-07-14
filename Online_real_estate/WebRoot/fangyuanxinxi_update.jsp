<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/fangyuanxinxi_insert.css"/>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<style type="text/css">
.pagination-outer{ text-align: center; }
		.pagination{
		    font-family: 'Rubik', sans-serif;
		    display: inline-flex;
		    position: relative;
		}
		.pagination li a.page-link{
		    color: #10ac84;
		    background-color: transparent;
		    font-size: 22px;
		    font-weight: 500;
		    line-height: 28px;
		    height: 40px;
		    width: 40px;
		    margin: 0 5px 10px;
		    border: none;
		    border-radius: 0;
		    overflow: hidden;
		    position: relative;
		    transition: all 0.4s ease 0s;
		}
		.pagination li.active a.page-link,
		.pagination li a.page-link:hover,
		.pagination li.active a.page-link:hover{
		    color: #fff;
		    background-color: #10ac84;
		}
		.pagination li:first-child a.page-link:hover,
		.pagination li:last-child a.page-link:hover{
		    box-shadow: 0 0 10px rgba(0,0,0,0.9);
		}
		.pagination li a.page-link:before{
		    content: attr(data-hover);
		    color: rgba(255,255,255,0.2);
		    font-size: 80px;
		    font-weight: 700;
		    height: 100%;
		    width: 100%;
		    opacity: 1;
		    position: absolute;
		    top: 100%;
		    left: 0;
		    transition: all 0.3s ease 0s;
		}
		.pagination li a.page-link:hover:before,
		.pagination li.active a.page-link:before{
		    opacity: 1;
		    top: 10px;
		}
		@media only screen and (max-width: 480px){
		    .pagination{ display: block; }
		    .pagination li{
		        margin-bottom: 10px;
		        display: inline-block;
		    }
		}
</style>
</head>
<body>
<c:choose>
<c:when test="${flag=='ok'}">
<form action="updateFangyuanxinxi2.do" enctype="multipart/form-data" method="post">
	<div class="contain1">
		<div class="contain2">
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_1" id="input_1" value="${pageResult.fy.bianhao}" />
					<label class="input__label input__label--jiro" for="input_1">
						<span class="input__label-content input__label-content--jiro">房源编号</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_2" id="input_2" value="${pageResult.fy.guihuaqu}"/>
					<label class="input__label input__label--jiro" for="input_2">
						<span class="input__label-content input__label-content--jiro">市辖区</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_3" id="input_3" value="${pageResult.fy.loupanming}"/>
					<label class="input__label input__label--jiro" for="input_3">
						<span class="input__label-content input__label-content--jiro">小区名</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_4" id="input_4" value="${pageResult.fy.shoujia}"/>
					<label class="input__label input__label--jiro" for="input_4">
						<span class="input__label-content input__label-content--jiro">售价</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_5" id="input_5" value="${pageResult.fy.biaoti}"/>
					<label class="input__label input__label--jiro" for="input_5">
						<span class="input__label-content input__label-content--jiro">标题</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_7" id="input_7" value="${pageResult.fy.huxing}"/>
					<label class="input__label input__label--jiro" for="input_7">
						<span class="input__label-content input__label-content--jiro">户型</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_8" id="input_8" value="${pageResult.fy.louceng}"/>
					<label class="input__label input__label--jiro" for="input_8">
						<span class="input__label-content input__label-content--jiro">楼层</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_9" id="input_9" value="${pageResult.fy.mianji}"/>
					<label class="input__label input__label--jiro" for="input_9">
						<span class="input__label-content input__label-content--jiro">面积</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_10" id="input_10" value="${pageResult.fy.huxingjiegou}"/>
					<label class="input__label input__label--jiro" for="input_10">
						<span class="input__label-content input__label-content--jiro">户型结构</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_11" id="input_11" value="${pageResult.fy.jianzhuleixing}"/>
					<label class="input__label input__label--jiro" for="input_11">
						<span class="input__label-content input__label-content--jiro">建筑类型</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_12" id="input_12" value="${pageResult.fy.jianzhujiegou}"/>
					<label class="input__label input__label--jiro" for="input_12">
						<span class="input__label-content input__label-content--jiro">建筑结构</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_13" id="input_13" value="${pageResult.fy.chaoxiang}"/>
					<label class="input__label input__label--jiro" for="input_13">
						<span class="input__label-content input__label-content--jiro">房屋朝向</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_14" id="input_14" value="${pageResult.fy.zhuangxiu}"/>
					<label class="input__label input__label--jiro" for="input_14">
						<span class="input__label-content input__label-content--jiro">装修情况</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_15" id="input_15" value="${pageResult.fy.tihubili}"/>
					<label class="input__label input__label--jiro" for="input_15">
						<span class="input__label-content input__label-content--jiro">梯户比例</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_16" id="input_16" value="${pageResult.fy.peibeidianti}"/>
					<label class="input__label input__label--jiro" for="input_16">
						<span class="input__label-content input__label-content--jiro">配备电梯</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_17" id="input_17" value="${pageResult.fy.chanquannianxian}"/>
					<label class="input__label input__label--jiro" for="input_17">
						<span class="input__label-content input__label-content--jiro">产权年限</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_18" id="input_18" value="${pageResult.fy.jiaoyiquanshu}"/>
					<label class="input__label input__label--jiro" for="input_18">
						<span class="input__label-content input__label-content--jiro">交易权属</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_19" id="input_19" value="${pageResult.fy.fangwuyongtu}"/>
					<label class="input__label input__label--jiro" for="input_19">
						<span class="input__label-content input__label-content--jiro">房屋用途</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_20" id="input_20" value="${pageResult.fy.fangwunianxian}"/>
					<label class="input__label input__label--jiro" for="input_20">
						<span class="input__label-content input__label-content--jiro">房屋年限</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_21" id="input_21" value="${pageResult.fy.chanquansuoshu}"/>
					<label class="input__label input__label--jiro" for="input_21">
						<span class="input__label-content input__label-content--jiro">产权所属</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="input_22" id="input_22" value="${pageResult.fy.diyaxinxi}"/>
					<label class="input__label input__label--jiro" for="input_22">
						<span class="input__label-content input__label-content--jiro">抵押信息</span>
					</label>
				</span>
				<br>
				<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="file" name="fileList" 
					id="input_23" multiple/>
					<label class="input__label input__label--jiro" for="input_23">
						<span class="input__label-content input__label-content--jiro">上传多张房源照片</span>
					</label>
				</span>
				<br>
						<input id="currentPage1" type="hidden" value="${pageResult.currentPage}" />
						<input id="totalPage1" type="hidden" value="${pageResult.totalPage}" />
						<input id="keyword1" type="hidden" value="${keyword}" />
				<input type="submit" value="提交">
				
		</div>
	</div>

</form>

<div style="margin-top: 30px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
				<div class="col-md-8">
					<nav class="pagination-outer" aria-label="Page navigation">
					<ul id="ul1" class="pagination">
						
						
						
					</ul>
					</nav>
				</div>
				<div class="col-md-2"></div>
		</div>
	</div>
</div>


</c:when>
<c:otherwise>
<div class="contain1">
	<div class="contain2">
	  <form action="updateFangyuanxinxi1.do" method="post">
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="update_info" id="update_info" />
					<label class="input__label input__label--jiro" for="update_info">
						<span class="input__label-content input__label-content--jiro">请输入要修改房源的编号或标题： </span>
					</label>
		</span> &emsp;&emsp;
		<span><input type="submit" value="提交"></span>
	  </form>
	</div>
</div>
</c:otherwise>
</c:choose>


<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<script type="text/javascript" src="js/fangyuanxinxi_update.js"></script>
</body>
</html>