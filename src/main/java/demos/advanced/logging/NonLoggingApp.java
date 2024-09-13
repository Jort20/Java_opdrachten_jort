package demos.advanced.logging;

import java.io.IOException;

public class NonLoggingApp {
    public static void main(String[] args) {
        NonLoggingApp app = new NonLoggingApp();
        app.start();
    }

    private void start() {
        System.out.println("starting the good work");
        try {
            doBusiness();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong - exiting!");
        }
        System.out.println("finished");
    }

    private void doBusiness() throws IOException {

    }
}
