<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        .lable {
            width: 15%;
            display: inline-block;
            height: 25px;
            text-align: left;
        }

        .value {
            width: 72%;
            display: inline-block;
            height: 25px;
        }

        input,
        select {
            width: 90%;
            height: 33px;
            margin: 8px;

            outline: none;
            border: 1px solid #0b96ec;
            font-size: 16px;
            font-weight: 550;
        }

        .pBtn {
            border-right: 2px solid white;
            cursor: pointer;
            color: #0b96ec;
            float: right;
            width: 85%;
            font-size: 8px;
            padding: 0px;
            margin: 0px;
            text-align: right;
        }

        textarea {
            margin-top: 5px;
            width: 90%;
            height: 40px;
        }
    </style>
</head>

<body>

<div style="text-align: center;">

    <div style="width: 70vw; height: 92vh; margin: 0 auto; border: 1px solid #0b96ec;">
        <h2>Create Template..</h2>
        <form action="/createTemplate" method="post">

            <div class="lable"><label>Name</label></div>
            <div class="value"><input type="text" placeholder="Enter Template Name" name="name"></div>

            <div class="lable"><label>Catagory</label></div>
            <div class="value"><select name="catagory">
                <option value="AUTHENTICATION">Authenticution</option>
                <option value="MARKETING">Markting</option>
                <option value="UTILITY">Utility</option>

            </select></div>

            <div class="lable"><label>Lanaguage</label></div>
            <div class="value"><select name="lang">
                <option value="en_US">English US</option>
                <option value="hi">Hindi</option>
                <option value="en_US">Other Language are under development</option>
            </select></div>


            <div class="lable"><label>Header Text</label></div>
            <div class="value"><textarea type="text" name="ht" placeholder="  Type Header text"> </textarea></div>
            <p class="pBtn" onclick="addVariable('header')">Add Variable to Header</p>

            <div class="lable"><label>Body Text</label></div>
            <div class="value"><textarea type="text" placeholder="Enter body text " name="bt"> </textarea></div>

            <p class="pBtn" onclick="addVariable('body')">Add Variable to Body</p>
            <div class="lable"><label>Footer Text</label></div>
            <div class="value"><textarea type="text" placeholder="Enter footer text " name="ft"> </textarea></div>

            <div class="lable"><label>Call Button</label></div>
            <div class="value">
                <div style="width: 98%">
                    <input type="text" name="btnText" style="width: 43%" placeholder="type the text for button">
                    <input type="number" name="btnNumber" style="width: 43%" placeholder="type the phone number ">
                </div>
            </div>

            <div class="lable"><label>Visit Web Button</label></div>
            <div class="value">
                <input type="text" name="urlText" style="width: 43%" placeholder="type the text for button">
                <input type="text" name="url" style="width: 43%" placeholder="paste your url here..">
            </div>


            <div id="div1"></div>
            <input type="submit" value="Create" style="background-color: #0b96ec; color: white; outline: none;">

        </form>
    </div>
</div>

<script>
    var hdCount = 1;
    var bdCount = 1;

    function addVariable(variableTo) {
        var form = document.forms[0];
        if (variableTo == "header") {
            if (hdCount > 1) {
                alert("only one variable allowed in header");
                return;
            }
            form.ht.value = form.ht.value + '{{' + hdCount + '}}';
            hdCount++;
            document.getElementById("div1").innerHTML = document.getElementById("div1").innerHTML + "<input type='text' style='width:30%'; name='hdExp' placeholder='type header example value' required >";
        } else if (variableTo == "body") {
            form.bt.value = form.bt.value + '{{' + bdCount + '}}';
            bdCount++;
            document.getElementById("div1").innerHTML = document.getElementById("div1").innerHTML + "<input type='text' name='bdExp' style='width:30%'; placeholder='type body example value' required >";

        }
    }

</script>
</body>

</html>