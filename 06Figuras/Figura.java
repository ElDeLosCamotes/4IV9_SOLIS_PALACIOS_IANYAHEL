//librerias
import java.util.Scanner;
import java.lang.Math;

public class Figura {
    //variables globales
    Scanner sc = new Scanner(System.in);
    int opcion;
    char letra;
    double lado, altura, area, perimetro, base, radio;
    boolean esValido = false;


    //metodo menu
    public void menu() {
        do {
            System.out.println("Este es un programa para calcular el área y perímetro de diferentes figuras geométricas. Por favor, selecciona una figura:");
            System.out.println("1. Triangulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Cubo ");
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

        } while (letra == 's' || letra == 'S' );
    }
public void calcularTriangulo(){
System.out.println("Área y Perímetro del Triángulo");
System.out.println("Que tipo de triángulo deseas calcular?");
System.out.println("1. Triángulo Equilátero");
System.out.println("2. Triángulo Isósceles");
System.out.println("3. Triángulo Escaleno");
opcion = sc.nextInt();
switch (opcion) {
    case 1:
        //formula P = 3 * Lado
        //A = (b * a) / 2
            esValido = false;
                do{
                System.out.println("Ingresa la base del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        base = sc.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            esValido = false;
            do{
                System.out.println("Ingresa la altura del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        altura = sc.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            area = (base * altura) / 2;
            perimetro = 3 * base;
            System.out.println("El área del triángulo equilátero es: " + area);
            System.out.println("El perímetro del triángulo equilátero es: " + perimetro);
                break;
    case 2:
        //formula P = 2 * (Lado1 + Lado2)
        //A = (b * a) / 2
            esValido = false;
                do{
                System.out.println("Ingresa la base del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        base = sc.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            esValido = false;
            do{
                System.out.println("Ingresa la altura del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        altura = sc.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            area = (base * altura) / 2;
            perimetro = 2 * (base + altura);
            System.out.println("El área del triángulo isósceles es: " + area);
            System.out.println("El perímetro del triángulo isósceles es: " + perimetro);
                break;
    case 3:
        //formula P = Lado1 + Lado2 + Lado3
        //A = (b*a) / 2
            esValido = false;
                do{
                System.out.println("Ingresa la base del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        base = sc.nextDouble();
                        if(base > 0){
                            esValido = true;
                        }else{
                            System.out.println("La base debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            esValido = false;
            do{
                System.out.println("Ingresa la altura del triangulo");
                try{
                    if(sc.hasNextDouble()){
                        altura = sc.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);

            area = (base * altura) / 2;
            perimetro = base + altura + Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
            System.out.println("El área del triángulo escaleno es: " + area);
            System.out.println("El perímetro del triángulo escaleno es: " + perimetro);
                break;
}

}

public void calcularCuadrado(){
esValido = false;
                do{
                System.out.println("Ingresa el lado del cuadrado");
                try{
                    if(sc.hasNextDouble()){
                        lado = sc.nextDouble();
                        if(lado > 0){
                            esValido = true;
                        }else{
                            System.out.println("El lado debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);
            area = Math.pow(lado, 2);
            perimetro = 4 * lado;
            System.out.println("El área del cuadrado es: " + area);
            System.out.println("El perímetro del cuadrado es: " + perimetro);

}

public void calcularCirculo(){
esValido = false;
                do{
                System.out.println("Ingresa el radio del círculo");
                try{
                    if(sc.hasNextDouble()){
                        radio = sc.nextDouble();
                        if(radio > 0){
                            esValido = true;
                        }else{
                            System.out.println("El radio debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);
            area = Math.PI * Math.pow(radio, 2);
            perimetro = 2 * Math.PI * radio;
            System.out.println("El área del círculo es: " + area);
            System.out.println("El perímetro del círculo es: " + perimetro);
}

public void calcularRectangulo(){
esValido = false;
                do{
                System.out.println("Ingresa el lado del rectángulo");
                try{
                    if(sc.hasNextDouble()){
                        lado = sc.nextDouble();
                        if(lado > 0){
                            esValido = true;
                        }else{
                            System.out.println("El lado debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);
            esValido = false;
                do{
                System.out.println("Ingresa la altura del rectángulo");
                try{
                    if(sc.hasNextDouble()){
                        altura = sc.nextDouble();
                        if(altura > 0){
                            esValido = true;
                        }else{
                            System.out.println("La altura debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);
            area = lado * altura;
            perimetro = 2 * (lado + altura);
            System.out.println("El área del rectángulo es: " + area);
            System.out.println("El perímetro del rectángulo es: " + perimetro);
}

public void calcularCubo(){
esValido = false;
                do{
                System.out.println("Ingresa el lado del cubo");
                try{
                    if(sc.hasNextDouble()){
                        lado = sc.nextDouble();
                        if(lado > 0){
                            esValido = true;
                        }else{
                            System.out.println("El lado debe ser un numero positivo");
                        }
                    }else{
                        System.out.println("Ingrese unicamente numeros");
                        sc.next();
                    }
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            }while(!esValido);
            area = 6 * Math.pow(lado, 2);
            perimetro = 12 * lado;
            System.out.println("El área del cubo es: " + area);
            System.out.println("El perímetro del cubo es: " + perimetro);
}




}

