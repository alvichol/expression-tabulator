package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

public class DoubleOperations implements Operations<Double> {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double negate(Double a) {
        return -a;
    }

    @Override
    public Double projector(Double a) {
        return a;
    }

    @Override
    public Double abs(Double a) {
        return Math.abs(a);
    }

    @Override
    public Double square(Double a) {
        return a * a;
    }

    @Override
    public Double mod(Double a, Double b) {
        return a % b;
    }
}
