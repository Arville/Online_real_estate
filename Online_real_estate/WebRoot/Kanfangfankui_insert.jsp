<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/Kanfangfankui_insert.css"/>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>
<body>
<form action="insertFankui.do" method="post">
	<div class="contain1">
  		<div class="contain2">
			<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="bianhao" id="bianhao" />
					<label class="input__label input__label--jiro" for="bianhao">
						<span class="input__label-content input__label-content--jiro">房源编号</span>
					</label>
				</span>
			<br />
			<br />
	<div class='textarea-wrapper'>
        <div class='textarea-block'>
            <textarea class="textarea-item" name="content" placeholder="请输入内容，不超过300字。" maxlength="300" spellcheck="false"></textarea>
            <div class="textarea-count">
                <span class="textareaInput">0</span>/<span class="textareaTotal">300</span>
            </div>
        </div>
    </div>
    <input type="hidden" name="gonghao" value="${jjrxinxi.gonghao}"  />
    <input type="submit" value="提交">
  </div>
</div>
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<!-- input框需要的js -->
<script type="text/javascript" src="js/Kanfangfankui_insert.js"></script>
</body>
</html>