package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

public class IntegerOperations implements Operations<Integer> {
    @Override
    public Integer add(Integer a, Integer b) {
        if (b > 0 ? a > Integer.MAX_VALUE - b
                : a < Integer.MIN_VALUE - b) {
            throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
        }
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        if (b > 0 ? a < Integer.MIN_VALUE + b
                : a > Integer.MAX_VALUE + b) {
            throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
        }
        return a - b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
        }
        return a / b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if (b > 0) {
            if (a > Integer.MAX_VALUE / b || a < Integer.MIN_VALUE / b) {
                throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
            }
        } else {
            if (b < -1 && (a > Integer.MIN_VALUE / b || a < Integer.MAX_VALUE / b) ||
                    b == -1 && a == Integer.MIN_VALUE) {
                throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
            }
        }
        return a * b;
    }

    @Override
    public Integer negate(Integer a) {
        if (a == Integer.MIN_VALUE) {
            throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
        }
        return -a;
    }

    @Override
    public Integer projector(Integer a) {
        return a;
    }

    @Override
    public Integer abs(Integer a) {
        if (a == Integer.MIN_VALUE) {
            throw new EvalException("overflow", EvalExceptionType.OVERFLOW);
        }
        return Math.abs(a);
    }

    @Override
    public Integer square(Integer a) {
        return multiply(a, a);
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return a % b;
    }

}
