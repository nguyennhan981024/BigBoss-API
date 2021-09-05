package com.example.APIBigboss.api;

import com.example.APIBigboss.models.InforCompany;
import com.example.APIBigboss.models.ShopBanner;
import com.example.APIBigboss.repository.InforCompanyRepository;
import com.example.APIBigboss.repository.ShopBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/infor-company")
public class InforCompanyAPI {
    @Autowired
    private InforCompanyRepository inforCompanyRepository;

    @GetMapping
    public ResponseEntity<List<InforCompany>> getAllInforCompany(){
        return ResponseEntity.ok(inforCompanyRepository.getAllInforCompany());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createInforCompany(@Valid @RequestBody InforCompany inforCompany) {
        InforCompany inforCompanySaved = inforCompanyRepository.save(inforCompany);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(inforCompany.getId())
                .toUri();
        return ResponseEntity.created(location).body(inforCompanySaved);
    }
}
