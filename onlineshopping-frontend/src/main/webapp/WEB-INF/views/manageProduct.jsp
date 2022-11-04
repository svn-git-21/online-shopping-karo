<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">

			<div class="panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">

					<!-- form elements -->
					<sf:form class="form-horizontal" modelAttribute="Product">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control"/>
									<em class="help-block">Please enter product Name !</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control"/> 
									<em class="help-block">Please enter brand Name !</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" class="form-control" 
								placeholder="Description" rows="4"></sf:textarea>
								<em class="help-block">Please enter description !</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price in &#8377" class="form-control"/>
								<em class="help-block">Please enter brand Name !</em>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity in &#8377" class="form-control"/>
								<em class="help-block">Please enter Quantity !</em>
							</div>
						</div>

						<!--  
						<div class="form-group">
							<label for="formFile" class="control-label col-md-4">Upload Image</label>
							<div class="col-md-8">
								<input class="form-control" type="file" id="formFile"> 
								<em class="help-block">Please upload image</em>
							</div>
						</div>
						
						-->

						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select class="from-control" id="categoryId" path="categoryId"
								items="${categories}"
								itemLabel="name"
								itemValue="id"
								/>
								
								</select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary">
								<!-- Hidden Fields for Products -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="active"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
