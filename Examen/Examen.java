/*
Desarrollar un programa que se encargue de realizar el calculo del costo para la colocación de piso, para ello el programa debe de tener las siguientes opciones


Debe de tener un menu con base a las siguientes opciones:
Al ingresar en la opcion 1 le debe de preguntar al usuario sus datos para la compra del piso, debe de solicitar los siguientes datos nombre apellido paterno, apellido materno, fecha de nacimiento, direccion residencial.
al ingresar en la opcion 2 se debe de debe de visualizar los datos del tipo de piso que se venden dentro de la empresa los cuales son:
Porcelanato 22.35 el metro cuadrado
Marmoleado 34.27 el metro cuadrado
Acrilico 22.94 el metro cuadrado
al oprimir la opcion 3 el programa debe de preguntar cuantos cuartos tiene el inmueble donde se desea instalar el piso, se debe de validar que sea un numero entero positivo mayor a 1 pero menor de 5. Una vez que se haya definido el numero de cuarto el programa debe de preguntar las medidas de largo y ancho de cada uno de los cuartos, asi como tambien debe de elegir alguna de las opciones listadas (si es porcelanato, si es marmoleado o si es acrilico). Finalmente debe de imprir en la pantalla el costo por cada cuarto con su correspondiente tipo de piso asi como el total general de la compra con los datos completos del comprador.
Una vez visualizados esos datos debe de preguntarle si desea realizar la compra en caso de ser afirmativa la respuesta debe de realizar a la compra total un descuento del 7.95% sobre el total de la compra. Considere que en el desploce de precios se debe de marcar el cobro del IVA del 16%
*/
import java.util.Scanner;

public class Examen {
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            char letrarepetir = 's';
            int opcion = 0;
            String nombre = null;
            String apellidoPaterno = null;
            String apellidoMaterno = null;
            String fechaNacimiento = null;
            String direccion = null;

