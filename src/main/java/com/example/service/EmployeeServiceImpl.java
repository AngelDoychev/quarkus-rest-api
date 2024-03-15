package com.example.service;

import com.example.model.dto.EmployeeRequest;
import com.example.model.entity.Employee;
import com.example.repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    EmployeeRepository employeeRepository;

    @Transactional
    public void create(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setAge(request.age());
        employee.setSalary(request.salary());
        this.employeeRepository.persist(employee);
    }

    public Employee getById(long id) {
        return this.employeeRepository.findByIdOptional(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id: " + id + " does not exist."));
    }

    public List<Employee> getAll() {
        return this.employeeRepository.listAll();
    }

    @Transactional
    public void update(Long id, EmployeeRequest request) {
        this.employeeRepository.findByIdOptional(id)
                .ifPresent(person -> {
                    person.setName(request.name());
                    person.setAge(request.age());
                    person.setSalary(request.salary());
                    this.employeeRepository.persist(person);
                });
    }

    @Transactional
    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
