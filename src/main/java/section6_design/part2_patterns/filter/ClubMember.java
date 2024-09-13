package section6_design.part2_patterns.filter;

import section6_design.part2_patterns.builder.Gender;
import section6_design.part2_patterns.builder.Sport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubMember {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int yearOfBirth;
    private List<Sport> sports;

    public ClubMember(String firstName, String lastName, Gender gender, int yearOfBirth) {
        this(firstName, lastName, gender, yearOfBirth, new ArrayList<>());
    }

    public ClubMember(String firstName, String lastName, Gender gender, int yearOfBirth, List<Sport> sports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.sports = sports;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public List<Sport> getSports() {
        return Collections.unmodifiableList(sports);
    }

    public void addSport(Sport sport) {
        this.sports.add(sport);
    }

    public static List<ClubMember> getAllMembers() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}