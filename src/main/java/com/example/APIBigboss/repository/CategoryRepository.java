package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);

    @Query("SELECT ca FROM Category ca WHERE ca.id = ?1")
    Optional<Category> findCategoryById(Integer id);
    @Query("SELECT ca FROM Category ca")
    List<Category> getAllCategories();
    @Query("SELECT ca FROM Category ca WHERE ca.name = ?1")
    Category findByCategoryName(String name);
}
