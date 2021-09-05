package com.example.APIBigboss.api;

import com.example.APIBigboss.models.District;
import com.example.APIBigboss.models.Ward;
import com.example.APIBigboss.repository.DistrictRepository;
import com.example.APIBigboss.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ward")
public class WardAPI {
    @Autowired
    private WardRepository wardRepository;

    @GetMapping
    public ResponseEntity<List<Ward>> getAllWard(){
        return ResponseEntity.ok(wardRepository.getAllWard());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createWard(@Valid @RequestBody Ward ward) {
        Ward wardSaved = wardRepository.save(ward);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ward.getId())
                .toUri();
        return ResponseEntity.created(location).body(wardSaved);
    }
}
