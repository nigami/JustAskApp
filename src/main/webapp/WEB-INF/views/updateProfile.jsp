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
							<li><a href="#">Change Password</a></li>
							<li><a href="">Update Profile</a></li>
							
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

				<div class="row" id="navPillSection">
					<ul class="nav nav-pills nav-stacked">
						<li class="active"><a data-toggle="pill" href="#home">Personal</a></li>
						<li><a data-toggle="pill" href="#menu1">Account</a></li>
						<li><a data-toggle="pill" href="#menu2">Contact</a></li>
						<li><a data-toggle="pill" href="#menu3">Activity log</a></li>
					</ul>

					<div class="clearfix visible-lg"></div>
				</div>

			</div>

		</div>

		<div class="col-lg-8">
			<div class="row headingbackground">
				<div class="askForUpdateHeading">
				
					<div>	<h2 class="btmPaddding">Settings:</h2></div>
					<div class="btmPaddding">You can update your profile by selecting appropriate tabs on the left side.</div>
					<br />
					<div class="btmPaddding">For Instance: For updating personal Information (eg: first name, email address): Choose 'Personal' tab from the left menu, you can directly type in updated information and hit 'Save' to save this information.<br/>
						You can also view and update reviews provided by you from Activity log.
					</div>
				</div>
			</div>

			<div class="row">

				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						<h3>Personal Information</h3>
						<form:form action="signUp.htm" commandName="user"
							id="personalAccInfo" method="POST">

							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="firstnamelabel"><font
										color="red">* </font> First name</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control"
										id="firstnameinput" aria-describedby="firstnameinput"
										path="firstName" placeholder="First Name" required="true" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="lastnamelabel"><font
										color="red">* </font> Last name</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="lastnameinput"
										aria-describedby="lastnameinput" path="lastName"
										placeholder="Last Name" required="true" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="emaillabel"><font
										color="red">* </font> Email address</label>
								</div>
								<div class="col-lg-6">
									<form:input type="email" class="form-control" id="emailinput"
										aria-describedby="emailinput" path="email" placeholder="Email"
										required="true" />
								</div>
							</div>

							<div>
								<button type="button" class="btn btn-primary"
									id="personalUpdate">Update</button>
							</div>
							<div id="personalConfSection">
								<div class="col-lg-2">
									<button type="button" class="btn btn-success yesPersonal">Review
										Changes</button>
								</div>
								<div class="col-lg-2">
									<button type="button" class="btn btn-danger no">Cancel</button>
								</div>
								<div class="col-lg-8"></div>
							</div>
						</form:form>
					</div>
					<div id="menu1" class="tab-pane fade">
						<h3 class="col-lg-6">Account Information</h3>
						<form:form action="signUp.htm" commandName="user" id="newmember"
							method="POST">
							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="usernamelabel"><font
										color="red">* </font>Username</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="usernameinput"
										aria-describedby="usernameinput" path="username"
										placeholder="Username" required="true" disabled="true"
										onkeyup="myUsernameChk(this)" />
								</div>

								<div class="usernameEdit">
									<div class="editGlyph col-lg-6 ">
										Edit <i class="fa fa-pencil text-primary fa-1x"></i>
									</div>
									
								</div>
								<div>
									<div id="usernameError" class="col-lg-12"></div>
								</div>
								<div id="savedUser" class="col-lg-12"><i class="fa fa-check text-success fa-2x" aria-hidden="true"></i></div>
								
								<div class="accountBtnDisplay col-lg-12">
									<button type="button" class="btn btn-primary"
										id="accountButton" disabled="disabled">Update</button>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="passwordlabel"><font
										color="red">* </font>Password</label>
								</div>
								
								<div class="col-lg-6">
									<form:input type="password" class="form-control"
										id="passwordinput" path="password" placeholder="Password"
										required="true" disabled="true" />
									<div id="passwordUpdateSec">
										Old Password:
										<form:input type="password" class="form-control"
											id="passwordOld" path="" placeholder="Password"
											required="true" disabled="false"
											onkeyup="myPasswordChk(this)" />
										<div id="passwordError"></div>

										New Password:
										<form:input type="password" class="form-control"
											id="passwordnew" path="" placeholder="Password"
											required="true" disabled="true" />
										Confirm Password:
										<form:input type="password" class="form-control"
											id="passwordConfirm" path="" placeholder="Password"
											required="true" disabled="true" onkeyup="confirmPwd(this)" />
										<div class="col-lg-12">
											<button type="button" class="btn btn-primary"
												id="updatePwdButton" disabled="disabled">Update</button>
										</div>
									</div>
								</div>
								<div class="editGlyph col-lg-6 passwordEdit">
									Edit <i class="fa fa-pencil text-primary fa-1x"></i>
								</div>
								<div id="passwordValidation" class="col-lg-12"></div>
								<div id="savedPassword"><i class="fa fa-check text-success fa-2x" aria-hidden="true"></i></div>
							</div>

							<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="userTypelabel"><font
										color="red">* </font>UserType</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="userTypelabel"
										path="userType" placeholder="UserType" readonly="true"
										required="true" />
								</div>
							</div>


						</form:form>

					</div>
					<div id="menu2" class="tab-pane fade col-lg-12">
						<h3 class="col-lg-5">Address Information</h3>
						
						<div class="addressEdit col-lg-1">
									<div class="editGlyph col-lg-6 ">
										Edit <i class="fa fa-pencil text-primary fa-1x"></i>
									</div>
						</div>
						<div id="addrMessage" class="col-lg-12"></div>
						
						<div class="row">
						
							<form:form action="signUp.htm" commandName="user" id="newmember"
								method="POST">
								<div class="form-group row">
									<div class="col-lg-12">
										<label class="control-label labelColor" for="addrline1Label"><font
										color="red">* </font> Address Line1</label>
									</div>
									<div class="col-lg-6">
									<form:input type="text" class="form-control" id="addrline1Label"
										aria-describedby="addrline1input" path="address.addrLine1"
										placeholder="AddressLine1" required="true" disabled="true" />
									</div>
								</div>
	
								<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="addrLine2Label"><font
										color="red">* </font> Address Line2</label>
									</div>
									<div class="col-lg-6">
									<form:input type="text" class="form-control" id="addrLine2Label"
										aria-describedby="addrLine2input" path="address.addrLine2"
										placeholder="AddressLine2" disabled="true" />
									</div>
								</div>
	
								<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="citylabel"><font
										color="red">* </font>City</label>
									</div>
									<div class="col-lg-6">
									<form:input type="text" class="form-control" id="citylabel"
										aria-describedby="cityinput" path="address.city"
										placeholder="City" required="true" disabled="true" />
									</div>
								</div>
	
								<div class="form-group row">
									<div class="col-lg-12">
									<label class="control-label labelColor" for="statelabel"><font
										color="red">* </font>State</label>
									</div>
									<div class="col-lg-6">
									<form:input type="text" class="form-control" id="statelabel"
										aria-describedby="stateinput" path="address.state"
										placeholder="State" required="true" disabled="true" />
									</div>
								</div>
	
								<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="cntrylabel"><font
										color="red">* </font>Country</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="cntrylabel"
										path="address.country" placeholder="Country" required="true" disabled="true" />
								</div>
								</div>
	
								<div class="form-group row">
								<div class="col-lg-12">
									<label class="control-label labelColor" for="ziplabel"><font
										color="red">* </font>Zip Code</label>
								</div>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="ziplabel"
										path="address.zipcode" placeholder="ZipCode" required="true" disabled="true" />
								</div>
								</div>
	
								<div class="row">
									<button type="button" id="addressUpdateBtn" class="btn btn-primary " disabled="disabled">Update</button>
								</div>
							</form:form>
						</div>
					</div>
					<div id="menu3" class="tab-pane fade">
						<h3>Activity Log</h3>
						<p>Last reviews provided are as follows:</p>
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
									<td><c:out value="${count.index+1}"></c:out></td>
	                                <td><input value="${review.dateOfReview}" required readonly="readonly"/></td>
	                                <td><input value="${review.venueId}" required readonly="readonly"/></td>
	                                <td><textarea class="editManage${review.reviewId}" id="reviewDesc${review.reviewId}" required readonly="readonly" >${review.description}</textarea></td>
	                                <td><input type="number" class="editManage${review.reviewId}"  id="reviewCostEff${review.reviewId}" value="${review.costEff}" required readonly="readonly" max="10000"/></td>
	                                <td><input type="number"  class="editManage${review.reviewId}"  id="reviewRating${review.reviewId}" value="${review.rating}" required readonly="readonly" max="5" min="1"/></td>
	                            	<td><input type="button" class="btn btn-danger" value="Delete" onclick="deleteReview(${review.reviewId})"/></td>
	                            	<td><input id="editBtn${review.reviewId}" type="button" class="btn btn-default" value="Edit" onclick="editReview(${review.reviewId})"/></td>
	                            	<td><input id="saveBtn${review.reviewId}" type="button" class="btn btn-primary" value="Save it" onclick="saveReview(${review.reviewId})" disabled/></td>
	                            </tr>
							</c:forEach>
							</tbody>
							</table>
					<!-- 	</div> -->
					</div>
				</div>
			</div>

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