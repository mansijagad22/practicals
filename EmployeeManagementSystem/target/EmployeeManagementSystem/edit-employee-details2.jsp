<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="entity.Employee"
	import="java.util.ArrayList" import="entity.Address"%>
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
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="https://bootswatch.com/3/paper/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

</head>
<body>
	<h2 class="title">Edit Detail</h2>
	<div class="main-container">
		<form action="ProfileServletForEditEmp" method="post">
			<table>
				<%
			Employee emp = (Employee) session.getAttribute("empKeyForjsp");
			%>
				<tr>
					<td><label for="id">Id :</label></td>
					<td><%=emp.getEmpId()%></td>
					<br />
					<br />
				</tr>
				<tr>
					<td><label for="name">Name :</label></td>
					<td><%=emp.getEmpName()%></td>
				</tr>
				<tr>
					<td><label for="email">Email :</label></td>
					<td><%=emp.getEmail()%></td>
				</tr>
				<tr>
					<td><label for="password">Password :</label></td>
					<td><input class="input" type="password" name="password"
						value="<%=emp.getPassword()%>" id="password" /></td>
				</tr>

				<tr>
					<td><label for="mob">Mobile :</label></td>
					<td><input type="text" name="mob" value="<%=emp.getMobNO()%>"
						class="input" /></td>
				</tr>
				<tr>
					<td><label for="dob">DOB : </label></td>
					<td><input type="date" name="dob" value="<%=emp.getDob()%>"
						class="input" /></td>
				</tr>
				<tr>
					<td><label for="hobbies">Hobbies : </label></td>
					<td><input type="text" name="hobbies"
						value="<%=emp.getHobbies()%>" class="input" /></td>
				</tr>
				<tr>
					<td>Admin :</td>
					<td><input type="radio" id="yes" name="fav_language"
						value="<%=emp.getIsAdmin()%>"> <label for="yes">Yes</label>

						<input type="radio" id="no" name="fav_language"
						value="<%=emp.getIsAdmin()%>"> <label for="no">No</label></td>
					<br>
				</tr>

			</table>



			<%
				
				ArrayList<String> street = (ArrayList<String>)session.getAttribute("street");
				ArrayList<String> city = (ArrayList<String>)session.getAttribute("city");
				ArrayList<String> state = (ArrayList<String>)session.getAttribute("state");
				ArrayList<String> pinCode = (ArrayList<String>)session.getAttribute("pinCode");
				for(int i=0;i<street.size();i++){
				%>

			<!-- /* List<Address> addressdata = (List<Address>) session.getAttribute("addressDetailsKeyForJsp");
				for (Address add : addressdata) {  */ -->

			<div id="repeater">
				<!-- Repeater Heading -->
				<% if(i==0){ %>
				
				<% } %>
				<!-- Repeater Items -->
				<div class="items" data-group="test">
					<!-- Repeater Content -->
					<form class="item-content">
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Street</label>
							<div class="col-lg-10">
								<input class="input" type="text" name="street[]"
									value="<%=street.get(i) %>" id="street" data-name="street">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">City</label>
							<div class="col-lg-10">
								<input class="input" type="text" name="city[]"
									value="<%=city.get(i) %>" id="city" data-name="city">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">State</label>
							<div class="col-lg-10">
								<input class="input" type="text" name="state[]"
									value="<%=state.get(i) %>" id="state" data-name="state">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Pin
								code</label>
							<div class="col-lg-10">
								<input class="input" type="text" name="pincode[]"
									value="<%=pinCode.get(i) %>" id="pincode" data-name="pincode">
							</div>
						</div>
					</div>
					<!-- Repeater Remove Btn -->
					<div class="pull-right repeater-remove-btn">
						<input type = "button" value = "Remove" data-name="Remove" class="btn btn-danger remove-btn"> 
					</div>
					<div class="clearfix"></div>
				</div>

			</div>
			<%
				}
				%>


			<%-- 	<td><a href="update.jsp?id=<%=resultSet.getString("id")%>">update</a></td> --%>

			<%-- 	<table class="table table-striped table-hover table-bordered">

					<thead class="thead-dark">

						<tr>

							<th>Street</th>

							<th>City</th>

							<th>State</th>

							<th>Pincode</th>

							<th>Remove</th>

						</tr>

					</thead>

					<tbody>

						<%
				List<Address> addressdata = (List<Address>) session.getAttribute("addressDetailsKeyForJsp");
				for (Address add : addressdata) {
				%>
						<tr>

							<td><input class="input" type="text" name="street"
								value="<%=add.getStreet()%>" id="street" /></td>
							<td><input class="input" type="text" name="city"
								value="<%=add.getCity()%>" id="city" /></td>
							<td><input class="input" type="text" name="state"
								value="<%=add.getState()%>" id="state" /></td>
							<td><input class="input" type="text" name="pincode"
								value="<%=add.getPinCode()%>" id="pincode" /></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="DeleteAddressServlet?id=<%=add.getAddId()%>">Delete</a></td>
						</tr>
						<%
				}
				%> --%>

			<hr>
			<tr>
				<br />
				<br />
				<td colspan="2" align="center"><input class="submit-button"
					type="submit" value="Update Details" /></td>
			</tr>
			</table>

		</form>
	</div>
	<!-- Import repeater js  -->
	<script src="./repeater.js" type="text/javascript"></script>
	<script>
        /* Create Repeater */
        $("#repeater").createRepeater({
            showFirstItemToDefault: true,
        });
    </script>
</body>
</html>
