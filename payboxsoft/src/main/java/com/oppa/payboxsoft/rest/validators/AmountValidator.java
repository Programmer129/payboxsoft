package com.oppa.payboxsoft.rest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class AmountValidator implements ConstraintValidator<AmountConstraint, Integer> {

   public boolean isValid(Integer value, ConstraintValidatorContext context) {
      return value != null && value > 99 && value < 10001;
   }
}
