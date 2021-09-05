package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.userID = ?1")
    Optional<User> findUserByID(int userID);

    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

}
