package com.revival.workflow.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revival.workflow.manager.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    // Define methods for CRUD operations on Material entities
    Material findByName(String name); // Find materials by name
    List<Material> findAllByNameContainingIgnoreCase(String keyword); // Find materials by name containing a keyword (case-insensitive)
}
