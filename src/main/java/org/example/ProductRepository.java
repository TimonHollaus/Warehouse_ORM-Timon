package org.example;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called productRepository
// CRUD refers to Create, Read, Update, Delete

public interface ProductRepository extends CrudRepository<Product, Long> {

}
