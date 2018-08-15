<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body style="text-align: center;">

	<jsp:useBean id="calculator" class="io.demo.jsp.calculator"></jsp:useBean>
	<jsp:setProperty property="*" name="calculator"/>
	
	<%
		try{
			calculator.calculate();
		} catch (Exception e){
			out.write(e.toString());
		}
	%>
	
	<br>------------------------------------------------<br>
	Result:
	<jsp:getProperty property="firstNum" name="calculator"/>
	<jsp:getProperty property="operator" name="calculator"/>
	<jsp:getProperty property="secondNum" name="calculator"/>
	=
	<jsp:getProperty property="result" name="calculator"/>
	<br>------------------------------------------------<br>
	
	<form action="/javaweb-heima/calculator.jsp" method="post">
	
		<table width="40%" border="1px">
			<tr>
				<td colspan="2">Calculator</td>
			</tr>
			<tr>
				<td>First Number</td>
				<td>
					<input type="text" name="firstNum">	
				</td>
			</tr>
			<tr>
				<td>Operator</td>
				<td>
					<select name="operator">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Second Number</td>
				<td>
					<input type="text" name="secondNum">	
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Calculate!">
				</td>
			</tr>
		
		</table>
	
	</form>
	
</body>
</html>