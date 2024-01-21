<%@ page import="modelo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>¡Bienvenido!</title>
	    <style>
	        body {
	            font-family: 'Arial', sans-serif;
	            background-color: #f0f0f0;
	            color: #333;
	            text-align: center;
	            padding: 50px;
	            margin: 0;
	        }
	
	        h1 {
	            color: #007bff;
	        }
	
	        p {
	            font-size: 18px;
	            color: #666;
	        }
	
	        ul {
	            list-style-type: none;
	            padding: 0;
	            margin-top: 30px;
	        }
	
	        li {
	            display: inline-block;
	            margin-right: 20px;
	        }
	
	        a {
	            text-decoration: none;
	            background-color: #007bff;
	            color: #fff;
	            padding: 10px 20px;
	            border-radius: 5px;
	            font-weight: bold;
	            transition: background-color 0.3s;
	        }
	
	        a:hover {
	            background-color: #0056b3;
	        }
	    </style>
	</head>
	
	<body>
	<%
	    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
	    String mensaje = (String) request.getAttribute("mensaje");
	
	    if (nombreUsuario != null) {
	%>
	        <h1>Bienvenido, <%= nombreUsuario %></h1>
	        
	        <p><%= mensaje %></p>
	        
	        <h3 style="color: green">¡Gracias por ser parte de nuestra plataforma!</h3>
	        <ul>
	            <li><a href="listarDueños.jsp">Ver Dueños</a></li>
	            <li><a href="register.jsp">¡Agenda una Cita!</a></li>
	            <li><a href="listarAgenda.jsp">Ver Citas Agendadas</a></li>
	        </ul>
	<%
	    } else {
	%>
	        <h3 style="color: red"><%= mensaje %></h3>
	        
	        <p><%= mensaje %></p>
	        
	        <a href="index.jsp">Iniciar sesión</a>
	<%
	    }
	%>
	</body>
</html>