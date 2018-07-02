<style>
      .fa {
          padding: 7px;
          font-size: 25px;
          width: 118.5px;
          height: 40px;
          text-align: center;
          text-decoration: none;
          border-radius: 5px;
          
      }
      
      .fa:hover {
          opacity: 0.7;
      }
      
      .fa-facebook {
        background: #3B5998;
        color: white;
      }
      
      .fa-twitter {
        background: #55ACEE;
        color: white;
      }
      
      .fa-google {
        background: #dd4b39;
        color: white;
      }
      
      
      .fa-instagram {
        background: #125688;
        color: white;
      }
      
      .fa-pinterest {
        background: #cb2027;
        color: white;
      }

      #ad-image{
          display:block;
          margin:auto;
      }
      .img-fluid{
          max-width: 60%;
          height: auto;
     
      } 
      
      #wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
}

		.fa{
			width: -webkit-fill-available;
		}
		
		
		.card-shadow {
  			box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
		}
		

		.card-shadow-hover-effect {
 		 box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
 		 transition: all 0.3s cubic-bezier(.25,.8,.25,1);
		}
		
		.card-shadow-hover-effect:hover {
  			 box-shadow: 0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);
		}
      
      </style> 


<!-- Main Container of user pannel START -->
	<div class="container-fluid">
		
		<!-- 1st Row `navbar` START-->
			<div class="row" style="height: 50px;margin-bottom: 20px"></div>
		<!-- 1st Row `navbar` END-->
			
		<!-- 2nd ROW `left Add Block`,`main task pannel`,`right Add Block` START-->
			<div class="row" style="">
				<div class="col-md-2" id="google_pc_add" style="margin-top: 100px">
					<img src="https://lh4.ggpht.com/8w5rhmn-M8IKcoktSlyKjXLUt5ABPwA8DVcPMz2JpzVc89kdJyntWb-RttwuurauryMR4lH3vw=w160" class="rounded mx-auto d-block"
						alt="ad1" style="max-height:  600px; max-width: 160px;">
				</div>
				
			<!-- 2nd COLUMN of 2nd ROW Start-->
				<div class="col-md-8">
					
				<!-- Top Add pannel start -->
					<div class="row" style="">
						<div class="col-md-12"	style="text-align: center;margin-top: 20px;">
							<img src="https://lh6.ggpht.com/41LFWBytPnxKsfZf6mivs6ba7qdOBtfk9-7MzWSMqwC3IFOvaXd8rejFiyeXKfBOK16mMEopeA=w728" class="rounded mx-auto d-block" alt="ad1">
						</div>
					</div>
				<!-- Top Add pannel end -->
					
				<!-- Product task row start -->	
					<div class="row">
					
					<!-- main section where tasks will appear-->
						<div class="col-md-12">
		
						<!-- MAIN TASK CARD START-->
							<div class="card ">
								<div class="form-horizontal card-shadow " style="border-radius:  5px; " id="viewDiv">
								
								<!-- Add Window button on top start -->
									<div data-toggle="modal" data-target="#addPopupModal" class="btn card-header card-header-text card-shadow card-shadow-hover-effect"
										data-background-color="rose">
										<h4 class="card-title">Adds Window</h4>
									</div>
								<!-- Add Window button on top end -->
								
								<!-- Modal START-->
									  <div class="modal fade" id="addPopupModal" role="dialog">
									    <div class="modal-dialog modal-lg">
									      <div class="modal-content">
									        <div class="modal-header">
									          <button type="button" class="close" style="color: black;;;font-size: 25px;" data-dismiss="modal">&times;</button>
									          <h4 class="modal-title">Share Here</h4>
									        </div>
									        <div class="modal-body">
									            <div class="container-fluid">
									                <div class="row">
									                    <div class="col col-lg-2" id="wrapper">
									                       <button type="button"  height="50%" class="btn glyphicon glyphicon-menu-left"></button>
									                    </div>
									
									                    <div class="col col-lg-8" style="">
									                        <div class="row" style="">
									                            <div class="col col-lg-12" >
									                                <div class="row">
									                                    <div style="text-align: center">
									                                         <h1 id="modal-add-name">Apple Macbook Air</h1>
									                                    </div>
									                                </div>
									                                <div  class="row" >
									                                     <div id="ad-image" >
									                                        <img id="modal-add-img" src="https://img.purch.com/o/aHR0cDovL3d3dy5sYXB0b3BtYWcuY29tL2ltYWdlcy93cC9wdXJjaC1hcGkvaW5jb250ZW50LzIwMTgvMDMvMTUyMDI1MjU2MjU0NC02MjB4NDAwLmpwZw==" class="" alt="Responsive image" height="300">
									                                     </div>
									                                </div>
									                                <div class="row">
									                                    <div >
									                                        <div>
									                                             <h3 >Description :</h3>
									                                        </div>
									                                        <div>
									                                            <p id="modal-add-desc" class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
									                                        </div>        
									                                    </div>
									                                </div>
									                                <div class="row" >
									                               		<div class="col col-lg-1"></div>
									                                	<div class="col col-lg-2">
									                                        <a href="#" id="modal-add-fb-share" class="btn fa fa-facebook"></a>
									                                    </div>
									                                    <div class="col col-lg-2">
									                                        <a href="#" id="modal-add-twitter-share"class="btn fa fa-twitter"></a>
									                                    </div>
									                                    <div class="col col-lg-2">
									                                        <a href="#" id="modal-add-google-share" class="btn fa fa-google"></a>
									                                    </div>
									                                    <div class="col col-lg-2">    
									                                        <a href="#" id="modal-add-instagram-share" class="btn fa fa-instagram"></a>
									                                    </div>
									                                    <div class="col col-lg-2">
									                                        <a href="#" id="modal-add-pinterest-share" class="btn fa fa-pinterest"></a>
									                                    </div>
									                                    <div class="col col-lg-1"></div>
									                               
									                                </div>
									                                <div class="row" style="padding-top: 20px">
									                                	<div class="col col-lg-12">
										                                    <div class="progress">
										                                        <div class="progress-bar" id="modal-add-progressbar" role="progressbar" style="width: 25%;" aria-valuenow="59" aria-valuemin="0" aria-valuemax="100">25%</div>
										                                    </div>
									                                    </div>
									                                </div>
									                            </div>    
									                        </div>
									                    </div>
									                    <div class="col col-lg-2" id="wrapper" height="50%">
									                         <button type="button" class="btn glyphicon glyphicon-menu-right"></button>
									                    </div>
									                </div>
									            </div>
									        </div>
									        
									      </div>
									    </div>
									  </div>
								<!-- Modal END-->								
									
								
								<!-- Products Cards pannel/div START -->
									<div style="overflow-y:scroll; max-height:  600px; overflow-x:  hidden; background:#f2f2f2" class="">
								
									<!-- Product add card start -->
										<div style="padding-left: 10px; padding-right: 10px">
											<div class="card bg-light card-shadow-hover-effect">
												<div class=" row" style="margin-top: 15px">
													<div class="col-md-2">
														<img class="card-img-left" src="assets/img/faces/avatar.jpg"
															alt="product image"
															style="padding-left: 10px; padding-top: 0px; padding-right: 0px; padding-bottom: 0px;">
													</div>
													<div class="col-md-7">
														<div class="card-body">
															<div class="caption ">
																<h3 style="margin-top: 0px; margin-bottom: 0px;">Alovera</h3>
																<p class="card-text">Cras justo odio, dapibus ac
																	facilisis in, egestas eget quam. Donec id elit non mi
																	porta gravida at eget metus. Nullam id dolor id nibh
																	ultricies vehicula ut id elit.</p>
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<!-- progress bar -->
														<div class="progress-bar1" data-percent="40"
															data-duration="1000" data-color="#ccc,teal"></div>
													</div>
												</div>
			
											</div>
										</div>
									<!-- Product add card end -->
									
									<!-- Product add card start -->
										<div style="padding-left: 10px; padding-right: 10px">
											<div class="card bg-light card-shadow-hover-effect">
												<div class=" row" style="margin-top: -15; margin-top: 15px">
													<div class="col-md-2">
														<img class="card-img-left" src="assets/img/faces/avatar.jpg"
															alt="product image"
															style="padding-left: 10px; padding-top: 0px; padding-right: 0px; padding-bottom: 0px;">
													</div>
													<div class="col-md-7">
														<div class="card-body">
															<div class="caption ">
																<h3 style="margin-top: 0px; margin-bottom: 0px;">Alovera</h3>
																<p class="card-text">Cras justo odio, dapibus ac
																	facilisis in, egestas eget quam. Donec id elit non mi
																	porta gravida at eget metus. Nullam id dolor id nibh
																	ultricies vehicula ut id elit.</p>
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<!-- progress bar -->
														<div class="progress-bar1" data-percent="40" data-duration="1000" data-color="#ccc,teal"></div>
													</div>
												</div>
			
											</div>
										</div>
									<!-- Product add card end -->
									
									<!-- Product add card start -->
										<div style="padding-left: 10px; padding-right: 10px">
											<div class="card bg-light card-shadow-hover-effect">
												<div class=" row" style="margin-top: -15; margin-top: 15px">
													<div class="col-md-2">
														<img class="card-img-left" src="assets/img/faces/avatar.jpg"
															alt="product image"
															style="padding-left: 10px; padding-top: 0px; padding-right: 0px; padding-bottom: 0px;">
													</div>
													<div class="col-md-7">
														<div class="card-body">
															<div class="caption ">
																<h3 style="margin-top: 0px; margin-bottom: 0px;">Alovera</h3>
																<p class="card-text">Cras justo odio, dapibus ac
																	facilisis in, egestas eget quam. Donec id elit non mi
																	porta gravida at eget metus. Nullam id dolor id nibh
																	ultricies vehicula ut id elit.</p>
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<!-- progress bar -->
														<div class="progress-bar1" data-percent="40" data-duration="1000" data-color="#ccc,teal"></div>
													</div>
												</div>
			
											</div>
										</div>
									<!-- Product add card end -->
									
									</div>
									<!-- Products Cards pannel/div START -->
								
								<!-- Pagination DIV START -->
									<div class="bs-docs-example" style="color:red">
       									<p class="pagination"></p>
     								</div>
     							<!-- Pagination DIV END -->
     							
								</div>
							</div>
							<!-- MAIN TASK CARD END	-->
		
						</div>
					</div>
					<!-- Product task row end -->	
				
				</div>
			<!-- 2nd COLUMN of 2nd ROW END-->
			
			<!-- 3rd COLUMN of 2nd ROW START -->
				<div class="col-md-2" id="google_pc_add" style="margin-top: 100px;">
					<img align="right" src="https://lh4.ggpht.com/8w5rhmn-M8IKcoktSlyKjXLUt5ABPwA8DVcPMz2JpzVc89kdJyntWb-RttwuurauryMR4lH3vw=w160"class="rounded mx-auto d-block" alt="ad2" >
				</div>
			<!-- 3rd COLUMN of 2nd ROW START -->
			
			</div>
		<!-- 2nd ROW `left Add Block`,`main task pannel`,`right Add Block` END-->
		
		<!-- 3rd ROW `bottom Add Block` START-->
			<div class="row" style="">
				<div class="col-md-2"></div>
				<div class="col-md-8"style="text-align: center;">
						<img src="https://lh6.ggpht.com/41LFWBytPnxKsfZf6mivs6ba7qdOBtfk9-7MzWSMqwC3IFOvaXd8rejFiyeXKfBOK16mMEopeA=w728" class="rounded mx-auto d-block" alt="ad3"	>
				</div>
				<div class="col-md-2"></div>
			</div>
		<!-- 3rd ROW `bottom Add Block` END-->

	</div>
<!-- Main Container of user pannel START -->

