package org.hammerit.timeguard.controllers;


import org.hammerit.timeguard.entities.Department;
import org.hammerit.timeguard.entities.Employee;
import org.hammerit.timeguard.services.DepartmentService;
import org.hammerit.timeguard.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class DepartmentController {
    private DepartmentService departmentService;
    private EmployeeService employeeService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/departments")
    public String showDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments";
    }

    @GetMapping("/show_department/{department_id}")
    public String showOneDepartment(Model model, @PathVariable(value = "department_id") Long departmentId) {
        List<Employee> employeeList = employeeService.findByDepartmentId(departmentId);
        Department department = departmentService.findById(departmentId);
        model.addAttribute("employees", employeeList);
        model.addAttribute("department", department);
        return "one_department";
    }

    @GetMapping("/add_department")
    public String addFormDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "add_department";
    }
    @PostMapping("/add_department")
    public String addDepartment(@ModelAttribute(value = "department") Department department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/delete_department/{id}")
    public String deleteDepartment(@PathVariable(value = "id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "redirect:/departments";
    }

    @GetMapping("/edit_department/{departmentId}")
    public String editFormDepartment(Model model, @PathVariable(value = "departmentId") Long departmentId) {
        Department department = departmentService.findById(departmentId);
        model.addAttribute("department", department);
        return "edit_department";
    }

    @PostMapping("/edit_department")
    public String editDepartment(@ModelAttribute(value = "department") Department department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }
}
