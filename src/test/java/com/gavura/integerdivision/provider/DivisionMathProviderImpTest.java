package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import com.gavura.integerdivision.domain.Number;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DivisionMathProviderImpTest {
    private final DivisionMathProviderImp divisionMathProvider = new DivisionMathProviderImp();

    @Test
    void provideMathCalculationShouldProvideMathCalculationForLongResult() {
        DivisionStep step1 = DivisionStep.builder()
                .withSubtrahend(24)
                .withMinuend(1724)
                .withPointPosition(2)
                .withSemiResult(1)
                .withResult(100)
                .build();
        DivisionStep step2 = DivisionStep.builder()
                .withSubtrahend(168)
                .withMinuend(44)
                .withPointPosition(1)
                .withSemiResult(7)
                .withResult(70)
                .build();
        DivisionStep step3 = DivisionStep.builder()
                .withSubtrahend(24)
                .withMinuend(20)
                .withPointPosition(0)
                .withSemiResult(1)
                .withResult(1)
                .build();
        List<DivisionStep> actualList = Arrays.asList(step1, step2, step3);
        List<DivisionStep> expectedList = divisionMathProvider.provideMathCalculation(4124, 24);

        assertThat(actualList, is(expectedList));
    }

    @Test
    void divideNextShouldReturnNumberWithZerosArgumentsWhenDividendIsSmallerThanDividend() {
        Number expectedNumber = new Number(0, 0);
        Number actualNumber = divisionMathProvider.divideNext(321, 232323);

        assertThat(actualNumber, is(expectedNumber));
    }

    @Test
    void divideNextShouldCheckIfNumbersAreEqualsWhenDividendIsBiggerThanAnOrderOfMagnitude() {
        Number expectedNumber = new Number(1, 2);
        Number actualNumber = divisionMathProvider.divideNext(32143, 321);

        assertThat(actualNumber, is(expectedNumber));
    }

    @Test
    void divideNextShouldCheckIfNumbersAreEqualsWhenDividendIsMuchMoreThanDivisor() {
        Number expectedNumber = new Number(3, 8);
        Number actualNumber = divisionMathProvider.divideNext(323213211, 23);

        assertThat(actualNumber, is(expectedNumber));
    }
}
