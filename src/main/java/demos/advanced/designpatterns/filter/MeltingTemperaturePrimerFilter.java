package demos.advanced.designpatterns.filter;

public class MeltingTemperaturePrimerFilter implements PrimerFilter {
    private double minTm;
    private double maxTm;

    public MeltingTemperaturePrimerFilter(double minTm, double maxTm) {
        this.minTm = minTm;
        this.maxTm = maxTm;
    }

    @Override
    public boolean pass(Primer primer) {
        return primer.getMeltingPoint() >= minTm && primer.getMeltingPoint() <= maxTm;
    }

    @Override
    public String description(Primer primer) {
        return getClass().getSimpleName() + "{" + "min Tm=" + minTm + ", max Tm=" + maxTm + "}; ACTUAL=" + primer.getMeltingPoint();
    }
}
