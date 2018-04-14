<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

	<h2><spring:message code="RegistrationForm" text="default text" /></h2>
 
	<form:form method="POST" modelAttribute="student">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="fullName"><spring:message code="NAME" text="default text" />: </label> </td>
				<td><form:input path="fullName" id="fullName"/></td>
				<td><form:errors path="fullName" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="sex"><spring:message code="SEX" text="default text" />: </label> </td>
				<td><form:input path="sex" id="sex"/></td>
				<td><form:errors path="sex" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="address"><spring:message code="Address" text="default text" />: </label> </td>
				<td><form:input path="address" id="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="<spring:message code="Register" text="default text" />"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	<spring:message code="Gobakcto" text="default text" /> <a href="<c:url value='/list' />"><spring:message code="ListofAllStudent" text="default text" /></a>
</body>
</html>