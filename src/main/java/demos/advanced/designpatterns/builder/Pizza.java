package demos.advanced.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pizza {
    private List<Ingredient> ingredients;
    private PizzaBase base;


    private Pizza(Builder builder) {
        this.base = builder.base;
        this.ingredients = new ArrayList<>();
        for (Ingredient ingredient : builder.ingredients) {
            this.ingredients.add(ingredient);
        }
    }

    @Override
    public String toString() {
        String ingredientsStr = ingredients.stream()
                .map(i -> i.name)
                .collect(Collectors.joining(" & "));
        return "Pizza{" +
                "base=" + this.base +
                "\n\tingredients=" + ingredientsStr +
                '}';
    }

    public static class Builder {
        private final PizzaBase base;
        private List<Ingredient> ingredients = new ArrayList<>();

        private Builder(PizzaBase base) {
            this.base = base;
        }

        public Builder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Pizza build() {
            if (this.ingredients.isEmpty()) {
                throw new IllegalArgumentException("there should be at least one ingredient");
            }
            return new Pizza(this);
        }
    }

    public static Builder builder(PizzaBase base) {
        try {
            Objects.requireNonNull(base);
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("base should be provided");
        }

        return new Builder(base);
    }

    public static class Ingredient {
        private final String name;

        public Ingredient(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Ingredient{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public enum PizzaBase {
        STANDARD,
        EXTRA_THICK,
        LOW_SALT;
    }

    public static void main(String[] args) {
        Pizza pizza = Pizza
                .builder(PizzaBase.EXTRA_THICK)
                .ingredient(new Ingredient("cheese"))
                .ingredient(new Ingredient("onions"))
                .ingredient(new Ingredient("peppers"))
                .ingredient(new Ingredient("gorgonzola"))
                .build();
        System.out.println("pizza = " + pizza);
    }
}
