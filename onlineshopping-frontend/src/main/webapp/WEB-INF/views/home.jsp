
<div class="container">

	<div class="row">

		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img class="slide-image" src="data:image/jpeg;base64,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1h73Cw83LesJ5u6ogCSSCjZ9ynYHO7jawv23KwXyb78fuyZfaN7/AAxpganlXiUvsMhomHe+zn/i/wCixP0GWsdaWarr3XvlZmygjeAb6futXXMN5AUUVi9r6h/GZ5I+VtgfG62Wmp2RtyxsZG0e6xrWjyCpm9fqw2va3xS5Pg/N7UOseihpRxf1394JuQewgLb8M5Bwx6zSyzOO3XK3yGo8CFtqKJyW8OUWjw2GH7KNjDxA63zHVS1RFWCIiAiIgIiIKoiIKIiICIiAiIghY1hzaqnmgda0rS0E7nbWu8HAHwXz7jFI50EjHAiajcX67bN6srfCwPwFfR65Bzp0T6OrZWRtvFU6O006QN67D+80Zu3rcFbjnxI06hqOlja8bSNewjaFKa3eVi3x/RrzwgvpZDcjaYnfcP8AQ7xZSYsRifqJG9xIB8ivoul6uuSsRadW8/3D1cOet68zylOddWqJNiULNsje5pzHyCiNxh0py00Ekx2aA29L+tldk6vDj72j8/hZbNSveWWVk0zWC73NaOLiB+aguw6sd9vLDSNO4uBf8rbn1XpQcn4JH2YyrxCXeGtc1vjlu63eVjye04/RX/fDNbrax8MPCfH4Wmzc0jjoAwbfPb4K5grphdkLadh9+chv81v5VvmD8g69wGSKlw5h2mzXSW+G5J7yFs2H82VO0h9VNPVP33cY2+QOb8SwZevy27219P77s1uqyW/w47+g2uI+k1UkxP8Al07TYngHO0Pg1bRgnIWZ1jBQNjH+pWXJ7wJNnwtXZsOwinphaCGKLtYwBx73bT4lTlitl3O/zyomZnmXPqTm5e8AVdU4jeynGUdwc7S3wrY8L5HUNNYx08ZcNc0t5HX4gvvbwss6i4m8yCIi5BERAREQEREBERAREQEREFVRVVEBERAREQEREBQ8ZwqKrgkp52545BYjYQRqHNO5wOoKmIg4jinIetw97nQtdUwH3o25iW8JYhqD2jTtGxa1UQ0hJ6WmDH7xHK6PX9zcvpRFbGTjUwPn3CuTLpT/AIXDHycH1Dnlnfd9meq3Oh5vKyQWqKmOmj/06ZpJtw0ygeq6eqKPeT44Q1PC+bvD4LF0bqh/3qh2YH4BZp8QtpghbG0Mja1jRsaxoaB3AaK9FxMzPdIiIoBERAREQEREBERAREQEREBERAREQEREFUREFEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERBVERBRERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQVREQf/9k="
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR8TnkwN5U_T42oX_UWz9LQvsPj1dJ-8Ridg&usqp=CAU"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="http://placehold.it/800x300"
									alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>

			<div class="row">

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4 class="pull-right">$24.99</h4>
							<h4>
								<a href="#">First Product</a>
							</h4>
							<p>
								See more snippets like this online store item at <a
									target="_blank" href="http://www.bootsnipp.com">Bootsnipp -
									http://bootsnipp.com</a>.
							</p>
						</div>
						<div class="ratings">
							<p class="pull-right">15 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4 class="pull-right">$64.99</h4>
							<h4>
								<a href="#">Second Product</a>
							</h4>
							<p>This is a short description. Lorem ipsum dolor sit amet,
								consectetur adipiscing elit.</p>
						</div>
						<div class="ratings">
							<p class="pull-right">12 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4 class="pull-right">$74.99</h4>
							<h4>
								<a href="#">Third Product</a>
							</h4>
							<p>This is a short description. Lorem ipsum dolor sit amet,
								consectetur adipiscing elit.</p>
						</div>
						<div class="ratings">
							<p class="pull-right">31 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4 class="pull-right">$84.99</h4>
							<h4>
								<a href="#">Fourth Product</a>
							</h4>
							<p>This is a short description. Lorem ipsum dolor sit amet,
								consectetur adipiscing elit.</p>
						</div>
						<div class="ratings">
							<p class="pull-right">6 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="http://placehold.it/320x150" alt="">
						<div class="caption">
							<h4 class="pull-right">$94.99</h4>
							<h4>
								<a href="#">Fifth Product</a>
							</h4>
							<p>This is a short description. Lorem ipsum dolor sit amet,
								consectetur adipiscing elit.</p>
						</div>
						<div class="ratings">
							<p class="pull-right">18 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star"></span> <span
									class="glyphicon glyphicon-star-empty"></span>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>
						<a href="#">Like this template?</a>
					</h4>
					<p>
						If you like this template, then check out <a target="_blank"
							href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this
							tutorial</a> on how to build a working review system for your online
						store!
					</p>
					<a class="btn btn-primary" target="_blank"
						href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View
						Tutorial</a>
				</div>

			</div>

		</div>

	</div>

</div>
<!-- /.container -->