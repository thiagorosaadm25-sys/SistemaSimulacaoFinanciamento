/* TODO:
- Implementar blocos Try/Catch para lidar com InputMismatchException caso o usuário digite texto em vez de números.
- Validar se os valores de entrada são positivos (por exemplo, o valor da propriedade não pode ser zero ou negativo).
*/

public class Main {
    public static void main(String[] args) {

    // 1. Criar a instância da interface para lidar com as entradas
    UserInterface ui = new UserInterface();

    // 2. Coletar dados
    double value = ui.askPropertyValue();
    double term = ui.askFinancingTerm();
    double rate = ui.askInterestRate();

    // 3. Instanciar o objeto Financiamento com os dados coletados.
    Financing currentFinancing = new Financing(value, term, rate);

    // 4. Saídas dos resultados
    System.out.println("\n--- RESUMO DO FINANCIAMENTO ---");
    System.out.printf("Valor do Imóvel: R$ %.2f%n",currentFinancing.propertyValue);
    System.out.printf("Parcela Mensal: R$ %.2f%n",currentFinancing.calculateMonthlyPayment());
    System.out.printf("Valor Total: R$ %.2f%n",currentFinancing.calculateTotalPayment());
    }
}
