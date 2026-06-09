package Modelo;

public class Producto {
    
    private int id;
    private String nombre;
    private int edad;
    private String nivel;
    private String instrumento;
    private int idProfesor;
    
    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.edad = 0;
        this.nivel = "";
        this.instrumento = "";
        this.idProfesor = 0;
    }

    public Producto(int id, String nombre, int edad, String nivel, String instrumento, int idProfesor) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nivel = nivel;
        this.instrumento = instrumento;
        this.idProfesor = idProfesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public String mostrarDetalle() {
        return String.format(
            "ID: %d | Nombre: %s | Edad: %d | Nivel: %s | Instrumento: %s | Profesor ID: %d",
            id, nombre, edad, nivel, instrumento, idProfesor
        );
    }
    
    @Override
    public String toString() {
        return mostrarDetalle();
    }
}