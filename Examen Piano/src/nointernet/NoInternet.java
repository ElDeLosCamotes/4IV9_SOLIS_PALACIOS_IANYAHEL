
package nointernet;

import Controlador.ProductoControlador;
import Controlador.ProductoDAO;
import Controlador.ProfesorControlador;
import Controlador.ProfesorDAO;
import Vista.ProductoVista;
import Modelo.*;
import javax.swing.JOptionPane;


public class NoInternet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        if(!ConexionBD.probarConexion()){
            JOptionPane.showMessageDialog(
                    null, "No se pudo conectar a la bd");
            return;
        }
        
        ProductoDAO modelo = new ProductoDAO();
        ProfesorDAO profesorModelo = new ProfesorDAO();
        
        ProductoVista vista = new ProductoVista();
        
        new ProductoControlador(modelo, vista);
        new ProfesorControlador(profesorModelo, vista);
        
        vista.setVisible(true);
        
        
    }
    
}
