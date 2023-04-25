<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="regi.css">
    <title>Document</title>
</head>
<body>
<p style="color: red;position: absolute; bottom: 26%"> ${msg}</p>
<div class="contanir">
    <form action="/regi" method="post">
        <h1>Signup</h1><br><br>
        <label>firstName</label>:-<input type="text" name="firstName" value="${user.firstName}" placeholder=" enter your firstname"><br><br>
        <label>lastName</label>:-<input type="text" name="lastName" value="${user.lastName}" placeholder=" enter your lastname"><br><br>
        <label>mobileNo.</label>:-<input type="number" name="mobile" value="${user.mobile}" ><br><br>
        <label>email</label>:-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" value="${user.email}" placeholder=" enter your email"><br><br>
        <label>password</label>:-<input type="password" name="password"><br><br>
        <input type="submit" class="sumit" value="Submit">&nbsp;&nbsp;&nbsp;
        <a href="/login" class="login">login</a>
    </form>

</div>

</body>