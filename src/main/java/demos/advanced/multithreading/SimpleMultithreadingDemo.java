package demos.advanced.multithreading;

public class SimpleMultithreadingDemo {
    public static void main(String[] args) {
//        SimpleWorker firstWorker = new SimpleWorker("My First Worker");
//        Thread firstThread = new Thread(firstWorker);
//        firstThread.start();
        for (int i = 0; i < 10; i++) {
            SimpleWorker worker = new SimpleWorker("_" + i + "_");
            Thread t = new Thread(worker);
            t.start();
        }
    }
}
