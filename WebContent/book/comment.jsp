<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
 <script type="text/javascript">
 console.log("1");
 
function createComment(){
	var form=document.forms[0];
	console.log("1");
	form.action="/ssh1/book/createComment"; 
	form.method="get";
	form.submit();
	
}

</script>
    <title>ebook4u</title>

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

    <body>
    

    <div class="container">
    <h3>You are making a comment on book#${bookID }</h3>
    <!-- 
	<form name="userForm" action="" class="form-signin">
		
		<input type="text" name="content" class="form-control"><br>
		<input class="btn btn-lg btn-primary btn-block" type="button" value="post" onclick="createComment()"><br>
	</form> -->
	<form name="userForm" action="" class="form-signin">
		<h2 class="form-signin-heading">${username } </h2>
		password:<input type="text" name="password"  class="form-control"><br>
		email:<input type="text" name="email" class="form-control"><br>
		first name:<input type="text" name="firstName" class="form-control"><br>
		last name:<input type="text" name="lastName" class="form-control"><br>
		phone#:<input type="text" name="phoneNumber" class="form-control"><br>
		<input class="btn btn-lg btn-primary btn-block" type="button" value="Update" onclick="createComment()"><br>
		<!-- 这个调的是上面的function -->
	</form>
	</div>


    
  </body>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
     <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
  </body>
</html>