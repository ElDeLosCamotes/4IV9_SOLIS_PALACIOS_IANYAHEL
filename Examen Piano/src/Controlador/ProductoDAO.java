package Controlador;

import Modelo.ConexionBD;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void agregar(Producto producto) throws SQLException, Exception {
        String sql = "INSERT INTO estudiante (nombre, edad, nivel, instrumento, id_profesor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getEdad());
            ps.setString(3, producto.getNivel());
            ps.setString(4, producto.getInstrumento());
            ps.setInt(5, producto.getIdProfesor());

            ps.executeUpdate();
        }
    }

    public Producto buscarPorId(int id) throws SQLException, Exception {
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return construirProductoDesdeResultSet(rs);
                }
            }
        }

        return null;
    }

    public List<Producto> listarTodos() throws SQLException, Exception {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(construirProductoDesdeResultSet(rs));
            }
        }

        return productos;
    }

    public void actualizar(Producto producto) throws SQLException, Exception {
        String sql = "UPDATE estudiante SET nombre = ?, edad = ?, nivel = ?, instrumento = ?, id_profesor = ? WHERE id_estudiante = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getEdad());
            ps.setString(3, producto.getNivel());
            ps.setString(4, producto.getInstrumento());
            ps.setInt(5, producto.getIdProfesor());
            ps.setInt(6, producto.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException, Exception {
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Producto construirProductoDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_estudiante");
        String nombre = rs.getString("nombre");
        int edad = rs.getInt("edad");
        String nivel = rs.getString("nivel");
        String instrumento = rs.getString("instrumento");
        int idProfesor = rs.getInt("id_profesor");

        return new Producto(id, nombre, edad, nivel, instrumento, idProfesor);
    }
}