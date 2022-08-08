
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<link rel="stylesheet" href="styles.css">
<title>Loan List</title>
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
          <form action="AdminViewTrans">
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
 <%@ page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@page import="com.ncs.controller.TransList"%>
<% ArrayList<TransList> listOfTrans = (ArrayList)session.getValue("t"); %>    
<h1 style="background-color:black;color:silver; text-align:center">Hello <%out.println(session.getAttribute("adminUN"));%> below is the list of transaction:</h1>

<!-- Table to display the data of loans -->
<table id="adtranstable" style="border: 1px solid black;
  border-collapse: collapse;"class="table table-dark table-striped table-hover">
  
  <!-- Defining the table headers -->
  <thead >
  	<tr>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">id</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Amount</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Type</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Username</th>
    <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Unique ID</th>
  <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Actions</th>
		
	</tr>
	</thead>
	
<!-- 	using for loop to iterate through the Transaction object -->
 	<%for(int transCount =0;transCount<listOfTrans.size();transCount++){ %>

	<tr style="border: 1px solid black;
  border-collapse: collapse;">
  <!-- Getting the individual transaction and initializing it to type TransList imported from different class -->
		<%TransList tl = (TransList)listOfTrans.get(transCount); %>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(tl.getId()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(tl.getAmount()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(tl.getType()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(tl.getUsername()); %>
		</td> 
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(tl.getUniqueTransID()); %>
		</td> 
		<td><form action="AdDeleteTransaction"><button class="btn btn-danger" type="submit" name="transID" value="<%=tl.getId()%>">Delete</button></form></td>
	</tr>
	<%}%>
</table>
<form class="regform" action="FilterID">
	<table>
		<tr>
			<td style="color:silver; font-size:30px; font-family:monospace">Unique ID: </td><td><input type="number" name="filterID" placeholder="search for ID" required></td>
		</tr>
	
	</table>
	<button class="btn btn-outline-danger" type="submit" value = "filteredSearch">Search</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>