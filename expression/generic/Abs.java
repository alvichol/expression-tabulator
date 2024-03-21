package expression.generic;

public class Abs<T> extends GenericUnary<T> {
    public Abs(GenericExpression<T> exp) {
        this.exp = exp;
    }
    @Override
    protected T calc(T a, Operations<T> ops) {
        return ops.abs(a);
    }
}
