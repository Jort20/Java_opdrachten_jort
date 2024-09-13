package demos.advanced.designpatterns.observer_filter;

/**
 * This pathogenicity filter assumes a sequence to be of pathogenic
 * origin if it contains a quadruple A sequence (AAAA).
 * Created by michiel on 07/03/2017.
 */
public class EnterococcusPathogenFilter implements SequenceFilter {
    @Override
    public boolean filter(Sequence sequence) {
        return !sequence.sequence().contains("AAA");
    }
}
