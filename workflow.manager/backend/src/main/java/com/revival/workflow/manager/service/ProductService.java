package com.revival.workflow.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revival.workflow.manager.exception.ProductNotFoundException;
import com.revival.workflow.manager.model.Product;
import com.revival.workflow.manager.model.WorkflowStep;
import com.revival.workflow.manager.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product addWorkflowStepToProduct(Long productId, WorkflowStep workflowStep) {
        Product product = getProductById(productId);
        workflowStep.setProduct(product);
        product.addWorkflowStep(workflowStep);
        return productRepository.save(product);
    }
}
