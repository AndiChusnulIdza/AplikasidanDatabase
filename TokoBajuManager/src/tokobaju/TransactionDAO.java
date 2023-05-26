package tokobaju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO() {
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokobaju", "root", "");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void addTransaction(Transaction transaction) {
        try {
            // Tambahkan transaksi ke tabel "transaction"
            PreparedStatement statement = connection.prepareStatement("INSERT INTO transaction (customer_name, total_amount) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, transaction.getCustomerName());
            statement.setDouble(2, transaction.getTotalAmount());
            statement.executeUpdate();

            // Dapatkan ID transaksi yang baru ditambahkan
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int transactionId = generatedKeys.getInt(1);
                transaction.setId(transactionId);

                // Tambahkan produk yang terkait dengan transaksi ke tabel "transaction_product"
                for (Product product : transaction.getProducts()) {
                    PreparedStatement productStatement = connection.prepareStatement("INSERT INTO transaction_product (transaction_id, product_id) VALUES (?, ?)");
                    productStatement.setInt(1, transactionId);
                    productStatement.setInt(2, product.getId());
                    productStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
