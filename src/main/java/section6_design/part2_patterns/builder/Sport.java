package section6_design.part2_patterns.builder;

public enum Sport {
    INDOOR_SOCCER(6),
    INDOOR_HOCKEY(6),
    TENNIS(4),
    VOLLEYBALL(8);

    private final int maxTeamSize;

    Sport(int maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }
}
