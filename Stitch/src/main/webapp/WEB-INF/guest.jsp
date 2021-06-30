<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Continue as guest or keep logging</title>
	</head>
	<body>
		<mytags:navbar/>
		<div class = "continer">
		
		<div class="about_item">
			<mytags:sidebar/>
		</div>
		
			<p>Login</p>
				<p>${logerror}</p>
				
				<form method = "post" action = "/loginguest">			
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
	</body>
</html>