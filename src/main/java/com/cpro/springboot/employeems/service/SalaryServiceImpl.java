package com.cpro.springboot.employeems.service;

import com.cpro.springboot.employeems.model.Salary;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final Salary salary = new Salary();

    @Override
    public double getSalaryForDesignation(String designation) {
        return salary.getSalaryForDesignation(designation);
    }
}
