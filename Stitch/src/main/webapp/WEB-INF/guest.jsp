<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Continue as guest or keep logging</title>
	<meta charset="ISO-8859-1" name="viewport" content="width=device-width; initial-scale=1.0">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Benne&display=swap" rel="stylesheet">
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Benne&family=Caveat:wght@600&display=swap" rel="stylesheet">
	</head>
	<body>
		<mytags:navbar/>
	
    	<div class="container2">
    	
    		<div class="container3 background_gray">
	            <img src="/images/3_model-2911330_1920.png" alt="model" width="250" height="167">
	            <div class="item_center">
	                <h1 class="banner1">Life is too short for boring clothes...</h1>
	                <h1 class="banner2">Make life exciting <span id="logo_font">With Every Stitch</span></h1>
	            </div>
        	</div>
        	
        	<div class="container4">
	            <div class="item_top">
					<mytags:sidebar/>
	            </div>
	        </div>
		
		
		
			<h3>Login</h3>
				<p>${logerror}</p>
				
				<form method = "post" action = "/loginguser">			
					<p>
						<label for = "email">Email</label> 
						<input type ="text" id = "email" name = "inputemail"/>
					</p>
					
					<p>
						<label for = "password">Password</label> 
						<input type ="password" id = "password" name = "inputpassword"/>
					</p>
					<input type = "submit" value ="Login!"/>
				</form>	
				
				<form class = "button-form" action = "/registerpage" method = "post">
					<input type = "submit" value = "Join us as VIP member">
				</form>
				
				<form class = "button-form" action = "/guest" method = "post">
					<input type = "submit" value ="Continue as Guest to Pay">
				</form>
				
				
		</div>
		<mytags:footer/>
		<script type = "text/javascript" src="/javascript/script.js"></script>
	</body>
</html>