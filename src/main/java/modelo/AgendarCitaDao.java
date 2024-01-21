package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conn;

public class AgendarCitaDao {
		public static boolean createCita(Cita cita) {
		Connection con = null;
	    PreparedStatement ps = null;
	
	    try {
	        con = Conn.getConnection();
	        String sql = "INSERT INTO Agenda (idMascota, rutDueno, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, cita.getIdMascota());
	        ps.setString(2, cita.getRutDueno());
	        ps.setString(3, cita.getNombreMascota());
	        ps.setString(4, cita.getHora());
	        ps.setString(5, cita.getFecha());
	
	        int filasAfectadas = ps.executeUpdate();
	        return filasAfectadas > 0;
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static List<Cita> getAllCitas() {
	    List<Cita> citas = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	
	    try {
	        con = Conn.getConnection();
	        String sql = "SELECT * FROM Agenda";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	
	        while (rs.next()) {
	            int idMascota = rs.getInt("idMascota");
	            String rutDueno = rs.getString("rutDueno");
	            String nombreMascota = rs.getString("nombreMascota");
	            String hora = rs.getString("hora");
	            String fecha = rs.getString("fecha");
	
	            Cita cita = new Cita(idMascota, rutDueno, nombreMascota, hora, fecha);
	            citas.add(cita);
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	    return citas;
	}
}
