package modelo;

public class Land extends Financing {
    public Land(double value, double term, double rate) {
        super(value, term, rate);
    }

    @Override
    public double calculateMonthlyPayment() {
        return super.calculateMonthlyPayment() * 1.02;
    }
}
