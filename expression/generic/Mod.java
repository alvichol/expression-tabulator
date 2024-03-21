package expression.generic;

public class Mod<T> extends GenericBinary<T> {
    public Mod(GenericExpression<T> first, GenericExpression<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    protected T calc(T a, T b, Operations<T> ops) {
        return ops.mod(a, b);
    }
}
