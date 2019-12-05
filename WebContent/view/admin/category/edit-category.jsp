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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<div class="container">
		<div class="navbar">
			<a href="#home">ComeOnBabiii</a>
			<div class="dropdown">
				<button class="dropbtn">
					User <i class="fa fa-caret-down"></i>
				</button>
				<div class="dropdown-content">
					<a href="#">User Profile</a> <a href="#">Setting</a>
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
			<h2 align="center">Thêm Category</h2>
			<div class="add-table">
				<div class="hr">
					<hr>
				</div>
				<form method="post" id="ha">
				 <input id="idInput" type="hidden" value="${category.id}">
					<label>Name</label> <input id="nameInput" type="text" value="${category.name}"
						required="">
					<div class="hr">
						<hr>
					</div>
					<label>Description</label> <input id="descriptionInput" type="text"
						name="description" value="${category.description}">
					<div class="hr">
						<hr>
					</div>
					<input type="button" name="addUser" id="submit" value="Submit"
						onclick="updateCategory()"> </br>
				</form>
			</div>
		</div>
	</div>
	<c:url value="/static/admin/js/category.js" var="test"></c:url>
	<script src="${test}"></script>
</body>

</html>