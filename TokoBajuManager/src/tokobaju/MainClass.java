package tokobaju;

import javax.swing.*;
import java.awt.*;

public class MainClass {
    public static void main(String[] args) {
        // Membuat objek ProductDAO dan TransactionDAO
        ProductDAO productDAO = new ProductDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        // Membuat objek ProductView dan ProductController
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(productView, productDAO, transactionDAO);

        // Membuat objek TransactionView dan TransactionController
        TransactionView transactionView = new TransactionView();
        TransactionController transactionController = new TransactionController(transactionView, productDAO, transactionDAO);

        // Menghubungkan TransactionView dengan TransactionController
        transactionView.setTransactionController(transactionController);

        // Menampilkan tampilan produk dan transaksi dalam frame terpisah
        JFrame frame = new JFrame("Toko Baju Manager");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(productView.getMainPanel(), BorderLayout.WEST);
        frame.add(transactionView.getMainPanel(), BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}