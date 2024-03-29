<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cart</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<c:url value="/static/client/images/icons/favicon.png" var="favicon"/>
	<link rel="icon" type="image/png" href="${favicon }"/>
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/bootstrap/css/bootstrap.min.css" var="boostsrapMin"/>
	<link rel="stylesheet" type="text/css" href="${boostsrapMin }">
<!--===============================================================================================-->
	<c:url value="/static/client/fonts/font-awesome-4.7.0/css/font-awesome.min.css" var="awesome"/>
	<link rel="stylesheet" type="text/css" href="${awesome }">
<!--===============================================================================================-->
	<c:url value="/static/client/fonts/themify/themify-icons.css" var="themify"/>
	<link rel="stylesheet" type="text/css" href="${themify }">
<!--===============================================================================================-->
	<c:url value="/static/client/fonts/Linearicons-Free-v1.0.0/icon-font.min.css" var="iconFont"/>
	<link rel="stylesheet" type="text/css" href="${iconFont }">
<!--===============================================================================================-->
	<c:url value="/static/client/fonts/elegant-font/html-css/style.css" var="styleCss"/>
	<link rel="stylesheet" type="text/css" href="${styleCss }">
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/animate/animate.css" var="animate"/>
	<link rel="stylesheet" type="text/css" href="${animate }">
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/css-hamburgers/hamburgers.min.css" var="hambugers"/>
	<link rel="stylesheet" type="text/css" href="${hambugers }">
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/animsition/css/animsition.min.css" var="animsition"/>
	<link rel="stylesheet" type="text/css" href="${animsition }">
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/select2/select2.min.css" var="select2"/>
	<link rel="stylesheet" type="text/css" href="${select2 }">
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/slick/slick.css" var="slick"/>
	<link rel="stylesheet" type="text/css" href="${slick }">
<!--===============================================================================================-->
	<c:url value="/static/client/css/util.css" var="util"/>
	<link rel="stylesheet" type="text/css" href="${util }">
	<c:url value="/static/client/css/main.css" var="main"/>
	<link rel="stylesheet" type="text/css" href="${main }">
