package com.gavura.integerdivision.domain;

import java.util.Objects;

public class Number {
    private final int digit;
    private final int pointPosition;

    public Number(int value, int pointPosition) {
        this.digit = value;
        this.pointPosition = pointPosition;
    }

    public int getDigit() {
        return digit;
    }

    public int getPointPosition() {
        return pointPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return digit == number.digit &&
                pointPosition == number.pointPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit, pointPosition);
    }
}
