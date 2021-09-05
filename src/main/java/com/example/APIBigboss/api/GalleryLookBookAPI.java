package com.example.APIBigboss.api;

import com.example.APIBigboss.models.GalleryLookbook;
import com.example.APIBigboss.models.Ward;
import com.example.APIBigboss.repository.GalleryLookBookRepository;
import com.example.APIBigboss.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gallery-lookbook")
public class GalleryLookBookAPI {
    @Autowired
    private GalleryLookBookRepository galleryLookBookRepository;

    @GetMapping
    public ResponseEntity<List<GalleryLookbook>> getAllGalleryLookBook(){
        return ResponseEntity.ok(galleryLookBookRepository.getAllGalleryLookBook());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createGalleryLookBook(@Valid @RequestBody GalleryLookbook galleryLookbook) {
        GalleryLookbook galleryLookBookSaved = galleryLookBookRepository.save(galleryLookbook);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(galleryLookbook.getId())
                .toUri();
        return ResponseEntity.created(location).body(galleryLookBookSaved);
    }
}
