
import modelos.Conversion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while(true){
            System.out.println("\n************** CONVERSOR DE MONEDAS **************\n");
            String[][] currencies = {
                    {"Pesos Mexicanos", "Dolares", "MXN", "USD"},
                    {"Dolares", "Pesos Mexicanos", "USD", "MXN"},
                    {"Pesos Argentinos", "Dolares", "ARS", "USD"},
                    {"Dolares", "Pesos Argentinos", "USD", "ARS"},
                    {"Pesos Colombianos", "Pesos Mexicanos", "COP", "MXN"},
                    {"Pesos Mexicanos", "Pesos Colombianos  ", "MXN", "COP"}
            };

            for(int i = 0; i<currencies.length; i++){
                System.out.printf("%d.- %s ==> %s%n", i+1, currencies[i][0], currencies[i][1]);
            }
            int opcion;

            while(true){
                System.out.print("\nSelecciona una opcion: ");
                opcion = entrada.nextInt();
                if(opcion <= 0 || opcion > currencies.length){
                    System.out.println("Opcion Invalida");
                    continue;
                }
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: $");
            double cantidad = entrada.nextDouble();
            String[] selectedCurrency = currencies[opcion-1];
            try {
                double resultado = Conversion.getConversion(selectedCurrency[2], selectedCurrency[3], cantidad);
                System.out.printf("$%.2f %s son $%.2f %s%n",cantidad, selectedCurrency[0], resultado, selectedCurrency[1]);
            } catch (Exception e){
                System.out.println("Ha ocurrido un error trantando de hacer la conversión: " + e.getMessage());
            }
            System.out.print("¿Continuar? (y/n)");
            String continuar = entrada.next();

            if(continuar.equals("n")){
                break;
            }
        }


    }
}