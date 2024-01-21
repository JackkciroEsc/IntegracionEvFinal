import org.junit.Test;

import util.Conn;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;


public class ConnTest {

	@Test
    public void pruebaConexionBaseDeDatos() throws ClassNotFoundException {
        Connection conexion = null;
        try {
            conexion = Conn.getConnection();
            assertNotNull("La conexión no debería ser nula", conexion);
            assertTrue("La conexión debe ser válida", conexion.isValid(1));
        } catch (SQLException e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}