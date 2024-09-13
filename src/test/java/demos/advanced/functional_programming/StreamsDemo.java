package demos.advanced.functional_programming;

import com.google.gson.Gson;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Tag("demo")
public class StreamsDemo {
    private final String demoFile = "data/cardiac.csv";

    @Test
    void optionalDemo() {
        String name = "Mike";
        Optional<String> opt = Optional.of(name);
        /* Alternative: opt = Optional.ofNullable(name);*/
        System.out.println(opt.isPresent());
        System.out.println(opt.get());
        opt.ifPresent(n -> System.out.println(n));
        System.out.println(opt.orElseGet(/*a Supplier for when no value is present*/() -> "John Doe"));

        opt = Optional.empty();
        System.out.println(opt.orElseGet(() -> "John Doe"));
        opt.ifPresentOrElse(
                /*a Consumer: what to do if present*/ n -> System.out.println(n),
                /*a Runnable: what to do if NOT present*/ () -> System.out.println("John Doe"));

    }

    @Test
    void readFilterWrite() {
        //read file into stream, try-with-resources
        Gson gson = new Gson();

        try (Stream<String> stream = Files.lines(Paths.get(demoFile))) {

            stream.//.parallel(). //just as simple!
                    skip(1).
                    map(CardiacCase::fromString).
//                    filter(cc -> cc.age() > 50).
                    limit(10).
                    peek(c -> System.out.println(c.toCsv())).
                    map(c -> gson.toJson(c)).
                    forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void mapReduce() {
        try (Stream<String> stream = Files.lines(Paths.get(demoFile))) {
            //get average of bhr*basebp double product
            OptionalDouble average = stream.
                    skip(1).
                    map(CardiacCase::fromString).
                    mapToDouble(c -> c.bhr() * c.basebp()).
                    sorted().
                    average();

            System.out.println("average = " + average.orElse(-1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void mapGroupReduce() {
        /*
          A tale of three streams.
          The first collects all cases in a map where the keys are the dose of dobutamine given.
         */
        try (Stream<String> stream = Files.lines(Paths.get(demoFile))) {

            Map<Integer, List<CardiacCase>> collect = stream.
                    skip(1).
                    map(CardiacCase::fromString).
                    collect(groupingBy(CardiacCase::dose));

            System.out.println("doses given: = " + collect.keySet());
            /* The second streams the keys of this map and applies a custom method.
             * which agian applies a stream
             */
            collect.keySet().
                    stream().
                    map(k -> collectAverage(k, collect.get(k))).  //collect average of the group of cases
                    sorted(Comparator.comparing(GroupAverage::dose)). //sort on dose
                    forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GroupAverage collectAverage(int dose, List<CardiacCase> cases) {
        double avg = cases.
                stream().
                mapToDouble(c -> c.bhr() * c.basebp()). //returns the basal double product
                average(). //gives an optional
                orElse(-1);
        return new GroupAverage(dose, avg);
    }

    /**
     * An inner record!
     * All we need is a name and properties
     * @param dose
     * @param average
     */
    record GroupAverage(int dose, double average) { }



    @Test
    void testIntelliJsuggestions() {
        List<Integer> numbers = List.of(2,3,4,5,6,7);
    numbers.parallelStream().forEach(x-> System.out.println(x));
        int sum = numbers.
                stream().
                map(n -> n * n).          // map to squared
                filter(n -> n % 2 == 0).  // only even numbers pass
                mapToInt(n -> n).         // convert to int stream
                sum();                    // sum them up

//                reduce((x, y) -> x + y).  // sum them up
//                get();                    // extract the value from the optional
//        System.out.println("sum = " + sum);

//                map(n -> "an even square: " + n).   // map to a string object
//                forEach(System.out::println);

//        collect(Collectors.toList());       // collect into a list
//                forEach(System.out::println);       // creates a new stream from the collected list!

//        collect(Collectors.toList()).       // collect into a list

    }

    @Test
    void testMapStream() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map.entrySet().stream().forEach(System.out::println);
        map.keySet().stream().forEach(System.out::println);
        map.values().stream().forEach(System.out::println);
    }

    @Test
    void factory(){
        Stream.of(2,3,4,5,6,7).
                mapToDouble(n -> Math.sqrt(n)).
                sum();                
//                forEach(x -> System.out.println(x));
    }

    @Test
    void onDemandStream(){
        Stream numbers = Stream.generate(new Supplier<Integer>() {
            Random random = new Random();
            int max = 100;
            int min = 50;
            @Override
            public Integer get() {
                final int nextInt = random.nextInt(max - min) + min;
                return nextInt;
            }
        });
        numbers
                .limit(10)
                .forEach(n -> System.out.println(n));
    }

    @Test
    void intStreamTest(){
        IntStream.range(0, 6)
                .forEach(System.out::println);

    }

    @Test
    void streamArray() {
        int[] numbers = {3, 4, 5, 6, 7};
        IntStream stream = Arrays.stream(numbers);
        double avg = stream.average().getAsDouble();
        System.out.println("avg = " + avg);

    }

    @Test
    void streamFileContents() {

        String fileName = "/Users/michielnoback/Desktop/Datasets/placebo_drug_test.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .map(l -> l.replace(',', ';'))
                    .limit(4)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void streamCharactersFromString() {
        String s = "GACT";
        s.chars()
                .peek(n -> System.out.print(n + " "))
                .mapToObj(n -> (char)n)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    void streamCharactersAndMapFromString() {
        Map<Character, String> aminoacids = Map.of(
                'M', "Met",
                'P', "Pro",
                'F', "Phe",
                'R', "Arg",
                'S', "Ser",
                'T', "Thr"); // other 18 omitted
        String s = "MPFRST";
        s.chars()
                .mapToObj(n -> (char)n)
                .map(aa -> aminoacids.get(aa))
                .forEach(n -> System.out.print(n));
    }

    @Test
    void filterOperations() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> (n % 2 == 0 && n > 5))    //even
//                .filter(n -> n > 5)         //greater than 5
                .forEach(System.out::println);
    }

    static class Wrapper{
       static String wrap1(String s){
           return "|" + s + "|";
       }

       String wrap2(String s){
           return "$" + s + "$";
       }

        static String wrap3(String s, char wrapper){
            return wrapper + s + wrapper;
        }
    }

    @Test
    void functionReferences(){
        Stream.of("a", "b", "c")
                .map(Wrapper::wrap1)
                .map(new Wrapper()::wrap2)
                //.map(Wrapper()::wrap3)                 // does not compile! Needs an extra argument
                .map(s -> Wrapper.wrap3(s, '*')) // this works
                .forEach(System.out::println);
    }


    @Test
    void streamCharactersDistinct() {
        String s = "GAACGTCCTA";
        s.chars()
                .distinct()
                .mapToObj(n -> (char)n)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    void lambdaWithMultipleStatements(){
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> {
                    n = (int)(n * 10 * Math.random());
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
    }

    @Test
    void streamStringsAndCollect() {
        System.out.println(Stream.of("a", "b", "c", "a", "c", "d", "a")
                .map(s -> s.toUpperCase())
                        .collect(Collectors.toList()));
//                .toList());

        System.out.println(Stream.of("a", "b", "c", "a", "c", "d", "a")
                .map(s -> s.toUpperCase())
                .collect(Collectors.toSet()));

        System.out.println(Stream.of("a", "b", "c", "a", "c", "d", "a")
                .map(s -> s.toUpperCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        System.out.println(Stream.of("abc", "ca", "cd", "aaa", "bab")
                .collect(Collectors.groupingBy(x -> x.length(), Collectors.toList())));
    }


    record Employee (String name, String role) {
        @Override
        public String toString(){
            return name + "(" + role + ")";
        }
    }

    @Test
    void testCollectEmployees() {
        List<Employee> employees = List.of(
                new Employee("John", "Developer"),
                new Employee("Jane", "Developer"),
                new Employee("Jack", "Tester"),
                new Employee("Jill", "Tester"),
                new Employee("Jack", "Manager")
        );

        Map<String, List<Employee>> grouped = employees.stream().collect(groupingBy(Employee::role));
        System.out.println(grouped);

    }

    @Test
    void testStringConcat() {
        List<String> strings = List.of("a", "b", "c", "d", "e");
        String concat = strings.stream().collect(Collectors.joining(","));
        System.out.println(concat);
    }

    @Test
    void testReduction() {
        List<Integer> numbers = List.of(2, 3, 4, 5);
        Integer prod = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("cumulative prod=" + prod);

        Stream.of("a", "b", "c", "d", "e")
                .reduce((a, b) -> a + '-' + b)
                .ifPresent(System.out::println);

    }

}
