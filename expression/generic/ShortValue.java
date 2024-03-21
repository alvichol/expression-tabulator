package expression.generic;

public class ShortValue implements Value<Short> {
    @Override
    public Short toValue(String str) {
        return (short)Integer.parseInt(str);
    }
}
