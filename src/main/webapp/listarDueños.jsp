<%@ page import="java.util.List" %>
<%@ page import="modelo.Dueno" %>
<%@ page import="modelo.DuenoMascotaDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>Lista de Dueños</title>
	    <style>
	        body {
	            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	            background-color: #e6f7ff;
	            margin: 20px;
	            color: #333;
	        }
	
	        h1 {
	            color: #0066cc;
	        }
	
	        table {
	            width: 80%;
	            border-collapse: collapse;
	            margin-top: 20px;
	        }
	
	        th, td {
	            border: 1px solid #99c2ff;
	            padding: 12px;
	            text-align: left;
	        }
	
	        th {
	            background-color: #80bfff;
	        }
	
	        a {
	            display: inline-block;
	            padding: 10px;
	            margin-top: 20px;
	            background-color: #4CAF50;
	            color: white;
	            text-decoration: none;
	            border-radius: 5px;
	            transition: background-color 0.3s;
	        }
	
	        a:hover {
	            background-color: #45a049;
	        }
	
	        .no-records {
	            text-align: center;
	            font-style: italic;
	            color: #666;
	        }
	    </style>
	</head>
	
	
	<body>
	    <h1>Explora la Lista de Dueños</h1>
	
	    <table>
	        <tr>
	            <th>Rut</th>
	            <th>Nombre</th>
	            <th>Apellido</th>
	            <th>Dirección</th>
	            <th>Correo Electrónico</th>
	            <th>Teléfono</th>
	        </tr>
	        <%
	            List<Dueno> duenos = DuenoMascotaDao.getAllDuenos();
	
	            if (duenos != null && !duenos.isEmpty()) {
	                for (Dueno dueno : duenos) {
	        %>
	        <tr>
	            <td><%= dueno.getRut() %></td>
	            <td><%= dueno.getNombre() %></td>
	            <td><%= dueno.getApellido() %></td>
	            <td><%= dueno.getDireccion() %></td>
	            <td><%= dueno.getCorreo() %></td>
	            <td><%= dueno.getTelefono() %></td>
	        </tr>
	        <%
	                }
	            } else {
	        %>
	        <tr>
	            <td colspan="6" class="no-records">No hay dueños registrados. ¡Sé el primero en agregar uno!</td>
	        </tr>
	        <%
	            }
	        %>
	    </table>
	    <a href="Inicio.jsp">Regresar a la Página de Inicio</a>
	</body>
</html>