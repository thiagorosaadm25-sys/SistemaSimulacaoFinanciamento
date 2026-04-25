package main;

import modelo.*;
import util.UserInterface;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        boolean running;

        // Loop principal da aplicação
        do {
            List<Financing> financingList = new ArrayList<>();
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

            // Entrada de Dados
            RegisterFinancing(ui, financingList);

            // Variáveis de Acúmulo
            double totalPropertiesAll = 0;
            double totalFinancedAll = 0;
            double sumHouse = 0, sumApt = 0, sumLand = 0;
            int countHouse = 0, countApt = 0, countLand = 0;

            System.out.println("\n===== DETALHAMENTO DOS ITENS =====");

            // Processamento
            for (Financing f : financingList) {
                double propVal = f.getPropertyValue();
                double totalPay = f.calculateTotalPayment();
                totalPropertiesAll += propVal;
                totalFinancedAll += totalPay;

            // Identificar por tipo
                String tipoLabel = "";
                switch (f) {
                    case House house -> {
                        countHouse++;
                        sumHouse += totalPay;
                        tipoLabel = "[CASA]";
                    }
                    case Apartment apartment -> {
                        countApt++;
                        sumApt += totalPay;
                        tipoLabel = "[APARTAMENTO]";
                    }
                    case Land land -> {
                        countLand++;
                        sumLand += totalPay;
                        tipoLabel = "[TERRENO]";
                    }
                    default -> {
                    }
                }

                System.out.printf("%-15s Imóvel: %s | Total c/ Juros: %s%n",
                        tipoLabel, nf.format(propVal), nf.format(totalPay));
            }

            // Exibição dos Relatórios Consolidados
            displayReports(nf, countHouse, sumHouse, countApt, sumApt, countLand, sumLand, totalPropertiesAll, totalFinancedAll);

            // Reinicialização
            running = ui.askForNewSimulation();

            if (running) {
                System.out.println("\n\nLimpando dados e reiniciando simulador...");
            }

        } while (running);

        System.out.println("\nObrigado por utilizar o sistema T-Analytics. Simulação encerrada.");
    }

    // Metodo auxiliar para organizar o cadastro
    private static void RegisterFinancing(UserInterface ui, List<Financing> list) {
        // Cadastro Manual (1/5)
        int type = ui.askPropertyType();
        double v = ui.askPropertyValue();
        double t = ui.askFinancingTerm();
        double r = ui.askInterestRate();

        if (type == 1) list.add(new House(v, t, r));
        else if (type == 2) list.add(new Apartment(v, t, r));
        else list.add(new Land(v, t, r));

        // Cadastro Automático para completar a regra de negócio
        while (list.stream().filter(f -> f instanceof House).count() < 2) {
            list.add(new House(500000, 10, 10));
        }
        // Adiciona Apartamentos se faltar
        while (list.stream().filter(f -> f instanceof Apartment).count() < 2) {
            list.add(new Apartment(500000, 10, 10));
        }
        // Adiciona Terreno se faltar
        while (list.stream().noneMatch(f -> f instanceof Land)) {
            list.add(new Land(500000, 10, 10));
        }
    }

    private static void displayReports(NumberFormat nf, int cH, double sH, int cA, double sA, int cL, double sL, double tProp, double tFin) {
        System.out.println("\n===== RESUMO POR CATEGORIA =====");
        System.out.printf("Casas (%d): %15s%n", cH, nf.format(sH));
        System.out.printf("Apartamentos (%d): %15s%n", cA, nf.format(sA));
        System.out.printf("Terrenos (%d): %15s%n", cL, nf.format(sL));

        double totalOnlyInterest = tFin - tProp;

        System.out.println("\n==================================================");
        System.out.println("          BALANÇO ANALÍTICO DO PORTFÓLIO          ");
        System.out.println("==================================================");
        System.out.printf("VALOR TOTAL DOS IMÓVEIS (SEM JUROS):    %s%n", nf.format(tProp));
        System.out.printf("VALOR TOTAL DOS JUROS ACUMULADOS:       %s%n", nf.format(totalOnlyInterest));
        System.out.printf("VALOR TOTAL FINAL (MONTANTE):           %s%n", nf.format(tFin));
        System.out.println("==================================================");
    }
}