package demos.advanced.designpatterns.filter;

import demos.advanced.designpatterns.filter.Primer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class PrimerFilterTest {

    @Test
    void testPrimerFilters() {
        List<Primer> primers = new ArrayList<>();
        primers.add(new Primer("primer1", "ATCGATCGATCGATCGAT"));
        primers.add(new Primer("primer2", "GACTCCCCTACGCTAGCAG"));
        primers.add(new Primer("primer3", "TTACATCTCACCTTTATAAA"));
        primers.add(new Primer("primer4", "GCATTAGCAGCATACTATCGCAGGCGG"));


    }

}