package com.oppa.payboxsoft.rest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class PersonalNumberValidator implements ConstraintValidator<PersonalNumberConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(^[0-9]{11}$)");
    }
}
