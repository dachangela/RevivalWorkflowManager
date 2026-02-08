package com.revival.workflow.manager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revival.workflow.manager.exception.ProductNotFoundException;
import com.revival.workflow.manager.model.Product;
import com.revival.workflow.manager.model.WorkflowStep;
import com.revival.workflow.manager.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired 
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getProducts() {
        return productService.getAllProducts(); // Fetch all products from the database
    }

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id); // Fetch product by ID from the database
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name); // Fetch product by name from the database
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        
        return productService.createProduct(product);
    }

    @PostMapping("/addworkflowstep/{productId}")
    public Product addWorkflowStepToProduct(@PathVariable Long productId, @RequestBody WorkflowStep workflowStep) {
        return productService.addWorkflowStepToProduct(productId, workflowStep);
    }
}