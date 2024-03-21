package expression.generic;

import expression.exceptions.*;

public class GenericExpressionParser<T> {
    private int index;
    private String expression;
    private final Value<T> value;

    public GenericExpressionParser(Value<T> value) {
        this.value = value;
    }

    public GenericExpression<T> parse(String expression) throws Exception {
        index = 0;
        this.expression = expression;
        if (!correctBrackets()) {
            throw new InvalidExprException("invalid brackets");
        }
        return parseAddSub();
    }

    private boolean correctBrackets() {
        int balance = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                balance++;
            } else if (expression.charAt(i) == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    private void skipWhitespace() {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }

    private void checkIndex() {
        if (index == expression.length()) {
            throw new InvalidExprException("operand or operator expected");
        }
    }

    private GenericExpression<T> parseAddSub() {
        //System.out.println("addsub " + index);
        return parseBinary(ExpressionType.ADDSUB);
    }

    private GenericExpression<T> parseMulDiv() {
        //System.out.println("muldiv " + index);
        return parseBinary(ExpressionType.MULDIV);
    }

    private String getOperator() {
        StringBuilder sb = new StringBuilder();
        if (index < expression.length() && !Character.isLetter(expression.charAt(index))) {
            return Character.toString(expression.charAt(index++));
        }
        while (index < expression.length() &&
                (Character.isLetter(expression.charAt(index)) || Character.isDigit(expression.charAt(index)))) {
            sb.append(expression.charAt(index));
            index++;
        }
        return sb.toString();
    }

    private String getStringConst() {
        StringBuilder sb = new StringBuilder();
        if (expression.charAt(index) == '-') {
            sb.append('-');
            index++;
        }
        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
            sb.append(expression.charAt(index));
            index++;
        }
        if (index < expression.length() && Character.isLetter(expression.charAt(index))) {
            throw new InvalidExprException("unknown combination of numbers and letters");
        }
        return sb.toString();
    }

    private GenericExpression<T> parseVarConst() {
        //System.out.println("varconst " + index);
        skipWhitespace();
        checkIndex();
        if (Character.isLetter(expression.charAt(index))) {
            return switch (getOperator()) {
                case "x" -> new GenericVariable<>("x");
                case "y" -> new GenericVariable<>("y");
                case "z" -> new GenericVariable<>("z");
                default -> throw new InvalidExprException("unknown variable");
            };
        }
        try {
            return new GenericConst<>(value.toValue(getStringConst()));
        } catch (NumberFormatException e) {
            throw new InvalidExprException("Can't parse number");
        }
    }

    private GenericExpression<T> parseByType(ExpressionType type) {
        return switch (type) {
            case GCDLCM -> parseAddSub();
            case ADDSUB -> parseMulDiv();
            case MULDIV -> parseUnary();
        };
    }

    private boolean checkOperator(String op, ExpressionType type) {
        return switch (op) {
            case "+", "-" -> (type == ExpressionType.ADDSUB);
            case "*", "/", "mod" -> (type == ExpressionType.MULDIV);
            case "", ")" -> false;
            default -> throw new InvalidExprException("unknown operand");
        };
    }

    private GenericExpression<T> parseBinary(ExpressionType type) {
        GenericExpression<T> left, right;
        left = parseByType(type);
        if (left == null) {
            throw new InvalidExprException("no operand");
        }
        while (true) {
            skipWhitespace();
            int oldIndex = index;
            String op = getOperator();
            if (!checkOperator(op, type)) {
                index = oldIndex;
                break;
            }
            right = parseByType(type);
            if (right == null) {
                throw new InvalidExprException("no operand");
            }
            left = switch (op) {
                case "+" -> new GenericAdd<>(left, right);
                case "-" -> new GenericSubtract<>(left, right);
                case "*" -> new GenericMultiply<>(left, right);
                case "/" -> new GenericDivide<>(left, right);
                case "mod" -> new Mod<>(left, right);
                default -> throw new InvalidExprException("unknown operation");
            };
        }
        return left;
    }

    private GenericExpression<T> parseUnary() {
        //System.out.println("unary " + index);
        skipWhitespace();
        checkIndex();
        if (expression.charAt(index) == '-' &&
                (index == expression.length() - 1 || !Character.isDigit(expression.charAt(index + 1)))) {
            index++;
            return new GenericNegate<>(parseUnary());
        }

        int oldIndex = index;
        switch (getOperator()) {
            case "square" -> {
                return new Square<>(parseUnary());
            }
            case "abs" -> {
                return new Abs<>(parseUnary());
            }
            default -> {
                index = oldIndex;
                return parseBrackets();
            }
        }
    }

    private GenericExpression<T> parseBrackets() {
        //System.out.println("brackets " + index);
        skipWhitespace();
        checkIndex();
        if (expression.charAt(index) == '(') {
            index++;
            GenericExpression<T> exp = parseAddSub();
            skipWhitespace();
            index++;
            return exp;
        }
        return parseVarConst();
    }
}
