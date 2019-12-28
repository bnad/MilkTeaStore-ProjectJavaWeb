<%-- 
    Document   : adminpage
    Created on : Aug 19, 2019, 10:11:40 PM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Livvic&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Admin Page</title>
        <style>
            body {
                background-image: url('img/searchbg.jpg');
                background-attachment: fixed;
                background-size: cover;
                background-repeat: no-repeat;
            }
            .welcome {
                font-size: 34px;
                width: auto;
                font-family: 'Livvic', sans-serif;
                margin: 10px;
                color:	#ffffff;
            }.logout {
                font-family: 'Livvic', sans-serif;
                margin: 20px;
                color:	#ffffff;
            }
            #content {
                position: absolute;
                height: 400px;
                width: 300px;
                margin-left: 170px;
                top: 40%;
                left: 20%;
                transform: translate(-50%, -50%);
            }

            #content.on {
                -webkit-animation-name: in-out;
                animation-name: in-out;
                -webkit-animation-duration: 0.7s;
                animation-duration: 0.7s;
                -webkit-animation-timing-function: linear;
                animation-timing-function: linear;
                -webkit-animation-iteration-count: 1;
                animation-iteration-count: 1;
            }
            .btnSearchProduct {
                position: absolute;
                border-radius: 0%;
                border: 4px solid #ffffff;
                height: 50px;
                width: 100px;
                box-sizing: border-box;
                top: 18%;
                left: -16%;
                transform: translate(-50%, -50%);
            }
            .input {
                box-sizing: border-box;
                width: 50px;
                height: 50px;
                border: 4px solid #ffffff;
                border-radius: 50%;
                background: none;
                color: #fff;
                font-size: 16px;
                font-weight: 400;
                font-family: Roboto;
                outline: 0;
                -webkit-transition: width 0.4s ease-in-out, border-radius 0.8s ease-in-out,
                    padding 0.2s;
                transition: width 0.4s ease-in-out, border-radius 0.8s ease-in-out,
                    padding 0.2s;
                -webkit-transition-delay: 0.4s;
                transition-delay: 0.4s;
                -webkit-transform: translate(-100%, -50%);
                -ms-transform: translate(-100%, -50%);
                transform: translate(-100%, -50%);
            }
            .search {
                background: none;
                position: absolute;
                top: 0px;
                left: 0;
                height: 50px;
                width: 50px;
                padding: 0;
                border-radius: 100%;
                outline: 0;
                border: 0;
                color: inherit;
                cursor: pointer;
                -webkit-transition: 0.2s ease-in-out;
                transition: 0.2s ease-in-out;
                -webkit-transform: translate(-100%, -50%);
                -ms-transform: translate(-100%, -50%);
                transform: translate(-100%, -50%);
            }

            .search:before {
                content: "";
                position: absolute;
                width: 20px;
                height: 4px;
                background-color: #fff;
                -webkit-transform: rotate(45deg);
                -ms-transform: rotate(45deg);
                transform: rotate(45deg);
                margin-top: 26px;
                margin-left: 17px;
                -webkit-transition: 0.2s ease-in-out;
                transition: 0.2s ease-in-out;
            }

            .close {
                -webkit-transition: 0.4s ease-in-out;
                transition: 0.4s ease-in-out;
                -webkit-transition-delay: 0.4s;
                transition-delay: 0.4s;
            }

            .close:before {
                content: "";
                position: absolute;
                width: 27px;
                height: 4px;
                margin-top: -1px;
                margin-left: -13px;
                background-color: #fff;
                -webkit-transform: rotate(45deg);
                -ms-transform: rotate(45deg);
                transform: rotate(45deg);
                -webkit-transition: 0.2s ease-in-out;
                transition: 0.2s ease-in-out;
            }

            .close:after {
                content: "";
                position: absolute;
                width: 27px;
                height: 4px;
                background-color: #fff;
                margin-top: -1px;
                margin-left: -13px;
                cursor: pointer;
                -webkit-transform: rotate(-45deg);
                -ms-transform: rotate(-45deg);
                transform: rotate(-45deg);
            }
            
            .square {
                box-sizing: border-box;
                padding: 0 40px 0 10px;
                width: 300px;
                height: 50px;
                border: 4px solid #ffffff;
                border-radius: 0;
                background: none;
                color: #fff;
                font-family: Roboto;
                font-size: 16px;
                font-weight: 400;
                outline: 0;
                -webkit-transition: width 0.4s ease-in-out, border-radius 0.4s ease-in-out,
                    padding 0.2s;
                transition: width 0.4s ease-in-out, border-radius 0.4s ease-in-out,
                    padding 0.2s;
                -webkit-transition-delay: 0.4s, 0s, 0.4s;
                transition-delay: 0.4s, 0s, 0.4s;
                -webkit-transform: translate(-100%, -50%);
                -ms-transform: translate(-100%, -50%);
                transform: translate(-100%, -50%);
            }
            .tableTea {
                position: absolute;
                left: 50%;
                top: 55%;
                transform: translate(-50%,-50%);
                background: none;
                width: 70%;
                color: white;
            }
            .text {
                background: none;
                border: none;
                color: white;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.USERIDLOGIN ne 'duy'}">
            <jsp:forward page="login.jsp"></jsp:forward>
        </c:if>
        <font class="welcome">Welcome ${sessionScope.USERIDLOGIN}</font>
        <c:url var="logout" value="MainController">
            <c:param name="btnAction" value="Log out"></c:param>
        </c:url>
        <a href="${logout}" class="logout">Log out</a>
        <form id="content" action="MainController">
            <input type="text" name="txtSearchProduct" class="input" id="search-input" value="${param.txtSearchProduct}">
            <button type="reset" class="search" id="search-btn"></button>
            <input type="submit" value="Search Tea" name="btnAction" class="btnSearchProduct"/>
        </form>
        <a class="logout" href="createNewProduct.jsp">Click here to create new product</a>
        <script>
            const input = document.getElementById("search-input");
            const searchBtn = document.getElementById("search-btn");

            const expand = () => {
                searchBtn.classList.toggle("close");
                input.classList.toggle("square");
            };
            searchBtn.addEventListener("click", expand);
        </script>

        <c:if test="${not empty requestScope.LISTTEA}" var="existTea">
            <div class="container">
                <table border="1" class="tableTea" class="table table-dark table-hover">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Tea ID</th>
                            <th>Tea Name</th>
                            <th>Price</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.LISTTEA}" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <input class="text" type="text" name="txtTeaID" value="${dto.teaID}" readonly="true"/>
                                    <input type="hidden" name="txtSearchProduct" value="${param.txtSearchProduct}" />
                                </td>
                                <td>
                                    <input class="text" type="text" name="txtTeaName" value="${dto.teaName}" />
                                </td>
                                <td>
                                    <input class="text" type="number" name="txtPrice" value="${dto.price}" />
                                </td>
                                <td>
                                    <c:url var="deleteTea" value="MainController">
                                        <c:param name="teaID" value="${dto.teaID}"></c:param>
                                        <c:param name="btnAction" value="Delete"></c:param>
                                        <c:param name="txtSearchProduct" value="${param.txtSearchProduct}"></c:param>
                                    </c:url>
                                    <a href="${deleteTea}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" class="btn btn-secondary"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
