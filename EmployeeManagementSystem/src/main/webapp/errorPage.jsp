<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage ="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Error</title>
</head>
<%@ include file ="header.jsp" %>
<body>
<centre>
<h1> Error</h1> 
<h2> <%= exception.getMessage() %></h2>
</body>
<%@ include file ="footer.jsp" %>
</html>