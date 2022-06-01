package com.mytechexp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSorting {
    public static void main(String[] args) {
        Integer arr[]={6,5,7,8,9,1};
        Arrays.stream(arr).sorted().forEach(System.out::println);
        Arrays.stream(arr).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> empStream = Stream.of(new Employee("Sudeep", 7, "Dev", BigDecimal.valueOf(1000000), Arrays.asList("sudeep@gmail.com","sk@gmail.com")),
                new Employee("Shiji", 9, "Dev", BigDecimal.valueOf(100000),Arrays.asList("shiji@gmail.com")),
                new Employee("Sanju", 8, "Test", BigDecimal.valueOf(80000),Arrays.asList("Sanju@gmail.com")),
                new Employee("Gopal", 6, "Retried", BigDecimal.valueOf(80000),Arrays.asList("gopal@gmail.com","gk@gmail.com"))).collect(Collectors.toList());


        Comparator<Employee>salaryComparator=(o1,o2)->o1.getSalary().compareTo(o2.getSalary());
        Comparator<Employee>nameComparator=(o1,o2)->o1.getName().compareTo(o2.getName());
        empStream.stream().sorted(salaryComparator.thenComparing(nameComparator)).forEach(System.out::println);
       //Easy way of Doing
        System.out.println("Easy Way");
        System.out.println("************************************************************");
        empStream.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(e->e.getName())).forEach(System.out::println);
    }


}
