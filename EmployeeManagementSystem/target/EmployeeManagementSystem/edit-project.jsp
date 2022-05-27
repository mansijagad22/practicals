<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Project"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.title {
	text-align: center;
}

label {
	font-weight: 600;
}

.main-container {
	width: 100%;
	display: flex;
	justify-content: center;
}

.input {
	height: 30px;
	width: 110%;
	border: 2px solid black;
	border-radius: 5px;
	margin-left: 10px;
}

.table-container {
	border: 1px solid black;
	padding: 50px;
	border-radius: 5px;
}

.submit-button {
	margin: auto;
	width: 110%;
	height: 40px;
}
</style>

<h2 class="title">Edit Detail</h2>
<div class="main-container">
	<form action="EditProjectServlet" method="post">
		<table class="table-container">
			<%
			Project p = (Project) session.getAttribute("listProjectkeyForjsp");
			%>
			<tr>
				<td><label for="featute">Feature :</label></td>
				<td><%=p.getProjectFeature()%></td>
			</tr>
			<tr>
				<label for="status">edit status</label>
				<select name="status" id="status">
					<option value="upcoming">Upcoming</option>
					<option value="ongoing">Ongoing</option>
					<option value="completed">Completed</option>
				</select>
			</tr>
			<tr>
				<td colspan="2"><input class="submit-button" type="submit"
					value="Update Project " /></td>
			</tr>
		</table>
	</form>
</div>
<br />

 --%>