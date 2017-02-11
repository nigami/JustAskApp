<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Just Ask!! - Home</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" type="text/css">
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css' />
<link  rel="stylesheet" type="text/css" href="resources/css/jaHome.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="resources/js/jquery.gridnav.js"></script>
<script type="text/javascript" src="resources/js/jaHome.js"></script>
<script type="text/javascript">
			$(function() {
				$('#tj_container').gridnav({
					type	: {
						mode		: 'disperse', 	// use def | fade | seqfade | updown | sequpdown | showhide | disperse | rows
						speed		: 300,			// for fade, seqfade, updown, sequpdown, showhide, disperse, rows
						easing		: '',			// for fade, seqfade, updown, sequpdown, showhide, disperse, rows	
						factor		: '',			// for seqfade, sequpdown, rows
						reverse		: ''			// for sequpdown
					}
				});
			});
		</script>
</head>
<body id="page-top">

	
<nav id="mainNav" class="navbar navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top"><span class="colorChange">Just</span> <span class="changeCream">Ask!!</span></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about"><strong>About</strong></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Portfolio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

	
	<div class="container" >
		<div id="corossal-container">
			<div class="container">
			
			<div class="content example8">
				<div id="tj_container" class="tj_container">
					<div class="tj_nav">
						<span id="tj_prev" class="tj_prev">Previous</span>
						<span id="tj_next" class="tj_next">Next</span>
					</div>
					<div class="tj_wrapper">
						<ul class="tj_gallery">
							<li><a href="#"><img src="resources/images/368.JPG" alt="image01" /></a></li>
							<li><a href="#"><img src="resources/images/21.JPG" alt="image02" /></a></li>
							<li><a href="#"><img src="resources/images/22.JPG" alt="image03" /></a></li>
							<li><a href="#"><img src="resources/images/36.JPG" alt="image04" /></a></li>
							<li><a href="#"><img src="resources/images/28.JPG" alt="image05" /></a></li>
							<li><a href="#"><img src="resources/images/30.JPG" alt="image06" /></a></li>
							<li><a href="#"><img src="resources/images/25.JPG" alt="image07" /></a></li>
							<li><a href="#"><img src="resources/images/23.JPG" alt="image08" /></a></li>
							<li><a href="#"><img src="resources/images/24.JPG" alt="image09" /></a></li>
							<li><a href="#"><img src="resources/images/26.JPG" alt="image10" /></a></li>
							<li><a href="#"><img src="resources/images/30.JPG" alt="image11" /></a></li>
							<li><a href="#"><img src="resources/images/27.JPG" alt="image12" /></a></li>
							<li><a href="#"><img src="resources/images/29.JPG" alt="image13" /></a></li>
							<li><a href="#"><img src="resources/images/368.JPG" alt="image14" /></a></li>
							<li><a href="#"><img src="resources/images/30.JPG" alt="image15" /></a></li>
							<li><a href="#"><img src="resources/images/37.JPG" alt="image16" /></a></li>
							<li><a href="#"><img src="resources/images/213.JPG" alt="image17" /></a></li>
							<li><a href="#"><img src="resources/images/211.JPG" alt="image18" /></a></li>
							<li><a href="#"><img src="resources/images/25.JPG" alt="image19" /></a></li>
							<li><a href="#"><img src="resources/images/23.JPG" alt="image20" /></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		</div><!-- end of corossal container -->
		
		<div class="relative">
		<p>We've got what you need!</p>
		</div>
		
		<div class="signup col-xs-12">
		<h2 id="signInForm">Sign In</h2>
		
		<div id="errorSignIn">${requestScope.signInError}</div>
		<form:form class="form-horizontal toggleClass" commandName="user"  action="signIn.htm"  METHOD="POST">
		  <div class="form-group">
		    <div class="col-sm-8">
		      <form:input type="text" class="form-control" id="username" placeholder="Email/Username" path="username" value="${cookie.usernameCookie.value}"/> <font color="red"><form:errors path="username" /></font>
		    <div id="errorUsername">${requestScope.error}</div>
		    </div>
		  </div>
		  <div class="form-group">
		 	<div class="col-sm-8">
		      <form:input type="password" class="form-control" id="password" placeholder="Password"  path="password" value="${cookie.passwordCookie.value}"/> <font color="red"><form:errors path="password" /></font>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-8">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox" name="rememberMeId" value="true" > Remember me
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-success btnblock">Sign in</button>
		    </div>
		  </div>
		</form:form>
		<h2>Sign Up</h2>
		<!--  <div class="col-sm-12"> -->
		<button type="button" id="userSignUpBtn" data-toggle="modal" data-target="#becomeamember" class="btn btn-info btnblock" >As User</button>
		 <!-- <div class="col-sm-12"> --><br>
		<!-- <button type="button" id="ownerSignUpBtn" data-toggle="modal" data-target="#becomeamember" class="btn btn-warning btnblock" >As Owner</button> -->
			   <!-- Modal Become a member -->
        <form:form action="signUp.htm" commandName="user" id="newmember"  method="POST" >
        <div class="modal fade" id="becomeamember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h3 class="modal-title labelColor" id="myModalLabel" ><font color="black">Become a member</font></h3>
                <form:errors path="*" />
              </div>
              <div class="modal-body form-inline">
                <div class="form-group">
                    <label class="control-label labelColor" for="firstnamelabel"><font color="red">* </font> First name</label>
                    <form:input type="text" class="form-control" id="firstnameinput" aria-describedby="firstnameinput" path="firstName" placeholder="First Name"  required="true" maxlength="15"/> <font color="red"><form:errors path="firstName" /></font>
                 </div>
                
                <div class="form-group ">
                    <label class="control-label labelColor" for="lastnamelabel"><font color="red">* </font> Last name</label>
                    <form:input type="text" class="form-control" id="lastnameinput" aria-describedby="lastnameinput" path="lastName"  placeholder="Last Name" required="true" maxlength="15"/><font color="red"><form:errors path="lastName" /></font>
                </div>
                
                <div class="form-group">
                    <label class="control-label labelColor" for="emaillabel"><font color="red">* </font> Email address</label>
                    <form:input type="email" class="form-control" id="emailinput" aria-describedby="emailinput"  path="email"  placeholder="Email" required="true"/><font color="red"><form:errors path="email" /></font>
                </div>
                
                <div class="form-group">
                    <label class="control-label labelColor" for="usernamelabel"><font color="red">* </font>Username</label>
                    <form:input type="text" class="form-control" id="usernameinput" aria-describedby="usernameinput"  path="username"  placeholder="Username" required="true"/><font color="red"><form:errors path="username" /></font>
                </div>
                
                <div class="form-group">
                    <label class="control-label labelColor" for="passwordlabel"><font color="red">* </font>Password</label>
                    <form:input type="password" class="form-control" id="passwordinput"  path="password"  placeholder="Password" required="true"/><font color="red"><form:errors path="password" /></font>
                </div>
                <%-- 
                 <div class="form-group">
                    <label class="control-label labelColor" for="userTypelabel"><font color="red">* </font>UserType</label>
                    <form:input type="text" class="form-control" id="userTypelabel"  path="userType"  placeholder="UserType" readonly="true" required="true"/>
                </div> --%>
				<button type="button" id="nextBtn" class="btn btn-success">Next</button>
                
         	
	                <div id="addrDetails" class="labelColor">
	                			              
				         <div class="form-group">
		                    <label class="control-label labelColor" for="addrline1Label"><font color="red">* </font> Address Line1</label>
		                    <form:input type="text" class="form-control" id="addrline1Label" aria-describedby="addrline1input" path="address.addrLine1" placeholder="AddressLine1"  required="true"/><font color="red"><form:errors path="address.addrLine1" /></font>
		                 </div>
		                 
		                 <div class="form-group ">
		                    <label class="control-label labelColor" for="addrLine2Label"><font color="red">* </font> Address Line2</label>
		                    <form:input type="text" class="form-control" id="addrLine2Label" aria-describedby="addrLine2input" path="address.addrLine2"  placeholder="AddressLine2"  /><font color="red"><form:errors path="address.addrLine2" /></font>
	               		 </div>
	                
		                <div class="form-group">
		                    <label class="control-label labelColor" for="citylabel"><font color="red">* </font>City</label>
		                    <form:input type="text" class="form-control" id="citylabel" aria-describedby="cityinput"  path="address.city"  placeholder="City" required="true"/><font color="red"><form:errors path="address.city" /></font>
		                </div>
		                
		                <div class="form-group">
		                    <label class="control-label labelColor" for="statelabel"><font color="red">* </font>State</label>
		                    <form:input type="text" class="form-control" id="statelabel" aria-describedby="stateinput"  path="address.state"  placeholder="State" required="true"/><font color="red"><form:errors path="address.state" /></font>
		                </div>
		                
		                <div class="form-group">
		                    <label class="control-label labelColor" for="cntrylabel"><font color="red">* </font>Country</label>
		                    <form:input type="text" class="form-control" id="cntrylabel"  path="address.country"  placeholder="Country" required="true"/><font color="red"><form:errors path="address.country" /></font>
		                </div>
		                
		                 <div class="form-group">
		                    <label class="control-label labelColor" for="ziplabel"><font color="red">* </font>Zip Code</label>
		                    <form:input type="text" class="form-control" id="ziplabel"  path="address.zipcode"  placeholder="ZipCode" required="true"/><font color="red"><form:errors path="address.zipcode" /></font>
		                </div>
		                 
		                 <div>
		                 	<button type="submit" class="btn btn-primary">Sign up</button>
		                 </div> 
		                
	                </div>
              </div><!-- end modal-Body -->
              
            </div>
          </div>
        </div><!-- end become a member modal -->
        </form:form> <!-- end Form -->
        

			<!-- Contextual button for informational alert messages -->
			
		</div>
		
		
	<div class="signupSmallScreen col-xs-12 col-sm-12 col-md-12">
		<div class="col-sm-8 col-md-8">
		<h2 id="signInForm">Sign In</h2>
		
		<form class="form-horizontal toggleClass">
  <div class="form-group">
    <div class="col-sm-8">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
 	<div class="col-sm-8">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-8">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-success btnblock">Sign in</button>
    </div>
  </div>
