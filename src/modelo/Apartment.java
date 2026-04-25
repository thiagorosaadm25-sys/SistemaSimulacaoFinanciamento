package modelo;

public class Apartment extends Financing {
    public Apartment(double value, double term, double rate) {
        super(value, term, rate);
    }

    @Override
    public double calculateMonthlyPayment() {
        // Juros Compostos: M = P * (1 + i)^n
        double monthlyRate = (this.interestRate / 100) / 12;
        double months = this.financingTerm * 12;

        double totalWithInterest = this.propertyValue * Math.pow(1 + monthlyRate, months);
        return totalWithInterest / months;
    }
}
