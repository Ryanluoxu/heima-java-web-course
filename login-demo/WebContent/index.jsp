<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Demo</title>
</head>
<body style="text-align: center;">

${message }

	<br><br>
	<a href="${pageContext.request.contextPath }/RegisterUIServlet">Register</a><br>
	<br><br>
	<a href="${pageContext.request.contextPath }/LoginUIServlet">Login</a><br>

</body>
</html>