package com.mytechexp.puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr={1,2,5,7,8,9,10};
        Optional<Integer> first = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println("Second Largest is "+ (first.isPresent()?first.get():Optional.empty()));
        String [] input={"i","am","Sudeep","Krishnan"};
        var result = Arrays.stream(input).reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println("longest string is"+result);

        var join = String.join("-", input);
        System.out.println(join);
    }
}
