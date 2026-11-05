package pe.demo.facturacion;

import java.util.ArrayList;
import java.util.List;

/** Una factura de un cliente con sus líneas. */
public class Invoice {

    private final String id;
    private final String customer;
    private final List<InvoiceItem> items = new ArrayList<>();

    public Invoice(String id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void add(InvoiceItem item) {
        items.add(item);
    }
}
