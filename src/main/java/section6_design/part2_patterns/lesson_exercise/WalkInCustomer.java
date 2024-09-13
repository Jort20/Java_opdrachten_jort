package section6_design.part2_patterns.lesson_exercise;

public class WalkInCustomer extends AbstractPizzaOrderClient {
    public WalkInCustomer(Pizzeria pizzeria) {
        super(pizzeria);
    }

    public void getDisgruntled() {
        pizzeria.getOrders().clear();
        pizzeria.setName("This place sucks!");
    }
}
