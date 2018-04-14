<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>LOGIN FORM</h3>


	<form action="/spring-mvc-hibernate/" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="Login" /></td>
			</tr>
		</table>

	</form>
	
	<h4>For the first time, please use username: admin / password: admin to register new account</h4>

</body>
</html>

