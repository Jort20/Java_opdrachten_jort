package demos.advanced.designpatterns.strategy;

/**
 * Created by michiel on 02/03/2017.
 */
public abstract class AbstractBird {
    private String name;
    private FlyBehaviour flyBehabiour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehabiour = flyBehaviour;
    }

    public void fly() {
        System.out.println("I am a " + this.getName());
        this.flyBehabiour.fly();
    }

}
