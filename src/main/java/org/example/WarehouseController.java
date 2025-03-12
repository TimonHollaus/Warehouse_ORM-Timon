package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/warehouse") // URLs start with /warehouse
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewWarehouse(@RequestParam String warehouseID,
                                                @RequestParam String warehouseName,
                                                @RequestParam String warehouseAddress,
                                                @RequestParam String warehousePostalCode,
                                                @RequestParam String warehouseCity,
                                                @RequestParam String warehouseCountry) {
        WarehouseData warehouse = new WarehouseData();
        warehouse.setWarehouseID(warehouseID);
        warehouse.setWarehouseName(warehouseName);
        warehouse.setWarehouseAddress(warehouseAddress);
        warehouse.setWarehousePostalCode(warehousePostalCode);
        warehouse.setWarehouseCity(warehouseCity);
        warehouse.setWarehouseCountry(warehouseCountry);
        warehouseRepository.save(warehouse);
        return "Warehouse Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<WarehouseData> getAllWarehouses() {
        return warehouseRepository.findAll();
    }
}
