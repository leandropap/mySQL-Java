<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.leandropap.sourcePackage.MensajeDao"%>
<%@page import="com.leandropap.sourcePackage.Mensaje"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit message - JSP</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="flex flex-col items-center justify-center"> 
		<div class="border border-gray-500 rounded-md w-1/2 py-2 px-4 m-4">
			<p class="mx-2">
				<b> Edit existing message</b>
			</p>
			<form action="edit.jsp" method="POST">
				<div class="flex flex-col m-2">
					<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
					<label>Edit message</label>
					<textarea rows="3"
						class="py-1 px-2 w-full border border-gray-500 rounded-md "
						placeholder="Please type your message here" name="message"><%=request.getParameter("msg")%>
						</textarea>
				</div>
				<div class="flex flex-col m-2">
					<label>Who is sending this message?</label>
					<textarea rows="1"
						class="py-1 px-2 w-full border border-gray-500 rounded-md"
						placeholder="Type your name here" name="from"><%=request.getParameter("from")%>
						</textarea>
				</div>
				<div class="flex flex-col m-2">
					<label>Who are you reaching out?</label>
					<textarea rows="1"
						class="py-1 px-2 w-full border border-gray-500 rounded-md"
						placeholder="Type receiver's name here" name="to"><%=request.getParameter("to")%>
						</textarea>
				</div>
				<div class="flex flex-row justify-end mx-2">
					<a href="index.jsp" type="submit"
					 	class="bg-gray-300 border border-black rounded-md px-2 py-1 font-medium"> Home </a>
					<button type="submit" name="save"
						class="bg-blue-500 border border-black rounded-md px-2 py-1 font-medium ml-2"
						onclick="history.back()">Save</button>
				</div>
			</form>
		</div>
	</div>
	<%
		MensajeDao mensajeDao = new MensajeDao();
			
		String id = request.getParameter("id");
			
		if(request.getParameter("save") != null) {
			Mensaje mensaje = new Mensaje(
				Integer.parseInt(id.trim()),
				request.getParameter("message"),
				request.getParameter("from"),
				request.getParameter("to")
				);
		mensajeDao.update(mensaje);
			
		response.sendRedirect("index.jsp");
		}
	%>
</body>
</html>