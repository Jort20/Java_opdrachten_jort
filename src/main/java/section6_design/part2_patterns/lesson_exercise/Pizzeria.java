package section6_design.part2_patterns.lesson_exercise;

import demos.advanced.designpatterns.builder.Pizza;

import java.util.LinkedList;
import java.util.List;

public class Pizzeria {
    private String name;

    protected List<Pizza> orders = new LinkedList<>();

    public Pizzeria(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pizza> getOrders() {
        return orders;
    }

    public void setOrders(List<Pizza> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Pizzeria{" +
                "name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
