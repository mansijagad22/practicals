<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Project"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%@ include file ="header.jsp" %>
<body>
	<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
	%>
	<form method="post" name="frm" action="SearchServlet">
	<div class="main-container">

			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark  sticky-top">
				
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">

					<span class="navbar-toggler-icon"></span>

				</button>

				<div class="collapse navbar-collapse" id="navbarNav">

					<ul class="navbar-nav">

						<li class="nav-item"><a
							href="homepage.jsp" class="nav-link">Home</a></li>
</ul>

				</div>

			</nav>

		</div>
		<table border="0" width="300" align="center" bgcolor="#CDFFFF">
			<tr>
				<td colspan=2 style="font-size: 12pt; color: #00000;" align="center">
					<h3>Search</h3>
				</td>
			</tr>
			<tr>
				<td><b>Project Name</b></td>
				<td>: <input type="text" name="name" id="name">
				</td>
			</tr>

			<tr>
			<br><br>
				<td colspan=2 align="center"><input type="submit" name="submit"
					value="Search"></td>
			</tr>
		</table>
	</form>


	<%-- <table class="table table-bordered">
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


			</tbody> --%>
</body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<%@ include file ="footer.jsp" %>
</html>