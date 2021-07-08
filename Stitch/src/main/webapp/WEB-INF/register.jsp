<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register Page</title>
		
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

        <!-- ============================================================================================== -->
        <!-- Banner and Image-->
        <!-- ============================================================================================== -->

        <div class="container3 background_gray">
            <img src="/images/3_model-2911330_1920.png" alt="model" width="250" height="167">
            <div class="item_center">
                <h1 class="banner1">Life is too short for boring clothes...</h1>
                <h1 class="banner2">Make life exciting <span id="logo_font">With Every Stitch</span></h1>
            </div>
        </div>
                  
        <!-- ============================================================================================== -->
        <!-- Sidebar Menu and Images-->
        <!-- ============================================================================================== -->

        <div class="container4">
            <div class="item_top">
				<mytags:sidebar/>
            </div>
        </div>
        <!-- <div class = "container2"> -->
			
				<div class = "form-group">
				<p>${regerror}</p>
				
				<h3>Register</h3>
				<form:form class="col-sm-3 col-form-label" action = "/registuser" method = "post" modelAttribute ="newuser">
					<p>
						<form:label path = "name">Name:</form:label>
						<form:errors path="name"/>
						<form:input  class="form-control" path="name"/>
					</p>
					<p>
						<form:label path = "email">Email:</form:label>
						<form:errors path="email"/>
						<form:input  class="form-control" path="email"/>
					</p>
									
					<p>
						<form:label path = "password">Password:</form:label>
						<form:errors path="password"/>
						<form:password  class="form-control" path="password"/>
					</p>
					
					<p>
						<form:label path = "passwordConfirmation">PW Conf:</form:label>
						<form:errors path="passwordConfirmation"/>
						<form:password   class="form-control" path="passwordConfirmation"/>
					</p>
					
					<input class="btn btn-dark float" type="submit" value= "Register"/>
				</form:form>
				
				<br>
				
				<h3>Login</h3>
				<p>${logerror}</p>
				
				<form class="col-sm-3 col-form-label" method = "post" action = "/loginguser">			
					<p>
						<label for = "email">Email</label> 
						<input  class="form-control" type ="text" id = "email" name = "inputemail"/>
					</p>
					
					<p>
						<label for = "password">Password</label> 
						<input  class="form-control"  type ="password" id = "password" name = "inputpassword"/>
					</p>
					<input class="btn btn-dark float" type = "submit" value ="Login!"/>
				</form>	
					
			</div>	
		</div>	
		<!-- </div> -->
		<mytags:footer/>
	</body>
	<script type = "text/javascript" src="/javascript/script.js"></script>
</html>