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
public class AccountNumberValidatorTest {

    @Mock
    private ConstraintValidatorContext context;

    @InjectMocks
    private AccountNumberValidator accountNumberValidator;

    @Test
    public void shouldReturnTrue() {
        String [] validNumbers = {
                "GE01BG0000000000000000",
                "GE50BG0000000000000000",
                "GE01BG0000000030000000",
        };

        Arrays.stream(validNumbers).forEach(s -> assertTrue(accountNumberValidator.isValid(s, context)));
    }

    @Test
    public void shouldReturnFalse() {
        String [] invalidNumbers = {
                null,
                " ",
                "GEA1BG0000000000000000",
                "1E01BG0000000000000000",
                "GE01#G0000000000000000",
                "GE01AG000000000000000a",
                "GE01BG000000000000000",
                "GE01BG0000000000000a00",
                "GE01BG00000000000000000"
        };

        Arrays.stream(invalidNumbers).forEach(s -> assertFalse(accountNumberValidator.isValid(s, context)));
    }
}
