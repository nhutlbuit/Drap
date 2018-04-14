<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Date createTime = new Date(session.getCreationTime());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Session</title>
</head>
<body>
	<center>
		<% if (session.getAttribute("user-name") != null){ %>
			<h3>You are logining!</h3>
			<h4>Your user name is: <%=session.getAttribute("user-name").toString() %></h4>
			<h4>Your password is: <%=session.getAttribute("password").toString() %></h4>
			<p>The session was created: <%=createTime %></p>
			
			<br><br>
			<a href="index.jsp">Go Home Page</a>
		<%} else { %>
			<h3>You are not logining</h3>
			<br><br>
			<a href="login.jsp">Log in</a>
			<a href="index.jsp">Go Home Page</a>
		<%} %>
	</center>
</body>
</html>