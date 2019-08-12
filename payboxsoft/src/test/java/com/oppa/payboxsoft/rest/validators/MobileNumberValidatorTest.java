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
public class MobileNumberValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    private MobileNumberValidator mobileNumberValidator;

    @Test
    public void shouldReturnTrue() {
        String [] values = {
                "555121314"
        };

        Arrays.stream(values).forEach(value -> assertTrue(mobileNumberValidator.isValid(value, constraintValidatorContext)));
    }

    @Test
    public void shouldReturnFalse() {
        String [] values = {
                null,
                "",
                "$*@(U@F@dd",
                "955121314",
                "5551213145",
                "55512134"
        };

        Arrays.stream(values).forEach(value -> assertFalse(mobileNumberValidator.isValid(value, constraintValidatorContext)));
    }
}
