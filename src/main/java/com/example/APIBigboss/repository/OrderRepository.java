package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.models.Orders;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query("SELECT od FROM Orders od WHERE od.id = ?1")
    Optional<Orders> findOrderById(Integer id);
    @Query("SELECT od FROM Orders od order by od.id desc")
    List<Orders> getAllOrder();
}
