package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.OverView;
import com.example.APIBigboss.repository.BannerRepository;
import com.example.APIBigboss.repository.OverViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/overview")
public class OverViewAPI {
    @Autowired
    private OverViewRepository overViewRepository;

    @GetMapping
    public ResponseEntity<List<OverView>> getAllOverview(){
        return ResponseEntity.ok(overViewRepository.getAllOverView());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createOverview(@Valid @RequestBody OverView overview) {
        OverView overviewSaved = overViewRepository.save(overview);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(overview.getId())
                .toUri();
        return ResponseEntity.created(location).body(overviewSaved);
    }
}
