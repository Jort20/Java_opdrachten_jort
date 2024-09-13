package demos.advanced.functional_programming;

//import javafx.scene.control.Button;

import javax.swing.*;
import java.util.Comparator;
import java.util.function.Consumer;

public class LambdasIntro {
    public static void main(String[] args) {

//        NumberCombiner multiplyCombiner = new NumberCombiner() {
//            @Override
//            public int combine(int i, int j) {
//                return i * j;
//            }
//        };

        NumberCombiner multiplyCombiner = (i, j) -> j * j;

        final Consumer<String> stringConsumer = (String m) -> System.out.println(m);
        stringConsumer.accept("Hi");

        JButton b = new JButton();
        b.addActionListener((event) -> System.out.println(event.getActionCommand()));
        b.doClick();
        //.setOnAction((event) -> System.out.println(event.getEventType()));

        Comparator<String> comp;
        comp = (String first, String second) -> Integer.compare(first.length(), second.length());
        //Same as
        comp = (first, second) -> Integer.compare(first.length(), second.length());
        //same as
        comp = (first, second) -> {
            return Integer.compare(first.length(), second.length());
        };
        //Same as
        comp = new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.compare(first.length(), second.length());
            }
        };

        //call it
        System.out.println("comp = " + comp.compare("foo", "barr"));
//
//        List<String> l = new ArrayList<>();
//        l.add("foo");
//        l.add("bar");
//        l.add("drool");
//        l.add("gooish");
//        l.add("ha");
//        //Java 9: List.of("foo", "bar", "drool", "gooish", "ha");
//
//        Collections.sort(l, comp);
//        System.out.println("l.toString() = " + l.toString());



    }
}
