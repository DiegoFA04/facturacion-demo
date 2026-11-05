package pe.demo.facturacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaxCalculatorTest {

    @Test
    void shouldChargeEighteenPercentInPeru() {
        assertEquals(18.0, new TaxCalculator().calculate(100, "PE"), 0.001);
    }
}
