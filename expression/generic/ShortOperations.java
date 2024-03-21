package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

public class ShortOperations implements Operations<Short> {
    @Override
    public Short add(Short a, Short b) {
        return (short)(a + b);
    }

    @Override
    public Short subtract(Short a, Short b) {
        return (short)(a - b);
    }

    @Override
    public Short multiply(Short a, Short b) {
        return (short)(a * b);
    }

    @Override
    public Short divide(Short a, Short b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return (short)(a / b);
    }

    @Override
    public Short negate(Short a) {
        return (short)(-a);
    }

    @Override
    public Short projector(Short a) {
        return a;
    }

    @Override
    public Short abs(Short a) {
        return (short)(Math.abs(a));
    }

    @Override
    public Short square(Short a) {
        return (short)(a * a);
    }

    @Override
    public Short mod(Short a, Short b) {
        if (b == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return (short)(a % b);
    }
}
