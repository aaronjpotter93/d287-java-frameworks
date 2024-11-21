package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxInvValidator implements ConstraintValidator<ValidMaxInv, Part> {

    @Override
    public void initialize(ValidMaxInv constraintAnnotation) {
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true;
        }
        else return part.getMaxInv() >= part.getMinInv();
    }
}