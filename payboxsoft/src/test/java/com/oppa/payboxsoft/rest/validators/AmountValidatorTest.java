package com.oppa.payboxsoft.rest.validators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AmountValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    private AmountValidator amountValidator;

    @Test
    public void shouldReturnTrue() {
        int [] amounts = {
          100,
          101,
          1531,
          10000
        };

        Arrays.stream(amounts).forEach(value -> assertTrue(amountValidator.isValid(value, constraintValidatorContext)));
    }

    @Test
    public void shouldReturnFalse() {
        int [] amounts = {
                99,
                10001,
                -5
        };

        Arrays.stream(amounts).forEach(value -> assertFalse(amountValidator.isValid(value, constraintValidatorContext)));
    }
}
