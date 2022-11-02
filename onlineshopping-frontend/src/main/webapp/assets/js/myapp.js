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
	//create a dataset
	var products =[
		
		['1','A'],
		['2','B'],
		['3','C'],
		['4','D'],
		['5','E'],
		['6','F']
			
	];
	
	var $table = $('#productListTable');
	
	//execute the below code only where we have this table
	if($table.length)
	{
		console.log('Inside the table');
		
		$table.DataTable(
			{
				lengthMenu: [[3,5,10,-1], ['3 records', '5 records', '10 records', 'ALL']],
				pageLength: 5,
				data: products
			}
			
		);
	}
	
	
});