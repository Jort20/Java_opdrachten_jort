package demos.advanced.oop_basics.javabasics;

import demos.advanced.oop_basics.javabasics.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class EmployeeTest {
    private Employee permanentEmployee;
    private Employee freelanceEmployee;
    private Employee temporaryEmployee;

    @BeforeEach
    public void createEmployees() {
        Address address = new Address("Hoofdweg", 122);
        this.permanentEmployee = new PermanentEmployee(1111, address, "Dilbert");
        this.freelanceEmployee = new FreelanceEmployee(2222, address, "Dogbert");
        this.temporaryEmployee = new TemporaryEmployee(3333, address, "Dagobert");
    }


    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setBirthdayNull() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> permanentEmployee.setBirthday(null));
       //permanentEmployee.setBirthday(null);
    }

    @Test
    public void setBirthdayNormal() throws Exception {
        LocalDate birthday = LocalDate.of(1969, 1, 20);
        permanentEmployee.setBirthday(birthday);
        assertEquals(birthday, permanentEmployee.getBirthday());
    }

    @Test//(expected = java.lang.IllegalArgumentException.class)
    public void setBirthdayFuture() throws Exception {
        LocalDate birthday = LocalDate.of(2110, 1, 20);
        assertThrows(IllegalArgumentException.class, () ->permanentEmployee.setBirthday(birthday));
    }


    @Test//(expected = java.lang.IllegalStateException.class)
    public void getRetirementDateNobirthday() throws Exception {
        assertThrows(IllegalStateException.class, () -> permanentEmployee.getRetirementDate());
        //permanentEmployee.getRetirementDate();
    }

    @Test
    public void getRetirementDateNormal() throws Exception {
        LocalDate birthday = LocalDate.of(1969, 1, 20);
        permanentEmployee.setBirthday(birthday);
        LocalDate retirement = LocalDate.of(1969 + Employee.RETIREMENT_AGE, 1, 20);
        assertEquals(retirement, permanentEmployee.getRetirementDate());
    }

    @Test
    public void getRetirementDatePast() throws Exception {
        LocalDate birthday = LocalDate.of(1919, 1, 20);
        permanentEmployee.setBirthday(birthday);
        LocalDate retirement = LocalDate.of(1919 + Employee.RETIREMENT_AGE, 1, 20);
        assertEquals(retirement, permanentEmployee.getRetirementDate());
    }


    @Test
    public void getEndOfEmploymentFreelance() throws Exception {
        assertEquals(LocalDate.now(), freelanceEmployee.getEndOfEmployment());
    }

    @Test
    public void getEndOfEmploymentPermanent() throws Exception {
        LocalDate birthday = LocalDate.of(1969, 1, 20);
        permanentEmployee.setBirthday(birthday);
        LocalDate endOfEmployment = LocalDate.of(1969 + Employee.RETIREMENT_AGE, 1, 20);
        assertEquals(endOfEmployment, permanentEmployee.getEndOfEmployment());
    }

    @Test
    public void getEndOfEmploymentTemporary() throws Exception {
        assertEquals(LocalDate.now(), temporaryEmployee.getEndOfEmployment());
    }

}