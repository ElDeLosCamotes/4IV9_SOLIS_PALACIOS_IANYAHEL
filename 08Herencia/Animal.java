//La herencia es la capacidad de poder tener acceso a los atributos y conportaminetos de una clase padre a una clase hijo

//El encapsulamiento es la capacidad de podert restringir el acceso a los tipos de datos, comportamientos u atributoa de una clase frente a otra. Con ello vamos a poder agrupar en una clase el accespo a los metodos, atributos y objetos para que no puedan ser modificados.

//sobrecarga 
public class Animal {

    private String nombre, raza, tipo_alimento;
    private int edad;

    //toda clase debe de tener un constructor
    //Los constructores sirven para poder declarar la existencia de una clase, para poder inicializar sus variables y poder crear instancias de la misma.

    public Animal(){
        // su acceso es publico
        // el nombbre del constructor es el mismo que el de la clase pero sin parametros.
        //Es un metodo
    }

    public Animal(String nombre, String raza, String tipo_alimento, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipo_alimento = tipo_alimento;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
