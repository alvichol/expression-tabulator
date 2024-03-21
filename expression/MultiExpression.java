package expression;

import expression.generic.Operations;

public interface MultiExpression {
    int getPrior();
    boolean nonAssociativeBinary();
    int getType();
}
