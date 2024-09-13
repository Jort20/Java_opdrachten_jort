package section6_design.part2_patterns.observer.clubs;

import section6_design.part2_patterns.builder.Sport;
import section6_design.part2_patterns.filter.ClubMember;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Sport sport;
    private List<ClubMember> members = new ArrayList<>();

    public Team(Sport sport) {
        this.sport = sport;
    }

    public void addMember(ClubMember newTeamMate) {
        if (this.members.size() == this.sport.getMaxTeamSize()) {
            throw new IllegalArgumentException("Maximum team size reached. You should probably create a new team");
        }
    }
    //for you to implement this logic

}
