package main;

import modelo.Financing;
import util.UserInterface;

public class Main {
    public static void main(String[] args) {

        // Instanciar a interface de usuário
        UserInterface ui = new UserInterface();

        // Coletar os dados validados
        double value = ui.askPropertyValue();
        double term = ui.askFinancingTerm();
        double rate = ui.askInterestRate();

        // Instanciar o objeto de financiamento
        Financing currentFinancing = new Financing(value, term, rate);

        // Saída dos resultados
        System.out.println("\n--- RESUMO DO FINANCIAMENTO ---");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", currentFinancing.getPropertyValue());
        System.out.printf("Parcela Mensal: R$ %.2f%n", currentFinancing.calculateMonthlyPayment());
        System.out.printf("Valor Total: R$ %.2f%n", currentFinancing.calculateTotalPayment());
        System.out.println("-------------------------------");
    }
}