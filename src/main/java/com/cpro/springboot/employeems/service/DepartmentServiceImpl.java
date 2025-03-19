package com.cpro.springboot.employeems.service;

import com.cpro.springboot.employeems.model.Department;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<String> getDepartments() {
        return Department.getDepartments();
    }
}
