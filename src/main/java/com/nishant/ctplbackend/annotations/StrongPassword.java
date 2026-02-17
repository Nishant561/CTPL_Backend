package com.nishant.ctplbackend.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must be 8 character long contains lowercase, uppercase, number, special character!"
)

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface StrongPassword {

    String message() default "Please provide strong-password!";
    Class[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
