<%-- 
    Document   : login
    Created on : Aug 19, 2019, 8:54:10 PM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>

            body{
                margin:0;
                background:url("img/bglogin.jpg") ;
                no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
            h2{
                margin-top:50px;
                text-align:center;
                color:white;
                font-family:Arial;
                font-size:30px;
            }
            form{
                margin:auto;
                margin-top:5px;
                display:flex;
                flex-direction:column;
                padding:20px;
                width:30%;
                background-color:rgba(0,0,0,0.3);
                color:white;
                font-family:Arial;
            }
            input{
                padding:10px;
                border:none;
                width:90%;
                border-radius:20px;
            }
            .btn{
                margin-top:10px;
                border:none;
                padding:10px;
                background-color:green;
                color:white;
                width:100%;
                border-radius:20px;
            }
            .btn:hover{
                background-color:green;
                color:white;
            }
            .forget{
                padding:10px;
            }
            .forget a{
                text-decoration:none;
                color:white;

            }
            .forget a:hover{
                color:black;
            }

        </style>
    </head>
    <body>
        <h2>Login Page</h2>
        <form action="MainController" method="post">
            <input type="text" placeholder="Nhập tên tài khoản" required name="txtUserID">
            <br>
            <input type="Password" placeholder="Nhập mật khẩu" required name="txtPassword">
            <p class="forget">
                <a href="createNewAccount.jsp">Bạn chưa có tài khoản?</a> <br>
                <font color="red">${requestScope.ERRORLOGIN.errorMsg}</font>
            </p>
            <input type="submit" value="Login" class="btn" name="btnAction">
        </form>
    </body>
</html>
