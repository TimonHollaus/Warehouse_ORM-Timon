package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewProduct(@RequestParam String productID,
                                              @RequestParam String productName,
                                              @RequestParam String productCategory,
                                              @RequestParam int productQuantity,
                                              @RequestParam String productUnit,
                                              @RequestParam Long warehouseId) {
        WarehouseData warehouse = warehouseRepository.findById(warehouseId).orElse(null);
        if (warehouse == null) {
            return "Warehouse not found";
        }

        Product product = new Product();
        product.setProductID(productID);
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setProductQuantity(productQuantity);
        product.setProductUnit(productUnit);
        product.setWarehouse(warehouse);

        productRepository.save(product);
        return "Product Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
