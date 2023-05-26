package tokobaju;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private List<Product> productList;
    private String[] columnNames = {"ID", "Name", "Price", "Quantity"};

    public ProductTableModel(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getPrice();
            case 3:
                return product.getQuantity();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Product getProductAt(int rowIndex) {
        return productList.get(rowIndex);
    }
}
