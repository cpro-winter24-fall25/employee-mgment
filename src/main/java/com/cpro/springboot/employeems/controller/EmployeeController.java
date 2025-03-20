package com.cpro.springboot.employeems.controller;

import com.cpro.springboot.employeems.model.Employee;
import com.cpro.springboot.employeems.model.Salary;
import com.cpro.springboot.employeems.service.SalaryService;
import com.cpro.springboot.employeems.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;

@Controller
public class EmployeeController {

    private final SalaryService salaryService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(SalaryService salaryService, DepartmentService departmentService) {
        this.salaryService = salaryService;
        this.departmentService = departmentService;
    }

    // Display the employee form
    @GetMapping("/employee-form")
    public String showForm(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        theModel.addAttribute("departments", departmentService.getDepartments());
        theModel.addAttribute("JUNIOR_SALARY", Salary.JUNIOR_SALARY);
        theModel.addAttribute("SENIOR_SALARY", Salary.SENIOR_SALARY);
        theModel.addAttribute("MANAGER_SALARY", Salary.MANAGER_SALARY);
        return "employee-form";
    }

    // Handle form submission and validate the data
    @PostMapping("/submit-employee")
    public String submitEmployee(@Valid @ModelAttribute("employee") Employee theEmployee,
                                 BindingResult theBindingResult, Model theModel) {

        if (theBindingResult.hasErrors()) {
            theModel.addAttribute("departments", departmentService.getDepartments());
            theModel.addAttribute("JUNIOR_SALARY", Salary.JUNIOR_SALARY);
            theModel.addAttribute("SENIOR_SALARY", Salary.SENIOR_SALARY);
            theModel.addAttribute("MANAGER_SALARY", Salary.MANAGER_SALARY);
            return "employee-form";
        }

        // Set the salary based on the selected designation
        double salary = salaryService.getSalaryForDesignation(theEmployee.getDesignation());
        theEmployee.setSalary(salary);

        theModel.addAttribute("employee", theEmployee);
        return "employee-success";
    }
}
