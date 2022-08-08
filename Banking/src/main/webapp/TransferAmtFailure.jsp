<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<link rel="stylesheet" href="styles.css">
<title>Wrong PW</title>
</head>
<body style="background-color:black">
<nav class="navbar navbar-expand-lg navbar-light bg-dark bg-gradient text-white-50">
  <div class="container-fluid">
  
  	<!-- NavBar logo for ABS bank -->
  	<a class="navbar-brand mt-2 mt-lg-0" href="CustomerSuccess.jsp">
        <img src="./img/ABS.png" height="30" width="30" alt="ABS logo"/>
      </a>
    <div class="collapse navbar-collapse" id="customerOptions">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item customerOptions">
          <form action="UpdatePW.jsp">
				<button class="btn btn-outline-light btn-rounded" type="submit" name="changePW">Change password</button>
		  </form>
        </li>
        <li class="nav-item customerOptions">
          <form action="UpdateParticulars.jsp" >
          	<button class="btn btn-outline-light btn-rounded" type="submit" name="updateParticulars">Update personal info</button>
       	  </form>
        </li>
        <li class="nav-item customerOptions">
          <form action="ViewBalance" >
          	<button class="btn btn-outline-light btn-rounded"type="submit" name="ViewBalance">Balance</button>
       	  </form>
        </li>
         <li class="nav-item customerOptions">
          <form action="ViewTransaction" >
          	<button class="btn btn-outline-light btn-rounded" type="submit" name="ViewTransaction">Transactions</button>
       	  </form>
        </li>
         <li class="nav-item customerOptions">
          <form action="SendMoney.jsp" >
          	<button class="btn btn-outline-light btn-rounded" type="submit" name="SendMoney">Funds Transfer</button>
       	  </form>
        </li>
         <li class="nav-item customerOptions">
          <form action="ApplyLoan.jsp" >
          	<button class="btn btn-outline-light btn-rounded" type="submit" name="ViewBalance">Loans Application</button>
       	  </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
<h1 style="background-color:black;color:silver; text-align:center">Dear <%out.println(session.getAttribute("name")); %> the value you've input is greater than your current balance.</h1>
<h3 style="background-color:black;color:silver; text-align:center">Return to your dashboard and check your balance</h3>

<div class="blocker"></div>
<div class="image-container">
	<div class="bg-image"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>