package dao;

import modelo.Aprendiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AprendizDAO {

    private Connection conexion;

    public AprendizDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Aprendiz> listarAprendices() {
        List<Aprendiz> aprendices = new ArrayList<>();
        String sql = "SELECT * FROM Aprendices";
        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aprendiz aprendiz = new Aprendiz(
                        rs.getInt("id_aprendiz"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("documento_identidad"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );
                aprendices.add(aprendiz);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar aprendices: " + e.getMessage());
        }
        return aprendices;
    }

    public boolean agregarAprendiz(Aprendiz aprendiz) {
        String sql = "INSERT INTO Aprendices (nombre, apellido, documento_identidad, correo, telefono) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, aprendiz.getNombre());
            stmt.setString(2, aprendiz.getApellido());
            stmt.setString(3, aprendiz.getDocumentoIdentidad());
            stmt.setString(4, aprendiz.getCorreo());
            stmt.setString(5, aprendiz.getTelefono());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar aprendiz: " + e.getMessage());
            return false;
        }
    }
}
