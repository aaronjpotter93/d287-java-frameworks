package com.example.demo.repositories;

import com.example.demo.domain.NonGrocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonGroceryRepository extends JpaRepository<NonGrocery, Long> {
    @Query("SELECT p FROM NonGrocery p WHERE p.name LIKE %?1%")
    List<NonGrocery> search(String keyword);
}
