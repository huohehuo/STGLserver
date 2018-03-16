<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/edit.css" />

<title>Insert title here</title>

</head>
<body style="margin: 0; background-image: url(img/banner.jpg);"
	class="headbg">
	<div class="topname">
		<h1>| 添加管理</h1>
	</div>
	<form action="webinsert" method="post">
	<div class="inputedit">
		<div>
			<input required='' type="text" name="name">
			 <label alt='请输入姓名' placeholder='名称'>
		</div>
		<div>
			<input required='' type="text" name="pwd">
			 <label alt='请输入密码' placeholder='密码'>
		</div>
		<div>
			<input required='' type="text" name="sex">
			 <label alt='请输入性别' placeholder='性别'>
		</div>
		<div>
			<input required='' type="text" name="age">
			 <label alt='请输入年龄' placeholder='年龄'>
		</div>
		<div>
			<input required='' type="text" name="clue">
			 <label alt='请输入社团' placeholder='社团'>
		</div>
		<div>
			<input type="submit" value="提交" style="height: 47px; width: 81px">&nbsp;&nbsp;&nbsp;

			<input type="reset" value="取消" style="height: 45px; width: 75px">
		</div>

</div>
	</form>

</body>
</html>