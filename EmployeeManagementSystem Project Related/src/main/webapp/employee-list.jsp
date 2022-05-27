<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Employee"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>



<head>

<link rel="stylesheet" href="./hello.css">

<title>Employee Details</title>

<link rel="stylesheet"
	href=https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<%@ include file="header.jsp"%>


<body>

	<form action="ProjectServlet" method="post,get">

		<div class="main-container">

			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark  sticky-top">

				<a class="navbar-brand" href="#">All Employee</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">

					<span class="navbar-toggler-icon"></span>

				</button>

				<div class="collapse navbar-collapse" id="navbarNav">

					<ul class="navbar-nav">

						<li class="nav-item"><a href="register.jsp" class="nav-link">Add
								New Employee</a></li>


						<li class="nav-item"> 
								<input type="text" name="name"  value= "Search Employee" id="name" class= "nav-link">
								<input type="submit" name="submit" value="Search"> 
</li>
						<li class="nav-item"><a href="LogoutServlet" class="nav-link">Logout</a>

						</li>

					</ul>

				</div>

			</nav>

			<div class="container">

				<br>

				<h3 class="text-center">List of Employee</h3>

				<br>

				<table class="table table-striped table-hover table-bordered">

					<thead class="thead-dark">

						<tr>

							<th>ID</th>

							<th>Name</th>

							<th>Contact No</th>

							<th>Email</th>

							<th>DOB</th>
							
							<th>Hobbies</th>

						</tr>

					</thead>

					<tbody>

						<%
						List<Employee> empdata = (List<Employee>) request.getAttribute("listEmpkeyForjsp");
						for (Employee e : empdata) {
						%>
						<tr>
							<td><%=e.%></td>
							<td><%=p.getProjectName()%></td>
							<td><%=p.getProjectFeature()%></td>
							<td><%=p.getStatus()%>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteProjectServlet?id=<%=p.getProjectId()%>">Delete</a></td>
						</tr>
						</tr>
						<%
						}
						%>


					</tbody>

				</table>
			</div>
		</div>
</body>
<br />
<br />
<br />
<%@ include file="footer.jsp"%>
</html>