package pe.demo.facturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Guarda y consulta facturas en la base de datos. */
public class InvoiceRepository {

    private final String url;

    public InvoiceRepository(String url) {
        this.url = url;
    }

    public List<String> findByCustomer(String customer) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rows = statement.executeQuery("SELECT id FROM invoices WHERE customer = '" + customer + "'");
        List<String> ids = new ArrayList<>();
        while (rows.next()) {
            ids.add(rows.getString("id"));
        }
        return ids;
    }

    public void save(Invoice invoice, double total) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        connection.createStatement().executeUpdate("INSERT INTO invoices (id, customer, total) VALUES ('"
                + invoice.getId() + "', '" + invoice.getCustomer() + "', " + total + ")");
    }

    // Pruebas unitarias
    public static void main(String[] args) {
        try {
            InvoiceRepository repo = new InvoiceRepository("jdbc:mysql://localhost:3306/facturacion");

            // Prueba de findByCustomer
            List<String> ids = repo.findByCustomer("John Doe");
            System.out.println("IDs encontrados: " + ids);

            // Prueba de save
            Invoice invoice = new Invoice("INV123", "Jane Doe");
            repo.save(invoice, 150.0);
            System.out.println("Factura guardada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
