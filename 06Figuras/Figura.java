//librerias
import java.util.Scanner;
import java.lang.Math;

public class Figura {
    //variables globales
    Scanner sc = new Scanner(System.in);
    int opcion;
    char letra;
    double lado, altura, area, perimetro, base;
    boolean esValido = false;


    //metodo menu
    public void menu() {
        do {
            System.out.println("Este es un programa para calcular el área y perímetro de diferentes figuras geométricas. Por favor, selecciona una figura:");
            System.out.println("1. Triangulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Rectángulo");
            System.out.print("5. Cubo ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    calcularTriangulo();

                    break;
                case 2:
                    calcularCuadrado();
                    break;
                case 3:
                    calcularCirculo();
                    break;
                case 4:
                    calcularRectangulo();
                    break;
                case 5:
                    calcularCubo();
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
            System.out.println("Si desa repetir el programa, presione 's' o 'S'.");
            letra = sc.next().charAt(0);

        } while (letra != 's' && letra != 'S' );
    }
public void calcularTriangulo(){


}

public void calcularCuadrado(){

}

public void calcularCirculo(){

}

public void calcularRectangulo(){

}

public void calcularCubo(){

}




}

