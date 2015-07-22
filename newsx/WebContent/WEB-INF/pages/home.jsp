<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to NewsX</title>
<script type="text/javascript"
	src="/newsx/resources/jquery/jquery.min.js"></script>
<link href="/newsx/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/newsx/resources/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="http://getbootstrap.com/examples/carousel/carousel.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="/newsx/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/newsx/resources/canvasJs/canvasjs.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "News Categories",
				verticalAlign : 'top',
				horizontalAlign : 'left'
			},
			animationEnabled : true,
			data : [ {
				type : "doughnut",
				click:onClick,
				startAngle : 20,
				toolTipContent : "{label}: {y} - <strong>#percent%</strong>",
				indexLabel : "{label} #percent%",
				dataPoints : ${chartdata}
			}]
		});
		chart.render();
		
		function onClick(e){
			alert("here");
			window.location="/newsx/news/" +e.dataPoint.label;
		}
	}
</script>


</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">NewsX</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/newsx/addNews">Add News<span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="row">
		<div class="container">
			<div class="col-md-8">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<a:forEach items="${carouselnews}" var="n" varStatus="i">
							<a:choose>
								<a:when test="${i.index==0}">
									<div class="item active">
										<img class="third-slide" src="${n.imageurl}"
											alt="${n.headlines}">
										<div class="container">
											<div class="carousel-caption">
												<h1>${n.headlines}</h1>
											</div>
										</div>
									</div>
								</a:when>
								<a:otherwise>
									<div class="item">
										<img class="third-slide" src="${n.imageurl}"
											alt="${n.headlines}">
										<div class="container">
											<div class="carousel-caption">
												<h1>${n.headlines}</h1>
											</div>
										</div>
									</div>
								</a:otherwise>
							</a:choose>
						</a:forEach>

					</div>

					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
				<!-- /.carousel -->
			</div>
			<div class="col-md-4">
				<h1>Gekki</h1>
				<div id="chartContainer" style="height: 300px; width: 100%;"></div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-lg-8">
				<form method="POST" action="/newsx/search">
					<div class="input-group">
						<input type="text" id="query" name="query" type="text"
							class="form-control" placeholder="Search for..." /> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">Go!</button>
						</span>
					</div>
					<!-- /input-group -->
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
		<br>
		<div class="row">
			<a:forEach items="${allnews}" var="news">
				<div class="col-md-4">
					<div class="thumbnail">
						<img src="${news.imageurl}" alt="...">
						<h3>
							<a href="/newsx/news?id=${news.news_id}">${news.headlines}</a>
						</h3>
					</div>
				</div>
			</a:forEach>
		</div>
	</div>
</body>

</html>