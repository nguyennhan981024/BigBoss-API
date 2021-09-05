package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("SELECT mn FROM Menu mn")
    List<Menu> getAllMenus();
}
