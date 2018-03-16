<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/edit.css" />
</head>
<body style="margin: 0; background-image: url(img/banner.jpg);"
	class="headbg">
	<div class="topname">
		<h1>| 查找查找管理</h1>
	</div>
	<form action="webfind" method="post">
	<div class="inputedit">
		<div>
			<input required='' type="text" name="name">
			 <label alt='请输入姓名' placeholder='名称'>
		</div>
		<div>
			<input type="submit" value="提交" style="height: 47px; width: 81px">&nbsp;&nbsp;&nbsp;

			<input type="reset" value="取消" style="height: 45px; width: 75px">
		</div>

</div>
	</form>

</body>

</html>