package com.cpro.springboot.employeems.model;

import java.util.Arrays;
import java.util.List;

public class Department {

    private static final List<String> departments = Arrays.asList("HR", "Finance", "IT", "Marketing", "Sales");

    public static List<String> getDepartments() {
        return departments;
    }
}
