package principal.herenciapersona;

import javax.swing.JOptionPane;

public class HerenciaPersona {

    public static void main(String[] args) {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Qué deseas administrar? \n"
                + "1.- Estudiantes \n"
                + "2.- Profesores \n"));
        
        switch (opcion) {
            case 1:
                DAOEstudiante objEstudiante = new DAOEstudiante();
                objEstudiante.menu();
                break;
            case 2:
                DAOProfesor objProfesor = new DAOProfesor();
                objProfesor.menu();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}