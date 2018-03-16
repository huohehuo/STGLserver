<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin: 100 200; width: 266px; height: 226px;background-color:#888888">
		请输入修改条件(单个或多个)
			<form action="webupdate" method="post">
			<table >
				<tr><td>姓名:</td><td><input type="text" name="name"></td></tr>
				<tr><td>密码:</td><td><input type="text" name="pwd"></td></tr>
				<tr><td>性别:</td>
				<td><input type="radio" name="sex"value="男">男
					<input type="radio" name="sex" value="女">女
				</td></tr>
				<tr><td>年龄:</td><td><input type="text" name="age"></td></tr>

				<tr style="align:center">
				<td colspan="2">
				<input type="submit"value="确定">
				&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset"value="取消">
				</td>
				</tr>
				</table>
			</form>
</body>
</html>