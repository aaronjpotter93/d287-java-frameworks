package com.example.demo.controllers;

import com.example.demo.domain.NonGrocery;
import com.example.demo.repositories.NonGroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AddNonGroceryController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddNonGrocery")
    public String showFormAddNonGrocery(Model theModel) {
        NonGrocery nonGrocery = new NonGrocery();
        theModel.addAttribute("nonGrocery", nonGrocery);
        return "NonGroceryForm";
    }

    @PostMapping("/showFormAddNonGrocery")
    public String showFormAddNonGrocerySubmit(@Valid @ModelAttribute("nonGrocery") NonGrocery nonGrocery, BindingResult theBindingResult, Model theModel) {
        theModel.addAttribute("nonGrocery", nonGrocery);
        if(theBindingResult.hasErrors()) {
            return "NonGroceryForm";
        }
        else {
            NonGroceryRepository nonGroceryRepository = context.getBean(NonGroceryRepository.class);
            nonGroceryRepository.save(nonGrocery);
        }
        return "confirmationaddpart";
    }

    @GetMapping("/deleteNonGrocery")
    public String showPartFormForUpdateNonGrocery(@RequestParam("id") int theId, Model theModel) {
        NonGrocery nonGrocery = context.getBean(NonGrocery.class);
        NonGroceryRepository nonGroceryRepository = context.getBean(NonGroceryRepository.class);
        nonGroceryRepository.delete(nonGrocery);
        return "confermationdeletepart";
    }
}
