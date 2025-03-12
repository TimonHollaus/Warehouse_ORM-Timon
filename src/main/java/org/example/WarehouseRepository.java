package org.example;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called warehouseRepository
// CRUD refers to Create, Read, Update, Delete

public interface WarehouseRepository extends CrudRepository<WarehouseData, Long> {

}
