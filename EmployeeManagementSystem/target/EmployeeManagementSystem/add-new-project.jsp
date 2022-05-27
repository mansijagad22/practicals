<style>

.title{
	text-align:center;	
	
}
label{
	font-weight:600;
}
.main-container{
	width:100%;
	display:flex;
	justify-content:center;
}
.input{
	height:	30px;
	width:110%;
	border:2px solid black;
	border-radius:5px;
	margin-left:10px;
}
.table-container{
	border:1px solid black;
	padding:50px;
	border-radius:5px;
}
.submit-button{
	margin:auto;
	width:110%;
	height:40px;
}
</style>

<h2 class="title">Add New Employee</h2>
<div class="main-container">
<form action="NewProjectServlet" method="post">
	<table class="table-container">
		<tr>
			<td><label for="name">Project Name :</label></td>
			<td><input class="input" type="text" name="name" id="name"/></td>
		</tr>
		<tr>
			<td><label for="password">Feature :</label></td>
			<td><input class="input" type="text" name="feature" id="feature" /></td>
		</tr>
		<tr>
			<td colspan="2"><input class="submit-button" type="submit" value="Add Project" /></td>
		</tr>
	</table>
</form>
</div>
<br />
