<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>¡Cita Exitosa!</title>
	    <style>
	        body {
	            font-family: 'Verdana', sans-serif;
	            background-color: #e6f7ff;
	            color: #0066cc;
	            text-align: center;
	            padding: 50px;
	            margin: 0;
	        }
	
	        h1 {
	            color: #0066cc;
	        }
	
	        p {
	            font-size: 18px;
	            margin-top: 20px;
	        }
	
	        .success-message {
	            color: #0066cc;
	            font-weight: bold;
	        }
	
	        a {
	            color: #0099ff;
	            text-decoration: none;
	        }
	
	        button {
	            background-color: #0099ff;
	            color: #fff;
	            padding: 10px 20px;
	            font-size: 16px;
	            border: none;
	            cursor: pointer;
	        }
	
	        button:hover {
	            background-color: #0077cc;
	        }
	    </style>
	</head>
	
	
	<body>
	    <h1>¡Tu Cita Está Confirmada!</h1>
	    <p class="success-message">Gracias por agendar con nosotros. ¡Esperamos brindarte el mejor servicio!</p>
	    
	    <form action="Inicio.jsp" method="get">
	        <button type="submit">Volver a Inicio</button>
	    </form>
	</body>
</html>