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
public class PersonalNumberValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    private PersonalNumberValidator personalNumberValidator;

    @Test
    public void shouldReturnTrue() {
        String [] values = {
                "12345678910"
        };

        Arrays.stream(values).forEach(value -> assertTrue(personalNumberValidator.isValid(value, constraintValidatorContext)));
    }

    @Test
    public void shouldReturnFalse() {
        String [] values = {
                null,
                "",
                "$*@(U@F@dd",
                "123456791!",
                "0000000000",
                "0053116-1113"
        };

        Arrays.stream(values).forEach(value -> assertFalse(personalNumberValidator.isValid(value, constraintValidatorContext)));
    }
}
