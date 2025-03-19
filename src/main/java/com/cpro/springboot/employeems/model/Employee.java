package com.cpro.springboot.employeems.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class Employee {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Designation is required")
    private String designation;

    private double salary;

    // Employment Type
    private boolean fullTime;

    // Multiple department selection
    private List<String> departments;

    public Employee() {
    }

    // Getter and Setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
