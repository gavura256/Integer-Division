package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import com.gavura.integerdivision.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class DivisionMathProviderImp implements DivisionMathProvider {

    public static final int ORDER_OF_MAGNITUDE = 10;

    @Override
    public List<DivisionStep> provideMathCalculation(int dividend, int divisor) {
        List<DivisionStep> steps = new ArrayList<>();
        Number number = divideNext(dividend, divisor);

        while (number.getDigit() != 0) {
            int subtrahend = divisor * number.getDigit();
            int minuend = dividend - getValue(number) * divisor;
            int semiResult = number.getDigit();
            int result = getValue(number);
            dividend -= getValue(number) * divisor;
            int pointPosition = number.getPointPosition();
            DivisionStep step = DivisionStep.builder()
                    .withSubtrahend(subtrahend)
                    .withMinuend(minuend)
                    .withPointPosition(pointPosition)
                    .withSemiResult(semiResult)
                    .withResult(result)
                    .build();
            steps.add(step);
            number = divideNext(dividend, divisor);
        }

        return steps;
    }

    Number divideNext(int dividend, int divisor) {
        int pointPosition = 0;

        if (dividend < divisor) {
            return new Number(0, 0);
        }

        while (dividendIsBiggestThanMatchedValue(dividend, divisor, ORDER_OF_MAGNITUDE)) {
            pointPosition++;
            divisor *= ORDER_OF_MAGNITUDE;
        }

        int quotient = 1;
        while (dividendIsBiggestThanMatchedValue(dividend, divisor, quotient + 1)) {
            quotient++;
        }

        return new Number(quotient, pointPosition);
    }

    private boolean dividendIsBiggestThanMatchedValue(int dividend, int divisor, int argument) {
        return dividend > divisor * argument;
    }

    private int getValue(Number number) {
        int result = number.getDigit();
        for (int i = 0; i < number.getPointPosition(); i++) {
            result *= ORDER_OF_MAGNITUDE;
        }

        return result;
    }
}
