<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
function addUser(){
	var form=document.forms[0];
	form.action="/ssh1/user/checkUserExist";
	form.method="get";
	form.submit();
	
}

</script>
</head>
<body>
<div class="container">
	<form name="userForm" action="">
		name:<input type="text" name="userName"> <br>
		password:<input type="text" name="password"><br>
		email:<input type="text" name="email"><br>
		first name:<input type="text" name="firstName"><br>
		last name:<input type="text" name="lastName"><br>
		phone#:<input type="text" name="phoneNumber"><br>
		<input type="button" value="add" onclick="addUser()"><br>
	</form>
	</div>
	<h2>add User</h2>


</body>
</html>