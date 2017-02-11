<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/updateProfile.css">
<script type="text/javascript" src="resources/js/updateProfile.js"></script>
<script type="text/javascript" src="resources/js/jaDashBoardUser.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/weather.css">
<script type="text/javascript" src="resources/js/weatherWidget.js"></script>
<script type="text/javascript" src="resources/js/prefixfree.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/jaDashBoardUser.css">
<body>
	<nav class="navbar navbar-inverse  navbar-fixed-top">
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
				<a class="navbar-brand" href="./dashboard.htm">Just Ask!!</a>

			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="./dashboard.htm">Home <span
							class="sr-only">(current)</span></a></li>
					
				</ul>
				
				<!--   <p class="navbar-text navbar-right"><a href="#" class="navbar-link">  </a></p> -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./preciousVenue.htm">My Precious<i class="fa fa-shopping-cart text-warning" aria-hidden="true"></i></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${requestScope.username} <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="updateProfile.htm#menu1">Change Password</a></li>
							<li><a href="#"><div id="updateProfile">Update Profile</div></a></li>
							
							<li role="separator" class="divider"></li>
							<li><a href="#"><div class="logout">LogOut <i class="fa fa-power-off" aria-hidden="true"></i></div></a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container-fluid topPaddingContainer">
		<div id="home" class="col-lg-2">
			<div class="leftPanelSection">
				<div class="row">
					<span class="glyphicons glyphicons-align-center"></span>
					<script type="text/javascript"
						src="http://100widgets.com/js_data.php?id=106"></script>
				</div>

		

			</div>

		</div>

		<div class="col-lg-8"><!-- center section Start -->
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
							<img class="logoResize img-rounded img-thumbnail" id="imageId"
							src="resources/images/${requestScope.venue.venueImgLocation}" alt="PlaceToVisit" />
					</div>
					<div class="col-lg-8">
						<div class="row">
							<h1>${requestScope.venue.venueName}</h1>
							<span>${requestScope.venue.venueRange}</span>
								<c:choose>
								    <c:when test="${requestScope.venue.venueRange<100}">
								        <i class="fa fa-usd text-success" aria-hidden="true"></i>
								        <br />
								    </c:when> 
								    <c:when test="${requestScope.venue.venueRange<200}">
								        <i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i>
								        <br />
								    </c:when>
								    <c:when test="${requestScope.venue.venueRange<300}">
								        <i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i>
								        <br />
								    </c:when>    
								    <c:otherwise>
								       <i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i><i class="fa fa-usd text-success" aria-hidden="true"></i>
								        <br />
								    </c:otherwise>
								</c:choose>
						</div>
						<div class="row">
						<br /><br />
							<h3><label class="control-label labelCustomize">Address:</label></h3>
							<label class="control-label valueCustomize" >${requestScope.venue.venueAddress.addrLine1},</label><br />
							<label class="control-label valueCustomize">${requestScope.venue.venueAddress.addrLine2},</label><br />
							<label class="control-label valueCustomize">${requestScope.venue.venueAddress.city},</label>
							<label class="control-label valueCustomize">${requestScope.venue.venueAddress.state},</label><br />
							<label class="control-label valueCustomize">${requestScope.venue.venueAddress.country},</label>
							<label class="control-label valueCustomize">${requestScope.venue.venueAddress.zipcode}</label><br />
						</div>	
					</div>
					
				</div>
				<div class="row">
					<h3>Description:</h3>
					<br />
					${requestScope.venue.venueDesc}
				</div>
				<div class="row">
				<br />
				<br />
					<h3>Reviews:</h3>
						<!-- <div class="table-responsive"> -->
							<table class="table table-striped  table-hover" id="reviewTable">
								<thead class="thead-inverse" >
									<tr>
	                                    <th> #</th>
	                                    <th>Date of Review</th>
	                                    <th>Venue Name</th>
	                                    <th>Review Comments</th>
	                            		<th>Cost for two</th>
	                                    <th>Rating</th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="review" items="${requestScope.reviewList}" varStatus="count">
								<tr id="review${review.reviewId}" >
									<td></td>
	                                <td><c:out value="${review.dateOfReview}" /></td>
	                                <td><c:out value="${review.venueId}"/></td>
	                                <td><i class="fa fa-quote-left" aria-hidden="true"></i>  <c:out value="${review.description}"/>  <i class="fa fa-quote-right" aria-hidden="true"></i></td>
	                                <td><c:out value="${review.costEff}"/></td>
	                                <td><c:out value="${review.rating}" /></td>
	                            </tr>
	                         
							</c:forEach>
							</tbody>
							</table>
					
				</div>
			</div>
		</div>	<!-- center section end -->
		
		
		<div class="col-lg-1 rightPanel">
			<div class="row">
				<div id="weatherDiv">
					<a
						href="http://www.accuweather.com/en/us/boston-ma/02108/weather-forecast/348735"
						class="aw-widget-legal"> <!--
						By accessing and/or using this code snippet, you agree to AccuWeather’s terms and conditions (in English) which can be found at http://www.accuweather.com/en/free-weather-widgets/terms and AccuWeather’s Privacy Statement (in English) which can be found at http://www.accuweather.com/en/privacy.
						-->
					</a>
					<div id="awcc1460090223500" class="aw-widget-current"
						data-locationkey="" data-unit="f" data-language="en-us"
						data-useip="true" data-uid="awcc1460090223500"></div>
					<script type="text/javascript"
						src="http://oap.accuweather.com/launch.js"></script>
				</div>
			</div>


		</div>

	</div>
	<!-- end of main container fluid -->

</body>
</html>