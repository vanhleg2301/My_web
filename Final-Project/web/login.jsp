<%-- 
    Document   : cart
    Created on : Mar 11, 2023, 1:41:06 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>All Products - MoniterStore</title>
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    </head>

    <body>
        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <a href="home"><img src="images/logo-white.png" width="125px"></a>
                </div>
                <nav>
                    <ul class="menuItems">
                        <li><a href="home">Home</a></li>
                        <li><a href="product">Products</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                        <li><a href="login">Login</a></li>
                        <li><a href="register">Register</a></li>
                    </ul>
                </nav>
                <a href="cart"><img src="images/cart.png" width="30px" height="30px"></a>
            </div>
        </div>
        <!-- --------------- acount page ---------------- -->
        <div class="hero">
            <div class="form-box">
                <div class="button-box">
                    <div id="btn"></div>
                    <button type="button" class="toggle-btn" onclick="login()">Login</button>
                </div>
                <div class="icons-social">
                    <a href="https://www.facebook.com/"><img src="images/fb.png" alt=""></a>
                    <a href="https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fmyaccount.google.com%3Futm_source%3Daccount-marketing-page%26utm_medium%3Dcreate-account-button&flowName=GlifWebSignIn&flowEntry=SignUp"><img src="images/gp.png" alt=""></a>
                    <a href="https://twitter.com/i/flow/login"><img src="images/tw.png" alt=""></a>
                </div>

                <div id="login" class="input-group">
                    <h3 style="color: white">${requestScope.ms}</h3>
                    <form action="login" method="post">
                        <input name="Email" type="text" class="input-field" placeholder="Email" required>
                        <input name="Password" type="password" class="input-field" placeholder="Password" required>
                        <input name="re" type="checkbox" class="check-box" ><span>Remember Password</span>
                        <input type="submit" class="submit-btn" value="Login">
                    </form>
                </div>
            </div>
        </div>

        <script src="assets/js/appValidate.js"></script>
    </body>

</html>
