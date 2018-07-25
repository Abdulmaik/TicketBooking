<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    	   <%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <style type="text/css">
    	
    	table {
    border-collapse: collapse;
      width: 100%;
}

table, th, td {
    border: 1px solid black;
    height: 50% ;
    text-align: center;
}


}
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.searchPageTitle"></spring:message></title>
</head>
<body>
<h1><spring:message code="label.searchResultWelcome"></spring:message></h1>
<c:choose>
<c:when test="${empty ticket_info}">
<table>
<tr>
<th><spring:message code="label.ticketId"></spring:message></th>
<th><spring:message code = "label.passengerName"></spring:message></th>
<th><spring:message code="label.bookDate"></spring:message></th>
<th><spring:message code="label.sourceStation"></spring:message></th>
<th><spring:message code="label.destStation"></spring:message></th>
</tr>
<c:forEach items="${allTickets}" var="ticket1">
<tr>
<td>${ ticket1.id}</td><td>${ticket1.passengerName}</td><td>${ticket1.bookDate}</td><td>${ticket1.source}</td><td>${ticket1.dest}</td>
<td><a href="delete/${ticket1.id}"><spring:message code="label.deleteLink"></spring:message></a></td>
<td><a href="updatePage/${ticket1.id}"><spring:message code="label.updateLink"></spring:message></a></td>
</tr>
</c:forEach>

</table>
</c:when>
<c:otherwise>

<table>
<tr>
<th><spring:message code="label.ticketId"></spring:message></th>
<th><spring:message code = "label.passengerName"></spring:message></th>
<th><spring:message code="label.bookDate"></spring:message></th>
<th><spring:message code="label.sourceStation"></spring:message></th>
<th><spring:message code="label.destStation"></spring:message></th>
</tr>
<tr>
<td>${ ticket_info.id}</td><td>${ticket_info.passengerName}</td><td>${ticket_info.bookDate}</td><td>${ticket_info.source}</td><td>${ticket_info.dest}</td>
<td><a href="delete/${ticket_info.id}"><spring:message code="label.deleteLink"></spring:message></a></td>
<td><a href="updatePage/${ticket_info.id}"><spring:message code="label.deleteLink"></spring:message></a></td>
</tr>
</table>
</c:otherwise>
</c:choose>
<a href="createTicket"><spring:message code="label.createTicketSubmit"></spring:message></a>
</body>
</html>