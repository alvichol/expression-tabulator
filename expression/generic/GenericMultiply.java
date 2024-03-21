package expression.generic;

public class GenericMultiply<T> extends GenericBinary<T> {
    public GenericMultiply(GenericExpression<T> first, GenericExpression<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    protected T calc(T a, T b, Operations<T> ops) {
        return ops.multiply(a, b);
    }
}
