<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayTheBooks</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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
	<div ng-controller="DisplayController" class="container">
		<h1>Display the books in table</h1>


		<table class="table table-striped">
			<tr>
				<th>Poster</th>
				<th>Title</th>
				<th>SubTitle</th>
				<th>isbn</th>
				<th>&nbsp;</th>
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
		<%
			String str = (String) session.getAttribute("currentUser");
			out.println(str);
		%>
	</div>

</body>
</html>