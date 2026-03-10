<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ag.model.User"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>

<body>

	<%
	User user = (User) session.getAttribute("session_user");
	%>
	<h2>Welcome to Profile Page</h2>
	<h3>Name : <%=user.getName() %></h3>

</body>

</html>