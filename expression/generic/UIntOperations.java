package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

public class UIntOperations implements Operations<Integer> {

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return a / b;
    }

    @Override
    public Integer negate(Integer a) {
        return -a;
    }

    @Override
    public Integer projector(Integer a) {
        return a;
    }

    @Override
    public Integer abs(Integer a) {
        return Math.abs(a);
    }

    @Override
    public Integer square(Integer a) {
        return a * a;
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return a % b;
    }
}
