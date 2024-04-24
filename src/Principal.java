import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExchangeRate consultante = new ExchangeRate();
        ExchangeRate miExchangeRate = new ExchangeRate(consultante.consultar());

        String menu = """
                ************************************************
                Elije la opcción deseada:
                1- Convertir ARS a USD
                2- Convertir USD a ARS
                3- Convertir ARS a BRL
                4- Convertir BRL a ARS
                5- Convertir USD a BRL
                6- Convertir BRL a USD
                7- Elige tu propia moneda
                9- Salir
                ************************************************
                """;
// Agregar try-catch de: NumberFormatException para cuando ingresan letras en vez de números
        Scanner lectura = new Scanner(System.in);
        System.out.println(menu);
        int opcion = Integer.valueOf(lectura.nextLine());

        while (opcion != 9) {
            double cantidad;

            if(opcion == 1) { // De ARS a USD ********************************
                System.out.println("Intoduzca la cantidad que desea convertir de ARS a USD: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeBack(cantidad, "ARS"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 2) { // De USD a ARS ********************************
                System.out.println("Intoduzca la cantidad que desea convertir de USD a ARS: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeTarget(cantidad, "ARS"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 3) { // De ARS a BRL
                System.out.println("Intoduzca la cantidad que desea convertir de ARS a BRL: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeOverflow(cantidad, "ARS", "BRL"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 4) { // De BRL a ARS
                System.out.println("Intoduzca la cantidad que desea convertir de BRL a ARS: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeOverflow(cantidad, "BRL", "ARS"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 5) { // De USD a BRL
                System.out.println("Intoduzca la cantidad que desea convertir de USD a BRL: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeTarget(cantidad, "BRL"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 6) { // De BRL a USD
                System.out.println("Intoduzca la cantidad que desea convertir de BRL a USD: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeBack(cantidad, "BRL"));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 7) {
                String monedaBase;
                String monedaDestino;
                System.out.println("Escriba la moneda base: ");
                monedaBase = lectura.nextLine();
                System.out.println("Ahora esciba la moneda destino: ");
                monedaDestino = lectura.nextLine();
                System.out.println("Por último, escriba la cantidad que desea convertir desde la moneda base hacia la moneda destino: ");
                cantidad = Double.valueOf(lectura.nextLine());
                System.out.println(miExchangeRate.exchangeOverflow(cantidad, monedaBase, monedaDestino));
                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
            }

        } lectura.close();
    }
}
