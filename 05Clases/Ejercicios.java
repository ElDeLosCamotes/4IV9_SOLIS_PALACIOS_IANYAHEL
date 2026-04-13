import java.util.Scanner;

public class Ejercicios {
    Scanner entrada = new Scanner(System.in);
    double num1 = 0;
    double num2 = 0;
    double num3 = 0;
    public void menu(){
        System.out.println("Bienvenido a la calculadora");
        System.out.println("Elige una opcion");
        System.out.println("1.- Suma ");
        System.out.println("2.- Resta ");
        System.out.println("3.- Multiplicacion ");
        System.out.println("4.- Salir ");

        int opcion = 0;
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1 :
                System.out.println("Ingresa el primer numero");
                num1 = entrada.nextDouble();
                System.out.println("Ingresa el segundo numero");
                num2 = entrada.nextDouble();
                num3= num1 + num2;
                
                System.out.println("La suma de los numeros es " + num3);
                break;
            case 2 :
            break;
        }


    }
}
