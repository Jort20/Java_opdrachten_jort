package demos.advanced.designpatterns.observer_filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract superclass defines all generic observer code
 * Created by michiel on 07/03/2017.
 */
public abstract class AbstractSequenceObserver implements SequencerObserver {
    private List<SequenceFilter> filters;

    /**
     * adds a Filter to the current observer.
     *
     * @param filter
     */
    public void addSequenceFilter(SequenceFilter filter) {

        if (null == this.filters) {
            this.filters = new ArrayList<>();
        }
        this.filters.add(filter);
    }

    /**
     * Returns a unmodifiable view of the filters
     *
     * @return
     */
    public List<SequenceFilter> getFilters() {
        return Collections.unmodifiableList(filters);
    }

    /**
     * clears the current filter collection.
     */
    public void clearFilters() {
        this.filters.clear();
    }


    /**
     * applies all filters to the given sequence.
     *
     * @param sequence
     * @return accepted
     */
    public boolean applyFilters(Sequence sequence) {
        for (SequenceFilter sf : this.filters) {
            if (!sf.filter(sequence)) {
                return false;
            }
        }
        return true;
    }
}
