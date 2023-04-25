<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        body {
            background-color: rgb(173, 213, 244);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .box {
            background-color: aliceblue;
            width: 40vw;
            height: 70vh;
            border-radius: 20px;
        }

        .logoimage {
            position: relative;
            top: 35px;
        }

        .content {
            position: relative;
            top: 50px;
        }

        .next {
            width: 60px;
            height: 30px;
            font-size: 17px;
            border-radius: 5px;
            outline: none;
            border: 0.9px solid black;
            position: relative;
            right: 31px;

        }

        .next:hover {
            background-color: black;
            color: aliceblue;
        }

        .mbn {
            border-radius: 0px 5px 5px 0px;
            outline: none;
            border: 0.9px solid black;
            padding: 5px;
            font-size: 15px;
            border-left: none;
            width: 20vw;
            height: 3vh;
        }

        .number {
            font-size: 21px;
            font-weight: 500;
            border: 2px solid black;
            border-right: none;
            border-radius: 5px 0px 0px 5px;
            background-color: white;
            display: inline-block;
            height: 25.4px;
            position: relative;
            top: 1px;
            padding: 2px;
        }


        .text {
            display: flex;
            float: right;
            position: relative;
            top: 70px;
            right: 20px;
            font-size: 18px;
        }

        .text a {
            text-decoration: none;
        }

        .pass {
            width: 22.7vw;
            height: 3vh;
            border-radius: 5px;
            outline: none;
            border: 0.9px solid black;
            padding: 5px;
            font-size: 15px;
        }
    </style>
    <title>Document</title>
</head>

<body>
<div class="box">
    <img class="logoimage" src="image/logo.svg" width="200px">
    <div class="content">
        <form action="/login" method="post">
            <h1 class="login">Login</h1><br><br>
            <label class="number">+91</label><input class="mbn" name="mobile" value="${mobile}"
                                                    type="number"><br><br>
            <input class="pass" name="password"  type="password"><br><br>
            <button class="next">Next</button>
            <h5 class="text">Don't have account?<a href="/regi">Register</a></h5>
        </form>
    </div>

</div>
</body>

</html>