package com.nishant.ctplbackend.annotations;


import com.nishant.ctplbackend.validators.FieldsMatchingValidators;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsMatchingValidators.class)
@Documented

public @interface FieldMatching {

    String message() default "Fields value didn't matched!";

    Class[] groups() default {};

    Class[] payload() default {};

    String field();
    String fieldMatch();





}
