package com.revival.workflow.manager.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Material {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long totalQuantity;
    private Date createdAt;
    private Date lastUpdated;

    public Material() {
        // Default constructor
    }

    public Material(Long id, String name, long totalQuantity, Date createdAt) {
        this.id = id;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.createdAt = createdAt;
        this.lastUpdated = createdAt;
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
    public long getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
