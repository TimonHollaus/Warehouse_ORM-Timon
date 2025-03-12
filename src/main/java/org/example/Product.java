package org.example;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseData warehouse;

    public Product() {}

    public Product(String productID, String productName, String productCategory,
                   int productQuantity, String productUnit, WarehouseData warehouse) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
        this.warehouse = warehouse;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public WarehouseData getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseData warehouse) {
        this.warehouse = warehouse;
    }
}
