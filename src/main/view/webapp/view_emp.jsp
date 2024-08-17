<%@page import="model.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="view_emp" method="post">
		Enter id: <input type ="number" name="id"><br>
		<input type ="submit" value ="find">
	</form>
	
	<%
		Employee emp=(Employee)request.getAttribute("employee");
		String message=(String)request.getAttribute("message");
	%>
	<%
		if(emp!= null){
	%>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Phone</th>
			<th>password</th>
			<th>Role</th>
		</tr>
		<tr> 
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getPhone()%></td>
			<td><%=emp.getPassword()%></td>
			<td><%=emp.getRole()%></td>
			
		</tr>
	</table>
	
<%
		}	
	if(emp==null){
		out.print("<h6><mark>"+message+"</mark></H6>");
	}
	%>
</body>
</html>