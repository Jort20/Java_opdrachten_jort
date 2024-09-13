package demos.basic.functional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

@Tag("demo")
public class FunctionalDemo {


    /**
     * This is called a *functional interface* because it has a single non-default method defined.
     * Such interfaces can be used in functional programming settings.
     */
    interface Combiner<E, R>{
        R combine(E x, E y);
    }


    interface NumberCombiner{
        double combine(int x, int y);
    }

    interface Mapper<I, R>{
        R mapIt(I input);
    }

    class StringToIntMapper implements Mapper<String, Integer> {
        @Override
        public Integer mapIt(String input) {
            return input.length();
        }
    }

    /**
     * This is an old-school implementation of the interface.
     */
    class AdditionCombiner implements NumberCombiner {
        @Override
        public double combine(int x, int y) {
            return x + y;
        }
    }

    /**
     * This is an old-school implementation of the interface.
     */
    class GenericAdditionCombiner implements Combiner<Integer, Double> {
        @Override
        public Double combine(Integer x, Integer y) {
            return Double.valueOf(x + y);
        }
    }

    /**
     * nl.bioinf.streams_demo.User of combiner.
     * It has no clue what the combiner is going to do;
     * It only knows the contract will by definition be implemented (otherwise the compiler would have rejected it).
     * @param combiner
     */
    void useAcombiner(Combiner combiner) {
        System.out.println("Class _"
                + combiner.getClass().getSimpleName()
                + "_ combines 2 and 4: "
                + combiner.combine(2, 4));

        Combiner<Integer, Double> additionCombiner = (x, y) -> Double.valueOf(x + y);

    }


    void useAcombiner(int x, int y, NumberCombiner combiner) {
        System.out.println("Combining " + x + " and " + y + ": " + combiner.combine(2, 4));
    }

    @Test
    void additionCombiner() {
        //old school
        NumberCombiner nc = new AdditionCombiner();
        System.out.println("Combining 2 and 4 with AdditionCombiner: " + nc.combine(2, 4));

        //useAcombiner(new GenericAdditionCombiner());
    }

    @Test
    void multiplierCombiner() {
        NumberCombiner multiplierCombiner = (x, y) -> x * y;
        System.out.println(multiplierCombiner.combine(2, 4)); // prints 8.0
        BiFunction<Integer, Integer, Double> bf = (integer1, integer2) -> Double.valueOf(integer1 * integer2);

        //old school with anonymous inner class
        useAcombiner(5, 3, (x, y) -> x * y);

        //old school with anonymous inner class
        useAcombiner(new Combiner<Integer, Double>() {
            @Override
            public Double combine(Integer x, Integer y) {
                return (double)x * y;
            }
        });
    }

    @Test
    void usingLambdas() {
        //a Lambda implementer of the interface!
        useAcombiner((a, b) -> {
            return (double)a / (double)b;
        });
    }
}
