<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.angular.service.*,com.angular.entity.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm</title>
</head>
<body>
	
	
		<%
			String str1=(String) session.getAttribute("bookID");
			
			String str = (String) session.getAttribute("currentUser");
			
			
		%>
		<div><h1>Hello <%=str %></h1></div>
		<div><h2>You have successfully favor the book <%=str1 %></h2></div>
		<div><h2>You can check it in your favorite list.</h2></div>
		
	
	
</body>
</html>