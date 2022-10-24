package org.hammerit.timeguard.services;

import org.hammerit.timeguard.entities.Department;
import org.hammerit.timeguard.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll(Sort.by("departmentId"));
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Department findById(Long departmentId) {
        return departmentRepository.getById(departmentId);
    }
}
