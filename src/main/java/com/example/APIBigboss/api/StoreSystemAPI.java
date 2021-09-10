package com.example.APIBigboss.api;

import com.example.APIBigboss.models.News;
import com.example.APIBigboss.models.StoreSystem;
import com.example.APIBigboss.repository.NewsRepository;
import com.example.APIBigboss.repository.StoreSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/store-system")
public class StoreSystemAPI {
  
     @Autowired
    private StoreSystemRepository storeSystemRepository;

    @GetMapping
    public ResponseEntity<List<StoreSystem>> getAllStoreSystem(){
        return ResponseEntity.ok(storeSystemRepository.getAllStoreSystem());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createStoreSystem(@Valid @RequestBody StoreSystem storeSystem) {
        StoreSystem storeSystemSaved = storeSystemRepository.save(storeSystem);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(storeSystem.getId())
                .toUri();
        return ResponseEntity.created(location).body(storeSystemSaved);
    }
}
