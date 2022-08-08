<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance failed</title>
</head>
<h1 style="background-color:black;color:salmon; text-align:center"><%out.println(session.getAttribute("name")); %> Your balance cannot be viewed</h1>

<span style="background-color: white"><a href="CustomerSuccess.jsp">re-try </a></span>
</body>
</html>