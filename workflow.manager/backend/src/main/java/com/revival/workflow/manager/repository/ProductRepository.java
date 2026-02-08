package com.revival.workflow.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revival.workflow.manager.model.Product;

@Repository // This annotation indicates that this class is a Spring Data repository and will be used to interact with the database.
// The repository will be responsible for performing CRUD operations on Product entities.
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Define methods for CRUD operations on Product entities
    // For example:
    // Removed the conflicting findById(Long id) method to use the inherited method from CrudRepository.
    Product findByName(String name); // Example method to find products by name
    List<Product> findByNameContainingIgnoreCase(String keyword); // Example method to find products by name containing a keyword (case-insensitive)
}
