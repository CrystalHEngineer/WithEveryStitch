<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Benne&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Benne&family=Caveat:wght@600&display=swap" rel="stylesheet">


<title>Contact</title>
</head>
<body>
	<mytags:navbar/>
	<h1 class="center">CONTACT US</h1>
	
	<div class="container6">
		<div class="about_item">
			<mytags:sidebar/>
		</div>

		<div class="about_item about_width cust">
		<form:form action="/contact/new" method="POST" modelAttribute="feedback">
		
		    <div class="form-group row">
		        <form:label class="col-sm-3 col-form-label" path="name">Name:</form:label>
		    	<div class="col-sm-8">
		        	<form:input class="form-control" rows="5" cols="30" path="name"/>
		    		<form:errors class="errors" path="name"/>
		    	</div>
		    </div> 

		    <div class="form-group row">
		        <form:label class="col-sm-3 col-form-label" path="email">Email:</form:label>
		    	<div class="col-sm-8">
		        	<form:input class="form-control" rows="5" cols="30" path="email"/>
		    		<form:errors class="errors" path="email"/>
		    	</div>
		    </div>
		    	    
		    <div class="form-group row">
		        <form:label class="col-sm-3 col-form-label" path="phone">Phone:</form:label>
		    	<div class="col-sm-8">
		        	<form:input class="form-control" rows="5" cols="30" path="phone"/>
		    		<form:errors class="errors" path="phone"/>
		    	</div>
		    </div>   
		    
		    <div class="form-group row">
				<form:label class="col-sm-3 col-form-label" path="reason">Reason for contacting:</form:label>
		    	<div class="col-sm-9">
		        	<form:textarea class="form-control" rows="5" cols="30" path="reason"/>
		        	<form:errors class="errors" path="reason"/>
		    	</div>
		    </div>		    
		    
		    <div class="form-group row">
		    	<div class="col-sm-12">
		    		<input type="submit" class="btn btn-dark float-right" value="Submit">
		      	</div>
		    </div>
		    
		</form:form>
		</div>

	</div>
    
	<mytags:footer/>

</body>

<script type = "text/javascript" src="javascript/script.js"></script>

