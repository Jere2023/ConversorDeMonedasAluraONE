import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elije la opcción deseada: ");
        int opcion = Integer.valueOf(lectura.nextLine());;
        ConsultarCambio consulta = new ConsultarCambio();

        while (opcion != 9) {
            double cantidad;

            if(opcion == 1) { // De ARS a USD
                System.out.println("Intoduzca la cantidad que desea convertir a USD: ");
                cantidad = Double.valueOf(lectura.nextLine());
                Consulta nuevaConsulta = consulta.consultar("ARS", "USD", cantidad);
                System.out.println(nuevaConsulta);
                System.out.println("Elije la opcción deseada: ");
                opcion = Integer.valueOf(lectura.nextLine());
            } else if (opcion == 2) { // De USD a ARS

            } else if (opcion == 3) { // De ARS a EUR

            } else if (opcion == 4) { // De EUR a ARS

            }
        }
    }
}
