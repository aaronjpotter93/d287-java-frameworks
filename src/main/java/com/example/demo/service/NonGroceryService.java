package com.example.demo.service;

import com.example.demo.domain.NonGrocery;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface NonGroceryService {
    public List<NonGrocery> findAll();
    public NonGrocery findById(int theId);
    public void save (NonGrocery theNonGrocery);
    public void deleteById(int theId);

    public List<NonGrocery> listAll(String keyword);
}
