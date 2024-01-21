package controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Dueno;
import modelo.DuenoMascotaDao;
import modelo.Mascota;
import modelo.MascotaDao;
import util.Conn;

/**
 * Servlet implementation class CitaServlet
 */
public class CitaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int idMascota;
        try {
            idMascota = Integer.parseInt(request.getParameter("idMascota"));
            System.out.println("ID de Mascota: " + idMascota);
        } catch (NumberFormatException e) {
            mostrarError(request, response, "El ID de la mascota debe ser un número válido.");
            return;
        }

        String rutDueno = request.getParameter("rutDueno");
        String nombreMascota = request.getParameter("nombreMascota");
        String hora = request.getParameter("hora");
        String fecha = request.getParameter("fecha");
        
        System.out.println("[MENSAJE] ID de Mascota: " + idMascota);
        System.out.println("[MENSAJE] Rut del Dueño: " + rutDueno);
        System.out.println("[MENSAJE] Nombre de la Mascota: " + nombreMascota);
        System.out.println("[MENSAJE] Hora: " + hora);
        System.out.println("[MENSAJE] Fecha: " + fecha);


        // Validar que ningún campo esté vacío o sea nulo
        if (rutDueno == null || rutDueno.trim().isEmpty() || nombreMascota == null || nombreMascota.trim().isEmpty()
                || hora == null || hora.trim().isEmpty() || fecha == null || fecha.trim().isEmpty()) {
            mostrarError(request, response, "Todos los campos son obligatorios.");
            return;
        }

        // Verificar si la mascota con el ID existe
        MascotaDao mascotaDao = new MascotaDao();
        Mascota mascota = mascotaDao.readMascota(idMascota);
        if (mascota == null) {
            mostrarError(request, response, "La mascota con el ID proporcionado no existe.");
            return;
        }

        System.out.println("Mascota encontrada: " + mascota.getNombreMascota());

        // Verificar si el dueño con el Rut existe
        DuenoMascotaDao duenoMascotaDao = new DuenoMascotaDao();
        Dueno dueno = duenoMascotaDao.readDueno(rutDueno);
        if (dueno == null) {
            mostrarError(request, response, "El dueño con el Rut proporcionado no existe.");
            return;
        }

        System.out.println("Dueño encontrado: " + dueno.getNombre());

        // Agregar la cita
        boolean resultado = agregarCita(idMascota, rutDueno, nombreMascota, hora, fecha);

        if (resultado) {
            // Agrega un mensaje de éxito
            System.out.println("Cita agendada exitosamente");
            request.setAttribute("mensaje", "Cita agendada exitosamente");
            // Redirige a la página de éxito
            request.getRequestDispatcher("Exito.jsp").forward(request, response);
        } else {
            // Agrega un mensaje de error
            System.out.println("Error al agendar la cita");
            request.setAttribute("mensaje", "Error al agendar la cita");
            // Redirige a la página de error
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // Método para mostrar un mensaje de error en la vista y mantenerla
    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        System.out.println("Error: " + mensaje);
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    private boolean agregarCita(int idMascota, String rutDueno, String nombreMascota, String hora, String fecha) {
        String query = "INSERT INTO Agenda (idMascota, rutDueno, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Conn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idMascota);
            preparedStatement.setString(2, rutDueno);
            preparedStatement.setString(3, nombreMascota);
            preparedStatement.setString(4, hora);
            preparedStatement.setString(5, fecha);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cita agendada exitosamente");
                return true;
            } else {
                System.err.println("Error al agendar la cita. No se pudieron insertar filas.");
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Excepción al intentar agregar cita: " + e.getMessage());
            return false;
        }
    }

}