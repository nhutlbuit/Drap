<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
		<h2>Please enter your user name and password.</h2>
		<form action="check-login" method="post">
			<table border="1" align="center" width="17%">
				<tr>
					<td bgcolor="#949494">Username</td>
					<td><input type="text" name="user_name"></td>
				</tr>
				
				<tr>
					<td bgcolor="#949494">Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Login" name="login" style="width: 100%; font-size: large; font-weight: 800;"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>