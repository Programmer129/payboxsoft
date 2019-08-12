package com.oppa.payboxsoft.rest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class MobileNumberValidator implements ConstraintValidator<MobileNumberConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(?=^5)(^[0-9]{9}$)");
    }
}
