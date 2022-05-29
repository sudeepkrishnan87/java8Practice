package com.mytechexp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreams {
    public static void main(String[] args) {
        List<Employee> empStream = Stream.of(new Employee("Sudeep", 7, "Dev", BigDecimal.valueOf(1000000), Arrays.asList("sudeep@gmail.com","sk@gmail.com")),
                new Employee("Shiji", 9, "Dev", BigDecimal.valueOf(100000),Arrays.asList("shiji@gmail.com")),
                new Employee("Sanju", 8, "Test", BigDecimal.valueOf(90000),Arrays.asList("Sanju@gmail.com")),
                new Employee("Gopal", 6, "Retried", BigDecimal.valueOf(80000),Arrays.asList("gopal@gmail.com","gk@gmail.com"))).collect(Collectors.toList());
        //To Collect All employee Names
        System.out.println("**************************************************************");
        System.out.println("To Collect All employee Names");

        empStream.stream().map(Employee::getName).forEach(e -> System.out.println(e));
        //To Print Name of Salary whose Salary is greater than 80000
        System.out.println("**************************************************************");
        System.out.println("Print Name of Salary whose Salary is greater than 80000");
        Predicate<Employee> salaryPredicate = employee -> employee.getSalary().compareTo(BigDecimal.valueOf(80000)) > 0;
        empStream.stream().filter(salaryPredicate).forEach(e -> System.out.println(e.getName()));
        //Get email-id of all employees
        System.out.println("**************************************************************");
        System.out.println("Get email-id of all employees");
        empStream.stream().flatMap(employee -> employee.getEmail().stream()).forEach(System.out::println);
        //Group by department
        System.out.println("**************************************************************");
        System.out.println("Group by department");
        empStream.stream().collect(Collectors.groupingBy(emp->emp.department)).forEach((k,v)->System.out.println(k+"->"+v));
        System.out.println("**************************************************************");
        System.out.println("Group by department and return number of employees");
        empStream.stream().collect(Collectors.groupingBy(emp->emp.department,Collectors.counting())).forEach((k,v)->System.out.println(k+"->"+v));


        //Comparator
        //Sorting Purpose
        System.out.println("**************************************************************");
        System.out.println("Sorting Purpose");
        Comparator<Employee> idComparator=Comparator.comparing(employee -> employee.getId());
        empStream.stream().sorted(idComparator).forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Sorting Reverse");
        Comparator<Employee> idReverse= Collections.reverseOrder(idComparator);
        empStream.stream().sorted(idReverse).forEach(System.out::println);

        // Grouping and comparator
        //To get highest Salary guy from each Department
        System.out.println("**************************************************************");
        System.out.println("To get highest Salary guy from each Department");
        Comparator<Employee>salaryComparator=Comparator.comparing(Employee::getSalary);
        empStream.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.reducing(BinaryOperator.maxBy(salaryComparator)))).
                forEach((k,v)->System.out.println(k+"->"+v));
    }
}
