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
<link rel="stylesheet" type="text/css"
	href="resources/css/jaDashBoardUser.css">
<script type="text/javascript" src="resources/js/manageUser.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"	href="resources/css/manageUser.css">
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
	<div class="container-fluid topPaddingContainer">
		<h2> User Detailed list: </h2>
		<table class="table" id="userTable">
								<thead class="thead-default" >
									<tr>
	                                    <th> #</th>
	                                    <th>Username</th>
	                                    <th>First Name</th>
	                                    <th>Last Name</th>
	                            		<th>email</th>
	                                    <th>Address</th>
	                                    <th></th><th></th>
	                                </tr>
								</thead>
								 <tbody>
							<c:forEach var="user" items="${requestScope.userlist}" varStatus="count">
								<tr id="user${user.personId}" >
									<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><c:out value="${user.username}"/></td>
	                                <td><c:out value="${user.firstName}"/></td>
	                                <td><c:out value="${user.lastName}" /></td>
	                                <td id="email${user.personId}"><c:out value="${user.email}" /></td>
	                                <td><textarea cols="30" id="address${user.personId}"  required readonly="readonly" > ${user.address.addrLine1},${user.address.addrLine2}, ${user.address.city}, ${user.address.state},${user.address.zipcode},	 ${user.address.country} </textarea></td>
	                            	<td><input type="button" class="btn btn-default" value="View Reviews" id="viewReviewBtn${user.personId}" onclick="viewReview(${user.personId})"/></td>
	                           		
	                          		<c:choose>
									   <c:when test="${user.blacklist == true}">
									      <td id="unblockBtnSection${user.personId}"><input type="button" class="btn btn-success" value="Unblock" onclick="unblockUser(${user.personId})" id="unblock${user.personId}"/></td>
									    </c:when>
									    <c:otherwise>
									      <td id="deleteBtnSection${user.personId}"><input type="button" class="btn btn-danger" value="Block" onclick="deleteUser(${user.personId})" id="delete${user.personId}"/></td>
									    </c:otherwise>
								   </c:choose>
								   
	                           </tr>
	                           <tr class="review${user.personId} hide">
	                           		<td colspan="8">
			                           	<div class="panel-body mainReview alert-success">
				                           	  <table class="table table-striped  table-hover" id="reviewTable${user.personId}">
												<thead class="thead-inverse" >
													<tr>
					                                    <th> #</th>
					                                    <th>Date of Review</th>
					                                    <th>Venue Name</th>
					                                    <th>Review Comments</th>
					                            		<th>Cost for two</th>
					                                    <th>Rating</th>
					                                    <th></th>
					                                </tr>
												</thead>
												 <tbody id="reviewTableBody${user.personId}">
												
											</tbody>
											</table>
			                           	</div>
	                           		</td>
	                           </tr>
	                         
							</c:forEach>
							</tbody>
							</table>
		
	</div>
	<!-- end of main container fluid -->

</body>
</html>