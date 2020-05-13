package com.gavura.integerdivision.provider;

import com.gavura.integerdivision.domain.DivisionStep;
import java.util.List;

public final class DivisionViewProviderImp implements DivisionViewProvider {

    public static final String WORD_SEPARATOR = " ";
    public static final String PIPE = "|";
    public static final String NEW_LINE = "\n";

    @Override
    public String provideDivisionView(List<DivisionStep> steps, int dividend, int divisor) {
        StringBuilder builder = new StringBuilder();

        int lineLength = getLineLength(dividend, divisor);

        String intFormat = "%" + lineLength + "d";

        builder.append(WORD_SEPARATOR)
                .append(String.format(intFormat, dividend))
                .append(PIPE)
                .append(String.format(intFormat, divisor))
                .append(NEW_LINE);

        int result = 0;
        for (DivisionStep step : steps) {
            String numberFormat = "%" + (lineLength - step.getPointPosition()) + "d";

            builder.append(WORD_SEPARATOR)
                    .append(String.format(numberFormat, -step.getSubtrahend()))
                    .append(generateTab(step.getPointPosition(), ' '))
                    .append(PIPE)
                    .append(String.format(numberFormat, step.getSemiResult()))
                    .append(NEW_LINE);

            result += step.getResult();

            builder.append(generateTab(lineLength + lineLength + 2, '-'))
                    .append(NEW_LINE)
                    .append(WORD_SEPARATOR)
                    .append(String.format(intFormat, step.getMinuend()))
                    .append(PIPE)
                    .append(NEW_LINE);

            dividend = step.getMinuend();
        }

        builder.append(generateTab(lineLength + lineLength + 2, '–'))
                .append(NEW_LINE)
                .append(WORD_SEPARATOR)
                .append(String.format(intFormat, dividend))
                .append(PIPE)
                .append(String.format(intFormat, result))
                .append(NEW_LINE);

        return builder.toString();
    }

    private int getLineLength(int dividend, int divisor) {
        return 1 + Math.max(String.valueOf(dividend).length(), String.valueOf(divisor).length());
    }

    private String generateTab(int length, char ch) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(ch);
        }

        return result.toString();
    }
}
