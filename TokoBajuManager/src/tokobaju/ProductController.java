package tokobaju;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProductController implements ActionListener, ListSelectionListener {
    private ProductView view;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;

    public ProductController(ProductView view, ProductDAO productDAO, TransactionDAO transactionDAO) {
        this.view = view;
        this.productDAO = productDAO;
        this.transactionDAO = transactionDAO;

        view.setController(this);
        updateProductTable();
    }

    private void updateProductTable() {
        List<Product> productList = productDAO.getAllProducts();
        view.displayProducts(productList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getAddButton()) {
            Product product = view.getProductFromForm();
            productDAO.addProduct(product);
            view.clearForm();
            updateProductTable();
        } else if (e.getSource() == view.getUpdateButton()) {
            Product product = view.getProductFromForm();
            productDAO.updateProduct(product);
            view.clearForm();
            updateProductTable();
        } else if (e.getSource() == view.getDeleteButton()) {
            int productId = view.getSelectedProductId();
            productDAO.deleteProduct(productId);
            view.clearForm();
            updateProductTable();
        } else if (e.getSource() == view.getSellButton()) {
            String customerName = view.getCustomerName();
            List<Product> selectedProducts = view.getSelectedProducts();
            double totalAmount = 0.0;

            for (Product product : selectedProducts) {
                totalAmount += product.getPrice();
            }

            Transaction transaction = new Transaction(0, customerName, selectedProducts, totalAmount);
            transactionDAO.addTransaction(transaction);

            // Proses transaksi penjualan, misalnya mengurangi jumlah stok produk yang terjual
            for (Product product : selectedProducts) {
                int quantitySold = product.getQuantity();
                product.setQuantity(product.getQuantity() - quantitySold);
                productDAO.updateProduct(product);
            }

            // Refresh tampilan setelah transaksi penjualan berhasil
            view.clearForm();
            updateProductTable();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedProductId = view.getSelectedProductId();
            if (selectedProductId != -1) {
                Product product = productDAO.getProductById(selectedProductId);
                view.setFormFields(product);
            }
        }
    }
}
