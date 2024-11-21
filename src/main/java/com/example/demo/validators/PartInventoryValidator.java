package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartInventoryValidator implements ConstraintValidator<ValidPartInventory, Part> {
    @Autowired
    private ApplicationContext context;

    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidPartInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if (part == null) return true;
        if(context!=null)myContext=context;

        int inv = part.getInv();
        int min = part.getMinInv();
        int max = part.getMaxInv();

        // Adding New Parts
        if (part.getId() == 0) {
            return inv >= min && inv <= max;
        }

        // Updating Existing Parts
        PartService repo = myContext.getBean(PartServiceImpl.class);
        Part myPart = repo.findById((int) part.getId());
        inv = myPart.getInv();

        return inv >= min && inv <= max;
    }
}
