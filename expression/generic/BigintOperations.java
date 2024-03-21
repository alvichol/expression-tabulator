package expression.generic;

import expression.exceptions.EvalException;
import expression.exceptions.EvalExceptionType;

import java.math.BigInteger;

public class BigintOperations implements Operations<BigInteger> {
    @Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return a.divide(b);
    }

    @Override
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    @Override
    public BigInteger projector(BigInteger a) {
        return a;
    }

    @Override
    public BigInteger abs(BigInteger a) {
        return a.abs();
    }

    @Override
    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    @Override
    public BigInteger mod(BigInteger a, BigInteger b) {
        if (!b.abs().equals(b)) {
            throw new EvalException("negative modulus", EvalExceptionType.NEGMOD);
        }
        if (b.equals(BigInteger.ZERO)) {
            throw new EvalException("division by zero", EvalExceptionType.DBZ);
        }
        return a.mod(b);
    }

}
