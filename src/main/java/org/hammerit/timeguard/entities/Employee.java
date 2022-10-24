package org.hammerit.timeguard.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "person")
    private String person;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department departmentId;

    public Employee() {
    }

    public Employee(String person, String phoneNumber, Department department) {
        this.person = person;
        this.phoneNumber = phoneNumber;
        this.departmentId = department;
    }

    public Employee(String person, Department department) {
        this.person = person;
        this.departmentId = department;
    }

    public Employee(Long employeeId, String person, Department department) {
        this.employeeId = employeeId;
        this.person = person;
        this.departmentId = department;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department department) {
        this.departmentId = department;
    }
}
