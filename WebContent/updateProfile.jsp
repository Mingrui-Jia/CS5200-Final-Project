<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Profile</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<%
					String str = (String) session.getAttribute("currentUser");
				%>
<script type="text/javascript">
function updateProfile(){
	var form=document.forms[0];
	form.action="/ssh1/user/updateProfile/<%=str%>";
	form.method="get";
	form.submit();
	
}
</script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ebook4u</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
			
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="<%=request.getContextPath()%>/book/search"><span class="glyphicon glyphicon-search"></span></a></li>
					<li><a href="<%=request.getContextPath()%>/user/<%=str%>"><span class="glyphicon glyphicon-user"></span></a></li>
					<li><a href="<%=request.getContextPath()%>/contact.jsp"><span class="glyphicon glyphicon-phone-alt"></span></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
<div class="container">

	<form name="userForm" action="" class="form-signin">
		<h2 class="form-signin-heading">${username } </h2>
		password:<input type="text" name="password"  class="form-control"><br>
		email:<input type="text" name="email" class="form-control"><br>
		first name:<input type="text" name="firstName" class="form-control"><br>
		last name:<input type="text" name="lastName" class="form-control"><br>
		phone#:<input type="text" name="phoneNumber" class="form-control"><br>
		<input class="btn btn-lg btn-primary btn-block" type="button" value="Update" onclick="updateProfile()"><br>
		<!-- 这个调的是上面的function -->
	</form>
	</div>


</body>
</html>