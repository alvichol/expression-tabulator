package expression.generic;

import expression.MultiExpression;

public interface GenericExpression<T> {
    T evaluate(T a, T b, T c, Operations<T> ops);
}
