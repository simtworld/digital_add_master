<!DOCTYPE html>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="ce"%> --%>
<html>
<head>

<tiles:insertAttribute name="Header"></tiles:insertAttribute>

<script src="<%=request.getContextPath()%>/assets/js/pace/pace.js" ></script>
	
<link href="<%=request.getContextPath()%>/assets/css/pace/pace.css" rel="stylesheet" />
    <script type="text/javascript">
    	paceOptions = {
				  ajax: false, // Monitors all ajax requests on the page
				  document: false, // Checks for the existance of specific elements on the page
				  eventLag: false, // Checks the document readyState
				  elements: {
				    selectors: ['.my-page'] // Checks for event loop lag signaling that javascript is being executed
				  }
				};
    </script>
</head>
<%-- <fmt:setBundle basename="resources/ApplicationResources" var="bndl"/> --%>
<body>

	
	<tiles:insertAttribute name="Left"></tiles:insertAttribute>

	<tiles:insertAttribute name="Body"></tiles:insertAttribute>



	<tiles:insertAttribute name="Footer"></tiles:insertAttribute>
	
	
<script src="<%=request.getContextPath()%>/assets/js/pace/pace.js" type="text/javascript" />
	
</body>

</html>






