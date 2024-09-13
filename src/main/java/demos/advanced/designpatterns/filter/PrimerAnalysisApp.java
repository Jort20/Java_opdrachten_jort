package demos.advanced.designpatterns.filter;

import java.util.ArrayList;
import java.util.List;

public class PrimerAnalysisApp {
    public static void main(String[] args) {
        List<Primer> primers = new ArrayList<>();
        primers.add(new Primer("GCTCGATCGATCGAGCGAGT", "primer1"));
        primers.add(new Primer("GACTCCCCTACGCTAGCAG", "primer2"));
        primers.add(new Primer("TTACATCTCACCTTTATAAA", "primer3"));
        primers.add(new Primer("GCATTGCAGCATACTATCGCAGCG","primer4"));

        CompositePrimerFilter compositeFilter = new CompositePrimerFilter();

        compositeFilter.addFilter(new PrimerLengthFilter(10, 24));
        compositeFilter.addFilter(new MeltingTemperaturePrimerFilter(50, 65));
        compositeFilter.addFilter(new BaseRunPrimerFilter(4));

        List<Primer> passedPrimers = new ArrayList<>();

        for (Primer p : primers) {
            System.out.println("Analyzing primer: " + p.getName());
            if (! compositeFilter.pass(p)) {
                System.out.println("Primer " + p.getName() + " did not pass: " + compositeFilter.description(p));
            } else {
                passedPrimers.add(p);
            }
        }
    }
}
