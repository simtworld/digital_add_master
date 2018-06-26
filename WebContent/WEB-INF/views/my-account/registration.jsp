<style type="text/css">
	.checkbox label, .radio label, label, .label-on-left, .label-on-right {
	     color: red; 
	}
	
	.swal2-hide {
     -webkit-animation: ; 
    animation: ; 
}
</style>

<script>
/* $("#checkButton").click(function(){alert("hhh")
	checkOTP();
})
 */

</script>

<body class="off-canvas-sidebar">
	<div class="wrapper wrapper-full-page">
		<div class="full-page register-page" filter-color="black"
			data-image="<%=request.getContextPath()%>/assets/img/register.jpg">
			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="card card-signup">
							<h2 class="card-title text-center">Register</h2>
							<div class="row">
								<div class="col-md-5 col-md-offset-1">
									<div class="card-content">
										<div class="info info-horizontal">
											<div class="icon icon-rose">
												<i class="material-icons">timeline</i>
											</div>
											<div class="description">
												<h4 class="info-title">Marketing</h4>
												<p class="description">We've created the marketing
													campaign of the website. It was a very interesting
													collaboration.</p>
											</div>
										</div>
										<div class="info info-horizontal">
											<div class="icon icon-primary">
												<i class="material-icons">code</i>
											</div>
											<div class="description">
												<h4 class="info-title">Fully Coded in HTML5</h4>
												<p class="description">We've developed the website with
													HTML5 and CSS3. The client has access to the code using
													GitHub.</p>
											</div>
										</div>
										<div class="info info-horizontal">
											<div class="icon icon-info">
												<i class="material-icons">group</i>
											</div>
											<div class="description">
												<h4 class="info-title">Built Audience</h4>
												<p class="description">There is also a Fully
													Customizable CMS Admin Dashboard for this product.</p>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-5">
									<div class="social text-center">
										<button class="btn btn-just-icon btn-round btn-twitter">
											<i class="fa fa-twitter"></i>
										</button>
										<button class="btn btn-just-icon btn-round btn-dribbble">
											<i class="fa fa-dribbble"></i>
										</button>
										<button class="btn btn-just-icon btn-round btn-facebook">
											<i class="fa fa-facebook"> </i>
										</button>
										<h4>or be classical</h4>
									</div>
									<form class="form" name="registrationForm" id="registrationForm" method="POST" action="#">
										<div class="card-content">
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">face</i>
												</span> <input id="firstName" name="firstName" type="text" class="form-control"
													placeholder="First Name" required="true">
													<span style="color: red" id="firstNameError"></span>
											</div>
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">face</i>
												</span> <input id="lastName" name="lastName" type="text" class="form-control"
													placeholder="Last Name">
													<label style="color: red" id="lastNameError"></label>
											</div>
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">email</i>
												</span> <input id="email" name="email" type="text" class="form-control"
													placeholder="Email"  required="true">
													<span style="color: red" id="emailError"></span>
											</div>
											<div class="input-group">
												<span class="input-group-addon"> <i
													class="material-icons">email</i>
												</span> <input id="mobile" name="mobile" type="text" class="form-control"
													placeholder="Mobile Number" required="true" maxlength="10">
													<span style="color: red" id="mobileError"></span>
											</div>
											<div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">lock_outline</i>
                                                </span>
                                                <input id="password" name="password" type="password" placeholder="Password" class="form-control"  required="true"/>
                                                <span style="color: red" id="passwordError"></span>
                                            </div>
											<div class="input-group">
											<span class="input-group-addon"> <i class="material-icons">email</i></span>
											<div class="row" style="padding-left: 20px;">
												<select id="countries" name="countryCode" class="selectpicker" onchange="getStates()" data-style="btn btn-primary btn-round" title="Single Select" data-size="7" required="true">
													<option value="" disabled selected>Select Country</option>													
												</select>
												<span style="color: red" id="countriesError"></span>
											</div>
											</div>											
											<div class="input-group">
											<span class="input-group-addon"> <i class="material-icons">email</i></span>
											<div class="row" style="padding-left: 20px;">
												<select id="states" name="stateCode" class="selectpicker" onchange="getCities()" data-style="btn btn-primary btn-round" title="Single Select" data-size="7" required="true">
													<option value="" disabled selected>Select State</option>
												</select>
												<span style="color: red" id="statesError"></span>
											</div>
											</div>
											<div class="input-group" >
											<span class="input-group-addon"> <i class="material-icons">email</i></span>
											<div class="row" style="padding-left: 20px;">
												<select id="cities" name="cityCode" class="selectpicker" data-style="btn btn-primary btn-round" title="Single Select" data-size="7" >
													<option value="" disabled selected>Select City</option>
												</select>
												<span style="color: red" id="citiesError"></span>
											</div>
											</div>
										</div>
										<input id="uuid" type="hidden"/>
										<div class="footer text-center">
											<a href="javascript:void(0)" onclick="registration()" class="btn btn-primary btn-round">Register</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>




