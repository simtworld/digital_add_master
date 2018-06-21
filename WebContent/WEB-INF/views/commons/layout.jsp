<!DOCTYPE html>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="ce"%> --%>
<html>
<head></head>
<%-- <fmt:setBundle basename="resources/ApplicationResources" var="bndl"/> --%>
<body>

	<div id="wait" style="display:none;margin: 0px; padding: 0px; position: fixed; right: 0px; top: 0px; width: 100%; height: 100%; background-color: rgb(102, 102, 102); z-index: 30001; opacity: 0.8;">
		<img src='assets/img/loading.gif'  style="position: absolute; top: 30%; left: 40%;"/><br>Loading..
	</div>
	<tiles:insertAttribute name="Header"></tiles:insertAttribute>

	<tiles:insertAttribute name="Left"></tiles:insertAttribute>

	<tiles:insertAttribute name="Body"></tiles:insertAttribute>



	<tiles:insertAttribute name="Footer"></tiles:insertAttribute>
	
	
	
</body>

</html>






