<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/weather.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCrLuj9CqcVVw2ef2f5saPNCOzikCXAXsI&callback=initMap"></script>
<script src="scripts/weatherMap.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="css/fonts/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="scripts/lib/sweetalert/sweetalert2.css">
<link rel="stylesheet" href="css/theme.css">
<link rel="stylesheet" href="css/theme-elements.css">
<link rel="stylesheet" href="css/skins/red.css">
<link rel="stylesheet" href="css/custom.css">
<title>Carpool Weather Map</title>

</head>
<body>
	<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

	<header class="header header-default">
	<div class="header-top">
		<div>
			<div class="row">
				<div class="col-md-6">
					<div class="header-top-left">
						<ul class="header-top-nav">
							<li><a href="LoginServlet"> <img class="header-logo"
									src="css/images/car1.png" style="width: 70px; height: 70px;" />
									<span class="header-text">Car Pooling</span>
							</a></li>
						</ul>
					</div>
				</div>

				<c:choose>
					<c:when test="${userSession == null}">
						<div class="col-md-6">
							<div class="header-top-right" style="padding-top: 15px;">
								<span class="login"> <i class="fa fa-lock"></i> <a
									href="LoginServlet">Login</a>
								</span> <span class="register"> <i class="fa fa-pencil-square-o"></i>
									Not a member? <a href="RegisterServlet">Register</a>
								</span>
							</div>
						</div>
					</c:when>
					<c:otherwise>

						<div class="col-md-4">
							<div class="header-top-right" style="padding-top: 15px;">
								<span class="login"> Welcome, <span class="entry-meta"
									style="color: #dc2a0b; font-size: medium;">
										${userSession.email} </span> <i class="fa fa-lock"></i> <a
									href="LogoutServlet">logout</a>
								</span>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	</header>


	<div class="weather-map-content">
		<div class="weather-content">
			<h3>Forecast for ${param.cityDestination}</h3>
		</div>

		<div id="map"></div>

		<div id="summaryPanel"></div>

	</div>

	<div>
		<span id="citySource" style="display: none;">${param.citySource}</span>
		<span id="cityDestination" style="display: none;">${param.cityDestination}</span>
	</div>


	<footer class="footer" id="footer">
	<div class="footer-copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					Copyright &copy; 2017 <a href="LoginServlet">Carpooling</a> &nbsp;|
					&nbsp;All Rights Reserved
				</div>
				<div class="col-sm-6 col-md-8"></div>
			</div>
		</div>
	</div>
	</footer>

</body>

</html>