package expression.generic;

public class DoubleValue implements Value<Double> {

    @Override
    public Double toValue(String str) {
        return Double.parseDouble(str);
    }
}
