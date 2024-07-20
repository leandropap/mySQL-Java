<%@page import="com.leandropap.sourcePackage.MensajeDao" %>
<%@page import="com.leandropap.sourcePackage.Mensaje" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>MessageApp - JSP</title>
	<script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
	<div class="flex flex-col items-center justify-center">
		<div class="border border-gray-500 rounded-md w-1/2 py-2 px-4 m-4">
			<p class="mx-2">
				<b> Create new message</b>
			</p>
			<form action="index.jsp" method="POST">
				<div class="flex flex-col m-2">
					<label>Enter your message</label>
					<textarea rows="3"
						class="py-1 px-2 w-full border border-gray-500 rounded-md "
						placeholder="Please type your message here" name="message"></textarea>
				</div>
				<div class="flex flex-col m-2">
					<label>Who is sending this message?</label>
					<textarea rows="1"
						class="py-1 px-2 w-full border border-gray-500 rounded-md"
						placeholder="Type your name here" name="from"></textarea>
				</div>
				<div class="flex flex-col m-2">
					<label>Who are you reaching out?</label>
					<textarea rows="1"
						class="py-1 px-2 w-full border border-gray-500 rounded-md"
						placeholder="Type receiver's name here" name="to"></textarea>
				</div>
				<div class="flex flex-row justify-end mx-2">
					<button type="submit" name="send"
						class="bg-blue-500 border border-black rounded-md px-2 py-1 font-medium">Send</button>
				</div>
			</form>
		</div>
		<%
			MensajeDao mensajeDao = new MensajeDao();
			
			if(request.getParameter("send") != null) {
				Mensaje mensaje = new Mensaje(
						request.getParameter("message"),
						request.getParameter("from"),
						request.getParameter("to")
						);
			mensajeDao.insert(mensaje);
			}
		%>
		
		
		<div class="border border-gray-500 rounded-md w-1/2 py-2 px-4">
			<p class="mx-2 mb-2">
				<b> All messages</b>
			</p>
			
			<%	
				List <Mensaje> mensajes = mensajeDao.select();
				Collections.reverse(mensajes);
				
				for(Mensaje mensaje : mensajes) {
			%>
			<div class="mx-2 py-1 px-2  w-full border border-gray-500 rounded-md">
				<div>
					<p><%=mensaje.getMensaje()%></p>
					<p> <b>From: </b> <%=mensaje.getAutor()%> </p>
					<p> <b>To: </b> <%=mensaje.getDestinatario()%> </p>
					<hr />
					<cite><%=mensaje.getFecha()%></cite>
				</div>
				<a href="edit.jsp?id=<%=mensaje.getId()%>
					&&msg=<%=mensaje.getMensaje()%>
					&&from=<%=mensaje.getAutor()%>
					&&to=<%=mensaje.getDestinatario()%>"
					class="text-blue-500 hover:font-medium">
					Editar</a>
				<a href="delete.jsp?id=<%=mensaje.getId()%>"
					class="text-blue-500 hover:font-medium">
					Eliminar</a>
			</div>
		<%}%>
		
		</div>
	</div>
</body>
</html>