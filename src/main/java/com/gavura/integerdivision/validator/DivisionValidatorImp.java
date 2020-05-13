package com.gavura.integerdivision.validator;

public class DivisionValidatorImp implements DivisionValidator {
    @Override
    public void validate(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor is zero");
        }
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Operand is negative number");
        }
    }
}
