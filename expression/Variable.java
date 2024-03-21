package expression;

import expression.generic.Operations;

public class Variable implements MultiExpression {
    private final String name;
    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Variable that = (Variable) obj;
        return this.name.equals(that.name);
    }

    @Override
    public int getPrior() {
        return 0;
    }

    @Override
    public boolean nonAssociativeBinary() {
        return false;
    }

    @Override
    public int getType() {
        return 0;
    }
}
