package org.hammerit.timeguard.services;

import org.hammerit.timeguard.entities.Employee;
import org.hammerit.timeguard.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by("employeeId"));
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee findById(Long employeeId) {
        return employeeRepository.getById(employeeId);
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter((employee) -> employee.getDepartmentId().getDepartmentId() == departmentId).collect(Collectors.toList());
    }
}
