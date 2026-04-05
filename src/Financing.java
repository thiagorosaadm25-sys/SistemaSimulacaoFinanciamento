public class Financing {
    // Atributos
    double propertyValue;
    double financingTermYears;
    double annualInterestRate;

    // Construtores
    public Financing(double propertyValue, double financingTermYears, double annualInterestRate) {
        this.propertyValue = propertyValue;
        this.financingTermYears = financingTermYears;
        this.annualInterestRate = annualInterestRate;
    }
    /// MÉTODOS
    // Calcular o pagamento mensal
    public double calculateMonthlyPayment() {
        return (this.propertyValue / (this.financingTermYears * 12)) * (1 + (this.annualInterestRate / 100 / 12));
    }

    // Calcular o pagamento total
    public double calculateTotalPayment() {
        return this.calculateMonthlyPayment() * this.financingTermYears * 12;
    }
}
