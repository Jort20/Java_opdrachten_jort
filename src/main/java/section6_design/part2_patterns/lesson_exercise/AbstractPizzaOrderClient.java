package section6_design.part2_patterns.lesson_exercise;

import demos.advanced.designpatterns.builder.Pizza;

import java.util.List;

public class AbstractPizzaOrderClient implements PizzaOrderClient {
    protected Pizzeria pizzeria;

    public AbstractPizzaOrderClient(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    @Override
    public void takeOrder(Pizza pizza) {
        pizzeria.getOrders().add(pizza);
    }

    @Override
    public void takeOrders(List<Pizza> pizzas) {
        pizzeria.orders = pizzas;
    }

    @Override
    public void cancelOrder(Pizza pizza) {
        pizzeria.getOrders().remove(pizza);
    }
}
