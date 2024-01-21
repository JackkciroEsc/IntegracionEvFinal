<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agendar Cita</title>
    
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
	        
	        p {
	        	color: red;
	        }
	    </style>

    
</head>
<body>
    <h2>Agendar Cita</h2>

    <% if (request.getAttribute("error") != null) { %>
    	<p><%= request.getAttribute("error") %></p>
	<% } %>


    <form action="CitaServlet" method="post">
        <div>
            <label for="idMascota">ID de la Mascota:</label><br>
            <input type="number" id="idMascota" name="idMascota" required>
        </div>
        <div>
            <label for="rutDueno">Rut del Dueño:</label><br>
			<input type="text" id="rutDueno" name="rutDueno" required>
        </div>
        <div>
            <label for="nombreMascota">Nombre de la Mascota:</label><br>
            <input type="text" id="nombreMascota" name="nombreMascota" required>
        </div>
        <div>
            <label for="hora">Hora:</label><br>
            <input type="time" id="hora" name="hora" required>
        </div>
        <div>
            <label for="fecha">Fecha:</label><br>
            <input type="date" id="fecha" name="fecha" required>
        </div>
        <div><br>
            <button type="submit" name="submit">Agendar Cita</button>
        </div>
    </form><br>
    <a href="Inicio.jsp">Volver a la Página de Inicio</a>
</body>
</html>