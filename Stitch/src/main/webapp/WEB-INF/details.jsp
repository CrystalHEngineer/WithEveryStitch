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
			<form action="/${guest.id}/item/${item.id}/add" method="POST">
				<div class="details">
					<p>${guest.id}</p>
					<img src="/images/${item.img}" alt="clothing" class="detailsimg">
				</div>
				<div class="details">
					<div class="detailsdesc">
						<p class="price">$${item.price}</p>
						<p>${item.description}</p>
						<div>
							<label>Quantity: </label> <input type="number" min="1" value="1"
								name="quantity" />
						</div>
						<input type="hidden" name="itemid" value="${item.id}" />
						<button class="btn btn-primary" type="submit">Add To Cart</button>
					</div>
				</div>
			</form>


		</div>
	</div>
	<mytags:footer />

</body>

<script type="text/javascript" src="/javascript/script.js"></script>
</html>