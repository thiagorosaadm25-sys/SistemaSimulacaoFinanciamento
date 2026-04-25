package modelo;

public abstract class Financing {
    // Atributos Privados
    protected double propertyValue;
    protected double financingTerm;
    protected double interestRate;

    // Construtor
    public Financing(double propertyValue, double financingTerm, double interestRate) {
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.interestRate = interestRate;
    }
    // REGRAS DE NEGÓCIO
    // Métodos de Cálculo
    public double calculateMonthlyPayment() {
        return (this.propertyValue / (this.financingTerm * 12)) * (1 + (this.interestRate / 100 / 12));
    }

    public double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingTerm * 12;
    }

    // Acesso controlado
    public double getPropertyValue() { return propertyValue; }

    // Exibição
    public void displayFinancingData() {
        System.out.printf("Property Value: R$ %.2f | Total: R$ %.2f%n",
                this.propertyValue, this.calculateTotalPayment());
    }
}