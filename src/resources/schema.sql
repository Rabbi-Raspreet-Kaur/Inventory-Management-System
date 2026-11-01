CREATE DATABASE IF NOT EXISTS inventory_db;
USE inventory_db;

CREATE TABLE IF NOT EXISTS suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id) ON DELETE SET NULL
);

INSERT INTO suppliers (name, contact_email, phone) VALUES 
('Acme Corp', 'support@acmecorp.com', '555-0192'),
('Global Tech', 'sales@globaltech.com', '555-8391');

INSERT INTO products (sku, name, category, price, quantity, supplier_id) VALUES 
('SKU-001', 'Wireless Mouse', 'Electronics', 25.99, 150, 1),
('SKU-002', 'Mechanical Keyboard', 'Electronics', 79.99, 60, 1);