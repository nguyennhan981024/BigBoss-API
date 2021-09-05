package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.GalleryLookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GalleryLookBookRepository extends JpaRepository<GalleryLookbook, Integer> {
    @Query("SELECT bn FROM GalleryLookbook bn")
    List<GalleryLookbook> getAllGalleryLookBook();
}
