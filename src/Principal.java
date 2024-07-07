import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {


        Aplicacion nueva = new Aplicacion();
        Conversion com = new Conversion();
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println();
        System.out.println(" \n GRACIAS POR UTILIZAR NUESTRO SERVICIO \n CONVERSOR DE MONEDAS A-ONE ");
        System.out.println("Estas son las monedas mas comerciales en el mundo \n ");
        do {
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1. Conversor de Monedas");
            System.out.println("2. Resumen de conversiones realizadas");
            System.out.println("3. Salir \n");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n Principales Monedas del Mundo: \t ");
                    System.out.println("\n 1. USD -> Dolar Americano.");
                    System.out.println("\n 2. CAD -> Dolar Canadiense.");
                    System.out.println("\n 3. EUR -> Euro.");
                    System.out.println("\n 4. MXN -> Peso Mexicano.");
                    System.out.println("\n 5. GBP -> Libra Esterlina.");
                    System.out.println("\n 6. JPY -> Yen Japones.");
                    System.out.println("\n 7. CNY -> Renminbi Chino.");
                    System.out.println("\n 8. XPF -> Franco.");
                    System.out.print("Digita el codigo de la moneda origen: ");
                    String codigoDe = sc.next();
                    System.out.print("Monto : $ ");
                    double monto = sc.nextDouble();
                    System.out.print("Digita el codigo de la moneda destino: ");
                    String codigoA = sc.next();
                    nueva.agregaRegistro(com.convertirMoneda(codigoDe, codigoA, monto));
                    break;
                case 2:
                    nueva.mostrarLista();
                    break;
                case 3:
                    System.out.println(" Vuelve pronto \n "
                            + "Gracias por usar el conversor de monedas A-One");
                    nueva.listaTxt();
                    break;
                default:
                    System.out.println("La opcion ingresada es incorrecta:");
            }
        } while (opcion != 3);
    }
}