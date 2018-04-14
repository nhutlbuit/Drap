<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>

	<table>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Street</td>
			<td>City</td>
			<td>Country</td>
		</tr>
		<tr>
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.address.street}</td>
			<td>${student.address.city}</td>
			<td>${student.address.country}</td>
		</tr>

	</table>
	<h2>Scores table</h2>
	<table>
		<tr>
			<td>Subject</td>
			<td>Score</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${scores}" var="scores">
			<tr>
				<td>${scores.subject}</td>
				<td>${scores.score}</td>
				<td><a href="<c:url value='/edit-${student.id}-score-${scores.score_id}' />">edit</a></td>
				<td><a
					href="<c:url value='/delete-${student.id}-score-${scores.score_id}' />">delete</a></td>
			</tr>
		</c:forEach>

	</table>

	<h2>Scores average: ${avgscore}</h2>
	<br />
	<%-- 	<a href="<c:url value='/add-${student.id}-score' />">Add New Score</a> --%>
	<form action="/spring-mvc-hibernate/add-score" method="get">
		<input type="hidden" name="studentid" value="${student.id}" />
		<table>		
			<tr>
				<td><input type="submit" value="Add score" /></td>
			</tr>
		</table>

	</form>
	<%-- 	<a href="<c:url value='/new' />">Add New Student</a> --%>
</body>
</html>