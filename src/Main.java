import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarMoeadas apiClient = new ConsultarMoeadas();
        ConversorDeMoeadas converter = new ConversorDeMoeadas(apiClient);

        System.out.println("=== Conversor de Moedas ===");

        while (true) {
            try {
                System.out.print("\nDigite a moeda de origem (ex: USD): ");
                String fromCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Digite a moeda de destino (ex: BRL): ");
                String toCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Digite o valor a ser convertido (ou 0 para sair): ");
                double amount = scanner.nextDouble();

                if (amount == 0) {
                    System.out.println("Programa encerrado.");
                    break;
                }

                ConversionResult result = converter.convert(amount, fromCurrency, toCurrency);

                System.out.printf("\nValor original: %.2f %s\n", result.originalAmount(), result.fromCurrency());
                System.out.printf("Valor convertido: %.2f %s\n", result.convertedAmount(), result.toCurrency());
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
