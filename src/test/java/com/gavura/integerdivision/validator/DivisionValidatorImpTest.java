package com.gavura.integerdivision.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivisionValidatorImpTest {
    private final DivisionValidator validator = new DivisionValidatorImp();

    @Test
    void validateShouldThrowIllegalArgumentExceptionWhenDivisorIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(10, 0));
        String expectedString = "Divisor is zero";

        assertThat(exception.getMessage(), is(expectedString));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionWhenOperandIsNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(-12, -12));
        String expectedString = "Operand is negative number";

        assertThat(exception.getMessage(), is(expectedString));
    }

    @Test
    void validateShouldNotThrowAnyException() {
        assertDoesNotThrow(() -> validator.validate(4324, 234));
    }
}
