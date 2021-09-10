package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.Menu;
import com.example.APIBigboss.repository.BannerRepository;
import com.example.APIBigboss.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/banner")
public class BannerAPI {
    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping
    public ResponseEntity<List<Banner>> getAllBanner(){
        return ResponseEntity.ok(bannerRepository.getAllBanners());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBanner(@Valid @RequestBody Banner banner) {
        Banner bannerSaved = bannerRepository.save(banner);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(banner.getId())
                .toUri();
        return ResponseEntity.created(location).body(bannerSaved);
    }
    
}
