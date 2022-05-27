<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Employee"%>
<html>
<head>
<title>Dynamic Drop Down List Demo - CodeJava.net</title>
</head>
<%@ include file="header.jsp"%>

<body>
	<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
	%>
	<div align="center">
		<h2>Dynamic Drop Down List Demo</h2>
		<form action="AssignProjectToEmployeeByNameAndId" method="post">
			Select a Category:&nbsp;</form>
		<form action="AssignProjectToEmployeeByNameId">
			<select name="employee_name">
				<%List<Employee> empData = (List<Employee>) session.getAttribute("empList");
			for (Employee e : empData) {
			%>

				<option>
					<%= e.getEmpName()%>
				</option>
				<a href="AssignProjectToEmployeeByNameAndId?id=<%=e.getEmpId()%>">AssignProjectToEmployeeByNameId</a>
				<%
			 }
			 %>
			</select> <input type="submit" name="submit"
				value="Select Employee to Assign project " />
		</form>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>