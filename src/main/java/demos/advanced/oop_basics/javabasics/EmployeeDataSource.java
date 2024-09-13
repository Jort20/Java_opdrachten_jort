package demos.advanced.oop_basics.javabasics;

/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public interface EmployeeDataSource {
    Employee getEmployee(int employeeId);

    void storeEmployee(Employee employee);
}
