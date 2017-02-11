<!-- <div class="alert alert-success" role="alert" style="margin-top:300px;"> -->

 <%--  <a href="${pageContext.servletContext.contextPath}/page2">Go to Second Page</a> --%>
<div class="wrapper">
        <div class="container-fluid">
			<div class="row">
				<div class="mainContainer">
					<h1 class="customizeHeading">Welcome ${sessionScope.username} to the admin page </h1>
					<div class="button">
						<form action="manageUser.htm" method="POST">
							<button type="submit"  class="btn btn-success customBtn"  > Manage User <i class="fa fa-user" aria-hidden="true"></i> </button>
						</form>
						<br />
						<form action="manageAccounts.htm" method="POST">
							<button type="submit"  class="btn btn-success customBtn" > Analyze Account <i class="fa fa-line-chart" aria-hidden="true"></i></button>
						</form>
					</div>
                </div><!--transparent box closed-->
			</div><!--row closed-->
		</div><!--Container-fluid closed-->
	</div><!--wrapper closed-->

<!-- </div> -->
