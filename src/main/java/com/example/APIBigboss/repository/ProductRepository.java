package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Boolean existsByName(String name);
    @Query("SELECT pd FROM Product pd WHERE pd.id = ?1")
    Optional<Product> findProductById(Integer id);
    @Query("SELECT pd FROM Product pd")
    List<Product> getAllProduct();
}
