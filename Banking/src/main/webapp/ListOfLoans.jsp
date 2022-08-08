
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
<%@page import="com.ncs.controller.LoanList"%>
<% ArrayList<LoanList> listOfLoans = (ArrayList)session.getValue("l"); %>    
<h1 style="background-color:black;color:silver; text-align:center">Hello <%out.println(session.getAttribute("adminUN"));%> below is the list of loans:</h1>

<!-- Table to display the data of loans -->
<table id="adloanstable" style="border: 1px solid black;
  border-collapse: collapse;" class="table table-dark table-striped table-hover">
  
  <!-- Defining the table headers -->
  <thead >
  	<tr>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">id</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Username</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Loan Type</th>
		<th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Amount</th>
    <th style="border: 1px solid black;
  border-collapse: collapse;" class="tableHead">Status</th>
  <th style="border-bottom: 1px solid black; border-collapse: collapse;" class="tableHead"></th>
  <th style="border-bottom: 1px solid black;border-collapse: collapse;" class="tableHead"></th>
  
	</tr>
	</thead>
	
<!-- 	using for loop to iterate through the customer object -->
 	<%for(int loanCount =0;loanCount<listOfLoans.size();loanCount++){ %>

	<tr style="border: 1px solid black;
  border-collapse: collapse;">
  <!-- Getting the individual customer and initializing it tp type CustomerList imported from different class -->
		<%LoanList ll = (LoanList)listOfLoans.get(loanCount); %>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(ll.getId()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(ll.getUsername()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(ll.getLoan_type()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(ll.getAmount()); %>
		</td>
		<td style="border: 1px solid black;
  border-collapse: collapse;">
			<%out.println(ll.getStatus()); %>
		</td>
		<td><form action="EditLoans"><button class="btn btn-success" type="submit" name="loanID" value="<%=ll.getId()%>">Approve</button></form></td>
		<td><form action="RejectLoans"><button class="btn btn-danger" type="submit" name="loanID" value="<%=ll.getId()%>">Reject</button></form></td>
	</tr>
	<%}%>
</table>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>