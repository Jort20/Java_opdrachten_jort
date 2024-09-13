package demos.advanced.designpatterns.null_object;


import demos.advanced.designpatterns.null_object.Address;
import demos.advanced.designpatterns.null_object.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonTest {
    @Test
    void testPersonStream() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Henk", "Boer",
                new Address("Zernikeplein", 11, "9746BA", "Groningen")));
        persons.add(new Person("Hans", "Anders",
                new Address("Dam", 1, "1012JS", "Amsterdam")));
        persons.add(new Person("Agnes", "Dakloos",null));
        persons.add(new Person("Joost", "Wandel",
                new Address("Spuistraat", 24, "2511BD", "Den Haag")));
        persons.add(new Person("Ingrid", "Dommel",
                new Address("Leidseplein", 9, "1017PR", "Amsterdam")));

        persons.stream()
                .filter(p -> p.address().city().equals("Amsterdam"))
                .forEach(p -> System.out.println(p.firstName() + " " + p.lastName()));
    }
}