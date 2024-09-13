package demos.advanced.oop_basics.javabasics;

import java.time.LocalDate;

/**
 * Creation date: Jun 13, 2017
 *
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public abstract class Employee {
    public static final int RETIREMENT_AGE = 68;
    private int employeeId;
    private Address address;
    private String name;
    private double salary;
    private LocalDate birthday;
//    private CommissionType commissionType = CommissionType.PERMANENT;

    public Employee(int employeeId, Address address, String name) {
        this.employeeId = employeeId;
        this.address = address;
        this.name = name;
    }

//    public CommissionType getCommissionType() {
//        return commissionType;
//    }
//
//    public void setCommissionType(CommissionType commissionType) {
//        this.commissionType = commissionType;
//    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (null == birthday) {
            throw new IllegalArgumentException("birthday can not be null");
        }
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("birthday can not be in the future");
        }
        this.birthday = birthday;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract LocalDate getEndOfEmployment();

//    {
//        switch (this.commissionType) {
//            case FREELANCE:
//                return LocalDate.now();
//            case PERMANENT:
//                return getRetirementDate();
//            case TEMPORARY:
//                return LocalDate.now();
//            default:
//                throw new IllegalStateException("unknown constant:" + commissionType);
//        }
//    }

    public LocalDate getRetirementDate() {
        if (null == this.getBirthday()) {
            throw new IllegalStateException("birthday should not be null");
        }
        return this.getBirthday().plusYears(RETIREMENT_AGE);
    }
}
