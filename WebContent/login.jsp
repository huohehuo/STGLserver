<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />


</head>
<body>
 <form action="weblogin" method="post"><br>
 
 <div class="login">
	<h2>社团活动信息管理</h2>
	<div class="login-top">
		<h1>管理员登录</h1>
		<form>
			<input type="text" value="Admin" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Id';}" name="admin">
			<input type="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}" name="pwd">
	    </form>
	    <div class="forgot">
	    	<input type="submit" value="Login" >
	    </div>
	</div>
	<div class="login-bottom">
		<h3>欢迎登陆本系统</h3>
	</div>
</div>	
 

</form>
</body>
</html>