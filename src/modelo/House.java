package modelo;

public class House extends Financing {
    public House(double value, double term, double rate) {
        super(value, term, rate);
    }

    @Override
    public double calculateMonthlyPayment() {
        // Pegar o cálculo da classe pai e somar o seguro
        return super.calculateMonthlyPayment() + 80;
    }
}
