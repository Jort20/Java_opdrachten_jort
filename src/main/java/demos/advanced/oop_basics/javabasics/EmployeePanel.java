package demos.advanced.oop_basics.javabasics;

import javax.swing.*;

/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class EmployeePanel extends JPanel {
    private final EmployeeDataSource dataSource;

    public EmployeePanel(EmployeeDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void showEmployee(int employeeId) {
        Employee emp = dataSource.getEmployee(employeeId);

        //GUI logic follows
    }
}
