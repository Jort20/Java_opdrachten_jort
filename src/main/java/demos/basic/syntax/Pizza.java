package demos.basic.syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private PizzaBase base;
    private List<String> toppings = new ArrayList<>();

    public Pizza() {
        this(PizzaBase.THIN);
    }

    public Pizza(PizzaBase base) {
        this.base = base;
    }

    public Pizza(String... ingredients) {
        this(PizzaBase.THIN, ingredients);
    }

    List<String> getIngredients() {
        Collections.frequency(toppings, "cheese");
        return Collections.unmodifiableList(toppings);
    }
    public Pizza(PizzaBase base, String... ingredients) {
        this.base = base;
        for (String topping : ingredients) {
            toppings.add(topping);
        }
    }

    public static Pizza createThinPizza(String... ingredients) {
        return createPizza(PizzaBase.THIN, ingredients);
    }

    public static Pizza createThickPizza(String... ingredients) {
        return createPizza(PizzaBase.THICK, ingredients);
    }

    //PRIVATE
    private static Pizza createPizza(PizzaBase base, String... ingredients) {
        Pizza p = new Pizza(base);
        Arrays.stream(ingredients).forEach(i -> p.addIngredient(i));
        return p;
    }
    /**
     * Adds a single ingredient.
     * @param ingredient
     */
    private void addIngredient(String ingredient) {
        this.toppings.add(ingredient);
    }

    /**
     * adds multiple ingredients.
     * @param ingredients
     */
    void addIngredients(List<String> ingredients) {
        this.toppings.addAll(ingredients);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "base='" + base + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
