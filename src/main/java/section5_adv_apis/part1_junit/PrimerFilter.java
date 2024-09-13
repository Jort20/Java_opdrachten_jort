/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package section5_adv_apis.part1_junit;

/**
 * @author michiel
 */
public interface PrimerFilter {

    /**
     * checks the given primer.
     *
     * @param primer the primer
     * @return primerOK
     */
    boolean isOK(Primer primer);

    /**
     * returns this filter name.
     *
     * @return name
     */
    String getName();
}
