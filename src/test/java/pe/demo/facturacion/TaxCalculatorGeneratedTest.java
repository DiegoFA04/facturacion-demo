package pe.demo.facturacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaxCalculatorGeneratedTest {

    @Test
    public void testCalculatePeru() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.calculate(100, "PE");
        assertEquals(18.0, result);
    }

    @Test
    public void testCalculateChile() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.calculate(100, "CL");
        assertEquals(19.0, result);
    }

    @Test
    public void testCalculateColombia() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.calculate(100, "CO");
        assertEquals(19.0, result);
    }

    @Test
    public void testCalculateMexico() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.calculate(100, "MX");
        assertEquals(16.0, result);
    }

    @Test
    public void testCalculateUnknownCountry() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.calculate(100, "US");
        assertEquals(0.0, result);
    }

    @Test
    public void testApplyDiscount() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.applyDiscount(100, 10);
        assertEquals(90.0, result);
    }

    @Test
    public void testApplyDiscountZeroPercent() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.applyDiscount(100, 0);
        assertEquals(100.0, result);
    }

    @Test
    public void testApplyDiscountNegativePercent() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.applyDiscount(100, -10);
        assertEquals(100.0, result);
    }

    @Test
    public void testRoundMoney() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.roundMoney(123.456);
        assertEquals(123.46, result);
    }

    @Test
    public void testRoundMoneyZero() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.roundMoney(0.0);
        assertEquals(0.0, result);
    }

    @Test
    public void testRoundMoneyNegative() {
        TaxCalculator calculator = new TaxCalculator();
        double result = calculator.roundMoney(-123.456);
        assertEquals(-123.46, result);
    }
}
