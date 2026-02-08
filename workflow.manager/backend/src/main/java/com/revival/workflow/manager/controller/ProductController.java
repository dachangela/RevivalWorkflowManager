package com.revival.workflow.manager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revival.workflow.manager.model.Product;
import com.revival.workflow.manager.model.WorkflowStep;
import com.revival.workflow.manager.service.ProductService;


/**
 * REST controller for managing product-related HTTP requests and responses.
 * 
 * This controller handles CRUD operations for products and workflow step management.
 * All endpoints are prefixed with "/api/products".
 * 
 * @author [Dylan Changela]
 * @version 1.0
 * @since [02-08-2026]
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /**
     * Service for managing product-related business logic and operations.
     * This field is automatically injected by Spring's dependency injection container.
     */
    @Autowired 
    private ProductService productService;

    /**
     * Retrieves all products from the database.
     *
     * @return a {@link List} of {@link Product} objects containing all products in the database
     */
    @GetMapping("/")
    public List<Product> getProducts() {
        return productService.getAllProducts(); // Fetch all products from the database
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id the unique identifier of the product to retrieve
     * @return the Product object corresponding to the given id
     */
    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id); // Fetch product by ID from the database
    }

    /**
     * Retrieves a list of products by their name.
     *
     * @param name the name of the products to retrieve
     * @return a list of products matching the specified name
     */
    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name); // Fetch products by name from the database
    }

    /**
     * Creates a new product and saves it to the database.
     *
     * @param product the {@link Product} object containing the product details to be created
     * @return the created {@link Product} object with the generated ID from the database
     */
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        
        return productService.addProduct(product); // Save the new product to the database
    }

    /**
     * Adds a workflow step to a product.
     *
     * @param productId the ID of the product to which the workflow step will be added
     * @param workflowStep the workflow step to be added to the product
     * @return the updated Product object with the new workflow step added
     */
    @PostMapping("/addworkflowstep/{productId}")
    public Product addWorkflowStepToProduct(@PathVariable Long productId, @RequestBody WorkflowStep workflowStep) {
        return productService.addWorkflowStepToProduct(productId, workflowStep); // Add a workflow step to the specified product and save it to the database
    }

    /**
     * Removes a product from the database by its ID.
     *
     * @param id the ID of the product to be removed
     * @return void
     */
    @PostMapping("/remove/{id}") 
    public void removeProduct(@PathVariable Long id) {
        productService.removeProduct(id); // Remove the product with the specified ID from the database
    }
}