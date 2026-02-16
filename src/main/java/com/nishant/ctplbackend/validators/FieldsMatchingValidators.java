package com.nishant.ctplbackend.validators;

import com.nishant.ctplbackend.annotations.FieldMatching;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsMatchingValidators implements ConstraintValidator<FieldMatching,Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldMatching constraintAnnotation) {

        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        if(fieldValue != null){
            return fieldValue.equals(fieldMatchValue);
        }

        return fieldMatchValue == null;
    }
}
