package expression.generic;

public class GenericSubtract<T> extends GenericBinary<T> {
    public GenericSubtract(GenericExpression<T> first, GenericExpression<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    protected T calc(T a, T b, Operations<T> ops) {
        return ops.subtract(a, b);
    }
}