<script type="text/javascript">
$(function(){
	getCountries();
})

function getCountries(){
	$.ajax({url : "<%=request.getContextPath()%>/getallcountries",success : function(data){
		//data = JSON.parse(data);
		
		 $.each(data, function(i,val) {	
			$('#countries').append('<option value="'+val.countryCode+'">'+val.countryName+'</option>');
		}); 
		$('#countries').selectpicker('refresh');
	}
	});	
}

function getStates(){
	var countryCode = $("#countries").find('option:selected').val();

	if(countryCode != null && countryCode != ""){
		$.ajax({url : "<%=request.getContextPath()%>/getallstates",
			data : {countryCode : countryCode},success : function(data){		
						
			$('#states').find('option').remove();	
			$('#states').append('<option value="" selected>Select State</option>');
				
			 $.each(data, function(i,val) {	
				$('#states').append('<option value="'+val.stateCode+'">'+val.stateName+'</option>');
			}); 
			$('#states').selectpicker('refresh');
			$('#cities').find('option').remove();	
			$('#cities').append('<option value="" selected>Select City</option>');
			$('#cities').selectpicker('refresh');
		}
		});
	}else{
		$('#states').find('option').remove();	
		$('#states').append('<option value="" selected>Select State</option>');
		$('#states').selectpicker('refresh');
	}	
}

function getCities(){
	var stateCode = $("#states").find('option:selected').val();

	if(stateCode != null && stateCode != "-1"){
		$.ajax({url : "<%=request.getContextPath()%>/getallcities",
			data : {stateCode : stateCode},success : function(data){
								
			 $('#cities').find('option').remove();	
			 $('#cities').append('<option value="" selected>Select City</option>');
		
			 $.each(data, function(i,val) {	
				$('#cities').append('<option value="'+val.cityCode+'">'+val.cityName+'</option>');
			}); 
			$('#cities').selectpicker('refresh');
		}
		});
	}else{
		$('#cities').find('option').remove();	
		$('#cities').append('<option value="" selected>Select City</option>');
		$('#cities').selectpicker('refresh');
	}
}

function registration(){
	var check = $('#registrationForm').valid();
	if(check){		
		$.ajax({url : "<%=request.getContextPath()%>/customer-registration",
			data : $("#registrationForm").serialize(),success : function(data){
				//alert("test>> "+JSON.stringify(data));
				data = JSON.stringify(data);
				data = JSON.parse(data);
				
				if(data.status == "true"){
					alert(data.status)
					if(data.uuid != null && data.uuid != undefined){
						$("#uuid").val(data.uuid);
					}
					
					swal({
		                title: "Please Enter OTP",
		                //text: "Please Enter OTP",
		                html: '<div class="form-group"> <input id="otp" type="text" class="form-control" onkeydown="removeError()"/><div style="margin: 5px; color: red" id="otpError">'
		                	+'</div> <button class="btn btn-success" id="checkButton">Check</button>'
		                	+'<button class="btn btn-success" id="resendOtpButton">Resend OTP</button></div>',
		                buttonsStyling: false,
		                confirmButtonClass: "btn btn-success",
		                type: "success",
		                dismissible:false,
		                showConfirmButton: false
		            }).then(function(result){
		            	checkOTP();	
		            			            
		                 swal({
		                    type: 'success',
		                    html: 'You entered: <strong>' +
		                        $('#input-field').val() +
		                        '</strong>',
		                    confirmButtonClass: 'btn btn-success',
		                    buttonsStyling: false

		                }) 
					
					
					 swal({
		                title: "OK",
		                text: "Registration ",
		                buttonsStyling: false,
		                confirmButtonClass: "btn btn-success",
		                type: "success"
		            }); 
				});
				}else if(data.status == "false"){
					swal({
		                title: "Oops !!!",
		                text: "Some Error Occured, Please Try Again",
		                buttonsStyling: false,
		                confirmButtonClass: "btn btn-success",
		                type: "error",
		                dismissible:false
		            });
				}else if(data.status == "mobileExists"){
					swal({
		                title: "Oops !!!",
		                text: "Mobile Number Already Existed. Try To Login Or Use Forgot Password",
		                buttonsStyling: false,
		                confirmButtonClass: "btn btn-success",
		                type: "info",
		                dismissible:false
		            });
				}
				
				/* var status = $.each(data).find("status").text();
				
				alert(status); */
		}
		});
	}
}

