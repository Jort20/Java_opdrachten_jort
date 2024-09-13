package demos.advanced.oop_basics.javabasics;

import java.util.logging.Logger;

/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class MyApp {
    public static void main(String[] args) {
        new MyApp().start();
    }

    private MyApp() {
    }

    private void start() {
        Logger.getLogger("MyApp.class").info("Starting the analysis");
    }
}
