package expression.generic;

public class IntValue implements Value<Integer> {
    @Override
    public Integer toValue(String str) {
        return Integer.parseInt(str);
    }
}
