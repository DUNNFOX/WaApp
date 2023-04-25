<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="sandeepsir.css">
    <title>Document</title>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="image/padlock.png" width="30px"><a href="/regi">Registration</a> &nbsp; <a href="/login">Login</a>
    </div>
</div>
<div class="container">
    <img class="flag" src="image/flag-animation.gif" width="40px">
    <img class="logosvg" src="image/logo.svg" width="150px">
</div>
<p style="color: red"> ${msg}</p>
</body>
</html>