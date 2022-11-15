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
		
		case 'Manage Product' :
		$('#manageProduct').addClass('active');
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
						data: 'quantity',
						mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
					},
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row)
						{
							var str ='';
							str+= '<a href="'+window.contextRoot+ '/show/'+data+'/products" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							if(row.quantity < 1)
							{
								str+= '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							else
							{
								str+= '<a href="'+window.contextRoot+ '/cart/add/'+data+'/products" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							
							return str
						}
					}
				]
			}
			
		);
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');
	if($alert.length)
	{
		setTimeout(function()
		{
			$alert.fadeOut('slow')
		}
		
		, 3000)
	}
	
	// --------------------------
	
	
	//data table for Admin
		var $adminProductTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductTable.length) {
		console.log('Inside the table!');
		console.log(window.contextRoot);
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductTable
				.DataTable({
				lengthMenu: [[10,30,50,-1], ['10 records', '30 records', '50 records', 'ALL']],
				pageLength: 30,
				
				ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
				columns:	
				[
					{
						data: 'id'
					},
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
						data: 'quantity',
						mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
					},
					{
						data: 'unitPrice',
						mRender: function(data, type,row)
						{
							return '&#8377; ' + data
						}
					},
					{
						data: 'active',
						bSortable: false,
						mRender: function(data, type, row)
						{
							var str = '';
							str += '<label class="switch">';
							
							if(data)
							{
								str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
							}
							else
							{
								str += '<input type="checkbox" value="'+row.id+'"/>';
							}
							
							str +='<div class="slider"></div></label>';
							
							return str;
							
						}
					},
					
					{
						data: 'id',
						bSortable: false,
						mRender: function(data, type, row)
						{
							var str = '';
							str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
							str += '<span class="glyphicon glyphiconicon-pencil"></span></a>'
							
							return str;

							
						}
					}
				],
				
				
				initComplete: function()
				{
					var api=this.api();
					api.$('.switch input[type="checkbox"]').on('change',function()
					{
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked)? 'Do you want to activate the product?':
												'Do you want to de-activate the product?';
						var value = checkbox.prop('value');
						
						bootbox.confirm
						(
							{
							size: 'medium',
							title: 'Product activation and Deactivation',
							message: dMsg,
							callback: function(confirmed)
							{
								if(confirmed)
								{
									console.log(value);
									
									var activationURL = window.contextRoot + '/manage/product/' + value + '/activation';
									$.post(activationURL, function(data)
									{
										bootbox.alert
										({
											size: 'medium',
											title: 'Information',
											message: data
										});
									});
								}
								else
								{
									checkbox.prop('checked', !checked);
								}
							}
						});
					});
				}
			}
			
		);
	}
	
	
	
	
});