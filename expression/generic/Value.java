package expression.generic;

public interface Value<T> {
    T toValue(String str);
}
