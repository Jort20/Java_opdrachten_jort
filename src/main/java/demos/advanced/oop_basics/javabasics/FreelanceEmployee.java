package demos.advanced.oop_basics.javabasics;

import java.time.LocalDate;

/**
 * Creation date: Jun 15, 2017
 *
 * @version 0.01
 * @autor Michiel Noback (&copy; 2017)
 */
public class FreelanceEmployee extends Employee {
    public FreelanceEmployee(int employeeId, Address address, String name) {
        super(employeeId, address, name);
    }

    @Override
    public LocalDate getEndOfEmployment() {
        return LocalDate.now();
    }
}
