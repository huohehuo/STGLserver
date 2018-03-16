<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

		 framset,frame{
		 	border:0px;
		 }
</style>
</head>

<frameset rows="80,*" frameborder="no" border="0">
    		<frame src="index_title.jsp" scrolling="no">
    		<frameset cols="255,*" frameborder="no" border="0">
    			<frame src="user_left.jsp" name="left" scrolling="auto">
    			<frame src="user_right.jsp" name="right" scrolling="auto">
    		</frameset>
    		
    	</frameset>

</html>