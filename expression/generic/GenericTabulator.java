package expression.generic;

import expression.exceptions.EvalException;

import java.math.BigInteger;

public class GenericTabulator implements Tabulator {
    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        return switch (mode) {
            case "i" -> getExpr(new IntegerOperations(), new IntValue(), expression, x1, x2, y1, y2, z1, z2);
            case "bi" -> getExpr(new BigintOperations(), new BigintValue(), expression, x1, x2, y1, y2, z1, z2);
            case "s" -> getExpr(new ShortOperations(), new ShortValue(), expression, x1, x2, y1, y2, z1, z2);
            case "u" -> getExpr(new UIntOperations(), new IntValue(), expression, x1, x2, y1, y2, z1, z2);
            case "p" -> getExpr(new PIntOperations(), new IntValue(), expression, x1, x2, y1, y2, z1, z2);
            default -> getExpr(new DoubleOperations(), new DoubleValue(), expression, x1, x2, y1, y2, z1, z2);
        };
    }

    private <T> Object[][][] getExpr(
            Operations<T> ops,
            Value<T> val,
            String expression,
            int x1, int x2,
            int y1, int y2,
            int z1, int z2
    ) throws Exception {
        GenericExpressionParser<T> parser = new GenericExpressionParser<>(val);
        GenericExpression<T> expr = parser.parse(expression);
        Object[][][] table = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    try {
                        table[i][j][k] = expr.evaluate(
                                val.toValue(Integer.toString(x1 + i)),
                                val.toValue(Integer.toString(y1 + j)),
                                val.toValue(Integer.toString(z1 + k)),
                                ops);
                    } catch (EvalException e) {
                        table[i][j][k] = null;
                    }
                }
            }
        }
        return table;
    }
}
