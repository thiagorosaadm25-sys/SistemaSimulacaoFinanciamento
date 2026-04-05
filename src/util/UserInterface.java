package util;

import java.util.Scanner;
import java.util.Locale;

public class UserInterface {
    // Atributos
    private final Scanner scanner;

    // Construtor
    public UserInterface() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    // ENTRADAS
    // Valor Imóvel
    public double askPropertyValue() {
        double value;
        do {
            System.out.print("Digite o valor do imóvel (ex: 250000.00): ");
            value = scanner.nextDouble();
            if (value <= 0) {
                System.out.println("Erro: O valor do imóvel deve ser positivo!");
            }
        } while (value <= 0);
        return value;
    }

    // Prazo do financiamento
    public double askFinancingTerm() {
        double term;
        do {
            System.out.print("Digite o prazo do financiamento em anos (ex: 30): ");
            term = scanner.nextDouble();
            if (term <= 0) {
                System.out.println("Erro: O prazo deve ser um número positivo!");
            }
        } while (term <= 0);
        return term;
    }

    // Taxa de juros (0 a 100%)
    public double askInterestRate() {
        double rate;
        do {
            System.out.print("Digite a taxa de juros anual (ex: 10.5): ");
            rate = scanner.nextDouble();
            if (rate < 0 || rate > 100) {
                System.out.println("Erro: A taxa de juros deve estar entre 0 e 100!");
            }
        } while (rate < 0 || rate > 100);
        return rate;
    }
}