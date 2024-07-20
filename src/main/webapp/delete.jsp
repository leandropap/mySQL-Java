<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.leandropap.sourcePackage.Mensaje"%>
<%@page import="com.leandropap.sourcePackage.MensajeDao" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Delete message</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<%
		String id = request.getParameter("id");
		Mensaje mensaje = new Mensaje(Integer.valueOf(id));
		MensajeDao mensajeDao = new MensajeDao();
		mensajeDao.delete(mensaje);
		response.sendRedirect("index.jsp");
	%>

</body>
</html>