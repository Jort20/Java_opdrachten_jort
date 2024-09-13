package demos.advanced.designpatterns.observer_filter;

public class Main {
    public static Sequencer sqr;

    /**
     * main starts up the application and initializaes core objects.
     *
     * @param args
     */
    public static void main(String[] args) {
        //create sequencer and dummy sequences
        sqr = new Sequencer();
        sqr.createDummySequences(25, 25);
        sqr.registerObserver(new SimpleSequencerObserver());
        sqr.sequence();


        //create sequence quality observer and its filter and register it
//        SequenceQualityObserver qualObs = new SequenceQualityObserver();
//        qualObs.addSequenceFilter(new SequenceQualityFilter());
//        sqr.registerObserver(qualObs);
//
//        //create pathogenicity observer and its filter and register it
//        SequencePathogenicityObserver pathObs = new SequencePathogenicityObserver();
//        pathObs.addSequenceFilter(new EnterococcusPathogenFilter());
//        pathObs.addSequenceFilter(new StaphAureusPathogenFilter());
//        sqr.registerObserver(pathObs);
//
//        //start sequencing
//        sqr.sequence();


    }
}
