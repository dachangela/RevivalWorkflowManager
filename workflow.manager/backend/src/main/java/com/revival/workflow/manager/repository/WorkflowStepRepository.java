package com.revival.workflow.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revival.workflow.manager.model.WorkflowStep;
@Repository // This annotation indicates that this class is a Spring Data repository and will be used to interact with the database.
// The repository will be responsible for performing CRUD operations on WorkflowStep entities.
public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Long> {
    // Define methods for CRUD operations on WorkflowStep entities
    // For example:
    // Removed the conflicting findById(Long id) method to use the inherited method from CrudRepository.
    // WorkflowStepRepository findByName(String name); // Example method to find WorkflowSteps by name
    // List<WorkflowStepRepository> findByNameContainingIgnoreCase(String keyword); // Example method to find WorkflowSteps by name containing a keyword (case-insensitive)
}
