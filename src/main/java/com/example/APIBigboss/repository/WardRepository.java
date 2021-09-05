package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.District;
import com.example.APIBigboss.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Integer> {
    @Query("SELECT bn FROM Ward bn")
    List<Ward> getAllWard();
}
