
import modelos.Conversion;
import modelos.CurrencyConversion;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n************** CONVERSOR DE MONEDAS **************\n");
            List<CurrencyConversion> currencies = Arrays.asList(
                    new CurrencyConversion("Pesos Mexicanos", "Dólares", "MXN", "USD"),
                    new CurrencyConversion("Dólares", "Pesos Mexicanos", "USD", "MXN"),
                    new CurrencyConversion("Pesos Argentinos", "Dólares", "ARS", "USD"),
                    new CurrencyConversion("Dólares", "Pesos Argentinos", "USD", "ARS"),
                    new CurrencyConversion("Pesos Colombianos", "Pesos Mexicanos", "COP", "MXN"),
                    new CurrencyConversion("Pesos Mexicanos", "Pesos Colombianos  ", "MXN", "COP")
            );

            for (int i = 0; i < currencies.size(); i++) {
                CurrencyConversion currentCurrency = currencies.get(i);
                System.out.printf("%d.- %s ==> %s%n", i + 1, currentCurrency.getBaseName(), currentCurrency.getTargetName());
            }
            int opcion = 1;
            boolean opcionValida = false;

            while (!opcionValida) {
                System.out.print("\nSelecciona una opcion: ");

                if (entrada.hasNextInt()) {
                    opcion = entrada.nextInt();

                    if (opcion > 0 && opcion <= currencies.size()) {
                        opcionValida = true;
                    } else {
                        System.out.println("Opción inválida. Seleccione un numero de la lista");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    entrada.next();
                }
            }
            double cantidad = 0;
            boolean cantidadValida = false;

            while (!cantidadValida) {
                System.out.print("Ingrese la cantidad a convertir: $");
                if (entrada.hasNextDouble()) {
                    cantidad = entrada.nextDouble();
                    if (cantidad >= 0) {
                        cantidadValida = true;
                    } else {
                        System.out.println("Cantidad inválida, ingrese un valor mayor o igual a 0.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor ingrese un número válido.");
                    entrada.next();
                }
            }
            CurrencyConversion selectedCurrency = currencies.get(opcion - 1);
            try {
                double resultado = Conversion.getConversion(selectedCurrency.getBaseCode(), selectedCurrency.getTargetCode(), cantidad);
                System.out.printf("%n$%.2f %s son $%.2f %s%n%n", cantidad, selectedCurrency.getBaseName(), resultado, selectedCurrency.getTargetName());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error trantando de hacer la conversión: " + e.getMessage());
            }
            System.out.print("¿Continuar? (y/n) ");
            String continuar = entrada.next();

            if (continuar.equals("n")) {
                break;
            }
        }
    }
}