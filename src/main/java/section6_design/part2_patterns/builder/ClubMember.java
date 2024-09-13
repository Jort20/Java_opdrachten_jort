package section6_design.part2_patterns.builder;

import section5_adv_apis.part3_funct.fp_exercise.Address;

import java.util.List;

public class ClubMember {
    //required
    private String firstName;
    //required
    private String lastName;
    //required but may default to Address.DEFAULT_NO_ADDRESS
    private Address address;
    //required
    private Gender gender;
    //required, at least one sport should be provided
    private List<Sport> sports;

}
