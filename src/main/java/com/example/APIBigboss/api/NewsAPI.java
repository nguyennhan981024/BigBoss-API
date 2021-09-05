package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Material;
import com.example.APIBigboss.models.News;
import com.example.APIBigboss.repository.MaterialRepository;
import com.example.APIBigboss.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/news")
public class NewsAPI {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews(){
        return ResponseEntity.ok(newsRepository.getAllNews());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createNews(@Valid @RequestBody News news) {
        News newsSaved = newsRepository.save(news);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(news.getId())
                .toUri();
        return ResponseEntity.created(location).body(newsSaved);
    }
}
