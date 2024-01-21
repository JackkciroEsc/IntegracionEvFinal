package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conn;

public class DuenoMascotaDao {
	public boolean createDueno(Dueno dueno) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Dueno (Rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, dueno.getRut());
            ps.setString(2, dueno.getNombre());
            ps.setString(3, dueno.getApellido());
            ps.setString(4, dueno.getDireccion());
            ps.setString(5, dueno.getCorreo());
            ps.setString(6, dueno.getTelefono());
            ps.setString(7, dueno.getNombreMascota());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Dueno> getAllDuenos() {
        List<Dueno> duenos = new ArrayList<>();
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Dueno");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Dueno dueno = new Dueno(
                        rs.getString("Rut"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("nombreMascota")
                );
                duenos.add(dueno);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return duenos;
    }

    public Dueno readDueno(String rut) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Dueno WHERE Rut = ?")) {

            ps.setString(1, rut);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Dueno(
                            rs.getString("Rut"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("direccion"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("nombreMascota")
                    );
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}