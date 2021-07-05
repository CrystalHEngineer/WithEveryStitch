<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="navbar container1">
    <a class="hyperlink hyperlink_margin" href="/"><img src="/images/1_kisspng_needle_thread.png" alt="logo" width="300" height="95"></a>
    <div>
    	<c:choose>
    		<c:when test="${loginUser ==null}">
        		<a class="hyperlink hyperlink_margin" href="/registerpage">Sign In / Register</a>
      		</c:when>
      		<c:otherwise>
      			<a class="hyperlink hyperlink_margin" href="/logout">Logout</a>
      		</c:otherwise>
        </c:choose>
        <a class="hyperlink hyperlink_margin" href="/${guest.id}/cart/${cart.id}">Cart <img src="/images/2_cleanpng_cart5a364b6d2c5557.png" alt="cart" width="35" height="35"></a>
    </div>
</div>
<hr>