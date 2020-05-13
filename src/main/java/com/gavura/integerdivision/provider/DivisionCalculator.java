package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import com.gavura.integerdivision.validator.DivisionValidator;
import java.util.List;

public class DivisionCalculator {
    private final DivisionValidator validator;
    private final DivisionMathProvider mathProvider;
    private final DivisionViewProvider viewProvider;

    public DivisionCalculator(DivisionValidator validator,
                              DivisionMathProvider mathProvider, DivisionViewProvider viewProvider) {
        this.validator = validator;
        this.mathProvider = mathProvider;
        this.viewProvider = viewProvider;
    }

    public String calculateDivision(int dividend, int divisor) {
        validator.validate(dividend, divisor);
        List<DivisionStep> steps = mathProvider.provideMathCalculation(dividend, divisor);

        return viewProvider.provideDivisionView(steps, dividend, divisor);
    }
}
