<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Project"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%@ include file ="header.jsp" %>
<br/>
<body>

	<form action="SearchServlet" method="post,get">
		<br>
		<br />
		<hr>
		<h3 class="text-center">matched results...</h3>
				<hr>
				<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Feature</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
						HttpSession httpSession = request.getSession();
						List<Project> projectdata = (List<Project>) httpSession.getAttribute("search");
						for (Project p : projectdata) {
						%>
				<tr>
					<td><%=p.getProjectId()%></td>
					<td><%=p.getProjectName()%></td>
					<td><%=p.getProjectFeature()%></td>
					<td><%=p.getStatus()%>
				</tr>
				</tr>
				<%
						}
						%>
			</tbody>
</body>

</html>