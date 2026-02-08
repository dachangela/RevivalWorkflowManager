package com.revival.workflow.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private String description;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<WorkflowStep> workflowSteps;
    // private String imageUrl;

    public Product() {
        // Default constructor
    }

    public Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        // this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WorkflowStep> getWorkflowSteps() {
        return workflowSteps;
    }

    public void setWorkflowSteps(List<WorkflowStep> workflowSteps) {
        this.workflowSteps = workflowSteps;
    }

    public void addWorkflowStep(WorkflowStep step) {
        this.workflowSteps.add(step);
    }
    
}
