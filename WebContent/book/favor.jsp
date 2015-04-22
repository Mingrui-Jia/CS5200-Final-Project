<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">

    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
      <%
			String str1=(String) session.getAttribute("bookID");
			
			//String str = (String) session.getAttribute("currentUser");
			
			
		%>
		<div><h1>Hello <%=str %></h1></div>
		<div><h2>You have successfully favored the book <%=str1 %></h2></div>
		<div><h2>You can check it in your favorite list.</h2></div>
             </div>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
     <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
  </body>
</html>
