
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<center>
		<h2>Your user name: <%= session.getAttribute("user-name") %></h2>
		<form action="change-password" method="post">
			<table border="1" align="center">
				<tr>
					<td bgcolor="#949494">Old Password</td>
					<td><input type="password" name="old_password"></td>
				</tr>
				<tr>
					<td bgcolor="#949494">New Password</td>
					<td><input type="password" name="new_password"></td>
				</tr>
				<tr>
					<td bgcolor="#949494">Type Again</td>
					<td><input type="password" name="again_password"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Change" name="change" style="width: 100%; font-size: large; font-weight: 700;"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>