package Modelo;

public class Profesor {
    private int id;
    private String nombre;
    private String especialidad;
    private String telefono;
    private String email;

    public Profesor() {
        this.id = 0;
        this.nombre = "";
        this.especialidad = "";
        this.telefono = "";
        this.email = "";
    }

    public Profesor(int id, String nombre, String especialidad, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String mostrarDetalle() {
        return String.format(
            "ID: %d | Nombre: %s | Especialidad: %s | Teléfono: %s | Email: %s",
            id, nombre, especialidad, telefono, email
        );
    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }
}
