package demos.advanced.oop_basics.javabasics;

public class TestInitializer {
    String name;
    static String url;

    /**
     * INSTANCE INITIALIZER
     * With an instance initializer, you can just write the code once, and it will
     * be executed no matter what constructor is used to create the object.
     * Instance initializers are also useful in anonymous inner classes, which
     * can't declare any constructors at all. The code inside an instance initializer
     * may not return.
     */ {
        name = "foo";
    }

    /**
     * STATIC OR CLASS INITIALIZER
     * The first time you access a static member such as a static field or a static
     * method, any static initializers in the class are executed — provided that you
     * haven’t already created an instance of the class. That’s because the static
     * initializers are also executed the first time you create an instance. In that
     * case, the static initializers are executed before the constructor is executed.
     */
    static {
        url = "www.example.com";
    }

    public static void main(String[] args) {
        System.out.println("starting");
        TestInitializer tin = new TestInitializer();

        System.out.println("name = " + tin.name);
        System.out.println("TestInitializer.url = " + TestInitializer.url);
    }

}
