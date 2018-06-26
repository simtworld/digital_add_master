/*
 *script for submitting the addProduct form 
 */
$(document).ready(function () {
	/*$(document).ajaxStart(function(){
	    $("#wait").css("display", "block");
	});

	$(document).ajaxComplete(function(){
	    $("#wait").css("display", "none");
	});*/

$('form#addProductDetailsForm').submit(function(e) {
		e.preventDefault();
		var formData = new FormData(this);
		$('#myModal').modal('hide');
		$.ajax({
			url : "savefiles",
			type : 'POST',
			data : formData,
			success : function(data) {

				if (data) {
					
					swal("Done!", "Product successfully added!", "success");
					table.ajax.reload();
					$(this).trigger('reset');
				} else {
					//$('#myModal').modal('hide');
					swal("OOPS!", "Something went wrong, try again!", "error");
				}
			},
			cache : false,
			contentType : false,
			processData : false
		});
		$(this).trigger('reset');
	});


var table;

	table=$('#product_table')
			.DataTable(
					{
						'ajax' : {
							'url' : 'getProducts',
							'dataSrc' : ''
						},
						'columns' : [
								{
									'data' : 'productId'
								},
								{
									'data' : 'productName'
								},
								{
									'data' : 'puoductUrl'
								},
								{
									'data' : 'countryId'
								},
								{
									'data' : 'stateId'
								},
								{
									'data' : 'cityId'
								},
								{
									'data' : 'creationDate'
								},
								{
									data : null,
									"bSort" : false,
									className : "center",
									defaultContent : '<button class="btn btn-success edit">Edit</button> <button    class="btn btn-danger del" >Delete</button>'
								} ],
						"order" : [],
						select : true,
					}).columns.adjust();

	$('#product_table tbody').on('click', '.del', function() {
		var row = table.row($(this).parents('tr'));
		var data = row.data();
		var param = data.productId
		console.log(param);
		
		swal({
			  title: "Are you sure?",
			  text: "Once deleted, you will not be able to recover!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  $.ajax({
						url : "delete-product-list",
						type : 'POST',
						 data : {'productId':data.productId+"'"}, 
						data : {
							productID : param
						},
						success : function(response) {
							if (response) {
								console.log(row);
								console.log(row.remove().draw());
								swal("Done!", "Product successfully deleted!", "success");
							} else {
								swal("OOPS!", "Something went wrong, try again!", "error");
							}
						},
						error : function(e1, e2) {
							console.log(e1);
							console.log(e2);
						}

					});
			    
			  } else {
			    
			  }
			});
		
		

	});
	
	/* function to update/edit product details */
	$('#product_table tbody').on('click', '.edit', function() {
		var data = table.row($(this).parents('tr')).data();
		$('#myModal').modal('toggle');
		$("#productName").val(data.productName);
		$("#productUrl").val(data.puoductUrl);
		$("#productDescriptionForSms").val(data.smsDesc);
		$("#productDescriptionForEmail").val(data.emailDesc);
		$("#countries").val(data.countryId);
		
		getStates();// get state values from DB
		//function to set value to state
		var  stateVar= setInterval(function(){  
			$("#states option").each(function(){
                if($(this).val()== data.stateId){
                	$("#states").val($(this).val())
                	clearTimeout(stateVar);
                }
           });
		}, 100);

		
		getCities()// get cities values from DB
		//function to set value to cities
		var  cityVar= setInterval(function(){  
			$("#cities option").each(function(){
                if($(this).val()== data.cityId){
                	$("#cities").val($(this).val())
                	clearTimeout(cityVar);
                }
           });
		}, 100);

		$("#addProductDetailsSubmitbutton").hide();
		$("#addProductDetailsCancelbutton").hide();
		$("#updateProductDetailsbutton").show();
		$("#addProductDetailsCancelbutton").show();
		
	});
	
	$("#updateProductDetailsbutton").click(function(){
		alert("test");
	});
	
	$("#addProductDetailsButton").click(function(){
		$('form#addProductDetailsForm').trigger('reset');
		$("#updateProductDetailsbutton").hide();
		$("#addProductDetailsCancelbutton").hide();
		$("#addProductDetailsSubmitbutton").show();
		$("#addProductDetailsCancelbutton").show();
	});
});



var countryData;
var stateData;
var cityData;

/**
 * function to get Countries details from database
 */
$(document).ready(function () {
	$.ajax({url : "getallcountries",success : function(countryData){
		// data = JSON.parse(data);
		
		 $.each(countryData, function(i,val) {	
			$('#countries').append('<option value="'+val.countryCode+'">'+val.countryName+'</option>');
		}); 
		// $('#countries').selectpicker('refresh');
	}
	});	
});
/**
 * function to get States details from database
 */
function getStates(){
	var countryCode = $("#countries").find('option:selected').val();
	
	if(countryCode != null && countryCode != ""){
		$.ajax({url : "getallstates",
			data : {countryCode : countryCode},success : function(stateData){		
						
			$('#states').find('option').remove();	
			$('#states').append('<option value="" selected>Select State</option>');
				
			 $.each(stateData, function(i,val) {	
				$('#states').append('<option value="'+val.stateCode+'">'+val.stateName+'</option>');
			}); 
			// $('#states').selectpicker('refresh');
			$('#cities').find('option').remove();	
			$('#cities').append('<option value="" selected>Select City</option>');
			// $('#cities').selectpicker('refresh');
		}
		});
	}else{
		$('#states').find('option').remove();	
		$('#states').append('<option value="" selected>Select State</option>');
		// $('#states').selectpicker('refresh');
	}	
}

/**
 * function to get cities details from database
 */
function getCities(){
	var stateCode = $("#states").find('option:selected').val();
	
	if(stateCode != null && stateCode != "-1"){
		$.ajax({url : "getallcities",
							data : {
								stateCode : stateCode
							},
							success : function(cityData) {

								$('#cities').find('option').remove();
								$('#cities').append('<option value="" selected>Select City</option>');
								$.each(cityData, function(i, val) {
									$('#cities').append('<option value="'+val.cityCode+'">'+ val.cityName + '</option>');
								});
								// $('#cities').selectpicker('refresh');
							}
						});
			} else {
				$('#cities').find('option').remove();
				$('#cities').append(
						'<option value="" selected>Select City</option>');
				// $('#cities').selectpicker('refresh');
			}
		}









