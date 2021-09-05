package com.example.APIBigboss.api;

import com.example.APIBigboss.models.StoreContact;
import com.example.APIBigboss.models.StoreSystem;
import com.example.APIBigboss.repository.StoreContactRepository;
import com.example.APIBigboss.repository.StoreSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/store-contact")
public class StoreContactAPI {
    @Autowired
    private StoreContactRepository storeContactRepository;

    @GetMapping
    public ResponseEntity<List<StoreContact>> getAllStoreContact(){
        return ResponseEntity.ok(storeContactRepository.getAllStoreContact());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createStoreContact(@Valid @RequestBody StoreContact storeContact) {
        StoreContact storeContactSaved = storeContactRepository.save(storeContact);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(storeContact.getId())
                .toUri();
        return ResponseEntity.created(location).body(storeContactSaved);
    }
}
