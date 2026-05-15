
package principal.herenciapersona;


import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DAOEstudiante {
    
    //vamos a crear un programa para dar de alta 10 estudiantes
    
    //un objeto por parte de estudiante
    Estudiante obj[] = new Estudiante[10];
    int x = 0;
    
    //metodo del menu para el programa
    void menu(){
        cargarEstudiantes("estudiantes.txt");
        String var = "si";
        String mensaje = "";
        
        while(var.equalsIgnoreCase("si")){
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opcion deseada : \n"
                    + "1.- Dar de alta a nuevo estudiante. \n"
                    + "2.- Mostrar los datos de todos los estudiantes \n"
                    + "3.- Eliminar Datos de un Estudiante \n"
                    + "4.- Actualizar Estudiante \n"
                    ));
            switch (op) {
                case 1:
                    //metodo para registrar
                    pedirEstudiante();                    
                    
                    break;
                case 2:
                    //mostrar estudiantes
                    mostrarEstudiante();
                    
                    break;
                    
                case 3:
                    eliminarEstudiante();
                    
                    break;
                
                case 4:
                    actualizarEstudiante();
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
            mensaje = JOptionPane.showInputDialog("¿Desea repetir el programa?");
            var = mensaje;
        }
    }

    public void pedirEstudiante() {
        if (x >=obj.length) {
            JOptionPane.showMessageDialog(null, "Ya no se pueden registrar mas estudiantes");
        }
        
        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la boleta del estudiante: "));
        String nom = JOptionPane.showInputDialog(
                "Ingresa el nombre del estudiante");
        int edad = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Ingresa la edad del estudiante: "));
        char gen = JOptionPane.showInputDialog(
                "Ingresa el genero del estudiante").charAt(0);
        
        obj[x] = new Estudiante(numboleta, nom, edad, gen);
        x++;
        
        
    }

    public void mostrarEstudiante() {
        //necesitamos recorrer el arreglo del tamaño que sea
        
        for(int i = 0; i < x; i++){
            //visualizar los datos
            JOptionPane.showMessageDialog(null, 
                    "La boleta del estudiante es: " + obj[i].getNumBoleta() + "\n"
                    +"El nombre del estudiante es: " + obj[i].getNombre()+ "\n"
                   +"La edad del estudiante es: " + obj[i].getEdad() + "\n"
                   +"El genero del estudiante es: " + obj[i].getGenero()+ "\n");
        }
    }
    
    public void eliminarEstudiante() {
    int boletaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de boleta del estudiante a eliminar:"));
    boolean encontrado = false;
    for (int i = 0; i < x; i++) {
        if (obj[i] != null && obj[i].getNumBoleta() == boletaBuscar) {
            // Desplazar elementos para llenar el hueco (opcional, o solo nullificar)
            for (int j = i; j < x - 1; j++) {
                obj[j] = obj[j + 1];
            }
            obj[x - 1] = null;  // Limpiar el último
            x--;  // Reducir contador
            JOptionPane.showMessageDialog(null, "Estudiante eliminado.");
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }
}
    
    public void actualizarEstudiante (){
        int boletaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de boleta del estudiante a actualizar"));
        boolean encontrado = false;
        for(int i = 0; i < x; i++){
            if (obj[i] !=null && obj[i].getNumBoleta() == boletaBuscar){
                //Pedir los nuevos datos jeje
                int nuevaBoleta = Integer.parseInt(JOptionPane.showInputDialog("Nueva boleta (actual: " + obj[i].getNumBoleta()+ "):"));
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre (actual: " + obj[i].getNombre()+ "):");
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad (actual: " + obj[i].getEdad()+ "):"));
                char nuevoGen = JOptionPane.showInputDialog("Nuevo Genero (actual: " + obj[i].getGenero()+ "):").charAt(0);
                
                //creamos un nuevo objeto pa guardarlo
                obj[i] = new Estudiante (nuevaBoleta,nuevoNom, nuevaEdad, nuevoGen);
                
                JOptionPane.showMessageDialog(null, "Estudiante actualizado");
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            
            JOptionPane.showMessageDialog(null, "Estudiante no Encontrado");
        }
    }
    
    public void guardarEstudiantes(String archivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        for (int i = 0; i < x; i++) {
            writer.write("numBoleta=" + obj[i].getNumBoleta());
            writer.newLine();
            writer.write("nombre=" + obj[i].getNombre());
            writer.newLine();
            writer.write("edad=" + obj[i].getEdad());
            writer.newLine();
            writer.write("genero=" + obj[i].getGenero());
            writer.newLine();
            writer.write("finRegistro");
            writer.newLine();
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar estudiantes: " + e.getMessage());
    }
}
    
    public void cargarEstudiantes(String archivo) {
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        int numBoleta = 0;
        String nombre = "";
        int edad = 0;
        char genero = ' ';
        while ((linea = reader.readLine()) != null) {
            if (linea.isEmpty()) continue;
            if (linea.equals("finRegistro")) {
                if (x < obj.length) {
                    obj[x] = new Estudiante(numBoleta, nombre, edad, genero);
                    x++;
                }
                continue;
            }
            String[] partes = linea.split("=", 2);
            if (partes.length < 2) continue;
            String clave = partes[0];
            String valor = partes[1];
            switch (clave) {
                case "numBoleta": numBoleta = Integer.parseInt(valor); break;
                case "nombre": nombre = valor; break;
                case "edad": edad = Integer.parseInt(valor); break;
                case "genero": genero = valor.charAt(0); break;
            }
        }
    } catch (IOException e) {

    }
}
    
}