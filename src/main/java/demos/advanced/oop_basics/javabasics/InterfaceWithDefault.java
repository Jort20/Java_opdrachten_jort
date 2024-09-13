package demos.advanced.oop_basics.javabasics;

/**
 * Creation date: Jun 15, 2017
 *
 * @version 0.01
 * @autor Michiel Noback (&copy; 2017)
 */
public interface InterfaceWithDefault {
    /**
     * returns a Foo stub by default
     *
     * @return
     */
    default Foo createFoo() {
        return new Foo();
    }

    //an empty class just for demo
    public static class Foo {
    }
}
