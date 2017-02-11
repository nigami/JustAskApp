<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your dash-board: JustAsk</title>

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
<link rel="stylesheet" type="text/css"	href="resources/css/jaDashBoardUser.css">
<link rel="stylesheet" type="text/css"	href="resources/css/reviewSearchIndex.css">
<script type="text/javascript" src="resources/js/jaDashBoardUser.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/weather.css">
<script type="text/javascript" src="resources/js/weatherWidget.js"></script>
<script type="text/javascript" src="resources/js/prefixfree.min.js"></script>
<script type="text/javascript" src="resources/js/infiniteScrolling.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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
					<li class="active"><a href="#">Home <span
							class="sr-only">(current)</span></a></li>
					<li><a href="#"><div id="restaurentSpecific">Restaurants</div></a></li>
					
				</ul>
				
				<!--   <p class="navbar-text navbar-right"><a href="#" class="navbar-link">  </a></p> -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./preciousVenue.htm">My Precious<i class="fa fa-shopping-cart text-warning" aria-hidden="true"></i></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${requestScope.username} <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<!-- <li><a href="updateProfile.htm#menu1">Change Password</a></li> -->
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
	<div class="container-fluid topalignment">
		<div id="home" class="col-lg-2">
			<div class="leftPanel">
				<span class="glyphicons glyphicons-align-center"></span>
				<script type="text/javascript"
					src="http://100widgets.com/js_data.php?id=106"></script>
			</div>
		</div>

		<div class="col-lg-8">
			<div class="row reviewColorBg">
				<div class="askForReview">
				
					<div class="col-lg-12 panel-body reviewColorBg">
						<h2 class="col-lg-offset-1 col-lg-4">Write a review:</h2>
						
						<div class="col-lg-7 addAddressClass">
						<!-- <label for="comment" class="col-lg-4">Name of Venue:</label> -->
							 <div class="form-group col-lg-offset-3 col-lg-6 ">
							   <!--  <input type="text" class="form-control" placeholder="Search"> -->
							      <section class="main">
								 <form class="reviewSearch">
									 <input id="ilaInput" type="text" name="q" placeholder="Search..." />
									 <ul class="reviewSearchResult" >
									 	<c:forEach var="venue" items="${requestScope.venueList}" varStatus="count">
											 <li id="${venue.venueId}"><a href="#"> ${venue.venueName},<br /><span> <em>${venue.venueDesc}</em> </span></a></li>
											<!--  <li  id="10"><a href="#">Rurry Center,<br /><span>Longwoord</span></a></li>
									 		 <li id="16"><a href="#">Cutlet Center,<br /><span>New Restaurant with great dining ambience and rates!</span></a></li> -->
							         	</c:forEach>
									 </ul>
								 </form>
							</section>
							  </div>
							 
						<!-- 	<button type="button" class="btn btn-primary col-lg-2 " form="">Add</button> -->
						</div>
						
						<div class="col-lg-offset-1 col-lg-11"><div id="reviewSearchError"></div></div>
					</div>
						
			
					
					<div class="col-lg-1"></div>
					<div class="col-lg-9">
					  <div class="row">
							  <div id="reviewAddAddress" class="col-lg-12">
							  	<div id="reviewVenueName" class="col-lg-12"></div>
							  <!-- 	<div id="reviewOtherInfo" class="col-lg-4"></div> -->
							  </div>
							
							  
							    <br />
							  <!-- 	Rating:  <i class="fa fa-star reviewStar" aria-hidden="true"></i><i class="fa fa-star reviewStar" aria-hidden="true"></i><i class="fa fa-star reviewStar" aria-hidden="true"></i><i class="fa fa-star reviewStar" aria-hidden="true"></i><i class="fa fa-star reviewStar" aria-hidden="true"></i>
							 -->  
							 
							  <div class="costEffSect">
					  	 		<div class="col-lg-8">Cost Effectiveness for 2 people: <input  class="form-control" type="number" id="costEff" autocomplete="on"/></div>
					  		 	<div class="col-lg-4">Rating 
					  		 		<select  class="form-control" id="rating">
					  		 			<option value="1">1</option>
					  		 			<option value="2">2</option>
					  		 			<option value="3">3</option>
					  		 			<option value="4">4</option>
					  		 			<option value="5">5</option>
					  		 		</select>
					  		 	</div>
					  		 </div>	
					  	</div>
					  	
					  <div class="form-group comment">
					  	 <!--  <label for="comment">Comment:</label> -->
						  <textarea class="form-control" rows="3" id="comment" required placeholder="Enter Review Comments........."></textarea>
					  </div>
					</div>

					<div>
						<button type="button" id="addExistVenueReview" data-toggle="modal" data-target="#becomeamember" class="btn btn-warning btnblock" >Add new venue</button>
			   <!-- Modal Become a member -->
					        <form  id="newmember" action="addNewVenue.htm" method="POST">
					        <div class="modal fade" id="becomeamember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					          <div class="modal-dialog">
					            <div class="modal-content">
					              <div class="modal-header">
					                 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					               
					              <h3 class="modal-title labelColor" id="myModalLabel" ><font color="black">Add New Venue</font></h3>
					              
					              </div>
					              <div class="modal-body form-inline ">
					                <div class="form-group">
					                    <label class="control-label labelColor" for="venueName"><font color="red">* </font> Venue Name</label>
					                    <input type="text" class="form-control" id="venueName" name="venueName" aria-describedby="venueName" placeholder="Enter Venue Name"  required/>
					                 </div>
					                
					                <div class="form-group ">
					                    <label class="control-label labelColor" for="venueDesc"><font color="red">* </font> Venue Description</label>
					                    <textarea class="form-control" id="venueDesc" name="venueDesc" aria-describedby="venueDesc"   placeholder="Enter Venue Description" required maxlength="100"></textarea>
					                </div>
					                
					                <div class="form-group">
					                    <label class="control-label labelColor" for="venueRange"><font color="red">* </font> Venue Range for two</label>
					                    <input type="number" class="form-control" id="venueRange" name="venueRange" aria-describedby="venueRange"  placeholder="00.00" required/>
					                </div>
					                
					                 <%-- <div class="form-group">
					                    <label class="control-label labelColor" for="venueRating"><font color="red">* </font> Venue Rating</label>
					                    <form:select class="form-control" id="venueRating" name="venueType" aria-describedby="venueRating" required>
					                    	<option value="0" >Please select...</option>
					                    	<option value="1">1</option>
					                    	<option value="2">2</option>
					                    	<option value="3">3</option>
					                    	<option value="4">4</option>
					                    	<option value="5">5</option>
					                    </form:select>
					                </div> --%>
					                
					                <div class="form-group">
					                    <label class="control-label labelColor" for="venueType"><font color="red">* </font> Venue Type</label>
					                    <select class="form-control" id="venueType"   name="venueType"  aria-describedby="venueType" required>
					                    	<option value="NA">Please select...</option>
					                    	<option value="R">Restaurant</option>
					                    	<option value="P">Party Lounges</option>
					                    	<option value="R">Fine dining</option>
					                    	<option value="H">Holiday Spots</option>
					                    </select>
					                </div>
					                
					                <button type="button" id="nextBtn" class="btn btn-success">Next</button>
                
         	
					                <div id="addrDetails" class="labelColor">
					                			              
								         <div class="form-group">
						                    <label class="control-label labelColor" for="addrline1Label"><font color="red">* </font> Address Line1</label>
						                    <input type="text" class="form-control" id="addrline1Label" aria-describedby="addrline1input" name="venueAddress.addrLine1" placeholder="AddressLine1"  required/>
						                 </div>
						                 
						                 <div class="form-group ">
						                    <label class="control-label labelColor" for="addrLine2Label"><font color="red">* </font> Address Line2</label>
						                    <input type="text" class="form-control" id="addrLine2Label" aria-describedby="addrLine2input" name="venueAddress.addrLine2"   placeholder="AddressLine2"  />
					               		 </div>
					                
						                <div class="form-group">
						                    <label class="control-label labelColor" for="citylabel"><font color="red">* </font>City</label>
						                    <input type="text" class="form-control" id="citylabel" aria-describedby="cityinput" name="venueAddress.city"  placeholder="City" required/>
						                </div>
						                
						                <div class="form-group">
						                    <label class="control-label labelColor" for="statelabel"><font color="red">* </font>State</label>
						                    <input type="text" class="form-control" id="statelabel" aria-describedby="stateinput"  name="venueAddress.state"   placeholder="State" required/>
						                </div>
						                
						                <div class="form-group">
						                    <label class="control-label labelColor" for="cntrylabel"><font color="red">* </font>Country</label>
						                    <input type="text" class="form-control" id="cntrylabel"  name="venueAddress.country"   placeholder="Country" required/>
						                </div>
						                
						                 <div class="form-group">
						                    <label class="control-label labelColor" for="ziplabel"><font color="red">* </font>Zip Code</label>
						                    <input type="number" class="form-control" id="ziplabel" name="venueAddress.zipcode" placeholder="ZipCode" required/>
						                </div>
						                 
						                 <div class="addVenueBtnDiv">
						                 	<button id="newVenueBtn" type="submit" class="btn btn-primary">Add Venue!</button>
						                 <!-- 	<button id="newVenueMailBtn" type="button" class="btn btn-primary">Send mail!</button> -->
						                 </div> 
						                
					                </div>
					              </div>
					            </div>
					         </div>
					                
					        </div><!-- end become a member modal -->
					        </form> <!-- end Form -->
					        
			
						<br /><br />
						<div class="reviewSubmitDiv"><button type="button" id="reviewSubmit" class="btn btn-success">Submit</button>
					</div>
						</div>

				</div>
			</div>
			<div class="row resizeRow border">
				<div class="logos">
					<div class="logo1 col-lg-4 col-md-4 col-sm-6 col-xs-12 ">
						<img class="logoResize img-circle img-thumbnail" id="holidayImgId"
							src="resources/images/placeLogo2.jpg" alt="PlaceToVisit" />
					</div>
					<div class="logo1 col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<img class="logoResize img-circle img-thumbnail" id="restaurantImgId"
							src="resources/images/resturantLogo2.jpg" alt="PlaceToEat" />
					</div>
					<div class="logo1 col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<img class="logoResize img-circle img-thumbnail" id="partyImgId"
							src="resources/images/partylogo1.JPG" alt="PlaceToParty" />
					</div>
				</div>
			</div>
			<div class="row border">
				<div class="shadow" id="mainSection">
					<c:forEach var="venue" items="${requestScope.venueList}"
						varStatus="count">
						<div class="panel panel-default col-lg-4 resizePanelVenue">
							<div class="panel-heading">
							<div class="col-lg-offset-9">
								<span id="favSelect${venue.venueId}" onclick="myFav(${venue.venueId})"><i class="fa fa-heart-o fa-lg"></i></span> 
								<span id="visitSelect${venue.venueId}" onclick="myVisited(${venue.venueId})"><i class="fa fa-thumbs-o-up fa-lg"></i> </span> <span class="glyphicon glyphicon-star text-warning"></span>
							</div>
							<h3 class="venueSectionHeading"><a onclick="getVenueDetail(${venue.venueId})">${venue.venueName}</a></h3>
								<!-- <span><div class="rating"><span>☆</span></div></span> -->
								
							</div>
							<div class="panel-body">
								<div class="col-lg-6">
									<img class="ImgVenueSize"
										src="resources/images/venueImgs/${venue.venueImgLocation}"
										alt="venue Image" />
								</div>
								<div class="col-lg-6">
									<i class="fa fa-quote-left  fa-lg fa-pull-left"></i>${venue.introVenueReview}
									
								</div>
							</div>
							<div class="panel-footer">
								<p>${venue.venueDesc}</p>
								<p><em>Restaurant Type:</em> ${venue.venueType}</p>
								<p><em>Range:</em> ${venue.venueRange}<i class="fa fa-usd" aria-hidden="true"></i></p>
								<p><em>Address:</em> ${venue.venueAddress.addrLine1},<br>
									${venue.venueAddress.addrLine2},<br>
									${venue.venueAddress.city}
								</p>
							</div>
						</div>
					</c:forEach>

				</div>
				<input id="hidden1" type="hidden" value="">
				<input id="hiddenPageIndex" type="hidden" value="9" />
			</div>
			<div id="row">
				<div id="mainSection2"></div>
			</div>
			<div class="row">
			
			</div>
		</div>
		<!-- center section end -->
		<div class="col-lg-1 rightPanel">
			<div class="row">
				<div id="weatherDiv">
					<a
						href="http://www.accuweather.com/en/us/boston-ma/02108/weather-forecast/348735"
						class="aw-widget-legal"> 
						By accessing and/or using this code snippet, you agree to AccuWeather’s terms and conditions (in English) which can be found at http://www.accuweather.com/en/free-weather-widgets/terms and AccuWeather’s Privacy Statement (in English) which can be found at http://www.accuweather.com/en/privacy.
						
					</a>
					<div id="awcc1460090223500" class="aw-widget-current"
						data-locationkey="" data-unit="f" data-language="en-us"
						data-useip="true" data-uid="awcc1460090223500"></div>
					<script type="text/javascript"
						src="http://oap.accuweather.com/launch.js"></script>
						
					<!-- 	<iframe src="http://www.weatherfor.us/load.php?" scrolling="no" frameborder="0" allowtransparency="true" style="background: transparent; width: 720px; height: 250px; overflow: hidden;"></iframe> -->
						
				</div>
			</div>


		</div>

	</div>
	<!-- end of main container fluid -->
	<div>
		<span><script type="text/javascript"
				src="http://100widgets.com/js_data.php?id=142"></script></span>
	</div>
</body>
</html>