package demos.advanced.oop_basics.basic_oo;

/**
 * Created by michiel on 16/03/2017.
 */
public class Carrot extends Veggie {
    @Override
    public void dip(Dip dip) {
        throw new IllegalDipOperation("Carrots should not be dipped at all!");
    }
}
