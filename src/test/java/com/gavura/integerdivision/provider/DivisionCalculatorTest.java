package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.validator.DivisionValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DivisionCalculatorTest {
    @Mock
    private DivisionValidator validator;

    @Mock
    private DivisionMathProvider mathProvider;

    @Mock
    private DivisionViewProvider viewProvider;

    @InjectMocks
    private DivisionCalculator calculator;

    @Test
    void validateShouldThrowIllegalArgumentExceptionWhenDivisorIsZero() {
        doThrow(IllegalArgumentException.class).when(validator).validate(anyInt(), eq(0));

        verifyNoMoreInteractions(mathProvider);
        verifyNoMoreInteractions(viewProvider);

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDivision(anyInt(), eq(0)));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionWhenOperandsAreNegatives() {
        doThrow(IllegalArgumentException.class).when(validator).validate(-anyInt(), -anyInt());

        verifyNoMoreInteractions(mathProvider);
        verifyNoMoreInteractions(viewProvider);

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDivision(-anyInt(), -anyInt()));
    }

    @Test
    void validateShouldNotThrowAnyExceptions() {
        when(calculator.calculateDivision(anyInt(), anyInt())).thenReturn("All right");

        verify(validator).validate(anyInt(), anyInt());
        verify(mathProvider).provideMathCalculation(anyInt(), anyInt());

        assertDoesNotThrow(() -> calculator.calculateDivision(anyInt(), anyInt()));
        assertThat(calculator.calculateDivision(anyInt(), anyInt()), containsString("All right"));
    }
}
