import java.util.Scanner;

public class Figuras {
    Scanner entrada = new Scanner(System.in);
    //Variables jeje
        int NoMenu;
        double rCirculo = 0;
        double diCirculo = 0;
        double AreaCirculo = 0;
        double PerimetroCirculo = 0;
        double lCuadrado = 0;
        double AreaCuadrado = 0;
        double PerimetroCuadrado = 0;
        double bTriangulo = 0;
        double hTriangulo = 0;
        double AreaTriangulo = 0;
        double PerimetroTriangulo = 0;
        double lCubo = 0;
        double AreaCubo = 0;
        double PerimetroCubo = 0;
        double bRectangulo = 0;
        double hRectangulo = 0;
        double AreaRectangulo = 0;
        double PerimetroRectangulo = 0;
    public void calculadorsita(){
        //Menu
        do{
        System.out.println("Ingresa el numero de la figura que deseas calcular");
        System.out.println("|1.-Circulo                      |");
        System.out.println("|2.-cuadrado                     |");
        System.out.println("|3.-Triangulo                    |");
        System.out.println("|4.-Cubo                         |");
        System.out.println("|5.-Rectangulo                   |");
        System.out.println("|6.-Salir                        |");
        NoMenu = entrada.nextInt();
        try {
            if (NoMenu < 1 || NoMenu > 6) {
                throw new Exception("Opcion no valida, ingrese un numero de las opciones");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            continue; 
        }
        switch (NoMenu) {
            case 1:
                System.out.println("introduce el radio del circulo");
                rCirculo = entrada.nextDouble();
                diCirculo = rCirculo*2;
                AreaCirculo = Math.PI * Math.pow(rCirculo, 2);
                PerimetroCirculo = Math.PI * diCirculo;
                System.out.println("El area del circulo es: " + AreaCirculo);
                System.out.println("El perimetro del circulo es: " + PerimetroCirculo);
                break;
            case 2:
                System.out.println("introduce el lado del cuadrado");
                lCuadrado = entrada.nextDouble();
                AreaCuadrado = Math.pow(lCuadrado, 2);
                PerimetroCuadrado = 4 * lCuadrado;
                System.out.println("El area del cuadrado es: " + AreaCuadrado);
                System.out.println("El perimetro del cuadrado es: " + PerimetroCuadrado);
                break;
            case 3:
                System.out.println("introduce la base del triangulo");
                bTriangulo = entrada.nextDouble();
                System.out.println("introduce la altura del triangulo");
                hTriangulo = entrada.nextDouble();
                AreaTriangulo = (bTriangulo * hTriangulo) / 2;
                PerimetroTriangulo = 3 * bTriangulo; // Digamos que es un equilatero jeje
                System.out.println("El area del triangulo es: " + AreaTriangulo);
                System.out.println("El perimetro del triangulo es: " + PerimetroTriangulo);
                break;
            case 4:
                System.out.println("introduce el lado del cubo");
                lCubo = entrada.nextDouble();
                AreaCubo = 6 * Math.pow(lCubo, 2);
                PerimetroCubo = 12 * lCubo;
                System.out.println("El area del cubo es: " + AreaCubo);
                System.out.println("El perimetro del cubo es: " + PerimetroCubo);
                break;
            case 5:
                System.out.println("introduce la base del rectangulo");
                bRectangulo = entrada.nextDouble();
                System.out.println("introduce la altura del rectangulo");
                hRectangulo = entrada.nextDouble();
                AreaRectangulo = bRectangulo * hRectangulo;
                PerimetroRectangulo = 2 * (bRectangulo + hRectangulo);
                System.out.println("El area del rectangulo es: " + AreaRectangulo);
                System.out.println("El perimetro del rectangulo es: " + PerimetroRectangulo);
                break;
            case 6:
                System.out.println("Gracias por usar el programa");
                break;
        }

    }while (NoMenu != 6);
}
}