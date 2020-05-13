package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import java.util.List;

public interface DivisionViewProvider {

    String provideDivisionView(List<DivisionStep> steps, int dividend, int divisor);
}
