package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Product;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import com.example.APIBigboss.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductAPI {
 
       @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productRepository.getAllProduct());
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {

        if (productRepository.existsByName(product.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Product Name is already!"));
        }
        Product productSave = productRepository.save(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).body(productSave);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,
                                            @Valid @RequestBody Product product){
        Optional<Product> optionalProduct= productRepository.findProductById(id);

        if(!optionalProduct.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        product.setId(optionalProduct.get().getId());
        productRepository.save(product);
        return ResponseEntity.ok(optionalProduct.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id){
        Optional<Product> optionalProduct= productRepository.findProductById(id);

        if(!optionalProduct.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        productRepository.delete(optionalProduct.get());
        return ResponseEntity.noContent().build();
    }
}
