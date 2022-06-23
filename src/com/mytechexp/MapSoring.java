package com.mytechexp;

import java.math.BigDecimal;
import java.util.*;

public class MapSoring {

    public static void main(String[] args) {
       Map<String,Integer> map=new HashMap<>();
       map.put("tt",55);
       map.put("aa",100);
       map.put("cc",1);
       map.put("bb",25);

       List<Map.Entry<String,Integer>> mapList=new ArrayList<>(map.entrySet());
       Comparator<Map.Entry<String,Integer>>keyComparator=(o1,o2)->o1.getKey().compareTo(o2.getKey());
       Collections.sort(mapList,keyComparator);
       for(Map.Entry<String,Integer> entry:mapList)
           System.out.println(entry.getKey()+":"+entry.getValue());
       System.out.println("*********************************************");
       map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("*********************************************");
        System.out.println("To Reverse");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        //To print the Employee in Ascending order
        System.out.println("Ensuring the Employee Object in Ascending order while inserting itself");

        Map<Employee,Integer> empTreemap=new TreeMap<>(((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())));

      empTreemap.put(new Employee("Sudeep", 7, "Dev", BigDecimal.valueOf(1000000), Arrays.asList("sudeep@gmail.com","sk@gmail.com")),5);
      empTreemap.put(new Employee("Shiji", 7, "Dev", BigDecimal.valueOf(80000), Arrays.asList("shiji@gmail.com","sk@gmail.com")),11);

      empTreemap.entrySet().stream().forEach((k)->System.out.println("Employee :"+k+"Value"));
    }
}
