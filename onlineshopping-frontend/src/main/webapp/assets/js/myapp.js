$(function() {
	//solving the active menu problem
	switch(menu) {
		case 'About us' :
		$('#about').addClass('active');
		break;
		
		case 'Contacts' :
		$('#contacts').addClass('active');
		break;
		
		case 'All Products' :
		$('#listProduct').addClass('active');
		break;
		
		default :
		if(menu =="Home") break;
		$('#listProduct').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
		
	}
	
	//code for jquery dataTables
	
	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		console.log('Inside the table!');
		console.log(window.contextRoot);
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		
		$table
				.DataTable({
				lengthMenu: [[3,5,10,-1], ['3 records', '5 records', '10 records', 'ALL']],
				pageLength: 5,
				
				ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
				columns:	[
					{
						data: 'code',
						mRender: function(data, type,row)
						{
							return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
						}
						
					},
					{
						data: 'name'
					},
					{
						data: 'brand'
					},
					{
						data: 'unitPrice',
						mRender: function(data, type,row)
						{
							return '&#8377; ' + data
						}
					},
					{
						data: 'quantity'
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row)
						{
							var str ='';
							str+= '<a href="'+window.contextRoot+ '/show/'+data+'/products" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							str+= '<a href="'+window.contextRoot+ '/cart/add/'+data+'/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							return str
						}
					}
				]
			}
			
		);
	}
	
	
});