package org.example;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class WarehouseData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String warehouseID;
    private String warehouseName;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productData;

    public WarehouseData() {}

    public WarehouseData(String warehouseID, String warehouseName, String warehouseAddress,
                         String warehousePostalCode, String warehouseCity,
                         String warehouseCountry, LocalDateTime timestamp) {
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        this.warehouseAddress = warehouseAddress;
        this.warehousePostalCode = warehousePostalCode;
        this.warehouseCity = warehouseCity;
        this.warehouseCountry = warehouseCountry;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Product> getProductData() {
        return productData;
    }

    public void setProductData(List<Product> productData) {
        this.productData = productData;
    }
}
