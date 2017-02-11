<!-- <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container header">
    <p class="navbar-text">This is the First Page Header Tile Section.</p>
    <a class="navbar-brand" href="#">Just Ask!! </a>
  </div>
</nav> -->
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
				
					
				</ul>
				
				<!--   <p class="navbar-text navbar-right"><a href="#" class="navbar-link">  </a></p> -->
				<ul class="nav navbar-nav navbar-right">
				<!-- 	<li><a href="./preciousVenue.htm">My Precious<i class="fa fa-shopping-cart text-warning" aria-hidden="true"></i></a></li> -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${requestScope.username}<span class="caret"></a>
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