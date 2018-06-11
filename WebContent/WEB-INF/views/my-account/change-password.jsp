 <style type="text/css">	
	.error{
		color: red !important;
	}
</style>
            
   <div class="main-panel">
      <div class="content">
         <div class="container-fluid">
           <div class="row">   
           		<div class="col-md-12">
                            <div class="card">
                              <form id="changePasswordForm" name="changePasswordForm" method="POST" action="#">
                                <div class="form-horizontal">
                                    <div class="card-header card-header-text" data-background-color="rose">
                                        <h4 class="card-title">Change Password</h4>
                                    </div>
                                    <span id="errorId" style="color: red"></span>
                                    <div class="card-content">                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">Current Password</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="password" class="form-control" id="currentPassword" name="currentPassword">
                                                    <span style="color: red" id="currentPasswordError"></span>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">New Password</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="password" class="form-control" id="newPassword" name="newPassword">
                                                    <label style="color: red" id="newPasswordError"></label>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <label class="col-sm-2 label-on-left">Confirm New Password</label>
                                            <div class="col-sm-10">
                                                <div class="form-group label-floating is-empty">
                                                    <label class="control-label"></label>
                                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
                                                    <span style="color: red" id="confirmPasswordError"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
	                                        <label class="col-sm-2 label-on-left" style="padding-top: 17px;"></label>
	                                        <button type="button" class="btn btn-fill btn-rose" onclick="updatePassword()">Update<div class="ripple-container"></div></button>
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

 <script>
 function updatePassword(){
	 $("#errorId").html('');	
	 var status =$("#changePasswordForm").valid();
	 
	 if(status){
		 var currentPassword = $("#currentPassword").val();
		 var newPassword = $("#newPassword").val();
		 
		 $.ajax({url : "<%=request.getContextPath()%>/update-password",
			data : {currentPassword : currentPassword, newPassword : newPassword},success : function(data){
								
			if(data.status == true){
				swal({
	                title: "OK",
	                text: "Password Updated Successfully. Please Relogin With New Password",
	                buttonsStyling: false,
	                confirmButtonClass: "btn btn-success",
	                type: "success",
	                dismissible:false
	            }).then(function(result){
	            	window.location.href = "<%=request.getContextPath() %>/login";
	            });
			}else if(data.status == "passwordWrong"){
				$("#errorId").html('Current Password Is Wrong');	
			}else{
				$("#errorId").html('Exception Occured, Please Try Again');
			}
		}
	   });
	 }
 }
 
 
 $('#changePasswordForm').validate({
		rules: {
  		 "currentPassword": {
	        	required: true
	      	 },
		      "newPassword": {
		        required: true
		      },
		      "confirmPassword": {
		     	equalTo: "#newPassword"
		      }
	 		},
	    messages: {
	   			  
			      "currentPassword": {
			        required: 'Please Enter Current Password'
			       },
			       "newPassword": {
			        required: 'Please Enter New Password'
			      },
			      "confirmPassword" : {
			      	equalTo: 'Please Enter Confirn New Password'
			      }
		    },
	    errorPlacement:function(error, element){
		     if (element.attr("id") == "currentPassword" ){
		    	document.getElementById("currentPasswordError").innerHTML="";
	          	error.appendTo('#currentPasswordError');
	        }else if (element.attr("id") == "newPassword" ){
	        	document.getElementById("newPasswordError").innerHTML="";
	          	error.appendTo('#newPasswordError');
	        }else if (element.attr("id") == "confirmPassword" ){
	        	document.getElementById("confirmPasswordError").innerHTML="";
	          	error.appendTo('#confirmPasswordError');
	        }else{
		            error.insertAfter(element); 
		    }
		}    
});
 </script>                  
                        
                        
                        