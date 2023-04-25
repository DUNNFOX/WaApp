<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="configur.css">
    <title>Document</title>
</head>
<body>
<h1>
    Hello Mr.Rahul ${user.firstName}
</h1>
<div class="main">
    <form action="/config" method="post">
    <b class="info">Please configur your whatsApp details</b><br><br>
    <label><b>PHONE NUMBER ID</b></label>:- <br><br><input type="text" name="phoneId" placeholder="Enter your Phone Number Id" class="box"><br><br>
        <label><b>WHATSAPP BUSINESS ACCOUNT ID</b></label>:- <br><br><input type="text" name="wbai" placeholder="Enter your Phone Number Id" class="box"><br><br>


        <label><b>AUTH KEY</b></label>:- <br><br><input type="password" name="key" placeholder="Enter your key" class="box"><br><br><br>
  <input type="submit" value="configure">
    </form>
</div>
</body>
</html>