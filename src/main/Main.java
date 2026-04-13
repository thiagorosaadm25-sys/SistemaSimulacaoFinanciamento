package main;

import modelo.Financing;
import util.UserInterface;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        // Instanciar a interface de usuário
        UserInterface ui = new UserInterface();

        // Criar a lista para armazenar os financiamentos
        List<Financing> financingList = new ArrayList<>();

        // Loop
        boolean keepAdding = true;

        while (keepAdding) {
            int currentNumber = financingList.size() + 1;
            System.out.println("\n --- Cadastro do Financiamento #" + currentNumber + "---");

            // Coletar os dados validados
            double value = ui.askPropertyValue();
            double term = ui.askFinancingTerm();
            double rate = ui.askInterestRate();

            // Instancia e adiciona na lista
            financingList.add(new Financing(value, term, rate));

            // Mínimo de 4
            if (financingList.size() >=4){
                keepAdding = ui.askToContinue();
            } else {
                System.out.println("Atenção: Você deve cadastrar pelo menos 4 financiamentos. Faltam: " + (4- financingList.size()));
            }
        }

        // Variáveis para acumular os totais
        double totalProperties = 0;
        double totalFinancing = 0;

        // Formatador para moeda BR
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        System.out.println("\n--- RELATÓRIO FINAL ---");

        // Inicie o loop e percorrer a lista
        for (int i = 0; i < financingList.size(); i++) {
            Financing f = financingList.get(i);

            // Acumulando os totais
            totalProperties += f.getPropertyValue();
            totalFinancing += f.calculateTotalPayment();

            System.out.printf("Financiamento %d – valor do imóvel: %s | Valor do financiamento: %s%n",
                    (i + 1),
                    nf.format(f.getPropertyValue()),
                    nf.format(f.calculateTotalPayment()));
        }

        // Saída dos resultados
        System.out.println("\n========================================");
        System.out.printf("Total de todos os imóveis: %s%n", nf.format(totalProperties));
        System.out.printf("Total de todos os financiamentos: %s%n", nf.format(totalFinancing));
        System.out.println("========================================");
    }
}