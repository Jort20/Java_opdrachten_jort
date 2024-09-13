package demos.basic.enums;

import demos.basic.enums.PizzaSize;
import org.junit.jupiter.api.Test;

class PizzaSizeTest {

    @Test
    void testOrdinal() {
        PizzaSize pz = PizzaSize.LUNATIC;

        if (pz.ordinal() >= PizzaSize.LARGE.ordinal()) {
            System.out.println("Are you sure? This size is for really hungry people.");
        }
    }
}