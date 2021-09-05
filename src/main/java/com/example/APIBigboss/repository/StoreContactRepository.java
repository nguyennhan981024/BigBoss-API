package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.ShopBanner;
import com.example.APIBigboss.models.StoreContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreContactRepository extends JpaRepository<StoreContact, Integer> {
    @Query("SELECT bn FROM StoreContact bn")
    List<StoreContact> getAllStoreContact();
}
