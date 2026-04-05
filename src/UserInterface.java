import java.util.Scanner;
import java.util.Locale;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public double askPropertyValue() {
        System.out.print("Digite o valor do imóvel (use ponto para decimais, ex: 200000.00): ");
        return scanner.nextDouble();
    }

    public double askFinancingTerm() {
        System.out.print("Digite o prazo do financiamento em anos (ex: 3 ou 3.5): ");  // Usei double para aceitar anos quebrados, tipo 3.5 anos
        return scanner.nextDouble();
    }

    public double askInterestRate() {
        System.out.print("Digite a taxa de juros anual (ex: 10.5): ");
        return scanner.nextDouble();
    }
}