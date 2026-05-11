public class Gato extends Animal {

        private int num_vidas;

    public Gato() {

    }

    public Gato(String nombre, String raza, String tipo_alimento, int edad, int num_vidas) {
        super(nombre, raza, tipo_alimento, edad);
        this.num_vidas = num_vidas;
    }

    public int getNum_vidas() {
        return num_vidas;
    }

    public void setNum_vidas(int num_vidas) {
        this.num_vidas = num_vidas;
    }

    //metodo de don gato 
    public void mostrarGato(){
        System.out.println("El nombre del miau es: " + getNombre() + "\n");
        System.out.println("La raza del miau es: " + getRaza() + "\n");
        System.out.println("El tipo de alimento del miau es: " + getTipo_alimento() + "\n");
        System.out.println("La edad del miau es: " + getEdad() + "\n");
        System.out.println("El numero de vidas que le restan son: " + getNum_vidas() + "\n");
    }
    
}
