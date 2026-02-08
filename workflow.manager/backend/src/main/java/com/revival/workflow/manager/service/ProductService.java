package com.revival.workflow.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revival.workflow.manager.exception.ProductNotFoundException;
import com.revival.workflow.manager.model.Product;
import com.revival.workflow.manager.model.WorkflowStep;
import com.revival.workflow.manager.repository.ProductRepository;

/**
 * Service class for managing Product entities and their operations.
 * 
 * This service provides business logic for CRUD operations on products,
 * as well as workflow step management for products.
 */
@Service
public class ProductService {
    
    /**
     * Repository for managing Product entities and performing database operations.
     * This is injected by Spring and provides CRUD operations and custom queries
     * for Product data persistence and retrieval.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all {@link Product} objects stored in the repository
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id the unique identifier of the product to retrieve
     * @return the Product object associated with the given ID
     * @throws ProductNotFoundException if no product is found with the specified ID
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    /**
     * Retrieves a list of products that contain the specified name (case-insensitive).
     *
     * @param name the product name or partial name to search for (case-insensitive)
     * @return a list of products whose names contain the specified name;
     *         returns an empty list if no products match the criteria
     */
    public List<Product> getProductsByName(String name) {
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    /**
     * Creates and saves a new product to the repository.
     *
     * @param product the Product object to be created and saved
     * @return the saved Product object with any generated identifiers or default values
     */
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Adds a workflow step to a product.
     *
     * @param productId the ID of the product to which the workflow step will be added
     * @param workflowStep the workflow step to add to the product
     * @return the updated product with the new workflow step added
     * @throws ProductNotFoundException if the product with the given ID is not found
     */
    public Product addWorkflowStepToProduct(Long productId, WorkflowStep workflowStep) {
        Product product = getProductById(productId);
        workflowStep.setProduct(product);
        product.addWorkflowStep(workflowStep);
        return productRepository.save(product);
    }

    /**
     * Removes a product from the repository by its ID.
     *
     * @param id the ID of the product to remove
     * @throws ProductNotFoundException if no product exists with the given ID
     */
    public void removeProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
