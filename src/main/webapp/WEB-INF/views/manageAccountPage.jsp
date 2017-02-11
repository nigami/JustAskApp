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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="resources/css/updateProfile.css">
<script type="text/javascript" src="resources/js/updateProfile.js"></script>
<script type="text/javascript" src="resources/js/jaDashBoardUser.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/jaDashBoardUser.css">
	
<link rel="stylesheet" type="text/css"
	href="resources/css/adminAnalytic.css">
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.js"></script></head>
<script type="text/javascript" src="resources/js/adminAnalytic.js"></script>
</head>
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
				<a class="navbar-brand" href="#">Just Ask!! </a>

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
				<!-- 	<li><a href="./preciousVenue.htm">My Precious<i class="fa fa-shopping-cart text-warning" aria-hidden="true"></i></a></li> -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${requestScope.username}AdminProfile</a>
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
	<div class="topContent">
	<div class="">
		<ul id="sideMenu">
		  <li><a class="active" href="#" onclick="hideShow(home)">Dashboard</a></li>
		 <!--  <li><a href="#news" onclick="hideShow(news)">News</a></li>
		  <li><a href="#contact" onclick="hideShow(news)">Contact</a></li>
		  <li><a href="#about" onclick="hideShow(news)">About</a></li> -->
		</ul>
	</div>
		<div id="dashboard">
			<div class="row customizeRow" >
			<!-- <div class="col-lg-12"> -->
			<div class=" col-lg-2">	</div>
				<div class="customizeColumn1 col-lg-5"> <div id="chartContainer" style="height: 300px; width: 100%;">
  </div>	</div>
				<div class="customizeColumn2 col-lg-5"><div id="chartContainer2" style="height: 300px; width: 100%;">
	</div></div>
		<!-- 		</div> -->
			</div>
			<div class="row customizeRow">
		<!-- 	<div class="col-lg-12"> -->
		<div class=" col-lg-2">	</div>
				<div class="customizeColumn3 col-lg-5">
					<div class="userAnalysisSec">
						<h3 class="centerAlign">Account Statistics: </h3>
						<hr />
						<div class="col-lg-3">
							<label for="popularUser" class="control-label">Most Active User:</label>
						</div>
						<div class="col-lg-9">
							<div class="col-lg-8">
								<input type="text" id="popularUser" class="form-control" readonly value="${requestScope.usernameMax}">
							</div>
							<div class="col-lg-4">
								<button type="button" class="btn btn-success" value="Details" id="ruchi" onclick="getDetails()">Details</button>
							</div>
						</div>
						
						
						<div class="col-lg-12">
						<br>
						<h4 class="centerAlign">Top Venue's Statistics: </h4>
						<hr /><div class="tablescroll">
								<table class="table table-bordered  table-hover" id="venueTable">
									<thead class="thead-inverse" >
										<tr>
		                                    <th> #</th>
		                                   
		                                    <th>Id</th>
		                                     <th>Create date</th>
		                                    <th>Venue Name</th>
		                                    <th>Reviews Count</th>
		         							<th>Rating</th>
		                                </tr>
									</thead>
									 <tbody>
								<c:forEach var="venue" items="${requestScope.topVenueList}" varStatus="count">
									<tr id="venue${venue.venueId}" >
										<td><c:out value="${count.index+1}"></c:out></td>
		                               <td><c:out value="${venue.venueId}" /></td>
		                               <td><c:out value="${venue.startDate}" /></td>
		                                <td><c:out value="${venue.venueName}" /></td>
		                                <td><c:out value="${venue.reviewCount}" /></td>
		                                <td><c:out value="${venue.rating}" /></td>
		                           </tr>
								</c:forEach>
								</tbody>
								</table>
							</div>
						</div>
					</div>
					
		
				</div>
				<div class="customizeColumn4 col-lg-5">
					<div id="noUserDetail" class="centerAlign topMargin">Click on "Details Button" on user to view user details</div> 
					<div class="userDetail col-lg-12">
						<h3 class="centerAlign">User Details: </h3><hr />
						<div class="col-lg-3"><label class="control-value">Username: </label></div>
						<div class="col-lg-9"><input type="text" class="form-control" value="${requestScope.userMax.username } " readonly/></div>
						<br /><br />
						<%-- Full Name: <c:out value="${requestScope.userMax.firstName}"/> <c:out value="${requestScope.userMax.lastName}"/> --%>
						<div class="col-lg-3"><label class="control-value">Full Name: </label></div>
						<div class="col-lg-9"><input type="text"  class="form-control" value="${requestScope.userMax.firstName} ${requestScope.userMax.lastName}" readonly/></div>
						<br /><br />
						
						<div class="col-lg-12">
							<label class="control-value">Contact Info: </label>
						</div><br />
						
						
						<br />
						<div class="col-lg-3"><label class="control-value">Email: </label></div>
						<div class="col-lg-9"><input type="text" class="form-control" value="${requestScope.userMax.email}" readonly/></div>
						<br />	<br />
					
						<div class="col-lg-3"><label class="control-value">Address: </label></div>
						<div class="col-lg-9"><textarea class="form-control" readonly>${requestScope.userMax.address.addrLine1},${requestScope.userMax.address.city}</textarea>
					</div>
				</div>
		
			
			</div>
		</div>
	</div>
	<div class="row" id="about">Ila</div>
	<script type="text/javascript" src="resources/js/adminDetail.js"></script>
</body>
</html>