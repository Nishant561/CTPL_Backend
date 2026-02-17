package com.nishant.ctplbackend.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(
        regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
        message = "Please provide valid Email-Address!"
)

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidEmail {
    String message() default "Invalid-Email Address!";

    Class[] groups() default {};
    Class[] payload() default {};
}
