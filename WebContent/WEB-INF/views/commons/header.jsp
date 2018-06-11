<!doctype html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/<%=request.getContextPath()%>/assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="/<%=request.getContextPath()%>/assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Digital Add</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- Canonical SEO -->
    
    
    <!-- Bootstrap core CSS     -->
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="<%=request.getContextPath()%>/assets/css/material-dashboard5438.css?v=1.2.0" rel="stylesheet" />
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<%=request.getContextPath()%>/assets/css/demo.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    
    <script src="<%=request.getContextPath()%>/assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    
    <!--   Core JS Files   -->

<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/material.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/assets/js/perfect-scrollbar.jquery.min.js"
	type="text/javascript"></script>
<!-- Library for adding dinamically elements -->
<script src="<%=request.getContextPath()%>/assets/js/arrive.min.js"
	type="text/javascript"></script>
<!-- Forms Validations Plugin -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery.validate.min.js"></script>
<!-- Promise Library for SweetAlert2 working on IE -->
<script
	src="<%=request.getContextPath()%>/assets/js/es6-promise-auto.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<!--  Charts Plugin, full documentation here: https://gionkunz.github.io/chartist-js/ -->
<script src="<%=request.getContextPath()%>/assets/js/chartist.min.js"></script>
<!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery.bootstrap-wizard.js"></script>
<!--  Notifications Plugin, full documentation here: http://bootstrap-notify.remabledesigns.com/    -->
<script
	src="<%=request.getContextPath()%>/assets/js/bootstrap-notify.js"></script>
<!--   Sharrre Library    -->
<script src="<%=request.getContextPath()%>/assets/js/jquery.sharrre.js"></script>
<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
<script
	src="<%=request.getContextPath()%>/assets/js/bootstrap-datetimepicker.js"></script>
<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery-jvectormap.js"></script>
<!-- Sliders Plugin, full documentation here: https://refreshless.com/nouislider/ -->
<script src="<%=request.getContextPath()%>/assets/js/nouislider.min.js"></script>

<!--  Google Maps Plugin    -->
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFPQibxeDaLIUHsC6_KqDdFaUdhrbhZ3M"></script> -->
<!--  Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery.select-bootstrap.js"></script>
<!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery.datatables.js"></script>
<!-- Sweet Alert 2 plugin, full documentation here: https://limonte.github.io/sweetalert2/ -->
<script src="<%=request.getContextPath()%>/assets/js/sweetalert2.js"></script>
<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
<script
	src="<%=request.getContextPath()%>/assets/js/jasny-bootstrap.min.js"></script>
<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
<script
	src="<%=request.getContextPath()%>/assets/js/fullcalendar.min.js"></script>
<!-- Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
<script
	src="<%=request.getContextPath()%>/assets/js/jquery.tagsinput.js"></script>
<!-- Material Dashboard javascript methods -->
<script
	src="<%=request.getContextPath()%>/assets/js/material-dashboard5438.js?v=1.2.0"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="<%=request.getContextPath()%>/assets/js/demo.js"></script>
<script type="text/javascript">
	$().ready(function() {
		demo.checkFullPageBackgroundImage();

		var testUser = '<%= session.getAttribute("bean") %>';
		
		if(testUser == null || testUser == "null" || testUser == ""){	
			$("#userMenuNav").show();
		}
		
		setTimeout(function() {
			// after 1000 ms we add the class animated to the login/register card
			$('.card').removeClass('card-hidden');
		}, 700)
	});
</script>
    <body>
<%--     	<c:if test="${session.bean eq null or session.bean eq ''}"> --%>
    	<%-- <c:if test="${session.bean ne null or session.bean ne ''}"> --%>
	    	<nav class="navbar navbar-primary navbar-transparent navbar-absolute" id="userMenuNav" ><!-- style="display: none;" -->
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href="<%=request.getContextPath() %>">Material Dashboard Pro</a>
	            </div>
	            <div class="collapse navbar-collapse">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a href="<%=request.getContextPath() %>/dashboard">
	                            <i class="material-icons">dashboard</i> Dashboard
	                        </a>
	                    </li>
	                    <li class=" active ">
	                        <a href="<%=request.getContextPath() %>/registration">
	                            <i class="material-icons">person_add</i> Register
	                        </a>
	                    </li>
	                    <li class="">
	                        <a href="<%=request.getContextPath() %>/login">
	                            <i class="material-icons">fingerprint</i> Login
	                        </a>
	                    </li>
	                    <li class="">
	                        <a href="lock.html">
	                            <i class="material-icons">lock_open</i> Lock
	                        </a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
    <%-- </c:if> --%>
    
    <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title">Background Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <div class="togglebutton switch-sidebar-image">
                        <label>
                            <input type="checkbox" checked="">
                        </label>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger active-color" aria-expanded="false">
                    <p>Filters</p>
                    <div class="badge-colors pull-right">
                        <span class="badge filter active" data-color="black"></span>
                        <span class="badge filter badge-blue" data-color="blue"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-rose" data-color="rose"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Background Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-1.jpg" data-src="<%=request.getContextPath()%>/assets/img/login.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-2.jpg" data-src="<%=request.getContextPath()%>/assets/img/lock.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-3.jpg" data-src="<%=request.getContextPath()%>/assets/img/header-doc.jpeg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="<%=request.getContextPath()%>/assets/img/sidebar-4.jpg" data-src="<%=request.getContextPath()%>/assets/img/bg-pricing.jpeg" alt="" />
                </a>
            </li>
        </ul>
    </div>
</div>
    </body>
</head>