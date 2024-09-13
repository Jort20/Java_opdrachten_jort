package demos.advanced.designpatterns.filter;

public class BaseRunPrimerFilter implements PrimerFilter {
    private int maxBaseRun;

    public BaseRunPrimerFilter(int maxBaseRun) {
        this.maxBaseRun = maxBaseRun;
    }

    @Override
    public boolean pass(Primer primer) {
        return ! primer.hasBaseRun(maxBaseRun);
    }

    @Override
    public String description(Primer primer) {
        return getClass().getSimpleName() + "{" + "max base run=" + maxBaseRun + "}";
    }
}
