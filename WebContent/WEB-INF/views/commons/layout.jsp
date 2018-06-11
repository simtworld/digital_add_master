<!DOCTYPE html>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="ce"%> --%>
<html>
<head></head>
<%-- <fmt:setBundle basename="resources/ApplicationResources" var="bndl"/> --%>
<body>   
      <tiles:insertAttribute name="Header"></tiles:insertAttribute>
     
      <tiles:insertAttribute name="Left"></tiles:insertAttribute>
     
      <tiles:insertAttribute name="Body"></tiles:insertAttribute>
      
      
    
      <tiles:insertAttribute name="Footer"></tiles:insertAttribute>
</body>
 
</html>






