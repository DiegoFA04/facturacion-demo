package pe.demo.facturacion;

/** Una línea de factura: cuántas unidades de algo y a qué precio. */
public class InvoiceItem {

    private final String description;
    private final int quantity;
    private final double price;

    public InvoiceItem(String description, int quantity, double price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
