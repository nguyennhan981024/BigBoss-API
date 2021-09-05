package com.example.APIBigboss.api;

import com.example.APIBigboss.models.OverView;
import com.example.APIBigboss.models.ShopBanner;
import com.example.APIBigboss.repository.OverViewRepository;
import com.example.APIBigboss.repository.ShopBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shop-banner")
public class ShopBannerAPI {
    @Autowired
    private ShopBannerRepository shopBannerRepository;

    @GetMapping
    public ResponseEntity<List<ShopBanner>> getAllShopBanner(){
        return ResponseEntity.ok(shopBannerRepository.getAllShopBanner());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createShopBanner(@Valid @RequestBody ShopBanner shopbanner) {
        ShopBanner shopBannerSaved = shopBannerRepository.save(shopbanner);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(shopbanner.getId())
                .toUri();
        return ResponseEntity.created(location).body(shopBannerSaved);
    }
}
