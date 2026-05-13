/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Alumno
 */

import java.util.ArrayList;

public class ControladorPersona {
    
      /*
        Vamos a crear un objeto especialk para poder almacenar diferentes tipos de variables, y diferenciatr objetos, llamado arraylist, su particularidad es rendimiento
        */
        public static ArrayList<Persona> listadePersonas = new ArrayList<Persona>();
       
        //el metodo
        public ArrayList<Persona> mostrarPersonas(){
            return listadePersonas;
        }
       
        //registrar
       
        public void registrarPersona(Persona p){
            listadePersonas.add(p);
        }
        //buscar persona
       
        public Persona buscarPersona (int id){
            Persona encontrada = new Persona();
            //recorro el arraylist
           
            for(Persona p: listadePersonas){
                if(id == p.getId()){
                encontrada = p;
               
                }else{
                    System.out.println("Solo juego contigo");
                }
            }
            return encontrada;
        }
       
        public void actualizarPersona(Persona personaActualizada){
            Persona personaActualizar = buscarPersona(personaActualizada.getId());
            listadePersonas.remove(personaActualizar);
            listadePersonas.add(personaActualizar);
        }
       
        public void eliminarPersona(Persona personaEliminar){
            listadePersonas.remove(personaEliminar);
        }
}

