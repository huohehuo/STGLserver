<%@ page language="java" import="java.util.*" import="bean.PUser" import="dao.DbUtil" import="dao.WebDao" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%       List list =(List) request.getAttribute("list");

    		WebDao aa=new WebDao();
	
			for(int i=0;i<list.size();i++ ){
			PUser rs= (PUser)list.get(i);
		 %>

	<table border="0" bgcolor="ccceee" width="650" style="height: 161px;">
		<tr bgcolor="CCCCCC" align="center">
			<td style="height: 30px;width:80px ">用户</td><td style="height: 30px;width:80px ">姓名</td>
    	 			<td style="height: 30px;width:80px ">密码</td><td style="height: 30px;width:80px ">性别</td>
    	 			<td style="height: 30px;width:80px ">年龄</td><td style="height: 30px;width:80px ">所属社团</td>
    	 			<td style="height: 30px;width:80px ">是否为社长</td>

		</tr>

		<tr align="center">
			<td style="height: 45px; width:80px"><%=rs.getRid() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getName() %></td>
    	 			 	<td style="height: 45px;width:80px"><%=rs.getPassword() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getSex() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getAge() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getClue() %></td>
    	 			 	<td style="height: 45px; width:80px"><%=rs.getVip() %></td>
			<td width="80px" align="center"><a href="webdelete?name=<%=rs.getName() %>">删除</a></td>

		</tr>
		<%} %>

	</table>
</body>
</html>