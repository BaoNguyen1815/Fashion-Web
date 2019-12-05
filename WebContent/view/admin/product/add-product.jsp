<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <c:url value="/static/admin/css/admin.css" var="bootstrap"></c:url>
    <link href="${bootstrap}" rel="stylesheet" type="text/css" media="all">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container">
        <div class="navbar">
            <a href="#home">ComeOnBabiii</a>
            <div class="dropdown">
                <button class="dropbtn">User
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <a href="#">User Profile</a>
                    <a href="#">Setting</a>
                    <hr />
                    <a href="#">Log out</a>
                </div>
            </div>
        </div>

        <div class="sidenav">
            <a href="/Fashion/admin/user/list">User</a>
            <a href="/Fashion/admin/category/list">Category</a>
            <a href="/Fashion/admin/product/list">Product</a>
            <a href="/Fashion/admin/cart/list">Cart</a>
        </div>

        <div class="add-content">

            <br>
            <h2 align="center">Thêm Product</h2>
            <div class="add-table">
                <div class="hr">
                    <hr>
                </div>
                <form method="post" id="ha">
                    <label >Name</label>
                    <input id="nameInput" type="text" name="name" required="">
                    <div class="hr">
                        <hr>
                    </div>
                    <label >Price</label>
                    <input id="priceInput" type="text" name="price" required="">
                    <div class="hr">
                        <hr>
                    </div>
                    <label>Category</label>
                     <select id = "categoryInput" name="category">
							<c:forEach items="${categories}" var="c">
								<option value="${c.id}">${c.id}</option>
							</c:forEach>
					</select>
                    <div class="hr">
                        <hr>
                    </div>
                    <label>Image product</label>
                    <input type="file" name="image"> </br>
                                   
                    <input type="button" name="add" id="submit" value="Submit" onclick="insertProduct()"> </br>
                </form>
            </div>
        </div>
    </div>
    <c:url value="/static/admin/js/product.js" var="test"></c:url>
    <script src="${test}"></script>
</body>

</html>