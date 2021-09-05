package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.InforCompany;
import com.example.APIBigboss.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("SELECT bn FROM Material bn")
    List<Material> getAllMaterial();
}