<!--===============================================================================================-->
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="/view/client/include/hearder.jsp"></jsp:include>

	<!-- Title Page -->
	<c:url value="/static/client/images/heading-pages-01.jpg" var="headingpage"/>
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(${headingpage});">
		<h2 class="l-text2 t-center">
			Cart
		</h2>
	</section>

	<!-- Cart -->
	<section class="cart bgwhite p-t-70 p-b-100">
		<div class="container">
			<!-- Cart item -->
			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
					<table class="table-shopping-cart">
						<tr class="table-head">
							<th class="column-1"></th>
							<th class="column-2">Product</th>
							<th class="column-3">Price</th>
							<th class="column-4 p-l-70">Quantity</th>
							<th class="column-5">Total</th>
						</tr>

						<tr class="table-row">
							<td class="column-1">
								<div class="cart-img-product b-rad-4 o-f-hidden">
									<c:url value="/static/client/images/item-10.jpg" var="item10"/>
									<img src="${item10 }" alt="IMG-PRODUCT">
								</div>
							</td>
							<td class="column-2">Men Tshirt</td>
							<td class="column-3">$36.00</td>
							<td class="column-4">
								<div class="flex-w bo5 of-hidden w-size17">
									<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
									</button>

									<input class="size8 m-text18 t-center num-product" type="number" name="num-product1" value="1">

									<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
									</button>
								</div>
							</td>
							<td class="column-5">$36.00</td>
						</tr>

						<tr class="table-row">
							<td class="column-1">
								<div class="cart-img-product b-rad-4 o-f-hidden">
									<c:url value="/static/client/images/item-05.jpg" var="item05"/>
									<img src="${item05 }" alt="IMG-PRODUCT">
								</div>
							</td>
							<td class="column-2">Mug Adventure</td>
							<td class="column-3">$16.00</td>
							<td class="column-4">
								<div class="flex-w bo5 of-hidden w-size17">
									<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
									</button>

									<input class="size8 m-text18 t-center num-product" type="number" name="num-product2" value="1">

									<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
									</button>
								</div>
							</td>
							<td class="column-5">$16.00</td>
						</tr>
					</table>
				</div>
			</div>

			<div class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
				<div class="flex-w flex-m w-full-sm">
					<div class="size11 bo4 m-r-10">
						<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="coupon-code" placeholder="Coupon Code">
					</div>

					<div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10">
						<!-- Button -->
						<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
							Apply coupon
						</button>
					</div>
				</div>

				<div class="size10 trans-0-4 m-t-10 m-b-10">
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
						Update Cart
					</button>
				</div>
			</div>

			<!-- Total -->
			<div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">
					Cart Totals
				</h5>

				<!--  -->
				<div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm">
						Subtotal:
					</span>

					<span class="m-text21 w-size20 w-full-sm">
						$39.00
					</span>
				</div>

				<!--  -->
				<div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm">
						Shipping:
					</span>

					<div class="w-size20 w-full-sm">
						<p class="s-text8 p-b-23">
							There are no shipping methods available. Please double check your address, or contact us if you need any help.
						</p>

						<span class="s-text19">
							Calculate Shipping
						</span>

						<div class="rs2-select2 rs3-select2 rs4-select2 bo4 of-hidden w-size21 m-t-8 m-b-12">
							<select class="selection-2" name="country">
								<option>Select a country...</option>
								<option>US</option>
								<option>UK</option>
								<option>Japan</option>
								<option>Viet Nam</option>
							</select>
						</div>

						<div class="size13 bo4 m-b-12">
						<input class="sizefull s-text7 p-l-15 p-r-15" type="text" name="state" placeholder="State /  country">
						</div>

						<div class="size13 bo4 m-b-22">
							<input class="sizefull s-text7 p-l-15 p-r-15" type="text" name="postcode" placeholder="Postcode / Zip">
						</div>

						<div class="size14 trans-0-4 m-b-10">
							<!-- Button -->
							<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
								Update Totals
							</button>
						</div>
					</div>
				</div>

				<!--  -->
				<div class="flex-w flex-sb-m p-t-26 p-b-30">
					<span class="m-text22 w-size19 w-full-sm">
						Total:
					</span>

					<span class="m-text21 w-size20 w-full-sm">
						$39.00
					</span>
				</div>

				<div class="size15 trans-0-4">
					<!-- Button -->
					<button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
						Proceed to Checkout
					</button>
				</div>
			</div>
		</div>
	</section>



	<!-- Footer -->
	<jsp:include page="/view/client/include/footer.jsp"></jsp:include>



	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



<!--===============================================================================================-->
	<c:url value="/static/client/vendor/jquery/jquery-3.2.1.min.js" var="jqueryMin"/>
	<script type="text/javascript" src="${jqueryMin }"></script>
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/animsition/js/animsition.min.js" var="animsitionMin"/>
	<script type="text/javascript" src="${animsitionMin }"></script>
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/bootstrap/js/popper.js" var="popper"/>
	<script type="text/javascript" src="${popper }"></script>
	<c:url value="/static/client/vendor/bootstrap/js/bootstrap.min.js" var="bootstrapMin"/>
	<script type="text/javascript" src="${bootstrapMin }"></script>
<!--===============================================================================================-->
	<c:url value="/static/client/vendor/select2/select2.min.js" var="select2"/>
	<script type="text/javascript" src="${select2 }"></script>
	<script type="text/javascript">
		$(".selection-1").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});

		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect2')
		});
	</script>
<!--===============================================================================================-->
	<c:url value="/static/client/js/main.js" var="mainjs"/>
	<script src="${mainjs }"></script>

</body>
</html>
