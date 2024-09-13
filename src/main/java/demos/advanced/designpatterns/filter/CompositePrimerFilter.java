package demos.advanced.designpatterns.filter;

import java.util.ArrayList;
import java.util.List;

public class CompositePrimerFilter implements PrimerFilter {
    private List<PrimerFilter> filters = new ArrayList<>();

    public void addFilter(PrimerFilter filter) {
        filters.add(filter);
    }

    @Override
    public boolean pass(Primer primer) {
        for (PrimerFilter filter : filters) {
            if (! filter.pass(primer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String description(Primer primer) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("{");
        for (PrimerFilter filter : filters) {
            if (! filter.pass(primer)) {
                sb.append(filter.description(primer)).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }
}
