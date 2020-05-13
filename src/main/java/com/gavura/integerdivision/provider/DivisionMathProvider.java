package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import java.util.List;

public interface DivisionMathProvider {

    List<DivisionStep> provideMathCalculation(int dividend, int divisor);
}
