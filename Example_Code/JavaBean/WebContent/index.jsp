<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title> get and set properties Example</title>
</head>
<body>
<jsp:useBean id="students" class="test.student.bean.StudentBean">
<jsp:setProperty name="students" property="firstName" value="Luong"/>
<jsp:setProperty name="students" property="lastName" value="Thien"/>
<jsp:setProperty name="students" property="age" value="22"/>
</jsp:useBean>
</body>

<p>
Student First Name:
<jsp:getProperty name="students" property="firstName"/>
</p>

<p>
Student Last name:
<jsp:getProperty name="students" property="lastName"/>
</p>
<p>
Student Age:
<jsp:getProperty name="students" property="age"/>
</p>
</html>
