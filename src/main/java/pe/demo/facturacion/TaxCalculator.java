package pe.demo.facturacion;

/** Impuestos y descuentos de una factura. Esta clase contiene métodos para calcular impuestos y aplicar descuentos. */
public class TaxCalculator {

    /**
     * Calcula el impuesto según el país.
     * 
     * @param amount El monto de la factura.
     * @param country El país de la factura.
     * @return El monto del impuesto.
     */
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

    /**
     * Aplica un descuento al monto.
     * 
     * @param amount El monto de la factura.
     * @param percent El porcentaje de descuento.
     * @return El monto con el descuento aplicado.
     */
    public double applyDiscount(double amount, int percent) {
        return amount - amount * percent / 100;
    }

    /**
     * Redondea el monto a dos decimales.
     * 
     * @param value El monto a redondear.
     * @return El monto redondeado.
     */
    public double roundMoney(double value) {
        return Math.round(value * 100) / 100;
    }
}
