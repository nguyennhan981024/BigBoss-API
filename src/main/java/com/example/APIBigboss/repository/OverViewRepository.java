package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.OverView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OverViewRepository extends JpaRepository<OverView, Integer> {
    @Query("SELECT bn FROM OverView bn")
    List<OverView> getAllOverView();
}
