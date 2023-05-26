package tokobaju;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ProductView extends JFrame {

    private JTable table;
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField customerNameField; // Variabel customerNameField
    private JTextField totalAmountField; // Variabel totalAmountField
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton sellButton;

    private ProductController controller;
    public ProductView() {
        setTitle("Product Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Form
         JPanel formPanel = new JPanel(new GridLayout(7, 2)); // Menambahkan 2 baris untuk customerName dan totalAmount
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        formPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        formPanel.add(priceField);
        formPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        formPanel.add(quantityField);
        formPanel.add(new JLabel("Customer Name:")); // Label untuk customerName
        customerNameField = new JTextField(); // TextField untuk customerName
        formPanel.add(customerNameField);
        formPanel.add(new JLabel("Total Amount:")); // Label untuk totalAmount
        totalAmountField = new JTextField(); // TextField untuk totalAmount
        formPanel.add(totalAmountField);

        // Buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        sellButton = new JButton("Sell");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sellButton);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }
    
    public JPanel getMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Price:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(quantityField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sellButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }
    
    public JButton getAddButton() {
        return addButton;
    }
    
    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public JButton getSellButton() {
        return sellButton;
    }
    
    public String getCustomerName() {
        return customerNameField.getText();
    }

    public List<Product> getSelectedProducts() {
        List<Product> selectedProducts = new ArrayList<>();
        int[] selectedRows = table.getSelectedRows();
        ProductTableModel model = (ProductTableModel) table.getModel();
        for (int selectedRow : selectedRows) {
            Product product = model.getProductAt(selectedRow);
            selectedProducts.add(product);
        }
        return selectedProducts;
    }

    public double getTotalAmount() {
        String totalAmountText = totalAmountField.getText();
        return Double.parseDouble(totalAmountText);
    }
    
    public void setController(ProductController controller) {
        this.controller = controller;
        addButton.addActionListener(controller);
        updateButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        sellButton.addActionListener(controller);
        table.getSelectionModel().addListSelectionListener(controller);
    }

    public void displayProducts(List<Product> productList) {
        ProductTableModel model = new ProductTableModel(productList);
        table.setModel(model);
    }

    public Product getProductFromForm() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        boolean isAvailable = true;

        return new Product(id, name, price, quantity, isAvailable);
    }

    public void clearForm() {
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    public void setFormFields(Product product) {
        idField.setText(String.valueOf(product.getId()));
        nameField.setText(product.getName());
        priceField.setText(String.valueOf(product.getPrice()));
        quantityField.setText(String.valueOf(product.getQuantity()));
    }

    public int getSelectedProductId() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            ProductTableModel model = (ProductTableModel) table.getModel();
            return model.getProductAt(selectedRow).getId();
        }
        return -1;
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

