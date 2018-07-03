<!DOCTYPE html>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="ce"%> --%>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="//digital_add_master/assets/img/apple-icon.png" />
<link rel="icon" type="image/png"
	href="//digital_add_master/assets/img/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Digital Add</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Canonical SEO -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>user pannel</title>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="//digital_add_master/assets/img/apple-icon.png" />
<link rel="icon" type="image/png"
	href="//digital_add_master/assets/img/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Digital Add</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<!-- Canonical SEO -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>user pannel</title>



<!-- Bootstrap core CSS     -->
<link href="/digital_add_master/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Bootstrap theme CSS -->
<link href="/digital_add_master/assets/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<!-- Morris Charts CSS -->
<link href="/digital_add_master/assets/css/morris.css" rel="stylesheet">
<!--  Material Dashboard CSS    -->
<link
	href="/digital_add_master/assets/css/material-dashboard5438.css?v=1.2.0"
	rel="stylesheet" />
<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="/digital_add_master/assets/css/demo.css" rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<%=request.getContextPath()%>/assets/css/metisMenu.min.css"
	rel="stylesheet">

<!-- Bootstrap core CSS     -->
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Morris Charts CSS -->
<link href="<%=request.getContextPath()%>/assets/css/morris.css"
	rel="stylesheet">
<!--  Material Dashboard CSS    -->
<link
	href="<%=request.getContextPath()%>/assets/css/material-dashboard5438.css?v=1.2.0"
	rel="stylesheet" />

<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- progressbar CSS -->
<link rel="stylesheet"
	href="/digital_add_master/assets/css/progressbar-style.css">


<style type="text/css">
	@media screen and (max-width: 600px) {
  #google_pc_add {
    visibility: hidden;
    clear: both;
    float: left;
    margin: 10px auto 5px 20px;
    width: 28%;
    display: none;
    
  }
  
}

/**  STYLE 3 */
		.scroll::-webkit-scrollbar-track {
			-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
			background-color: #F5F5F5;
		}

		.scroll::-webkit-scrollbar {
			width: 6px;
			background-color: #F5F5F5;
		}

		.scroll::-webkit-scrollbar-thumb {
			background-color: #000000;
		}

		.scrollbar {
			
			overflow-y: scroll;
			
		}

</style>



<!--   Core JS Files   -->

		<script src="/digital_add_master/assets/js/jquery-3.2.1.min.js"	type="text/javascript"></script>

		<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"type="text/javascript"></script>
	
		<script src="<%=request.getContextPath()%>/assets/js/material.min.js"type="text/javascript"></script> 
	

</head>
<body class="scrollbar scroll">

	<tiles:insertAttribute name="Navbar"></tiles:insertAttribute>

	<%-- <tiles:insertAttribute name="Left"></tiles:insertAttribute> --%>

	<tiles:insertAttribute name="Body"></tiles:insertAttribute>



	<tiles:insertAttribute name="Footer"></tiles:insertAttribute>

	<!--   Core JS Files   -->

		<script src="/digital_add_master/assets/js/jquery-3.2.1.min.js"	type="text/javascript"></script>

		<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"type="text/javascript"></script>
	
		<script src="<%=request.getContextPath()%>/assets/js/material.min.js"type="text/javascript"></script> 
	
	<!-- Forms Validations Plugin -->
		<script	src="<%=request.getContextPath()%>/assets/js/jquery.validate.min.js"></script>
	
	<!-- Promise Library for SweetAlert2 working on IE -->
		<script	src="<%=request.getContextPath()%>/assets/js/es6-promise-auto.min.js"></script>
	
	 <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
		<script	src="<%=request.getContextPath()%>/assets/js/bootstrap-datetimepicker.js"></script>
	
	<!-- Sweet Alert 2 plugin, full documentation here: https://limonte.github.io/sweetalert2/ -->
		<script src="<%=request.getContextPath()%>/assets/js/sweetalert2.js"></script>
	
	<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
		<script	src="<%=request.getContextPath()%>/assets/js/fullcalendar.min.js"></script>
		
	
	<%--
	
	<!-- Material Dashboard javascript methods -->
		<script src="<%=request.getContextPath()%>/assets/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
		
		<script	src="<%=request.getContextPath()%>/assets/js/material-dashboard5438.js?v=1.2.0"></script>
	
	 --%>
	
		<script src="<%=request.getContextPath()%>/assets/js/jQuery-plugin-progressbar.js"type="text/javascript"></script>

		<script src="/digital_add_master/assets/js/jquery.bootpag.min.js"type="text/javascript"></script>
	
		<script src="<%=request.getContextPath()%>/assets/js/pace/pace.js"type="text/javascript"></script>

	
	 
	 
	 
	 
	 
	 
	 
	 
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
	 
	
	
	
	
	
	
	
	
	
	<script>
		function openNav() {

		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>

	

	<!-- script for pagination -->
	<script type="text/javascript">
		pageSize = 5;
		$(".progress-bar1").loading();
		showPage = function(page) {
			$(".adds").hide();
			$(".adds").each(function(n) {
				if (n >= pageSize * (page - 1) && n < pageSize * page)
					$(this).show();
			});
		}

		showPage(1);

		$('.pagination').bootpag({
			total : 100,
			page : 1,
			maxVisible : 5
		}).on('page', function(event, num) {
			// or some ajax content loading...

			//dynamic pagination

			$('.pagination').click(function() {
				/* $('.demo2').removeClass("current");
				$(this).addClass("current");
				showPage(parseInt($(this).text())) */
				showPage(num);
			});

		});
	</script>

</body>

</html>






