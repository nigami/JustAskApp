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

		<div class="col-lg-8">
			<div class="row">
				            <ul class="nav nav-tabs" id="myTab">
			  <li class="active"><a data-target="#home" data-toggle="tab">Home</a></li>
			  <li><a data-target="#profile" data-toggle="tab">Saved Favourite List</a></li>
			  <li><a data-target="#messages" data-toggle="tab">Visited List</a></li>
			 
			</ul>

			<div class="tab-content">
			  <div class="tab-pane active" id="home">
			  
			  <h3>Please select list favourite/Visited </h3>
			  
			  </div>
			  
			  <div class="tab-pane" id="profile">
			 <h3> Saved Favourite List: </h3>
			  
			  	 <div class="row">
			          <table class="table table-hover" id="reviewTable">
								<thead class="thead-inverse" >
									<tr>
	                                    <th> #</th>
	                                    <th>home Name</th>
	                                    <th>Venue Type</th>
	                                    <th>Description</th>
	                            		<th>Cost for two</th>
	                                    <th>Address</th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="venue" items="${requestScope.favList}" varStatus="count">
								<tr id="venue${venue.venueId}" >
									<%--<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><input value="${venue.venueName}" required readonly="readonly"/></td>
	                                <td><input value="${venue.venueType}" required readonly="readonly"/></td>
	                                <td><textarea class="editManage${venue.venueId}" id="venueDesc${venue.venueId}" required readonly="readonly" >${venue.venueDesc}</textarea></td>
	                                <td><input type="number" class="editManage${venue.venueId}"  id="venueCostEff${venue.venueId}" value="${venue.venueRange}" required readonly="readonly" max="10000"/></td>
	                                <td><input type="text"  class="editManage${venue.venueId}"  id="venueAddress${venue.venueId}" value="${venue.venueAddress.addrLine1}" required readonly="readonly" /></td>
	                            	 <td><input type="button" class="btn btn-danger" value="Delete" onclick="deleteReview(${venue.venueId})"/></td>
	                            	<td><input id="saveBtn${venue.venueId}" type="button" class="btn btn-primary" value="Save it" onclick="saveReview(${venue.venueId})" disabled/></td>
	                            --%>
	                            <td><c:out value="${count.index+1}"></c:out></td>
	                                <td><a onclick="getVenueDetail(${venue.venueId})"><c:out value="${venue.venueName}" /></a></td>
	                                <td><c:out value="${venue.venueType}" /></td>
	                                <td><c:out value="${venue.venueDesc }" /></td>
	                                <td><c:out value="${venue.venueRange}" /></td>
	                                <td><c:out  value="${venue.venueAddress.addrLine1},${venue.venueAddress.city},${venue.venueAddress.country }" /></td>
	                            	 
	                            </tr>
							</c:forEach>
							</tbody>
							</table>
					</div>
			  </div>
			  <div class="tab-pane" id="messages">
			   <h3> Visited List: </h3>
			   <div class="row">
			          <table class="table table-hover" id="reviewTable">
								<thead class="thead-inverse" >
									<tr>
	                                    <th> #</th>
	                                    <th>home Name</th>
	                                    <th>Venue Type</th>
	                                    <th>Description</th>
	                            		<th>Cost for two</th>
	                                    <th>Address</th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="venue" items="${requestScope.visitedList}" varStatus="count">
								<tr id="venue${venue.venueId}" >
									<%--<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><input value="${venue.venueName}" required readonly="readonly"/></td>
	                                <td><input value="${venue.venueType}" required readonly="readonly"/></td>
	                                <td><textarea class="editManage${venue.venueId}" id="venueDesc${venue.venueId}" required readonly="readonly" >${venue.venueDesc}</textarea></td>
	                                <td><input type="number" class="editManage${venue.venueId}"  id="venueCostEff${venue.venueId}" value="${venue.venueRange}" required readonly="readonly" max="10000"/></td>
	                                <td><input type="text"  class="editManage${venue.venueId}"  id="venueAddress${venue.venueId}" value="${venue.venueAddress.addrLine1}" required readonly="readonly" /></td>
	                            	 <td><input type="button" class="btn btn-danger" value="Delete" onclick="deleteReview(${venue.venueId})"/></td>
	                            	<td><input id="saveBtn${venue.venueId}" type="button" class="btn btn-primary" value="Save it" onclick="saveReview(${venue.venueId})" disabled/></td>
	                            --%>
	                            <td><c:out value="${count.index+1}"></c:out></td>
	                                <td><a onclick="getVenueDetail(${venue.venueId})"><c:out value="${venue.venueName}" /></a></td>
	                                <td><c:out value="${venue.venueType}" /></td>
	                                <td><c:out value="${venue.venueDesc }" /></td>
	                                <td><c:out value="${venue.venueRange}" /></td>
	                                <td><c:out  value="${venue.venueAddress.addrLine1},${venue.venueAddress.city},${venue.venueAddress.country }" /></td>
	                            	 
	                            </tr>
							</c:forEach>
							</tbody>
							</table>
					</div>
			  </div>
			 
			</div>
			</div>

				<%--  <div id="my-tab-content" class="tab-content">
			 	 <div class="tab-pane active" id="home">
			         <div class="row">
			          <table class="table table-hover" id="reviewTable">
								<thead class="thead-inverse" >
									<tr>
	                                    <th> #</th>
	                                    <th>home Name</th>
	                                    <th>Venue Type</th>
	                                    <th>Description</th>
	                            		<th>Cost for two</th>
	                                    <th>Address</th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="venue" items="${requestScope.favList}" varStatus="count">
								<tr id="venue${venue.venueId}" >
									<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><input value="${venue.venueName}" required readonly="readonly"/></td>
	                                <td><input value="${venue.venueType}" required readonly="readonly"/></td>
	                                <td><textarea class="editManage${venue.venueId}" id="venueDesc${venue.venueId}" required readonly="readonly" >${venue.venueDesc}</textarea></td>
	                                <td><input type="number" class="editManage${venue.venueId}"  id="venueCostEff${venue.venueId}" value="${venue.venueRange}" required readonly="readonly" max="10000"/></td>
	                                <td><input type="text"  class="editManage${venue.venueId}"  id="venueAddress${venue.venueId}" value="${venue.venueAddress.addrLine1}" required readonly="readonly" /></td>
	                            	 --%><%-- <td><input type="button" class="btn btn-danger" value="Delete" onclick="deleteReview(${venue.venueId})"/></td>
	                            	<td><input id="saveBtn${venue.venueId}" type="button" class="btn btn-primary" value="Save it" onclick="saveReview(${venue.venueId})" disabled/></td>
	                           <td><c:out value="${count.index+1}"></c:out></td>
	                                <td><a><c:out value="${venue.venueName}" /></a></td>
	                                <td><c:out value="${venue.venueType}" /></td>
	                                <td><c:out value="${venue.venueDesc }" /></td>
	                                <td><c:out value="${venue.venueRange}" /></td>
	                                <td><c:out  value="${venue.venueAddress.addrLine1},${venue.venueAddress.city},${venue.venueAddress.country }" /></td>
	                            	 
	                            </tr>
							</c:forEach>
							</tbody>
							</table>
					</div>
		        </div>
			 
			 <div class="tab-pane" id="profile">
				<div class="row">
						<table class="table table-hover" id="reviewTable">
								<thead class="thead-inverse" >
									<tr>
	                                    <th> #</th>
	                                    <th>profile Name</th>
	                                    <th>Venue Type</th>
	                                    <th>Description</th>
	                            		<th>Cost for two</th>
	                                    <th>Address</th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="venue" items="${requestScope.favList}" varStatus="count">
								<tr id="venue${venue.venueId}" >
									<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><input value="${venue.venueName}" required readonly="readonly"/></td>
	                                <td><input value="${venue.venueType}" required readonly="readonly"/></td>
	                                <td><textarea class="editManage${venue.venueId}" id="venueDesc${venue.venueId}" required readonly="readonly" >${venue.venueDesc}</textarea></td>
	                                <td><input type="number" class="editManage${venue.venueId}"  id="venueCostEff${venue.venueId}" value="${venue.venueRange}" required readonly="readonly" max="10000"/></td>
	                                <td><input type="text"  class="editManage${venue.venueId}"  id="venueAddress${venue.venueId}" value="${venue.venueAddress.addrLine1}" required readonly="readonly" /></td>
	                            	 --%><%-- <td><input type="button" class="btn btn-danger" value="Delete" onclick="deleteReview(${venue.venueId})"/></td>
	                            	<td><input id="saveBtn${venue.venueId}" type="button" class="btn btn-primary" value="Save it" onclick="saveReview(${venue.venueId})" disabled/></td>
	                           <td><c:out value="${count.index+1}"></c:out></td>
	                                <td><a><c:out value="${venue.venueName}" /></a></td>
	                                <td><c:out value="${venue.venueType}" /></td>
	                                <td><c:out value="${venue.venueDesc }" /></td>
	                                <td><c:out value="${venue.venueRange}" /></td>
	                                <td><c:out  value="${venue.venueAddress.addrLine1},${venue.venueAddress.city},${venue.venueAddress.country }" /></td>
	                            	 
	                            </tr>
							</c:forEach>
							</tbody>
							</table>
				
				</div>	
			</div> 
			
			</div>--%>
			<div id="row">
				<div id="mainSection2"></div>
			</div>

		</div>
		<!-- center section end -->
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