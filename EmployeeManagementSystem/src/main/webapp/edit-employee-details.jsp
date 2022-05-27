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
<!DOCTYPE style PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Register New Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="https://bootswatch.com/3/paper/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="form-wrap">

			<form action="ProfileServletForEditEmp" method="post">
				<% Employee emp = (Employee)session.getAttribute("empKeyForjsp"); %>
				<div class="form-group">
					<label for="name">Name :</label> <input class="input" type="text"
						name="name" value="<%= emp.getEmpName() %>" id="emp_name" />
				</div>
				<div class="form-group">
					<label for="password">Password :</label> <input class="input"
						type="password" name="password" value="<%= emp.getPassword() %>"
						id="password" />
				</div>
				<div class="form-group">
					<label for="email">Email :</label> <input type="email"
						class="input" name="email" value="<%= emp.getEmail() %>" />
				</div>
				<div class="form-group">
					<label for="mob">Mobile :</label> <input type="text" name="mob"
						value="<%= emp.getMobNO() %>" class="input" />
				</div>
				<div class="form-group">
					<label for="dob">DOB : </label> <input type="date" name="dob"
						value="<%= emp.getDob() %>" class="input" />
				</div>

				<div class="form-group">
					<label for="hobbies">Hobbies : </label> <input type="text"
						name="hobbies" value="<%= emp.getHobbies() %>" class="input" />
				</div>
				<div class="form-group">
					<label for="admin" class="admin-label"> Admin : </label> <input
						class="radioBtn" type="radio" <%if(emp.getIsAdmin()==1){ %>
						id="yes" name="fav_language" value="<%= emp.getIsAdmin()  %>">
					<%
						}
						%>
					<% if(emp.getIsAdmin()==0) { %>
					<label class="radiobtn-Label" for="yes">Yes</label> <input
						class="radioBtn" type="radio" id="no" name="fav_language"
						value="<%= emp.getIsAdmin()  %>"> <label
						class="radiobtn-Label" for="no">No</label>
					<%} %>
				</div>
				<div id="repeater">
				<div class="repeater-heading">
					<input type="button" value="Add Adresses"
						class="pull-right repeater-add-btn">
				</div>
				<%
				List<Address> add = (List<Address>) session.getAttribute("addressDetailsKeyForJsp");
				ArrayList<String> street = (ArrayList<String>)session.getAttribute("street");
				ArrayList<String> city = (ArrayList<String>)session.getAttribute("city");
				ArrayList<String> state = (ArrayList<String>)session.getAttribute("state");
				ArrayList<String> pinCode = (ArrayList<String>)session.getAttribute("pinCode");
				 if(add.size()==0){
				%>
				<div class="clearfix"></div>
					<div class="items" data-group="test">
						<!-- Repeater Content -->
						<div class="item-content">
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Street</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputStreet" name="street[0]" value="" data-name="street">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">City</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputCity" name="city[0]" value="" data-name="city">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">State</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputState" name="state[0]" value="" data-name="state">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Pin
									code</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputPinCode" name="pinCode[0]" value="" data-name="pincode">
								</div>
							</div>
						</div>
						<!-- Repeater Remove Btn -->
						<div onclick="DeleteAddressServlet class="pull-right repeater-remove-btn">
							<input type="submit" value="Remove" class="btn btn-danger remove-btn">
						</div>
						<div class="clearfix"></div>
					</div>
				<% } %> 
				<% 
				for(int i=0;i<add.size();i++){
				%>

					<div class="clearfix"></div>
					<!-- Repeater Items -->
					<div class="items" data-group="test">
						<!-- Repeater Content -->
						<div class="item-content">
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Street</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputStreet"
										name="street[<%=i%>]" value="<%= street.get(i) %>"
										data-name="street" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">City</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputCity"
										name="city[<%=i%>]" value="<%=city.get(i)%>" data-name="city">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">State</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputState"
										name="state[<%=i%>]" value="<%=state.get(i)%>"
										data-name="state">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Pin
									code</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputPinCode"
										name="pinCode[<%=i%>]" value="<%=pinCode.get(i) %>"
										data-name="pincode">
								</div>
							</div>
						</div>
						<!-- Repeater Remove Btn -->
						<div onClick="DeleteAddressServlet?id=<%= add.get(i).getAddId() %>" class="pull-right repeater-remove-btn" >
							<input type="submit"		
								value="Remove" class="btn btn-danger remove-btn">
						</div>
						<div class="clearfix"></div>
					</div>

				<%
				}
				%>
				</div>

				<button type="Submit">Update Details</button>
			</form>
		</div>
	</div>
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
