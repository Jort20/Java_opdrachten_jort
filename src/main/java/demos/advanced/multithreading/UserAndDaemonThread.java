package demos.advanced.multithreading;

public class UserAndDaemonThread {
    public static void main(String[] args) {
        Thread userThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("User Thread - Iteration " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon Thread - Running in the background");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        daemonThread.setDaemon(true); // Set the thread as a daemon.

        userThread.start();
        daemonThread.start();

        System.out.println("Main Method - Exiting");
    }
}
