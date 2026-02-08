package com.revival.workflow.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revival.workflow.manager.model.Material;
import com.revival.workflow.manager.service.MaterialService;


@RestController
@RequestMapping("/api/materials")
public class MaterialController {
    
    @Autowired
    private MaterialService materialService;

    @GetMapping("/")
    public List<Material> getMaterials() {
        return materialService.getAllMaterials();
    }

    @GetMapping("/id/{id}")
    public Material getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id);
    }

    @PostMapping
    public Material addMaterial(@RequestBody Material material) {
        return materialService.addMaterial(material);
    }


    @PostMapping("/remove/{id}")
    public void removeMaterial(@PathVariable Long id) {
        materialService.removeMaterial(id);
    }
    
}
