package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.ContactNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactNewRepository extends JpaRepository<ContactNew, Integer> {
    @Query("SELECT bn FROM ContactNew bn")
    List<ContactNew> getAllContactNew();
}
