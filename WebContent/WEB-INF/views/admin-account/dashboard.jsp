


<div id="wrapper">

		<%-- <!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/">Home</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong>John Smith</strong> <span class="pull-right text-muted">
										<em>Yesterday</em>
									</span>
								</div>
								<div>Lorem ipsum dolor sit amet, consectetur adipiscing
									elit. Pellentesque eleifend...</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>John Smith</strong> <span class="pull-right text-muted">
										<em>Yesterday</em>
									</span>
								</div>
								<div>Lorem ipsum dolor sit amet, consectetur adipiscing
									elit. Pellentesque eleifend...</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>John Smith</strong> <span class="pull-right text-muted">
										<em>Yesterday</em>
									</span>
								</div>
								<div>Lorem ipsum dolor sit amet, consectetur adipiscing
									elit. Pellentesque eleifend...</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>Read
									All Messages</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-messages --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-tasks fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-tasks">
						<li><a href="#">
								<div>
									<p>
										<strong>Task 1</strong> <span class="pull-right text-muted">40%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 2</strong> <span class="pull-right text-muted">20%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
											style="width: 20%">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 3</strong> <span class="pull-right text-muted">60%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 4</strong> <span class="pull-right text-muted">80%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: 80%">
											<span class="sr-only">80% Complete (danger)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									All Tasks</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-tasks --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> New Comment <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
										class="pull-right text-muted small">12 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-envelope fa-fw"></i> Message Sent <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-tasks fa-fw"></i> New Task <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									All Alerts</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> <!-- /.dropdown-alerts --></li>
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">



					<c:set var="uid_data" scope="session" value="USER_01"></c:set>
					<c:if test="${bean.userTypeId==uid_data}">
					<span>test <c:out value="${bean.userTypeId}" /></span>



					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
								Dashboard</a></li>

						<!-- nav bar validation -->

						<c:set var="user" scope="session" value="USER_01"></c:set>
						<c:set var="admin" scope="session" value="USER_05"></c:set>
						<c:choose>
							<c:when test="${bean.userTypeId==user}">
								<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
										User Tables</a></li>

								<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
										User Charts<span class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<li><a href="flot.html">float</a></li>
										<li><a href="morris.html">
										morris</a></li>
									</ul> <!-- /.nav-second-level --></li>

								<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
										User Menu<span class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<li><a href="#">Second Level Item</a></li>
										<li><a href="#">Second Level Item</a></li>
										<li><a href="#">Third Level <span class="fa arrow"></span></a>
											<ul class="nav nav-third-level">
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
											</ul> <!-- /.nav-third-level --></li>
									</ul> <!-- /.nav-second-level --></li>

							</c:when>

							<c:when test="${bean.userTypeId==admin}">
								<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>
										Admin Tables</a></li>

								<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
										Settings<span class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<li><a href="email-settings">Email Settings</a></li>
										<li><a href="morris.html">SMS Settings</a></li>
									</ul> <!-- /.nav-second-level --></li>

								<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
										Admin Menu<span class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<li><a href="#">Second Level Item</a></li>
										<li><a href="#">Second Level Item</a></li>
										<li><a href="#">Third Level <span class="fa arrow"></span></a>
											<ul class="nav nav-third-level">
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
												<li><a href="#">Third Level Item</a></li>
											</ul> <!-- /.nav-third-level --></li>
									</ul> <!-- /.nav-second-level --></li>
							</c:when>

							<c:otherwise>
						            No comment sir...
						        </c:otherwise>
						</c:choose>

					</c:if>
				</div>
				
				<!-- /.sidebar-collapse -->
			</div>
			
			<!-- /.navbar-static-side -->
		</nav>
 --%>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-comments fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">26</div>
									<div>New Comments!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">12</div>
									<div>New Tasks!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-shopping-cart fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">124</div>
									<div>New Orders!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-support fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">13</div>
									<div>Support Tickets!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-3 col-md-6">

					<!-- Add products model -->

					<button type="button" id="addProductDetailsButton"  class="btn btn-primary" data-toggle="modal"
						data-target=".bs-example-modal-lg">
						<span class="pull-left"><i class="fa fa-plus"></i> Add
							product details</span>
					</button>

					<!-- Modal div started -->

					<div class="modal fade bs-example-modal-lg" tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel" id="myModal"
						data-backdrop="static" data-keyboard="false">
						<div class="modal-dialog modal-md" role="document">
							<div class="modal-content">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<button type="button" class="btn" style="float: right;"
												data-dismiss="modal">
												<i class="fa fa-times" style="font-size: 20px"></i>
											</button>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-12 ">
											<form  contentType="multipart/form-data"
												id="addProductDetailsForm" >
												<div class="form-group">
													<label>Product Name</label> <input id="productName"
														type="text" name="productName" class="form-control">
												</div>
												<div>
													<label>Product Url</label> <input id="productUrl"
														type="text" name="productUrl" class="form-control">
												</div>
												<div>
													<label>ProductDescription For SMS</label> <input
														type="textarea" id="productDescriptionForSms"
														name="productDescriptionForSms" class="form-control"><br>
												</div>
												<div>
													<label>ProductDescription For E-Mail</label> <input
														type="textarea" id="productDescriptionForEmail"
														name="productDescriptionForEmail" class="form-control"><br>
												</div>
												<div class="row">
													<div class="col-md-4 form-group">
														<select id="countries" name="country" class="form-control"
															onchange="getStates()"
															data-style="btn btn-primary btn-round"
															title="Single Select" data-size="7" required="true">
															<option value="" disabled selected>Select
																Country</option>
														</select> <span style="color: red" id="countriesError"></span>
													</div>
													<div class="col-md-4 form-group">
														<select id="states" name="state" class="form-control"
															onchange="getCities()"
															data-style="btn btn-primary btn-round"
															title="Single Select" data-size="7" required="true">
															<option value="" disabled selected>Select State</option>
														</select> <span style="color: red" id="statesError"></span>
													</div>
													<div class=" col-md-4 form-group">
														<select id="cities" name="city" class="form-control"
															data-style="btn btn-primary btn-round"
															title="Single Select" data-size="7">
															<option value="" disabled selected>Select City</option>
														</select> <span style="color: red" id="citiesError"></span>
													</div>
												</div>

												<div style="margin: 5px"></div>
										
												<div class=" col-md-12 form-group">
													<input type="file"  class="form-control file"
														name="file" id="customFile" accept=".xlsx,.xls,image/*" >
												</div>



												<div style="float: right;">
													<button type="button" id="addProductDetailsCancelbutton"
														class="btn btn-danger" data-dismiss="modal">Cancel</button>
													<button type="submit" class="btn btn-success"
														id="addProductDetailsSubmitbutton">Submit</button>
													<button type="button" class="btn btn-success"
														id="updateProductDetailsbutton" style="display: none;">Update</button>
												</div>

											</form>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<!-- /Modal div end -->
				</div>
			</div>
			<!-- /.row -->
			<!-- row -->
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<table id="product_table"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Product Id</th>
								<th>Product Name</th>
								<th>puoduct Url</th>
								<th>country Id</th>
								<th>state Id</th>
								<th>city Id</th>
								<th>creation Date</th>
								<th>EDIT/DELETE</th>
							</tr>
						</thead>
					</table>
				</div>

			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/assets/js/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="<%=request.getContextPath()%>/assets/js/raphael.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/morris.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/assets/js/sb-admin-2.js"></script>

	<!-- Custom Bootstrap Script -->
	<script src="<%=request.getContextPath()%>/assets/js/custom-scripts.js"></script>

	<!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
	<script
		src="<%=request.getContextPath()%>/assets/js/jquery.datatables.js"></script>

	<!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
	<script
		src="<%=request.getContextPath()%>/assets/js/dataTables.bootstrap.js"></script>

	<!-- Sweet Alert plugin, full documentation here:https://sweetalert.js.org/guides/ -->
	<script src="<%=request.getContextPath()%>/assets/js/sweetalert.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/fileinput.min.js"></script>		
	

