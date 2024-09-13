package demos.advanced.oop_basics.javabasics;

import java.time.LocalDate;

/**
 * Creation date: Jun 15, 2017
 *
 * @version 0.01
 * @autor Michiel Noback (&copy; 2017)
 */
public class PermanentEmployee extends Employee {
    public PermanentEmployee(int employeeId, Address address, String name) {
        super(employeeId, address, name);
    }

    @Override
    public LocalDate getEndOfEmployment() {
        return getRetirementDate();
    }

}
