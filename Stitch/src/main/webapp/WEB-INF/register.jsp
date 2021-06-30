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
	</head>
	<body>
		
		<div class="about_item">
			<mytags:sidebar/>
		</div>
		<div class = "container" >
			<h1>Hello Guest</h1>
				<div class = "form-group">
				<p>${regeror}</p>
				
				<h3>Register</h3>
				<form:form action = "/registguest" method = "post" modelAttribute ="newguest">
					<p>
						<form:label path = "name">Name:</form:label>
						<form:errors path="name"/>
						<form:input path="name"/>
					</p>
					<p>
						<form:label path = "email">Email:</form:label>
						<form:errors path="email"/>
						<form:input path="email"/>
					</p>
									
					<p>
						<form:label path = "password">Password:</form:label>
						<form:errors path="password"/>
						<form:password path="password"/>
					</p>
					
					<p>
						<form:label path = "passwordConfirmation">PW Conf:</form:label>
						<form:errors path="passwordConfirmation"/>
						<form:password path="passwordConfirmation"/>
					</p>
					
					<input type="submit" value= "Register"/>
				</form:form>	
			</div>	
			
		</div>
		<mytags:footer/>
	</body>
</html>