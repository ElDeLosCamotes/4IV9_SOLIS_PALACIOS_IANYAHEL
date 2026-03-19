
/*
    Vamos a realizar 14 programas dentrp de in menu gigante para poner a prubea sus conocimientos de algoritmia 
    1.- Desarrolla un progrma para calcular el bono de un descuento por edad
    2.- Conertir numeros decimales a binarios
    3.- Convertir temperaturas entre los 3 principales grados C -> F y K 
    4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros
    5.- Desarrollar una tienda para agregrar productos y precios
    6.- Desarrollar un programa para calclar el area y perimetro de 5 diferentes figuras
    7.- Desarrollar una tabla multiplicar
    8.- Desarrollar un programa para calcular un factorial 
    9.- Vamos a hacer dibujitos wiiii ( Triangulo equilatero o rombo)
    10.- Desarrolla una figura hueca
    12.- Realizar un diamanteeeee
    13.- Desarrollar una calculadora basica + - * / para n numeros

*/
import java.util.Scanner;


class EstructuraDatos {
    public static void main(String[] args) {
        
     //aqui van las variables
        int opcion;
        Scanner entrada = new Scanner(System.in);
        double pago = 0;
        int edad = 0;
        char socios;
        char letrarepetir;
        float compra = 0;
        double descuentobono= 0;
        double temperatura = 0;
        double resultadotemperatura = 0;
        int[] numero = new int[10];
        int positivos = 0;
        int negativos = 0;
        double radio = 0;
        double areacirculo = 0;
        double ladocuadrado = 0;
        double areacuadrado = 0;
        float ladorectangulo = 0;
        float baserectangulo = 0;
        float arearectangulo = 0;
        float basetriangulo = 0;
        float alturatriangulo = 0;
        float areatriangulo = 0;
        double Baseunocilindro = 0;
        double areaCilindro = 0;
        double Basedosclindro = 0;
        int n1= 0;
        int numfactorial = 0;
        int hueco = 0;
   // aqui van los objetos

   // aqui va el menu
    do {
    System.out.println("1.- Bono de descuento por edad");
    System.out.println("2.- Convertir numeros binarios");
    System.out.println("3.- Temperaturas ");
    System.out.println("4.- Contar positivos y negativos");
    System.out.println("5.-Tienda");
    System.out.println("6.- Calcular area y perimetro");
    System.out.println("7.-Tabla Multiplicar");
    System.out.println("8.-Calcular un factorial ");
    System.out.println("9.- Cuadradito Magiquito ");
    System.out.println("10.- Figura Hueca ");
    System.out.println("11.- Diamante ");
    System.out.println("12.- Calculadora Basica ");
    System.out.println("13.- Salir ");

    opcion = entrada.nextInt();

   // ahora tenemos que evaluar la entrada

        switch (opcion){
            case 1:
                System.out.println("Ingrese su edad");
                edad = entrada.nextInt();
                System.out.println("Ingrese su pago ");
                pago = entrada.nextFloat();
                if (edad > 65){
                    System.out.println("Tiene un bono del 40%");
                    descuentobono = pago * 0.40;
                }else if (edad < 21){
                    System.out.println("Ingrese si es socio (s/n)");
                    socios = entrada.next().charAt(0);
                    if(socios == 's'){
                        System.out.println("Tiene un bono del 45%");
                        descuentobono = pago * 0.45;
                    }
                }else {
                    System.out.println("No tiene bono");
                    descuentobono = pago;
                }
                System.out.println("El pago final con/sin bono es: " + descuentobono);
                break;
            case 2:
                // convertir decimal a binario 
                System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
                int numbinario;
                String guardarbinario ="";
                numbinario = entrada.nextInt();

                if(numbinario > 0){
                // realizar mod 2
                while( numbinario > 0){
                if(numbinario%2 == 0){
                    guardarbinario = "0" + guardarbinario;
                }
                else {
                    guardarbinario = "1" + guardarbinario;
                }
                numbinario = (int)numbinario/2;
                }
                }else if(numbinario == 0){
                guardarbinario = "0";
                }else{
                guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
                }
                System.out.println("El numero convertido a binario es: " + guardarbinario);
                break;
            case 3:
                System.out.println("Ingrese la temperatura");
                temperatura = entrada.nextFloat();
                    System.out.println("Ingrese la unidad de la temperatura (C, F, K)");
                    char unidad = entrada.next().charAt
                    (0);
                    System.out.println("Ingrese a que unidad desea convertir (C, F, K)");
                    char unidadconvertir = entrada.next().charAt
                    (0);
                    if (unidad == 'C' && unidadconvertir == 'F'){
                        resultadotemperatura = (temperatura * 9/5) + 32;
                        System.out.println("La temperatura convertida es: " + resultadotemperatura + " F");
                    }else if (unidad == 'C' && unidadconvertir == 'K'){
                        resultadotemperatura = temperatura + 273.15;
                        System.out.println("La temperatura en Kelvin es:" + resultadotemperatura + " K");
                    }else if (unidad == 'F' && unidadconvertir == 'C'){
                        resultadotemperatura = (temperatura - 32) * 5/9;
                        System.out.println("La temperatura convertida es: " + resultadotemperatura + " C");
                    }else if ( unidad == 'F' && unidadconvertir == 'K'){
                        resultadotemperatura = (temperatura - 32) * 5/9 + 273.15;
                        System.out.println("La temperatura convertida es: " + resultadotemperatura + " K");
                    }else if ( unidad == 'K' && unidadconvertir == 'C') {
                        resultadotemperatura = temperatura - 273.15;
                        System.out.println("La temperatura convertida es: " + resultadotemperatura + " C");
                    }else if ( unidad == 'K' && unidadconvertir == 'F') {
                        resultadotemperatura = (temperatura - 273.15) * 9/5 + 32;
                        System.out.println("La temperatura convertida es: " + resultadotemperatura + " F");
                    }else {
                        System.out.println("Ingrese una unidad valida");
                    }
                    
                    break;
            case 4:
                for(int i = 0; i < numero.length; i++ ){
                    System.out.println("Ingrese un numero (0 para finalizar)");
                    numero[i] = entrada.nextInt();
                    if (numero[i] == 0){
                        break;
                    }else if (numero[i] > 0){
                        positivos++;
                    }else {
                        negativos++;
                    }
                }   
                System.out.println("Numero de positivos: " + positivos);
                System.out.println("Numero de negativos: " + negativos);
                break;
            case 5:
                System.out.println("Bienvenido a esta linda hermosa y kawaii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int elementosproducto = 0;
                elementosproducto = entrada.nextInt();
                if (elementosproducto > 0 ){
                    for(int i = 1; i <= elementosproducto;i++ ){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto = "";
                        nombreproducto = entrada.next();
                        System.out.println("Ingrese el precio");
                        float precio = 0;
                        precio = entrada.nextFloat();
                        System.out.println("Ingrese la cantidad");
                        int cantidad = 0;
                        cantidad = entrada.nextInt();
                        float resultado = 0;
                        resultado = precio * cantidad;
                        compra = resultado + compra;
                    }
                    System.out.println("El total de la compra es: " + compra);
                }else{
                    System.out.println("Ingrese solo positivos");
                }
                break;
            case 6:
                System.out.println("Ingrese la fiugra deseada (1.- Circulo, 2.- Cuadrado, 3.- Rectangulo, 4.- Triangulo, 5.- Cilindro)");
                int figura = entrada.nextInt();
                switch (figura) {
                    case 1:
                        System.out.println("Ingrese el radio del circulo");
                        radio = entrada.nextFloat();
                        areacirculo = Math.PI * Math.pow(radio, 2);
                        System.out.println("El area del circulo es: " + areacirculo);
                        break;
                    case 2:
                        System.out.println("Ingrese el lado del cuadrado");
                        ladocuadrado = entrada.nextFloat();
                        areacuadrado = Math.pow(ladocuadrado, 2);
                        System.out.println("El area del cuadrado es: " + areacuadrado);
                        break;
                    case 3:
                        System.out.println("Ingresa la base del rectangulo");
                        baserectangulo = entrada.nextFloat();
                        System.out.println("Ingrese el lado ( o altura) del rectangulo");
                        ladorectangulo = entrada.nextFloat();
                        arearectangulo = baserectangulo * ladorectangulo;
                        System.out.println("El area del rectangulo ess:" + arearectangulo);
                        break;
                    case 4:
                        System.out.println("Ingrese la base del triangulo");
                        basetriangulo = entrada.nextFloat();
                        System.out.println("Ingrese la altura del triangulo");
                        alturatriangulo = entrada.nextFloat();
                        areatriangulo = (basetriangulo * alturatriangulo) /2;
                        System.out.println("El area del triangulo es:" + areatriangulo);
                        break;
                    case 5:
                        System.out.println("Ingrese la base uno del cilindro");
                        Baseunocilindro = entrada.nextFloat();
                        System.out.println("Ingresa la base dos del clindro");
                        Basedosclindro = entrada.nextFloat();
                        areaCilindro = 2 * Math.PI * (Baseunocilindro * Basedosclindro);
                        System.out.println("El area del cilindro es: " + areaCilindro);

                        break;
                    default:
                        System.out.println("Ingrese un numero valido");
                        break;
                }
            case 7:
                //Tabla de Multiplicar 
                System.out.println("Tabla del  10, 100 y 1000");
                System.out.println("-------------------------------------------------");
                for (int n = 0; n <= 10; n++) {
                    System.out.print(" | " + n + " " + " | ");
                    System.out.print(" | " + (n*10) + " " + " | ");
                    System.out.print(" | " + (n*100) + " " + " | ");
                    System.out.println(" | " + (n*1000) + " " + " | ");
                    System.out.println("-------------------------------------------------");
                }
                break; 
            case 8:
                // Factorial
                System.out.println("Ingrese un numero para calcular su factorial");
                numfactorial = entrada.nextInt();
                for ( int i = numfactorial - 1; i > 0; i--){
                    numfactorial = numfactorial * i;
                    
                }
                System.out.println("El factorial es: " + numfactorial);
                break;
            case 9:
                // Vamos a realizar un cuadrado magico 
                System.out.println("Vamos a realizar el dibujo de un cuadrado magico");
                System.out.println("Ingrese el tamaño del cuadrado");
                n1 = entrada.nextInt();
                if(n1 >= 1 && n1 <= 20){
                    for (int i = 1; i <= n1; i++){
                        for (int j = 0; j < n1; j++) {
                            System.out.print(" * ");
                        }
                    System.out.println("");
                    }
                }else{
                    System.out.println("Porfavor solo ingrese valores entre el 1 y el 20");
                }
                break;
            case 10:
                // Figura Hueca
                System.out.println("Ingrese el tamaño de la figura hueca");
                hueco = entrada.nextInt();
                if (hueco >= 3 && hueco <=20){
                    for (int i = 1; i <= hueco; i++){
                        for (int j = 1; j <= hueco; j++){
                            if (i == 1 || i == hueco || j == 1 || j == hueco){
                                System.out.print("*");
                            }else {
                                System.out.print(" ");
                            }
                        }
                    System.out.println("");
                    }
                }else {
                    System.out.println("Ingrese Valores entre el 3 y el 20");
                }
                System.out.println(" ");

                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                System.out.println(" Vuelva Pronto... ");
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
    System.out.println("Desas Repetir el programa escribe s o S para si");
    letrarepetir = entrada.next().charAt
    (0);
    } while (letrarepetir == 's' || letrarepetir == 'S');
}
}