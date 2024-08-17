<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String message=(String)request.getAttribute("message");
	if(message!=null){
%>
		<h2><%= message %></h2>
<%
	}
%>

<h1> Admin Operation </h1>
<h2><a href="add_emp.jsp">Add Employee</a></h2>
<h2><a href="view_emp.jsp">View Employee</a></h2>
<h2><a href="view_all_emp">View All Employee</a></h2>
<h2><a href="#">Remove Employee</a></h2>
<h2><a href="#">Update Employee</a></h2>
</body>
</html>