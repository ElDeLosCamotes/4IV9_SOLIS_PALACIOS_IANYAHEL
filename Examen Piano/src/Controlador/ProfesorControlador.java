package Controlador;

import Modelo.Profesor;
import Vista.ProductoVista;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProfesorControlador {

    private ProfesorDAO dao;
    private ProductoVista vista;

    public ProfesorControlador(ProfesorDAO dao, ProductoVista vista) {
        this.dao = dao;
        this.vista = vista;
        inicializarEventos();
        cargarTablaProfesores();
    }

    private void inicializarEventos() {
        vista.getBtnProfAgregar().addActionListener(e -> agregar());
        vista.getBtnProfActualizar().addActionListener(e -> actualizar());
        vista.getBtnProfEliminar().addActionListener(e -> eliminar());
        vista.getBtnProfBuscar().addActionListener(e -> buscar());
        vista.getBtnProfLimpiar().addActionListener(e -> vista.limpiarFormularioProfesores());

        vista.getTablaProfesores().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarProfesorSeleccionado();
            }
        });
    }

    private void agregar() {
        try {
            Profesor profesor = construirProfesorDesdeFormulario();
            if (profesor == null) return;

            dao.agregar(profesor);
            cargarTablaProfesores();
            vista.limpiarFormularioProfesores();
            vista.mostrarMensaje("Profesor agregado exitosamente.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al agregar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void actualizar() {
        try {
            Profesor profesor = construirProfesorDesdeFormulario();
            if (profesor == null) return;

            dao.actualizar(profesor);
            cargarTablaProfesores();
            vista.limpiarFormularioProfesores();
            vista.mostrarMensaje("Profesor actualizado exitosamente.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void eliminar() {
        String idStr = vista.getTxtProfId().getText().trim();
        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del profesor a eliminar.");
            return;
        }

        int id = Integer.parseInt(idStr);
        if (vista.confirmar("¿Está seguro de eliminar al profesor con ID " + id + "?")) {
            try {
                dao.eliminar(id);
                cargarTablaProfesores();
                vista.limpiarFormularioProfesores();
                vista.mostrarMensaje("Profesor eliminado.");
            } catch (SQLException ex) {
                vista.mostrarError("Error al eliminar: " + ex.getMessage());
            } catch (Exception ex) {
                vista.mostrarError("Error: " + ex.getMessage());
            }
        }
    }

    private void buscar() {
        String idStr = vista.getTxtProfId().getText().trim();
        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del profesor a buscar.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Profesor profesor = dao.buscarPorId(id);

            if (profesor != null) {
                cargarProfesorEnFormulario(profesor);
                vista.mostrarMensaje("Profesor encontrado:\n" + profesor.mostrarDetalle());
            } else {
                vista.mostrarError("No se encontró un profesor con ID " + id);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private Profesor construirProfesorDesdeFormulario() {
        if (vista.getTxtProfNombre().getText().trim().isEmpty()) {
            vista.mostrarError("El nombre del profesor es obligatorio.");
            return null;
        }

        int id = 0;
        if (!vista.getTxtProfId().getText().trim().isEmpty()) {
            id = Integer.parseInt(vista.getTxtProfId().getText().trim());
        }

        String nombre = vista.getTxtProfNombre().getText().trim();
        String especialidad = vista.getTxtProfEspecialidad().getText().trim();
        String telefono = vista.getTxtProfTelefono().getText().trim();
        String email = vista.getTxtProfEmail().getText().trim();

        return new Profesor(id, nombre, especialidad, telefono, email);
    }

    private void cargarTablaProfesores() {
        DefaultTableModel modelo = vista.getModeloTablaProfesores();
        modelo.setRowCount(0);

        try {
            List<Profesor> profesores = dao.listarTodos();
            for (Profesor p : profesores) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getEspecialidad(),
                    p.getTelefono(),
                    p.getEmail()
                });
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar profesores: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProfesorSeleccionado() {
        int fila = vista.getTablaProfesores().getSelectedRow();
        if (fila < 0) return;

        int id = (int) vista.getModeloTablaProfesores().getValueAt(fila, 0);

        try {
            Profesor profesor = dao.buscarPorId(id);
            if (profesor != null) {
                cargarProfesorEnFormulario(profesor);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al cargar profesor: " + ex.getMessage());
        } catch (Exception ex) {
            vista.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void cargarProfesorEnFormulario(Profesor profesor) {
        vista.getTxtProfId().setText(String.valueOf(profesor.getId()));
        vista.getTxtProfNombre().setText(profesor.getNombre());
        vista.getTxtProfEspecialidad().setText(profesor.getEspecialidad());
        vista.getTxtProfTelefono().setText(profesor.getTelefono());
        vista.getTxtProfEmail().setText(profesor.getEmail());
    }
}
