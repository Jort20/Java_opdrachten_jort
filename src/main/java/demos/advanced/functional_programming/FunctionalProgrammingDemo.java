package demos.advanced.functional_programming;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * Creation date: 31-1-2018
 *
 * @author Michiel Noback (&copy; 2018)
 * @version 0.01
 */
public class FunctionalProgrammingDemo {
    public static final String[] words = {"arg", "bah", "yeah", "howwie", "aw", "whoa", "yuck"};
    public static final List<User> USERS;

    static {
        USERS = new ArrayList<>();

        Address aOne = new Address();
        aOne.setNumber(1);
        aOne.setStreet("Barker Street");
        aOne.setZipCode("7765VV");

        Address aTwo = new Address();
        aTwo.setNumber(32);
        aTwo.setStreet("Overhill");
        aTwo.setZipCode("6667AS");

        Address aThree = new Address();
        aThree.setStreet("Beverly Hills");
        aThree.setZipCode("9021OO");

        User u;
        u = new User();
        u.setAddress(aOne);
        u.setName("Frodo Baggins");
        u.setNumberOfLogins(4);
        USERS.add(u);

        u = new User();
        u.setAddress(aTwo);
        u.setName("Gandalf the Grey");
        u.setNumberOfLogins(5);
        USERS.add(u);

        u = new User();
        u.setAddress(aOne);
        u.setName("Samwise Gamgee");
        u.setNumberOfLogins(1);
        USERS.add(u);

        u = new User();
        u.setAddress(aTwo);
        u.setName("Saruman the White");
        u.setNumberOfLogins(476);
        USERS.add(u);

        u = new User();
        u.setName("Aragorn");
        u.setNumberOfLogins(2);
        USERS.add(u);

        u = new User();
        u.setName("Gimli");
        u.setNumberOfLogins(7);
        u.setAddress(aThree);
        USERS.add(u);

        u = new User();
        u.setName("Boromir");
        u.setNumberOfLogins(0);
        USERS.add(u);

    }

    public static void main(String[] args) {
//        NumberCombiner nc = (i, j) -> i*j;
//        System.out.println("2 * 3 = " + nc.combine(2,3));
//        nc = (i, j) -> (int)Math.pow(i, j);
//        System.out.println("2 ^ 3 = " + nc.combine(2,3));
//        combineAndPrint(3, 4, (i, j) -> (int)(i * j * Math.random()));

        //Demo Predicate interface

//        filterUsers((user) -> user.getAddress() != null);
//        filterUsers((user) -> user.getNumberOfLogins() > 10);
        simpleStream();
    }

    public static void simpleStream() {

        Arrays.stream(words).forEach(w -> System.out.println(w));
        final int sumOfLengths = Arrays.stream(words)
                .mapToInt(String::length)
                .reduce(0, Integer::sum);

        out.println("sumOfLengths = " + sumOfLengths);
        Arrays.stream(words)
                .mapToInt(String::length)
                .reduce((x, y) -> x + y)
                .ifPresent(s -> System.out.println(s));


        //List<String> list = Arrays.asList(words);
        //list.stream().forEach(w -> System.out.println(w));
    }

    public void streamToStream() {
        Arrays.stream(words).map(w -> w.length()).forEach(System.out::println);
    }

    public void streamToOptional() {
        System.out.println(Arrays.stream(words)
                .map(String::length)
                .max((one, two) -> Integer.compare(one, two)).get());
        //same as (Integer::compare).get());
    }

    public void streamToCollector() {
        List<Integer> collected = Arrays.stream(words)
                .map(String::length)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collected = " + collected);
    }

    public void toSumReduction() {
        Optional<Integer> sum = Arrays.stream(words)
                .map(String::length)
                .reduce((x, y) -> x + y);
        System.out.println("sum.get() = " + sum.get());
    }

