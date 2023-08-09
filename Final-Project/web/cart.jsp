<%-- 
    Document   : cart
    Created on : Mar 11, 2023, 1:41:06 PM
    Author     : DELL
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <c:if test="${sessionScope.role == null}">
                            <li><a href="contact.jsp">Contact</a></li>
                            </c:if>
                            <c:if test="${sessionScope.account == null}">
                            <li class="active">
                                <a href="login">Login
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li><a href="register">Register</a></li>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                            <li class="active">
                                <a href="profile">Profile
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li><a href="logout" style="text-decoration: underline">Logout(${account.userID})</a></li>
                            <li><a href="change">ChangePassword</a></li>
                            </c:if>
                            <c:if test="${sessionScope.role != null}">
                            <li><a href="manager">Manager</a></li>
                            </c:if>
                    </ul>
                </nav>
                <a href="cart"><img src="images/cart.png" width="30px" height="30px">${sessionScope.size}</a>
            </div>
        </div>


        <div class="small-container cart-page">
            <table>
                <tr>
                    <th>No</th>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Money</th>
                    <th>Action</th>
                </tr>
                <c:set var="o" value="${sessionScope.cart}"/>
                <c:set var="t" value="0"/>
                <c:forEach items="${o.items}" var="i">
                    <c:set var="t" value="${t+1}"/>
                    <tr>
                        <td>${t}</td>
                        <td>${i.product.name}</td>
                        <td>
                            <button>
                                <a href="process?num=-1&id=${i.product.id}" >-</a>
                            </button>
                            <input type="text" readonly value="${i.quantity}"/>
                            <button>
                                <a href="process?num=1&id=${i.product.id}">+</a>
                            </button>
                        </td>
                        <td><fmt:formatNumber pattern="#,###" value="${i.price}"/> </td>
                        <td><fmt:formatNumber pattern="#,###" value="${i.quantity*i.price}"/> </td>
                        <td>
                            <form action="process" method="post">
                                <input type="hidden" name="id" value="${i.product.id}"/>
                                <input type="submit" value="Return Item" style="width: 100px"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
                <p></p>
                <form action="checkout" method="post">
                    <input type="submit" style="margin-top: 30px" class="btn btn-primary" value="Check Out"/>
                </form>
        </div>


        <!-- ------------------------- footer -------------------------------- -->

        <div class="footer">
            <div class="small-container">
                <div class="row">
                    <div class="footer-col-1">
                        <h3>Download Our App</h3>
                        <p>Download App For Android And IOS Mobile Phone</p>
                    </div>
                    <div class="footer-col-2">
                        <img src="images/logo-white.png" alt="">
                        <p>Our Purposes Is Sustainably Make The Pleasure And
                            Benefits Of Technology Accessible To The Many.</p>
                    </div>
                    <div class="footer-col-3">
                        <h3>Usefull Links</h3>
                        <ul>
                            <li>Coupons</li>
                            <li>Blog Post</li>
                            <li>Return Policy</li>
                            <li>Join Affiliate</li>
                        </ul>
                    </div>
                    <div class="footer-col-4">
                        <h3>Follow Us</h3>
                        <ul>
                            <li>FaceBook</li>
                            <li>Twitter</li>
                            <li>Instagram</li>
                            <li>Youtube</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete category with id" + id)) {
                    window.location = "delete?id=" + id;
                }
            }
        </script>
        

    </body>

</html>