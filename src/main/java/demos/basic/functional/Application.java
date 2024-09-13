package demos.basic.functional;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("I am the entry point of this app");

        List<Integer> numbers = List.of(3,2,1,4,5,6);

        for (int number: numbers) {
            System.out.println(number);
        }
        //def my_sorter(x):
        //    return x[1]
        //python list.sort(key = my_sorter)
        //python list.sort(key = lambda x: x[1])

        numbers.forEach(n -> System.out.println(n));

        numbers.stream().
                filter(x -> x < 5).
                mapToDouble(x -> x*0.5).
                forEach(System.out::println);
        //numbers.forEach();

    }


    interface Printable {
        void printTheObject(Object o);
    }

    static void printIt(Object o) {
        System.out.println(o.toString());
    }

}
