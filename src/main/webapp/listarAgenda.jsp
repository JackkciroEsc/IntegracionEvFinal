<%@ page import="java.util.List" %>
<%@ page import="modelo.AgendarCitaDao" %>
<%@ page import="modelo.Cita" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Agendas Programadas</title>
	    <style>
	        body {
	            font-family: 'Arial', sans-serif;
	            background-color: #f8f9fa;
	            color: #343a40;
	            text-align: center;
	            padding: 50px;
	            margin: 0;
	        }
	
	        h1 {
	            color: #007bff;
	        }
	
	        table {
	            width: 80%;
	            margin: 20px auto;
	            border-collapse: collapse;
	        }
	
	        th, td {
	            border: 1px solid #dee2e6;
	            padding: 10px;
	            text-align: left;
	        }
	
	        th {
	            background-color: #007bff;
	            color: #fff;
	        }
	
	        tr:nth-child(even) {
	            background-color: #f2f2f2;
	        }
	
	        p {
	            font-size: 18px;
	            color: #666;
	        }
	
	        button {
	            background-color: #007bff;
	            color: #fff;
	            padding: 10px 20px;
	            border: none;
	            border-radius: 5px;
	            font-weight: bold;
	            cursor: pointer;
	            transition: background-color 0.3s;
	        }
	
	        button:hover {
	            background-color: #0056b3;
	        }
	    </style>
	</head>
	
	
	<body>
	    <h1>¡Agendas Programadas!</h1>
	    <% 
	        List<Cita> citas = AgendarCitaDao.getAllCitas();
	        if (citas != null && !citas.isEmpty()) {
	    %>
	    <table>
	        <tr>
	            <th>ID Mascota</th>
	            <th>Rut Dueño</th>
	            <th>Nombre Mascota</th>
	            <th>Hora</th>
	            <th>Fecha</th>
	        </tr>
	        <% for(Cita cita : citas) { %>
	        <tr>
	            <td><%= cita.getIdMascota() %></td>
	            <td><%= cita.getRutDueno() %></td>
	            <td><%= cita.getNombreMascota() %></td>
	            <td><%= cita.getHora() %></td>
	            <td><%= cita.getFecha() %></td>
	        </tr>
	        <% } %>
	    </table>
	    <% } else { %>
	        <p>No hay citas programadas. ¡Agenda una ahora!</p>
	    <% } %>
	    
	    <form action="Inicio.jsp" method="get">
	        <button type="submit">Volver a Inicio</button>
	    </form>
	</body>
</html>