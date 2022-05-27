<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Project"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Project Details</title>
<head>

    <link rel="stylesheet" href="./hello.css">

    <title>Project Details</title>

    <link rel="stylesheet" href=https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css

        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>

<%@ include file ="header.jsp" %>

<body>
<form action="UpcomingProjectServlet" method="post,get">
	 <div class="main-container">

            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark  sticky-top">

                <a class="navbar-brand" href="AllProjectListServlet">All Project</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">

                  <span class="navbar-toggler-icon"></span>

                </button>

                <div class="collapse navbar-collapse" id="navbarNav">

                  <ul class="navbar-nav">

                    <li class="nav-item">

                        <a href="add-new-project.jsp" class="nav-link">Add New Project</a>

                    </li>

                    <li class="nav-item">

                        <a href="UpcomingProjectServlet" class="nav-link">Upcoming Projects</a>

                    </li>

                    <li class="nav-item">

                        <a href="OnGoingProjectServlet" class="nav-link">On Going Projects</a>

                    </li>

                    <li class="nav-item">

                        <a href="CompletedProjectServlet" class="nav-link">Completed Projects</a>

                    </li>

                    <li class="nav-item">

                        <a href="search.jsp" class="nav-link">Search Project</a>

                    </li>
                    
                     <li class="nav-item">

                        <a href="LogoutServlet" class="nav-link">Logout</a>

                    </li>

                  </ul>

                </div>

              </nav>

	 <div class="container">

                <br>

                <h3 class="text-center">List of Projects</h3>

                <br>

                <table class="table table-striped table-hover table-bordered">

                    <thead  class="thead-dark">

					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Feature</th>
						<th>Status</th>
						<th>Assign </th>
					</tr>
				</thead>
				<tbody>

					<%	
					HttpSession httpSession = request.getSession();
				List<Project> projectdata=(List<Project>)httpSession.getAttribute("listProjectkeyForupcomingjsp");
				 for (Project p : projectdata) {
					%>
					<tr>
						<td><%= p.getProjectId() %></td>
						<td><%= p.getProjectName()%></td>
						<td><%= p.getProjectFeature()%></td>
						<td><%= p.getStatus() %>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="AssignEmployeeServlet?id=<%=p.getProjectId()%>">Assign to Employee ?</a></td>
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
</html>