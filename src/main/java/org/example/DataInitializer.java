package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        // Erstellen von zwei Warehouse-Objekten
        WarehouseData warehouse1 = new WarehouseData();
        warehouse1.setWarehouseID("001");
        warehouse1.setWarehouseName("Linz Bahnhof");
        warehouse1.setWarehouseAddress("Bahnhofsstrasse 27/9");
        warehouse1.setWarehousePostalCode("4020");
        warehouse1.setWarehouseCity("Linz");
        warehouse1.setWarehouseCountry("Austria");

        WarehouseData warehouse2 = new WarehouseData();
        warehouse2.setWarehouseID("002");
        warehouse2.setWarehouseName("Wien Zentrale");
        warehouse2.setWarehouseAddress("Hauptstrasse 45");
        warehouse2.setWarehousePostalCode("1010");
        warehouse2.setWarehouseCity("Wien");
        warehouse2.setWarehouseCountry("Austria");

        // Warehouses speichern
        warehouseRepository.saveAll(Arrays.asList(warehouse1, warehouse2));

        // Erstellen von zehn Product-Objekten (5 pro Warehouse)
        List<Product> products = Arrays.asList(
                new Product("00-443175", "Bio Orangensaft Sonne", "Getränk", 2500, "Packung 1L", warehouse1),
                new Product("00-871895", "Bio Apfelsaft Gold", "Getränk", 3420, "Packung 1L", warehouse1),
                new Product("00-123456", "Mineralwasser Still", "Getränk", 5000, "Flasche 1L", warehouse1),
                new Product("00-654321", "Cola Zero", "Getränk", 3000, "Dose 0.5L", warehouse1),
                new Product("00-789012", "Tee Pfirsich", "Getränk", 2000, "Packung 1L", warehouse1),
                new Product("00-111222", "Bio Tomatensauce", "Lebensmittel", 1500, "Glas 500ml", warehouse2),
                new Product("00-333444", "Vollkorn Brot", "Lebensmittel", 1200, "Stück", warehouse2),
                new Product("00-555666", "Butter", "Milchprodukt", 1800, "Packung 250g", warehouse2),
                new Product("00-777888", "Käse Gouda", "Milchprodukt", 1600, "Packung 500g", warehouse2),
                new Product("00-999000", "Joghurt Natur", "Milchprodukt", 2000, "Becher 150g", warehouse2),
                new Product("5", "hallo", "Milchprodukt", 2000, "Becher 150g", warehouse2),
                new Product("5", "Abnahme Product!", "Milchprodukt", 2000, "Becher 150g", warehouse2)


        );

        // Produkte speichern
        productRepository.saveAll(products);

        System.out.println("Data initialization completed successfully!");
    }
}
