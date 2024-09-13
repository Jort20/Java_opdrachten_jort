package demos.advanced.oop_basics.basic_oo;

/**
 * Created by michiel on 16/03/2017.
 */
public class Cheese implements Dippable {
    @Override
    public void dip(Dip dip) {
        if (dip == Dip.GUACEMOLE) {
            throw new IllegalDipOperation("Cheese should not be dipped in quacemole");
        }
        Dippable.super.dip(dip);
    }
}
