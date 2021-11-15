<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<title>Checkout</title>
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
	</div>

	<mytags:sidebar/>
	
	<div class="cart_background">
		<h1>Checkout</h1>
		<div class="cart_container">
			<div class="cart_items">
			<ul>
				<c:forEach items="${cart.cartItems}" var="cartItem">			
						
						<li>
							<div class ="cart_item">						
								<img src="/images/${cartItem.product.img}"alt="clothing" class="detailsimg"> 															
								<p> ${cartItem.quantity} ${cartItem.product.gender} ${cartItem.product.item} ${cartItem.product.price}</p>
								<p>${cartItem.product.description}</p>
							</div>				
						</li>
						
				</c:forEach>
			</ul>
			</div>

			
			
			<hr>
			<div class="cart_total">
				<c:set var="total" value="${0}"/>
								
				<c:forEach items="${cart.cartItems}" var="cartItem">					
					<c:set var="total" value="${total + cartItem.product.price}"/>					
				</c:forEach>
				
				<h2>SubTotal: <fmt:formatNumber type="currency" maxFractionDigits="2" value="${total}" /></h2>
				<c:set var="tax" value="${Math.nextDown(total * .065) }"/>
				<h2>Tax: (6.5%) <fmt:formatNumber type="currency" maxFractionDigits="2" value="${tax}" /> </h2>
				<h2>Total: <fmt:formatNumber type="currency" maxFractionDigits="2" value="${total + tax}" /></h2>
			</div>
		</div>
		
		
		
		
		<h3>Make Payment</h3>

		<form action="/${guestId}/cart/${cartId}/purchase/<fmt:formatNumber type="number" maxFractionDigits="2" value="${total + tax}" />" method="POST">
			<script 
				src="https://checkout.stripe.com/checkout.js"
				class="stripe-button" 
				data-key="pk_test_51JWlyiHlsp7LpxwL9ULfYYi8ALpglqdkZxAouBFVdW01piKqBl85QzBQHkL8Dhk90VbUcwIEKUhKj79LH3Yude0F00fy4P3Aae"
				data-amount="${(total + (total *.065))*100}" 
				data-name="With Every Stitch"
				data-description="Stripe Demo Charge"
				data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
				data-locale="auto"
				>
			</script>
		</form>
		
	</div>	
			
	<mytags:footer/>
</body>
<script type = "text/javascript" src="/javascript/script.js"></script>
</html>