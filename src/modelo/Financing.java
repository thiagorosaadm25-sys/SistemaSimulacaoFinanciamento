package modelo;

public class Financing {
    // Atributos Privados
    private final double propertyValue;
    private final double financingTermYears;
    private final double annualInterestRate;

    // Construtor
    public Financing(double propertyValue, double financingTermYears, double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTermYears = financingTermYears;
        this.annualInterestRate = annualInterestRate;
    }
    // REGRAS DE NEGÓCIO
    // Métodos de Cálculo
    public double calculateMonthlyPayment() {
        return (this.propertyValue / (this.financingTermYears * 12)) * (1 + (this.annualInterestRate / 100 / 12));
    }

    public double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingTermYears * 12;
    }

    // Acesso controlado
    public double getPropertyValue() { return propertyValue; }

    // Exibição
    public void displayFinancingData() {
        System.out.printf("Property Value: R$ %.2f | Total: R$ %.2f%n",
                this.propertyValue, this.calculateTotalPayment());
    }
}