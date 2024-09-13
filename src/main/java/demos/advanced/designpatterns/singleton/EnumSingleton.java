package demos.advanced.designpatterns.singleton;

public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("I am doing something");
    }
}