$(document).on("click", "#checkButton", function(event){
	var otp = $("#otp").val();
	var mobile = $("#mobile").val();
	
	if(otp == null || otp == ""){
		$("#otpError").html("Please Enter OTP");
		return;
	}
	$.ajax({url : "<%=request.getContextPath()%>/check-otp",
		data : {otp : otp, mobile : mobile},success : function(data){			
			if(data.status == true){
				swal.close();
				
			    swal({
	                title: "OK",
	                text: "Registration Completed Successfully.",
	                buttonsStyling: false,
	                confirmButtonClass: "btn btn-success",
	                type: "success"
	            }).then(function(result){
	            	window.location = '<%=request.getContextPath()%>/login';
	            }); 
			}else if(data.status == false){
				$("#otpError").html("Incorrect OTP Entered, Please Check It Once");
			}else if(data.status == "exception"){
				$("#otpError").html("Error Occured, Please Try Again.");
			}
		}			
	});
});

$(document).on("click", "#resendOtpButton", function(event){
	var mobile = $("#mobile").val();
	
	$.ajax({url : "<%=request.getContextPath()%>/resend-otp",
		data : {mobile : mobile, uuid : $("#uuid").val()},success : function(data){			
			if(data.status == true){
				$("#otpError").html("OTP Send to your mobile number successfully.");
			}else{
				$("#otpError").html("Error Occured, Please Try Again.");
			}
		}			
	});
});

function removeError(){
	$('#otpError').html('');
}

// to validate customer form inputs 
$('#registrationForm').validate({
	    rules: {
		      	"firstName": {
			        required: true
		      	},		      	
		      	"lastName": {
			        required: true
		      	},
		      	"email": {
		      	   required: true,
				   email: true,
				   emailCheck:true
			  	},
			  	"mobile": {
			        required: true,
			        digits: true,
			        minlength: 10,
			        mobileNocheck:true
		      	},
			 	"password":{
			  	   required: true
			  	},
			  	"countries":{
			  		required: true
			  	},
			  	"states":{
			  		required: true
			  	},
			  	"cities":{
			  		required: true
			  	}
	  		},
	    messages: {
			       "firstName": {
				        required: 'Please enter your first name'
			       },
			       "lastName": {
				        required: 'Please enter your last name'
			       },
			       "email": {
			            required: 'Please enter email',
				        email: 'Please enter valid Email address'
				   },
			       "mobile": {
				        required: 'Please enter valid 10 digit Mobile number',
				        minlength: 'Please enter 10 digit Mobile number',
				        digits: 'Mobile number accept only numbers'
			       },			       
				   "password": {
				        required: 'Please enter password'
				   },
				   "countries":{
			  		   required: 'Please select country'
				   },
				   "states":{
				  	   required: 'Please select state'
				   },
			       "cities": {
				       required:'Please select city'
			       }     
			 },
		    errorPlacement:
			    function(error, element){
			    if (element.attr("id") == "firstName" ){
			    	document.getElementById("firstNameError").innerHTML="";
		          	error.appendTo('#firstNameError');
		        }else if (element.attr("id") == "lastName" ){
			    	document.getElementById("lastNameError").innerHTML="";
		          	error.appendTo('#lastNameError');
		        }else if (element.attr("id") == "email" ){
			    	document.getElementById("emailError").innerHTML="";
		          	error.appendTo('#emailError');
		        }else if (element.attr("id") == "mobile" ){
			    	document.getElementById("mobileError").innerHTML="";
		          	error.appendTo('#mobileError');
		        }else if (element.attr("id") == "password" ){
			    	document.getElementById("passwordError").innerHTML="";
		          	error.appendTo('#passwordError');
		        }else if (element.attr("id") == "countries" ){
			    	document.getElementById("countriesError").innerHTML="";
		          	error.appendTo('#countriesError');
		        }else if (element.attr("id") == "states" ){
			    	document.getElementById("statesError").innerHTML="";
		            error.appendTo('#statesError');
		        }else if (element.attr("id") == "cities" ){
			    	document.getElementById("citiesError").innerHTML="";
		            error.appendTo('#citiesError');
		        }
		        }
		});
		
//to validate Email Address
   $.validator.addMethod("emailCheck", function(email, element) {
	    email = email.replace(/\s+/g, ""); 
	    return this.optional(element) || email.match(/^[a-zA-Z0-9._]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,4}/);
	}, 'Please enter valid email');
	
// to validate initial digit of Mobile No
     $.validator.addMethod("mobileNocheck", function(mobileNo, element) {
      mobileNo = mobileNo.replace(/\s+/g, ""); 
       return this.optional(element) || mobileNo.match( /^[789]\d{9}$/);
   	}, 'Mobile number starts with 9 or 8 or 7');

</script>