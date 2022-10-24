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

@Controller
@RequestMapping
public class EmployeeController {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {this.departmentService = departmentService; }

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/add_employee")
    public String addFormEmployee(Model model) {
        Employee employee = new Employee();
        List<Department> departmentList= departmentService.getAllDepartments();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentList);
        return "add_employee";
    }
    @PostMapping("/add_employee")
    public String addEmployee(@ModelAttribute(value = "employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete_employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit_employee/{employee_id}")
    public String editFormEmployee(Model model, @PathVariable(value = "employee_id") Long employeeId) {
        Employee employee = employeeService.findById(employeeId);
        List<Department> departmentList= departmentService.getAllDepartments();
        model.addAttribute("departments", departmentList);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit_employee")
    public String editEmployee(@ModelAttribute(value = "employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
}
