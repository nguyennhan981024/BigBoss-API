package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.InforCompany;
import com.example.APIBigboss.models.ShopBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InforCompanyRepository extends JpaRepository<InforCompany, Integer> {
    @Query("SELECT bn FROM InforCompany bn")
    List<InforCompany> getAllInforCompany();
}
