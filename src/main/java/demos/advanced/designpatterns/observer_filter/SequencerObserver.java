package demos.advanced.designpatterns.observer_filter;

/**
 * Created by michiel on 07/03/2017.
 */
public interface SequencerObserver {
    /**
     * Client will get notified here when a new sequence has been determined/finished.
     */
    public void newSequenceDetermined(Sequence sequence);
}
