package demos.advanced.designpatterns.singleton;

public class ClassicSingleton {
    //PART ONE: THE SINGLE INSTANCE
    private static ClassicSingleton instance;

    //PART TWO: THE PRIVATE CONSTRUCTOR
    private ClassicSingleton() {
    }

    //PART THREE: THE PUBLIC STATIC GETTER
    public static ClassicSingleton getInstance() {
        if (instance == null) {
            //LAZY INITIALIZATION!
            instance = new ClassicSingleton();
        }
        return instance;
    }
}
