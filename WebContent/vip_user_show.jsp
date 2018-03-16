<%@ page language="java" import="java.util.*" import="dao.WebDao"
	import="bean.Forvip" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/edit.css" />
<title>Insert title here</title>
<script type="text/javascript">
    function deleteuser(bookId) {
        window.location.href = "n.jsp?name="+bookId;
    }
</script>
</head>
<body style="margin: 0; background-image: url(img/banner.jpg);">
	<div class="topname">
		<h1>| 所有用户</h1>
	</div>
	<center>
		<%
		WebDao us = new WebDao();
		List<Forvip> list = us.show_forvip();
		%>
		
		<table border="0" bgcolor="ccceee" width="650" style="height: 161px;">
			<tr bgcolor="CCCCCC" align="center">
				<td style="height: 30px; width: 80px">申请ID</td>
				<td style="height: 30px; width: 80px">申请人姓名</td>
				<td style="height: 30px; width: 80px">申请原因</td>
				<td style="height: 30px; width: 80px">操作</td>
			</tr>
		<%
		for(int i = 0; i<list.size(); i++)
		{
			Forvip rs = (Forvip)list.get(i);
			%>
			<tr align="center">
				<td style="height: 45px; width: 80px"><%=rs.getRid() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getName() %></td>
				<td style="height: 45px; width: 80px"><%=rs.getReason() %></td>
				 <td width="80px" align="center"><a href="vip_add?rid=<%=rs.getRid() %>">设为社长</a></td>
				
				
			</tr>
			<%} %>

		</table>
	</center>
</body>
</html>