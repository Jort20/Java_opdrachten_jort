package section6_design.part2_patterns.observer.clubs;

import section6_design.part2_patterns.filter.ClubMember;

public class ClubRegistration {

    public void register(ClubMember newMember) {
        //some parts of the club are interested in this new member -- let them know!
    }

    public void unsubscribe(ClubMember leavingMember) {
        //some parts of the club are interested in this leaving member -- let them know!
    }
}
