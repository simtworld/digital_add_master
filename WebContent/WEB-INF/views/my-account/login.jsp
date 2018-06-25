<style type="text/css">
	 .form-group label {
	     color: red; 
	}
	
	.login-page .card-login .btn-wd {
	    min-width: 100px;
	}
</style>


<body class="off-canvas-sidebar">
    <div class="wrapper wrapper-full-page">
        <div class="full-page login-page" filter-color="black" data-image="<%=request.getContextPath() %>/assets/img/login.jpg">
            <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
            <div class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                            <form name="loginForm" id="loginForm" method="POST" action="#">
                                <div class="card card-login card-hidden">
                                    <div class="card-header text-center" data-background-color="rose">
                                        <h4 class="card-title">Login</h4>
                                        <div class="social-line">
                                            <a href="#btn" class="btn btn-just-icon btn-simple">
                                                <i class="fa fa-facebook-square"></i>
                                            </a>
                                            <a href="#pablo" class="btn btn-just-icon btn-simple">
                                                <i class="fa fa-twitter"></i>
                                            </a>
                                            <a href="#eugen" class="btn btn-just-icon btn-simple">
                                                <i class="fa fa-google-plus"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <p class="category text-center" id="loginError" style="color: red;"></p>                                    
                                    <div class="card-content">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">face</i>
                                            </span>
                                            <div class="form-group label-floating">
                                                <label class="control-label">User Name / Mobile</label>
                                                <input type="text" class="form-control" id="userName" name="userName">
                                                <span style="color: red" id="userNameError"></span>
                                            </div>
                                        </div>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock_outline</i>
                                            </span>
                                            <div class="form-group label-floating">
                                                <label class="control-label">Password</label>
                                                <input type="password" class="form-control" id="password" name="password">
                                                <span style="color: red" id="passwordError"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <input id="uuid" type="hidden"/>
                                    <div class="footer text-center">
                                        <button type="button" id="login" onclick="checkLogin()" class="btn btn-rose btn-simple btn-wd btn-lg">Let's go</button>
                                        <button type="button" onclick="openForgotPasswordPopup()" class="btn btn-rose btn-simple btn-wd btn-lg">Forgot Password</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</body>
<script>
var input=document.getElementById("password")
	input.addEventListener("keyup", function(event) {
	  // Cancel the default action, if needed
		  event.preventDefault();
	  // Number 13 is the "Enter" key on the keyboard
	 		 if (event.keyCode === 13) {
	    // Trigger the button element with a click
	    document.getElementById("login").click();
	  }
	});
</script>
<script>

	function checkLogin(){
		var check = $('#loginForm').valid();
		
		if(check){		
			$.ajax({url : "<%=request.getContextPath()%>/check-user-login",
				data : {userName : $("#userName").val(), password : $("#password").val()},success : function(data){					
					if(data.status == true){
						window.location = '<%=request.getContextPath()%>/dashboard'
					}else if(data.status == "mobileNeedToVerify"){
						if(data.uuid != null && data.uuid != undefined){
							$("#uuid").val(data.uuid);
						}
						swal({
			                title: "Please Enter OTP",
			                html: '<div class="form-group"> <input id="otp" type="text" class="form-control" onkeydown="removeError(this.id)"/><div style="margin: 5px; color: red" id="otpError">'
			                	+'</div> <button class="btn btn-success" id="checkButton">Check</button>'
			                	+'<button class="btn btn-success" id="resendOtpButton">Resend OTP</button></div>',
			                buttonsStyling: false,
			                confirmButtonClass: "btn btn-success",
			                type: "success",
			                dismissible:false,
			                showConfirmButton: false
			            })
					}else if(data.status == false){
						$("#loginError").html('User Name Or Password Wrong');
					}else{
						$("#loginError").html('Some error occured, Please try again');
					}
			}
			});
		}
	}
	
	function openForgotPasswordPopup(){
		swal({
            title: "Forgot Password",
            html: '<div class="form-group"> <input id="forgotMobile" maxlength="10" type="text" class="form-control" onkeydown="removeError(this.id)" placeholder="Enter Mobile Number Here"/><div style="margin: 5px; color: red" id="forgotMobileError">'
            	+'</div> <button class="btn btn-success" id="forgotPasswordButton">Get Password</button>'
            	+'<button class="btn btn-success" id="cancelButton">Cancel</button></div>',
            buttonsStyling: false,
            confirmButtonClass: "btn btn-success",
            //type: "success",
            dismissible:false,
            showConfirmButton: false
        })
	}
	
	$(document).on("click", "#cancelButton", function(event){
		swal.close();		
	});
	
	$(document).on("click", "#forgotPasswordButton", function(event){
		var mobile = $("#forgotMobile").val();
		
		if(mobile != null && mobile != "" && mobile.length >= 10){
			$.ajax({url : "<%=request.getContextPath()%>/forgot-password",
				data : {mobile : mobile},success : function(data){			
					if(data.status == true){
						$("#loginError").html("Credentials Send To Your Mobile Successfully, Please Login");
						
						swal.close();
					}else if(data.status == "Mobile Not Exists"){
						$("#forgotMobileError").html("Please Enter Valid Mobile Number");
					}else{
						$("#forgotMobileError").html("Error Occured, Please Try Again.");
					}
				}			
			});
		}else{
			$("#forgotMobileError").html('Please Enter 10 Digit Mobile Number');
		}		
	});
	
	function removeError(id){
		$('#'+id+'Error').html('');
	}
	
	$(document).on("click", "#checkButton", function(event){
		var otp = $("#otp").val();
		var mobile = $("#userName").val();
		
		if(otp == null || otp == ""){
			$("#otpError").html("Please Enter OTP");
			return;
		}
		$.ajax({url : "<%=request.getContextPath()%>/check-otp",
			data : {otp : otp, mobile : mobile, doLogin : "doLogin"},success : function(data){			
				if(data.status == true){
					swal.close();
					
				    swal({
		                title: "OK",
		                text: "Registration Completed Successfully.",
		                buttonsStyling: false,
		                confirmButtonClass: "btn btn-success",
		                type: "success"
		            }).then(function(result){
		            	window.location = '<%=request.getContextPath()%>/dashboard';
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
		var mobile = $("#userName").val();
		
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
	
	// to validate customer form inputs 
	$('#loginForm').validate({
		    rules: {
			      	"userName": {
				        required: true
			      	},		      	
			      	"password": {
				        required: true
			      	}
		  		},
		    messages: {
				       "userName": {
					        required: 'Please Enter User Name'
				       },
				       "password": {
					        required: 'Please Enter Password'
				       }    
				 },
			    errorPlacement:
				    function(error, element){
					    if (element.attr("id") == "userName" ){
					    	document.getElementById("userNameError").innerHTML="";
				          	error.appendTo('#userNameError');
				        }else if (element.attr("id") == "password" ){
					    	document.getElementById("passwordError").innerHTML="";
				          	error.appendTo('#passwordError');
				        }
			        }
			});
</script>

