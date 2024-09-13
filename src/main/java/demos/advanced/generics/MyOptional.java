package demos.advanced.generics;

import java.util.function.Supplier;

public class MyOptional<T> {
    private T value;

    private MyOptional(T value) {
        this.value = value;
    }

    static <T> MyOptional<T> of(T value) {
        return new MyOptional<T>(value);
    }

    static <T> MyOptional<T> empty() {
        return new MyOptional<T>(null);
    }

    public T getValueOrDefault(Supplier<T> supplier) {
        if (value != null) {
            return value;
        } else {
            return supplier.get();
        }
    }
}
