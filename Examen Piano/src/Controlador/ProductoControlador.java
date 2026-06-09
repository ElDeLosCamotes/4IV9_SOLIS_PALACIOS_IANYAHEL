package Controlador;

import Modelo.Producto;
import Vista.ProductoVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductoControlador {

    private ProductoDAO dao;
    private ProductoVista vista;

    public ProductoControlador(ProductoDAO dao, ProductoVista vista) {
        this.dao = dao;
        this.vista = vista;

        inicializarEventos();
        cargarTabla();
    }

    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());

        vista.getTablaProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarProductoSeleccionado();
            }
        });
    }

    private void agregar() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            if (producto == null) return;

            dao.agregar(producto);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Alumno agregado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al agregar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void actualizar() {
        try {
            Producto producto = construirProductoDesdeFormulario();
            if (producto == null) return;

            dao.actualizar(producto);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Alumno actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void eliminar() {
        String idStr = vista.getTxtId().getText().trim();

        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del alumno a eliminar.");
            return;
        }

        int id = Integer.parseInt(idStr);

        if (vista.confirmar("¿Está seguro de eliminar al alumno con ID " + id + "?")) {
            try {
                dao.eliminar(id);
                cargarTabla();
                vista.limpiarFormulario();
                vista.mostrarMensaje("Alumno eliminado.");
            } catch (SQLException ex) {
                vista.mostrarError("Error al eliminar: " + ex.getMessage());
            } catch (Exception ex) {
                vista.mostrarError("Error: " + ex.getMessage());
            }
        }
    }

    private void buscar() {
        String idStr = vista.getTxtId().getText().trim();

        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del alumno a buscar.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Producto producto = dao.buscarPorId(id);

            if (producto != null) {
                cargarProductoEnFormulario(producto);
                vista.mostrarMensaje("Alumno encontrado:\n" + producto.mostrarDetalle());
            } else {
                vista.mostrarError("No se encontró un alumno con ID " + id);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private Producto construirProductoDesdeFormulario() {
        if (vista.getTxtNombre().getText().trim().isEmpty()) {
            vista.mostrarError("El nombre del alumno es obligatorio.");
            return null;
        }

        int id = 0;

        if (!vista.getTxtId().getText().trim().isEmpty()) {
            id = Integer.parseInt(vista.getTxtId().getText().trim());
        }

        String nombre = vista.getTxtNombre().getText().trim();
        int edad = Integer.parseInt(vista.getTxtEdad().getText().trim());
        String nivel = vista.getTxtNivel().getText().trim();
        String instrumento = vista.getTxtInstrumento().getText().trim();
        int idProfesor = Integer.parseInt(vista.getTxtIdProfesor().getText().trim());

        return new Producto(id, nombre, edad, nivel, instrumento, idProfesor);
    }

    private void cargarTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);

        try {
            List<Producto> productos = dao.listarTodos();

            for (Producto p : productos) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getEdad(),
                    p.getNivel(),
                    p.getInstrumento(),
                    p.getIdProfesor()
                });
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar alumnos: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProductoSeleccionado() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila < 0) return;

        int id = (int) vista.getModeloTabla().getValueAt(fila, 0);

        try {
            Producto producto = dao.buscarPorId(id);
            if (producto != null) {
                cargarProductoEnFormulario(producto);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar alumno: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProductoEnFormulario(Producto producto) {
        vista.getTxtId().setText(String.valueOf(producto.getId()));
        vista.getTxtNombre().setText(producto.getNombre());
        vista.getTxtEdad().setText(String.valueOf(producto.getEdad()));
        vista.getTxtNivel().setText(producto.getNivel());
        vista.getTxtInstrumento().setText(producto.getInstrumento());
        vista.getTxtIdProfesor().setText(String.valueOf(producto.getIdProfesor()));
    }
}