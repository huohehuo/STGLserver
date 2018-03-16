<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });

});
</script>
<body style="height: 80px;">
	
	<div class="navgation">
		<ul class="nav">
			<li><a href="user_left.jsp" target="left">用户管理</a></li>
			<li><a href="hd_pl_left.jsp" target="left">活动以及评论管理</a></li>
			<!-- <li><a href="#">评论管理</a></li> -->
			<li><a href="stgl_left.jsp" target="left">社团内务管理</a></li>
			
		</ul>
	</div>


</body>

</body>
</html>