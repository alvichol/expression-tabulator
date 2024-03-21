package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

public class PIntOperations implements Operations<Integer> {
    private final int MOD = 10079;
    @Override
    public Integer add(Integer a, Integer b) {
        return (projector(a) + projector(b)) % MOD;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return (projector(a) - projector(b) + MOD) % MOD;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return projector(a) * projector(b) % MOD;
    }

    int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int p = pow(a, n / 2);
        if (n % 2 == 0) {
            return p * p % MOD;
        }
        return (p * p % MOD) * a % MOD;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (projector(b) == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return multiply(a, pow(projector(b), MOD - 2));
    }

    @Override
    public Integer negate(Integer a) {
        return projector(-(a % MOD));
    }

    @Override
    public Integer projector(Integer a) {
        return (a % MOD + MOD) % MOD;
    }

    @Override
    public Integer abs(Integer a) {
        if (a >= 0) {
            return a % MOD;
        }
        return negate(a);
    }

    @Override
    public Integer square(Integer a) {
        return multiply(a, a);
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        if (projector(b) == 0) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return projector(a) % projector(b);
    }
}
