package demos.advanced.multithreading;

import demos.advanced.multithreading.JavaUtilConcurrentDemo;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class JavaUtilConcurrentDemoTest {

    @Test
    void singleExecutor() {
        JavaUtilConcurrentDemo demo = new JavaUtilConcurrentDemo();
        demo.singleExecutor();
    }

    @Test
    void executorService() {
        JavaUtilConcurrentDemo demo = new JavaUtilConcurrentDemo();
        demo.executorService();
    }

    @Test
    void timerTask() {
        TimerTask task = new TimerTask() {
            public void run() {
                //The job you want to execute
                System.out.println("Job executed: " + new Date() + "\nThread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L; //will be dealt with in milliseconds
        timer.schedule(task, delay);

        //alternative
        //timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }
}