            do {
                //Menu jeje
                System.out.println("===Bienvenido al programa pal calculo de pisos===");
                System.out.println("Menu ");
                System.out.println("1. Ingresar datos del comprador");
                System.out.println("2. Visualizar tipos de piso");
                System.out.println("3. Calcular costo de instalación");
                System.out.println("4. Salir");
                try{
                    System.out.println("Seleccione una opción del menú:");
                    opcion = entrada.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número entero.");
                    entrada.nextLine();
                    continue;
                }
                switch (opcion) {
                    case 1: // Datos 
                        System.out.println("Ingrese su nombre:");
                        nombre = entrada.next();
                        try {
                            Integer.parseInt(nombre);
                            System.out.println("El nombre no puede ser un número. Por favor, ingrese un nombre válido.");
                            nombre = null;
                        } catch (NumberFormatException e) {
                        }
                        System.out.println("Ingrese su apellido paterno:");
                        apellidoPaterno = entrada.next();
                        try {
                            Integer.parseInt(apellidoPaterno);
                            System.out.println("El apellido paterno no puede ser un número. Por favor, ingrese un apellido válido.");
                            apellidoPaterno = null;
                        } catch (NumberFormatException e) {
                        }
                        System.out.println("Ingrese su apellido materno:");
                        apellidoMaterno = entrada.next();
                        try {
                            Integer.parseInt(apellidoMaterno);
                            System.out.println("El apellido materno no puede ser un número. Por favor, ingrese un apellido válido.");
                            apellidoMaterno = null;
                        } catch (NumberFormatException e) {
                        }

                        System.out.println("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
                        fechaNacimiento = entrada.next();
                        try {
                            String[] fechaPartes = fechaNacimiento.split("/");
                            if (fechaPartes.length != 3) {
                                throw new IllegalArgumentException("Formato de fecha no válido. Por favor, ingrese la fecha en formato dd/mm/yyyy.");
                            }
                            int dia = Integer.parseInt(fechaPartes[0]);
                            int mes = Integer.parseInt(fechaPartes[1]);
                            int año = Integer.parseInt(fechaPartes[2]);
                            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || año < 1900 || año > 2026) {
                                throw new IllegalArgumentException("Fecha no válida. Por favor, ingrese una fecha válida.");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            fechaNacimiento = null;
                        }
                        System.out.println("Ingrese su dirección residencial:");
                        direccion = entrada.next();
                        try {
                            Integer.parseInt(direccion);
                            System.out.println("La dirección no puede ser un número. Por favor, ingrese una dirección válida.");
                            direccion = null;
                        } catch (NumberFormatException e) {
                        }
                    break;
                    case 2: // Pisos
                        System.out.println("Tipos de Pisos: ");
                        System.out.println("1. Porcelanato - $22.35 por metro cuadrado");
                        System.out.println("2. Marmoleado - $34.27 por metro cuadrado");
                        System.out.println("3. Acrilico - $22.94 por metro cuadrado");
                    break;
                    case 3: // Costo
                    double[] largo = new double[5];
                    double[] ancho = new double[5];
                    int[] tipoPiso = new int[5];
                    double[] costoCuarto = new double[5];
                    if (nombre == null || apellidoPaterno == null || apellidoMaterno == null || fechaNacimiento == null || direccion == null) {
                        System.out.println("Por favor, ingrese los datos del comprador en la opción 1 antes de calcular el costo de instalación.");
                        break;
                    }else{
                    System.out.println ("Ingrese el número de cuartos (entre 1 y 5):");
                    try {
                    } catch (Exception e) {
                        System.out.println(" Ingrese un número entero.");
                        entrada.nextLine();
                        break;
                    }
                    int numCuartos = entrada.nextInt();
                    try {
                    } catch (Exception e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                        entrada.nextLine();
                        break;
                    }
                    if (numCuartos > 1 && numCuartos < 5) {
                        for (int i = 0; i < numCuartos; i++) {
                            System.out.println("Ingrese el largo: ");
                            largo[i] = entrada.nextDouble();
                            System.out.println("Ingrese el ancho: ");
                            ancho[i] = entrada.nextDouble();
                            System.out.println("Ingrese el tipo de piso (1-3): ");
                            tipoPiso[i] = entrada.nextInt();
                            switch (tipoPiso[i]) {
                                case 1:
                                    costoCuarto[i] = largo[i] * ancho[i] * 22.35;
                                    break;
                                case 2:
                                    costoCuarto[i] = largo[i] * ancho[i] * 34.27;
                                    break;
                                case 3:
                                    costoCuarto[i] = largo[i] * ancho[i] * 22.94;
                                    break;
                                default:
                                    System.out.println("Tipo de piso no válido. Por favor, ingrese un número entero entre 1 y 3.");
                                    i--;
                                    break;
                                }
                            System.out.println("Costo del cuarto " + (i + 1) + ": $" + costoCuarto[i]);
                            System.out.println("Tipo de piso " + (i + 1) + ": " + (tipoPiso[i] == 1 ? "Porcelanato" : tipoPiso[i] == 2 ? "Marmoleado" : "Acrilico"));
                        }
                        System.out.println("Total general de la compra: $" + (costoCuarto[0] + costoCuarto[1] + costoCuarto[2] + costoCuarto[3] + costoCuarto[4]));
                        }else {
                            System.out.println("Número de cuartos no válido. Debe ser un número entero positivo mayor a 1 pero menor de 5.");
                            break;
                        }
                        System.out.println("¿Desea realizar la compra? (s/n)");
                        char respuestaCompra = entrada.next().charAt(0);
                        if (respuestaCompra == 's' || respuestaCompra == 'S') {
                            double totalCompra = costoCuarto[0] + costoCuarto[1] + costoCuarto[2] + costoCuarto[3] + costoCuarto[4];
                            double descuento = totalCompra * 0.0795;
                            double totalConDescuento = totalCompra - descuento;
                            double iva = totalConDescuento * 0.16;
                            double totalFinal = totalConDescuento + iva;
                            System.out.println("Total de la compra con descuento: $" + totalConDescuento);
                            System.out.println("IVA (16%): $" + iva);
                            System.out.println("Total final a pagar: $" + totalFinal);
                        } else {
                            System.out.println("Compra cancelada.");
                        }
                    }

                    break;
                    case 4:
                        System.out.println("Vuelva Prontooo");
                    break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                    
            }
            System.out.println("Desas Repetir el programa escribe s o S para si");
    letrarepetir = entrada.next().charAt
    (0);
        } while (letrarepetir == 's' || letrarepetir == 'S');
    }
}