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
	<h2>List of Students</h2>
	<h3>${sticker}</h3>
	<table>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Age</td>
			<td>Sex</td>
			<td>Username</td>
			<td>Street</td>
			<td>City</td>
			<td>Country</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.age}</td>
				<td>${student.sex}</td>
				<td>${student.username}</td>
				<td>${student.address.street}</td>
				<td>${student.address.city}</td>
				<td>${student.address.country}</td>
				<td><a href="<c:url value='/edit-${student.id}-student' />">edit</a></td>
				<td><a href="<c:url value='/delete-${student.id}-student' />">delete</a></td>
				<td><a href="<c:url value='/score-${student.id}-student' />">score</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />


	<input type="text" value="" id="searchsub" size="30" />
	<button onclick="searchfun()">Search</button>
	
	<script>
		function searchfun() {
			var searchname = document.getElementById("searchsub");
			window.location.href ="search-" + searchname.value;
		}
	</script>

<br/>

	<a href="<c:url value='/new' />">Add New Student</a>
	<br/>
	<a href="<c:url value='/listsallcore' />">View All Score</a>
	<br/>
	<a href="<c:url value='/' />">Login another account</a>
</body>
</html>