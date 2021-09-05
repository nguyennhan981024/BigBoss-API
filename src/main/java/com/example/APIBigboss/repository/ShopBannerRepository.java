package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.ShopBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopBannerRepository extends JpaRepository<ShopBanner, Integer> {
    @Query("SELECT bn FROM ShopBanner bn")
    List<ShopBanner> getAllShopBanner();
}
