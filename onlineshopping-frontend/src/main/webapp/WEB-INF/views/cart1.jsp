<!--  
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
-->
<!------ Include the above in your HEAD tag ---------->


<div class="cart-wrap">
	<div class="container">
		<c:choose>
			<c:when test="${not empty cartLines}">

				<div class="row">
					<div class="col-lg-8">
						<div class="main-heading">Shopping Cart</div>
						<div class="table-cart">
							<table id="cart" class="table table-hover table-condensed">
								<thead>
									<tr>
									<th style="width: 10%">Product</th>
									<th style="width: 10%">Name</th>
									<th style="width: 8%">Price</th>
									<th style="width: 8%">Quantity</th>
									<th style="width: 8%">Total</th>
									<th style="width: 10%"></th>
									</tr>
								</thead>
								
								<tbody>
								<c:forEach items="${cartLines}" var="cartLine">
									<tr>
										<td>
											<div class="display-flex align-center">
											
												<div class="img-product">
													<img
														src="${images}/${cartLine.product.code}.jpg"
														alt="${cartLine.product.name} 
														class="cartImg">
												</div>
												
												<div class="name-product">${cartLine.product.name}
													<c:if test="${cartLine.avaliable == false }">
														<strong class="unavaliable">(Not Avaliable)</strong>
													</c:if>
													<p>Brand - ${cartLine.product.brand}</p>
													<p>Description - ${cartLine.product.description}</p>
												</div>
												<div class="price">&#8377;${cartLine.buyingPrice}</div>
											</div>
										</td>
										
										<td class="product-count">
											<form action="#" class="count-inlineflex">
												<div class="qtyminus">-</div>
												<input type="text" name="quantity" value="${cartLine.productCount}" class="qty">
												<div class="qtyplus">+</div>
											</form>
										</td>
										
										<td>
											<div class="total">&#8377;${cartLine.total}</div>
										</td>
										<td><a href="#" title=""> <img
												src="images/icons/delete.png" alt="" class="mCS_img_loaded">
										</a></td>
									</tr>
									
									
									</c:forEach>
								</tbody>
							</table>
							<div class="coupon-box">
								<form action="#" method="get" accept-charset="utf-8">
									<div class="coupon-input">
										<input type="text" name="coupon code"
											placeholder="Coupon Code">
										<button type="submit" class="round-black-btn">Apply
											Coupon</button>
									</div>
								</form>
							</div>
						</div>
						<!-- /.table-cart -->
					</div>
					<!-- /.col-lg-8 -->
					<div class="col-lg-4">
						<div class="cart-totals">
							<h3>Cart Totals</h3>
							<form action="#" method="get" accept-charset="utf-8">
								<table>
									<tbody>
										<tr>
											<td>Subtotal</td>
											<td class="subtotal">${userModel.cart.grandTotal}</td>
										</tr>
										<tr>
											<td>Shipping</td>
											<td class="free-shipping">Free Shipping</td>
										</tr>
										<tr class="total-row">
											<td>Total</td>
											<td class="price-total">${userModel.cart.grandTotal}</td>
										</tr>
									</tbody>
								</table>
								<div class="btn-cart-totals">
									<a href="#" class="update round-black-btn" title="">Update
										Cart</a> <a href="#" class="checkout round-black-btn" title="">Proceed
										to Checkout</a>
								</div>
								<!-- /.btn-cart-totals -->
							</form>
							<!-- /form -->
						</div>
						<!-- /.cart-totals -->
					</div>
					<!-- /.col-lg-4 -->
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="jumbotron">
					<div class="text-center">
						<h1>Your Cart is Empty!</h1>
					</div>
				</div>
			</c:otherwise>

		</c:choose>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="	sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>