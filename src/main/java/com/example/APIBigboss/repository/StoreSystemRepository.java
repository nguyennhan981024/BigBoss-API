package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.News;
import com.example.APIBigboss.models.StoreSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreSystemRepository extends JpaRepository<StoreSystem, Integer> {
    @Query("SELECT bn FROM StoreSystem bn")
    List<StoreSystem> getAllStoreSystem();
}
