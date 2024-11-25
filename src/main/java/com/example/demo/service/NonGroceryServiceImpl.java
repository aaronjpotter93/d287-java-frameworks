package com.example.demo.service;

import com.example.demo.domain.NonGrocery;
import com.example.demo.repositories.NonGroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */

@Service
public class NonGroceryServiceImpl implements NonGroceryService{
        private NonGroceryRepository nonGroceryRepository;

        @Autowired

    public NonGroceryServiceImpl(NonGroceryRepository nonGroceryRepository) {
        this.nonGroceryRepository = nonGroceryRepository;
    }

    @Override
    public List<NonGrocery> findAll() {
        return nonGroceryRepository.findAll();
    }
    public List<NonGrocery> listAll(String keyword){
        if(keyword !=null){
            return nonGroceryRepository.search(keyword);
        }
        return nonGroceryRepository.findAll();
    }
    @Override
    public NonGrocery findById(int theId) {
        Long theIdl=(long)theId;
        Optional<NonGrocery> result = nonGroceryRepository.findById(theIdl);

        NonGrocery theNonGrocery = null;

        if (result.isPresent()) {
            theNonGrocery = result.get();
        }
        else {
            // we didn't find the NonGrocery id
            throw new RuntimeException("Did not find NonGrocery id - " + theId);
        }

        return theNonGrocery;
    }

    @Override
    public void save(NonGrocery theNonGrocery) {
            nonGroceryRepository.save(theNonGrocery);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        nonGroceryRepository.deleteById(theIdl);
    }
}
