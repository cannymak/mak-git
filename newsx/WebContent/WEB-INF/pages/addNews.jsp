<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="/newsx/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/newsx/resources/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="/newsx/resources/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/newsx/resources/bootstrap/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Latest News Update</title>
</head>
<body>


	<div class="jumbotron" align="center">
		<h1>Add News</h1>
	</div>

	<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/newsx">NewsX</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Add News <span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="jumbotron">
		<div class="container">
			<h1>Add Latest News</h1>
		</div>
	</div>
	<div class="container">
		<div class="col-md-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Add News</h3>
				</div>
				<div class="panel-body">
					<form:form method="POST" modelAttribute="news"
						action="/newsx/addNews">
						<div class="input-group">
							<span class="input-group-addon" id="sizing-addon2">HeadLines</span>
							<form:input type="text" class="form-control" path="headlines"
								required="true" placeholder="Enter Headlines"
								aria-describedby="sizing-addon2" />
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="sizing-addon2">Image
								Url</span>
							<form:input type="text" class="form-control" path="imageurl"
								required="true" placeholder="Enter image url"
								aria-describedby="sizing-addon2" />
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="sizing-addon2">video
								Url</span>
							<form:input type="text" class="form-control" path="videourl"
								placeholder="Enter video url" aria-describedby="sizing-addon2" />
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="sizing-addon2">News
								Type</span>
							<form:select class="form-control" path="newstype" id="newsType">
								<a:forEach items="${newsTypes}" var="type">
									<option value="${type}">${type}</option>
								</a:forEach>
							</form:select>
						</div>
						<br>
						<div class="form-group">
							<label for="comment">Main Story:</label>
							<form:textarea class="form-control" rows="5" required="true"
								path="mainStory" id="comment"></form:textarea>
						</div>
						<br>
						<button type="submit" class="btn btn-danger pull-right">Add</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>