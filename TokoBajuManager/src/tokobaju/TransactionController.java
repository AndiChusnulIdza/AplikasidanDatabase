package tokobaju;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransactionController {
    private TransactionView transactionView;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;
    private List<Product> selectedProducts;

    public TransactionController(TransactionView transactionView, ProductDAO productDAO, TransactionDAO transactionDAO) {
        this.transactionView = transactionView;
        this.productDAO = productDAO;
        this.transactionDAO = transactionDAO;
        this.selectedProducts = new ArrayList<>();

        // Menghubungkan TransactionController dengan TransactionView
        transactionView.setTransactionController(this);
    }

    public void addProduct(Product product) {
        selectedProducts.add(product);
        updateProductList();
        calculateTotalAmount();
    }

    public void removeProduct(Product product) {
        selectedProducts.remove(product);
        updateProductList();
        calculateTotalAmount();
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0.0;

        for (Product product : selectedProducts) {
            totalAmount += product.getPrice();
        }

        transactionView.setTotalAmount(totalAmount);
        return totalAmount;
    }

    public void addTransaction(String customerName, List<Product> products, double totalAmount) {
        // Buat objek Transaction dengan data yang diberikan
        Transaction transaction = new Transaction(0, customerName, products, totalAmount);


        // Simpan transaksi ke dalam database
        transactionDAO.addTransaction(transaction);

        // Menampilkan pesan sukses
        transactionView.clearFields();
        selectedProducts.clear();
        updateProductList();
        transactionView.displayProducts(selectedProducts);
        transactionView.setTotalAmount(0.0);
        JOptionPane.showMessageDialog(transactionView, "Transaction added successfully.");
    }

    private void updateProductList() {
        List<Product> availableProducts = productDAO.getAllProducts();
        List<Product> remainingProducts = new ArrayList<>(availableProducts);

        for (Product product : selectedProducts) {
            remainingProducts.remove(product);
        }

        transactionView.displayProducts(remainingProducts);
    }
}