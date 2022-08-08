<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<link rel="stylesheet" href="styles.css">
<title>Delected</title>
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

<h1 style="background-color:black;color:silver; text-align:center">Dear <%out.println(session.getAttribute("adminUN")); %> you have deleted the customer: </h1>
<table id="addeletecus" style="border: 1px solid black;
  border-collapse: collapse;"class="table table-dark table-striped table-hover">
	<thead>
	<tr><th>Customer ID: </th></tr>
	</thead>
	<tr>
		<td style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead"><%out.println(session.getAttribute("customerID")); %></td>
	</tr>
</table>
<div class="blocker">></div>
<div class="image-container">
	<div class="bg-image"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>