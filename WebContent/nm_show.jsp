<%@ page language="java" import="java.util.*" import="dao.WebDao"
	import="bean.Nmchat" import="bean.PingLun"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/edit.css" />
<title>Insert title here</title>

</head>
<body style="margin: 0; background-image: url(img/banner.jpg);">
	<div class="topname">
		<h1>| 所有用户</h1>
	</div>
	<center>
		<%
		WebDao us = new WebDao();
		List<Nmchat> list = us.show_nmchat();
		
		%>



		<table border="0" bgcolor="ccceee" width="700px"
			style="height: 161px;">
			<tr bgcolor="CCCCCC" align="center">
				<td style="height: 30px; width: 80px">匿名序号</td>
				<td style="height: 30px; width: 80px">匿名发布用户姓名</td>
				<td style="height: 30px; width: 90px">匿名发布用户性别</td>
				<td style="height: 30px; width: 150px">匿名发布用户所属社团</td>
				<td style="height: 30px; width: 80px">匿名发布用户所属学校</td>
				<td style="height: 30px; width: 280px">匿名发布内容</td>
				<td style="height: 30px; width: 80px">操作</td>
			</tr>
			<%
		for(int i = 0; i<list.size(); i++)
		{
			Nmchat rs = (Nmchat)list.get(i);
			
			%>
			<tr align="center">
				<td style="height: 45px; width: 80px"><%=rs.getNid() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getName() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getSex() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getClue() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getSchool() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getSaytext() %></td>


				<td width="auto" align="center"><a style="margin: 5px"
					href="nm_delelte?nid=<%=rs.getNid() %>">删除</a></td>

			</tr>


			<%} %>



		</table>
	</center>
</body>
</html>