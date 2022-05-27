<style>
.error-message {
	width: fit-content;
	margin: auto;
	padding: 10px;
	color: white;
	font-weight: 900;
	background-color: #ff3737;
	border-radius: 20px;
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
<script>  
var request;  
function sendInfo(){  
var email=document.vinform.email.value;
var url="emailfinder.jsp?email="+email;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('mylocation').innerHTML=val;  
}  
}  
  
</script>

</head>
<body>
	<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");// HTTP 1.0
	response.setHeader("Expires", "0"); // proxies
	%>
	<div class="container">
		<div class="form-wrap">
			<form action="Register" method="post">
				<div class="form-group">
					<label for="name">Name :</label> <input class="input" type="text"
						name="name" id="emp_name" />
				</div>
				<div class="form-group">
					<label for="password">Password :</label> <input class="input"
						type="password" name="password" id="password" />
				</div>
				<div class="form-group">
					<label for="confirmpassword">Re Enter Password :</label> <input
						class="input" type="password" name="confirmpassword"
						id="confirmpassword" />
				</div>
				<form name="vinform">
					<div class="form-group">
						<label for="email">Email :</label> <input type="email"
							name="email" /> <input type="button" onclick="sendInfo()"
							value="Check Availability" /> <span id="mylocation"></span>
					</div>
				</form>
				<div class="form-group">
					<label for="mob">Mobile :</label> <input type="text" name="mob"
						class="input" />
				</div>
				<div class="form-group">
					<label for="dob">DOB : </label> <input type="date" name="dob"
						class="input" />
				</div>

				<div id="repeater">
					<!-- Repeater Heading -->
					<div class="repeater-heading">
						<input type="button" value="Add Address"
							class="pull-right repeater-add-btn" />

					</div>
					<div class="clearfix"></div>
					<!-- Repeater Items -->
					<div class="items" data-group="test">
						<!-- Repeater Content -->
						<div class="item-content">
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Street</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputStreet"
										placeholder="enter Street" data-name="street">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">City</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputCity"
										placeholder="enter city" data-name="city">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">State</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputState"
										placeholder="enter state" data-name="state">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail" class="col-lg-2 control-label">Pin
									code</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputPinCode"
										placeholder="enter pincode" data-name="pincode">
								</div>
							</div>
						</div>
						<!-- Repeater Remove Btn -->
						<div class="pull-right repeater-remove-btn">
							<input type="button" value="Remove"
								class="btn btn-danger remove-btn" />
							</button>
						</div>
						<div class="clearfix"></div>
					</div>

				</div>
				<div class="form-group">
					<label for="hobbies">Hobbies : </label> <input type="text"
						name="hobbies" class="input" />
				</div>
				<div class="form-group">
					<label for="admin" class="admin-label"> Admin : </label> <input
						class="radioBtn" type="radio" id="yes" name="fav_language"
						value="1"> <label class="radiobtn-Label" for="yes">Yes</label>
					<input class="radioBtn" type="radio" id="no" name="fav_language"
						value="0"> <label class="radiobtn-Label" for="no">No</label>
				</div>
				<div class="form-group">
					<label for="project">Project :</label> <input type="text"
						name="projectid" class="input" />
				</div>
				<button type="Submit">Save Employee</button>
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
