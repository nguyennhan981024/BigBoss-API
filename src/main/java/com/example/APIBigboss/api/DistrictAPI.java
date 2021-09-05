package com.example.APIBigboss.api;

import com.example.APIBigboss.models.City;
import com.example.APIBigboss.models.District;
import com.example.APIBigboss.repository.CityRepository;
import com.example.APIBigboss.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/district")
public class DistrictAPI {
    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping
    public ResponseEntity<List<District>> getAllDistrict(){
        return ResponseEntity.ok(districtRepository.getAllDistrict());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createDistrict(@Valid @RequestBody District district) {
        District districtSaved = districtRepository.save(district);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(district.getId())
                .toUri();
        return ResponseEntity.created(location).body(districtSaved);
    }
}
