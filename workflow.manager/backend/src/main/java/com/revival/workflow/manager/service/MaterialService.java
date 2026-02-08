package com.revival.workflow.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revival.workflow.manager.exception.MaterialNotFoundException;
import com.revival.workflow.manager.model.Material;
import com.revival.workflow.manager.repository.MaterialRepository;

/**
 * Service class for managing Material entities.
 * 
 * Provides business logic for CRUD operations on materials, including
 * retrieving, creating, and removing materials from the repository.
 */
@Service
public class MaterialService {
    
    /**
     * Repository for accessing and managing Material entities in the database.
     * Provides CRUD operations and custom queries for Material objects.
     */
    @Autowired
    private MaterialRepository materialRepository;

    /**
     * Retrieves all materials from the repository.
     *
     * @return a list of all {@link Material} objects stored in the database
     */
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    /**
     * Retrieves a material by its unique identifier.
     *
     * @param id the unique identifier of the material to retrieve
     * @return the {@link Material} object with the specified id, or null if no material is found
     */
    public Material getMaterialById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a list of materials whose names contain the specified string, ignoring case sensitivity.
     *
     * @param name the partial or full name of the material to search for (case-insensitive)
     * @return a list of {@link Material} objects whose names contain the provided name string;
     *         returns an empty list if no materials are found
     */
    public List<Material> getMaterialsByName(String name) {
        return materialRepository.findAllByNameContainingIgnoreCase(name);
    }

    /**
     * Creates and saves a new material to the repository.
     *
     * @param material the Material object to be created and saved
     * @return the saved Material object with any generated identifiers or default values
     */
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    /**
     * Removes a material from the repository by its ID.
     *
     * @param id the ID of the material to remove
     * @throws MaterialNotFoundException if no material exists with the given ID
     */
    public void removeMaterial(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new MaterialNotFoundException(id);
        }
        materialRepository.deleteById(id);
    }
}
