<%@ page language="java" import="java.util.*" import="bean.PingLun" import="dao.DbUtil" import="dao.WebDao" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin: 0; background-image: url(img/banner.jpg);">

<%       List list =(List) request.getAttribute("pl_list");

    		WebDao aa=new WebDao();
	
			for(int i=0;i<list.size();i++ ){
				PingLun rs= (PingLun)list.get(i);
		 %>

	<table border="0" bgcolor="ccceee" width="650" style="height: 161px;">
		<tr bgcolor="CCCCCC" align="center">
			<td style="height: 30px;width:80px ">评论序号</td><td style="height: 30px;width:80px ">活动ID</td>
    	 			<td style="height: 30px;width:80px ">评论人ID</td><td style="height: 30px;width:80px ">评论人姓名</td>
    	 			<td style="height: 30px;width:80px ">评论内容</td><td style="height: 30px;width:80px ">操作</td>

		</tr>

		<tr align="center">
    	 			 	<td style="height: 45px; width:80px"><%=rs.getPid() %></td>
    	 			 	<td style="height: 45px;width:80px"><%=rs.getHid() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getRid() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getPname() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getPword() %></td>
 						<td width="80px" align="center"><a href="pl_delete?pid=<%=rs.getPid() %>">删除</a></td>
		</tr>
		<%} %>

	</table>
</body>
</html>