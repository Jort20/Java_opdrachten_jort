package demos.advanced.oop_basics.basic_oo;

/**
 * Created by michiel on 16/03/2017.
 */
public interface Dippable {
    default void dip(Dip dip) {
        System.out.println(this.getClass().getSimpleName() + " dipping in " + dip.name());
    }
}
