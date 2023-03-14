package com.mytechexp.puzzles;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateOccurance {
    public static void main(String[] args) {
        String input="Sudeepkrishnan";
        List<String> result = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(key -> key.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(result);

        //to find unique elements
        List<String> unique = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(key -> key.getValue() == 1)
                .map(key -> key.getKey())
                .collect(Collectors.toList());
        System.out.println("Output for unique"+unique.toString());


        //first non repeat character

        String firstOccurance = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(key -> key.getValue() == 1)
                .findFirst().get().getKey();

        System.out.println("First occurance:"+firstOccurance);
    }
}
