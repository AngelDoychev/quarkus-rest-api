package com.example.service;

import com.example.model.dto.EmployeeRequest;
import com.example.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void create(EmployeeRequest request);
    public Employee getById(long id);
    public List<Employee> getAll();
    public void update(Long id, EmployeeRequest request);
    public void delete(Long id);
}
