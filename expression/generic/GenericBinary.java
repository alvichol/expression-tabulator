package expression.generic;

public abstract class GenericBinary<T> implements GenericExpression<T> {
    GenericExpression<T> first, second;

    protected abstract T calc(T a, T b, Operations<T> ops);

    @Override
    public T evaluate(T a, T b, T c, Operations<T> ops) {
        return calc(first.evaluate(a, b, c, ops), second.evaluate(a, b, c, ops), ops);
    }
}
