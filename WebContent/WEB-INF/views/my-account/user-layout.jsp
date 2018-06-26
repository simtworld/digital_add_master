<<<<<<< HEAD
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

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/assets/css/sb-admin-2.css"
	rel="stylesheet">



</head>
<%-- <fmt:setBundle basename="resources/ApplicationResources" var="bndl"/> --%>
<body>

	<tiles:insertAttribute name="Header"></tiles:insertAttribute>

	<%-- <tiles:insertAttribute name="Left"></tiles:insertAttribute> --%>

	<tiles:insertAttribute name="Body"></tiles:insertAttribute>



	<tiles:insertAttribute name="Footer"></tiles:insertAttribute>


	<script src="/digital_add_master/assets/js/jquery-3.2.1.min.js"
		type="text/javascript"></script>
	<!-- progressbar CSS -->
	<link rel="stylesheet"
		href="/digital_add_master/assets/css/progressbar-style.css">
	
	<script
		src="<%=request.getContextPath()%>/assets/js/jQuery-plugin-progressbar.js"
		type="text/javascript"></script>

	<script src="/digital_add_master/assets/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/digital_add_master/assets/js/jquery.bootpag.min.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/assets/js/pace/pace.js"
		type="text/javascript"></script>



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






