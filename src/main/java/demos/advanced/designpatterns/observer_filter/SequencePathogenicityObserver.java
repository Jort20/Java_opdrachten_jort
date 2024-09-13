package demos.advanced.designpatterns.observer_filter;

/**
 * Implementation for scanning for pathogenicity-specific sequences.
 * Created by michiel on 07/03/2017.
 */
public class SequencePathogenicityObserver extends AbstractSequenceObserver {
    @Override
    public void newSequenceDetermined(Sequence sequence) {
        //System.out.println(this.getFilter());
        boolean accept = this.applyFilters(sequence);
        if (!accept) {
            System.out.println(">>>" + this.getClass().getSimpleName() + " has found a pathogenic bacterium; alerting CDC!");
            //alert CDC
        }
    }
}
