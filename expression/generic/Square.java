package expression.generic;

public class Square<T> extends GenericUnary<T> {
    public Square(GenericExpression<T> exp) {
        this.exp = exp;
    }

    @Override
    protected T calc(T a, Operations<T> ops) {
        return ops.square(a);
    }
}
