<%-- 
    Document   : createNewAccount
    Created on : Aug 20, 2019, 9:29:50 AM
    Author     : Bui Be Bong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
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

        .user, .email, .pass, .confirm{
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
                        <h2>Tạo tài khoản</h2>
                        <i class="fa fa-fw fa-user-o" aria-hidden="true"></i>
                        <input type="text" required
                               class="user" name="txtCreateUserID"
                               placeholder="Tên đăng nhập"/>

                        <i class="fa fa-fw fa-envelope-o" aria-hidden="true"></i>
                        <input type="text" required
                               class="email" name="txtCreateUserName"
                               placeholder="Họ và tên"/>

                        <i class="fa fa-fw fa-lock" aria-hidden="true"></i>
                        <input type="password" required
                               class="pass" name="txtCreatePassword"
                               placeholder="Mật khẩu"/>
                        <input type="password" required
                               class="confirm" name="txtCreateConfirm"
                               placeholder="Xác nhận mật khẩu"/> <br>
                        <font color="red">${requestScope.ERRORUSERID.errorMsg}</font>
                        <font color="red">${requestScope.ERRORCONFIRM.confirmError}</font>
                        <input type="submit" value="Create" name="btnAction" class="login"/>
                    </form>
                </div>
            </div> 
        </div>
    </body>
</html>
