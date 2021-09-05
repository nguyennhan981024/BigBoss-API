package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
    @Query("SELECT bn FROM Banner bn")
    List<Banner> getAllBanners();
}
