<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width; initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Benne&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Benne&family=Caveat:wght@600&display=swap" rel="stylesheet">

<title>With Every Stitch</title>
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

            <div class="item_top overlay">
                <img class="img-fluid" src="/images/4_three-3075752_1920.jpg" alt="model" width="760" height="507">
                <div class="bottom_left">
                    <h1>NIGHT-ON-THE-TOWN</h1>
                </div>
            </div>
            <div class="item_top">
                <img class="img-fluid" src="/images/5_woman-5611028_1920.jpg" alt="model" width="192" height="240">
                <h4>BOHO CHIC</h4>
                <a class="btn2" href="/wShirts">SHOP WOMEN'S SHIRTS</a>
                <br/>

                <img class="img-fluid" src="/images/6_man-2792505_1920.jpg" alt="model" width="160" height="240">
                <h4>WEEKEND CASUAL</h4>
                <a class="btn2" href="/mShirts">SHOP MEN'S SHIRTS</a>
                <br/>
            </div>

        </div>

    </div>

	<mytags:footer/>

</body>

<script type = "text/javascript" src="/javascript/script.js"></script>

</html>