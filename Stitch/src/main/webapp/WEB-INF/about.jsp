<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
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


<title>About</title>
</head>
<body>
	<mytags:navbar/>
	<h1 class="center">ABOUT</h1>
	<div class="container6">
		<div class="about_item">
			<mytags:sidebar/>
		</div>
		<img src="/images/kisspng-woman-fashion-shopping-beauty.png" alt="model" width="275" height="413">
		<div class="about_item about_width background_gray font_size">
			<p><span id="logo_font">With Every Stitch</span> is the brainchild of four software engineers (Adan, Cheng, Crystal, and Terra) who are committed to providing clothing that are exciting to wear.  
				Clothing is an art form and nothing makes us happier than helping you create your masterpiece.</p>
			<p>We offer a wide variety of high-quality custom apparel that can be personalized to suit your tastes. So, browse our collection, you won't be disappointed!</p>
			<h1>Life is too short for boring clothes...</h1>
			<h1 class="banner1">Make life exciting <span id="logo_font">With Every Stitch</span></h1>

		</div>

	</div>
    
	<mytags:footer/>

</body>

<script type = "text/javascript" src="/javascript/script.js"></script>

