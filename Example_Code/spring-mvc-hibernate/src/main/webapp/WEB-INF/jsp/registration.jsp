<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Registration Form</h2>

	<form method="POST">

		<table>
			<tr>
				<td>First name :</td>
				<td><input type="text" name="firstname"
					value='${student.firstname}' /></td>
			</tr>
			<tr>
				<td>Last name :</td>
				<td><input type="text" name="lastname"
					value='${student.lastname}' /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="text" name="age" value='${student.age}' /></td>
			</tr>
			<tr>
				<td>Is male :</td>
				<td><input type="checkbox" name="sex" value='${student.sex}' />
				</td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"
					value='${student.username}' /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					value='${student.password}' /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Student's Address :</td>
			</tr>
			<tr>
				<td>country: <input type="text" name="address.country"
					value='${student.address.country}' /></td>
				<td>city: <input type="text" name="address.city"
					value='${student.address.city}' /></td>
				<td>street: <input type="text" name="address.street"
					value='${student.address.street}' /></td>
			</tr>

			<tr>
				<td colspan="2"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Add" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

	</form>

	<br />
	<br /> Go back to
	<a href="<c:url value='/list' />">List of All Students</a>
</body>
</html>