<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width; initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Benne&display=swap"
	rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Benne&family=Caveat:wght@600&display=swap"
	rel="stylesheet">

<title>With Every Stitch</title>
</head>
<body>

	<mytags:navbar />
	<div class="container4">
		<div class="item_top">
			<mytags:sidebar />
		</div>

		<div class="catalog_container">
			<c:forEach items="${product}" var="item">


				<div class="card" style="width: 18rem;">
					<img src="images/${item.img}" class="card-img-top" alt="man_shirt">
					<div class="card-body">
						<h5 class="card-title">${item.gender} ${item.item}     $${item.price}</h5>
						<a href="/product/${item.id}" class="btn btn-primary">Product Details</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<mytags:footer />

</body>

<script type="text/javascript" src="/javascript/script.js"></script>
</html>