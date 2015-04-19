<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module("DetailApp", []);
	
	app.controller("DetailController", function($scope, $http) {
		var text = ${id };
		var down = "http://it-ebooks-api.info/v1/book/" + text;
		$http.get(down).success(function(response) {
			$scope.details = response;
			console.log(response);
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
</head>
<body ng-app="DetailApp">
	<div ng-controller="DetailController" class="container">
	<h4>ISBN:</h4>
		<h4 id="id">${id }</h4>
		<div ng-show="details">
			<h2>Details</h2>
			<div class="row">
				<div class="col-sm-3">
					<img ng-src="{{details.Image}}" />
				</div>
				<div class="col-sm-8">
					<h3>{{details.Title}}</h3>
					<h4>
						<span ng-show="details">--</span>{{details.SubTitle}}
					</h4>
					<p>{{details.Description}}</p>
					<h3>
						<a href="{{details.Download}}"><u>Download</u> </a>
					</h3>
				</div>
				
			</div>
		</div>
	</div>
	<form action="add/${id }" method="post">INPUT
						<input class="btn btn-default" type="submit" value="{{book.ID}}" path="id" name="ID">
					</form>
	<div>
		<%
			String str = (String) session.getAttribute("currentUser");
			out.println(str);
		%>
		<a class="btn btn-danger" href="addFavor/${id }/<%=str%>">add</a>
	</div>
</body>
</html>