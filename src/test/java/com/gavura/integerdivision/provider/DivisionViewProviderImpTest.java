package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DivisionViewProviderImpTest {
    private final DivisionViewProvider divisionViewProvider = new DivisionViewProviderImp();

     @Test
    void provideDivisionViewShouldPrintToConsoleWhenDividendConsistOfZerosInTheMiddle() {
        DivisionStep step = DivisionStep.builder()
                .withSubtrahend(10)
                .withMinuend(5)
                .withPointPosition(4)
                .withSemiResult(1)
                .withResult(10000)
                .build();
        String actualString = "  100005|     10\n" +
                " -10    |  1\n" +
                "----------------\n" +
                "       5|\n" +
                "––––––––––––––––\n" +
                "       5|  10000\n";

        String expectedString = divisionViewProvider.provideDivisionView(Collections.singletonList(step), 100005, 10);

        assertThat(actualString, is(expectedString));
    }

    @Test
    void provideDivisionViewShouldPrintToConsoleWhenDividendIsZero() {
        String actualString = "   0| 10\n" +
                "––––––––\n" +
                "   0|  0\n";
        String expectedString = divisionViewProvider.provideDivisionView(Collections.emptyList(), 0, 10);

        assertThat(actualString, is(expectedString));
    }
}
