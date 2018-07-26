<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix = "spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="?lang=en">English</a>|<a href="?lang=ar">Arabic</a>


<form action="${contextPath}/login" method = "post">
<spring:message code="label.username"></spring:message> <input type="text" name="username">
<spring:message code="label.password"></spring:message> <input type="password" name="password">
<input type="submit" value="Login">
</form>
</body>
</html>