    public void frequencyReduction() {
        Map<Integer, Long> collect = Arrays.stream(words)
                .map(String::length)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //similar to (only Integers)
        Map<Integer, Integer> collectAlt = Arrays.stream(words)
                .map(String::length)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));

        System.out.println("collect = " + collect);
        System.out.println("collect = " + collectAlt);
    }

    public void customObjectsStream() {
        FunctionalProgrammingDemo.USERS.stream()
                .map((u) -> {
                    if (u.getAddress() == null) {
                        Address a = new Address();
                        a.setStreet("Homeless");
                        return a;
                    } else {
                        return u.getAddress();
                    }
                })
                .distinct()
                .forEach(a -> System.out.println(a.getStreet()));
    }


    public static void mapSortedUsersToStringAndPrint() {
        //sorted and Function<T,R>
        USERS
                .stream()
                .sorted(Comparator.comparingInt(User::getNumberOfLogins).reversed())
                .map(user -> user.getName() + "[logins:" + user.getNumberOfLogins() + "]").forEach(out::println);
    }

    public static void groupByStreetAndListName() {
        final Map<String, List<User>> collect2 = USERS.stream().collect(Collectors.groupingBy(user -> user.getAddress().getStreet()));
        collect2.entrySet().stream().forEach(entry -> {
            out.print(entry.getKey() + " --> ");
            ((List<User>) entry.getValue()).forEach(u -> out.print(u.getName() + "+"));
        });
    }

    public static void groupByStreetAndCount() {
        //Group by street attribute of address and count
        final Map<String, Long> collect =
                USERS
                        .parallelStream()
                        .peek(u -> out.println(u.getName() + ": " + u.getAddress()))
                        .collect(Collectors.groupingBy(user -> user.getAddress().getStreet(), Collectors.counting()));
        collect.forEach((k, v) -> out.println("k=" + k + "; v=" + v));
    }

    public static void combineAndPrint(int i, int j, NumberCombiner combiner) {
        out.println("combining i = " + i + " and j = " + j + " to " + combiner.combine(i, j));
    }

    /**
     * demo of Predicate Functional Interface
     * @param p
     */
    public static void filterUsers(Predicate<User> p) {
        USERS.stream().filter(p).forEach(user -> out.println(user.getName() + " passed"));
    }


    /**
     * suppose you have this alignment:
     * GAATC-GACGACTACG
     * - !  !
     * GAATCCGCCGCCTACG
     * then the alignment can be described as "     - !  !     "
     * and this can be used to calculate an alignment score
     */
    public static void mapToObjectDemo(String alignment) {
        //note that .mapToObj(c -> (char) c) will take care of autoboxing to Character
        final int sum = alignment.chars()
                .mapToObj(c -> (char) c)
                .peek(character -> out.print("{" + character + "}"))
                .map(AlignmentSymbol::of)
                .mapToInt(AlignmentSymbol::getScore)
                .peek(x -> out.print("[" + x + "]"))
                .sum();
        out.println("\nscore = " + sum);
    }

    public static void streamFileContents() {
        Path path = Paths.get("data/alice.txt");
        try {
            final Optional<String> longestWord = Files.lines(path)
                    .map(FunctionalProgrammingDemo::getLongestWordOfLine)
                    .distinct()
                    .min((one, two) -> Integer.compare(two.length(), one.length()));
            //streamOfStrings.map()

            out.println("longestWord = " + longestWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLongestWordOfLine(String line) {
        final String[] split = line.split("[\\P{L}]+");
        return Stream.of(split)
                .distinct()
                .max((one, two) -> Integer.compare(two.length(), one.length()))
                .orElse("");

        //.max() is same as .sorted().findfirst()
    }

    public static void findLongestWordAlice() {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("data/alice.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

//see https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html for Java advanced regex
        Stream.of(contents.split("[\\P{L}]+"))
                .sorted((one, two) -> Integer.compare(two.length(), one.length()))
                .distinct()
                .limit(10)
                .sorted((one, two) -> one.compareTo(two))
                .forEach(w -> System.out.println(w + " has length " + ((String) w).length()));
    }
}
