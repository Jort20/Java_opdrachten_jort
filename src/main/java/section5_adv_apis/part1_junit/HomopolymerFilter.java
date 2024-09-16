package section5_adv_apis.part1_junit;

public class HomopolymerFilter implements PrimerFilter {

    private static final int HOMOPOLYMER_THRESHOLD = 4;

    @Override
    public boolean isOK(Primer primer) {
        String sequence = primer.getSequence();
        int count = 1;

        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
                if (count >= HOMOPOLYMER_THRESHOLD) {
                    return false;
                }
            } else {
                count = 1;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Homopolymer Filter";
    }
}
