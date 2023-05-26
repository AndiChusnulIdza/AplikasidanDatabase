package tokobaju;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokobaju", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int productId) {
        Product product = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                boolean status = resultSet.getBoolean("status");

                product = new Product(id, name, price, quantity, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product WHERE status = 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                boolean status = resultSet.getBoolean("status");

                Product product = new Product(id, name, price, quantity, status);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO product (name, price, quantity, status) VALUES (?, ?, ?, ?)");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setBoolean(4, product.isStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE product SET name = ?, price = ?, quantity = ?, status = ? WHERE id = ?");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setBoolean(4, product.isStatus());
            statement.setInt(5, product.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE product SET status = 0 WHERE id = ?");
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
