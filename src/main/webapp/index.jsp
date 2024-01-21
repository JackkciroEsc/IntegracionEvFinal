<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Iniciar Sesión</title>
	    <style>
	        body {
	            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	            background-color: #f4f4f4;
	            color: #333;
	            text-align: center;
	            padding: 50px;
	            margin: 0;
	        }
	
	        h2 {
	            color: #007bff;
	        }
	
	        form {
	            max-width: 300px;
	            margin: 0 auto;
	        }
	
	        label {
	            display: block;
	            margin-top: 15px;
	            color: #007bff;
	        }
	
	        input {
	            width: 100%;
	            padding: 10px;
	            margin-top: 5px;
	            margin-bottom: 15px;
	            box-sizing: border-box;
	        }
	
	        button {
	            background-color: #007bff;
	            color: #fff;
	            padding: 10px 20px;
	            font-size: 16px;
	            border: none;
	            cursor: pointer;
	        }
	
	        button:hover {
	            background-color: #0056b3;
	        }
	
	        p.error-message {
	            color: #dc3545;
	            margin-top: 15px;
	        }
	    </style>
	</head>
	
	
	<body>
	    <h2>Iniciar Sesión</h2>
	    <% if(request.getAttribute("error") != null) { %>
	        <p class="error-message"><%= request.getAttribute("error") %></p>
	    <% } %>
	    <form action="ValidatorServlet" method="post">
	        <label for="nombreUsuario">Nombre de Usuario:</label>
	        <input type="text" id="usuario" name="nombreUsuario">
	
	        <label for="password">Contraseña:</label>
	        <input type="password" id="password" name="password">
	
	        <button type="submit" name="submit">Iniciar Sesión</button>
	    </form>
	</body>
</html>