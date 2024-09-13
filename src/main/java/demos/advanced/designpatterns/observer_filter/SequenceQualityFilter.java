package demos.advanced.designpatterns.observer_filter;

/**
 * This quality filter assumes Illumina scores and
 * fails a sequence if it contains any quality score
 * at level 0.
 * Created by michiel on 07/03/2017.
 */
public class SequenceQualityFilter implements SequenceFilter {

    @Override
    public boolean filter(Sequence sequence) {
        return !sequence.quality().contains("!!");
    }
}
