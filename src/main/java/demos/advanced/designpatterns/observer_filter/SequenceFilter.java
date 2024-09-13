package demos.advanced.designpatterns.observer_filter;

/**
 * Created by michiel on 07/03/2017.
 */
public interface SequenceFilter {
    /**
     * method accepts a sequence object and tells whether
     * it passes the implementers' criteria
     *
     * @param sequence
     * @return accepted
     */
    public boolean filter(Sequence sequence);

}
