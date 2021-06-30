<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello there!</h1>
	
	<c:forEach items="${product}" var="item">
		<p>${item.gender} ${item.description} ${item.price} ${item.size}</p>
	</c:forEach>
</body>
</html>