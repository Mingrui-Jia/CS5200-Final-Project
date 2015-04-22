<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayTheBooks</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link
	href="http://getbootstrap.com/examples/starter-template/starter-template.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>

<script type="text/javascript">
	var app = angular.module("DisplayApp", []);
	app.controller("DisplayController", function($scope, $http) {

		$scope.searchBooks = function() {
			var title = $scope.searchByTitle;
			var url = "http://it-ebooks-api.info/v1/search/" + title;

			$http.get(url).success(function(response) {
				//console.log(url);
				$scope.books = response.Books;
			})
		}

	})
</script>
</head>
<body ng-app="DisplayApp">
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
			<%
				String str = (String) session.getAttribute("currentUser");
			%>
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
	<div class="starter-template">
		<div ng-controller="DisplayController" class="container">
			<h1>Need some ebook?</h1>


			<table class="table table-striped">
				<tr>
					<th>Poster</th>
					<th>Title</th>
					<th>SubTitle</th>
					<th>isbn</th>
				</tr>
				<tr ng-repeat="book in books">
					<td><img class="poster" ng-src="{{book.Image}}" width="50" />
					</td>
					<td><a href="{{book.ID}}">{{book.Title}}</a></td>
					<td>{{book.SubTitle}}</td>
					<td>{{book.isbn}}</td>

				</tr>
			</table>
			<div class="input-group">
				<input type="text" ng-model="searchByTitle" class="form-control"
					placeholder="Search for..."> <span class="input-group-btn">
					<button ng-click="searchBooks()" class="btn btn-default"
						type="button">Go!</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<div class="container">
			
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>