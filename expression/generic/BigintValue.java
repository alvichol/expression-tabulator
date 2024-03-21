package expression.generic;

import java.math.BigInteger;

public class BigintValue implements Value<BigInteger> {

    @Override
    public BigInteger toValue(String str) {
        return new BigInteger(str);
    }
}
