<%-- 
    Document   : checkout
    Created on : Aug 26, 2019, 10:43:16 PM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <h1>Confirm order?</h1>
        <c:set var="cart" value="${sessionScope.CART}"></c:set>
        ${cart.total}
        <form action="MainController">
            <input type="text" name="txtAddress" value="" />
            <input type="submit" value="Confirm" name="btnAction"/>
        </form>
        <input type="submit" value="back to cart" formaction="ViewOrderController" />
    </body>
</html>
