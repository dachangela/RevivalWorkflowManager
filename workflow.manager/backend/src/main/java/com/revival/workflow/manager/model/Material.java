package com.revival.workflow.manager.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Material {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long totalQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    public Material() {
        // Default constructor
    }

    public Material(Long id, String name, long totalQuantity, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.createdAt = createdAt;
        this.lastUpdated = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        lastUpdated = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
