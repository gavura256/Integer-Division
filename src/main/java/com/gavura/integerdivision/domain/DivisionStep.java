package com.gavura.integerdivision.domain;

import java.util.Objects;

public class DivisionStep {
    private final int subtrahend;
    private final int minuend;
    private final int pointPosition;
    private final int semiResult;
    private final int result;

    private DivisionStep(int subtrahend, int minuend, int pointPosition, int semiResult, int result) {
        this.subtrahend = subtrahend;
        this.minuend = minuend;
        this.semiResult = semiResult;
        this.pointPosition = pointPosition;
        this.result = result;
    }

    public static DivisionStepBuilder builder() {
        return new DivisionStepBuilder();
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSemiResult() {
        return semiResult;
    }

    public int getPointPosition() {
        return pointPosition;
    }

    public int getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DivisionStep that = (DivisionStep) o;
        return subtrahend == that.subtrahend &&
                minuend == that.minuend &&
                pointPosition == that.pointPosition &&
                semiResult == that.semiResult &&
                result == that.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtrahend, minuend, pointPosition, semiResult, result);
    }

    public static class DivisionStepBuilder {
        private int subtrahend;
        private int minuend;
        private int pointPosition;
        private int semiResult;
        private int result;

        private DivisionStepBuilder() {
        }

        public DivisionStepBuilder withSubtrahend(int subtrahend) {
            this.subtrahend = subtrahend;
            return this;
        }

        public DivisionStepBuilder withMinuend(int minuend) {
            this.minuend = minuend;
            return this;
        }

        public DivisionStepBuilder withPointPosition(int pointPosition) {
            this.pointPosition = pointPosition;
            return this;
        }

        public DivisionStepBuilder withSemiResult(int semiResult) {
            this.semiResult = semiResult;
            return this;
        }

        public DivisionStepBuilder withResult(int result) {
            this.result = result;
            return this;
        }

        public DivisionStep build() {
            return new DivisionStep(subtrahend, minuend, pointPosition, semiResult, result);
        }
    }
}
