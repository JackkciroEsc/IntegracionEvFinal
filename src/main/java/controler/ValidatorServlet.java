package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.LoginDao;

/**
 * Servlet implementation class ValidatorServlet
 */
public class ValidatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombreUsuario = request.getParameter("nombreUsuario");
	    String password = request.getParameter("password");
	    String mensaje = "";

	    try {
	        if (nombreUsuario.isEmpty() || password.isEmpty()) {
	            // Credenciales vacías
	            mensaje = "Ambos campos son obligatorios. Por favor, completa la información.";
	        } else if (LoginDao.validarUsuario(nombreUsuario, password)) {
	            // Autenticación exitosa
	            HttpSession session = request.getSession();
	            session.setAttribute("nombreUsuario", nombreUsuario);

	            System.out.println("Autenticación exitosa. Nombre de usuario: " + nombreUsuario);
	            mensaje = "Acceso autorizado";
	        } else {
	            // Autenticación fallida
	            System.out.println("Autenticación fallida para el nombre de usuario: " + nombreUsuario);
	            mensaje = "Credenciales invalidas, intente nuevamente";

	            // Puedes eliminar esta línea para que no se establezca un atributo de error en la request
	            // request.setAttribute("Error", mensaje);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        mensaje = "Error interno al procesar la solicitud";
	    }

	    // Enviar el mensaje al JSP, ya sea de éxito o de error
	    request.setAttribute("mensaje", mensaje);

	    // Redirigir siempre a la página "Inicio.jsp"
	    RequestDispatcher despachador = request.getRequestDispatcher("Inicio.jsp");
	    despachador.forward(request, response);
	}
}
