package demos.advanced.designpatterns.observer_filter;

public class SimpleSequencerObserver implements SequencerObserver {
    @Override
    public void newSequenceDetermined(Sequence sequence) {
        System.out.println("A new sequence was determined!\n" + sequence);
        //Do pathogenicity analysis on the sequence
    }
}
