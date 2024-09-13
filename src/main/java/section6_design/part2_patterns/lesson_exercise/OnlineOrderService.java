package section6_design.part2_patterns.lesson_exercise;

public class OnlineOrderService extends AbstractPizzaOrderClient {

    public OnlineOrderService(Pizzeria pizzeria) {
        super(pizzeria);
    }

    public void getHacked() {
        super.pizzeria.orders = null;
    }
}
