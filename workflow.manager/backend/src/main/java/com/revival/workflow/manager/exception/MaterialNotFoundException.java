package com.revival.workflow.manager.exception;

public class MaterialNotFoundException extends RuntimeException {
    public MaterialNotFoundException(String msg) { super(msg); }
    public MaterialNotFoundException(Long id) { super("Material not found with id: " + id); }
    public MaterialNotFoundException(String field, String value) { super("Material not found with " + field + ": " + value); }
    
}
