<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<link rel="stylesheet" href="styles.css">
<title>Input edit details</title>
</head>
<body style="background-color:black">
<nav class="navbar navbar-expand-lg navbar-light bg-dark bg-gradient text-white-50">
  <div class="container-fluid">
  
  	<!-- NavBar logo for ABS bank -->
  	<a class="navbar-brand mt-2 mt-lg-0" href="landing.html">
        <img src="./img/ABS.png" height="30" width="30" alt="ABS logo"/>
      </a>
    <div class="collapse navbar-collapse" id="adminOptions">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item customerOptions">
          <form action="ListOfTrans.jsp">
				<button class="btn btn-outline-light btn-rounded" type="submit" name="adminViewLoans">View Transactions</button>
		  </form>
        </li>
        <li class="nav-item adminOptions">
          <form action="ViewCustomerList" >
          	<button class="btn btn-outline-light btn-rounded" type="submit" name="ViewCustomerList">View customers</button>
       	  </form>
        </li>
        <li class="nav-item adminOptions">
          <form action="AdminViewLoans" >
          	<button class="btn btn-outline-light btn-rounded"type="submit" name="adminViewLoans">View loans</button>
       	  </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
     
<h1 style="background-color:black;color:silver; text-align:center">Hello <%out.println(session.getAttribute("adminUN"));%>, ONLY update relevant fields:</h1>


<table id="admineditcus" style="
	border: 1px solid black;
  	border-collapse: collapse;
  	margin-left:auto;
	margin-right:auto;
	width:100%;
	height:50%;
	text-align: center;
  "class="table table-dark table-striped table-hover">
  
  <!-- Defining the table headers -->
  <thead >
  	<tr>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">id</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Name</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Username</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Password</th>
    <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Email</th>
  <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Balance</th>
  <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Security Answer</th>
	</tr>
	</thead>
	<tr style="border: 1px solid black;
  border-collapse: collapse;">
  
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("id")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("name")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("customerUN")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("customerPW")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("customerEmail")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("bal")); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(session.getAttribute("secA")); %>
		</td>
		
	</tr>
	
</table>
<form class="adEditCus" action="AdEditCustomer2">
	<table>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Name: </td><td><input type="text" name="newName" value="<%=session.getAttribute("name")%>"></td>
		</tr>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Username: </td><td><input type="text" name="newUN" value="<%=session.getAttribute("customerUN")%>"></td>
		</tr>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Password: </td><td><input type="text" name="newPW" required></td>
		</tr>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Email: </td><td><input type="text" name="newEmail" value="<%=session.getAttribute("customerEmail")%>"></td>
		</tr>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Balance: </td><td><input type="text" name="newBalance" value="<%=session.getAttribute("bal")%>"></td>
		</tr>
		<tr>
			<td style="color:silver; font-size:40px; font-family:monospace">Security Answer: </td><td><input type="text" name="secA" value="<%=session.getAttribute("secA")%>"></td>
		</tr>
	</table>
	<button class="btn btn-outline-danger" type="submit">Change</button>

</form>

<div class="blocker">></div>
<div class="image-container">
	<div class="bg-image2"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>

