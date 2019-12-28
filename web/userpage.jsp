<%-- 
    Document   : userpage
    Created on : Aug 19, 2019, 10:12:09 PM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1><font class="welcome">Welcome ${sessionScope.USERIDLOGIN} !</font></h1>
            <c:url var="logout" value="MainController">
                <c:param name="btnAction" value="Log out"></c:param>
            </c:url>
        <font color="white"><a href="${logout}" class="logout">Log out</a></font>
        <br>
        <c:url var="vieword" value="ViewOrderController">
        </c:url>
        <a href="${vieword}">View your order</a>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <table border="1" class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Tea ID</th>
                    <th scope="col">Tea Name</th>
                    <th scope="col">Unit Price</th>
                    <th scope="col">Size</th>
                    <th scope="col">Topping</th>
                    <th scope="col">Sugar</th>
                    <th scope="col">Ice</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${sessionScope.LISTTEAUSER}" varStatus="counter">
                <form action="MainController">
                    <tr>
                        <td scope="row">${counter.count}</td>
                        <td>
                            ${dto.teaID}
                            <input class="text" type="hidden" name="txtTeaID" value="${dto.teaID}"/>
                        </td>
                        <td>
                            ${dto.teaName}
                        </td>
                        <td>
                            ${dto.price}
                        </td>
                        <td>
                            <select name="cboSize">
                                <option value="0">S</option>
                                <option value="5000">M</option>
                                <option value="10000">L</option>
                            </select>
                        </td>
                        <td>
                            <select name="cboTopping">
                                <option></option>
                                <option>Trân châu trắng</option>
                                <option>Trân châu đen</option>
                                <option>Kem cheese</option>
                                <option>Nha đam</option>
                                <option>Sương sáo</option>
                            </select>
                        </td>
                        <td>
                            <select name="cboSugar">
                                <option value="0">0%</option>
                                <option value="30">30%</option>
                                <option value="50">50%</option>
                                <option value="70">70%</option>
                                <option value="100">100%</option>
                            </select>
                        </td>
                        <td>
                            <select name="cboIce">
                                <option value="0">0%</option>
                                <option value="30">30%</option>
                                <option value="50">50%</option>
                                <option value="70">70%</option>
                                <option value="100">100%</option>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="Add to cart" name="btnAction" class="btn btn-secondary"/>
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
