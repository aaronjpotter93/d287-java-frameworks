package com.example.demo.controllers;

import com.example.demo.domain.NonGrocery;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.NonGroceryRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.NonGroceryService;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {

    private final PartService partService;
    private final ProductService productService;
    private final NonGroceryService nonGroceryService;

    public MainScreenControllerr(PartService partService, ProductService productService, NonGroceryService nonGroceryService){
        this.partService=partService;
        this.productService=productService;
        this.nonGroceryService = nonGroceryService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword, @Param("nongrockeyword") String nongrockeyword){

        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);

        List<NonGrocery> theNonGroceries=nonGroceryService.listAll(nongrockeyword);
        theModel.addAttribute("nonGroceries",theNonGroceries);
        theModel.addAttribute("nongrockeyword",nongrockeyword);

        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
}