</form>
</div><!-- sign in subform for small screen-->
<div class="col-sm-4 col-md-4">
		<h2>Sign Up</h2>
		<!--  <div class="col-sm-12"> -->
		<button type="button" class="btn btn-warning btnblock">As User</button><!-- </div> -->
			
		 <!-- <div class="col-sm-12"> --><br>
		<!-- <button type="button" class="btn btn-warning btnblock">As Owner</button></div> -->
			

			<!-- Contextual button for informational alert messages -->
			</div><!-- sign upsubform for small screen-->
		</div>

<!--
    Left and right controls
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  </div>end of customize Carousal
   -->
		<%-- 
     <%@include  file="/resources/typed.js-master/index.htm" %>
     
   --%>    
	</div>
	
	<div>	
    <section  id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">We've got what you need!</h2>
                    <hr class="light">
                    <p class="text-faded">Helping people discover great places around them.
Our team gathers information from every restaurant on a regular basis to ensure our data is fresh. Our vast community of food lovers share their reviews and photos, so you have all that you need to make an informed choice.</p>
                    <a href="#" class="btn btn-default btn-xl">Get Started!</a>
                </div>
            </div>
        </div>
    </section>

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-diamond wow bounceIn text-info"></i>
                        <h3>Holiday Search</h3>
                        <p class="text-muted">Our Holiday destination are updated regularly so they great.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-paper-plane wow bounceIn text-warning" data-wow-delay=".1s"></i>
                        <h3>Restaurant Search</h3>
                        <p class="text-muted">You can use this theme as is, or you can make changes!</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-newspaper-o wow bounceIn text-success" data-wow-delay=".2s"></i>
                        <h3>Contact</h3>
                        <p class="text-muted">We update dependencies to keep things fresh. Contact: ilanigam17@gmail.com</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-heart wow bounceIn text-danger" data-wow-delay=".3s"></i>
                        <h3>Made with Love</h3>
                        <p class="text-muted">You have to make your Services to with love these days!</p>
                    </div>
                </div>
            </div>
        </div>
   	 </section>
		
</div><!-- Container black -->
	
</body>
</html>