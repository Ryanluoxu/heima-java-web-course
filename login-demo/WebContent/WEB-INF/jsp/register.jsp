<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<br>
<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
	<table align="center">
		<thead align="center">
			<tr><td colspan="2">User Register</td></tr>
		</thead>
		<tbody>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"></td>
				<c:if test="${form.errors.username==null }">
					<td>3 - 12 characters</td>
				</c:if>
				<c:if test="${form.errors.username!=null }">
					<td style="color: red;">Error: ${form.errors.username }</td>
				</c:if>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
				<c:if test="${form.errors.password==null }">
					<td>6 - 20 characters</td>
				</c:if>
				<c:if test="${form.errors.password!=null }">
					<td style="color: red;">Error: ${form.errors.password }</td>
				</c:if>
			</tr>
			<tr>
				<td>Confirmed Password :</td>
				<td><input type="password" name="password2"></td>
				<c:if test="${form.errors.password2==null }">
					<td>Enter password again</td>
				</c:if>
				<c:if test="${form.errors.password2!=null }">
					<td style="color: red;">Error: ${form.errors.password2 }</td>
				</c:if>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"></td>
				<c:if test="${form.errors.email!=null }">
					<td style="color: red;">Error: ${form.errors.email }</td>
				</c:if>
			</tr>
		</tbody>
		<tfoot align="right">
			<tr> </tr>
			<tr><td colspan="2">
				<input type="submit" value="Register">
			</td></tr>
		</tfoot>
	</table>
</form>
</body>
</html>