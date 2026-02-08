/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.revival.workflow.manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkflowStep {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private String description;
    private int stepOrder;

    @ManyToOne
    @JsonBackReference
    private Product product;
    public WorkflowStep() {
        // Default constructor
    }

    public WorkflowStep(Long id, String name, String description, int stepOrder, Product product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stepOrder = stepOrder;
        this.product = product;
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
    public int getStepOrder() {
        return stepOrder;
    }
    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
