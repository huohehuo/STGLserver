<%@ page language="java" import="java.util.*" import="dao.WebDao"
	import="bean.HuoDong" import="bean.PingLun" contentType="text/html; charset=UTF-8"
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
		List<HuoDong> list = us.show_hd();
		
		List<PingLun> list2 = us.show_pl();
		%>
		
	
		
				<table border="0" bgcolor="ccceee" width="700px" style="height: 161px;">
			<tr bgcolor="CCCCCC" align="center">
				<td style="height: 30px; width: 80px">活动序号</td>
				<td style="height: 30px; width: 80px">发布用户ID</td>
				<td style="height: 30px; width: 90px">发布用户姓名</td>
				<td style="height: 30px; width: 150px">活动标题</td>
				<td style="height: 30px; width: 80px">活动时间</td>
				<td style="height: 30px; width: 280px">活动内容</td>
				<td style="height: 30px; width: 80px">操作</td>
			</tr>
			<%
		for(int i = 0; i<list.size(); i++)
		{
			HuoDong rs = (HuoDong)list.get(i);
			
			%>
			<tr align="center">
				<td style="height: 45px; width: 80px"><%=rs.getHid() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getRid() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getHname() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getHtitle() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getHtime() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getHword() %></td>
				
				
				 <td width="auto" align="center"><a style="margin: 5px"  href="hd_delete?hid=<%=rs.getHid() %>">删除</a>
				 <a style="margin: 5px" href="pl_find?hid=<%=rs.getHid() %>">查看评论</a></td>
				
			</tr>
		 
		
			<%} %>

			
			
		</table>
	</center>
</body>
</html>