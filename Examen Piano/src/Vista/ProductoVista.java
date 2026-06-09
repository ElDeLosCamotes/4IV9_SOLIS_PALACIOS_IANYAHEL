package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProductoVista extends JFrame {

    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtNivel;
    private JTextField txtInstrumento;
    private JTextField txtIdProfesor;

    private JTable tablaProfesores;
    private DefaultTableModel modeloTablaProfesores;
    private JTextField txtProfId;
    private JTextField txtProfNombre;
    private JTextField txtProfEspecialidad;
    private JTextField txtProfTelefono;
    private JTextField txtProfEmail;

    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JButton btnProfAgregar;
    private JButton btnProfActualizar;
    private JButton btnProfEliminar;
    private JButton btnProfBuscar;
    private JButton btnProfLimpiar;

    public ProductoVista() {
        setTitle("Escuela de Piano - Registro de Alumnos");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(20, 20, 20));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(35, 35, 35));

        JLabel lblTitulo = new JLabel("Gestión de Alumnos y Profesores - Escuela de Piano");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(242, 236, 217));

        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBackground(new Color(35, 35, 35));
        pestañas.setForeground(new Color(242, 236, 217));

        pestañas.addTab("Alumnos", crearPanelAlumnos());
        pestañas.addTab("Profesores", crearPanelProfesores());

        add(pestañas, BorderLayout.CENTER);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(2, 6, 10, 10));
        panel.setBackground(new Color(20, 20, 20));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(212, 175, 55)),
            "Datos del Alumno",
            0,
            0,
            new Font("Arial", Font.BOLD, 14),
            new Color(242, 236, 217)
        ));

        panel.add(crearEtiquetaCampo("ID:"));
        txtId = crearCampoTexto();
        panel.add(txtId);

        panel.add(crearEtiquetaCampo("Nombre:"));
        txtNombre = crearCampoTexto();
        panel.add(txtNombre);

        panel.add(crearEtiquetaCampo("Edad:"));
        txtEdad = crearCampoTexto();
        panel.add(txtEdad);

        panel.add(crearEtiquetaCampo("Nivel:"));
        txtNivel = crearCampoTexto();
        panel.add(txtNivel);

        panel.add(crearEtiquetaCampo("Instrumento:"));
        txtInstrumento = crearCampoTexto();
        panel.add(txtInstrumento);

        panel.add(crearEtiquetaCampo("ID Profesor:"));
        txtIdProfesor = crearCampoTexto();
        panel.add(txtIdProfesor);

        return panel;
    }

    private JPanel crearPanelAlumnos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(20, 20, 20));

        modeloTabla = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Edad", "Nivel", "Instrumento", "ID Profesor"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaProductos = new JTable(modeloTabla);
        configurarTabla(tablaProductos);

        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.getViewport().setBackground(new Color(20, 20, 20));
        scrollTabla.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));

        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        panelInferior.setBackground(new Color(20, 20, 20));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInferior.add(crearPanelFormulario(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotones(), BorderLayout.SOUTH);

        panel.add(scrollTabla, BorderLayout.CENTER);
        panel.add(panelInferior, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearPanelProfesores() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(20, 20, 20));

        modeloTablaProfesores = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Especialidad", "Teléfono", "Email"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaProfesores = new JTable(modeloTablaProfesores);
        configurarTabla(tablaProfesores);

        JScrollPane scrollProfesores = new JScrollPane(tablaProfesores);
        scrollProfesores.getViewport().setBackground(new Color(20, 20, 20));
        scrollProfesores.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));

        JPanel panelInferior = new JPanel(new BorderLayout(10, 10));
        panelInferior.setBackground(new Color(20, 20, 20));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelInferior.add(crearPanelFormularioProfesor(), BorderLayout.CENTER);
        panelInferior.add(crearPanelBotonesProfesor(), BorderLayout.SOUTH);

        panel.add(scrollProfesores, BorderLayout.CENTER);
        panel.add(panelInferior, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearPanelFormularioProfesor() {
        JPanel panel = new JPanel(new GridLayout(2, 5, 10, 10));
        panel.setBackground(new Color(20, 20, 20));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(212, 175, 55)),
            "Datos del Profesor",
            0,
            0,
            new Font("Arial", Font.BOLD, 14),
            new Color(242, 236, 217)
        ));

        panel.add(crearEtiquetaCampo("ID:"));
        txtProfId = crearCampoTexto();
        panel.add(txtProfId);

        panel.add(crearEtiquetaCampo("Nombre:"));
        txtProfNombre = crearCampoTexto();
        panel.add(txtProfNombre);

        panel.add(crearEtiquetaCampo("Especialidad:"));
        txtProfEspecialidad = crearCampoTexto();
        panel.add(txtProfEspecialidad);

        panel.add(crearEtiquetaCampo("Teléfono:"));
        txtProfTelefono = crearCampoTexto();
        panel.add(txtProfTelefono);

        panel.add(crearEtiquetaCampo("Email:"));
        txtProfEmail = crearCampoTexto();
        panel.add(txtProfEmail);

        return panel;
    }

    private JPanel crearPanelBotonesProfesor() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBackground(new Color(20, 20, 20));

        btnProfAgregar = crearBotonPrincipal("Agregar");
        btnProfActualizar = crearBotonPrincipal("Actualizar");
        btnProfEliminar = crearBotonSecundario("Eliminar");
        btnProfBuscar = crearBotonPrincipal("Buscar por ID");
        btnProfLimpiar = crearBotonSecundario("Limpiar");

        panel.add(btnProfAgregar);
        panel.add(btnProfActualizar);
        panel.add(btnProfEliminar);
        panel.add(btnProfBuscar);
        panel.add(btnProfLimpiar);

        return panel;
    }

    private void configurarTabla(JTable tabla) {
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setRowHeight(26);
        tabla.setBackground(new Color(35, 35, 35));
        tabla.setForeground(new Color(242, 236, 217));
        tabla.setGridColor(new Color(80, 80, 80));
        tabla.setSelectionBackground(new Color(212, 175, 55));
        tabla.setSelectionForeground(new Color(20, 20, 20));
        tabla.setShowGrid(true);

        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setBackground(new Color(212, 175, 55));
        encabezado.setForeground(new Color(20, 20, 20));
        encabezado.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private JLabel crearEtiquetaCampo(String texto) {
        JLabel label = new JLabel(texto);
        label.setForeground(new Color(242, 236, 217));
        label.setFont(new Font("Arial", Font.BOLD, 12));
        return label;
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setBackground(new Color(242, 236, 217));
        campo.setForeground(new Color(20, 20, 20));
        campo.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));
        return campo;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBackground(new Color(20, 20, 20));

        btnAgregar = crearBotonPrincipal("Agregar");
        btnActualizar = crearBotonPrincipal("Actualizar");
        btnEliminar = crearBotonSecundario("Eliminar");
        btnBuscar = crearBotonPrincipal("Buscar por ID");
        btnLimpiar = crearBotonSecundario("Limpiar");

        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);
        panel.add(btnLimpiar);

        return panel;
    }

    private JButton crearBotonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(212, 175, 55));
        boton.setForeground(new Color(20, 20, 20));
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        return boton;
    }

    private JButton crearBotonSecundario(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(60, 60, 60));
        boton.setForeground(new Color(242, 236, 217));
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        return boton;
    }

    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JTextField getTxtNivel() {
        return txtNivel;
    }

    public JTextField getTxtInstrumento() {
        return txtInstrumento;
    }

    public JTextField getTxtIdProfesor() {
        return txtIdProfesor;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JTable getTablaProfesores() {
        return tablaProfesores;
    }

    public DefaultTableModel getModeloTablaProfesores() {
        return modeloTablaProfesores;
    }

    public JTextField getTxtProfId() {
        return txtProfId;
    }

    public JTextField getTxtProfNombre() {
        return txtProfNombre;
    }

    public JTextField getTxtProfEspecialidad() {
        return txtProfEspecialidad;
    }

    public JTextField getTxtProfTelefono() {
        return txtProfTelefono;
    }

    public JTextField getTxtProfEmail() {
        return txtProfEmail;
    }

    public JButton getBtnProfAgregar() {
        return btnProfAgregar;
    }

    public JButton getBtnProfActualizar() {
        return btnProfActualizar;
    }

    public JButton getBtnProfEliminar() {
        return btnProfEliminar;
    }

    public JButton getBtnProfBuscar() {
        return btnProfBuscar;
    }

    public JButton getBtnProfLimpiar() {
        return btnProfLimpiar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(
            this,
            mensaje,
            "Confirmar",
            JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION;
    }

    public void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtNivel.setText("");
        txtInstrumento.setText("");
        txtIdProfesor.setText("");
        tablaProductos.clearSelection();
    }

    public void limpiarFormularioProfesores() {
        txtProfId.setText("");
        txtProfNombre.setText("");
        txtProfEspecialidad.setText("");
        txtProfTelefono.setText("");
        txtProfEmail.setText("");
        tablaProfesores.clearSelection();
    }
}
