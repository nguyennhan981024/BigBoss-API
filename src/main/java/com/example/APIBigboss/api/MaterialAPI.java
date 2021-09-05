package com.example.APIBigboss.api;

import com.example.APIBigboss.models.InforCompany;
import com.example.APIBigboss.models.Material;
import com.example.APIBigboss.repository.InforCompanyRepository;
import com.example.APIBigboss.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/material")
public class MaterialAPI {
    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterial(){
        return ResponseEntity.ok(materialRepository.getAllMaterial());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createMaterial(@Valid @RequestBody Material material) {
        Material materialSaved = materialRepository.save(material);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(material.getId())
                .toUri();
        return ResponseEntity.created(location).body(materialSaved);
    }
}
