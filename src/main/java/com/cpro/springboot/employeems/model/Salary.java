package com.cpro.springboot.employeems.model;

public class Salary {

    private static final double JUNIOR_SALARY = 40000;
    private static final double SENIOR_SALARY = 70000;
    private static final double MANAGER_SALARY = 100000;

    public double getSalaryForDesignation(String designation) {
        switch (designation.toLowerCase()) {
            case "junior":
                return JUNIOR_SALARY;
            case "senior":
                return SENIOR_SALARY;
            case "manager":
                return MANAGER_SALARY;
            default:
                return 0;
        }
    }
}