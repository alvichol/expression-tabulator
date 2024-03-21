package expression.generic;

import expression.Variable;

public class GenericVariable<T> implements GenericExpression<T> {
    private final String name;
    public GenericVariable(String name) {
        this.name = name;
    }

    @Override
    public T evaluate(T a, T b, T c, Operations<T> ops) {
        return switch (name) {
            case "x" -> ops.projector(a);
            case "y" -> ops.projector(b);
            case "z" -> ops.projector(c);
            default -> null;
        };
    }
}
