package expression.generic;

public class GenericConst<T> implements GenericExpression<T> {
    T val;
    public GenericConst(T value) {
        val = value;
    }

    @Override
    public T evaluate(T a, T b, T c, Operations<T> ops) {
        return ops.projector(val);
    }
}
