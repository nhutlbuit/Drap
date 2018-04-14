<%@ page contentType="text/html;charset=UTF-8" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
Language : 
<a href="?language=en">English</a> | 
<a href="?language=vi_VN">VietNam</a>

<br>
<br>



<i>Current Locale : ${pageContext.response.locale}</i>

	<h2><spring:message code="ListOfStudent" text="default text" /></h2>	
	<table>
		<tr>
		
			<td><spring:message code="NAME" text="default text" /></td>
			<td><spring:message code="SEX" text="default text" /></td>
			<td><spring:message code="Address" text="default text" /></td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
			<td>${student.fullName}</td>
			<td>${student.sex}</td>
			<td>${student.address}</td>
			<td><a href="<c:url value='/edit-${student.id}-student' />"><spring:message code="Edit" text="default text" /></a></td>
			<td><a href="<c:url value='/delete-${student.id}-student' />"><spring:message code="delete" text="default text" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />"><spring:message code="AddNewStudent" text="default text" /></a>
</body>

</html>