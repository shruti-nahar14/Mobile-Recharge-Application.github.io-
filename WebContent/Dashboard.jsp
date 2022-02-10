<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.*"%>
<%@page import="com.controller.*"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">

<link rel="stylesheet" href="fonts2/icomoon/style.css">

<link rel="stylesheet" href="css2/owl.carousel.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css2/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css2/style.css">

<title>DashBoard | SaveTime</title>
<style>
body {
	background-image: url('pay1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	background-position: center center;
}

@media only screen and (max-width: 720px) {
	body {
		background-image: url('pay1.jpg');
	}
}

h3 {
	color: white;
}
</style>
</head>
<body>
	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>
	<%!String msg = null;%>
	<%
	if (!session.isNew()) {
		msg = (String) session.getAttribute("login");
		if (msg != null) {
	%>
	<script type="text/javascript">
		alert("Login SuccessFully");
	</script>
	<%
	}
	}
	%>
	<header class="site-navbar" role="banner">
		<div class="container-fluid">
			<div class="row align-items-center">

				<div class="col-11 col-xl-2">
					<h1 class="mb-0 site-logo">
						<a href="#" class="text-white mb-0"><h3>
								<strong>SaveTime</strong>
							</h3></a>
					</h1>
				</div>
				<div class="col-12 col-md-10 d-none d-xl-block">
					<nav class="site-navigation position-relative text-right"
						role="navigation">
						<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
							<li class="active"><a href="Dashboard.jsp"><span>Home</span></a></li>
							<li class="has-children"><a href="#"><span>Services</span></a>
								<ul class="dropdown arrow-top">
									<li><a href="Recharge.jsp">Recharge</a></li>
									<li><a href="Transaction.jsp">Transactions</a></li>

									<li><a href="history.jsp">History</a></li>
								</ul></li>
							<li class="has-children"><a href="#"><span>Profile</span></a>
								<ul class="dropdown arrow-top">
									<li><a href="EditProfile.jsp">Edit Profile</a></li>
								</ul></li>
							<li><a href="index.jsp"><span>Sign Out</span></a></li>
						</ul>
					</nav>
				</div>
				<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
					style="position: relative; top: 3px;">
					<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
						class="icon-menu h3"></span></a>
				</div>
			</div>
		</div>
	</header>
	<script src="js2/jquery-3.3.1.min.js"></script>
	<script src="js2/popper.min.js"></script>
	<script src="js2/bootstrap.min.js"></script>
	<script src="js2/jquery.sticky.js"></script>
	<script src="js2/main.js"></script>
</body>
</html>