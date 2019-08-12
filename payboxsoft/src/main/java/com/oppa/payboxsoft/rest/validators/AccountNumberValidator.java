package com.oppa.payboxsoft.rest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class AccountNumberValidator implements ConstraintValidator<AccountNumberConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("(GE[0-9]{2}[a-zA-Z]{2}[0-9]{16}$)");
    }
}
