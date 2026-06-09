package Controlador;

import Modelo.ConexionBD;
import Modelo.Profesor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    public void agregar(Profesor profesor) throws SQLException, Exception {
        String sql = "INSERT INTO profesor (nombre, especialidad, telefono, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getEspecialidad());
            ps.setString(3, profesor.getTelefono());
            ps.setString(4, profesor.getEmail());

            ps.executeUpdate();
        }
    }

    public Profesor buscarPorId(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM profesor WHERE id_profesor = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirProfesorDesdeResultSet(rs);
                }
            }
        }

        return null;
    }

    public List<Profesor> listarTodos() throws SQLException, Exception {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT * FROM profesor";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                profesores.add(construirProfesorDesdeResultSet(rs));
            }
        }

        return profesores;
    }

    public void actualizar(Profesor profesor) throws SQLException, Exception {
        String sql = "UPDATE profesor SET nombre = ?, especialidad = ?, telefono = ?, email = ? WHERE id_profesor = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getEspecialidad());
            ps.setString(3, profesor.getTelefono());
            ps.setString(4, profesor.getEmail());
            ps.setInt(5, profesor.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException, Exception {
        String sql = "DELETE FROM profesor WHERE id_profesor = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Profesor construirProfesorDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_profesor");
        String nombre = rs.getString("nombre");
        String especialidad = rs.getString("especialidad");
        String telefono = rs.getString("telefono");
        String email = rs.getString("email");

        return new Profesor(id, nombre, especialidad, telefono, email);
    }
}
