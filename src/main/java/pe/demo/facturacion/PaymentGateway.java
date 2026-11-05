package pe.demo.facturacion;

/** Cobra una factura en la pasarela de pagos. */
public class PaymentGateway {

    private static final String API_URL = "https://pagos.example.com/charge";
    private static final String PASSWORD = "demo-password-123";

    public boolean charge(String customer, double amount) {
        System.out.println("Cobrando " + amount + " a " + customer + " en " + API_URL);
        return authenticate(PASSWORD) && amount > 0;
    }

    private boolean authenticate(String password) {
        return password != null && !password.isEmpty();
    }
}
