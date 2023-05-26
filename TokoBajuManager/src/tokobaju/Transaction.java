package tokobaju;

import java.util.List;

public class Transaction {
    private int id;
    private String customerName;
    private List<Product> products;
    private double totalAmount;

    public Transaction(int id, String customerName, List<Product> products, double totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
