package com.inventory;

import com.inventory.service.InventoryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Object-Oriented Inventory & Management System ===");

        do {
            System.out.println("\n1. View Inventory");
            System.out.println("2. Add New Product");
            System.out.println("3. Update Product Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Supplier ID (1 or 2): ");
                    int supplierId = scanner.nextInt();
                    scanner.nextLine();

                    service.registerNewProduct(sku, name, category, price, qty, supplierId);
                    break;
                case 3:
                    System.out.print("Enter SKU of product to update: ");
                    String updateSku = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    scanner.nextLine();

                    service.updateItemStock(updateSku, newQty);
                    break;
                case 4:
                    System.out.print("Enter SKU of product to delete: ");
                    String deleteSku = scanner.nextLine();
                    service.removeProductItem(deleteSku);
                    break;
                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}