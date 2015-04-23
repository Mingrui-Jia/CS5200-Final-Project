<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>ebook4u</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link
	href="http://getbootstrap.com/examples/starter-template/starter-template.css"
	rel="stylesheet">



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
             table.center {
    margin-left:auto; 
    margin-right:auto;
  }
        </style>
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

	<div class="container">

		<div class="starter-template">
			<h1> ${otheruser }<a class="btn btn-danger" href="<%=request.getContextPath()%>/user/follow/<%=str %>/${otheruser}"><span class="glyphicon glyphicon-heart"></span></a></h1>
			
			<table class=" table-striped center" style="text-align:center;">
				<tr>
					<th>following</th>
					<th>followed</th>
					
				</tr>
				<tr >
					
					<td><a href="<%=request.getContextPath()%>/user/${otheruser }/following">${following }</a></td>
					<td><a href="<%=request.getContextPath()%>/user/${otheruser }/followed">${followed }</a></td>

				</tr>
			</table>
			
			<h2>This user favors:</h2>
			<ul>
				<c:forEach var="book" items="${books}">
					<li><h3>
							<a href="<%=request.getContextPath()%>/book/${book}">${book}</a>
						</h3></li>
				</c:forEach>
			</ul>
		</div>

	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>
