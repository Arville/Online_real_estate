			$('#q1').show();
			$('#q2').hide();
			
layui.config({
			base: 'layui_exts/'
		}).extend({
			sliderVerify:'sliderVerify/sliderVerify'
		}).use(['sliderVerify', 'jquery', 'upload','form'], function() {
			
			var $ = layui.jquery,
			sliderVerify = layui.sliderVerify,
			form = layui.form;
				
			if($('#i1').val()=="fault"){
				layer.msg("用户名或密码错误！");
			}
			
			$('#u1').blur(function(){
				$.ajax({
					 url:'yonghuming.do',
				     type:'post',
				     data:{
				    	 username:''+$('#u1').val()+''
				    	 },
				     success:function(data,textStatus){
				    	 if(data=="success"){
				    		 layer.msg('用户名可以使用');
				    	 }else{
				    		 layer.msg('用户名已存在！');
				    	 }
				     }
				   });
			})
			
			var slider = sliderVerify.render({
				elem: '#slider',
				onOk: function(){//当验证通过回调
					layer.msg("滑块验证通过");
				}
			})
			
			var slider3 = sliderVerify.render({
				elem: '#slider3',
				onOk: function(){//当验证通过回调
					layer.msg("滑块验证通过");
				}
			})
			
			
			$('#a1').click(function(){
				$('#q1').hide();
				$('#q2').show();
				slider3.reset();
			})
			
			$('#a2').click(function(){
				$('#q1').show();
				$('#q2').hide();
				slider.reset();
			})
			
	/*var form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;*/
		
		//多图片上传
		
	form.verify({
		
	username: [
		/^[a-zA-Z][a-zA-Z0-9]{3,15}$/, '用户名由英文字母和数字组成的4-16位字符，以字母开头'
	]
			//我们既支持上述函数式的方式，也支持下述数组的形式
			//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
			,
		pass: [
			/^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'
		]
	});
	
			

});
