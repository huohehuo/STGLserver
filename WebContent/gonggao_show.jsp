<%@ page language="java" import="java.util.*" import="dao.WebDao"
	import="bean.Gonggao" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		List<Gonggao> list = us.show_allgg();
		
		%>
				<table border="0" bgcolor="ccceee" width="700px" style="height: 161px;">
			<tr bgcolor="CCCCCC" align="center">
				<td style="height: 30px; width: 80px">公告ID</td>
				<td style="height: 30px; width: 80px">公告发布人</td>
				<td style="height: 30px; width: 90px">公告所属社团</td>
				<td style="height: 30px; width: 150px">公告内容</td>
				<td style="height: 30px; width: 80px">公告所属学校</td>
				<td style="height: 30px; width: 80px">操作</td>
			</tr>
			<%
		for(int i = 0; i<list.size(); i++)
		{
			Gonggao rs = (Gonggao)list.get(i);
			
			%>
			<tr align="center">
				<td style="height: 45px; width: 80px"><%=rs.getGid() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getGname() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getGclue() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getGonggao() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getOfschool() %></td>
				
				
				 <td width="auto" align="center">
				 <a style="margin: 5px" href="gg_delete?gname=<%=rs.getGname() %>">删除公告</a></td>
				
			</tr>
		 
		
			<%} %>

			
			
		</table>
	</center>
</body>
</html>