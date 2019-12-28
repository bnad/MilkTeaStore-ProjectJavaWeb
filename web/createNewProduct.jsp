<%-- 
    Document   : createNewProduct
    Created on : Aug 21, 2019, 3:16:57 PM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Product Page</title>
    </head>
    <style>
        *{
            margin: 0;
            padding: 0;
            outline: none;
            box-sizing: border-box;
            font-family: 'Raleway', sans-serif;
        }

        body{ 
            background: linear-gradient(to right, #d6d6d6,#ffffff);
            perspective: 600px;
            background-image: url('img/searchbg.jpg');
            background-size: fixed;
            background-repeat: no-repeat;
        }

        .cont{
            position: relative;
            width: 28%;
            height: 600px;
            margin: 50px auto;
            transition: all 0.4s linear;
        }

        /* .cont:hover{
          transform: rotateX(45deg) rotateY(10deg) rotateZ(-60deg)
        } */

        .main-box{ 
            width: 100%;
            height: 100%;
            text-align: center;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-image:  url('img/createbg.jpg');
            box-shadow: 0px 20px 50px 0px #000000;
        }

        .create {
            position: relative;
            width: 100%;
            height: 100%;
            padding: 18px 15px;
            background: rgba(19, 20, 27, 0.72);
        }

        h2, .user, .email, .pass, .confirm{ 
            display: block;
        }

        h2{ 
            text-align: center;
            color: #f7f3f2;
            font-weight: 400;
            font-size: 22px;
            margin-top: 20px;
            margin-bottom: 35%;
        }

        .user, .email, .pass{
            width: 85%;
            height: 45px;
            border: none;
            color: white;
            margin: 20px;
            padding-left: 40px;
            font-size: 18px;
            font-weight: 500;
            border-radius: 25px;
            margin-bottom: 0;
            background: rgba(158, 158, 158, 0.49);
        }

        input::placeholder{
            color: #fff;
            font-size: 16px;
            font-weight: 100;
            transition: all 0.4s ease;
        }

        input:focus::placeholder{
            opacity:0;
        }

        .fa {
            color: #67c5e7;
            font-size: 20px;
            position: relative;
            left: -36%;
            top: 33px;
        }

        .login{
            color: #fff;
            cursor: pointer;
            width: 85%;
            height: 50px;
            border: none;
            font-size: 18px;
            font-weight: 500;
            margin-top: 10%;
            background: #67c5e7;
            border-radius: 25px;
            transition: background 0.4s ease;
        }

        button.login:hover {
            background: #2196F3;
        }

        @media only screen and (min-width : 280px) {
            .cont{ width: 90% }
        }

        @media only screen and (min-width : 480px) {
            .cont{ width: 60% }
        }

        @media only screen and (min-width : 768px) {
            .cont{ width: 40% }
        }

        @media only screen and (min-width : 992px) {
            .cont{ width: 30% }
        }
    </style>
    <body>
        <div class="cont">
            <div class="main-box">
                <div class="create">
                    <form action="MainController">
                        <h2>Tạo sản phẩm</h2>
                        <i class="fa fa-fw fa-user-o" aria-hidden="true"></i>
                        <input type="text" required
                               class="user" name="txtCreateTeaID"
                               placeholder="Tea ID"/>

                        <i class="fa fa-fw fa-envelope-o" aria-hidden="true"></i>
                        <input type="text" required
                               class="email" name="txtCreateTeaName"
                               placeholder="Tea Name"/>

                        <i class="fa fa-fw fa-lock" aria-hidden="true"></i>
                        <input type="text" required
                               class="pass" name="txtCreatePrice"
                               placeholder="Price"/>
                        <br>
                        <font color="red">${requestScope.ERRORTEA.priceError}</font>
                        <br>
                        <font color="red">${requestScope.ERRORTEA.errorMsg}</font>
                        <input type="submit" value="Create Product" name="btnAction" class="login"/>
                    </form>
                </div>
            </div> 
        </div>
    </body>
</html>
