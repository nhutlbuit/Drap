<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
	message : ${success}
	<br/>
	<br/>
<%-- 	<a href="<c:url value='/score-${studentid}-student' />">View your score</a> --%>
	<form action="/spring-mvc-hibernate/${link}" method="GET">
		<table>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${status}">
							<input type="submit" value="View list student"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="View your score"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>