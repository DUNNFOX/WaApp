
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
<div class="container">
    <div class="leftside">
        <div class="header">
            <div class="userimage">
                <img class="cover" src="whatsappimage/sadeepsahrma.jpg" width="50px" height="50px">
            </div>
            <ul class="icon">
                <li><ion-icon name="scan-circle-outline"></ion-icon></li>
                <li><ion-icon name="chatbox"></ion-icon></li>
                <li><ion-icon name="ellipsis-vertical"></ion-icon></li>
            </ul>
        </div>
        <div class="search">
            <div>
                <input type="text" placeholder="search or start new chat">
                <ion-icon name="search-outline"></ion-icon>
            </div>
        </div>
        <div class="chatlist">
            <div class="block active">
                <div class="imgbx">
                    <img src="whatsappimage/rahul.jpg" width="50px" height="50px">
                </div>
                <div class="details">
                    <div class="listhead">
                        <h4>Rahul Saini</h4>
                        <p class="time">10:00</p>
                    </div>
                    <div class="massage">
                        <p>Sir This is almost complet your project</p>
                    </div>
                </div>
            </div>
            <div class="block unread">
                <div class="imgbx">
                    <img src="whatsappimage/yogesh.png" width="50px" height="50px">
                </div>
                <div class="details">
                    <div class="listhead">
                        <h4>Yogesh kumawat</h4>
                        <p class="time">6:47</p>
                    </div>
                    <div class="massage">
                        <p>Good morning sir</p>
                        <b>1</b>
                    </div>
                </div>
            </div>
            <div class="block active">
                <div class="imgbx">
                    <img src="whatsappimage/arjit.webp" width="50px" height="50px">
                </div>
                <div class="details">
                    <div class="listhead">
                        <h4>Ankit kumar</h4>
                        <p class="time">Yesterday</p>
                    </div>
                    <div class="massage">
                        <p>thankyou sir for help me</p>
                    </div>
                </div>
            </div>
            <div class="block active">
                <div class="imgbx">
                    <img src="whatsappimage/radharani.jpg" width="50px" height="50px">
                </div>
                <div class="details">
                    <div class="listhead">
                        <h4>Birbl</h4>
                        <p class="time">03/04/2023</p>
                    </div>
                    <div class="massage">
                        <p>hello sir</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="rightside">
        <div class="header">
            <div class="imgtext">

                <div class="userimage">
                    <img class="cover" src="whatsappimage/rahul.jpg" width="50px" height="50px">
                </div>
                <h4>Rahul Saini<br><span>online</span></h4>
            </div>
            <ul class="icon">
                <li><ion-icon name="search-outline"></ion-icon></li>
                <li><ion-icon name="ellipsis-vertical"></ion-icon></li>
            </ul>
        </div>
        <div class="chatbox">
            <div class="massege my_massege">
                <p>
                    Hii<br><span>12:10</span>
                </p>
            </div>
            <div class="massege frnd_massege">
                <p>
                    Yes <br><span>12:11</span>
                </p>
            </div><div class="massege my_massege">
            <p>
                What are you doing<br><span>12:13</span>
            </p>
        </div><div class="massege frnd_massege">
            <p>
                Complete your proj.<br><span>12:13</span>
            </p>
        </div><div class="massege my_massege">
            <p>
                What's Update<br><span>12:14</span>
            </p>
        </div><div class="massege frnd_massege">
            <p>
                Sir This is almost complet your project<br><span>12:15</span>
            </p>
        </div>
        </div>
        <div class="chatbox_input">
            <ion-icon name="happy-outline"></ion-icon>
            <ion-icon name="attach-outline"></ion-icon>
            <input type="text" placeholder="Type a message">
            <ion-icon name="mic"></ion-icon>
        </div>
    </div>

</div>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>

</html>