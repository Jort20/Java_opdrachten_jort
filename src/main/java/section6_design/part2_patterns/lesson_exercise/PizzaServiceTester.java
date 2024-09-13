package section6_design.part2_patterns.lesson_exercise;

import demos.advanced.designpatterns.builder.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaServiceTester {
    public static void main(String[] args) {
        PizzaServiceTester tester = new PizzaServiceTester();
        tester.start();
    }

    private void start() {
        Pizzeria pizzeria = new Pizzeria("Frutti di Mundi!");
        System.out.println("pizzeria = " + pizzeria);

        PizzaOrderClient online = new OnlineOrderService(pizzeria);
        PizzaOrderClient customer = new WalkInCustomer(pizzeria);

        Pizza margarita = Pizza.builder(
                Pizza.PizzaBase.EXTRA_THICK)
                .ingredient(new Pizza.Ingredient("Tomato sauce"))
                .ingredient(new Pizza.Ingredient("Cheese"))
                .build();

        Pizza paizana = Pizza.builder(
                Pizza.PizzaBase.STANDARD)
                .ingredient(new Pizza.Ingredient("Tomato sauce"))
                .ingredient(new Pizza.Ingredient("Ham"))
                .ingredient(new Pizza.Ingredient("Onions"))
                .ingredient(new Pizza.Ingredient("Gorgonzola"))
                .build();

        Pizza fruttiDiMare = Pizza.builder(
                Pizza.PizzaBase.LOW_SALT)
                .ingredient(new Pizza.Ingredient("Tomato sauce"))
                .ingredient(new Pizza.Ingredient("Cheese"))
                .ingredient(new Pizza.Ingredient("Shrimps"))
                .ingredient(new Pizza.Ingredient("Salmon"))
                .build();

        List<Pizza> onlineOrders = new ArrayList<>();
        onlineOrders.add(margarita);
        onlineOrders.add(paizana);
        online.takeOrders(onlineOrders);

        System.out.println("pizzeria = " + pizzeria);

        customer.takeOrder(fruttiDiMare);

        ((WalkInCustomer) customer).getDisgruntled();

        System.out.println("pizzeria = " + pizzeria);

        ((OnlineOrderService) online).getHacked();

        System.out.println("pizzeria = " + pizzeria);

        online.takeOrder(paizana);

        System.out.println("pizzeria = " + pizzeria);
    }
}
