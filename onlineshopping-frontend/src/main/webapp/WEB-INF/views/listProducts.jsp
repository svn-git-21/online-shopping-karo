<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- display the actual products -->
		<div class="col-md-9">

			<!-- added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProduct == true}">

						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProduct == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">

				<div class="col-xs-12">
					<div class="container-fluid">
						<div class="table-responsive">

							<table id="productListTable"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Brand</th>
										<th>Unit Price</th>
										<th>Quantity</th>
										<th></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>