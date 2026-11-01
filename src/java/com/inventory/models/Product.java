package com.inventory.models;

public class Product extends Item {
    private String sku;
    private String category;
    private int quantity;
    private int supplierId;

    public Product(int id, String sku, String name, String category, double price, int quantity, int supplierId) {
        super(id, name, price);
        this.sku = sku;
        this.category = category;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    @Override
    public String getDetails() {
        return String.format("Product[%s]: %s | Category: %s | Price: $%.2f | Stock: %d units", 
                sku, name, category, price, quantity);
    }

    @Override
    public String toString() {
        return getDetails();
    }
}