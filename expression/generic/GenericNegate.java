package expression.generic;

public class GenericNegate<T> extends GenericUnary<T> {
    public GenericNegate(GenericExpression<T> exp) {
        this.exp = exp;
    }

    @Override
    protected T calc(T a, Operations<T> ops) {
        return ops.negate(a);
    }
}
