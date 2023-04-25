<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1>Welcome Dear ${user.firstName}</h1>


<form action="/testMessage">

    <input type="number" name="to" placeholder="Enter the recipient number with the country code prefix... ">
    <input type="submit" value="send a Test message">
</form>

<form action="/textMessage">

    <input type="number" name="to" placeholder="Enter the recipient number with the country code prefix... ">
    <input type="text" name="message" placeholder="Enter the text message.....">
    <input type="submit" value="send a Text message">
</form>

<form action="/contactMessage">
    <input type="number" name="to" placeholder="Enter the recipient number with the country code prefix... ">
    <input type="submit" value="send a Contact message">
</form>


<textarea >
    ${msg}
</textarea>

<h2>Templates..</h2>
<table>
    <tr>
        <th>Template Id</th>
        <th>Template Name</th>
        <th>Template Status</th>
        <th>Template Category</th>
    </tr>
    <c:forEach var="template" items="${templates.data}">
    <tr>
        <td>${template.id}</td>
        <td>${template.name}</td>
        <td>${template.status}</td>
        <td>${template.category}</td>
    </tr>
    </c:forEach>
</table>
<a href="/createTemplate">Create Template</a>

</body>
</html>