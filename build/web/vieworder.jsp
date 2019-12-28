<%-- 
    Document   : vieworder
    Created on : Aug 25, 2019, 10:02:35 PM
    Author     : Bui Be Bong
--%>

<%@page import="sample.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <h1>View your order</h1>
        <c:if test="${sessionScope.CART != null}" var="existCart">
            <c:set var="cart" value="${sessionScope.CART}"></c:set>
            <c:if test="${not empty cart.items}">
                <c:set var="items" value="${cart.items}"></c:set>
                <c:if test="${not empty items}">
                    <table border="1" class="table">
                        <thead class="thead-dark">
                            <tr>    
                                <th scope="col">No.</th>
                                <th scope="col">Tea ID</th>
                                <th scope="col">Size</th>
                                <th scope="col">Ice</th>
                                <th scope="col">Sugar</th>
                                <th scope="col">Topping</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total price</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0"></c:set>
                            <c:forEach var="item" items="${items}" varStatus="counter">
                            <form action="UpdateItemController">
                                <tr>
                                    <td scope="row">${counter.count}</td>
                                    <td>${item.teaID}</td>
                                    <td>
                                        <c:if test="${item.size == 0}">S</c:if>
                                        <c:if test="${item.size == 5000}">M</c:if>
                                        <c:if test="${item.size == 10000}">L</c:if>
                                        </td>
                                        <td>${item.ice}</td>
                                    <td>${item.sugar}</td>
                                    <td>${item.topping}</td>
                                    <td>
                                        <input type="number" name="quantity" value="${item.quantity}" />
                                    </td>
                                    <td>
                                        <%--<jsp:useBean id="bean" class="sample.cart.CartObject" />--%>
                                        ${item.total}
                                        <input type="hidden" name="total" value="${total = total + bean.computeTotal()}" />
                                    </td>
                                    <td>
                                        <c:url var="remove" value="RemoveItemController">
                                            <c:param name="teaID" value="${item.teaID}"></c:param>
                                            <c:param name="TeaSize" value="${item.size}" ></c:param>
                                            <c:param name="TeaIce" value="${item.ice}" ></c:param>
                                            <c:param name="TeaSugar" value="${item.sugar}" ></c:param>
                                            <c:param name="TeaTopping" value="${item.topping}" ></c:param>
                                        </c:url>
                                        <a href="${remove}">Remove</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" />
                                        <input type="hidden" name="TeaID" value="${item.teaID}" />
                                        <input type="hidden" name="TeaSize" value="${item.size}" />
                                        <input type="hidden" name="TeaIce" value="${item.ice}" />
                                        <input type="hidden" name="TeaSugar" value="${item.sugar}" />
                                        <input type="hidden" name="TeaTopping" value="${item.topping}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        <tr>
                            <td colspan="7">
                                <c:url var="back" value="userpage.jsp">
                                </c:url>
                                <a href="${back}">Back to store</a>
                            </td>
                            <td>
                                ${cart.total}
                            </td>
                            <td colspan="2">
                                <form action="CheckOutServlet">
                                    <input type="submit" value="Checkout" />
                                    <input type="hidden" name="total" value=" ${total}" />
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:if>

        </c:if>

    </c:if>
    <c:if test="${!existCart}">
        <h2>No item is existed!</h2>
    </c:if>

</body>
</html>
