package principal.herenciapersona;

import javax.swing.JOptionPane;

public class DAOProfesor {
    
    Profesor obj[] = new Profesor[10];
    int x = 0;
    
    void menu() {
        String var = "si";
        String mensaje = "";
        
        while (var.equalsIgnoreCase("si")) {
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo profesor. \n"
                    + "2.- Mostrar los datos de todos los profesores \n"
                    + "3.- Eliminar datos de un profesor \n"
                    + "4.- Actualizar profesor \n"));
            
            switch (op) {
                case 1:
                    pedirProfesor();
                    break;
                case 2:
                    mostrarProfesor();
                    break;
                case 3:
                    eliminarProfesor();
                    break;
                case 4:
                    actualizarProfesor();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
            var = mensaje;
        }
    }
    
    public void pedirProfesor() {
        if (x >= obj.length) {
            JOptionPane.showMessageDialog(null, "Ya no se pueden registrar más profesores");
            return;
        }
        
        int numEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de empleado del profesor:"));
        String nom = JOptionPane.showInputDialog("Ingresa el nombre del profesor");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad del profesor:"));
        char gen = JOptionPane.showInputDialog("Ingresa el genero del profesor").charAt(0);
        String departamento = JOptionPane.showInputDialog("Ingresa el departamento del profesor");
        
        obj[x] = new Profesor(numEmpleado, nom, edad, gen, departamento);
        x++;
    }
    
    public void mostrarProfesor() {
        for (int i = 0; i < x; i++) {
            JOptionPane.showMessageDialog(null,
                    "Número de empleado: " + obj[i].getNumEmpleado() + "\n"
                    + "Nombre: " + obj[i].getNombre() + "\n"
                    + "Edad: " + obj[i].getEdad() + "\n"
                    + "Género: " + obj[i].getGenero() + "\n"
                    + "Departamento: " + obj[i].getDepartamento() + "\n");
        }
    }
    
    public void eliminarProfesor() {
        int empleadoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de empleado del profesor a eliminar:"));
        boolean encontrado = false;
        for (int i = 0; i < x; i++) {
            if (obj[i] != null && obj[i].getNumEmpleado() == empleadoBuscar) {
                for (int j = i; j < x - 1; j++) {
                    obj[j] = obj[j + 1];
                }
                obj[x - 1] = null;
                x--;
                JOptionPane.showMessageDialog(null, "Profesor eliminado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Profesor no encontrado.");
        }
    }
    
    public void actualizarProfesor() {
        int empleadoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de empleado del profesor a actualizar:"));
        boolean encontrado = false;
        for (int i = 0; i < x; i++) {
            if (obj[i] != null && obj[i].getNumEmpleado() == empleadoBuscar) {
                int nuevoEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de empleado:"));
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre:");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
                char nuevoGen = JOptionPane.showInputDialog("Nuevo género:").charAt(0);
                String nuevoDepartamento = JOptionPane.showInputDialog("Nuevo departamento:");
                
                obj[i] = new Profesor(nuevoEmpleado, nuevoNom, nuevaEdad, nuevoGen, nuevoDepartamento);
                JOptionPane.showMessageDialog(null, "Profesor actualizado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Profesor no encontrado.");
        }
    }
}