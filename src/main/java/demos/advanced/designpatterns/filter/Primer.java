package demos.advanced.designpatterns.filter;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Primer {
    private static double defaultSaltMolarity = 0.05;
    private String sequence;
    private String name;
    private HashMap<Character, Integer> baseCounts;

    public Primer(String sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

    public Primer(String sequence) {
        this(sequence, "UNNAMED");
    }

    public String getSequence() {
        return sequence;
    }

    public String getName() {
        return name;
    }

    public int length() {
        return this.sequence.length();
    }

    public double getGCcontent() {
        double perc = (double) (getBaseCountsMap().get('G') + getBaseCountsMap().get('C')) / sequence.length();
        return perc;
    }

    private HashMap<Character, Integer> getBaseCountsMap() {
        if (baseCounts == null) {
            baseCounts = new HashMap<Character, Integer>();
        } else {
            return baseCounts;
        }
        baseCounts.put('A', 0);
        baseCounts.put('C', 0);
        baseCounts.put('G', 0);
        baseCounts.put('T', 0);
        baseCounts.put('O', 0);
        for (Character c : this.sequence.toUpperCase().toCharArray()) {
            try{
                baseCounts.put(c, baseCounts.get(c) + 1);
            } catch (NullPointerException e) {
                System.out.println("Unknown base found: " + c);
            }
        }
        return baseCounts;
    }

    public double getMolecularWeight() {
        HashMap<Character, Integer> baseCountsLocal = getBaseCountsMap();
        if (baseCountsLocal.get('O') != 0) {
            throw new UnsupportedOperationException("Ambiguous bases not supported yet");
        }
        double mw = baseCountsLocal.get('G') * 329.21;
        mw += baseCountsLocal.get('A') * 313.21;
        mw += baseCountsLocal.get('T') * 304.2;
        mw += baseCountsLocal.get('C') * 289.18;
        mw -= 61.96;
        return mw;
    }

    /**
     * Commonly used formula takes into account the molarSalt concentration of
     * the reaction: Tm = 81.5C + 7.21C x Math.log(molarSalt) + (0.41 x GC) -
     * (675 / primer length)
     * @return Tm the melting point
     */
    public int getMeltingPoint() {
        HashMap<Character, Integer> baseCountsLocal = getBaseCountsMap();
        if (baseCountsLocal.get('O') != 0) {
            throw new UnsupportedOperationException("Ambiguous bases not supported yet");
        }
        double pGC = ((double) (baseCountsLocal.get('G') + baseCountsLocal.get('C')) / length()) * 100;
        return (int) Math.round(81.5 + 7.21 * Math.log(defaultSaltMolarity) + (0.41 * pGC) - (675 / length()));
    }

    public boolean hasBaseRun(int maxRunLength) {
        char[] nucs = {'G', 'A', 'T', 'C'};
        for (char nuc : nucs) {
            Pattern p = Pattern.compile(nuc + "{" + maxRunLength + "}");
            Matcher m = p.matcher(this.sequence.toUpperCase());
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDinucleotideBaseRun(int maxRunLength) {
        String[] dinucs = {"GA", "GT", "GC", "AG", "AT", "AC", "TG", "TA", "TC", "CG", "CA", "CT"};
        for (String dinuc : dinucs) {
            Pattern p = Pattern.compile("(" + dinuc + ")" + "{" + maxRunLength + "}");

            Matcher m = p.matcher(this.sequence.toUpperCase());
            if (m.find()) {
                return true;
            }
        }
        return false;
    }

    /**
     * returns the count of G+C nucleotides in the last 3' terminal nucleotides
     * (length indicated by desiredThreePrimeEndSize)
     * Also called 3'GC-clamp
     *
     * @param desiredThreePrimeEndSize
     * @return threePrimeGCcount
     */
    public int getThreePrimeGCcount(int desiredThreePrimeEndSize) {
        String threePrimeEnd;
        if (sequence.length() >= desiredThreePrimeEndSize) {
            threePrimeEnd = sequence.substring(sequence.length() - desiredThreePrimeEndSize, sequence.length());
        } else {
            threePrimeEnd = sequence;
        }

        Primer tpPrimer = new Primer(threePrimeEnd);
        tpPrimer.getBaseCountsMap();

        int gcCounts = tpPrimer.getBaseCountsMap().get('G') + tpPrimer.getBaseCountsMap().get('C');

        return gcCounts;
    }

    @Override
    public String toString() {
        return "> Primer" + name + '\n' + sequence  + '\n';
    }
}
