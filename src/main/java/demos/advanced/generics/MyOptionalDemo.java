package demos.advanced.generics;

import java.util.function.Supplier;

public class MyOptionalDemo {
    public static void main(String[] args) {
        MyOptional<String> stringOptional = MyOptional.of("Hello, ");
        String valueOrDefault1 = stringOptional.getValueOrDefault(() -> "World");
        System.out.println(valueOrDefault1.toUpperCase()); // No casting required because of generic declaration

        MyOptional<String> emptyOptional = MyOptional.empty();
        String valueOrDefault2 = emptyOptional.getValueOrDefault(new Supplier<String>() {
            @Override
            public String get() {
                return "World";
            }
        });
        System.out.println(valueOrDefault2.toUpperCase());
    }
}
