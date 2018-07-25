<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.welcomePageTitle"></spring:message></title>
</head>
<body>

<h1><spring:message code="label.welcomeMessage"></spring:message></h1>
<form action="ticket" method="GET">
<spring:message code="label.ticketId"></spring:message><input type="text" name="Student_Id">
<input type="submit" value="<spring:message code="label.search"></spring:message>">
</form>

<a href="createTicket"><spring:message code="label.createTicketSubmit"></spring:message></a>
</body>
</html>