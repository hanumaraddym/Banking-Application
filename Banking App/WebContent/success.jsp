<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%
out.println("Dear Customer Welcome to Internet Banking,Your Account Number is:"+session.getAttribute("accno"));
%>

<tr>
<td><a href="transfer.jsp">Third party transfer</a> </td>
</tr>
<tr>
<td><a href="Balance">Balance check</a> </td>
</tr>
<tr>
<td><a href="password.jsp">Password change</a> </td>
</tr>
<tr>
<td><a href="loan.jsp">Click here for applying Loan</a> </td>
</tr>
<tr>
<td><a href="Statement">Get Statement</a> </td>
</tr>
<tr>
<td><a href="logout.jsp">Logout</a> </td>
</tr>
</table>
</body>
</html>