package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Menu;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import com.example.APIBigboss.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/menu")
public class MenuAPI {
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus(){
        return ResponseEntity.ok(menuRepository.getAllMenus());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createMenu(@Valid @RequestBody Menu menu) {
        Menu menuSaved = menuRepository.save(menu);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(menu.getId())
                .toUri();
        return ResponseEntity.created(location).body(menuSaved);
    }
}
