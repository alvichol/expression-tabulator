package expression.generic;

public class GenericDivide<T> extends GenericBinary<T> {
    public GenericDivide(GenericExpression<T> first, GenericExpression<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    protected T calc(T a, T b, Operations<T> ops) {
        return ops.divide(a, b);
    }
}
