<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo - get current time</title>
</head>
<body>

<%@page import="java.io.*, java.util.Date, java.util.Enumeration" %> 

	Current date time 1: 
	<%
		Date date = new Date();
		out.write(date.toString());
	%>
	
	<br>
	<br>
	
	Current date time 2: 
	<%= new Date() %>		<!-- script expression -->
	
	<br>
	
</body>
</html>