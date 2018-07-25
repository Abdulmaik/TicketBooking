<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.createPageTitle"></spring:message></title>
</head>
<body>
<form  action= "create" method="POST">
<spring:message code="label.ticketId"></spring:message>  <input type="text"  name=id >
<spring:message code = "label.passengerName"></spring:message> <input type = "text" name="passengerName">
<spring:message code="label.sourceStation"></spring:message> <input type = "text" name="source">
<spring:message code="label.destStation"></spring:message> <input type = "text" name="dest">
<spring:message code="label.bookDate"></spring:message> <input type = "text" name="bookDate">

<input type="submit" value="<spring:message code="label.createTicketSubmit"></spring:message>">
</form>
</body>
</html>