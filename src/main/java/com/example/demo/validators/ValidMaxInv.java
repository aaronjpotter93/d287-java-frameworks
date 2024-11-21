package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxInvValidator.class)
public @interface ValidMaxInv {
    String message() default "Maximum inventory should not be less than minimum inventory";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}