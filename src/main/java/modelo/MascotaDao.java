package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conn;

public class MascotaDao {
	public boolean createMascota(Mascota mascota) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO Mascota (RutDueno, tipoMascota, Edad, nombreMascota) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, mascota.getRutDueno());
            ps.setString(2, mascota.getTipoMascota());
            ps.setInt(3, mascota.getEdad());
            ps.setString(4, mascota.getNombreMascota());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Mascota readMascota(int idMascota) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Mascota WHERE idMascota = ?")) {

            ps.setInt(1, idMascota);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Mascota(
                            rs.getInt("idMascota"),
                            rs.getString("RutDueno"),
                            rs.getString("tipoMascota"),
                            rs.getInt("Edad"),
                            rs.getString("nombreMascota")
                    );
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateMascota(Mascota mascota) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE Mascota SET RutDueno = ?, tipoMascota = ?, Edad = ?, nombreMascota = ? WHERE idMascota = ?")) {

            ps.setString(1, mascota.getRutDueno());
            ps.setString(2, mascota.getTipoMascota());
            ps.setInt(3, mascota.getEdad());
            ps.setString(4, mascota.getNombreMascota());
            ps.setInt(5, mascota.getIdMascota());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMascota(int idMascota) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Mascota WHERE idMascota = ?")) {

            ps.setInt(1, idMascota);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public static List<Mascota> getAllMascotas() {
        List<Mascota> mascotas = new ArrayList<>();
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Mascota");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mascota mascota = new Mascota(
                        rs.getInt("idMascota"),
                        rs.getString("RutDueno"),
                        rs.getString("tipoMascota"),
                        rs.getInt("Edad"),
                        rs.getString("nombreMascota")
                );
                mascotas.add(mascota);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mascotas;
    }

    public Mascota getMascotaByRutDueno(String rutDueno) {
        try (Connection con = Conn.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Mascota WHERE RutDueno = ?")) {

            ps.setString(1, rutDueno);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Mascota(
                            rs.getInt("idMascota"),
                            rs.getString("RutDueno"),
                            rs.getString("tipoMascota"),
                            rs.getInt("Edad"),
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