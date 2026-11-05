package pe.demo.facturacion;

/** Impuestos y descuentos de una factura. */
public class TaxCalculator {

    public double calculate(double amount, String country) {
        if (country.equals("PE")) {
            return amount * 0.18;
        } else if (country.equals("CL")) {
            return amount * 0.19;
        } else if (country.equals("CO")) {
            return amount * 0.19;
        } else if (country.equals("MX")) {
            return amount * 0.16;
        }
        return 0;
    }

    public double applyDiscount(double amount, int percent) {
        return amount - amount * percent / 100;
    }

    public double roundMoney(double value) {
        return Math.round(value * 100) / 100;
    }
}
