package expression.generic;

public abstract class GenericUnary<T> implements GenericExpression<T> {
    GenericExpression<T> exp;
    protected abstract T calc(T a, Operations<T> ops);

    @Override
    public T evaluate(T a, T b, T c, Operations<T> ops) {
        return calc(exp.evaluate(a, b, c, ops), ops);
    }
}
