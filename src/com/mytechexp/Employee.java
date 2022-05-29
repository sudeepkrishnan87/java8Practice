package com.mytechexp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Employee {
    public Employee(String name, int id, String department, BigDecimal salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        Salary = salary;
    }

    private String name;
    int id;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                ", Salary=" + Salary +
                ", email=" + email +
                '}';
    }

    String department;
    BigDecimal Salary;

    public Employee(String name, int id, String department, BigDecimal salary, List<String> email) {
        this.name = name;
        this.id = id;
        this.department = department;
        Salary = salary;
        this.email = email;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    List<String> email;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getName().equals(employee.getName()) && getDepartment().equals(employee.getDepartment()) && getSalary().equals(employee.getSalary()) && email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getDepartment(), getSalary(), email);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        Salary = salary;
    }

}