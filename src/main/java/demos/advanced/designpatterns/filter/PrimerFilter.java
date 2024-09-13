package demos.advanced.designpatterns.filter;

public interface PrimerFilter {
    /**
     * checks the given primer.
     */
    boolean pass(Primer primer);

    /**
     * Returns the description of this filter.
     */
    String description(Primer primer);
}
