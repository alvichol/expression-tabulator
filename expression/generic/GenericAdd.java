package expression.generic;

public class GenericAdd<T> extends GenericBinary<T> {
    public GenericAdd(GenericExpression<T> first, GenericExpression<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    protected T calc(T a, T b, Operations<T> ops) {
        return ops.add(a, b);
    }
}
