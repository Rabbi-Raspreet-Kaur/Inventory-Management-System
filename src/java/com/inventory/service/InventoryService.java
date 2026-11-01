package com.inventory.service;

import com.inventory.dao.ProductDAO;
import com.inventory.models.Product;

import java.util.List;

public class InventoryService {
    private final ProductDAO productDAO;

    public InventoryService() {
        this.productDAO = new ProductDAO();
    }

    public void registerNewProduct(String sku, String name, String category, double price, int quantity, int supplierId) {
        Product product = new Product(0, sku, name, category, price, quantity, supplierId);
        productDAO.addProduct(product);
    }

    public void displayInventory() {
        List<Product> products = productDAO.getAllProducts();
        System.out.println("\n--- Current Inventory Status ---");
        if (products.isEmpty()) {
            System.out.println("No products found in inventory.");
        } else {
            for (Product p : products) {
                System.out.println(p.getDetails());
            }
        }
        System.out.println("--------------------------------\n");
    }

    public void updateItemStock(String sku, int newQuantity) {
        productDAO.updateStock(sku, newQuantity);
    }

    public void removeProductItem(String sku) {
        productDAO.deleteProduct(sku);
    }
}