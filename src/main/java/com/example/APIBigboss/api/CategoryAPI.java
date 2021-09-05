package com.example.APIBigboss.api;
import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryAPI {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryRepository.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable int id) {
        Optional<Category> optionalCategory = categoryRepository.findCategoryById(id);
        if (!optionalCategory.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalCategory.get());
    }
    @PostMapping("/add")
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category) {

        if (categoryRepository.existsByName(category.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Category Name is already!"));
        }
        Category categorySaved = categoryRepository.save(category);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(location).body(categorySaved);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id,
                                            @Valid @RequestBody Category category){
        Optional<Category> optionalCategory= categoryRepository.findCategoryById(id);

        if(!optionalCategory.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        category.setId(optionalCategory.get().getId());
        categoryRepository.save(category);
        return ResponseEntity.ok(optionalCategory.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
        Optional<Category> optionalCategory= categoryRepository.findCategoryById(id);

        if(!optionalCategory.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        categoryRepository.delete(optionalCategory.get());
        return ResponseEntity.noContent().build();
    }
}
