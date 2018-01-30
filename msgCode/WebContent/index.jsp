<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>猿说教育-手机短信验证系统</title>
<style type="text/css">
	body{
		background: #1f1f2b;
    	color: #fff;
	}
	.box{
		width: 400px;
	    margin: 70px auto;
	    padding: 30px;
	    background: rgba(247, 247, 247, 0.15);
	    box-shadow: 0px 0px 50px 0px #fff;
	    border-radius: 16px;
	}
	.content{
		    background: rgba(88, 144, 160, 0.08);
   			height: 200px;
	}
	h3{
		    text-align: center;
	}
	.controller{
		    margin-top: 20px;
		    padding-left: 20px;
		    padding-top: 20px;
	}
	input{
		    background: none;
	    border: none;
	    outline: none;
	    border-bottom: 1px solid #968f8f;
	    color: #fff;
	}
	a{
		    color: #999;
    margin-left: 20px;
	}
	button{
		width: 100px;
	    font-size: 20px;
	    background: #54a5a1;
	    color: #fff;
	    border: none;
	    padding: 10px;
	    border-radius: 65px;
	    cursor:pointer;
	        outline: none;
	}
	button:hover{
		box-shadow: 0px 0px 1px 1px #fff;
	}
</style>
</head>
<body>
	<div class="box">
		<h3>【猿说教育】手机短信验证系统</h3>
		<div class="content">
			<div class="controller">手机号码:<input type="text" id="phone"/></div>
			<div class="controller"><input type="text" id="code"/><a href="javascript:void(0)" id="getCode">获取验证码</a></div>
			<div class="controller" style="text-align:center"><button onclick="validate()" >校验</button></div>
		</div>
	</div>
	<script type="text/javascript">
	var obj = document.getElementById("getCode");
	var flag = 10;
	//注册点击事件
	obj.onclick=function(){
		if(flag<10){
			return;
		}
		//ajax引擎（浏览器内部的小型浏览器）
		var xhr = new XMLHttpRequest();
		//相当于你打开浏览器输入需要访问的地址
		xhr.open("get","getCode.do?phone="+document.getElementById("phone").value,true);
		//监控请求状态 判断是否请求完成，回调函数，事件监听函数
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				//alert(xhr.responseText);
			}
		}
		xhr.send(null);
		timer();
	}
	function validate(){
		//ajax引擎（浏览器内部的小型浏览器）
		var xhr = new XMLHttpRequest();
		//相当于你打开浏览器输入需要访问的地址
		xhr.open("get","ValidateCode?code="+document.getElementById("code").value,true);
		//监控请求状态 判断是否请求完成，回调函数，事件监听函数
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				alert(xhr.responseText);
			}
		}
		xhr.send(null);
	}
	function timer(){
		flag--;
		obj.innerHTML=flag+"秒以后重新获取！";
		if(flag==0){
			obj.innerHTML="获取验证码";
			flag =10;
		}else{
			
		setTimeout("timer()",1000);
		}
	}
	</script>
</body>
</html>