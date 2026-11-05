package pe.demo.facturacion;

/** Calcula el total de una factura y la guarda. */
public class InvoiceService {

    private final TaxCalculator taxCalculator = new TaxCalculator();
    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public double process(Invoice invoice, String country, String customerType) {
        double total = 0;
        for (InvoiceItem item : invoice.getItems()) {
            if (item != null) {
                if (item.getQuantity() > 0) {
                    if (item.getPrice() > 0) {
                        double line = item.getQuantity() * item.getPrice();
                        if (customerType.equals("VIP")) {
                            line = line - line * 15 / 100;
                        } else if (customerType.equals("REGULAR")) {
                            if (line > 1000) {
                                line = line - line * 5 / 100;
                            }
                        } else if (customerType.equals("NEW")) {
                            line = line - line * 10 / 100;
                        }
                        total = total + line;
                    }
                }
            }
        }
        double tax = taxCalculator.calculate(total, country);
        total = total + tax;
        if (total > 5000) {
            System.out.println("Factura grande: " + invoice.getId());
        }
        try {
            repository.save(invoice, total);
        } catch (Exception e) {
        }
        return total;
    }

    public double preview(Invoice invoice, String customerType) {
        double total = 0;
        for (InvoiceItem item : invoice.getItems()) {
            if (item != null && item.getQuantity() > 0 && item.getPrice() > 0) {
                double line = item.getQuantity() * item.getPrice();
                if (customerType.equals("VIP")) {
                    line = line - line * 15 / 100;
                } else if (customerType.equals("REGULAR")) {
                    if (line > 1000) {
                        line = line - line * 5 / 100;
                    }
                } else if (customerType.equals("NEW")) {
                    line = line - line * 10 / 100;
                }
                total = total + line;
            }
        }
        return total;
    }
}
