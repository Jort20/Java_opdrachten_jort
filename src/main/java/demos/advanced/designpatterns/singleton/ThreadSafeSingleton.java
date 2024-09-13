package demos.advanced.designpatterns.singleton;

/**
 * Creation date: Jul 08, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class ThreadSafeSingleton {
    //volatile -- keep in main memory, not in thread-local cache
    private static volatile ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            //synchronized -- ensures that only one thread can enter this block at a time
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
