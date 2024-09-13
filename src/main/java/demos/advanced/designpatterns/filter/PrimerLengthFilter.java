package demos.advanced.designpatterns.filter;

public class PrimerLengthFilter implements PrimerFilter{
    private int minLength;
    private int maxLength;

    public PrimerLengthFilter(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean pass(Primer primer) {
        return primer.length() >= minLength && primer.length() <= maxLength;
    }

    @Override
    public String description(Primer primer) {
        return getClass().getSimpleName() + "{" + "min length=" + minLength + ", max length=" + maxLength + "}; ACTUAL=" + primer.length();
    }
}
