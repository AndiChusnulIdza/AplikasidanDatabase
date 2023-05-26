package tokobaju;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TransactionView extends JPanel {
    private JTextField tfCustomerName;
    private JTextArea taProducts;
    private JTextField tfTotalAmount;
    private JButton btnAddTransaction;

    private TransactionController transactionController;

    public TransactionView() {
        setLayout(new BorderLayout());

        JLabel lblCustomerName = new JLabel("Customer Name:");
        tfCustomerName = new JTextField(20);

        JLabel lblProducts = new JLabel("Products:");
        taProducts = new JTextArea(10, 20);
        taProducts.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taProducts);

        JLabel lblTotalAmount = new JLabel("Total Amount:");
        tfTotalAmount = new JTextField(10);
        tfTotalAmount.setEditable(false);

        btnAddTransaction = new JButton("Add Transaction");

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(lblCustomerName);
        formPanel.add(tfCustomerName);
        formPanel.add(lblProducts);
        formPanel.add(scrollPane);
        formPanel.add(lblTotalAmount);
        formPanel.add(tfTotalAmount);
        formPanel.add(btnAddTransaction);

        add(formPanel, BorderLayout.CENTER);

        btnAddTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = tfCustomerName.getText();
                List<Product> products = transactionController.getSelectedProducts();
                double totalAmount = transactionController.calculateTotalAmount();

                transactionController.addTransaction(customerName, products, totalAmount);
            }
        });
    }

    public JPanel getMainPanel() {
        return this;
    }

    public void setTransactionController(TransactionController transactionController) {
        this.transactionController = transactionController;
    }

    public void clearFields() {
        tfCustomerName.setText("");
        taProducts.setText("");
        tfTotalAmount.setText("");
    }

    public void displayProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            sb.append(product.getName()).append("\n");
        }

        taProducts.setText(sb.toString());
    }

    public void setTotalAmount(double totalAmount) {
        tfTotalAmount.setText(String.valueOf(totalAmount));
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

