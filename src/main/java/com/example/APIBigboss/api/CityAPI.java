package com.example.APIBigboss.api;

import com.example.APIBigboss.models.City;
import com.example.APIBigboss.models.StoreContact;
import com.example.APIBigboss.repository.CityRepository;
import com.example.APIBigboss.repository.StoreContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/city")
public class CityAPI {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public ResponseEntity<List<City>> getAllCity(){
        return ResponseEntity.ok(cityRepository.getAllCity());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCity(@Valid @RequestBody City city) {
        City citySaved = cityRepository.save(city);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city.getId())
                .toUri();
        return ResponseEntity.created(location).body(citySaved);
    }
}
