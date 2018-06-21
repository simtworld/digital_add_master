


            
 <%@page import="com.digitaladd.model.UserMO"%>
 
 <style type="text/css">	
	.error{
		color: red !important;
	}
</style> 
 <script type="text/javascript">
 $(function(){
	 <%UserMO user = (UserMO)session.getAttribute("bean");%>
		/* var data = $("user");
		
		console.log("data--"+data.toString());
		alert(data) */
 })
 </script>
            
   <div class="main-panel">
      <div class="content">
         <div class="container-fluid">
           <div class="row">   
           		<div class="col-md-12">
                            <div class="card">
                                <!-- <form method="get" action="http://demos.creative-tim.com/" class="form-horizontal"> -->
                                <div class="form-horizontal" id="viewDiv">
                                    <div class="card-header card-header-text" data-background-color="rose">
                                        <h4 class="card-title">My Profile</h4>
                                    </div>
                                    <%-- <div class="card-content">
                                   		<div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">First Name</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getFirstName() != null ? user.getFirstName() : "" %></p>
                                                </div>
                                            </div>
                                        </div>
                                    
                                    	<div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Last Name</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getLastName() != null ? user.getLastName() : "" %></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Email</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getEmail() != null ? user.getEmail() : ""%></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Phone</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getMobile() != null ? user.getMobile() : ""%></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Country</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getCountryName() != null ? user.getCountryName() : ""%></p>
                                                </div>
                                            </div>
                                        </div>
                                    	
                                    	<div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">State</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getStateName() != null ? user.getStateName() : "" %></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">City</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getCityName() != null ? user.getCityName() : "" %></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Address</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getAddress() != null ? user.getAddress() : "" %></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
	                                        <label class="col-sm-2 label-on-left" style="padding-top: 17px;"></label>
	                                        <button type="button" class="btn btn-fill btn-rose" onclick="showEdit()">Edit<div class="ripple-container"></div></button>
                                        </div>
                                    </div> --%>
                                    </div>
                                <!-- </form> -->
                                <form id="profileForm" name="profileForm" method="POST" action="#">
                                <div class="form-horizontal" id="EditDiv" style="display: none;">
                                    <div class="card-header card-header-text" data-background-color="rose">
                                        <h4 class="card-title">Edit Profile</h4>
                                    </div>
                                    <div class="card-content">                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">First Name</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="text" class="form-control" id="firstName" name="firstName" value="<%=user.getFirstName() != null ? user.getFirstName() : "" %>">
                                                    <span style="color: red" id="firstNameError"></span>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">Last Name</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="text" class="form-control" id="lastName" name="lastName" value="<%=user.getLastName() != null ? user.getLastName() : ""%>">
                                                    <label style="color: red" id="lastNameError"></label>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">Email</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="text" class="form-control" id="email" name="email" value="<%=user.getEmail() != null ? user.getEmail() : ""%>">
                                                    <span style="color: red" id="emailError"></span>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Phone</label>
                                            <div class="col-sm-10">
                                                <div class="form-group">
                                                    <p class="form-control-static"><%=user.getMobile() != null ? user.getMobile() : ""%></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">Country</label>
                                            <div class="col-md-3">
                                                <div class="form-group">                                                    
                                                <div class="input-group">
													<span class="input-group-addon"></span>
													<div class="row">
														<select id="countries" name="countries" class="selectpicker" onchange="getStates()" data-style="btn btn-primary btn-round" data-size="7" required="true">
															<option value="" disabled selected>Select Country</option>													
														</select>
														<span style="color: red" id="countriesError"></span>
													</div>
													</div>	
                                                </div>
                                            </div>
                                        </div>
                                    	
                                    	<div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">State</label>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <div class="input-group">
														<span class="input-group-addon"></span>
														<div class="row">
															<select id="states" name="states" class="selectpicker" onchange="getCities()" data-style="btn btn-primary btn-round" data-size="7" required="true">
																<option value="" disabled selected>Select State</option>
															</select>
															<span style="color: red" id="statesError"></span>
														</div>
													</div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left" style="padding-top: 17px;">City</label>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <div class="input-group" >
														<span class="input-group-addon"></span>
														<div class="row">
															<select id="cities" name="cities" class="selectpicker" data-style="btn btn-primary btn-round" title="Single Select" data-size="7" >
																<option value="" disabled selected>Select City</option>
															</select>
															<span style="color: red" id="citiesError"></span>
														</div>
													</div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">Address</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="text" class="form-control" id="address" name="address" value="<%=user.getAddress() != null ? user.getAddress() : ""%>">
                                                    <span style="color: red" id="addressError"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
	                                        <label class="col-sm-2 label-on-left" style="padding-top: 17px;"></label>
	                                        <button type="button" class="btn btn-fill btn-rose" onclick="updateProfile()">Update<div class="ripple-container"></div></button>
	                                        <button type="button" class="btn btn-fill btn-rose" onclick="showView()">Cancel<div class="ripple-container"></div></button>
                                        </div>
                                    </div>
                                    </div>
                                    </form>
                            </div>
                        </div>
           </div>
     </div>
   </div>  
  </div> 
  
  <script type="text/javascript"> 
 function showEdit(){
	 getCountries();
	 getStates();
	 getCities();
	 
	 $("#viewDiv").hide();
	 $("#EditDiv").show();
 }
 
 function showView(){
	 $("#viewDiv").show();
	 $("#EditDiv").hide();
 }
 
 function getCountries(){
	$.ajax({url : "<%=request.getContextPath()%>/getallcountries",success : function(data){
		//data = JSON.parse(data);
		
		 $.each(data, function(i,val) {	
			 if(val.countryCode == <%=user.getCountryCode()%>){
				 $('#countries').append('<option value="'+val.countryCode+'" selected>'+val.countryName+'</option>'); 
			 }else{
				 $('#countries').append('<option value="'+val.countryCode+'">'+val.countryName+'</option>');
			 }
		}); 
		$('#countries').selectpicker('refresh');
	}
	});	
}
 
 function getStates(){
		var countryCode = $("#countries").find('option:selected').val();
		
		if(countryCode == null || countryCode == ""){
			countryCode = <%=user.getCountryCode()%>;
		}
		
		if(countryCode != null && countryCode != "" && countryCode != ""){
			$.ajax({url : "<%=request.getContextPath()%>/getallstates",
				data : {countryCode : countryCode},success : function(data){		
							
				$('#states').find('option').remove();	
				$('#states').append('<option value="" selected>Select State</option>');
					
				 $.each(data, function(i,val) {	
					 if(val.stateCode == <%=user.getStateCode()%>){
						 $('#states').append('<option value="'+val.stateCode+'" selected>'+val.stateName+'</option>');
					 }else{
						 $('#states').append('<option value="'+val.stateCode+'">'+val.stateName+'</option>');
					 }					
				}); 
				$('#states').selectpicker('refresh');
				/* $('#cities').find('option').remove();	
				$('#cities').append('<option value="" selected>Select City</option>');
				$('#cities').selectpicker('refresh'); */
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

		if(stateCode == null || stateCode == ""){
			stateCode = <%=user.getStateCode()%>;
		}
		
		if(stateCode != null && stateCode != "" && stateCode != "-1"){
			$.ajax({url : "<%=request.getContextPath()%>/getallcities",
				data : {stateCode : stateCode},success : function(data){
									
				 $('#cities').find('option').remove();	
				 $('#cities').append('<option value="" selected>Select City</option>');
			
				 $.each(data, function(i,val) {
					 if(val.cityCode == <%=user.getCityCode()%>){
						 $('#cities').append('<option value="'+val.cityCode+'" selected>'+val.cityName+'</option>');	 
					 }else{
						 $('#cities').append('<option value="'+val.cityCode+'">'+val.cityName+'</option>'); 
					 }					
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
 
   function updateProfile(){
	   var check = $('#profileForm').valid();
	   
	   if(check){
	   $.ajax({url : "<%=request.getContextPath()%>/update-profile",
			data : $("#profileForm").serialize(),success : function(data){
								
			if(data.status == true){
				swal({
	                title: "OK",
	                text: "Profile Updated Successfully",
	                buttonsStyling: false,
	                confirmButtonClass: "btn btn-success",
	                type: "success",
	                dismissible:false
	            }).then(function(result){
	            	window.location.href = "<%=request.getContextPath() %>/my-profile";
	            });
			}else{
				swal({
	                title: "Oops !!!",
	                text: "Some Problem Occured, Please Try Again",
	                buttonsStyling: false,
	                confirmButtonClass: "btn btn-success",
	                type: "success",
	                dismissible:false
	            });
			}
		}
		});
	 }
   }
   
// to validate customer form inputs 
   $('#profileForm').validate({
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
   			  	},
				"address":{
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
   			       },
   			       "address": {
   				       required:'Please enter address'
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
   		        }else if (element.attr("id") == "address"){
   			    	document.getElementById("addressError").innerHTML="";
   		            error.appendTo('#addressError');
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
                   
                        
                        
                        