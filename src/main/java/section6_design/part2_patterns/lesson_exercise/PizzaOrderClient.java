package section6_design.part2_patterns.lesson_exercise;

import demos.advanced.designpatterns.builder.Pizza;

import java.util.List;

public interface PizzaOrderClient {
    void takeOrder(Pizza pizza);

    void takeOrders(List<Pizza> pizzas);

    void cancelOrder(Pizza pizza);
}
