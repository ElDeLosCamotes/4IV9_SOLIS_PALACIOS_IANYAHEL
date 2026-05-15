package principal.herenciapersona;

public class Profesor extends Persona {
    
    private int numEmpleado;
    private String departamento;
    
    public Profesor(int numEmpleado, String nombre, int edad, char genero, String departamento) {
        super(nombre, edad, genero);
        this.numEmpleado = numEmpleado;
        this.departamento = departamento;
    }
    
    public int getNumEmpleado() {
        return numEmpleado;
    }
    
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}