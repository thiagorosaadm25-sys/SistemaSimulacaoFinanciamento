package util;

import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class UserInterface {
    // Constante para limitar as tentativas após erros de entradas
    private static final int MAX_ATTEMPTS = 3;

    // Atributos
    private final Scanner scanner;
    // Taxa Padrão
    private static final double DEFAULT_INTEREST_RATE = 11.5;

    // Construtor
    public UserInterface() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    // ENTRADAS
    // Valor Imóvel
    public double askPropertyValue() {
        double value;
        do {
            value = readDoubleWithRetry("Digite o valor do imóvel (ex: 250000.00): ");
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
            term = readDoubleWithRetry("Digite o prazo do financiamento em anos (30 ou 30.5): ");
            if (term <= 0) {
                System.out.println("Erro: O prazo deve ser um número positivo!");
            }
        } while (term <= 0);
        return term;
    }

    // Taxa de juros (0 a 100%)
    public double askInterestRate() {
        System.out.println("Taxa padrão SBPE: " + DEFAULT_INTEREST_RATE + "%.");
        double rate = readDoubleWithRetry("Digite a taxa de juros anual (ou 0 para usar o padrão):");
        if (rate <= 0) {
            System.out.println("Aplicando taxa padrão de " + DEFAULT_INTEREST_RATE + "%.");
            return DEFAULT_INTEREST_RATE;
        }

        if (rate > 100) {
            System.out.println("ERRO: Taxa acima de 100%! Tente Novamente.");
            return askInterestRate();
        }
        return rate;
    }

    public boolean askToContinue() {
        System.out.print("\nDeseja adicionar outro financiamento? (S/N):");
        String response = scanner.next().trim().toUpperCase();
        return  response.startsWith("S");

    }
    private double readDoubleWithRetry(String prompt) {
        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                attempts++;
                scanner.nextLine();
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("ERRO: Entrada inválida. Use PONTO (.) para decimais. Tentativas restantes: "+ (MAX_ATTEMPTS - attempts));
                }
            }
        }
        // Encerrar o programa se acabar as tentativas
        System.err.println("\n [ERRO FATAL] Limite de tentativvas excedido. Reinicie a aplicação.");
        System.exit(0);
        return 0;
    }
}